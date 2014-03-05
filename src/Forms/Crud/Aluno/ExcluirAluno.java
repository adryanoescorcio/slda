package Forms.Crud.Aluno;

import java.awt.Label;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import Forms.TelaPadrao;

/**
 * Classe que representa a tela Aluno - Cadastrar
 * 
 * @author Walysson Oliveira
 * @version 1.5
 * @extends TelaPadrao
 **/

@SuppressWarnings("serial")
public class ExcluirAluno extends TelaPadrao{

		//DECLARAÇÃO DE VARIÁVEIS
		JButton botaoExcluir;
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
			
		//MÉTODO CONSTRUTOR DA CLASSE
		public ExcluirAluno() {
		
		setLayout(layout);
		
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
		
		combo1 = criarEConfigurarComboDeUF();
		combo2 = criarEConfigurarComboDeCor();
		combo3 = criarEConfigurarComboDeUF();
		combo4 = criarEConfigurarComboDeUF();
		
		grupo = new ButtonGroup();
		
		radioM = new JRadioButton("M");
		radioF = new JRadioButton("F");
		
		//CONFIGURAÇÕES DE VARIÁVEIS
		grupo.add(radioF);
		grupo.add(radioM);
		radioF.setBackground(corDeFundo);
		radioM.setBackground(corDeFundo);

		botaoExcluir = new JButton("Excluir");
		botaoBuscar = new JButton("Buscar");
		
		//CRIANDO E ADICIONANDO PAINEIS DE DIVISÃO DE CÉLULA
		JPanel linha1L = criarDividirEConfigurarCelula(new JLabel("  Matricula:"), tff1);
		JPanel linha1R = criarDividirEConfigurarCelula(botaoBuscar, new Label(""));
		JPanel linha2 = criarDividirEConfigurarCelula(new JLabel("  INEP:"), tff2);
		JPanel linha3L = criarDividirEConfigurarCelula(new JLabel("  CPF:"), tff3);
		JPanel linha3R = criarDividirEConfigurarCelula(new JLabel("  Rg:"), tff4);
		JPanel linha4L = criarDividirEConfigurarCelula(new JLabel("  UF de Nascimento"), combo1);
		JPanel linha4R = criarDividirEConfigurarCelula(new JLabel("  Cidade de Nascimento"), tf2);
		JPanel linha5L = criarDividirEConfigurarCelula(new JLabel("  Data de Nascimento"), tff5);
		JPanel linha5R = criarDividirEConfigurarCelula(new JLabel("  Sexo:"), new Label(""), radioM, radioF);
		JPanel linha6L =criarDividirEConfigurarCelula(new JLabel("  Cor:"), combo2);
		JPanel linha6R = criarDividirEConfigurarCelula(new JLabel("  Telefone"), tff6);
		JPanel linha8 = criarDividirEConfigurarCelula(combo3, new Label(""));
		JPanel linha9 =criarDividirEConfigurarCelula(combo4, new Label(""));
		JPanel linha10 =criarDividirEConfigurarCelula(tf6, new Label(""));
		JPanel linha11 = criarDividirEConfigurarCelula(tf7, new Label(""));
		JPanel linha12 = criarDividirEConfigurarCelula(botaoExcluir, new Label(""));
		
		Label titulo = getTitulo("Aluno");
								
		//ADICIONANDO COMPONENTES À TELA
		add(new Label(""));									add(linha1L);										add(linha1R);											add(new Label(""));
		add(new Label(""));									add(new Label(""));									add(new Label(""));										add(new Label(""));
		add(new Label(""));									add(titulo);											add(new Label(""));										add(new Label(""));			
		add(new Label(""));									add(new JLabel("  Nome:"));							add(tf1);												add(new Label(""));	
		add(new Label(""));									add(new Label(""));									add(linha2);											add(new Label(""));
		add(new Label(""));									add(linha3L);										add(linha3R);											add(new Label(""));
		add(new Label(""));									add(linha4L);										add(linha4R);											add(new Label(""));
		add(new Label(""));									add(linha5L);										add(linha5R);											add(new Label(""));
		add(new Label(""));									add(linha6L);										add(linha6R);											add(new Label(""));	
		add(new Label(""));									add(new JLabel("  Endereço:"));						add(tf3);												add(new Label(""));
		add(new Label(""));									add(new JLabel("  Nome da Mãe:"));					add(tf4);												add(new Label(""));
		add(new Label(""));									add(new JLabel("  Nome do Pai:"));					add(tf5);												add(new Label(""));
		add(new Label(""));									add(new JLabel("  UF de Nascimento da Mãe:"));		add(linha8);											add(new Label(""));
		add(new Label(""));									add(new JLabel("  UF de Nascimento do Pai:"));		add(linha9);											add(new Label(""));
		add(new Label(""));									add(new JLabel("  Cidade de Nascimento da Mãe:"));	add(linha10);											add(new Label(""));
		add(new Label(""));									add(new JLabel("  Cidade de Nascimento do Pai:"));	add(linha11);											add(new Label(""));
		add(new Label(""));									add(new Label(""));									add(new Label(""));										add(new Label(""));
		add(new Label(""));									add(new Label(""));									add(linha12);											add(new Label(""));

		//DIFININDO O FUNDO DE TELA COMO BRANCO
		setBackground(corDeFundo);

	}

}
