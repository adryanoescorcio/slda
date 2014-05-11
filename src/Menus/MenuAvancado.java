package Menus;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

/**
 * Classe que controla o menu Avançado e seus itens
 * 
 * @author Walysson Oliveira
 * @version 1.5
 **/

public class MenuAvancado {

	JMenu menuAvancado;

	public MenuAvancado() {
		menuAvancado = new JMenu("Ajuda");	
		//ADICIONA UM MNEMÔNICO OU ATALHO(ALT + A) 
		menuAvancado.setMnemonic('A');
		JMenuItem itemControle = new JMenuItem("Sobre o SLDA.1"); 
		menuAvancado.add(itemControle);
		JMenuItem itemControle2 = new JMenuItem("Contato"); 
		menuAvancado.add(itemControle2);

	}

	public JMenu getMenuAvancado() {
		return menuAvancado;
	}

}
