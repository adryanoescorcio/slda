package Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

import DAO.AlunoDAO;

/**
 * Classe concreta referente a Entidade Aluno do BD.
 * 
 * @author Adryano Escorcio
 * @version 1.0
 * @implements PadraoEntidade
 **/
@Entity
public class Aluno implements PadraoEntidade {
	
	@Transient
	private static final String NOMETABLE = "aluno";
	@Transient
	private static final String NOMECOLUNAPK = "codigoaluno";
	@Transient
	private AlunoDAO dao = null;
	
	@Id
	private String codigoAluno = null;
	private String nomeAluno = null;
	private String INEP = null;
	private String CPF_Aluno = null;
	private String RG_Aluno = null;
	private String sexoAluno = null;
	private String corAluno = null;
	private String dataNascimento = null;
	private String cidadeNascAluno = null;
	private String estadoNascAluno = null;
	private String nomePai = null;
	private String cidadePaiNasc = null;
	private String estadoPaiNasc = null;
	private String nomeMae = null;
	private String cidadeMaeNasc = null;
	private String estadoMaeNasc = null;
	private String enderecoAluno = null;
	private String telefoneAluno = null;
	
	
	public String getNomeAluno() {
		return nomeAluno;
	}
	public void setNomeAluno(String nomeAluno) {
		this.nomeAluno = nomeAluno;
	}
	public String getINEP() {
		return INEP;
	}
	public void setINEP(String iNEP) {
		INEP = iNEP;
	}
	public String getCPF_Aluno() {
		return CPF_Aluno;
	}
	public void setCPF_Aluno(String cPF_Aluno) {
		CPF_Aluno = cPF_Aluno;
	}
	public String getRG_Aluno() {
		return RG_Aluno;
	}
	public void setRG_Aluno(String rG_Aluno) {
		RG_Aluno = rG_Aluno;
	}
	public String getSexoAluno() {
		return sexoAluno;
	}
	public void setSexoAluno(String sexoAluno) {
		this.sexoAluno = sexoAluno;
	}
	public String getCorAluno() {
		return corAluno;
	}
	public void setCorAluno(String corAluno) {
		this.corAluno = corAluno;
	}
	public String getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public String getCidadeNascAluno() {
		return cidadeNascAluno;
	}
	public void setCidadeNascAluno(String cidadeNascAluno) {
		this.cidadeNascAluno = cidadeNascAluno;
	}
	public String getEstadoNascAluno() {
		return estadoNascAluno;
	}
	public void setEstadoNascAluno(String estadoNascAluno) {
		this.estadoNascAluno = estadoNascAluno;
	}
	public String getNomePai() {
		return nomePai;
	}
	public void setNomePai(String nomePai) {
		this.nomePai = nomePai;
	}
	public String getCidadePaiNasc() {
		return cidadePaiNasc;
	}
	public void setCidadePaiNasc(String cidadePaiNasc) {
		this.cidadePaiNasc = cidadePaiNasc;
	}
	public String getEstadoPaiNasc() {
		return estadoPaiNasc;
	}
	public void setEstadoPaiNasc(String estadoPaiNasc) {
		this.estadoPaiNasc = estadoPaiNasc;
	}
	public String getNomeMae() {
		return nomeMae;
	}
	public void setNomeMae(String nomeMae) {
		this.nomeMae = nomeMae;
	}
	public String getCidadeMaeNasc() {
		return cidadeMaeNasc;
	}
	public void setCidadeMaeNasc(String cidadeMaeNasc) {
		this.cidadeMaeNasc = cidadeMaeNasc;
	}
	public String getEstadoMaeNasc() {
		return estadoMaeNasc;
	}
	public void setEstadoMaeNasc(String estadoMaeNasc) {
		this.estadoMaeNasc = estadoMaeNasc;
	}
	public String getEnderecoAluno() {
		return enderecoAluno;
	}
	public void setEnderecoAluno(String enderecoAluno) {
		this.enderecoAluno = enderecoAluno;
	}
	public String getTelefoneAluno() {
		return telefoneAluno;
	}
	public void setTelefoneAluno(String telefoneAluno) {
		this.telefoneAluno = telefoneAluno;
	}
	
	@Override
	public String getCodigo() {
		return this.codigoAluno;
	}
	
	@Override
	public void setCodigo(String codigo) {
		this.codigoAluno = codigo;
	}
	
	/**
	 * Descreve todos os atributos do objeto
	 **/
	@Override
	public String toString() throws NullPointerException {
		return "" +
			"CodigoAluno: "+this.codigoAluno+", " +
			"Nome: "+this.nomeAluno+", " +
			"CPF: "+this.CPF_Aluno+", " +
			"RG: "+this.RG_Aluno+", " +
			"Cor: "+this.corAluno+", " +
			"INEP: "+this.INEP+", " +
			"Sexo: "+this.sexoAluno+", " +
			"Data Nasc: "+this.dataNascimento+", " +
			"Cidade: "+this.cidadeNascAluno+", " +
			"Estado: "+this.estadoNascAluno+", " +
			"Pai: "+this.nomePai+", " +
			"Cidade do Pai: "+this.cidadePaiNasc+", " +
			"Estado do Pai: "+this.estadoPaiNasc+", " +
			"Mae: "+this.nomeMae+", " +
			"Cidade da Mae: "+this.cidadeMaeNasc+", " +
			"Estado da Mae: "+this.estadoMaeNasc+", " +
			"Endereco: "+this.enderecoAluno+", " +
			"Telefone: "+this.telefoneAluno+", " +
			"";
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
