package ExceptionSLDA;

import javax.swing.JOptionPane;

public class erroNullRequisitoException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public erroNullRequisitoException(final String message,
			final String codigoErro) {
		super(message, new Throwable(Messages.getString("erroNullRequisitoException.0"))); //$NON-NLS-1$
		JOptionPane.showMessageDialog(null, message, codigoErro,
				JOptionPane.ERROR_MESSAGE);
	}

}
