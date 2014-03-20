package Eventos;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import DAO.AlunoDAO;
import DAO.CaixaDAO;
import Forms.TablesModel.CaixaTableModel;
import Model.Aluno;
import Model.Caixa;

@SuppressWarnings("serial")
public class EventosCaixa extends EventosPadrão{

	//Objeto que será usado nos eventos
	private Caixa caixa;
	//Objeto que será usado nos eventos
	private CaixaDAO dao;
	
	protected static final int DIST = 5;

	protected static final String BORDER_INFO_CAIXA = "Dados Caixa";

	protected JPanel mainJPanel = new JPanel(new BorderLayout(2,2));
	protected JPanel painelLocalizarArquivo = new JPanel(new BorderLayout(2,2));
	protected JPanel painelInternoNorte = new JPanel(new BorderLayout(2,2));
	protected JPanel painelInternoSul = new JPanel(new BorderLayout(2,2));
	protected JPanel painelEsquerdo = new JPanel(new GridLayout(5,1,DIST,DIST));
	protected JPanel painelDireito = new JPanel(new GridLayout(5,1,DIST,DIST));
	protected JPanel painelTabela= new JPanel(new BorderLayout(2,2));	
	protected JPanel painelContentEIA = new JPanel(new BorderLayout(2,2));
	
	protected JScrollPane scroll = new JScrollPane();
	
	protected JLabel lbCodigo = new JLabel("Codigo Caixa: ",SwingConstants.RIGHT);
	protected JLabel lbCodigo2 = new JLabel("Codigo Caixa: ",SwingConstants.RIGHT);
	protected JLabel lbTurno = new JLabel("Turno: ",SwingConstants.RIGHT);
	protected JLabel lbLetra = new JLabel("Letra: ",SwingConstants.RIGHT);
	protected JLabel lbStatus = new JLabel("Status: ",SwingConstants.RIGHT);
	protected JLabel lbDadosCaixa = new JLabel("DADOS DA CAIXA",SwingConstants.CENTER);
	
	protected JTextField tfCodigo = new JTextField();
	protected JTextField tfLocalizar = new JTextField();
	
	protected ImageIcon icone = new ImageIcon(DIR_ICONES+"search.png");

	protected JButton btnSalvar = new JButton("Salvar");
	protected JButton btnLimpar = new JButton("Limpar");
	protected JButton btnExcluir = new JButton("Excluir");
	protected JButton btnAlterar = new JButton("Alterar");
	protected JButton btnPesquisar = new JButton("Pesquisar", icone);

	protected ArrayList<Caixa> lista = new ArrayList<Caixa>();
	protected CaixaTableModel modelo = new CaixaTableModel(lista);
	protected JTable tabela = new JTable(modelo);
	
	protected JComboBox<String> comboTurno = padrao.getComboBoxTurno();
	protected JComboBox<String> comboLetra = padrao.getComboBoxLetra();
	protected JComboBox<String> comboStatus = padrao.getComboBoxStatus();

	@Override
	public void limparCampos() {
		// TODO Auto-generated method stub
		tfCodigo.setText("");
		tfLocalizar.setText("");
		comboTurno.setSelectedIndex(0);
		comboLetra.setSelectedIndex(0);
		comboStatus.setSelectedIndex(0);
		
	}

	@Override
	public Object getValoresDosCampos() {
		
		caixa = new Caixa();
		caixa.setCodigo(tfCodigo.getText());
		caixa.setTurno((String) comboTurno.getSelectedItem());
		caixa.setLetra((String) comboLetra.getSelectedItem());
		caixa.setStatus((String) comboStatus.getSelectedItem());
		
		return caixa;
	}

	@Override
	public void setValoresDosCampos(Object caixa) {
		caixa = new Caixa();
		
		tfCodigo.setText(((Caixa) caixa).getCodigo());
		comboTurno.setSelectedItem(((Caixa) caixa).getTurno());
		comboLetra.setSelectedItem(((Caixa) caixa).getLetra());
		comboStatus.setSelectedItem(((Caixa) caixa).getStatus());
		
	}
	
	//OBJETO ActionListener QUE LIMPA OS CAMPOS DA TELA
	protected ActionListener onClickLimparCampos = new ActionListener() {	
		@Override
		public void actionPerformed(ActionEvent e) {
			limparCampos();
		}
	};
	
	//OBJETO ActionListener QUE SALVA O CAIXA
	protected ActionListener onClickSalvarCaixa = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
		caixa = (Caixa) getValoresDosCampos();
		dao = new CaixaDAO(conexaoBD);
		dao.save(caixa);
		JOptionPane.showMessageDialog(null, "Salvo com sucesso.");
		limparCampos();
		
		//LIMPA A CAIXA
		caixa = null;
		}
	};

}
