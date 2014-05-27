package Forms;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JWindow;

public class SplashJProgressBar extends JWindow {
	
	private JLabel jLabelSplashImage;
	private static JProgressBar jProgressBarSistema;
	private Thread init;
	private ImageIcon imageIcon;

	public void run() {
		try {
			init = new Thread(initSplash);
			init.start();
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected Runnable initSplash = new Runnable() {
		
		@Override
		public void run() {
			criandoComponentes();
			SplashJProgressBar.this.setVisible(true);
		}
	};
	
	private void criandoComponentes() {
		/**
		 * Inicializando as variavaeis utilizadas
		 */
		jProgressBarSistema = new JProgressBar();
		jLabelSplashImage = new JLabel();
		
		this.setLayout(new BorderLayout(2,2));
		
		imageIcon = new ImageIcon("src/Icones/csar.png");
		jLabelSplashImage.setIcon(imageIcon);

		this.add("North",jLabelSplashImage);
		
		/**
		 * Setando parametros da variavel jProgressBarSistema
		 */
		jProgressBarSistema.setForeground(new Color(0,0,204));
		jProgressBarSistema.setPreferredSize(new java.awt.Dimension(148, 10));
		jProgressBarSistema.setBounds(0, 266, imageIcon.getIconWidth(), 5);
		jProgressBarSistema.setBorderPainted(false);
		jProgressBarSistema.setIndeterminate(true);
		
		/**
		 * Adicionando o jProgressBarSistema a classe SplashJProgressBar
		 */
		this.add("South", jProgressBarSistema);
		this.pack();
		
		configuracaoMainJFrame();
	}

	private void configuracaoMainJFrame() {
		this.setVisible(true);
		this.setSize(imageIcon.getIconWidth(), imageIcon.getIconHeight());

		// Centraliza a criação da Janela no monitor
		this.setLocationRelativeTo(null);
		this.setAlwaysOnTop(true);
	}
	
	public void stop() {
		this.setVisible(false);
		init.interrupt();
	}
}
