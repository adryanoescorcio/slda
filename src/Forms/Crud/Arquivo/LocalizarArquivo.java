package Forms.Crud.Arquivo;

import java.awt.Label;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Forms.TelaPadrao;

/**
 * Classe que representa a tela Arquivo - Localizar
 * 
 * @author Walysson Oliveira
 * @version 1.5
 * @extends TelaPadrao
 **/

@SuppressWarnings("serial")
public class LocalizarArquivo extends TelaPadrao{

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

		setLayout(layout);
		
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
		combo.setBackground(corDeFundo);
		combo.addItem("");
		combo.addItem("Testes para ver se o tamanho está bom: Aprovado");
		combo.addItem("Turno: Verpertino - Turma: 203 - Ano:2013");
		combo.addItem("Turno: Matutino - Turma: 34702 - Ano:2014");
		
		//CRIANDO E ADICIONANDO PAINEIS DE DIVISÃO DE CÉLULA
		JPanel linha1L = criarDividirEConfigurarCelula(new JLabel("Matrícula do Aluno:"), tf2);
		JPanel linha1R = criarDividirEConfigurarCelula(botao, new Label(""));
		JPanel linha2 = criarDividirEConfigurarCelula(new JLabel("Código da Caixa:"), tf3);
		JPanel linha3 = criarDividirEConfigurarCelula(new JLabel("Turno:"), tf4);
		JPanel linha4 = criarDividirEConfigurarCelula(new JLabel("Status:"), tf5);
		JPanel linha5 = criarDividirEConfigurarCelula(new JLabel("Código do Dossiê:"), tf6);
		JPanel linha6 = criarDividirEConfigurarCelula(new JLabel("Data de Entrada do Aluno:"), tf7);
	
		Label titulo = getTitulo("Localizar Documentos do Aluno");
											
		//ADICIONANDO COMPONENTES À TELA
		add(new Label(""));					add(new Label(""));									add(new Label(""));			add(new Label(""));
		add(new Label(""));					add(titulo);										add(new Label(""));			add(new Label(""));			
		add(new Label(""));					add(new Label(""));									add(new Label(""));			add(new Label(""));
		add(new Label(""));					add(new JLabel("Nome do Aluno:"));					add(new Label(""));			add(new Label(""));
		add(new Label(""));					add(tf1);											add(new Label(""));			add(new Label(""));
		add(new Label(""));					add(linha1L);										add(linha1R);				add(new Label(""));
		add(new Label(""));					add(new Label(""));									add(new Label(""));			add(new Label(""));
		add(new Label(""));					add(linha2);										add(new Label(""));			add(new Label(""));
		add(new Label(""));					add(linha3);										add(new Label(""));			add(new Label(""));
		add(new Label(""));					add(linha4);										add(new Label(""));			add(new Label(""));
		add(new Label(""));					add(linha5);										add(new Label(""));			add(new Label(""));
		add(new Label(""));					add(linha6);										add(new Label(""));			add(new Label(""));
		add(new Label(""));					add(new Label(""));									add(new Label(""));			add(new Label(""));
		add(new Label(""));					add(new JLabel("Atas que Contém o nome do Aluno:"));add(new Label(""));			add(new Label(""));
		add(new Label(""));					add(combo);											add(new Label(""));			add(new Label(""));
		add(new Label(""));					add(new Label(""));									add(new Label(""));			add(new Label(""));
		add(new Label(""));					add(new Label(""));									add(new Label(""));			add(new Label(""));
		add(new Label(""));					add(new Label(""));									add(new Label(""));			add(new Label(""));
		add(new Label(""));					add(new Label(""));									add(new Label(""));			add(new Label(""));

		setBackground(corDeFundo);

	}

}
