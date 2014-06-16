package Menus;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

/**
 * Classe que controla o menu Exportar e seus itens
 * 
 * @author Walysson Oliveira
 * @version 1.5
 **/

public class MenuExportar {

	JMenu menuExportar;

	public MenuExportar() {

		menuExportar = new JMenu(Messages.getString("MenuExportar.0")); //$NON-NLS-1$
		// ADICIONA UM MNEMÔNICO OU ATALHO(ALT + E)
		menuExportar.setMnemonic('E');
		final JMenuItem itemBackup = new JMenuItem(Messages.getString("MenuExportar.1")); //$NON-NLS-1$
		menuExportar.add(itemBackup);

	}

	public JMenu getMenuExportar() {
		return menuExportar;
	}

}
