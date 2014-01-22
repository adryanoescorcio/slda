package Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

/**
 * Classe concreta referente a Entidade Documento do BD.
 * 
 * @author Adryano Escorcio
 * @version 1.5
 * @implements PadraoEntidade
 **/
@Entity
public class Documento implements PadraoEntidade {

	@Transient
	private static final String NOMETABLE = "documento";
	@Transient
	private static final String NOMECOLUNAPK = "protocolopedidodocumento";

	@Id
	private String protocoloPedidoDocumento = null;
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

	public static String getNometable() {
		return NOMETABLE;
	}

	public static String getNomecolunapk() {
		return NOMECOLUNAPK;
	}

	@Override
	public String toString() {
		return "" +
				"Codigo: "+this.protocoloPedidoDocumento+ ", " +
				"Codigo Aluno: "+this.getAluno().getCodigo()+ ", " +
				"Codigo Aluno: "+this.nomeDocumento+ ", " +
				"Codigo Aluno: "+this.descricao+ ", " +
				"Codigo Aluno: "+this.dataEntrega+ ", " +
				"Codigo Aluno: "+this.dataPedido+ ", " +
				"Codigo Aluno: "+this.status+ ", " +
				"";
	}
	
	@Override
	public String getCodigo() {
		return this.protocoloPedidoDocumento;
	}

	@Override
	public void setCodigo(String codigo) {
		this.protocoloPedidoDocumento = codigo;
	}

	@Override
	public String getNomeTabelaBD() {
		return NOMETABLE;
	}

	@Override
	public String getNomeColunaPKBD() {
		return NOMECOLUNAPK;
	}

}