package Forms;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Label;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Classe que representa a tela Arquivo - Localizar
 * 
 * @author Walysson Oliveira
 * @version 1.5
 * @extends JPanel
 **/

@SuppressWarnings("serial")
public class LocalizarArquivo extends JPanel{

	//DECLARAÇÃO DE VARIÁVEIS
	JTextField tf1;
	JTextField tf2;
	JTextField tf3;
	JTextField tf4;
	JTextField tf5;
	JTextField tf6;
	JTextField tf7;
	JTextField tf8;
		
	JButton botao;
	
	JComboBox<String> combo;
	
	public LocalizarArquivo() {

		setLayout(new GridLayout(20, 4, 5, 5));
		
		//INICIALIZAÇÃO DE VARIÁVEIS
		tf1 = new JTextField();
		tf2 = new JTextField();
		tf3 = new JTextField();
		tf4 = new JTextField();
		tf5 = new JTextField();
		tf6 = new JTextField();
		tf7 = new JTextField();
		tf8 = new JTextField();
		
		botao = new JButton("Localizar");
		
		combo = new JComboBox<String>();
		
		//CONFIGURAÇÕES DE VARIÁVEIS
		//------>ESSA CAIXA DE SELEÇÃO TAMBÉM PODE SER SUBSTITUIDA POR UMA JTABLE
		//------>ELA MOSTRA AS ATAS COM O NOME DO ALUNO
		
		/*------>COLOQUEI ALGUNS ITENS SÓ PRA VER SE O TAMANHO ESTÁ BOM, MAS ELA TEM QUE SER INICIALIZADA VAZIA
		 * E PREENCHIDA PELAS ATAS DO BD COM O NOME DO ALUNO
		 */
		combo.setBackground(Color.WHITE);
		combo.addItem("");
		combo.addItem("Testes para ver se o tamanho está bom: Aprovado");
		combo.addItem("Turno: Verpertino - Turma: 203 - Ano:2013");
		combo.addItem("Turno: Matutino - Turma: 34702 - Ano:2014");
		
		//PAINEIS DE DIVISÃO DE CÉLULA
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
		
		Label nome = new Label("Localizar Documentos do Aluno");
		nome.setFont(new Font("san_serif", Font.BOLD, 19));
		nome.setForeground(Color.GRAY);
	
		//ADICIONANDO COMPONENTES AOS PAINEIS DE DIVISÃO DE CÉLULA
		linha1.add(new JLabel("Matrícula do Aluno:"));			linha1.add(tf2);						
		linha2.add(botao);										linha2.add(new Label(""));
		linha3.add(new JLabel("Código da Caixa:"));				linha3.add(tf3);						
		linha4.add(new JLabel("Turno:"));						linha4.add(tf4);
		linha5.add(new JLabel("Status:"));						linha5.add(tf5);
		linha6.add(new JLabel("Código do Dossiê:"));			linha6.add(tf6);
		linha7.add(new JLabel("Data de Entrada do Aluno:"));	linha7.add(tf7);
	
		//ADICIONANDO COMPONENTES À TELA
		add(new Label(""));					add(new Label(""));									add(new Label(""));			add(new Label(""));
		add(new Label(""));					add(nome);											add(new Label(""));			add(new Label(""));			
		add(new Label(""));					add(new Label(""));									add(new Label(""));			add(new Label(""));
		add(new Label(""));					add(new JLabel("Nome do Aluno:"));					add(new Label(""));			add(new Label(""));
		add(new Label(""));					add(tf1);											add(new Label(""));			add(new Label(""));
		add(new Label(""));					add(linha1);										add(linha2);				add(new Label(""));
		add(new Label(""));					add(new Label(""));									add(new Label(""));			add(new Label(""));
		add(new Label(""));					add(linha3);										add(new Label(""));			add(new Label(""));
		add(new Label(""));					add(linha4);										add(new Label(""));			add(new Label(""));
		add(new Label(""));					add(linha5);										add(new Label(""));			add(new Label(""));
		add(new Label(""));					add(linha6);										add(new Label(""));			add(new Label(""));
		add(new Label(""));					add(linha7);										add(new Label(""));			add(new Label(""));
		add(new Label(""));					add(new Label(""));									add(new Label(""));			add(new Label(""));
		add(new Label(""));					add(new JLabel("Atas que Contém o nome do Aluno:"));add(new Label(""));			add(new Label(""));
		add(new Label(""));					add(combo);											add(new Label(""));			add(new Label(""));
		add(new Label(""));					add(new Label(""));									add(new Label(""));			add(new Label(""));
		add(new Label(""));					add(new Label(""));									add(new Label(""));			add(new Label(""));
		add(new Label(""));					add(new Label(""));									add(new Label(""));			add(new Label(""));
		add(new Label(""));					add(new Label(""));									add(new Label(""));			add(new Label(""));

		setBackground(Color.WHITE);

	}

}
