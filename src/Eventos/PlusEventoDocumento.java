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
 * Classe responsavel pelos eventos do painelCaixa
 * $$
 * @author Walysson Oliveira
 * @author Adryano Escorcio
 * @version 2.0
 * @extends EventoPadrão
 **/

public class PlusEventoDocumento extends EventosPadrao {

	private static final int INTERVALO = 35;

	//OBJETO UTILIZADO NAS BUSCAS
	Documento DocPesquisa = new Documento();

	//TABELA
	PainelTabela table = new PainelTabela();
	protected JTable tabela = table.getTabela();
	protected List<Documento> lista;
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
		dataPedidoCampo();
		
		lista = daoDoc.buscarDocumentoporAluno(evento.aluno);
		modelo = new DocumentoTableModel(lista);
		tfProtocolo.setEditable(false);
	}

	private String dateToday() {

		Date date = new Date();
		SimpleDateFormat dateToday = new SimpleDateFormat("dd/MM/yyyy");
		String strDateToday = dateToday.format(date);

		return strDateToday;
	}
	
	private void dataPedidoCampo() {
		ftDataPedido.setText(dateToday());
	}

	public MainJFrame getMain() {
		return main;
	}

	public void setMain(MainJFrame main) {
		this.main = main;
	}

	@Override
	public Object getValoresDosCampos() {
		
		if(!(((String) ftDataPedido.getText()) == "")){

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
			throw new erroNullRequisitoException("(ER02) Preencha todos os requisitos com dados válidos.", "ERRO ER02");
		}
	}

	public int numAleatorio() {
		Random rand = new Random();
		return rand.nextInt(INTERVALO);
	}
	
	private String stringRandon() {
		String str = "ABCDEFGHIJKLMNOPQRSTUVXWYZ0123456789";
		String strRandom = "";
		
		for (int i=0; i < 8; i++) {
			strRandom += str.charAt(numAleatorio());
		}
		
		return strRandom;
	}

	@Override
	public void setValoresDosCampos(Object object) throws NullPointerException {
		Documento doc = (Documento) object;

		tfProtocolo.setText(doc.getCodigo());
		tfDocumento.setText(doc.getNomeDocumento());
		ftDataEntrega.setText(doc.getDataEntrega());
		ftDataPedido.setText(doc.getDataPedido());
		comboStatus.setSelectedItem(doc.getStatus());
		taDescricao.setText(doc.getDescricao());
		
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
				
				// gerando protocolo
				tfProtocolo.setText((String.valueOf
						(numAleatorio()) 
							+ stringRandon() + numAleatorio()));
				
				Documento doc = (Documento) getValoresDosCampos();
				if(daoDoc.save(doc)) {
					JOptionPane.showMessageDialog(null, SUCESSO);
					modelo.addContato(doc);
					evento.modeloDoc.addContato(doc);
					desabilitarAll();
				} else {
					JOptionPane.showMessageDialog(null, ERROPROC);
				}
				
			} catch (Exception ex) {
				System.out.println("Dados estão incompletos" + ex.getMessage());
			}
		}
	};
	
	protected ItemListener onClickChangeModalidade = new ItemListener() {
		@Override
		public void itemStateChanged(ItemEvent ev) {
			if(comboStatus.getSelectedIndex() == 1) {			
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
		public void actionPerformed(ActionEvent e) {
			Documento documentoSelect = (Documento) getValoresDosCampos();
			if (JOptionPane.showConfirmDialog(null, "Deseja excluir o documento?") == 0) {
				daoDoc.remover(documentoSelect);
				JOptionPane.showMessageDialog(null, "Documento foi excluído com sucesso.");
				modelo.removeContato(documentoSelect);
				evento.modeloDoc.removeContato(documentoSelect);
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
				habilitarBotoes(true,1);
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

	protected void desabilitarAll() {
		btnSalvar.setEnabled(false);
		tfDocumento.setEditable(false);
		tfProtocolo.setEditable(false);
		comboStatus.setEnabled(false);
		taDescricao.setEditable(false);
		ftDataEntrega.setEditable(false);
		ftDataPedido.setEditable(false);
	}

	@Override
	public void limparCampos() {
		tfProtocolo.setText(null);
		tfDocumento.setText(null);
		ftDataEntrega.setText(null);
		ftDataPedido.setText(dateToday());
		comboStatus.setSelectedIndex(0);
		taDescricao.setText(null);
		
		habilitarBotoes(false,0);
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
	public void habilitarBotoes(boolean bool, int i) {
		
		if(i != 1) {
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

	//PEQUENA CLASSE DE COMPARAÇÃO UTILIZADA NA ORDENAÇÃO DA LISTA
	public static class  ComparadorObjetos implements Comparator<Caixa> {

		@Override
		public int compare(Caixa objetoParaComparar, Caixa objetoAserComparado) {
			return  objetoParaComparar.getCodigo().compareTo(objetoAserComparado.getCodigo());
		}
	}   

	public Documento getCaixa() {
		return documento;
	}
}
