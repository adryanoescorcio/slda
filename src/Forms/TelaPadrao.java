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

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.AbstractTableModel;
import javax.swing.text.MaskFormatter;

public class TelaPadrao {

	// Constantes
	// Intervalo para o Random
	private static final int TAM_WITH_TABLE_COLUMN = 1000;
	private static final int INTERVALO = 999999999;
	protected static final Color COR_DE_FUNDO = Color.WHITE;
	protected static final int TAM_ROW_TABLE = 22;
	
	// Tipos de Fonte
	public Font font_PLA_14 = new Font(Font.SANS_SERIF, Font.PLAIN, 14);
	public Font font_PLA_15 = new Font(Font.SANS_SERIF, Font.PLAIN, 15);
	public Font font_NEG_15 = new Font(Font.SANS_SERIF,Font.BOLD,15);
	public Font font_NEG_18 = new Font(Font.SANS_SERIF,Font.BOLD,18);
	public Font font_PLA_12 = new Font(Font.SANS_SERIF, Font.PLAIN, 12);
		
	public JScrollPane scroll = new JScrollPane();
	
	public JTable tabela = new JTable(); // Table para todas as Jframes
	protected BorderLayout LAYOUT = new BorderLayout(1,1);
	
	protected MaskFormatter data;
	protected MaskFormatter tel;
	protected MaskFormatter cpf;
	protected MaskFormatter ano;
	
	private JPanel painelSalvarLimpar;
	
	public TelaPadrao() {
		loadConfigTable();
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
	
	public MaskFormatter getMascaraCPF(){
		try {
			cpf = new MaskFormatter("###.###.###-##");
			cpf.setPlaceholderCharacter('_');
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return cpf;
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
	
	/**
	 * Carrega as configurações padrões de todas as tabelas.
	 **/
	private void loadConfigTable() {
		getTabela().setRowHeight(TAM_ROW_TABLE); // Define o tamanho da linha da tabela
		getTabela().setFocusable(false);
		getTabela().setShowVerticalLines(false);
		getTabela().setShowHorizontalLines(true);
		getTabela().setRowMargin(5);
	}
	
	/**
	 * Reestrutura a disposição das colunas na tabela insere o scroll
	 * @param tabela 
	 * @return tabela reorganizada
	 **/
	public JScrollPane organizandoColunasTables(AbstractTableModel modelo) {
	// carregando modelo da tabela.
		JTable tabela = this.tabela;
		
		tabela.setModel(modelo);
		tabela.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		
		int x = TAM_WITH_TABLE_COLUMN/tabela.getColumnCount();
		
		for(int i=0;i<tabela.getColumnCount();i++) {
			tabela.getColumnModel().getColumn(i).setPreferredWidth(x);
		}
		
		scroll.setPreferredSize(new Dimension(0, 200)); // Define o tamanho da tabela.
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS); // Adiciona o scroll vertical
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS); // adiciona o scroll horizontal
		
		scroll.setViewportView(tabela); // insere a tabela no painel Scroll
		scroll.setWheelScrollingEnabled(true);
	
		return scroll;
	}
	
	/**
	 * Painel especifico para a criação de botões de pesquisa parte inferior
	 **/
	public JPanel painelLocaliza(JLabel titulo,JTextField localizar, JButton search) {
		JPanel painelLocalizar = new JPanel(new GridLayout(1,2,2,2));
		JPanel painelContentLocalizar = new JPanel(new BorderLayout(2,2));
		JPanel painelBtnSearch = new JPanel(new BorderLayout(2,2));
		
		painelLocalizar.add(painelContentComponent("East", titulo));
		painelLocalizar.add(painelContentComponent("West", localizar));
		painelBtnSearch.add("West", painelLocalizar);
		painelBtnSearch.add("Center", painelContentComponent("West", search));
		
		painelContentLocalizar.add("North", painelNull(0, 10));
		painelContentLocalizar.add("South", painelNull(0, 10));
		painelContentLocalizar.add("Center", painelBtnSearch);
		painelContentLocalizar.add("East", painelNull(200, 0));
		
		return painelContentLocalizar;
	}
	
	public String numAleatorio() {
		Random rand = new Random();
		return String.valueOf(rand.nextInt(INTERVALO));
	}

	/**
	 * Metodo que generaliza a tabela padrão que deveser utilizada nas Frames
	 **/
	public JTable getTabela() {
		return tabela;
	}

	public void setTabela(JTable tabela) {
		this.tabela = tabela;
	}
}
