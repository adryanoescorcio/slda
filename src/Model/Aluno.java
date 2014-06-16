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
@NamedQuery(name = "Aluno.findAll", query = "SELECT a FROM Aluno a")
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

	public String getCidadeNascAluno() {
		return cidadeNascAluno;
	}

	public String getCodigo() {
		return this.alunoPK.toString();
	}

	@Override
	public AlunoPK getCodigoKEY() {
		return this.alunoPK;
	}

	public String getCorAluno() {
		return corAluno;
	}

	public String getCPF_Aluno() {
		return CPF_Aluno;
	}

	public String getDataMatriculaAluno() {
		return dataMatriculaAluno;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public String getDataRegCertif() {
		return dataRegCertif;
	}

	public String getEnderecoAluno() {
		return enderecoAluno;
	}

	public String getEstadoNascAluno() {
		return estadoNascAluno;
	}

	public String getFolha() {
		return folha;
	}

	public String getLivro() {
		return livro;
	}

	public String getNis() {
		return nis;
	}

	public String getNomeAluno() {
		return nomeAluno;
	}

	public String getNomeMae() {
		return nomeMae;
	}

	public String getNumCertificado() {
		return numCertificado;
	}

	public String getSexoAluno() {
		return sexoAluno;
	}

	public String getSituacaoAluno() {
		return situacaoAluno;
	}

	public String getTelefoneAluno() {
		return telefoneAluno;
	}

	public String getTranferenciaAluno() {
		return tranferenciaAluno;
	}

	public void setCidadeNascAluno(final String cidadeNascAluno) {
		this.cidadeNascAluno = cidadeNascAluno;
	}

	public void setCodigo(final String codigo) {
		this.alunoPK.setCodigo(codigo);
	}

	@Override
	public void setCodigoKEY(final InterfaceKey codigo) {
		this.alunoPK = (AlunoPK) codigo;
	}

	public void setCorAluno(final String corAluno) {
		this.corAluno = corAluno;
	}

	public void setCPF_Aluno(final String CPF_Aluno) {
		this.CPF_Aluno = CPF_Aluno;
	}

	public void setDataMatriculaAluno(final String dataMatriculaAluno) {
		this.dataMatriculaAluno = dataMatriculaAluno;
	}

	public void setDataNascimento(final String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public void setDataRegCertif(final String dataNasc) {
		this.dataRegCertif = dataNasc;
	}

	public void setEnderecoAluno(final String enderecoAluno) {
		this.enderecoAluno = enderecoAluno;
	}

	public void setEstadoNascAluno(final String estadoNascAluno) {
		this.estadoNascAluno = estadoNascAluno;
	}

	public void setFolha(final String folha) {
		this.folha = folha;
	}

	public void setLivro(final String livro) {
		this.livro = livro;
	}

	public void setNis(final String nis) {
		this.nis = nis;
	}

	public void setNomeAluno(final String nomeAluno) {
		this.nomeAluno = nomeAluno;
	}

	public void setNomeMae(final String nomeMae) {
		this.nomeMae = nomeMae;
	}

	public void setNumCertificado(final String numCertificado) {
		this.numCertificado = numCertificado;
	}

	public void setSexoAluno(final String sexoAluno) {
		this.sexoAluno = sexoAluno;
	}

	public void setSituacaoAluno(final String situacaoAluno) {
		this.situacaoAluno = situacaoAluno;
	}

	public void setTelefoneAluno(final String telefoneAluno) {
		this.telefoneAluno = telefoneAluno;
	}

	public void setTranferenciaAluno(final String tranferenciaAluno) {
		this.tranferenciaAluno = tranferenciaAluno;
	}

	@Override
	public String toString() throws NullPointerException {
		return Messages.getString("Aluno.0") + Messages.getString("Aluno.1") + this.alunoPK.toString() + Messages.getString("Aluno.2") + Messages.getString("Aluno.3") //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
				+ this.nomeAluno + Messages.getString("Aluno.4") + Messages.getString("Aluno.5") + this.CPF_Aluno + Messages.getString("Aluno.6") //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				+ Messages.getString("Aluno.7") + this.corAluno + Messages.getString("Aluno.8") + Messages.getString("Aluno.9") + this.sexoAluno //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				+ Messages.getString("Aluno.10") + Messages.getString("Aluno.11") + this.dataNascimento + Messages.getString("Aluno.12") //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				+ Messages.getString("Aluno.13") + this.cidadeNascAluno + Messages.getString("Aluno.14") + Messages.getString("Aluno.15") //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				+ this.estadoNascAluno + Messages.getString("Aluno.16") + Messages.getString("Aluno.17") + this.nomeMae + Messages.getString("Aluno.18") //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				+ Messages.getString("Aluno.19") + this.enderecoAluno + Messages.getString("Aluno.20") + Messages.getString("Aluno.21") //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				+ this.telefoneAluno + Messages.getString("Aluno.22") + Messages.getString("Aluno.23") //$NON-NLS-1$ //$NON-NLS-2$
				+ this.dataMatriculaAluno + Messages.getString("Aluno.24") //$NON-NLS-1$
				+ Messages.getString("Aluno.25") + this.tranferenciaAluno //$NON-NLS-1$
				+ Messages.getString("Aluno.26") + Messages.getString("Aluno.27") + this.situacaoAluno + Messages.getString("Aluno.28") //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				+ Messages.getString("Aluno.29") + this.nis + Messages.getString("Aluno.30") + Messages.getString("Aluno.31") + this.livro + Messages.getString("Aluno.32") //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
				+ Messages.getString("Aluno.33") + this.folha + Messages.getString("Aluno.34") + Messages.getString("Aluno.35") //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				+ this.numCertificado + Messages.getString("Aluno.36") + Messages.getString("Aluno.37") //$NON-NLS-1$ //$NON-NLS-2$
				+ this.dataRegCertif + Messages.getString("Aluno.38") + Messages.getString("Aluno.39"); //$NON-NLS-1$ //$NON-NLS-2$
	}

}
