package Forms;

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
		menuVisualizar = new JMenu("Visualizar");
		//ADICIONA UM MNEMÔNICO OU ATALHO(ALT + V)
		menuVisualizar.setMnemonic('V');
		JMenuItem itemVisAlunos = new JMenuItem("Todos os Alunos"); 
		menuVisualizar.add(itemVisAlunos); 
		JMenuItem itemVisCaixas = new JMenuItem("Todas as Caixas"); 
		menuVisualizar.add(itemVisCaixas);
		JMenuItem itemVisAtas = new JMenuItem("Todas as Atas"); 
		menuVisualizar.add(itemVisAtas);
		
	}
	
	public JMenu getMenuVisualizar(){
		return menuVisualizar;
	}

}
