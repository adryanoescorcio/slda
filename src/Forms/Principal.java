package Forms;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import Forms.Crud.Aluno.CadastrarAluno;
import Forms.Crud.Arquivo.LocalizarArquivo;
import Forms.Crud.Ata.CadastrarAta;
import Forms.Menus.MenuAvancado;
import Forms.Menus.MenuExportar;
import Forms.Menus.MenuImportar;
import Forms.Menus.MenuUsuario;
import Forms.Menus.MenuVisualizar;

/**
 * Classe que representa a tela Principal - Aquela que chama todas as outras
 * 
 * @author Walysson Oliveira
 * @version 1.5
 * @extends JFrame
 **/
public class Principal {
	
	// WINDOWS 
	private JFrame mainJFrame = new JFrame();
	
	// constantes
	private static final String TITULO_WINDOW = "SLDA - Sistema de Localização de Documentos do Aluno";
	private static final String DIR_MAIN_ICONES = "../Icones/";
	private static final int TOP = JTabbedPane.TOP;

	/**
	 * CRIADO UM PAINEL EM CAMADAS(JTABBEDPANE) PRINCIPAL - TOP
	 * EM QUE CADA CAMADA TEM OUTROS PAINEIS EM CAMADAS(JTABBEDPANE) LATERAIS
	 **/
	private JTabbedPane camadaExterna = new JTabbedPane(TOP);
	
	private Icon iconAluno;
	private Icon iconAta;
	private Icon iconArquivo;

	// Menu Principal
	private JMenuBar menuBar = new JMenuBar();
	// Itens do Menu Principal
	private MenuUsuario menuUsuario = new MenuUsuario();
	private MenuExportar menuExportar = new MenuExportar();
	private MenuImportar menuImportar = new MenuImportar();
	private MenuVisualizar menuVisualizar = new MenuVisualizar();
	private MenuAvancado menuAvancado = new MenuAvancado();
	
	/**
	 * Painel Principal e mais externo da JFrame. 
	 **/
	private JPanel mainJPanel = new JPanel(new BorderLayout(2, 2));
	
	//INSTANCIANDO OS PAINEIS CRUD
	// ALUNO
	private LocalizarArquivo localizarAluno = new LocalizarArquivo();
	private CadastrarAluno cadastrarAluno = new CadastrarAluno();
	private CadastrarAta cadastrarAta = new CadastrarAta();
	
	private Font font = new Font(Font.SANS_SERIF, 0, 18);
	
	public Principal(){
		
		menusWindows();
		criandoIcones();
		alterandoFontes();
		addComponentesMainJPanel();
		configuracaoMainJFrame();
		
		//SETANDO AS CAMADAS COM O FUNDO BRANCO
		camadaExterna.setOpaque(true);

		//DEFININDO OS PAINEIS DA CAMADA EXTERNA 
		camadaExterna.addTab("Caixa",  iconArquivo, localizarAluno.getTelaPrincipal());
		camadaExterna.addTab("Discente", iconAluno, cadastrarAluno.getTelaPrincipal());
		camadaExterna.addTab("Ata", iconAta, cadastrarAta.getTelaPrincipal());
	}
	
	private void alterandoFontes() {
		camadaExterna.setFont(font);
	}

	private void addComponentesMainJPanel() {
		//ADICIONANDO A CAMADA EXTERNA À JANELA(JFrame)
		mainJPanel.add(camadaExterna);
	}

	private void configuracaoMainJFrame() {
		mainJFrame.setTitle(TITULO_WINDOW);
		mainJFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainJFrame.setVisible(true);
		mainJFrame.setSize(1050, 700);
		
		// Inserindo o MenuBar na Janela
		mainJFrame.setJMenuBar(menuBar);
		// Centraliza a criação da Janela no monitor
		mainJFrame.setLocationRelativeTo(null);
		// Adicionando o JPanel Principal com todos os outros elementos.
		mainJFrame.add(mainJPanel);
	}

	/**
	 * Classe responsavel pela criação dos itens do Menu da Janela
	 **/
	private void menusWindows() {
		//---------> CRIANDO A BARRA DE MENUS E ADICIONANDO MENUS A ELA <-----------
		menuBar.add(menuUsuario.getMenuUsuario());
		menuBar.add(menuExportar.getMenuExportar());
		menuBar.add(menuImportar.getMenuImportar());
		menuBar.add(menuVisualizar.getMenuVisualizar());
		menuBar.add(menuAvancado.getMenuAvancado());
	}

	/**
	 * Classe responsável pela criação de icones
	 **/
	private void criandoIcones() {
		//---------> CRIANDO OS ÍCONES<-----------
		 iconAluno = new ImageIcon(getClass().getResource(DIR_MAIN_ICONES+"aluno.png"));
		 iconAta = new ImageIcon(getClass().getResource(DIR_MAIN_ICONES+"ata.png"));
		 iconArquivo = new ImageIcon(getClass().getResource(DIR_MAIN_ICONES+"arquivo.png"));
	}

	public static void main(String[] args) {
		@SuppressWarnings("unused")
		Principal tela = new Principal();
	}
}