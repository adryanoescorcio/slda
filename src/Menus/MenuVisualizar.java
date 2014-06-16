package Menus;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

/**
 * Classe que controla o menu Visualizar e seus itens
 * 
 * @author Walysson Oliveira
 * @version 1.5
 **/

public class MenuVisualizar {

	JMenu menuVisualizar;

	public MenuVisualizar() {
		menuVisualizar = new JMenu(Messages.getString("MenuVisualizar.0")); //$NON-NLS-1$
		// ADICIONA UM MNEMÔNICO OU ATALHO(ALT + V)
		menuVisualizar.setMnemonic('V');
		final JMenuItem itemVisAlunos = new JMenuItem(Messages.getString("MenuVisualizar.1")); //$NON-NLS-1$
		menuVisualizar.add(itemVisAlunos);
		final JMenuItem itemVisCaixas = new JMenuItem(Messages.getString("MenuVisualizar.2")); //$NON-NLS-1$
		menuVisualizar.add(itemVisCaixas);
		final JMenuItem itemVisAtas = new JMenuItem(Messages.getString("MenuVisualizar.3")); //$NON-NLS-1$
		menuVisualizar.add(itemVisAtas);

	}

	public JMenu getMenuVisualizar() {
		return menuVisualizar;
	}

}
