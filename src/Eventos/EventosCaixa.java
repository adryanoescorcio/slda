package Eventos;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import ComponentGroupPlus.PainelTabela;
import ExceptionSLDA.erroNullRequisitoException;
import Forms.MainJFrame;
import Model.Arquivo;
import Model.Caixa;
import PrimaryKey.CaixaPK;
import TablesModel.CaixaTableModel;

/**
 * Classe responsavel pelos eventos do painelCaixa $$
 * 
 * @author Walysson Oliveira
 * @author Adryano Escorcio
 * @version 2.0
 * @extends EventoPadrão
 **/

public class EventosCaixa extends EventosPadrao {

	// PEQUENA CLASSE DE COMPARAÇÃO UTILIZADA NA ORDENAÇÃO DA LISTA
	public static class ComparadorObjetos implements Comparator<Caixa> {

		@Override
		public int compare(final Caixa objetoParaComparar,
				final Caixa objetoAserComparado) {
			return objetoParaComparar.getCodigo().compareTo(
					objetoAserComparado.getCodigo());
		}
	}

	// OBJETO UTILIZADO NAS BUSCAS
	Caixa caixaPesquisa = new Caixa();

	// COMPARADOR DE OBJETOS PARA ORDENAR O ARRAY
	ComparadorObjetos comparador = new ComparadorObjetos();
	// TABELA
	PainelTabela table = new PainelTabela();
	protected JTable tabela = table.getTabela();
	protected List<Caixa> lista = daoCaixa.getTodasCaixas();
	protected CaixaTableModel modelo;

	protected String strCodigo;
	// COMPONENTES NECESSÁRIOS
	protected JTextField tfCodigo = new JTextField();
	protected JComboBox<String> comboTurno = comboGroup.getComboBoxTurno();
	protected JComboBox<String> comboLetra = comboGroup.getComboBoxLetra();
	protected JComboBox<String> comboStatus = comboGroup.getComboBoxStatus();
	protected JComboBox<String> comboNumero = comboGroup.getComboBoxNumero();
	protected JComboBox<String> comboModalidade = comboGroup
			.getComboBoxEnsinoMF();

	protected JComboBox<String> comboEnsino = comboGroup
			.getComboBoxEnsinoFUNDAMENTAL();

	protected MainJFrame main;

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
	 * Necessário verificar se houve alteração para poder atualiza a caixa
	 * modificada.
	 **/
	protected ActionListener onClickAlterarCaixa = new ActionListener() {

		@Override
		public void actionPerformed(final ActionEvent e) {
			caixa = (Caixa) getValoresDosCampos();

			if (!caixa.toString().equals(caixaPesquisa.toString())) {
				if (daoCaixa.save(caixa)) {
					JOptionPane.showMessageDialog(null, SUCESSO);
					modelo.updateContato(caixaPesquisa, caixa);
					limparCampos();
				}
			} else {
				JOptionPane.showMessageDialog(null,
						Messages.getString("EventosCaixa.0"), Messages.getString("EventosCaixa.1"), //$NON-NLS-1$ //$NON-NLS-2$
						JOptionPane.WARNING_MESSAGE);
			}
		}
	};

	protected ItemListener onClickChangeModalidade = new ItemListener() {
		@Override
		public void itemStateChanged(final ItemEvent ev) {
			// SE FUNDAMENTAL ESSE METODO RECONTRÓI O COMBO
			if (comboModalidade.getSelectedIndex() == 0) {
				comboEnsino.removeAllItems();
				comboEnsino.addItem(Messages.getString("EventosCaixa.2")); //$NON-NLS-1$
				comboEnsino.addItem(Messages.getString("EventosCaixa.3")); //$NON-NLS-1$
				comboEnsino.addItem(Messages.getString("EventosCaixa.4")); //$NON-NLS-1$
				comboEnsino.addItem(Messages.getString("EventosCaixa.5")); //$NON-NLS-1$
				comboEnsino.addItem(Messages.getString("EventosCaixa.6")); //$NON-NLS-1$

				// SE MEDIO ESSE METODO RECONTRÓI O COMBO
			} else if (comboModalidade.getSelectedIndex() == 1) {
				comboEnsino.removeAllItems();
				comboEnsino.addItem(Messages.getString("EventosCaixa.7")); //$NON-NLS-1$
				comboEnsino.addItem(Messages.getString("EventosCaixa.8")); //$NON-NLS-1$
				comboEnsino.addItem(Messages.getString("EventosCaixa.9")); //$NON-NLS-1$
				comboEnsino.addItem(Messages.getString("EventosCaixa.10")); //$NON-NLS-1$
			}
		}
	};

	/**
	 * Metodo com a função de salvar e alterar uma caixa.
	 **/
	protected ActionListener onClickSalvarCaixa = new ActionListener() {

		@Override
		public void actionPerformed(final ActionEvent e) {

			try {
				caixa = (Caixa) getValoresDosCampos();

				int num = 1;
				final String codCaixaTMP = ((String) comboLetra
						.getSelectedItem())
						+ Messages.getString("EventosCaixa.11") //$NON-NLS-1$
						+ ((String) comboTurno.getSelectedItem()).substring(0,
								1)
						+ ((String) comboModalidade.getSelectedItem())
								.substring(0, 1)
						+ ((String) comboEnsino.getSelectedItem()).substring(0,
								1) + Messages.getString("EventosCaixa.12"); //$NON-NLS-1$

				String codCaixa = ((String) comboLetra.getSelectedItem())
						+ Messages.getString("EventosCaixa.13") //$NON-NLS-1$
						+ ((String) comboTurno.getSelectedItem()).substring(0,
								1)
						+ ((String) comboModalidade.getSelectedItem())
								.substring(0, 1)
						+ ((String) comboEnsino.getSelectedItem()).substring(0,
								1) + Messages.getString("EventosCaixa.14") + String.valueOf(num); //$NON-NLS-1$

				caixa.setCodigo(codCaixa);

				boolean boo = true;
				while (boo) {
					final CaixaPK pk = new CaixaPK();
					pk.setCodigo(codCaixa);
					final Caixa cx = daoCaixa.buscar(pk);

					if (cx == null) {
						boo = false;
					} else {
						num = num + 1;
						final String strNum = String.valueOf(num);
						codCaixa = codCaixaTMP.concat(strNum);
						caixa.setCodigo(codCaixa);
					}
				}

				if (daoCaixa.save(caixa)) {
					JOptionPane.showMessageDialog(null, SUCESSO);
					lista.add(caixa);
					// ORDENA A LISTA
					Collections.sort(lista, comparador);
					// RECRIA A TABELA
					modelo = new CaixaTableModel(lista);
					tabela.setModel(modelo);
					mostarDadoSalvo(caixa);
				}

			} catch (final Exception ex) {
				System.out.println(Messages.getString("EventosCaixa.15")); //$NON-NLS-1$
			}
		}
	};

	/***
	 * Metodo com a função de buscar um caixa
	 */
	protected ActionListener onClickBuscarCaixa = new ActionListener() {

		@Override
		public void actionPerformed(final ActionEvent e) {

			final String codigoLocalizar = tfLocalizar.getText().trim()
					.toUpperCase(); // pega o codigo digitado pelo cliente.

			final CaixaPK pk = new CaixaPK(); // chave primaria da caixa.
			pk.setCodigo(codigoLocalizar); // seta a chave

			try {
				caixaPesquisa = daoCaixa.buscar(pk); // realiza a busca no banco
														// de dados
				setValoresDosCampos(caixaPesquisa); // atribui os valores
													// recuperados para os
													// campos.
				habilitarBotoes(true);
				desabilitarCamposPesquisa();

			} catch (final NullPointerException exc) {
				JOptionPane.showMessageDialog(null, Messages.getString("EventosCaixa.16") //$NON-NLS-1$
						+ codigoLocalizar + Messages.getString("EventosCaixa.17")); //$NON-NLS-1$
			}
		}
	};

	/**
	 * Metodo com a função de excluir uma caixa
	 **/
	protected ActionListener onClickExcluirCaixa = new ActionListener() {

		@Override
		public void actionPerformed(final ActionEvent e) {

			if (JOptionPane.showConfirmDialog(null, Messages.getString("EventosCaixa.18")) == 0) { //$NON-NLS-1$
				daoCaixa.remover(caixaPesquisa);
				daoArquivo.excluirPorCaixa(caixaPesquisa);
				JOptionPane.showMessageDialog(null,
						Messages.getString("EventosCaixa.19")); //$NON-NLS-1$
				lista.remove(caixaPesquisa);
				Collections.sort(lista, comparador);

				modelo = new CaixaTableModel(lista);
				tabela.setModel(modelo);

				limparCampos();

				// LIMPA A CAIXA
				caixa = null;
			}
		}
	};

	protected ActionListener onClickInitInserir = new ActionListener() {

		@Override
		public void actionPerformed(final ActionEvent e) {
			try {
				final PlusEventoDiscenteArquivo disArquivo = new PlusEventoDiscenteArquivo(
						EventosCaixa.this);

				// verificar se tudo deu certo.
				if (disArquivo.onClickSalvarArquivo()) {
					main.direcionarParaCamada(0);
					main.limparCaixa();
				}
			} catch (final Exception ex) {
				JOptionPane
						.showMessageDialog(null,
								Messages.getString("EventosCaixa.20")); //$NON-NLS-1$
			}
		}
	};

	protected ActionListener onClickInitRetirar = new ActionListener() {

		@Override
		public void actionPerformed(final ActionEvent e) {
			try {
				final PlusEventoDiscenteArquivo disArquivo = new PlusEventoDiscenteArquivo(
						EventosCaixa.this);

				// verificar se tudo deu certo.
				if (disArquivo.onClickRetirarArquivo()) {
					main.direcionarParaCamada(0);
					main.atualizarCaixaAluno(aluno);
					main.limparCaixa();
				}
			} catch (final Exception ex) {
				JOptionPane
						.showMessageDialog(null,
								Messages.getString("EventosCaixa.21")); //$NON-NLS-1$
			}
		}
	};

	// OBJETO QUE REALIZA UMA BUSCA ATRAVÉS DAS LINHAS DA TABELA
	protected MouseListener onClickRowTable = new MouseListener() {

		@Override
		public void mouseClicked(final MouseEvent e) {
			if (e.getClickCount() == 2) {
				final int linha = tabela.getSelectedRow();
				caixaPesquisa = modelo.getContato(linha);
				setValoresDosCampos(caixaPesquisa);

				if (aluno == null) {
					habilitarBotoes(true);
					desabilitarCamposPesquisa();
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

	public EventosCaixa(final MainJFrame main) {
		this.main = main;
		// INICIA A TABELA ORDENADA
		Collections.sort(lista, comparador);
		modelo = new CaixaTableModel(lista);
		tfCodigo.setEditable(false);
		comboNumero.setEnabled(false);
	}

	protected void desabilitarCamposPesquisa() {
		comboTurno.setEnabled(false);
		comboLetra.setEnabled(false);
	}

	protected void desabilitarTudoFormulario() {
		comboTurno.setEnabled(false);
		comboLetra.setEnabled(false);
		comboStatus.setEditable(false);
		comboEnsino.setEditable(false);
		comboModalidade.setEditable(false);
		tfCodigo.setEditable(false);

		btnAlterar.setEnabled(false);
	}

	public Arquivo getArquivo() {

		if (!(((String) comboTurno.getSelectedItem()) == null)
				&& !(((String) comboLetra.getSelectedItem()) == null)) {

			arquivo = new Arquivo();
			arquivo.setCodigo(aluno.getCodigo(), tfCodigo.getText().trim());
			arquivo.setCodDossie((String) comboNumero.getSelectedItem());

			return arquivo;

		} else {
			return null;
		}
	}

	public Caixa getCaixa() {
		return caixa;
	}

	public MainJFrame getMain() {
		return main;
	}

	@Override
	public Object getValoresDosCampos() {

		if (!(((String) comboTurno.getSelectedItem()) == null)
				&& !(((String) comboLetra.getSelectedItem()) == null)) {

			caixa = new Caixa();
			caixa.setCodigo(tfCodigo.getText().trim());
			caixa.setTurno((String) comboTurno.getSelectedItem());
			caixa.setLetra((String) comboLetra.getSelectedItem());
			caixa.setStatus((String) comboStatus.getSelectedItem());
			caixa.setModalidadeAta((String) comboModalidade.getSelectedItem());
			caixa.setEnsinoAta((String) comboEnsino.getSelectedItem());

			return caixa;
		} else {
			throw new erroNullRequisitoException(
					Messages.getString("EventosCaixa.22"), //$NON-NLS-1$
					Messages.getString("EventosCaixa.23")); //$NON-NLS-1$
		}
	}

	// METODO PARA HABILITAR OU DESABILITAR OS BOTOES QUE INICIAM Enabled E
	// TAMBÉM OUTROS COMPONENTES NECESSÁRIOS
	public void habilitarBotoes(final boolean bool) {
		comboTurno.setEnabled(true);
		comboLetra.setEnabled(true);
		comboStatus.setEnabled(true);
		comboEnsino.setEnabled(false);
		comboModalidade.setEnabled(false);
		btnAlterar.setEnabled(bool);
		btnExcluir.setEnabled(bool);
		btnSalvar.setEnabled(!bool);
	}

	@Override
	public void limparCampos() {
		tfCodigo.setText(null);
		comboTurno.setSelectedIndex(0);
		comboLetra.setSelectedIndex(0);
		comboStatus.setSelectedIndex(0);
		comboNumero.setSelectedIndex(0);
		comboEnsino.setSelectedIndex(0);
		comboModalidade.setSelectedIndex(0);

		tfDiscente.setText(null);

		setMudarPerfil(false);
		habilitarBotoes(false);
	}

	protected void mostarDadoSalvo(final Caixa caixa) {
		setValoresDosCampos(caixa);
		comboLetra.setEnabled(false);
		comboTurno.setEnabled(false);
		comboStatus.setEnabled(false);
		comboEnsino.setEnabled(false);
		comboModalidade.setEnabled(false);
		comboLetra.setForeground(Color.BLACK);
		btnSalvar.setEnabled(false);
	}

	public Arquivo setArquivo(final Arquivo arquivo) {
		return this.arquivo = arquivo;
	}

	public void setMain(final MainJFrame main) {
		this.main = main;
	}

	public void setMudarPerfil(final boolean bool) {
		btnSalvar.setEnabled(!bool);
		btnAlterar.setEnabled(!bool);
		btnExcluir.setEnabled(!bool);

		comboNumero.setEnabled(bool);
		btnRetirar.setEnabled(bool);
		btnInserir.setEnabled(bool);

		comboLetra.setEnabled(!bool);
		comboStatus.setEnabled(!bool);
		comboTurno.setEnabled(!bool);
		comboEnsino.setEnabled(!bool);
		comboModalidade.setEnabled(!bool);
	}

	@Override
	public void setValoresDosCampos(final Object object)
			throws NullPointerException {
		final Caixa caixa = (Caixa) object;

		tfCodigo.setText(caixa.getCodigo());
		comboTurno.setSelectedItem(caixa.getTurno());
		comboLetra.setSelectedItem(caixa.getLetra());
		comboStatus.setSelectedItem(caixa.getStatus());
		comboEnsino.setSelectedItem(caixa.getEnsinoAta());
		comboModalidade.setSelectedItem(caixa.getModalidadeAta());

	}
}
