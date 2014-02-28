package Forms;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class MenuAvancado {

	JMenu menuAvancado;
	
	public MenuAvancado() {
		menuAvancado = new JMenu("Opções Avançadas");	
		//ADICIONA UM MNEMÔNICO OU ATALHO(ALT + A) 
		menuAvancado.setMnemonic('A');
		JMenuItem itemControle = new JMenuItem("Controle de Usuários"); 
		menuAvancado.add(itemControle);
		
		
	}
	
	public JMenu getMenuAvancado() {
		 return menuAvancado;
	}

}
