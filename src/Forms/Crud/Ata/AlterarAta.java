package Forms.Crud.Ata;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Label;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Forms.TelaPadrao;

/**
 * Classe que representa a tela Ata - Alterar
 * 
 * @author Walysson Oliveira
 * @version 1.5
 * @extends TelaPadrao
 **/

@SuppressWarnings("serial")
public class AlterarAta extends TelaPadrao{

	//DECLARA��O DE VARI�VEIS
	JButton botaoInserir;
	JButton botaoSalvar;
	JButton botaoExcluir;
	JButton botaoBuscar;
	
	JTextField tf1;
	JTextField tf2;
	JFormattedTextField tff1;
	JComboBox<String> comboTurno;
	JComboBox<String> comboModalidade;
	JComboBox<String> comboEnsino;
		
	public AlterarAta() {
		//LAYOUT DA TELA 
		// ------> OPTEI EM USAR O BORDERLAYOUT PQ PRETENDO INSERIR UM JTABLE NO LADO DIREITO PARA INSERIR OU EXCLUIR UM ALUNO DA ATA
		setLayout(new BorderLayout());
		
		//INICIALIZA��O DE VARI�VEIS
		botaoSalvar = new JButton("  Salvar", null);
		botaoInserir = new JButton("Inserir Aluno");
		botaoExcluir = new JButton("Excluir Aluno");
		botaoBuscar = new JButton("Buscar");
		
		tf1 = new JTextField();
		tf2 = new JTextField();
		tff1 = new JFormattedTextField();
		
		comboTurno = getComboBoxTurno();
		comboModalidade = getComboBoxModalidade();
		comboEnsino = getComboBoxEnsino();		
		
		
		//PAINEIS DE DIVIS�O DE C�LULA
		JPanel centro = new JPanel();
		centro.setLayout(new GridLayout(20, 4, 5, 5));
		centro.setBackground(COR_DE_FUNDO);
		
		//CRIANDO E ADICIONANDO PAINEIS DE DIVIS�O DE C�LULA
		JPanel linha1 = criarDividirEConfigurarCelula(new JLabel("Turma:"), tf1);
		JPanel linha2 = criarDividirEConfigurarCelula(new JLabel("Turno:"), comboTurno);
		JPanel linha3L = criarDividirEConfigurarCelula(new JLabel("Ano:"), tff1);
		JPanel linha3R = criarDividirEConfigurarCelula(botaoBuscar ,new Label(""));
		JPanel linha4 = criarDividirEConfigurarCelula(new JLabel("Modalidade de Ensino:"), comboModalidade);
		JPanel linha5 = criarDividirEConfigurarCelula(new JLabel("Grau de Ensino:"), comboEnsino);
		JPanel linha6L = criarDividirEConfigurarCelula(new JLabel("Matr�cula do(s) Aluno(s):"), tf2);
		JPanel linha6R = criarDividirEConfigurarCelula(botaoInserir, botaoExcluir);
		JPanel linha7 = criarDividirEConfigurarCelula(botaoSalvar, new Label(""));
		
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
		centro.add(new Label(""));			centro.add(linha6L);						centro.add(linha6R);			centro.add(new Label(""));
		centro.add(new Label(""));			centro.add(new JLabel(""));					centro.add(new JLabel(""));		centro.add(new Label(""));
		centro.add(new Label(""));			centro.add(new JLabel(""));					centro.add(linha7);				centro.add(new Label(""));
		centro.add(new Label(""));			centro.add(new JLabel(""));					centro.add(new JLabel(""));		centro.add(new Label(""));
		centro.add(new Label(""));			centro.add(new JLabel(""));					centro.add(new JLabel(""));		centro.add(new Label(""));
		centro.add(new Label(""));			centro.add(new JLabel(""));					centro.add(new JLabel(""));		centro.add(new Label(""));
		centro.add(new Label(""));			centro.add(new JLabel(""));					centro.add(new JLabel(""));		centro.add(new Label(""));
	
		//ADICIONANDO COMPONENTES � TELA
		add(centro, BorderLayout.CENTER);
		
		//DIFININDO O FUNDO DE TELA COMO BRANCO
		setBackground(COR_DE_FUNDO);

	}

}
