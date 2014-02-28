package Forms;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Label;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public abstract class TelaPadrao extends JPanel {

	protected static final String DIR_MAIN_ICONES = "../Icones/";
	protected Icon iconSalvar = new ImageIcon(getClass().getResource(DIR_MAIN_ICONES+"save3.png"));
	protected GridLayout layout = new GridLayout(20, 4, 5, 5);
	protected Color corDeFundo = Color.WHITE;
	
	public Label getTitulo(String titulo){
		Label nome = new Label(titulo);
		nome.setFont(new Font("san_serif", Font.BOLD, 19));
		nome.setForeground(Color.GRAY);
	
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
	};
	
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
	};
	
	//METODO QUE CRIA UMA CAIXA DE COMBINAÇÃO COM O NOME DAS UFs DO BRASIL E A CONFIGURA
	public JComboBox<String> criarEConfigurarComboDeUF(){
		
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
	};

	//METODO QUE CRIA UMA CAIXA DE COMBINAÇÃO COM O NOME DAS UFs DO BRASIL E A CONFIGURA
	public JComboBox<String> criarEConfigurarComboDeCor(){
		
		JComboBox<String> combo = new JComboBox<String>();
		
		combo.setBackground(Color.WHITE);
		combo.addItem("");
		combo.addItem("BRANCA");
		combo.addItem("PRETA");
		combo.addItem("PARDA");
		combo.addItem("AMARELA");
		combo.addItem("INDÍGENA");
		
		return combo;
	};

}
