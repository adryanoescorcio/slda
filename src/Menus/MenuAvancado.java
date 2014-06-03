package Menus;

import java.awt.BorderLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import ComponentGroupPlus.IconesGroup;

/**
 * Classe que controla o menu Avançado e seus itens
 * 
 * @author Walysson Oliveira
 * @version 1.5
 **/

public class MenuAvancado {

	JMenu menuAvancado;
	IconesGroup icones = new IconesGroup();

	public MenuAvancado() {
		menuAvancado = new JMenu("Ajuda");	
		//ADICIONA UM MNEMÔNICO OU ATALHO(ALT + A) 
		menuAvancado.setMnemonic('A');
		JMenuItem itemControle = new JMenuItem("Sobre o Software"); 
		menuAvancado.add(itemControle);
		
		itemControle.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				@SuppressWarnings("unused")
				FrameAbout jDialog = new FrameAbout();
			}
		});
	}

	public JMenu getMenuAvancado() {
		return menuAvancado;
	}
	
	@SuppressWarnings("serial")
	class FrameAbout extends JDialog {
		
		public FrameAbout() {
			
			
			JLabel labelImagem = new JLabel();
			JPanel painel = new JPanel(new BorderLayout(2,2));
			
			labelImagem.setIcon(icones.getImageAbout());
			
			painel.add("Center", labelImagem);
			
			this.add(painel);
			this.setIconImage(Toolkit.getDefaultToolkit().getImage(
					getClass().getResource("../Icones/icon.png")));
			this.setTitle("About SLDA");

			this.setSize(icones.getImageAbout().getIconWidth(), icones.getImageAbout().getIconHeight());
			this.setAutoRequestFocus(true);
			this.setAlwaysOnTop(true);
			this.setResizable(false);
			this.setLocationRelativeTo(null);
			this.setModal(true);
			this.setVisible(true);
			this.setDefaultCloseOperation(JDialog.EXIT_ON_CLOSE);
		}
	}

}
