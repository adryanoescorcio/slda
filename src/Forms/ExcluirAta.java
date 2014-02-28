package Forms;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Label;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Classe que representa a tela Ata - Excluir
 * 
 * @author Walysson Oliveira
 * @version 1.5
 * @extends TelaPadrao
 **/

@SuppressWarnings("serial")
public class ExcluirAta extends TelaPadrao{

	JButton botaoExcluir;
	JButton botaoBuscar;
	
	JTextField tf1;
	JTextField tf2;
	JTextField tf3;
	JTextField tf4;
	JTextField tf5;
	JTextField tf6;
		
	public ExcluirAta() {
		//LAYOUT DA TELA 
		// ------> OPTEI EM USAR O BORDERLAYOUT PQ PRETENDO INSERIR UM JTABLE NO LADO DIREITO PARA INSERIR OU EXCLUIR UM ALUNO DA ATA
		setLayout(new BorderLayout());
		
		//INICIALIZAÇÃO DE VARIÁVEIS
		botaoExcluir = new JButton("Excluir");
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
		centro.setBackground(corDeFundo);
				
		//CRIANDO E ADICIONANDO PAINEIS DE DIVISÃO DE CÉLULA
		JPanel linha1 = criarDividirEConfigurarCelula(new JLabel("Turma:"), tf1);
		JPanel linha2 = criarDividirEConfigurarCelula(new JLabel("Turno:"), tf2);
		JPanel linha3L = criarDividirEConfigurarCelula(new JLabel("Ano:"), tf3);
		JPanel linha3R = criarDividirEConfigurarCelula(botaoBuscar ,new Label(""));
		JPanel linha4 = criarDividirEConfigurarCelula(new JLabel("Modalidade de Ensino:"), tf4);
		JPanel linha5 = criarDividirEConfigurarCelula(new JLabel("Grau de Ensino:"), tf5);
		JPanel linha6 = criarDividirEConfigurarCelula(new JLabel("Matrícula do(s) Aluno(s):"), tf6);
		
		Label titulo = getTitulo("Ata");
			
		//ADICIONANDO COMPONENTES AO COMPONETE CENTRAL
		centro.add(new Label(""));			centro.add(new Label(""));					centro.add(new Label(""));		centro.add(new Label(""));
		centro.add(new Label(""));			centro.add(linha1);							centro.add(new JLabel(""));		centro.add(new Label(""));	
		centro.add(new Label(""));			centro.add(linha2);							centro.add(new JLabel(""));		centro.add(new Label(""));
		centro.add(new Label(""));			centro.add(linha3L);						centro.add(linha3R);			centro.add(new Label(""));
		centro.add(new Label(""));			centro.add(new JLabel(""));					centro.add(new JLabel(""));		centro.add(new Label(""));
		centro.add(new Label(""));			centro.add(titulo);							centro.add(new Label(""));		centro.add(new Label(""));			
		centro.add(new Label(""));			centro.add(new Label(""));					centro.add(new Label(""));		centro.add(new Label(""));
		centro.add(new Label(""));			centro.add(linha4);							centro.add(new Label(""));		centro.add(new Label(""));
		centro.add(new Label(""));			centro.add(linha5);							centro.add(new JLabel(""));		centro.add(new Label(""));
		centro.add(new Label(""));			centro.add(new JLabel(""));					centro.add(new JLabel(""));		centro.add(new Label(""));
		centro.add(new Label(""));			centro.add(linha6);							centro.add(new JLabel(""));		centro.add(new Label(""));
		centro.add(new Label(""));			centro.add(new JLabel(""));					centro.add(new JLabel(""));		centro.add(new Label(""));
		centro.add(new Label(""));			centro.add(new JLabel(""));					centro.add(new JLabel(""));		centro.add(new Label(""));
		centro.add(new Label(""));			centro.add(new JLabel(""));					centro.add(new JLabel(""));		centro.add(new Label(""));
		centro.add(new Label(""));			centro.add(new JLabel(""));					centro.add(new JLabel(""));		centro.add(new Label(""));
		centro.add(new Label(""));			centro.add(new JLabel(""));					centro.add(new JLabel(""));		centro.add(new Label(""));
		centro.add(new Label(""));			centro.add(new JLabel(""));					centro.add(new JLabel(""));		centro.add(new Label(""));
		
		//ADICIONANDO COMPONENTES À TELA
		add(centro, BorderLayout.CENTER);
		
		//DIFININDO O FUNDO DE TELA COMO BRANCO
		setBackground(corDeFundo);

	}

}
