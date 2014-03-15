package Forms;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class TesteGridBag extends JFrame{
	
	private static final int DIST = 5;
	private JPanel painelEsquerdo = new JPanel(new GridLayout(4,1,DIST,DIST));
	private JPanel painelDireito = new JPanel(new GridLayout(4,1,DIST,DIST));
	
	private JScrollPane scroll = new JScrollPane();
	
	private JLabel lbCodigo = new JLabel("Codigo Caixa: ");
	private JLabel lbCodigo2 = new JLabel("Codigo Caixa: ");
	private JLabel lbTurno = new JLabel("Turno: ");
	private JLabel lbLetra = new JLabel("Letra: ");
	private JLabel lbStatus = new JLabel("Status: ");
	
	private JTextField tfCodigo = new JTextField(10);
	private JTextField tfCodigo2 = new JTextField(10);
	private JTextField tfCodigo3 = new JTextField(10);
	private JTextField tfCodigo4 = new JTextField(10);
	private JTextField tfLocalizar = new JTextField();
	
	private ImageIcon icone = new ImageIcon("Icones/search.png");

	private JButton btnSalvar = new JButton("Salvar");
	private JButton btnLimpar = new JButton("Limpar");
	private JButton btnExcluir = new JButton("Excluir");
	private JButton btnAlterar = new JButton("Alterar");
	private JButton btnPesquisar = new JButton(icone);
	GridBagConstraints regras = new GridBagConstraints();
	GridBagLayout layout = new GridBagLayout();
	
	public TesteGridBag() {
		super("Teste GridBagLayout");
		
		setLayout(layout);
		
		Font font_PLA_15 = new Font(Font.SANS_SERIF, Font.PLAIN, 15);
		JComboBox<String> comboStatus = new JComboBox<String>();
		
		comboStatus.addItem("Corrente");
		comboStatus.addItem("Intermediário");
		comboStatus.addItem("Permanente");
		comboStatus.setBackground(Color.white);
		comboStatus.setFont(font_PLA_15);
		
		painelEsquerdo.setPreferredSize(new Dimension(100,0));
		painelEsquerdo.add(lbCodigo);
		painelEsquerdo.add(lbTurno);
		painelEsquerdo.add(lbLetra);
		painelEsquerdo.add(lbStatus);
		
		painelDireito.add(tfCodigo);
		painelDireito.add(comboStatus);
		painelDireito.add(tfCodigo3);
		painelDireito.add(tfCodigo4);
		
		JPanel painelContentBotoes = new JPanel(new GridLayout(1,4,5,5));
		
		painelContentBotoes.add(btnSalvar);
		painelContentBotoes.add(btnAlterar);
		painelContentBotoes.add(btnExcluir);
		painelContentBotoes.add(btnLimpar);
		
		//LINHA 1
		
		regras.anchor = GridBagConstraints.NORTH;
		regras.fill = GridBagConstraints.BOTH;
		addComponente(painelEsquerdo, 0, 0, 1, 1);
		addComponente(painelDireito, 1, 0, 1, 1);
		regras.weightx = 5;
		addComponente(new JLabel(""), 2, 0, 1, 1);
		
		//LINHA 2
		regras.weightx = 1;
		regras.anchor = GridBagConstraints.CENTER;
		regras.fill = GridBagConstraints.HORIZONTAL;
		addComponente(new JLabel(""), 0, 1, 1, 1);
		addComponente(painelContentBotoes, 1, 1, 1, 1);
		addComponente(new JLabel(""), 2, 1, 1, 1);
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setSize(850, 600);
	}
	
	public static void main(String[] args) {
		new TesteGridBag();
	}
	
	public void addComponente(Component comp, int coluna, int linha, int quantidadeGridColuna, int quantidadeGridLinha){
		regras.gridy = linha;
		regras.gridx = coluna;
		regras.gridheight = quantidadeGridLinha;
		regras.gridwidth = quantidadeGridColuna;
		layout.setConstraints(comp, regras);
		add(comp);
	}
	
}
