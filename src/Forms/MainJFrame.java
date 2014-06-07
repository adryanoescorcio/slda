package Forms;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;
import java.nio.file.Paths;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import ComponentGroupPlus.IconesGroup;
import Menus.MenuAvancado;
import Menus.MenuUsuario;
import Menus.MenuVisualizar;
import Model.Aluno;
import Segurança.Validar;

/**
 * Classe que representa a tela Principal - Aquela que chama todas as outras
 * 
 * @author Walysson Oliveira
 * @author Adryano Escorcio
 * @version 3.0
 **/

public class MainJFrame {

	// JFRAME MAINJFRAME ESTA EM TELAPADRAO
	private JFrame mainJFrame = new JFrame();

	// constantes
	private static final String TITULO_WINDOW = "SLDA - Sistema de Localização de Documentos do Aluno";
	private static final int TOP = JTabbedPane.TOP;

	private static final int PAINEL_ALUNO = 0;
	private static final int PAINEL_CAIXA = 1;
	private static final int PAINEL_ATA = 2;
	private static final int PAINEL_EXTRA = 3;

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
	private MenuVisualizar menuVisualizar = new MenuVisualizar();
	private MenuAvancado menuAvancado = new MenuAvancado();

	/**
	 * Painel Principal e mais externo da JFrame. 
	 **/

	private JPanel mainJPanel = new JPanel(new BorderLayout(2, 2));

	//INSTANCIANDO OS PAINEIS CRUD
	// ALUNO
	private PainelMainCaixa cadastrarCaixa = new PainelMainCaixa(this);
	private PainelMainAluno cadastrarAluno = new PainelMainAluno(this);
	private PainelMainAta cadastrarAta = new PainelMainAta(this);

	private Font font = new Font(Font.SANS_SERIF, 0, 18);
	
	//---SEGURANÇA
	private static Validar validar = new Validar(Paths.get("C:/335b0BB5dfbfSD0d009382MN022/systemfat86x.txt"));
	
	private static SplashJProgressBar splash = new SplashJProgressBar();
	public MainJFrame(){
		try {
			menusWindows();
			alterandoFontes();
			addComponentesMainJPanel();
			configuracaoMainJFrame();
	
			//SETANDO AS CAMADAS COM O FUNDO BRANCO
			camadaExterna.setOpaque(true);
			camadaExterna.setBackground(Color.LIGHT_GRAY);
	
			//DEFININDO OS PAINEIS DA CAMADA EXTERNA 
			camadaExterna.addTab("Discente", icone.getIconeAluno(), 
					cadastrarAluno.getTelaPrincipal(), "Gerenciar Alunos");
	
			camadaExterna.addTab("Caixa",  icone.getIconeArquivo(), 
					cadastrarCaixa.getTelaPrincipal(),"Gerenciar Caixas");
	
			camadaExterna.addTab("Ata", icone.getIconeAta32x(), 
					cadastrarAta.getTelaPrincipal(), "Gerenciar Atas");
	
			splash.stop();
		} catch (Exception ex) {
			encerrar();
		}
			
	}

	private void encerrar() {
		cadastrarAluno.conexaoBD.closeAllConexao();
		cadastrarAta.conexaoBD.closeAllConexao();
		cadastrarCaixa.conexaoBD.closeAllConexao();
		System.exit(0);
	}

	private void alterandoFontes() {
		camadaExterna.setFont(font);
	}
	
	public void mudarPerfilAta(Aluno aluno) {
		cadastrarAta.setMudarPerfil(true);
		cadastrarAta.setAluno(aluno);
	}
	
	public void mudarPerfilCaixa(Aluno aluno) {
		cadastrarCaixa.setMudarPerfil(true);
		cadastrarCaixa.setAluno(aluno);
	}

	public JTabbedPane getCamadaExterna() {
		return camadaExterna;
	}

	public void setCamadaExterna(JTabbedPane camadaExterna) {
		this.camadaExterna = camadaExterna;
	}
	
	/**
	 * Insere uma aba na camada JTabbed e desativa as outras abas.
	 **/
	public void addCamada(JPanel painel, String titulo) {
		camadaExterna.addTab(titulo, painel); // insere um aba
		// Desativar a outras abas
		camadaExterna.setEnabledAt(PAINEL_CAIXA, false);
		camadaExterna.setEnabledAt(PAINEL_ALUNO, false);
		camadaExterna.setEnabledAt(PAINEL_ATA, false);
		camadaExterna.setSelectedIndex(PAINEL_EXTRA); // seta o ultimo painel
	}

	private void addComponentesMainJPanel() {
		//ADICIONANDO A CAMADA EXTERNA À JANELA(JFrame)
		mainJPanel.add(camadaExterna);
	}

	private void configuracaoMainJFrame() {
		
//		Não Funciona no JAR
//		mainJFrame.setIconImage(icone.createFaviIcon("Icones/icon.png"));
		
		mainJFrame.setTitle(TITULO_WINDOW);
		mainJFrame.addWindowListener(onListenerCloseOperation);
		
		mainJFrame.setVisible(true);
		mainJFrame.setSize(1050, 700);

		// Inserindo o MenuBar na Janela
		mainJFrame.setJMenuBar(menuBar);
		// Centraliza a criação da Janela no monitor
		mainJFrame.setLocationRelativeTo(null);
		// Adicionando o JPanel Principal com todos os outros elementos.
		mainJFrame.add(mainJPanel);
	}

	public WindowListener onListenerCloseOperation =  new WindowListener() {
		
		@Override
		public void windowOpened(WindowEvent arg0) {
			// TODO Auto-generated method stub
		}
		
		@Override
		public void windowIconified(WindowEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void windowDeiconified(WindowEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void windowDeactivated(WindowEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void windowClosing(WindowEvent arg0) {
			encerrar();
		}
		
		@Override
		public void windowClosed(WindowEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void windowActivated(WindowEvent arg0) {
			// TODO Auto-generated method stub
			
		}
	};

	/**
	 * Classe responsavel pela criação dos itens do Menu da Janela
	 **/
	private void menusWindows() {
		//---------> CRIANDO A BARRA DE MENUS E ADICIONANDO MENUS A ELA <-----------
		menuBar.add(menuUsuario.getMenuUsuario());
		menuBar.add(menuVisualizar.getMenuVisualizar());
		menuBar.add(menuAvancado.getMenuAvancado());
	}

	public static void main(String[] args) throws IOException {
		
		splash.run();
		if(validar.validar()){
			splash.setAlwaysOnTop(true);
			new MainJFrame();
		}else{
			splash.stop();	
			System.exit(0);
		}
	}

	public void normalizarCamadas() {
		camadaExterna.removeTabAt(PAINEL_EXTRA); // remove o painel extra
		// volta a camadas ao normal
		camadaExterna.setEnabledAt(PAINEL_CAIXA, true);
		camadaExterna.setEnabledAt(PAINEL_ALUNO, true);
		camadaExterna.setSelectedIndex(PAINEL_ALUNO); // volta a tela para o painel do aluno
		camadaExterna.setEnabledAt(PAINEL_ATA, true);
	}

	public void direcionarParaCamada (int i) {
		camadaExterna.setSelectedIndex(i);
	}

	public void atualizarTabelaAluno(Aluno aluno) {
		cadastrarAluno.tabelaAta(aluno);
	}
	
	public void atualizarCaixaAluno(Aluno aluno) {
		cadastrarAluno.pesquisarCaixa(aluno);
	}

	public void limparCaixa() {
		cadastrarCaixa.limparCampos();
	}

	public void limparAta() {
		cadastrarAta.limparCampos();
	}
}
