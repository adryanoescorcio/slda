package Eventos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Comparator;
import java.util.List;

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
 * Classe responsavel pelos eventos do painelCaixa
 * $$
 * @author Walysson Oliveira
 * @author Adryano Escorcio
 * @version 2.0
 * @extends EventoPadrão
 **/

public class PlusEventoDocumento extends EventosPadrao {

	//OBJETO UTILIZADO NAS BUSCAS
	Documento DocPesquisa = new Documento();

	//TABELA
	PainelTabela table = new PainelTabela();
	protected JTable tabela = table.getTabela();
	protected List<Documento> lista = daoDoc.buscarDocumentoporAluno(aluno);
	protected DocumentoTableModel modelo;
	protected String strCodigo;

	//COMPONENTES NECESSÁRIOS
	protected JTextField tfProtocolo = new JTextField();
	protected JTextField tfDocumento = new JTextField();
	protected JFormattedTextField ftDataPedido = new JFormattedTextField(mask.getMascaraData());
	protected JFormattedTextField ftDataEntrega = new JFormattedTextField(mask.getMascaraData());
	protected JComboBox<String> comboStatus = comboGroup.getComboBoxStatusDocumento();
	
	protected JTextArea taDescricao = new JTextArea();
	
	protected MainJFrame main;
	protected EventosAluno evento;

	public PlusEventoDocumento(MainJFrame main, EventosAluno evento) {
		this.main = main;
		this.evento = evento;
		//INICIA A TABELA ORDENADA
//		Collections.sort(lista, comparador);
		modelo = new DocumentoTableModel(lista);
		tfProtocolo.setEditable(false);
	}

	public MainJFrame getMain() {
		return main;
	}

	public void setMain(MainJFrame main) {
		this.main = main;
	}

	@Override
	public Object getValoresDosCampos() {


		if(!(((String) tfDocumento.getText()) == "") &&
				!(((String) ftDataPedido.getText()) == "")){

			documento = new Documento();
			documento.setCodigo(tfProtocolo.getText().trim());
			documento.setAluno(aluno);
			documento.setStatus((String) comboStatus.getSelectedItem());
			documento.setDataEntrega(ftDataEntrega.getText());
			documento.setDataPedido(ftDataPedido.getText());

			return documento;
		} else {
			throw new erroNullRequisitoException("(ER02) Preencha todos os requisitos com dados válidos.", "ERRO ER02");
		}
	}

	@Override
	public void setValoresDosCampos(Object object) throws NullPointerException {
		Documento doc = (Documento) object;

		tfProtocolo.setText(doc.getCodigo());
		tfDocumento.setText(doc.getNomeDocumento());
		ftDataEntrega.setText(doc.getDataEntrega());
		ftDataPedido.setText(doc.getDataPedido());
		comboStatus.setSelectedItem(doc.getStatus());
		
	}

	/**
	 * Metodos que realiza a função de limpar os campos.
	 **/
	protected ActionListener onClickLimparCampos = new ActionListener() {  
		@Override
		public void actionPerformed(ActionEvent e) {
			limparCampos();
		}
	};

	/**
	 * Necessário verificar se houve alteração para poder atualiza a caixa modificada.
	 **/
	protected ActionListener onClickAlterarCaixa = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			documento = (Documento) getValoresDosCampos();

			if(!documento.toString().equals(DocPesquisa.toString())) {                        
				if(daoDoc.save(documento)) {
					JOptionPane.showMessageDialog(null, SUCESSO);
					modelo.updateContato(DocPesquisa, documento);
					limparCampos();
				}      
			} else {
				JOptionPane.showMessageDialog(null, "(AT01) Não houve modificação.","ATENÇÃO AT01",
						JOptionPane.WARNING_MESSAGE);
			}
		}
	};

	/**
	 * Metodo com a função de salvar e alterar uma caixa.
	 **/
	protected ActionListener onClickSalvarCaixa = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {

			try {
				// TODO
			} catch (Exception ex) {
				System.out.println("Dados estão incompletos");
			}
		}
	};

	/**
	 * Metodo com a função de excluir uma caixa
	 **/
	protected ActionListener onClickExcluirCaixa = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			Documento documentoSelect = (Documento) getValoresDosCampos();
			if (JOptionPane.showConfirmDialog(null, "Deseja excluir a Caixa?") == 0) {
				daoDoc.remover(documentoSelect);
				JOptionPane.showMessageDialog(null, "Documento foi excluído com sucesso.");
				modelo.removeContato(documentoSelect);
				limparCampos();

				//LIMPA A CAIXA
				documento = null;
			}
		}
	};

	//OBJETO QUE REALIZA UMA BUSCA ATRAVÉS DAS LINHAS DA TABELA
	protected MouseListener onClickRowTable = new MouseListener() {

		@Override
		public void mouseClicked(MouseEvent e) {
			if(e.getClickCount() == 2){
				int linha = tabela.getSelectedRow();
				DocPesquisa = modelo.getContato(linha);
				setValoresDosCampos(DocPesquisa);

				if (aluno == null) {
					habilitarBotoes(true);
				} else {
					desabilitarTudoFormulario();
				}
			}
		}

		@Override
		public void mouseEntered(MouseEvent e) {}
		@Override
		public void mouseExited(MouseEvent e) {}
		@Override
		public void mousePressed(MouseEvent e) {}
		@Override
		public void mouseReleased(MouseEvent e) {}
	};
	
	protected ActionListener onClickCancelarOperacao = new ActionListener() {      
		@Override
		public void actionPerformed(ActionEvent e) {
			main.normalizarCamadas();
		}
	};
	
	public void atualizarAlunoTela(){
		tfDiscente.setText(evento.aluno.getNomeAluno());
	}

	@Override
	public void limparCampos() {
		tfProtocolo.setText(null);
		tfDocumento.setText(null);
		ftDataEntrega.setText(null);
		ftDataPedido.setText(null);
		comboStatus.setSelectedIndex(0);
		
		setMudarPerfil(false);
		habilitarBotoes(false);
	}

	protected void mostarDadoSalvo(Caixa caixa) {
		setValoresDosCampos(caixa);
		tfDocumento.setEnabled(false);
		ftDataEntrega.setEnabled(false);
		ftDataPedido.setEnabled(false);
		comboStatus.setEnabled(false);
		
		btnSalvar.setEnabled(false);
	}

	//METODO PARA HABILITAR OU DESABILITAR OS BOTOES QUE INICIAM Enabled E TAMBÉM OUTROS COMPONENTES NECESSÁRIOS
	public void habilitarBotoes(boolean bool) {
		comboStatus.setEnabled(true);
		btnAlterar.setEnabled(bool);
		btnExcluir.setEnabled(bool);
		btnSalvar.setEnabled(!bool);
	}

	//PEQUENA CLASSE DE COMPARAÇÃO UTILIZADA NA ORDENAÇÃO DA LISTA
	public static class  ComparadorObjetos implements Comparator<Caixa> {

		@Override
		public int compare(Caixa objetoParaComparar, Caixa objetoAserComparado) {
			return  objetoParaComparar.getCodigo().compareTo(objetoAserComparado.getCodigo());
		}
	}   

	public void setMudarPerfil(boolean bool) {
		btnSalvar.setEnabled(!bool);
		btnAlterar.setEnabled(!bool);
		btnExcluir.setEnabled(!bool);

		btnRetirar.setEnabled(bool);
		btnInserir.setEnabled(bool);

		comboStatus.setEnabled(!bool);
	}

	protected void desabilitarTudoFormulario() {
		tfProtocolo.setEnabled(false);
		comboStatus.setEditable(false);
		tfDocumento.setEditable(false);
		ftDataEntrega.setEditable(false);
		ftDataPedido.setEditable(false);

		btnAlterar.setEnabled(false);
	}

	public Documento getCaixa() {
		return documento;
	}
}
