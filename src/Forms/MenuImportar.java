package Forms;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class MenuImportar {

	JMenu menuImportar;
	
	public MenuImportar() {
		menuImportar = new JMenu("Importar");	
		//ADICIONA UM MNEMÔNICO OU ATALHO(ALT + I) 
		menuImportar.setMnemonic('I');
		JMenuItem itemOutroBD = new JMenuItem("Usar outro Banco de Dados"); 
		menuImportar.add(itemOutroBD);
		
	}
	
	public JMenu getMenuImportar(){
		return menuImportar;
	}

}
