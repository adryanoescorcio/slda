package Forms;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class MenuAvancado {

	JMenu menuAvancado;
	
	public MenuAvancado() {
		menuAvancado = new JMenu("Op��es Avan�adas");	
		//ADICIONA UM MNEM�NICO OU ATALHO(ALT + A) 
		menuAvancado.setMnemonic('A');
		JMenuItem itemControle = new JMenuItem("Controle de Usu�rios"); 
		menuAvancado.add(itemControle);
		
		
	}
	
	public JMenu getMenuAvancado() {
		 return menuAvancado;
	}

}
