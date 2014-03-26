package Eventos;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import DAO.CaixaDAO;
import ExceptionSLDA.erroNullRequisitoException;
import Forms.TablesModel.CaixaTableModel;
import Model.Caixa;
import PrimaryKey.CaixaPK;

@SuppressWarnings("serial")
public class EventosCaixa extends EventosPadrão{

	//Objeto que será usado nos eventos
	private Caixa caixa;
	private Caixa caixa2;
	
	//Objeto que será usado nos eventos
	private CaixaDAO dao = new CaixaDAO(conexaoBD);
	
	protected static final int DIST = 5;

	protected static final String BORDER_INFO_CAIXA = "DADOS DA CAIXA";
	protected static final int QUANT_LINHAS_GRID = 5;

	protected JPanel mainJPanel = new JPanel(new BorderLayout(2,2));
	protected JPanel painelLocalizarArquivo = new JPanel(new BorderLayout(2,2));
	protected JPanel painelInternoNorte = new JPanel(new BorderLayout(2,2));
	protected JPanel painelInternoSul = new JPanel(new BorderLayout(2,2));
	protected JPanel painelEsquerdo = new JPanel(new GridLayout(QUANT_LINHAS_GRID,1,DIST,DIST));
	protected JPanel painelDireito = new JPanel(new GridLayout(QUANT_LINHAS_GRID,1,DIST,DIST));
	protected JPanel painelTabela= new JPanel(new BorderLayout(2,2));	
	protected JPanel painelContentEIA = new JPanel(new BorderLayout(2,2));
	
	protected JScrollPane scroll = new JScrollPane();
	
	protected JLabel lbCodigo = new JLabel("Cód. Caixa:* ",SwingConstants.RIGHT);
	protected JLabel lbCodigo2 = new JLabel("Cód. Caixa: ",SwingConstants.RIGHT);
	protected JLabel lbTurno = new JLabel("Turno: ",SwingConstants.RIGHT);
	protected JLabel lbLetra = new JLabel("Letra: ",SwingConstants.RIGHT);
	protected JLabel lbStatus = new JLabel("Status: ",SwingConstants.RIGHT);
	protected JLabel lbDadosCaixa = new JLabel("DADOS DA CAIXA",SwingConstants.CENTER);
	
	protected JTextField tfCodigo = new JTextField();
	
	protected ArrayList<Caixa> lista = new ArrayList<Caixa>();
	protected CaixaTableModel modelo = new CaixaTableModel(lista);

	protected JScrollPane scrollMain = new JScrollPane();
	
	protected JComboBox<String> comboTurno = getComboBoxTurno();
	protected JComboBox<String> comboLetra = getComboBoxLetra();
	protected JComboBox<String> comboStatus = getComboBoxStatus();
	
	public EventosCaixa() {
		btnAlterar.setEnabled(false); // necessario a pesquisa para ativar botão
		btnExcluir.setEnabled(false); // necessario a pesquisa para ativar botão
	}
	
	@Override
	public Object getValoresDosCampos() {
		
		if(!tfCodigo.getText().trim().equals("")){
			
			caixa = new Caixa();
			caixa.setCodigo(tfCodigo.getText().trim());
			caixa.setTurno((String) comboTurno.getSelectedItem());
			caixa.setStatus((String) comboStatus.getSelectedItem());
			caixa.setLetra((String) comboLetra.getSelectedItem());
			
			return caixa;
			
		} else {
			throw new erroNullRequisitoException("(ER02) Preencha todos os requisitos com dados válidos.", "ERRO ER02",null);
		}
	}

	@Override
	public void setValoresDosCampos(Object object) throws NullPointerException {
		Caixa caixa = (Caixa) object;
		
		tfCodigo.setText(caixa.getCodigo());
		comboTurno.setSelectedItem(caixa.getTurno());
		comboLetra.setSelectedItem(caixa.getLetra());
		comboStatus.setSelectedItem(caixa.getStatus());
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
	protected ActionListener onClickAterarCaixa = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			caixa = (Caixa) getValoresDosCampos();
			caixa2 = dao.buscar(caixa.getCodigoKEY());
			
			if(!caixa.toString().equals(caixa2.toString())) {
				metodoSalvar();
				
			} else {
				JOptionPane.showMessageDialog(null, "(AT01) Não houve modificação.","ATENÇÃO AT01", 
						JOptionPane.WARNING_MESSAGE);
			}
		}
	};
	
	private void metodoSalvar() {
		// Tentar pegar os valores
		caixa = (Caixa) getValoresDosCampos();
		
		// Caso seja salvo com sucesso
		if(dao.save(caixa)) {
			JOptionPane.showMessageDialog(null, SUCESSO);
			modelo.addContato(caixa); // Insere a caixa na tabela.
			limparCampos();
			
			//LIMPA A CAIXA
			caixa = null;
		}		
	}
	/**
	 * Metodo com a função de salvar e alterar uma caixa.
	 **/
	protected ActionListener onClickSalvarCaixa = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			metodoSalvar();
		}
	};

	/***
	 * Metodo com  a função de buscar um caixa
	 */
	protected ActionListener onClickBuscarCaixa = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			String codigoLocalizar = tfLocalizar.getText().trim(); // pega o codigo digitado pelo cliente.

			CaixaPK pk = new CaixaPK(); // chave primaria da caixa.
			pk.setCodigo(codigoLocalizar); // seta a chave

			try{
				Caixa cx = dao.buscar(pk); // realiza a busca no banco de dados
				setValoresDosCampos(cx); // atribui os valores recuperados para os campos.
				btnAlterar.setEnabled(true); // necessario a pesquisa para ativar botão
				btnExcluir.setEnabled(true); // necessario a pesquisa para ativar botão
				
				btnSalvar.setEnabled(false); // nao sera possivel salvar, somente alterar
				tfCodigo.setEditable(false); // nao sera possivel alterar o codigo de objeto consultado.
				
				caixa = cx;
			
			}catch(NullPointerException exc){
				throw new erroNullRequisitoException("(ER03) Nenhuma Caixa \"" +codigoLocalizar+ "\" foi encontrada.", "ERRO ER03",null);
			}
		}
	};

	/**
	 * Metodo com a função de excluir uma caixa
	 **/
	protected ActionListener onClickExcluirCaixa = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {			
			dao.remover(caixa);
			JOptionPane.showMessageDialog(null, "Caixa excluído com sucesso.");
			limparCampos();
		}
	};
	
	@Override
	public void limparCampos() {
		tfCodigo.setText(null);
		comboTurno.setSelectedIndex(0);
		comboLetra.setSelectedIndex(0);
		comboStatus.setSelectedIndex(0);
		
		btnAlterar.setEnabled(false); // necessario a pesquisa para ativar botão
		btnExcluir.setEnabled(false);
		
		btnSalvar.setEnabled(true);
		tfCodigo.setEditable(true);
	}
	
}
