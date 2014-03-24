package Eventos;

import javax.swing.JOptionPane;

public class erroNullRequisito extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public erroNullRequisito(String message, String codigoErro ,Throwable cause) {
		super(message, cause);
		JOptionPane.showMessageDialog(null, message, codigoErro, JOptionPane.ERROR_MESSAGE);
	}

}
