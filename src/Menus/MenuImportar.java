package Menus;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

/**
 * Classe que controla o menu Importar e seus itens
 * 
 * @author Walysson Oliveira
 * @version 1.5
 **/

public class MenuImportar {

	JMenu menuImportar;

	public MenuImportar() {
		menuImportar = new JMenu(Messages.getString("MenuImportar.0")); //$NON-NLS-1$
		// ADICIONA UM MNEMÔNICO OU ATALHO(ALT + I)
		menuImportar.setMnemonic('I');
		final JMenuItem itemOutroBD = new JMenuItem(Messages.getString("MenuImportar.1")); //$NON-NLS-1$
		menuImportar.add(itemOutroBD);

	}

	public JMenu getMenuImportar() {
		return menuImportar;
	}

}
