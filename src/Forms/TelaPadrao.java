package Forms;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Label;
import java.text.ParseException;
import java.util.Random;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

public class TelaPadrao{

	// Constantes
	// Intervalo para o Random
	private static final int INTERVALO = 999999999;
	public static final String DIR_ICONES = "src/Icones/";
	protected static final Color COR_DE_FUNDO = Color.WHITE;
	protected static final int TAM_ROW_TABLE = 22;
	
	private ImageIcon icone = new ImageIcon(DIR_ICONES+"search.png");
	
	// Tipos de Fonte
	public Font font_PLA_15 = new Font(Font.SANS_SERIF, Font.PLAIN, 15);
	public Font font_NEG_15 = new Font(Font.SANS_SERIF,Font.BOLD,15);
	public Font font_PLA_14 = new Font(Font.SANS_SERIF, Font.PLAIN, 14);
	protected Font font_PLA_12 = new Font(Font.SANS_SERIF, Font.PLAIN, 12);
		
	protected Icon iconSalvar = new ImageIcon(DIR_ICONES+"save3.png");
	
	
	private JTable tabela = new JTable(); // Table para todas as Jframes
	public GridLayout layout2 = new GridLayout(20, 4, 5, 5);
	protected BorderLayout LAYOUT = new BorderLayout(1,1);
	
	private JTextField tfLocalizar = new JTextField();
	
	private JButton btnPesquisar = new JButton("Pesquisar", icone);
	
	protected MaskFormatter data;
	protected MaskFormatter tel;
	protected MaskFormatter cpf;
	protected MaskFormatter ano;
	
	private JPanel painelSalvarLimpar;
	
	public TelaPadrao() {
		loadConfigTable();
		alterarFontes();
	}
	
	public Label getTitulo(String titulo){
		Label nome = new Label(titulo);
		nome.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 19));
	
		return nome;
	}
	
	/**
	 * Este metodo cria um espaço em branco a direita do JtextFild, definindo a largura do JtextFild 
	 **/
	public JPanel painelContentFieldTamanhoLargura(JTextField textField, int tamanho) {
		JPanel painelPrincipalContent = new JPanel(new BorderLayout(2,2));
		JPanel painelSeparador = new JPanel(new BorderLayout(2,2));
		
		// SEPARADOR
		painelSeparador.add("West", painelNull(tamanho, 0));
		// principal
		painelPrincipalContent.add("Center", painelContentComponent("Center", textField));
		painelPrincipalContent.add("East", painelSeparador);
		
		return painelPrincipalContent;
	}

	/**
	 * Criar um painel vazio.
	 **/
	public JPanel painelNull(int i, int j) {
		JPanel painelNull = new JPanel();
		painelNull.setPreferredSize(new Dimension(i,j));
		
		return painelNull;
	}
	
	/**
	 * Cria um painel Content para limitar horizontalmente o tamanho dos componentes ao maximo.
	 **/
	public JPanel painelContentComponent(String lado, Component componente) {
		JPanel painelContent = new JPanel(new BorderLayout());
		painelContent.add(lado,componente);
		
		return painelContent;
	}
	
	public MaskFormatter getMascaraData(){
		try {
			data = new MaskFormatter(" ##/##/####");
			data.setPlaceholderCharacter('_');
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return data;
	}
	
	public MaskFormatter getMascaraTelefone(){
		try {
			tel = new MaskFormatter("(##) ####-####");
			tel.setPlaceholderCharacter('_');
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return tel;
	}
	
	public MaskFormatter getMascaraCPF(){
		try {
			cpf = new MaskFormatter("###.###.###-##");
			cpf.setPlaceholderCharacter('_');
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return cpf;
	}

	public MaskFormatter getMascaraAno(){
		try {
			ano = new MaskFormatter("####.1");
			ano.setPlaceholderCharacter('_');
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return ano;
	}
	
	public JPanel SalvarLimparBotoes() {
		painelSalvarLimpar = new JPanel(new BorderLayout(2,2));
		painelSalvarLimpar.add("Weast",painelNull(20,20));
		return painelSalvarLimpar;
	}
	
	private void loadConfigTable() {
		// TABELA
		getTabela().setRowHeight(TAM_ROW_TABLE); // Define o tamanho da linha da tabela
		getTabela().setFocusable(false);
		getTabela().setShowVerticalLines(false);
		getTabela().setShowHorizontalLines(true);
		getTabela().setRowMargin(5);
	}
	
	/**
	 * Painel especifico para a criação de botões de pesquisa parte inferior
	 **/
	public JPanel painelLocaliza(JLabel titulo) {
		JPanel painelLocalizar = new JPanel(new GridLayout(1,3,2,2));
		JPanel painelContentLocalizar = new JPanel(new BorderLayout(2,2));
		
		painelLocalizar.add(painelContentComponent("East", titulo));
		painelLocalizar.add(painelContentComponent("West", getTfLocalizar()));
		painelLocalizar.add(painelContentComponent("West", getBtnPesquisar()));
		
		painelContentLocalizar.add("North", painelNull(0, 5));
		painelContentLocalizar.add("Center", painelLocalizar);
		painelContentLocalizar.add("East", painelNull(300, 0));
		
		return painelContentLocalizar;
	}
	
	public String numAleatorio() {
		Random rand = new Random();
		return String.valueOf(rand.nextInt(INTERVALO));
	}

	private void alterarFontes() {
		getBtnPesquisar().setFont(font_PLA_14);
		getTfLocalizar().setFont(font_NEG_15);
		
		getTfLocalizar().setPreferredSize(new Dimension(200,0));
		getBtnPesquisar().setPreferredSize(new Dimension(140,26));
		getBtnPesquisar().setRolloverEnabled(false);
	}

	public JTable getTabela() {
		return tabela;
	}

	public void setTabela(JTable tabela) {
		this.tabela = tabela;
	}

	public JTextField getTfLocalizar() {
		return tfLocalizar;
	}

	public void setTfLocalizar(JTextField tfLocalizar) {
		this.tfLocalizar = tfLocalizar;
	}

	public JButton getBtnPesquisar() {
		return btnPesquisar;
	}

	public void setBtnPesquisar(JButton btnPesquisar) {
		this.btnPesquisar = btnPesquisar;
	}
	
}
