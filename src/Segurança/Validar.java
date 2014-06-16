package Segurança;

import java.io.IOException;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

import Model.Senha;
import PrimaryKey.SenhaPK;

public class Validar extends MAC {

	private final JPanel padrao = new JPanel();
	private final JPasswordField campo = new JPasswordField(10);
	List<Senha> macsBD = dao.getSenhas();

	public Validar(final Path url) {
		super(url);
		// TODO Auto-generated constructor stub
	}

	private boolean dateToday() {

		final Date date = new Date();
		final SimpleDateFormat dateToday = new SimpleDateFormat(Messages.getString("Validar.0")); //$NON-NLS-1$
		final String strDateToday = dateToday.format(date);

		final Boolean boo = false;
		Boolean ano = false;
		Boolean dia = false;
		Boolean mes = false;

		final String[] data = String.valueOf(strDateToday).split(Messages.getString("Validar.1")); //$NON-NLS-1$
		final String[] dataBD = macsBD.get(0).getData().split(Messages.getString("Validar.2")); //$NON-NLS-1$

		System.out.println(Integer.parseInt(data[2]));
		// verifica ano, se for menor verificar o mes, se for menor verificar o
		// dia.
		if (Integer.parseInt(data[2]) <= Integer.parseInt(dataBD[2])) {
			ano = true;
		}

		if (Integer.parseInt(data[1]) <= Integer.parseInt(dataBD[1])) {
			mes = true;
		}

		if (Integer.parseInt(data[0]) <= Integer.parseInt(dataBD[0])) {
			dia = true;
		}

		if (ano) {
			if (mes) {
				if (dia) {
					return true;
				}
			}
		}

		System.out.println(strDateToday);
		return boo;
	}

	// ---METODO QUE VALIDA MAC E SENHA
	public boolean validar() {
		if (dateToday()) {
			if (!validarMAC()) {
				if (validarSenha()) {
					return true;
				} else {
					conexaoBD.closeAllConexao();
					return false;
				}
			}
		} else {
			JOptionPane.showMessageDialog(null, Messages.getString("Validar.3"), //$NON-NLS-1$
					Messages.getString("Validar.4"), JOptionPane.WARNING_MESSAGE); //$NON-NLS-1$
			conexaoBD.closeAllConexao();
			return false;
		}

		return true;
	}

	// --- MÉTODO QUE VERIFICA SE PELO MENOS UM MAC DA MÁQUINA É COMPATÍVEL COM
	// O DO TXT
	public boolean validarMAC() {

		ArrayList<String> macs1 = new ArrayList<>();
		ArrayList<String> macs2 = new ArrayList<>();

		String mac = null;
		boolean boo = true;

		try {
			macs1 = getMac();
			macs2 = getMacTxt();
			mac = macsBD.get(0).getMac();
		} catch (final IOException e) {
			e.printStackTrace();
		}

		if (mac != null && mac.length() >= 20) {
			final String[] str = mac.split(mac.substring(17, 18));
			for (final String string2 : macs1) {
				if (str[0].equals(string2)) {
					boo = false;
					System.out.println(boo);
				}
			}
		}

		if (!boo) {
			for (final String string1 : macs1) {
				for (final String string2 : macs2) {
					if (string1.equals(string2)) {
						return true;
					}
				}
			}
		}

		return false;
	}

	// --- MÉTODO QUE VERIFICA SE A SENHA É COMPATÍVEL
	public boolean validarSenha() {

		final List<Senha> senhas = dao.getSenhas();

		if (senhas == null) {

			JOptionPane.showMessageDialog(null,
					Messages.getString("Validar.5") //$NON-NLS-1$
							+ Messages.getString("Validar.6"), //$NON-NLS-1$
					Messages.getString("Validar.7"), JOptionPane.WARNING_MESSAGE); //$NON-NLS-1$

			return false;
		}
		padrao.add(new JLabel(Messages.getString("Validar.8"))); //$NON-NLS-1$
		padrao.add(campo);

		final String[] options = new String[] { Messages.getString("Validar.9"), Messages.getString("Validar.10") }; //$NON-NLS-1$ //$NON-NLS-2$

		final int x = JOptionPane.showOptionDialog(null, padrao,
				Messages.getString("Validar.11"), JOptionPane.NO_OPTION, //$NON-NLS-1$
				JOptionPane.WARNING_MESSAGE, null, options, campo);

		final String senha = String.valueOf(campo.getPassword());

		if (x == 0) {
			for (final Senha pass : senhas) {

				final SenhaPK pk = (SenhaPK) pass.getCodigoKEY();

				try {
					/**
					 * --- 1 - TESTA SE A SENHA DIGITADA ESTÁ NO BANCO --- 2 -
					 * TESTA SE O MAC É NULL OU SE O MAC É COMPATÍVEL COM O DA
					 * MÁQUINA
					 */
					if (pk.getCodigo().equals(senha)
							&& (pass.getMac().equals(Messages.getString("Validar.12")) || pass //$NON-NLS-1$
									.getMac().equals(getMacString()))) {
						setMacTxt(pass);
						return true;
					}
				} catch (final Exception e) {
					JOptionPane.showMessageDialog(null,
							Messages.getString("Validar.13") //$NON-NLS-1$
									+ Messages.getString("Validar.14"), //$NON-NLS-1$
							Messages.getString("Validar.15"), JOptionPane.WARNING_MESSAGE); //$NON-NLS-1$
				}
			}
			JOptionPane.showMessageDialog(null,
					Messages.getString("Validar.16") //$NON-NLS-1$
							+ Messages.getString("Validar.17"), Messages.getString("Validar.18"), //$NON-NLS-1$ //$NON-NLS-2$
					JOptionPane.WARNING_MESSAGE);
		}
		return false;
	}
}