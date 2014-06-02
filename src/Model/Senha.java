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
	
	public SenhaPK getPass() {
		return pass;
	}

	public void setPass(SenhaPK pass) {
		this.pass = pass;
	}
	
	@Override
	public String toString() {
		return "" +
				"Senha: " + this.pass.getCodigo()+ ", " +
				"Mac: " + this.mac + ".";
	}

	@Override
	public InterfaceKey getCodigoKEY() {
		return this.pass;
	}

	@Override
	public void setCodigoKEY(InterfaceKey chaveEntidade) {
		// TODO Auto-generated method stub
		
	}

	public String getMac() {
		return mac;
	}

	public void setMac(String mac) {
		this.mac = mac;
	}
}
