package Eventos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import ComponentGroupPlus.PainelTabela;
import ExceptionSLDA.erroNullRequisitoException;
import Forms.MainJFrame;
import Model.Caixa;
import Model.Documento;
import TablesModel.DocumentoTableModel;

/**
 * Classe responsavel pelos eventos do painelCaixa $$
 * 
 * @author Walysson Oliveira
 * @author Adryano Escorcio
 * @version 2.0
 * @extends EventoPadrão
 **/

public class PlusEventoDocumento extends EventosPadrao {

	// PEQUENA CLASSE DE COMPARAÇÃO UTILIZADA NA ORDENAÇÃO DA LISTA
	public static class ComparadorObjetos implements Comparator<Caixa> {

		@Override
		public int compare(final Caixa objetoParaComparar,
				final Caixa objetoAserComparado) {
			return objetoParaComparar.getCodigo().compareTo(
					objetoAserComparado.getCodigo());
		}
	}

	private static final int INTERVALO = 35;

	// OBJETO UTILIZADO NAS BUSCAS
	Documento DocPesquisa = new Documento();
	// TABELA
	PainelTabela table = new PainelTabela();
	protected JTable tabela = table.getTabela();
	protected List<Documento> lista;
	protected DocumentoTableModel modelo;

	protected String strCodigo;
	// COMPONENTES NECESSÁRIOS
	protected JTextField tfProtocolo = new JTextField();
	protected JTextField tfDocumento = new JTextField();
	protected JFormattedTextField ftDataPedido = new JFormattedTextField(
			mask.getMascaraData());
	protected JFormattedTextField ftDataEntrega = new JFormattedTextField(
			mask.getMascaraData());

	protected JComboBox<String> comboStatus = comboGroup
			.getComboBoxStatusDocumento();

	protected JTextArea taDescricao = new JTextArea();
	protected MainJFrame main;

	protected EventosAluno evento;

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
			documento = (Documento) getValoresDosCampos();

			if (!documento.toString().equals(DocPesquisa.toString())) {
				if (daoDoc.save(documento)) {
					JOptionPane.showMessageDialog(null, SUCESSO);
					modelo.updateContato(DocPesquisa, documento);
					limparCampos();
				}
			} else {
				JOptionPane.showMessageDialog(null,
						Messages.getString("PlusEventoDocumento.0"), Messages.getString("PlusEventoDocumento.1"), //$NON-NLS-1$ //$NON-NLS-2$
						JOptionPane.WARNING_MESSAGE);
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

				// gerando protocolo
				tfProtocolo.setText((String.valueOf(numAleatorio())
						+ stringRandon() + numAleatorio()));

				final Documento doc = (Documento) getValoresDosCampos();
				if (daoDoc.save(doc)) {
					JOptionPane.showMessageDialog(null, SUCESSO);
					modelo.addContato(doc);
					evento.modeloDoc.addContato(doc);
					desabilitarAll();
				} else {
					JOptionPane.showMessageDialog(null, ERROPROC);
				}

			} catch (final Exception ex) {
				System.out.println(Messages.getString("PlusEventoDocumento.2") + ex.getMessage()); //$NON-NLS-1$
			}
		}
	};

	protected ItemListener onClickChangeModalidade = new ItemListener() {
		@Override
		public void itemStateChanged(final ItemEvent ev) {
			if (comboStatus.getSelectedIndex() == 1) {
				ftDataEntrega.setText(dateToday());
			} else {
				ftDataEntrega.setText(null);
			}
		}
	};

	/**
	 * Metodo com a função de excluir uma caixa
	 **/
	protected ActionListener onClickExcluirCaixa = new ActionListener() {

		@Override
		public void actionPerformed(final ActionEvent e) {
			final Documento documentoSelect = (Documento) getValoresDosCampos();
			if (JOptionPane.showConfirmDialog(null,
					Messages.getString("PlusEventoDocumento.3")) == 0) { //$NON-NLS-1$
				daoDoc.remover(documentoSelect);
				JOptionPane.showMessageDialog(null,
						Messages.getString("PlusEventoDocumento.4")); //$NON-NLS-1$
				modelo.removeContato(documentoSelect);
				evento.modeloDoc.removeContato(documentoSelect);
				limparCampos();

				// LIMPA A CAIXA
				documento = null;
			}
		}
	};

	// OBJETO QUE REALIZA UMA BUSCA ATRAVÉS DAS LINHAS DA TABELA
	protected MouseListener onClickRowTable = new MouseListener() {

		@Override
		public void mouseClicked(final MouseEvent e) {
			if (e.getClickCount() == 2) {
				final int linha = tabela.getSelectedRow();

				DocPesquisa = modelo.getContato(linha);
				setValoresDosCampos(DocPesquisa);
				habilitarBotoes(true, 1);
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

	protected ActionListener onClickCancelarOperacao = new ActionListener() {
		@Override
		public void actionPerformed(final ActionEvent e) {
			main.normalizarCamadas();
		}
	};

	public PlusEventoDocumento(final MainJFrame main, final EventosAluno evento) {
		this.main = main;
		this.evento = evento;
		dataPedidoCampo();

		lista = daoDoc.buscarDocumentoporAluno(evento.aluno);
		modelo = new DocumentoTableModel(lista);
		tfProtocolo.setEditable(false);
	}

	public void atualizarAlunoTela() {
		tfDiscente.setText(evento.aluno.getNomeAluno());
	}

	private void dataPedidoCampo() {
		ftDataPedido.setText(dateToday());
	}

	private String dateToday() {

		final Date date = new Date();
		final SimpleDateFormat dateToday = new SimpleDateFormat(Messages.getString("PlusEventoDocumento.5")); //$NON-NLS-1$
		final String strDateToday = dateToday.format(date);

		return strDateToday;
	}

	protected void desabilitarAll() {
		btnSalvar.setEnabled(false);
		tfDocumento.setEditable(false);
		tfProtocolo.setEditable(false);
		comboStatus.setEnabled(false);
		taDescricao.setEditable(false);
		ftDataEntrega.setEditable(false);
		ftDataPedido.setEditable(false);
	}

	public Documento getCaixa() {
		return documento;
	}

	public MainJFrame getMain() {
		return main;
	}

	@Override
	public Object getValoresDosCampos() {

		if (!((ftDataPedido.getText()) == Messages.getString("PlusEventoDocumento.6"))) { //$NON-NLS-1$

			documento = new Documento();
			documento.setNomeDocumento(tfDocumento.getText());
			documento.setCodigo(tfProtocolo.getText().trim());
			documento.setAluno(evento.aluno);
			documento.setStatus((String) comboStatus.getSelectedItem());
			documento.setDataEntrega(ftDataEntrega.getText());
			documento.setDataPedido(ftDataPedido.getText());
			documento.setDescricao(taDescricao.getText().trim());

			return documento;

		} else {
			throw new erroNullRequisitoException(
					Messages.getString("PlusEventoDocumento.7"), //$NON-NLS-1$
					Messages.getString("PlusEventoDocumento.8")); //$NON-NLS-1$
		}
	}

	// METODO PARA HABILITAR OU DESABILITAR OS BOTOES QUE INICIAM Enabled E
	// TAMBÉM OUTROS COMPONENTES NECESSÁRIOS
	public void habilitarBotoes(final boolean bool, final int i) {

		if (i != 1) {
			tfDocumento.setEditable(!bool);
			comboStatus.setEnabled(!bool);
			ftDataEntrega.setEditable(!bool);
			ftDataPedido.setEditable(!bool);
			taDescricao.setEditable(!bool);
		}

		btnAlterar.setEnabled(bool);
		btnExcluir.setEnabled(bool);
		btnSalvar.setEnabled(!bool);
	}

	@Override
	public void limparCampos() {
		tfProtocolo.setText(null);
		tfDocumento.setText(null);
		ftDataEntrega.setText(null);
		ftDataPedido.setText(dateToday());
		comboStatus.setSelectedIndex(0);
		taDescricao.setText(null);

		habilitarBotoes(false, 0);
	}

	protected void mostarDadoSalvo(final Caixa caixa) {
		setValoresDosCampos(caixa);
		tfDocumento.setEnabled(false);
		ftDataEntrega.setEnabled(false);
		ftDataPedido.setEnabled(false);
		comboStatus.setEnabled(false);

		btnSalvar.setEnabled(false);
	}

	public int numAleatorio() {
		final Random rand = new Random();
		return rand.nextInt(INTERVALO);
	}

	public void setMain(final MainJFrame main) {
		this.main = main;
	}

	@Override
	public void setValoresDosCampos(final Object object)
			throws NullPointerException {
		final Documento doc = (Documento) object;

		tfProtocolo.setText(doc.getCodigo());
		tfDocumento.setText(doc.getNomeDocumento());
		ftDataEntrega.setText(doc.getDataEntrega());
		ftDataPedido.setText(doc.getDataPedido());
		comboStatus.setSelectedItem(doc.getStatus());
		taDescricao.setText(doc.getDescricao());

	}

	private String stringRandon() {
		final String str = Messages.getString("PlusEventoDocumento.9"); //$NON-NLS-1$
		String strRandom = Messages.getString("PlusEventoDocumento.10"); //$NON-NLS-1$

		for (int i = 0; i < 8; i++) {
			strRandom += str.charAt(numAleatorio());
		}

		return strRandom;
	}
}
