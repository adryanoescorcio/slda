package ExceptionSLDA;

import javax.swing.JOptionPane;

public class erroNullRequisitoException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public erroNullRequisitoException(String message, String codigoErro) {
		super(message);
		JOptionPane.showMessageDialog(null, message, codigoErro, JOptionPane.ERROR_MESSAGE);
	}

}
