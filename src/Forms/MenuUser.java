package Forms;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class MenuUser {

	private JMenu menuUsuario;

	public MenuUser() {
		menuUsuario = new JMenu("Usu�rio");	
		//ADICIONA UM MNEM�NICO OU ATALHO(ALT + U) 
		menuUsuario.setMnemonic('U');
		JMenuItem itemFazerLogin = new JMenuItem("Fazer Login"); 
		menuUsuario.add(itemFazerLogin); 
		JMenuItem itemFazerLogoff = new JMenuItem("Fazer Logoff"); 
		menuUsuario.add(itemFazerLogoff); 
	}
	
	public JMenu getMenuUsuario() {
		return menuUsuario;
	}
}