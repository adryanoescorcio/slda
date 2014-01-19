package Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

import DAO.AlunoDAO;
import DAO.JPAUtil;

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
	private JPAUtil conexaoBD = null;
	@Transient
	private AlunoDAO dao = null;
	
	@Id
	private String codigoAluno;
	private String nomeAluno;
	private String INEP;
	private String CPF_Aluno;
	private String RG_Aluno;
	private String sexoAluno;
	private String corAluno;
	private String dataNascimento;
	private String cidadeNascAluno;
	private String estadoNascAluno;
	private String nomePai;
	private String cidadePaiNasc;
	private String estadoPaiNasc;
	private String nomeMae;
	private String cidadeMaeNasc;
	private String estadoMaeNasc;
	private String enderecoAluno;
	private String telefoneAluno;
	
	
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
	
	@Override
	public JPAUtil getConexaoBD() {
		return this.conexaoBD;
	}
	
	@Override
	public void setConexaoBD(JPAUtil conexaoBD) {
		this.conexaoBD = conexaoBD;
		this.dao = new AlunoDAO(this.conexaoBD);
		
	}
	
	/**
	 * Descreve todos os atributos do objeto
	 **/
	@Override
	public String toString() {
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
	
	/**
	 * Metodo para inserir aluno no Banco de Dados
	 **/	
	public boolean inserirAtualizarAlunoBD(Aluno aluno){		
		try {
			return dao.inserirAtualizar(aluno);
		} catch (NullPointerException e) {
			System.out.println("Não foi setado EM da classe:" + e.getMessage());
			return false;
		}
	}
	
	/**
	 * Remover aluno do Banco de Dados
	 * @param <li><b>String</b> codigoAluno</li> <b>or</b>
	 * <li><b>PadraoEntidade</b> aluno </li>
	 **/
	public boolean removerAlunoBD(Object params) {
		try {
			return dao.removerPorObjetoEntidade((PadraoEntidade) params);
		} catch (Exception e) {
			return dao.removerPorCodigoPK((String) params);
		}
	}
	
	public Aluno buscarAlunoBD(String codigo) {
		return (Aluno) dao.consultar(codigo);
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
