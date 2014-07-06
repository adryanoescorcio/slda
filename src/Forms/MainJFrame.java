package Forms;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Panel;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import ComponentGroupPlus.IconesGroup;
import Eventos.EventosAluno;
import Menus.MenuAvancado;
import Menus.MenuUsuario;
import Menus.MenuVisualizar;
import Model.Aluno;
import Model.AtaResultado;
import Model.Documento;
import Segurança.Validar;

/**
 * Classe que representa a tela Principal - Aquela que chama todas as outras
 * 
 * @author Walysson Oliveira
 * @author Adryano Escorcio
 * @version 3.0
 **/

public class MainJFrame {

	public static void main(final String[] args) throws IOException {

		// splash.run();
		if (validar.validar()) {
			// splash.setAlwaysOnTop(true);
			new MainJFrame();
		} else {
			// splash.stop();
			System.exit(0);
		}
	}

	// JFRAME MAINJFRAME ESTA EM TELAPADRAO
	private final JFrame mainJFrame = new JFrame();
	// constantes
	private static final String TITULO_WINDOW = Messages.getString("MainJFrame.0"); //$NON-NLS-1$

	private static final int TOP = JTabbedPane.TOP;
	private static final int PAINEL_ALUNO = 0;
	private static final int PAINEL_CAIXA = 1;
	private static final int PAINEL_ATA = 2;

	private static final int PAINEL_EXTRA = 3;

	/**
	 * CRIADO UM PAINEL EM CAMADAS(JTABBEDPANE) PRINCIPAL - TOP EM QUE CADA
	 * CAMADA TEM OUTROS PAINEIS EM CAMADAS(JTABBEDPANE) LATERAIS
	 **/
	private JTabbedPane camadaExterna = new JTabbedPane(TOP);

	// ICONES
	private final IconesGroup icone = new IconesGroup();

	// Menu Principal
	private final JMenuBar menuBar = new JMenuBar();
	// Itens do Menu Principal
	private final MenuUsuario menuUsuario = new MenuUsuario();
	private final MenuVisualizar menuVisualizar = new MenuVisualizar();

	private final MenuAvancado menuAvancado = new MenuAvancado();

	/**
	 * Painel Principal e mais externo da JFrame.
	 **/

	private final JPanel mainJPanel = new JPanel(new BorderLayout(2, 2));
	// INSTANCIANDO OS PAINEIS CRUD
	// ALUNO
	private final PainelMainCaixa cadastrarCaixa = new PainelMainCaixa(this);
	private final PainelMainAluno cadastrarAluno = new PainelMainAluno(this);

	private final PainelMainAta cadastrarAta = new PainelMainAta(this);

	private final Font font = new Font(Font.SANS_SERIF, 0, 18);

	// ---SEGURANÇA
	private static Validar validar = new Validar(
			Paths.get(Messages.getString("MainJFrame.1"))); //$NON-NLS-1$

	public WindowListener onListenerCloseOperation = new WindowListener() {

		@Override
		public void windowActivated(final WindowEvent arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void windowClosed(final WindowEvent arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void windowClosing(final WindowEvent arg0) {
			encerrar();
		}

		@Override
		public void windowDeactivated(final WindowEvent arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void windowDeiconified(final WindowEvent arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void windowIconified(final WindowEvent arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void windowOpened(final WindowEvent arg0) {
			// TODO Auto-generated method stub
		}
	};

	// private static SplashJProgressBar splash = new SplashJProgressBar();
	public MainJFrame() {
		try {

			if (!icone.dirExist()) {
				encerrar();
			}
			try {
				final Path url = Paths.get(Messages.getString("MainJFrame.2")); //$NON-NLS-1$
				final Path url2 = Paths.get(Messages.getString("MainJFrame.3")); //$NON-NLS-1$
				final Path url1 = Paths.get(Messages.getString("MainJFrame.4")); //$NON-NLS-1$
				Runtime.getRuntime().exec(Messages.getString("MainJFrame.5") + url1); //$NON-NLS-1$
				Runtime.getRuntime().exec(Messages.getString("MainJFrame.6") + url); //$NON-NLS-1$
				Runtime.getRuntime().exec(Messages.getString("MainJFrame.7") + url2); //$NON-NLS-1$
			} catch (final IOException e1) {
				encerrar();
			}

			menusWindows();
			alterandoFontes();
			addComponentesMainJPanel();
			configuracaoMainJFrame();

			// SETANDO AS CAMADAS COM O FUNDO BRANCO
			camadaExterna.setOpaque(true);
			camadaExterna.setBackground(Color.LIGHT_GRAY);

			// DEFININDO OS PAINEIS DA CAMADA EXTERNA
			camadaExterna.addTab(Messages.getString("MainJFrame.8"), icone.getIconeAluno(), //$NON-NLS-1$
					cadastrarAluno.getTelaPrincipal(), Messages.getString("MainJFrame.9")); //$NON-NLS-1$

			camadaExterna.addTab(Messages.getString("MainJFrame.10"), icone.getIconeArquivo(), //$NON-NLS-1$
					cadastrarCaixa.getTelaPrincipal(), Messages.getString("MainJFrame.11")); //$NON-NLS-1$

			camadaExterna.addTab(Messages.getString("MainJFrame.12"), icone.getIconeAta32x(), //$NON-NLS-1$
					cadastrarAta.getTelaPrincipal(), Messages.getString("MainJFrame.13")); //$NON-NLS-1$

			// splash.stop();
		} catch (final Exception ex) {
			encerrar();
		}

	}

	/**
	 * Insere uma aba na camada JTabbed e desativa as outras abas.
	 **/
	public void addCamada(final Panel panel, final String titulo) {
		camadaExterna.addTab(titulo, panel); // insere um aba
		// Desativar a outras abas
		camadaExterna.setEnabledAt(PAINEL_CAIXA, false);
		camadaExterna.setEnabledAt(PAINEL_ALUNO, false);
		camadaExterna.setEnabledAt(PAINEL_ATA, false);
		camadaExterna.setSelectedIndex(PAINEL_EXTRA); // seta o ultimo painel
	}

	private void addComponentesMainJPanel() {
		// ADICIONANDO A CAMADA EXTERNA À JANELA(JFrame)
		mainJPanel.add(camadaExterna);
	}

	private void alterandoFontes() {
		camadaExterna.setFont(font);
	}

	public void atualizarCaixaAluno(final Aluno aluno) {
		cadastrarAluno.pesquisarCaixa(aluno);
	}

	public void atualizarTabelaAluno(final Aluno aluno) {
		cadastrarAluno.tabelaAta(aluno);
	}

	private void configuracaoMainJFrame() {

		// Não Funciona no JAR
		// mainJFrame.setIconImage(icone.createFaviIcon("Icones/icon.png"));

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

	public void direcionarParaCamada(final int i) {
		camadaExterna.setSelectedIndex(i);
	}

	private void encerrar() {
		cadastrarAluno.conexaoBD.closeAllConexao();
		cadastrarAta.conexaoBD.closeAllConexao();
		cadastrarCaixa.conexaoBD.closeAllConexao();
		System.exit(0);
	}

	public JTabbedPane getCamadaExterna() {
		return camadaExterna;
	}

	public void limparAta() {
		cadastrarAta.limparCampos();
	}

	public void limparCaixa() {
		cadastrarCaixa.limparCampos();
	}

	/**
	 * Classe responsavel pela criação dos itens do Menu da Janela
	 **/
	private void menusWindows() {
		// ---------> CRIANDO A BARRA DE MENUS E ADICIONANDO MENUS A ELA
		// <-----------
		menuBar.add(menuUsuario.getMenuUsuario());
		menuBar.add(menuVisualizar.getMenuVisualizar());
		menuBar.add(menuAvancado.getMenuAvancado());
	}

	public void mudarPerfilAta(final Aluno aluno) {
		cadastrarAta.setMudarPerfil(true);
		cadastrarAta.setAluno(aluno);
	}

	public void mudarPerfilAta(final Aluno aluno, final AtaResultado ataR) {
		mudarPerfilAta(aluno);
		cadastrarAta.setAta(ataR);
	}
	
	public void mudarPerfilDoc(final Aluno aluno, final Documento docR) {

	}

	public void mudarPerfilCaixa(final Aluno aluno, final EventosAluno evento) {
		cadastrarCaixa.setMudarPerfil(true);
		cadastrarCaixa.setAluno(aluno);
	}

	public void normalizarCamadas() {
		camadaExterna.removeTabAt(PAINEL_EXTRA); // remove o painel extra
		// volta a camadas ao normal
		camadaExterna.setEnabledAt(PAINEL_CAIXA, true);
		camadaExterna.setEnabledAt(PAINEL_ALUNO, true);
		camadaExterna.setSelectedIndex(PAINEL_ALUNO); // volta a tela para o
														// painel do aluno
		camadaExterna.setEnabledAt(PAINEL_ATA, true);
	}

	public void setCamadaExterna(final JTabbedPane camadaExterna) {
		this.camadaExterna = camadaExterna;
	}
}
