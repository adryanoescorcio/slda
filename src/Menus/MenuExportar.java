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

		menuExportar = new JMenu("Exportar");	
		//ADICIONA UM MNEMÔNICO OU ATALHO(ALT + E) 
		menuExportar.setMnemonic('E');
		JMenuItem itemBackup = new JMenuItem("Realizar Backup"); 
		menuExportar.add(itemBackup); 

	}

	public JMenu getMenuExportar(){
		return menuExportar;
	}

}
