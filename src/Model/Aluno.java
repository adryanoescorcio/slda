package Model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;

import PrimaryKey.AlunoPK;
import PrimaryKey.InterfaceKey;

/**
 * Classe concreta referente a Entidade Aluno do BD.
 * 
 * @author Adryano Escorcio
 * @version 1.5
 * @implements PadraoEntidade
 **/
@NamedQuery(name="Aluno.findAll", query="SELECT a FROM Aluno a")
@Entity
public class Aluno implements InterfacePadraoEntidade {
	
	@EmbeddedId
	private AlunoPK alunoPK = new AlunoPK();
	
	private String nomeAluno = null;
	private String CPF_Aluno = null;
	private String sexoAluno = null;
	private String corAluno = null;
	private String dataNascimento = null;
	private String cidadeNascAluno = null;
	private String estadoNascAluno = null;
	private String nomeMae = null;
	private String enderecoAluno = null;
	private String telefoneAluno = null;
	private String dataMatriculaAluno = null;
	private String situacaoAluno = null;
	private String tranferenciaAluno = null;
	private String nis = null;
	private String numCertificado = null;
	private String livro = null;
	private String folha = null;
	private String dataRegCertif = null;
	
	public String getNomeAluno() {
		return nomeAluno;
	}
	
	public void setNomeAluno(String nomeAluno) {
		this.nomeAluno = nomeAluno;
	}
	
	public String getNis() {
		return nis;
	}

	public void setNis(String nis) {
		this.nis = nis;
	}

	public String getNumCertificado() {
		return numCertificado;
	}

	public void setNumCertificado(String numCertificado) {
		this.numCertificado = numCertificado;
	}

	public String getLivro() {
		return livro;
	}

	public void setLivro(String livro) {
		this.livro = livro;
	}

	public String getFolha() {
		return folha;
	}

	public void setFolha(String folha) {
		this.folha = folha;
	}

	public String getDataRegCertif() {
		return dataRegCertif;
	}

	public void setDataRegCertif(String dataNasc) {
		this.dataRegCertif = dataNasc;
	}

	public String getCPF_Aluno() {
		return CPF_Aluno;
	}
	
	public void setCPF_Aluno(String CPF_Aluno) {
		this.CPF_Aluno = CPF_Aluno;
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
	
	public String getNomeMae() {
		return nomeMae;
	}
	
	public void setNomeMae(String nomeMae) {
		this.nomeMae = nomeMae;
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
	public String getDataMatriculaAluno() {
		return dataMatriculaAluno;
	}

	public void setDataMatriculaAluno(String dataMatriculaAluno) {
		this.dataMatriculaAluno = dataMatriculaAluno;
	}

	public String getTranferenciaAluno() {
		return tranferenciaAluno;
	}

	public void setTranferenciaAluno(String tranferenciaAluno) {
		this.tranferenciaAluno = tranferenciaAluno;
	}

	public String getSituacaoAluno() {
		return situacaoAluno;
	}

	public void setSituacaoAluno(String situacaoAluno) {
		this.situacaoAluno = situacaoAluno;
	}		

	@Override
	public String toString() throws NullPointerException {
		return "" +
			"CodigoAluno: "+this.alunoPK.toString()+", " +
			"Nome: "+this.nomeAluno+", " +
			"CPF: "+this.CPF_Aluno+", " +
			"Cor: "+this.corAluno+", " +
			"Sexo: "+this.sexoAluno+", " +
			"Data Nasc: "+this.dataNascimento+", " +
			"Cidade: "+this.cidadeNascAluno+", " +
			"Estado: "+this.estadoNascAluno+", " +
			"Mae: "+this.nomeMae+", " +
			"Endereco: "+this.enderecoAluno+", " +
			"Telefone: "+this.telefoneAluno+", " +
			"Data da Matrícula: "+this.dataMatriculaAluno+", "+
			"Admitido por transferência: " +this.tranferenciaAluno+", "+
			"Situação Atual: "+this.situacaoAluno+", "+
			"Nis: "+this.nis+", "+
			"Livro: "+this.livro+", "+
			"Folha: "+this.folha+", "+
			"N Certificado: "+this.numCertificado+", "+
			"data Reg: "+this.dataRegCertif+", "+
			"";
	}
	
	public void setCodigo(String codigo) {
		this.alunoPK.setCodigo(codigo);
	}
	
	public String getCodigo() {
		return this.alunoPK.toString();
	}
	
	@Override
	public AlunoPK getCodigoKEY() {
		return this.alunoPK;
	}

	@Override
	public void setCodigoKEY(InterfaceKey codigo) {
		this.alunoPK = (AlunoPK) codigo;
	}

}
