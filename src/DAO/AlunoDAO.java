package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;
import javax.swing.JOptionPane;

import Model.Aluno;
import Model.InterfacePadraoEntidade;
import PrimaryKey.AlunoPK;
import PrimaryKey.InterfaceKey;

/**
 * Classe concreta para realizar o CRUD da Entidade Aluno. <br>
 * Obs.: Excepetion SQL não são capturadas.
 * <p>
 * <b>Extends</b><br>
 * DAO
 * 
 * @author Adryano Escorcio
 * @version 2.0
 * */
public class AlunoDAO extends DAO {

	/**
	 * <b>Construtor</b>
	 * <p>
	 * Transmite a conexao do BD para super classe.<br>
	 * E iniciar uma conexa transicao de dados.
	 **/
	public AlunoDAO(final JPAUtil conexaoBD) {
		super(conexaoBD);
	}

	/**
	 * Buscar Aluno usando o CodigoAluno
	 **/
	public Aluno buscar(final AlunoPK codigo) {
		return (Aluno) this.consultar(codigo);
	}

	public List<Aluno> buscarNome(final String nomeLocalizar) {

		// tenta fazer consulta composta usando o codigo PK
		final List<Aluno> list = new ArrayList<Aluno>();
		try {
			Aluno aluno = null;
			final ResultSet rs = this.consultarAlunoNome(nomeLocalizar);

			while (rs.next()) {
				aluno = new Aluno(); // cria um aluno vindo dos resultados

				aluno.setCodigo(rs.getString(Messages.getString("AlunoDAO.0"))); // insere o //$NON-NLS-1$
																// codigoDossie
				aluno.setTranferenciaAluno(rs.getString(Messages.getString("AlunoDAO.1"))); //$NON-NLS-1$
				aluno.setTelefoneAluno(rs.getString(Messages.getString("AlunoDAO.2"))); //$NON-NLS-1$
				aluno.setSituacaoAluno(rs.getString(Messages.getString("AlunoDAO.3"))); //$NON-NLS-1$
				aluno.setSexoAluno(rs.getString(Messages.getString("AlunoDAO.4"))); //$NON-NLS-1$
				aluno.setNomeMae(rs.getString(Messages.getString("AlunoDAO.5"))); //$NON-NLS-1$
				aluno.setNomeAluno(rs.getString(Messages.getString("AlunoDAO.6"))); //$NON-NLS-1$
				aluno.setEstadoNascAluno(rs.getString(Messages.getString("AlunoDAO.7"))); //$NON-NLS-1$
				aluno.setEnderecoAluno(rs.getString(Messages.getString("AlunoDAO.8"))); //$NON-NLS-1$
				aluno.setDataNascimento(rs.getString(Messages.getString("AlunoDAO.9"))); //$NON-NLS-1$
				aluno.setDataMatriculaAluno(rs.getString(Messages.getString("AlunoDAO.10"))); //$NON-NLS-1$
				aluno.setCorAluno(rs.getString(Messages.getString("AlunoDAO.11"))); //$NON-NLS-1$
				aluno.setCidadeNascAluno(rs.getString(Messages.getString("AlunoDAO.12"))); //$NON-NLS-1$
				aluno.setCPF_Aluno(rs.getString(Messages.getString("AlunoDAO.13"))); //$NON-NLS-1$
				aluno.setNis(rs.getString(Messages.getString("AlunoDAO.14"))); //$NON-NLS-1$
				aluno.setLivro(rs.getString(Messages.getString("AlunoDAO.15"))); //$NON-NLS-1$
				aluno.setFolha(rs.getString(Messages.getString("AlunoDAO.16"))); //$NON-NLS-1$
				aluno.setNumCertificado(rs.getString(Messages.getString("AlunoDAO.17"))); //$NON-NLS-1$
				aluno.setDataRegCertif(rs.getString(Messages.getString("AlunoDAO.18"))); //$NON-NLS-1$

				list.add(aluno); // adiciona o aluno na lista
				// System.out.println(aluno.getNomeAluno());
			}

			// serve para verificar se o objeto não é null;
			System.out.println(Messages.getString("AlunoDAO.19") + aluno.getCodigo() //$NON-NLS-1$
					+ Messages.getString("AlunoDAO.20")); // forçar o erro de nullPoint //$NON-NLS-1$
			return list;

		} catch (final NullPointerException e1) {
			JOptionPane.showMessageDialog(null,
					Messages.getString("AlunoDAO.21")); //$NON-NLS-1$
			return list;
		} catch (final SQLException e1) {
			JOptionPane.showMessageDialog(null, Messages.getString("AlunoDAO.22") + e1.getMessage()); //$NON-NLS-1$
			return list;
		}
	}

	@Override
	protected InterfacePadraoEntidade consultar(final InterfaceKey codigo) {
		em.clear();
		return em.find(Aluno.class, codigo);
	}

	private ResultSet consultarAlunoNome(final String codigo)
			throws SQLException {
		return stm.executeQuery(Messages.getString("AlunoDAO.23") //$NON-NLS-1$
				+ codigo + Messages.getString("AlunoDAO.24")); //$NON-NLS-1$
	}

	/**
	 * RETORNA TODAS OS ALUNOS DO BANCO
	 **/
	public List<Aluno> getTodosAlunos() {

		final Query query = em.createNamedQuery(Messages.getString("AlunoDAO.25")); //$NON-NLS-1$
		@SuppressWarnings("unchecked")
		final List<Aluno> alunos = query.getResultList();

		return alunos;
	}

	public boolean isExist(final String codigo) {
		final AlunoPK pk = new AlunoPK();
		pk.setCodigo(codigo);

		final Aluno alunoDaConsulta = (Aluno) this.consultar(pk);

		try {
			alunoDaConsulta.toString();
			return true;
		} catch (final NullPointerException e) {
			return false;
		}
	}

	/**
	 * Metodo para inserir/atualiza o Entidade no Banco de Dados.
	 **/
	public boolean save(final Aluno aluno) {
		return super.save(aluno);
	}

}
