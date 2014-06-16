package ComponentGroupPlus;

import java.text.ParseException;

import javax.swing.JFormattedTextField;
import javax.swing.text.MaskFormatter;

public class MaskFormatterGroup {

	protected MaskFormatter data;
	protected MaskFormatter tel;
	protected MaskFormatter cpf;
	protected MaskFormatter ano;

	public MaskFormatter getMascaraAno() {
		try {
			ano = new MaskFormatter(Messages.getString("MaskFormatterGroup.0")); //$NON-NLS-1$
		} catch (final ParseException e) {
			e.printStackTrace();
		}
		return ano;
	}

	public MaskFormatter getMascaraCPF() {
		try {
			cpf = new MaskFormatter(Messages.getString("MaskFormatterGroup.1")); //$NON-NLS-1$
		} catch (final ParseException e) {
			e.printStackTrace();
		}
		return cpf;
	}

	public MaskFormatter getMascaraData() {
		try {
			data = new MaskFormatter(Messages.getString("MaskFormatterGroup.2")); //$NON-NLS-1$
		} catch (final ParseException e) {
			e.printStackTrace();
		}
		return data;
	}

	public MaskFormatter getMascaraTelefone() {
		try {
			tel = new MaskFormatter(Messages.getString("MaskFormatterGroup.3")); //$NON-NLS-1$
		} catch (final ParseException e) {
			e.printStackTrace();
		}
		return tel;
	}

	public String verificarMascara(final JFormattedTextField campo) {
		if (campo.getText().contains(Messages.getString("MaskFormatterGroup.4"))) { //$NON-NLS-1$
			return Messages.getString("MaskFormatterGroup.5"); //$NON-NLS-1$
		} else {
			return campo.getText();
		}
	}

}
