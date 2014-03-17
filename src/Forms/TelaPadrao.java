package Forms;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Label;
import java.text.ParseException;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.text.MaskFormatter;

public class TelaPadrao{

	// Constantes
	public static final String DIR_ICONES = "src/Icones/";
	protected static final Color COR_DE_FUNDO = Color.WHITE;
	
	// Tipos de Fonte
	public Font font_PLA_15 = new Font(Font.SANS_SERIF, Font.PLAIN, 15);
	public Font font_NEG_15 = new Font(Font.SANS_SERIF,Font.BOLD,15);
	
	protected Icon iconSalvar = new ImageIcon(DIR_ICONES+"save3.png");
	
	protected GridLayout layout2 = new GridLayout(20, 4, 5, 5);
	protected BorderLayout LAYOUT = new BorderLayout(1,1);
	
	protected MaskFormatter data, tel, cpf;
	
	private JPanel painelSalvarLimpar;
	
	public Label getTitulo(String titulo){
		Label nome = new Label(titulo);
		nome.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 19));
	
		return nome;
	}
	
	//METODO QUE CRIA, DIVIDE UMA CÉLULA DO GRIDLAYOUT E A CONFIGURA
	public JPanel criarDividirEConfigurarCelula(Component comp1, Component comp2){
		JPanel jpanel = new JPanel();
		jpanel.setLayout(new GridLayout(1, 2, 5, 5));
		jpanel.add(comp1);
		jpanel.add(comp2);
		jpanel.setBackground(Color.WHITE);
		return jpanel;
	}
	
	//METODO QUE CRIA, DIVIDE UMA CÉLULA DO GRIDLAYOUT E A CONFIGURA PARA 4 COMPONENTES
	public JPanel criarDividirEConfigurarCelula(Component comp1, Component comp2, Component comp3, Component comp4){
		JPanel jpanel = new JPanel();
		jpanel.setLayout(new GridLayout(1, 2, 5, 5));
		jpanel.add(comp1);
		jpanel.add(comp2);
		jpanel.add(comp3);
		jpanel.add(comp4);
		jpanel.setBackground(Color.WHITE);
		return jpanel;
	}

	public JPanel painelNull(int i, int j) {
		JPanel painelNull = new JPanel();
		painelNull.setPreferredSize(new Dimension(i,j));
		
		return painelNull;
	}
	
	public JPanel painelContentComponent(String lado, Component componente) {
		JPanel painelContent = new JPanel(new BorderLayout());
		painelContent.add(lado,componente);
		
		return painelContent;
	}
	
	public JComboBox<String> getComboBoxTurno() {
		
		JComboBox<String> comboTurno = new JComboBox<String>();
		
		comboTurno.addItem(null);
		comboTurno.addItem("1 - Matutino");
		comboTurno.addItem("2 - Vespertino");
		comboTurno.addItem("3 - Noturno");
		comboTurno.setBackground(Color.white);
		comboTurno.setFont(font_PLA_15);
		
		return comboTurno;
	}
	
	public JComboBox<String> getComboBoxLetra() {
		JComboBox<String> comboLetra = new JComboBox<String>();
		
		comboLetra.addItem(null);
		comboLetra.addItem("A");
		comboLetra.addItem("B");
		comboLetra.addItem("C");
		comboLetra.addItem("D");
		comboLetra.addItem("E");
		comboLetra.addItem("F");
		comboLetra.addItem("G");
		comboLetra.addItem("H");
		comboLetra.addItem("I");
		comboLetra.addItem("J");
		comboLetra.addItem("K");
		comboLetra.addItem("L");
		comboLetra.addItem("M");
		comboLetra.addItem("N");
		comboLetra.addItem("O");
		comboLetra.addItem("P");
		comboLetra.addItem("R");
		comboLetra.addItem("S");
		comboLetra.addItem("T");
		comboLetra.addItem("U");
		comboLetra.addItem("V");
		comboLetra.addItem("W");
		comboLetra.addItem("X");
		comboLetra.addItem("Y");
		comboLetra.addItem("Z");
		comboLetra.setBackground(Color.white);
		comboLetra.setFont(font_PLA_15);
		
		return comboLetra;
	}
	
	public JComboBox<String> getComboBoxStatus() {
		JComboBox<String> comboStatus = new JComboBox<String>();
		
		comboStatus.addItem("Corrente");
		comboStatus.addItem("Intermediário");
		comboStatus.addItem("Permanente");
		comboStatus.setBackground(Color.white);
		comboStatus.setFont(font_PLA_15);
		
		return comboStatus;
	}
	
	/**
	 * METODO QUE CRIA UMA CAIXA DE COMBINAÇÃO COM O NOME DAS UFs DO BRASIL E A CONFIGURA
	 **/
	public JComboBox<String> getComboBoxEstadosBR(){
		
		JComboBox<String> combo = new JComboBox<String>();
		
		combo.setBackground(Color.WHITE);
		combo.addItem("");
		combo.addItem("MA");
		combo.addItem("AC");
		combo.addItem("AL");
		combo.addItem("AP");
		combo.addItem("AM");
		combo.addItem("BA");
		combo.addItem("CA");
		combo.addItem("DF");
		combo.addItem("SE");
		combo.addItem("GO");
		combo.addItem("MT");
		combo.addItem("MS");
		combo.addItem("MG");
		combo.addItem("PA");
		combo.addItem("PB");
		combo.addItem("PR");
		combo.addItem("PE");
		combo.addItem("PI");
		combo.addItem("RJ");
		combo.addItem("RN");
		combo.addItem("RS");
		combo.addItem("RO");
		combo.addItem("RR");
		combo.addItem("CS");
		combo.addItem("SP");
		combo.addItem("SE");
		combo.addItem("TO");

		return combo;
	}

	/**
	 * Metodo que cria comboBox com a variedade de Cor/Raça da população
	 **/
	public JComboBox<String> getComboxCorRaca(){
		
		JComboBox<String> combo = new JComboBox<String>();
		
		combo.setBackground(Color.WHITE);
		combo.addItem("");
		combo.addItem("BRANCA");
		combo.addItem("PRETA");
		combo.addItem("PARDA");
		combo.addItem("AMARELA");
		combo.addItem("INDÍGENA");
		
		return combo;
	}

	/**
	 * Metodo que cria comboBox com as Modalidades de Ensino
	 **/
	public JComboBox<String> getComboBoxModalidade(){
		
		JComboBox<String> combo = new JComboBox<String>();
		
		combo.setBackground(Color.WHITE);
		combo.addItem("");
		combo.addItem("NORMAL");
		combo.addItem("EJA");
		
		return combo;
	}
	
	public JComboBox<String> getComboBoxEnsino(){
		
		JComboBox<String> combo = new JComboBox<String>();
		
		combo.setBackground(Color.WHITE);
		combo.addItem("");
		combo.addItem("FUNDAMENTAL");
		combo.addItem("MEDIO");
		
		return combo;
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
	
	public JPanel SalvarLimparBotoes() {
		painelSalvarLimpar = new JPanel(new BorderLayout(2,2));
		painelSalvarLimpar.add("Weast",painelNull(20,20));
		return painelSalvarLimpar;
	}
}
