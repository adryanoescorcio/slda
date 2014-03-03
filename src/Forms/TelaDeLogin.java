package Forms;

import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 * Classe que interage com o usuário ao fazer o login
 * 
 * @author Walysson Oliveira
 * @version 1.5
 * @extends JDialog
 **/

@SuppressWarnings("serial")
public class TelaDeLogin extends JDialog {

	JButton botaoLogar, botaoPadrao;
	JTextField login;
	JPasswordField senha;
	
	public TelaDeLogin() {
			
		Container tela = getContentPane();
		tela.setLayout(new GridLayout(5, 2, 8, 8));
		 
		login = new JTextField();
		senha = new JPasswordField();
		
		botaoLogar = new JButton("Logar");
		botaoPadrao = new JButton("Usuário Padrão");
		
		tela.add(new JLabel("")); 								tela.add(new JLabel(""));
		tela.add(new JLabel("      Matrícula: "));				tela.add(login);
		tela.add(new JLabel("      Senha: "));					tela.add(senha);
		tela.add(botaoPadrao);									tela.add(botaoLogar);
		tela.add(new JLabel("")); 								tela.add(new JLabel(""));
		
		this.setLocationRelativeTo(null);
		this.setModal(true);
		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		setSize(400, 200);
		setResizable(false);
		setVisible(true);
	}

	public static void main(String[] args) {
		new TelaDeLogin();

	}
	
}