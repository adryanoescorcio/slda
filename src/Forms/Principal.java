package Forms;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import Forms.Crud.Aluno.AlterarAluno;
import Forms.Crud.Aluno.CadastrarAluno;
import Forms.Crud.Aluno.ExcluirAluno;
import Forms.Crud.Arquivo.CaixaArquivo;
import Forms.Crud.Arquivo.LocalizarArquivo;
import Forms.Crud.Arquivo.PedidoArquivo;
import Forms.Crud.Ata.AlterarAta;
import Forms.Crud.Ata.CadastrarAta;
import Forms.Crud.Ata.ExcluirAta;
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
	private static final int LADO = JTabbedPane.RIGHT;
	private static final int TOP = JTabbedPane.TOP;

	/**
	 * CRIADO UM PAINEL EM CAMADAS(JTABBEDPANE) PRINCIPAL - TOP
	 * EM QUE CADA CAMADA TEM OUTROS PAINEIS EM CAMADAS(JTABBEDPANE) LATERAIS
	 **/
	private JTabbedPane camadaExterna = new JTabbedPane(TOP);
	
	//PAINEIS EM CAMADAS(JTABBEDPANE) TOP QUE INSEREM ABAS LATERAIS
	private JTabbedPane camadaAluno = new JTabbedPane(LADO);
	private JTabbedPane camadaArquivo = new JTabbedPane(LADO);
	private JTabbedPane camadaAta = new JTabbedPane(LADO);
	
	private Icon iconLocalizar;
	private Icon iconAluno;
	private Icon iconCaixa;
	private Icon iconAta;
	private Icon iconArquivo;
	private Icon iconCadastrar;
	private Icon iconExcluir;
	private Icon iconMovimentacao;
	private Icon iconAlterar;
	
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
	private ExcluirAluno excluirAluno = new ExcluirAluno();
	private AlterarAluno alterarAluno = new AlterarAluno();
	// ATA
	private CadastrarAta cadastrarAta = new CadastrarAta();
	private AlterarAta alterarAta = new AlterarAta();
	private ExcluirAta excluirAta = new ExcluirAta();
	// ARQUIVO
	private CaixaArquivo caixaArquivo = new CaixaArquivo();
	private PedidoArquivo pedidoArquivo = new PedidoArquivo();
	
	private Font font = new Font(Font.SANS_SERIF, 0, 18);
	
	public Principal(){
		
		menusWindows();
		criandoIcones();
		alterandoFontes();
		addComponentesMainJPanel();
		configuracaoMainJFrame();
		
		//SETANDO AS CAMADAS COM O FUNDO BRANCO
		
		camadaExterna.setOpaque(true);
		camadaAluno.setOpaque(true);
		camadaArquivo.setOpaque(true);
		camadaAta.setOpaque(true);

		//DEFININDO OS PAINEIS DA CAMADA ARQUIVO
		camadaArquivo.addTab("Localizar", iconLocalizar, localizarAluno);
		camadaArquivo.addTab("Caixa", iconCaixa, caixaArquivo);
		camadaArquivo.addTab("Pedido", iconMovimentacao, pedidoArquivo);
		
		//DEFININDO OS PAINEIS DA CAMADA ALUNO
		camadaAluno.addTab("Cadastrar", iconCadastrar, cadastrarAluno);
		camadaAluno.addTab("Alterar", iconAlterar, alterarAluno);
		camadaAluno.addTab("Excluir", iconExcluir, excluirAluno);
		
		//DEFININDO OS PAINEIS DA CAMADA ATA
		camadaAta.addTab("Cadastrar", iconCadastrar, cadastrarAta);
		camadaAta.addTab("Alterar", iconAlterar, alterarAta);
		camadaAta.addTab("Excluir", iconExcluir, excluirAta);
		
		//DEFININDO OS PAINEIS DA CAMADA EXTERNA 
		camadaExterna.addTab("Arquivo", iconArquivo, camadaArquivo);
		camadaExterna.addTab("Aluno", iconAluno, camadaAluno);
		camadaExterna.addTab("  Ata", iconAta, camadaAta);
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
		//---------> CRIANDO A BARRA DE MENUS E ADICIONANDO MENUS A ELA<-----------
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
		 iconLocalizar = new ImageIcon(getClass().getResource(DIR_MAIN_ICONES+"localizar.jpg"));
		 iconAluno = new ImageIcon(getClass().getResource(DIR_MAIN_ICONES+"aluno.jpg"));
		 iconCaixa = new ImageIcon(getClass().getResource(DIR_MAIN_ICONES+"caixa.jpg"));
		 iconAta = new ImageIcon(getClass().getResource(DIR_MAIN_ICONES+"ata.jpg"));
		 iconArquivo = new ImageIcon(getClass().getResource(DIR_MAIN_ICONES+"arquivo.png"));
		 iconCadastrar = new ImageIcon(getClass().getResource(DIR_MAIN_ICONES+"cadastrar.jpg"));
		 iconExcluir = new ImageIcon(getClass().getResource(DIR_MAIN_ICONES+"excluir.jpg"));
		 iconMovimentacao = new ImageIcon(getClass().getResource(DIR_MAIN_ICONES+"documento.jpg"));
		 iconAlterar = new ImageIcon(getClass().getResource(DIR_MAIN_ICONES+"alterar.jpg"));
	}

	public static void main(String[] args) {
		Principal tela = new Principal();
	}

}