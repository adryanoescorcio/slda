package Menus;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import ComponentGroupPlus.IconesGroup;

/**
 * Classe que controla o menu Avançado e seus itens
 * 
 * @author Walysson Oliveira
 * @version 1.5
 **/

public class MenuAvancado {

	@SuppressWarnings("serial")
	class FrameAbout extends JDialog {

		public FrameAbout() {

			final JLabel labelImagem = new JLabel();
			final JPanel painel = new JPanel(new BorderLayout(2, 2));

			labelImagem.setIcon(icones.getImageAbout());

			painel.add(Messages.getString("MenuAvancado.0"), labelImagem); //$NON-NLS-1$

			this.add(painel);
			// this.setIconImage(Toolkit.getDefaultToolkit().getImage(
			// getClass().getResource("Icones/about.png")));
			this.setTitle(Messages.getString("MenuAvancado.1")); //$NON-NLS-1$

			this.setSize(icones.getImageAbout().getIconWidth(), icones
					.getImageAbout().getIconHeight());
			this.setAutoRequestFocus(true);
			this.setAlwaysOnTop(true);
			this.setResizable(false);
			this.setLocationRelativeTo(null);
			this.setModal(true);
			this.setVisible(true);
			this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		}
	}

	JMenu menuAvancado;

	IconesGroup icones = new IconesGroup();

	public MenuAvancado() {
		menuAvancado = new JMenu(Messages.getString("MenuAvancado.2")); //$NON-NLS-1$
		// ADICIONA UM MNEMÔNICO OU ATALHO(ALT + A)
		menuAvancado.setMnemonic('A');
		final JMenuItem itemControle = new JMenuItem(Messages.getString("MenuAvancado.3")); //$NON-NLS-1$
		menuAvancado.add(itemControle);

		itemControle.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(final ActionEvent arg0) {
				@SuppressWarnings("unused")
				final FrameAbout jDialog = new FrameAbout();
			}
		});
	}

	public JMenu getMenuAvancado() {
		return menuAvancado;
	}

}
