package Forms;

import java.awt.BorderLayout;
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
 * Classe que representa a tela Ata - Alterar
 * 
 * @author Walysson Oliveira
 * @version 1.5
 * @extends JPanel
 **/

@SuppressWarnings("serial")
public class AlterarAta extends JPanel{

	private static final String DIR_MAIN_ICONES = "../Icones/";
	//DECLARAÇÃO DE VARIÁVEIS
	JButton botaoInserir;
	JButton botaoSalvar;
	JButton botaoExcluir;
	JButton botaoBuscar;
	
	JTextField tf1;
	JTextField tf2;
	JTextField tf3;
	JTextField tf4;
	JTextField tf5;
	JTextField tf6;
		
	public AlterarAta() {
		//LAYOUT DA TELA 
		// ------> OPTEI EM USAR O BORDERLAYOUT PQ PRETENDO INSERIR UM JTABLE NO LADO DIREITO PARA INSERIR OU EXCLUIR UM ALUNO DA ATA
		setLayout(new BorderLayout());
		
		//INICIALIZAÇÃO DE VARIÁVEIS
		Icon iconSalvar = new ImageIcon(getClass().getResource(DIR_MAIN_ICONES+"save3.png"));
		botaoSalvar = new JButton("  Salvar", iconSalvar);
		botaoInserir = new JButton("Inserir Aluno");
		botaoExcluir = new JButton("Excluir Aluno");
		botaoBuscar = new JButton("Buscar");
		
		tf1 = new JTextField();
		tf2 = new JTextField();
		tf3 = new JTextField();
		tf4 = new JTextField();
		tf5 = new JTextField();
		tf6 = new JTextField();
		
		//PAINEIS DE DIVISÃO DE CÉLULA
		JPanel centro = new JPanel();
		centro.setLayout(new GridLayout(20, 4, 5, 5));
		centro.setBackground(Color.WHITE);
		
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
		
		Label nome = new Label("Ata");
		nome.setFont(new Font("san_serif", Font.BOLD, 22));
		nome.setForeground(Color.GRAY);
	
		//ADICIONANDO COMPONENTES AOS PAINEIS DE DIVISÃO DE CÉLULA
		linha.add(botaoBuscar);									linha.add(new Label(""));
		linha1.add(new JLabel("Turma:"));						linha1.add(tf1);						
		linha2.add(new JLabel("Turno:"));						linha2.add(tf2);						
		linha3.add(new JLabel("Ano:"));							linha3.add(tf3);						
		linha4.add(new JLabel("Modalidade de Ensino:"));		linha4.add(tf4);						
		linha5.add(new JLabel("Grau de Ensino:"));				linha5.add(tf5);
		linha6.add(new JLabel("Matrícula do(s) Aluno(s):"));	linha6.add(tf6);
		linha7.add(botaoInserir);								linha7.add(botaoExcluir);
		linha8.add(botaoSalvar);								linha8.add(new Label(""));
		
		//ADICIONANDO COMPONENTES AO COMPONETE CENTRAL
		centro.add(new Label(""));			centro.add(new Label(""));					centro.add(new Label(""));		centro.add(new Label(""));
		centro.add(new Label(""));			centro.add(linha1);							centro.add(new JLabel(""));		centro.add(new Label(""));	
		centro.add(new Label(""));			centro.add(linha2);							centro.add(new JLabel(""));		centro.add(new Label(""));
		centro.add(new Label(""));			centro.add(linha3);							centro.add(linha);				centro.add(new Label(""));
		centro.add(new Label(""));			centro.add(new JLabel(""));					centro.add(new JLabel(""));		centro.add(new Label(""));
		centro.add(new Label(""));			centro.add(nome);							centro.add(new Label(""));		centro.add(new Label(""));			
		centro.add(new Label(""));			centro.add(new Label(""));					centro.add(new Label(""));		centro.add(new Label(""));
		centro.add(new Label(""));			centro.add(linha4);							centro.add(new Label(""));		centro.add(new Label(""));
		centro.add(new Label(""));			centro.add(linha5);							centro.add(new JLabel(""));		centro.add(new Label(""));
		centro.add(new Label(""));			centro.add(new JLabel(""));					centro.add(new JLabel(""));		centro.add(new Label(""));
		centro.add(new Label(""));			centro.add(linha6);							centro.add(linha7);				centro.add(new Label(""));
		centro.add(new Label(""));			centro.add(new JLabel(""));					centro.add(new JLabel(""));		centro.add(new Label(""));
		centro.add(new Label(""));			centro.add(new JLabel(""));					centro.add(linha8);				centro.add(new Label(""));
		centro.add(new Label(""));			centro.add(new JLabel(""));					centro.add(new JLabel(""));		centro.add(new Label(""));
		centro.add(new Label(""));			centro.add(new JLabel(""));					centro.add(new JLabel(""));		centro.add(new Label(""));
		centro.add(new Label(""));			centro.add(new JLabel(""));					centro.add(new JLabel(""));		centro.add(new Label(""));
		centro.add(new Label(""));			centro.add(new JLabel(""));					centro.add(new JLabel(""));		centro.add(new Label(""));
	
		//ADICIONANDO COMPONENTES À TELA
		add(centro, BorderLayout.CENTER);
		
		//DIFININDO O FUNDO DE TELA COMO BRANCO
		setBackground(Color.WHITE);

	}

}
