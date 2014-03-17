package Forms;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import Forms.TablesModel.CaixaTableModel;
import Model.Caixa;

@SuppressWarnings("serial")
public class TesteGridBag extends JFrame{
	
	private static final int DIST = 5;
	private JPanel painelEsquerdo = new JPanel(new GridLayout(5,1,DIST,DIST));
	private JPanel painelDireito = new JPanel(new GridLayout(5,1,DIST,DIST));
	
	private JScrollPane scroll = new JScrollPane();
	
	private JLabel lbCodigo = new JLabel("Codigo Caixa: ");
	private JLabel lbCodigo2 = new JLabel("Codigo Caixa: ");
	private JLabel lbTurno = new JLabel("Turno: ");
	private JLabel lbLetra = new JLabel("Letra: ");
	private JLabel lbStatus = new JLabel("Status: ");
	
	private JTextField tfCodigo = new JTextField(10);
	private JTextField tfCodigo2 = new JTextField(10);
	private JTextField tfCodigo3 = new JTextField(20);
	private JTextField tfCodigo4 = new JTextField(20);
	private JTextField tfLocalizar = new JTextField();
	
	TelaPadrao padrao = new TelaPadrao();
	
	private ImageIcon icone = new ImageIcon("../Icones/search.png");

	private JButton btnSalvar = new JButton("Salvar");
	private JButton btnLimpar = new JButton("Limpar");
	private JButton btnExcluir = new JButton("Excluir");
	private JButton btnAlterar = new JButton("Alterar");
	private JButton btnPesquisar = new JButton(icone);
	
	protected ArrayList<Caixa> lista = new ArrayList<Caixa>();
	protected CaixaTableModel modelo = new CaixaTableModel(lista);
	protected JTable tabela = new JTable(modelo);
	
	public TesteGridBag() {
		super("Teste GridBagLayout");
		
		setLayout(new BorderLayout(5, 5));
		
		JPanel compNorte = new JPanel();
		compNorte.setLayout(new BorderLayout());
		
		Font font_PLA_15 = new Font(Font.SANS_SERIF, Font.PLAIN, 15);
		JComboBox<String> comboStatus = new JComboBox<String>();
		
		comboStatus.addItem("Corrente");
		comboStatus.addItem("Intermediário");
		comboStatus.addItem("Permanente");
		comboStatus.setBackground(Color.white);
		comboStatus.setFont(font_PLA_15);
		
		scroll.setPreferredSize(new Dimension(0, 200)); // Define o tamanho da tabela.
		scroll.setViewportView(tabela); // insere a tabela no painel Scroll
		
		JPanel painelContentBotoes = new JPanel(new GridLayout(1,4,5,5));
		painelContentBotoes.add(btnSalvar);
		painelContentBotoes.add(btnAlterar);
		painelContentBotoes.add(btnExcluir);
		painelContentBotoes.add(btnLimpar);
		
		painelEsquerdo.setPreferredSize(new Dimension(100,0));
		painelEsquerdo.add(lbCodigo);
		painelEsquerdo.add(lbTurno);
		painelEsquerdo.add(lbLetra);
		painelEsquerdo.add(lbStatus);
		painelEsquerdo.add(new JLabel(""));
		
		painelDireito.add(criarFlow(tfCodigo, FlowLayout.LEFT));
		painelDireito.add(criarFlow(padrao.getComboBoxTurno(), FlowLayout.LEFT));
		painelDireito.add(criarFlow(padrao.getComboBoxLetra(), FlowLayout.LEFT));
		painelDireito.add(criarFlow(padrao.getComboBoxStatus(), FlowLayout.LEFT));
		painelDireito.add(criarFlow(painelContentBotoes, FlowLayout.CENTER));
		
		compNorte.add(painelEsquerdo, BorderLayout.WEST);
		compNorte.add(painelDireito, BorderLayout.CENTER);
		
		compNorte.setPreferredSize(new Dimension(0,220));
		add(compNorte, BorderLayout.NORTH);
		add(scroll, BorderLayout.CENTER);
		add(painelLocaliza(), BorderLayout.SOUTH);
		
		alterarFontes();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setSize(850, 600);
	}
	
	public static void main(String[] args) {
		new TesteGridBag();
	}
	

	private void alterarFontes() {
		lbCodigo.setFont(padrao.font_PLA_15);
		lbCodigo2.setFont(padrao.font_PLA_15);
		lbLetra.setFont(padrao.font_PLA_15);
		lbTurno.setFont(padrao.font_PLA_15);
		lbStatus.setFont(padrao.font_PLA_15);
		
		tfCodigo.setFont(padrao.font_NEG_15);
		tfCodigo2.setFont(padrao.font_NEG_15);
		tfCodigo3.setFont(padrao.font_NEG_15);
		tfCodigo4.setFont(padrao.font_NEG_15);
		tfLocalizar.setFont(padrao.font_NEG_15);
		
		btnSalvar.setFont(padrao.font_PLA_15);
		btnPesquisar.setFont(padrao.font_PLA_15);
		btnLimpar.setFont(padrao.font_PLA_15);
		btnAlterar.setFont(padrao.font_PLA_15);
		btnExcluir.setFont(padrao.font_PLA_15);
		
		btnPesquisar.setPreferredSize(new Dimension(25,25));
		btnPesquisar.setRolloverEnabled(false);
	}
	
	public JPanel criarFlow(Component comp, int Alinhamento){
		FlowLayout flow = new FlowLayout();
		flow.setAlignment(Alinhamento);
		JPanel painel = new JPanel();
		painel.setLayout(flow);
		painel.add(comp);
		return painel;
	}
	
	public JPanel criarFlow(Component comp, Component comp2, Component comp3, int Alinhamento){
		FlowLayout flow = new FlowLayout();
		flow.setAlignment(Alinhamento);
		JPanel painel = new JPanel();
		painel.setLayout(flow);
		painel.add(comp);
		painel.add(comp2);
		painel.add(comp3);
		return painel;
	}
	
	private JPanel painelLocaliza() {
		JPanel painelLocalizar = new JPanel(new BorderLayout(2,2));
		painelLocalizar.setPreferredSize(new Dimension(0,160));
		painelLocalizar.add("North", criarFlow(lbCodigo2, tfCodigo2, btnPesquisar, FlowLayout.LEFT));
		return painelLocalizar;
	}

}
