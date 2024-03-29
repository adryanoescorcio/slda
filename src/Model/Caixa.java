package Model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;

import PrimaryKey.CaixaPK;
import PrimaryKey.InterfaceKey;

/**
 * Classe concreta referente a Entidade Caixa do BD.
 * 
 * @author Walysson Oliveira
 * @version 1.5
 * @implements PadraoEntidade
 **/

@NamedQuery(name="Caixa.findAllC", query="SELECT c FROM Caixa c")
@Entity
public class Caixa implements InterfacePadraoEntidade{

	@EmbeddedId
	private CaixaPK caixapk = new CaixaPK();

	private String status;
	private String turno;
	private String letra;
	private String modalidadeAta = null;
	private String ensinoAta = null;
	
	public String getModalidadeAta() {
		return modalidadeAta;
	}

	public void setModalidadeAta(String modalidadeAta) {
		this.modalidadeAta = modalidadeAta;
	}

	public String getEnsinoAta() {
		return ensinoAta;
	}

	public void setEnsinoAta(String ensinoAta) {
		this.ensinoAta = ensinoAta;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTurno() {
		return turno;
	}

	public void setTurno(String turno) {
		this.turno = turno;
	}

	public String getCodigo() {
		return this.caixapk.toString();
	}

	public void setCodigo(String codigo) {
		this.caixapk.setCodigo(codigo);
	}

	public String getLetra() {
		return this.letra;
	}

	public void setLetra(String string) {
		this.letra = string;
	}

	@Override
	public String toString() {
		return "" +
				"Codigo: "+this.caixapk.toString()+ ", " +
				"Status: "+this.status+ ", " +
				"Turno: "+this.turno+ ", " +
				"Letra: "+this.letra +
				"";
	}

	@Override
	public CaixaPK getCodigoKEY() {
		return this.caixapk;
	}

	@Override
	public void setCodigoKEY(InterfaceKey chaveEntidade) {
		this.caixapk = (CaixaPK) chaveEntidade;
	}

}
