package Views;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Label;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Classe que representa a tela Arquivo - Caixa
 * 
 * @author Walysson Oliveira
 * @version 1.5
 * @extends JPanel
 **/

@SuppressWarnings("serial")
public class CaixaArquivo extends JPanel{

	JButton botaoSalvar;
	JButton botaoInserir;
	JButton botaoInativa;
	
	JTextField tf1;
	JTextField tf2;
	JTextField tf3;
	JTextField tf4;
	JTextField tf5;
	JTextField tf6;
	JTextField tf7;
	JTextField tf8;
	
	public CaixaArquivo() {
		
		setLayout(new GridLayout(20, 4, 5, 5));
		
		Icon iconSalvar = new ImageIcon(getClass().getResource("img/save3.png"));
		botaoSalvar = new JButton("  Salvar", iconSalvar);
		botaoInserir = new JButton("Inserir");
		botaoInativa = new JButton("Definir");
		
		tf1 = new JTextField();
		tf2 = new JTextField();
		tf3 = new JTextField();
		tf4 = new JTextField();
		tf5 = new JTextField();
		tf6 = new JTextField();
		tf7 = new JTextField();
		tf8 = new JTextField();
		
		JPanel linha = new JPanel();
		linha.setLayout(new GridLayout(1, 2, 5, 5));
		linha.setBackground(Color.WHITE);
		
		JPanel linha1 = new JPanel();
		linha1.setLayout(new GridLayout(1, 2, 5, 5));
		linha1.setBackground(Color.WHITE);
		
		JPanel linha2 = new JPanel();
		linha2.setLayout(new GridLayout(1, 2, 5, 5));
		linha2.setBackground(Color.WHITE);
		
		JPanel linha3 = new JPanel();
		linha3.setLayout(new GridLayout(1, 2, 5, 5));
		linha3.setBackground(Color.WHITE);
		
		JPanel linha4 = new JPanel();
		linha4.setLayout(new GridLayout(1, 2, 5, 5));
		linha4.setBackground(Color.WHITE);
		
		JPanel linha5 = new JPanel();
		linha5.setLayout(new GridLayout(1, 2, 5, 5));
		linha5.setBackground(Color.WHITE);
		
		JPanel linha6 = new JPanel();
		linha6.setLayout(new GridLayout(1, 2, 5, 5));
		linha6.setBackground(Color.WHITE);
		
		JPanel linha7 = new JPanel();
		linha7.setLayout(new GridLayout(1, 2, 5, 5));
		linha7.setBackground(Color.WHITE);
		
		JPanel linha8 = new JPanel();
		linha8.setLayout(new GridLayout(1, 2, 5, 5));
		linha8.setBackground(Color.WHITE);
		
		JPanel linha9 = new JPanel();
		linha9.setLayout(new GridLayout(1, 2, 5, 5));
		linha9.setBackground(Color.WHITE);
		
		JPanel linha10 = new JPanel();
		linha10.setLayout(new GridLayout(1, 2, 5, 5));
		linha10.setBackground(Color.WHITE);
		
		Label nome1 = new Label("Adicionar Aluno à Caixa");
		nome1.setFont(new Font("san_serif", Font.BOLD, 19));
		nome1.setForeground(Color.GRAY);

		Label nome2 = new Label("Criar Caixa");
		nome2.setFont(new Font("san_serif", Font.BOLD, 19));
		nome2.setForeground(Color.GRAY);
		
		Label nome3 = new Label("Definir Caixa como Inativa");
		nome3.setFont(new Font("san_serif", Font.BOLD, 19));
		nome3.setForeground(Color.GRAY);
		
		linha1.add(new JLabel("Código da Caixa:"));				linha1.add(tf1);
		linha2.add(new JLabel("Código do Dossiê:"));			linha2.add(tf2);						
		linha3.add(new JLabel("Matrícula do Aluno:"));			linha3.add(tf3);						
		linha4.add(new JLabel("Nome do Aluno:"));				linha4.add(tf4);						
		linha5.add(botaoInserir);								linha5.add(new Label(""));
	
		linha6.add(new JLabel("Código da Caixa:"));				linha6.add(tf5);						
		linha7.add(new JLabel("Turno:"));						linha7.add(tf6);
		linha8.add(botaoSalvar);								linha8.add(new Label(""));
		
		linha9.add(new JLabel("Código da Caixa:"));				linha9.add(tf7);						
		linha10.add(botaoInativa);								linha10.add(new Label(""));

		add(new Label(""));					add(new Label(""));									add(new Label(""));			add(new Label(""));
		add(new Label(""));					add(nome1);											add(new Label(""));			add(new Label(""));			
		add(new Label(""));					add(new Label(""));									add(new Label(""));			add(new Label(""));
		add(new Label(""));					add(linha1);										add(new Label(""));			add(new Label(""));
		add(new Label(""));					add(linha2);										add(new Label(""));			add(new Label(""));
		add(new Label(""));					add(linha3);										add(new Label(""));			add(new Label(""));
		add(new Label(""));					add(linha4);										add(linha5);				add(new Label(""));
		add(new Label(""));					add(new Label(""));									add(new Label(""));			add(new Label(""));
		add(new Label(""));					add(nome2);											add(new Label(""));			add(new Label(""));
		add(new Label(""));					add(new Label(""));									add(new Label(""));			add(new Label(""));
		add(new Label(""));					add(linha6);										add(new Label(""));			add(new Label(""));
		add(new Label(""));					add(linha7);										add(linha8);				add(new Label(""));
		add(new Label(""));					add(new Label(""));									add(new Label(""));			add(new Label(""));
		add(new Label(""));					add(nome3);											add(new Label(""));			add(new Label(""));
		add(new Label(""));					add(new Label(""));									add(new Label(""));			add(new Label(""));
		add(new Label(""));					add(linha9);										add(linha10);				add(new Label(""));
		add(new Label(""));					add(new Label(""));									add(new Label(""));			add(new Label(""));
		add(new Label(""));					add(new Label(""));									add(new Label(""));			add(new Label(""));

		setBackground(Color.WHITE);

	}

}
