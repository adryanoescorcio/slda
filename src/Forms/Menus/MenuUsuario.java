package Forms.Menus;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class MenuUsuario {

	private JMenu menuUsuario;

	public MenuUsuario() {
		menuUsuario = new JMenu("Usuário");	
		//ADICIONA UM MNEMÔNICO OU ATALHO(ALT + U) 
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
