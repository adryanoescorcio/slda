package Views;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Label;

import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 * Classe que representa a tela Aluno - Alterar
 * 
 * @author Walysson Oliveira
 * @version 1.5
 * @extends JPanel
 **/

@SuppressWarnings("serial")
public class AlterarAluno extends JPanel{

	//DECLARAÇÃO DE VARIÁVEIS
	JButton botaoSalvar;
	JButton botaoBuscar;
	JFormattedTextField tff1;
	JFormattedTextField tff2;
	JFormattedTextField tff3;
	JFormattedTextField tff4;
	JFormattedTextField tff5;
	JFormattedTextField tff6;
	
	JTextField tf1;
	JTextField tf2;
	JTextField tf3;
	JTextField tf4;
	JTextField tf5;
	JTextField tf6;
	JTextField tf7;
	JTextField tf8;
	JTextField tf9;
	
	JComboBox<String> combo1;
	JComboBox<String> combo2;
	JComboBox<String> combo3;
	JComboBox<String> combo4;
	
	ButtonGroup grupo;
	JRadioButton radioM;
	JRadioButton radioF;
	
	public AlterarAluno() {
		
		//LAYOUT DA TELA
		setLayout(new GridLayout(20, 4, 5, 5));
	
		//INICIALIZAÇÃO DE VARIÁVEIS
		tff1 = new JFormattedTextField();
		tff2 = new JFormattedTextField();
		tff3 = new JFormattedTextField();
		tff4 = new JFormattedTextField();
		tff5 = new JFormattedTextField();
		tff6 = new JFormattedTextField();
		
		tf1 = new JTextField();
		tf2 = new JTextField();
		tf3 = new JTextField();
		tf4 = new JTextField();
		tf5 = new JTextField();
		tf6 = new JTextField();
		tf7 = new JTextField();
		tf8 = new JTextField();
		tf9 = new JTextField();
		
		combo1 = new JComboBox<String>();
		combo2 = new JComboBox<String>();
		combo3 = new JComboBox<String>();
		combo4 = new JComboBox<String>();
		
		grupo = new ButtonGroup();
		
		radioM = new JRadioButton("M");
		radioF = new JRadioButton("F");
		
		//CONFIGURAÇÕES DE VARIÁVEIS
		grupo.add(radioF);
		grupo.add(radioM);
		radioF.setBackground(Color.WHITE);
		radioM.setBackground(Color.WHITE);
		
		combo1.setBackground(Color.WHITE);
		combo1.addItem("");
		combo1.addItem("MA");
		combo1.addItem("AC");
		combo1.addItem("AL");
		combo1.addItem("AP");
		combo1.addItem("AM");
		combo1.addItem("BA");
		combo1.addItem("CA");
		combo1.addItem("DF");
		combo1.addItem("SE");
		combo1.addItem("GO");
		combo1.addItem("MT");
		combo1.addItem("MS");
		combo1.addItem("MG");
		combo1.addItem("PA");
		combo1.addItem("PB");
		combo1.addItem("PR");
		combo1.addItem("PE");
		combo1.addItem("PI");
		combo1.addItem("RJ");
		combo1.addItem("RN");
		combo1.addItem("RS");
		combo1.addItem("RO");
		combo1.addItem("RR");
		combo1.addItem("CS");
		combo1.addItem("SP");
		combo1.addItem("SE");
		combo1.addItem("TO");
		
		combo2.setBackground(Color.WHITE);
		combo2.addItem("");
		combo2.addItem("BRANCA");
		combo2.addItem("PRETA");
		combo2.addItem("PARDA");
		combo2.addItem("AMARELA");
		combo2.addItem("INDÍGENA");
		
		combo3.setBackground(Color.WHITE);
		combo3.addItem("");
		combo3.addItem("MA");
		combo3.addItem("AC");
		combo3.addItem("AL");
		combo3.addItem("AP");
		combo3.addItem("AM");
		combo3.addItem("BA");
		combo3.addItem("CA");
		combo3.addItem("DF");
		combo3.addItem("SE");
		combo3.addItem("GO");
		combo3.addItem("MT");
		combo3.addItem("MS");
		combo3.addItem("MG");
		combo3.addItem("PA");
		combo3.addItem("PB");
		combo3.addItem("PR");
		combo3.addItem("PE");
		combo3.addItem("PI");
		combo3.addItem("RJ");
		combo3.addItem("RN");
		combo3.addItem("RS");
		combo3.addItem("RO");
		combo3.addItem("RR");
		combo3.addItem("CS");
		combo3.addItem("SP");
		combo3.addItem("SE");
		combo3.addItem("TO");
		
		combo4.setBackground(Color.WHITE);
		combo4.addItem("");
		combo4.addItem("MA");
		combo4.addItem("AC");
		combo4.addItem("AL");
		combo4.addItem("AP");
		combo4.addItem("AM");
		combo4.addItem("BA");
		combo4.addItem("CA");
		combo4.addItem("DF");
		combo4.addItem("SE");
		combo4.addItem("GO");
		combo4.addItem("MT");
		combo4.addItem("MS");
		combo4.addItem("MG");
		combo4.addItem("PA");
		combo4.addItem("PB");
		combo4.addItem("PR");
		combo4.addItem("PE");
		combo4.addItem("PI");
		combo4.addItem("RJ");
		combo4.addItem("RN");
		combo4.addItem("RS");
		combo4.addItem("RO");
		combo4.addItem("RR");
		combo4.addItem("CS");
		combo4.addItem("SP");
		combo4.addItem("SE");
		combo4.addItem("TO");
		
		Icon iconSalvar = new ImageIcon(getClass().getResource("img/save3.png"));
		botaoSalvar = new JButton(" Salvar", iconSalvar);
		botaoBuscar = new JButton("Buscar");
		
		//PAINEIS DE DIVISÃO DE CÉLULA
		JPanel linha1 = new JPanel();
		linha1.setLayout(new GridLayout(1, 2, 5, 5));
		linha1.setBackground(Color.WHITE);
		
		JPanel linha21 = new JPanel();
		linha21.setLayout(new GridLayout(1, 2, 5, 5));
		linha21.setBackground(Color.WHITE);
		
		JPanel linha22 = new JPanel();
		linha22.setLayout(new GridLayout(1, 2, 5, 5));
		linha22.setBackground(Color.WHITE);
		
		JPanel linha31 = new JPanel();
		linha31.setLayout(new GridLayout(1, 2, 5, 5));
		linha31.setBackground(Color.WHITE);
		
		JPanel linha32 = new JPanel();
		linha32.setLayout(new GridLayout(1, 2, 5, 5));
		linha32.setBackground(Color.WHITE);
		
		JPanel linha41 = new JPanel();
		linha41.setLayout(new GridLayout(1, 2, 5, 5));
		linha41.setBackground(Color.WHITE);
		
		JPanel linha42 = new JPanel();
		linha42.setLayout(new GridLayout(1, 2, 5, 5));
		linha42.setBackground(Color.WHITE);
		
		JPanel linha51 = new JPanel();
		linha51.setLayout(new GridLayout(1, 2, 5, 5));
		linha51.setBackground(Color.WHITE);
		
		JPanel linha52 = new JPanel();
		linha52.setLayout(new GridLayout(1, 4, 5, 5));
		linha52.setBackground(Color.WHITE);
		
		JPanel linha61 = new JPanel();
		linha61.setLayout(new GridLayout(1, 2, 5, 5));
		linha61.setBackground(Color.WHITE);
		
		JPanel linha62 = new JPanel();
		linha62.setLayout(new GridLayout(1, 2, 5, 5));
		linha62.setBackground(Color.WHITE);
		
		JPanel linha8 = new JPanel();
		linha8.setLayout(new GridLayout(1, 2, 5, 5));
		linha8.setBackground(Color.WHITE);
	
		JPanel linha9 = new JPanel();
		linha9.setLayout(new GridLayout(1, 2, 5, 5));
		linha9.setBackground(Color.WHITE);
		
		JPanel linha10 = new JPanel();
		linha10.setLayout(new GridLayout(1, 2, 5, 5));
		linha10.setBackground(Color.WHITE);
		
		JPanel linha11 = new JPanel();
		linha11.setLayout(new GridLayout(1, 2, 5, 5));
		linha11.setBackground(Color.WHITE);
		
		JPanel linha12 = new JPanel();
		linha12.setLayout(new GridLayout(1, 2, 5, 5));
		linha12.setBackground(Color.WHITE);
				
		Label nome = new Label("Aluno");
		nome.setFont(new Font("san_serif", Font.BOLD, 22));
		nome.setForeground(Color.GRAY);
		
		//ADICIONANDO COMPONENTES AOS PAINEIS DE DIVISÃO DE CÉLULA
		linha1.add(botaoBuscar);								linha1.add(new Label(""));	
		linha21.add(new JLabel("  Matricula:"));				linha21.add(tff1);		linha22.add(new JLabel("  INEP:"));	 					linha22.add(tff2);		
		linha31.add(new JLabel("  CPF:"));						linha31.add(tff3);		linha32.add(new JLabel("  Rg:"));						linha32.add(tff4);
		linha41.add(new JLabel("  UF de Nascimento"));			linha41.add(combo1);	linha42.add(new JLabel("  Cidade de Nascimento"));		linha42.add(tf2);						
		linha51.add(new JLabel("  Data de Nascimento"));		linha51.add(tff5);		linha52.add(new JLabel("  Sexo:"));						linha52.add(new Label(""));	linha52.add(radioM); linha52.add(radioF);				
		linha61.add(new JLabel("  Cor:"));						linha61.add(combo2);	linha62.add(new JLabel("  Telefone"));					linha62.add(tff6);			
		linha8.add(combo3);										linha8.add(new Label(""));	
		linha9.add(combo4);										linha9.add(new Label(""));	
		linha10.add(tf6);										linha10.add(new Label(""));	
		linha11.add(tf7);										linha11.add(new Label(""));	
		linha12.add(botaoSalvar);								linha12.add(new Label(""));										
		
		//ADICIONANDO COMPONENTES À TELA
		add(new Label(""));					add(linha21);										add(linha1);				add(new Label(""));
		add(new Label(""));					add(new Label(""));									add(new Label(""));			add(new Label(""));
		add(new Label(""));					add(nome);											add(new Label(""));			add(new Label(""));			
		add(new Label(""));					add(new JLabel("  Nome:"));							add(tf1);					add(new Label(""));	
		add(new Label(""));					add(new Label(""));									add(linha22);				add(new Label(""));
		add(new Label(""));					add(linha31);										add(linha32);				add(new Label(""));
		add(new Label(""));					add(linha41);										add(linha42);				add(new Label(""));
		add(new Label(""));					add(linha51);										add(linha52);				add(new Label(""));
		add(new Label(""));					add(linha61);										add(linha62);				add(new Label(""));	
		add(new Label(""));					add(new JLabel("  Endereço:"));						add(tf3);					add(new Label(""));
		add(new Label(""));					add(new JLabel("  Nome da Mãe:"));					add(tf4);					add(new Label(""));
		add(new Label(""));					add(new JLabel("  Nome do Pai:"));					add(tf5);					add(new Label(""));
		add(new Label(""));					add(new JLabel("  UF de Nascimento da Mãe:"));		add(linha8);				add(new Label(""));
		add(new Label(""));					add(new JLabel("  UF de Nascimento do Pai:"));		add(linha9);				add(new Label(""));
		add(new Label(""));					add(new JLabel("  Cidade de Nascimento da Mãe:"));	add(linha10);				add(new Label(""));
		add(new Label(""));					add(new JLabel("  Cidade de Nascimento do Pai:"));	add(linha11);				add(new Label(""));
		add(new Label(""));					add(new Label(""));									add(new Label(""));			add(new Label(""));
		add(new Label(""));					add(new Label(""));									add(linha12);				add(new Label(""));

		//DIFININDO O FUNDO DE TELA COMO BRANCO
		setBackground(Color.WHITE);

	}

}
