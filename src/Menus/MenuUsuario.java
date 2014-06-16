package Menus;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class MenuUsuario {

	private final JMenu menuUsuario;

	public MenuUsuario() {
		menuUsuario = new JMenu(Messages.getString("MenuUsuario.0")); //$NON-NLS-1$
		// ADICIONA UM MNEMÔNICO OU ATALHO(ALT + U)
		menuUsuario.setMnemonic('U');
		final JMenuItem itemFazerLogin = new JMenuItem(Messages.getString("MenuUsuario.1")); //$NON-NLS-1$
		menuUsuario.add(itemFazerLogin);
		final JMenuItem itemFazerLogoff = new JMenuItem(Messages.getString("MenuUsuario.2")); //$NON-NLS-1$
		menuUsuario.add(itemFazerLogoff);
	}

	public JMenu getMenuUsuario() {
		return menuUsuario;
	}
}
