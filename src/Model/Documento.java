package Model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;

import PrimaryKey.DocumentoPK;
import PrimaryKey.InterfaceKey;

/**
 * Classe concreta referente a Entidade Documento do BD.
 * 
 * @author Adryano Escorcio
 * @version 1.5
 * @implements PadraoEntidade
 **/

@NamedQuery(name="Documento.findAll", query="SELECT d FROM Documento d")

@Entity
public class Documento implements InterfacePadraoEntidade {

	@EmbeddedId
	private DocumentoPK documentopk = new DocumentoPK(); 
	private String nomeDocumento = null;
	@Column(length=100)
	private String descricao = null;
	private String dataPedido = null;
	private String dataEntrega = null;
	private String status = null;
	
	@ManyToOne
	private Aluno aluno = null;
	
	public String getNomeDocumento() {
		return nomeDocumento;
	}

	public void setNomeDocumento(String nomeDocumento) {
		this.nomeDocumento = nomeDocumento;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getDataPedido() {
		return dataPedido;
	}

	public void setDataPedido(String dataPedido) {
		this.dataPedido = dataPedido;
	}

	public String getDataEntrega() {
		return dataEntrega;
	}

	public void setDataEntrega(String dataEntrega) {
		this.dataEntrega = dataEntrega;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	@Override
	public String toString() {
		return "" +
			"Codigo: "+ this.getCodigo()+ ", " +
			"Codigo Aluno: "+this.getAluno().toString()+ ", " +
			"Nome Documento: "+this.nomeDocumento+ ", " +
			"Descri��o: "+this.descricao+ ", " +
			"Data de Entrega: "+this.dataEntrega+ ", " +
			"Data de Pedido: "+this.dataPedido+ ", " +
			"Status: "+this.status+ ", " +
			"";
	}

	@Override
	public InterfaceKey getCodigoKEY() {
		return this.documentopk;
	}

	@Override
	public void setCodigoKEY(InterfaceKey chaveEntidade) {
		this.documentopk = (DocumentoPK) chaveEntidade;
	}

	public void setCodigo(String codigo) {
		this.documentopk.setCodigo(codigo);
	}
	
	public String getCodigo() {
		return documentopk.getCodigo();
	}

}
