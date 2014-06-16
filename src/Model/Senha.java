package Model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import PrimaryKey.InterfaceKey;
import PrimaryKey.SenhaPK;

@Entity
public class Senha implements InterfacePadraoEntidade {

	@EmbeddedId
	private SenhaPK pass = new SenhaPK();

	private String mac;
	private String data;

	@Override
	public InterfaceKey getCodigoKEY() {
		return this.pass;
	}

	public String getData() {
		return data;
	}

	public String getMac() {
		return mac;
	}

	public SenhaPK getPass() {
		return pass;
	}

	@Override
	public void setCodigoKEY(final InterfaceKey chaveEntidade) {
		// TODO Auto-generated method stub

	}

	public void setData(final String data) {
		this.data = data;
	}

	public void setMac(final String mac) {
		this.mac = mac;
	}

	public void setPass(final SenhaPK pass) {
		this.pass = pass;
	}

	@Override
	public String toString() {
		return Messages.getString("Senha.0") + Messages.getString("Senha.1") + this.pass.getCodigo() + Messages.getString("Senha.2") + Messages.getString("Senha.3") //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
				+ this.mac + Messages.getString("Senha.4"); //$NON-NLS-1$
	}
}
