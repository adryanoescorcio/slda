package Eventos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import ComponentGroupPlus.MaskFormatterGroup;
import ComponentGroupPlus.PainelTabela;
import ExceptionSLDA.erroNullRequisitoException;
import Forms.MainJFrame;
import Model.Ata;
import Model.AtaResultado;
import PrimaryKey.AtaPK;
import TablesModel.AtaTableModel;

/**
 * Classe responsavel pelos eventos do painelAta $$
 * 
 * @author Walysson Oliveira
 * @author Adryano Escorcio
 * @version 2.0
 * @extends EventoPadrão
 **/

public class EventosAta extends EventosPadrao {

	// OBJETO UTILIZADO NAS BUSCAS
	private Ata ataPesquisa = new Ata();

	private MainJFrame main;

	// TABELA
	protected PainelTabela table = new PainelTabela();
	protected JTable tabela = table.getTabela();
	protected List<Ata> lista = daoAta.getTodasAtas();
	protected AtaTableModel modeloAta = new AtaTableModel(lista);

	// Objeto Mask
	protected MaskFormatterGroup mask = new MaskFormatterGroup();

	// COMPONENTES NECESSÁRIOS
	protected JTextField tfTurma = new JTextField();
	protected JFormattedTextField ftAno = new JFormattedTextField(
			mask.getMascaraAno());
	protected JComboBox<String> comboTurno = comboGroup.getComboBoxTurno();
	protected JComboBox<String> comboEnsino = comboGroup
			.getComboBoxEnsinoFUNDAMENTAL();
	protected JComboBox<String> comboModalidade = comboGroup
			.getComboBoxEnsinoMF();

	protected AtaPK pk = new AtaPK(); // chave primaria da ata.

	/**
	 * Metodos que realiza a função de limpar os campos.
	 **/
	protected ActionListener onClickLimparCampos = new ActionListener() {
		@Override
		public void actionPerformed(final ActionEvent e) {
			limparCampos();
		}
	};

	/**
	 * Necessário verificar se houve alteração para poder atualiza a ata
	 * modificada.
	 **/
	protected ActionListener onClickAterarAta = new ActionListener() {

		@Override
		public void actionPerformed(final ActionEvent e) {
			ata = (Ata) getValoresDosCampos();

			if (!ata.toString().equals(ataPesquisa.toString())) {
				if (daoAta.save(ata)) {
					JOptionPane.showMessageDialog(null, SUCESSO);
					modeloAta.updateContato(ataPesquisa, ata);
					limparCampos();
				}
			} else {
				JOptionPane.showMessageDialog(null,
						Messages.getString("EventosAta.0"), Messages.getString("EventosAta.1"), //$NON-NLS-1$ //$NON-NLS-2$
						JOptionPane.WARNING_MESSAGE);
			}
		}
	};

	/**
	 * Metodo com a função de salvar e alterar uma caixa.
	 **/
	protected ActionListener onClickSalvarAta = new ActionListener() {

		@Override
		public void actionPerformed(final ActionEvent e) {
			ata = (Ata) getValoresDosCampos();
			pk.setCodigo(ata.getTurmaAta(), ata.getTurnoAta(), ata.getAnoAta()); // seta
																					// a
																					// chave

			try {
				daoAta.buscar(pk).getCodigoKEY(); // realiza a busca no banco de
													// dados
				throw new erroNullRequisitoException(
						Messages.getString("EventosAta.2"), Messages.getString("EventosAta.3")); //$NON-NLS-1$ //$NON-NLS-2$
			} catch (final NullPointerException exc) {

				// Tentar pegar os valores
				final String turma = ata.getTurmaAta();
				final String turno = ata.getTurnoAta();
				final String ano = ata.getAnoAta();

				// Verificar se os campos foram digitados
				if (turma.equals(Messages.getString("EventosAta.4")) || ano.equals(Messages.getString("EventosAta.5")) || turno.equals(Messages.getString("EventosAta.6"))) { //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
					JOptionPane.showMessageDialog(null,
							Messages.getString("EventosAta.7"), Messages.getString("EventosAta.8"), //$NON-NLS-1$ //$NON-NLS-2$
							JOptionPane.ERROR_MESSAGE);
				} else if (daoAta.save(ata)) {
					JOptionPane.showMessageDialog(null, SUCESSO);
					modeloAta.addContato(ata); // Insere a ata na tabela da tela
												// ATA.
					limparCampos();
				}
			}
		}
	};

	/***
	 * Metodo com a função de buscar um caixa
	 */
	protected ActionListener onClickBuscarAta = new ActionListener() {

		@Override
		public void actionPerformed(final ActionEvent e) {
			final String ano = tfLocalizar.getText().trim(); // pega o codigo
																// digitado pelo
																// cliente.

			try {
				final List<Ata> atas = daoAta.getAtasByYear(ano);
				modeloAta = new AtaTableModel(atas);
				tabela.setModel(modeloAta);

			} catch (final NullPointerException exc) {
				throw new erroNullRequisitoException(
						Messages.getString("EventosAta.9") + ano //$NON-NLS-1$
								+ Messages.getString("EventosAta.10"), Messages.getString("EventosAta.11")); //$NON-NLS-1$ //$NON-NLS-2$
			}
		}
	};

	protected ActionListener onClickInitInserir = new ActionListener() {

		@Override
		public void actionPerformed(final ActionEvent e) {
			try {
				final PlusEventoDiscenteAta disAta = new PlusEventoDiscenteAta(
						EventosAta.this);

				// verificar se tudo deu certo.
				if (disAta.onClickSalvarAtaResultado()) {
					main.direcionarParaCamada(0);
					main.atualizarTabelaAluno(aluno);
					main.limparAta();
				}
			} catch (final Exception ex) {
				JOptionPane
						.showMessageDialog(null,
								Messages.getString("EventosAta.12")); //$NON-NLS-1$
			}
		}
	};

	protected ActionListener onClickRetirarAtaResultado = new ActionListener() {

		@Override
		public void actionPerformed(final ActionEvent e) {
			final PlusEventoDiscenteAta disAta = new PlusEventoDiscenteAta(
					EventosAta.this);
			disAta.onClickRetirarAtaResultado();
			main.direcionarParaCamada(0);
			main.atualizarTabelaAluno(aluno);
		}
	};

	/**
	 * Metodo com a função de excluir uma caixa
	 **/
	protected ActionListener onClickExcluirAta = new ActionListener() {

		@Override
		public void actionPerformed(final ActionEvent e) {
			if (JOptionPane.showConfirmDialog(null, Messages.getString("EventosAta.13")) == 0) { //$NON-NLS-1$
				daoAta.remover(ataPesquisa);
				daoAtaResultado.excluirPorAta(ataPesquisa);
				JOptionPane
						.showMessageDialog(null, Messages.getString("EventosAta.14")); //$NON-NLS-1$
				modeloAta.removeContato(ataPesquisa);
				limparCampos();
			}
		}
	};

	protected ItemListener onClickChangeModalidade = new ItemListener() {
		@Override
		public void itemStateChanged(final ItemEvent ev) {
			// SE FUNDAMENTAL ESSE METODO RECONTRÓI O COMBO
			if (comboModalidade.getSelectedIndex() == 0) {
				comboEnsino.removeAllItems();
				comboEnsino.addItem(Messages.getString("EventosAta.15")); //$NON-NLS-1$
				comboEnsino.addItem(Messages.getString("EventosAta.16")); //$NON-NLS-1$
				comboEnsino.addItem(Messages.getString("EventosAta.17")); //$NON-NLS-1$
				comboEnsino.addItem(Messages.getString("EventosAta.18")); //$NON-NLS-1$
				comboEnsino.addItem(Messages.getString("EventosAta.19")); //$NON-NLS-1$

				// SE MEDIO ESSE METODO RECONTRÓI O COMBO
			} else if (comboModalidade.getSelectedIndex() == 1) {
				comboEnsino.removeAllItems();
				comboEnsino.addItem(Messages.getString("EventosAta.20")); //$NON-NLS-1$
				comboEnsino.addItem(Messages.getString("EventosAta.21")); //$NON-NLS-1$
				comboEnsino.addItem(Messages.getString("EventosAta.22")); //$NON-NLS-1$
				comboEnsino.addItem(Messages.getString("EventosAta.23")); //$NON-NLS-1$
			}
		}
	};

	protected MouseListener onClickRowTable = new MouseListener() {

		@Override
		public void mouseClicked(final MouseEvent e) {
			if (e.getClickCount() == 2) {
				final int linha = tabela.getSelectedRow();
				ataPesquisa = modeloAta.getContato(linha);
				setValoresDosCampos(ataPesquisa);

				if (aluno == null) {
					habilitarBotoes(true);
				} else {
					desabilitarTudoFormulario();
				}
			}
		}

		@Override
		public void mouseEntered(final MouseEvent e) {
		}

		@Override
		public void mouseExited(final MouseEvent e) {
		}

		@Override
		public void mousePressed(final MouseEvent e) {
		}

		@Override
		public void mouseReleased(final MouseEvent e) {
		}
	};

	public EventosAta(final MainJFrame main) {
		this.main = main;
		btnAlterar.setEnabled(false); // necessario a pesquisa para ativar botão
		btnExcluir.setEnabled(false); // necessario a pesquisa para ativar botão
	}

	protected void desabilitarTudoFormulario() {
		tfTurma.setEditable(false); // nao sera possivel alterar o codigo de
									// objeto consultado.
		ftAno.setEditable(false); // nao sera possivel alterar o codigo de
									// objeto consultado.
		comboTurno.setEnabled(false);
		comboModalidade.setEnabled(false);
		comboEnsino.setEnabled(false);
	}

	public MainJFrame getMain() {
		return main;
	}

	@Override
	public Object getValoresDosCampos() {
		ata = new Ata();
		ata.setCodigo((String) comboTurno.getSelectedItem(), tfTurma.getText(),
				(mask.verificarMascara(ftAno)).trim());
		ata.setModalidadeAta((String) comboModalidade.getSelectedItem());
		ata.setEnsinoAta((String) comboEnsino.getSelectedItem());

		return ata;
	}

	// METODO PARA HABILITAR OU DESABILITAR OS BOTOES QUE INICIAM Enabled E
	// TAMBÉM OUTROS COMPONENTES NECESSÁRIOS
	public void habilitarBotoes(final boolean bool) {

		btnAlterar.setEnabled(bool);
		btnExcluir.setEnabled(bool);
		btnSalvar.setEnabled(!bool);
		tfTurma.setEditable(!bool);
		ftAno.setEditable(!bool);
		comboTurno.setEnabled(!bool);
	}

	@Override
	public void limparCampos() {

		tfTurma.setText(Messages.getString("EventosAta.24")); //$NON-NLS-1$
		ftAno.setText(Messages.getString("EventosAta.25")); //$NON-NLS-1$
		aluno = null;
		ata = null;
		tfDiscente.setText(Messages.getString("EventosAta.26")); //$NON-NLS-1$
		comboTurno.setSelectedIndex(0);
		comboModalidade.setSelectedIndex(0);
		comboEnsino.setSelectedIndex(0);

		// RESCONTRÓI A TABELA CASO ELA TENHA SIDO REDUZIDA NA BUSCA
		lista = daoAta.getTodasAtas();
		modeloAta = new AtaTableModel(lista);
		tabela.setModel(modeloAta);

		setMudarPerfil(false);
		habilitarBotoes(false);

	}

	public void setAta(final AtaResultado ataR) {
		ata = ataR.getAta();
		setValoresDosCampos(ata);
	}

	public void setMain(final MainJFrame main) {
		this.main = main;
	}

	public void setMudarPerfil(final boolean bool) {
		btnSalvar.setEnabled(!bool);
		btnAlterar.setEnabled(!bool);
		btnExcluir.setEnabled(!bool);

		btnRetirar.setEnabled(bool);
		btnInserir.setEnabled(bool);

		tfTurma.setEditable(!bool);
		ftAno.setEditable(!bool);

		comboEnsino.setEnabled(!bool);
		comboModalidade.setEnabled(!bool);
		comboTurno.setEnabled(!bool);

	}

	@Override
	public void setValoresDosCampos(final Object objeto) {
		ata = (Ata) objeto;

		tfTurma.setText(ata.getTurmaAta());
		comboTurno.setSelectedItem(ata.getTurnoAta());
		ftAno.setText(ata.getAnoAta());
		comboModalidade.setSelectedItem(ata.getModalidadeAta());
		comboEnsino.setSelectedItem(ata.getEnsinoAta());
	}

}
