package Forms;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import ComponentGroupPlus.IconesGroup;
import Menus.MenuAvancado;
import Menus.MenuExportar;
import Menus.MenuImportar;
import Menus.MenuUsuario;
import Menus.MenuVisualizar;

/**
 * Classe que representa a tela Principal - Aquela que chama todas as outras
 * 
 * @author Walysson Oliveira
 * @author Adryano Escorcio
 * @version 3.0
 **/
public class MainJFrame {
	
	// JFRAME MAINJFRAME ESTA EM TELAPADRAO
	public JFrame mainJFrame = new JFrame();
	
	// constantes
	private static final String TITULO_WINDOW = "SLDA - Sistema de Localização de Documentos do Aluno";
	private static final int TOP = JTabbedPane.TOP;

	/**
	 * CRIADO UM PAINEL EM CAMADAS(JTABBEDPANE) PRINCIPAL - TOP
	 * EM QUE CADA CAMADA TEM OUTROS PAINEIS EM CAMADAS(JTABBEDPANE) LATERAIS
	 **/
	private JTabbedPane camadaExterna = new JTabbedPane(TOP);

	// ICONES
	private IconesGroup icone = new IconesGroup();
	
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
	private PainelMainCaixa localizarAluno = new PainelMainCaixa();
	private PainelMainAluno cadastrarAluno = new PainelMainAluno();
	private PainelMainAta cadastrarAta = new PainelMainAta();
	
	private Font font = new Font(Font.SANS_SERIF, 0, 18);
	
	public MainJFrame(){
		
		menusWindows();
		alterandoFontes();
		addComponentesMainJPanel();
		configuracaoMainJFrame();
		
		//SETANDO AS CAMADAS COM O FUNDO BRANCO
		camadaExterna.setOpaque(true);

		//DEFININDO OS PAINEIS DA CAMADA EXTERNA 
		camadaExterna.addTab("Caixa",  icone.getIconeArquivo(), localizarAluno.getTelaPrincipal());
		camadaExterna.addTab("Discente", icone.getIconeAluno(), cadastrarAluno.getTelaPrincipal());
		camadaExterna.addTab("Ata", icone.getIconeAta(), cadastrarAta.getTelaPrincipal());
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

	public static void main(String[] args) {
		new MainJFrame();

	}
}
