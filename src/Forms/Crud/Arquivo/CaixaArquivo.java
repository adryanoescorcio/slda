package Forms.Crud.Arquivo;

import java.awt.Label;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Forms.TelaPadrao;

/**
 * Classe que representa a tela Arquivo - Caixa
 * 
 * @author Walysson Oliveira
 * @version 1.5
 * @extends TelaPadrao
 **/

@SuppressWarnings("serial")
public class CaixaArquivo extends TelaPadrao{
	
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
		
		setLayout(layout);
		
		botaoSalvar = new JButton("  Salvar", null);
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
		
		//CRIANDO E ADICIONANDO PAINEIS DE DIVISÃO DE CÉLULA
		JPanel linha1 = criarDividirEConfigurarCelula(new JLabel("Código da Caixa:"), tf1);
		JPanel linha2 = criarDividirEConfigurarCelula(new JLabel("ódigo do Dossiê:"), tf2);
		JPanel linha3 = criarDividirEConfigurarCelula(new JLabel("Matrícula do Aluno:"), tf3);
		JPanel linha4 = criarDividirEConfigurarCelula(new JLabel("Nome do Aluno:"), tf4);
		JPanel linha5 = criarDividirEConfigurarCelula(botaoInserir, new Label(""));
		JPanel linha6 = criarDividirEConfigurarCelula(new JLabel("Código da Caixa:"), tf5);
		JPanel linha7 = criarDividirEConfigurarCelula(new JLabel("Turno:"), tf6);
		JPanel linha8 = criarDividirEConfigurarCelula(botaoSalvar, new Label(""));
		JPanel linha9 = criarDividirEConfigurarCelula(new JLabel("Código da Caixa:"), tf7);
		JPanel linha10 = criarDividirEConfigurarCelula(botaoInativa, new Label(""));
		
		Label titulo1 = getTitulo("Adicionar Aluno à Caixa");
		Label titulo2 = getTitulo("Criar Caixa");
		Label titulo3 = getTitulo("Definir Caixa como Inativa");
				
		add(new Label(""));					add(new Label(""));									add(new Label(""));			add(new Label(""));
		add(new Label(""));					add(titulo1);										add(new Label(""));			add(new Label(""));			
		add(new Label(""));					add(new Label(""));									add(new Label(""));			add(new Label(""));
		add(new Label(""));					add(linha1);										add(new Label(""));			add(new Label(""));
		add(new Label(""));					add(linha2);										add(new Label(""));			add(new Label(""));
		add(new Label(""));					add(linha3);										add(new Label(""));			add(new Label(""));
		add(new Label(""));					add(linha4);										add(linha5);				add(new Label(""));
		add(new Label(""));					add(new Label(""));									add(new Label(""));			add(new Label(""));
		add(new Label(""));					add(titulo2);										add(new Label(""));			add(new Label(""));
		add(new Label(""));					add(new Label(""));									add(new Label(""));			add(new Label(""));
		add(new Label(""));					add(linha6);										add(new Label(""));			add(new Label(""));
		add(new Label(""));					add(linha7);										add(linha8);				add(new Label(""));
		add(new Label(""));					add(new Label(""));									add(new Label(""));			add(new Label(""));
		add(new Label(""));					add(titulo3);										add(new Label(""));			add(new Label(""));
		add(new Label(""));					add(new Label(""));									add(new Label(""));			add(new Label(""));
		add(new Label(""));					add(linha9);										add(linha10);				add(new Label(""));
		add(new Label(""));					add(new Label(""));									add(new Label(""));			add(new Label(""));
		add(new Label(""));					add(new Label(""));									add(new Label(""));			add(new Label(""));

		setBackground(COR_DE_FUNDO);

	}

}
