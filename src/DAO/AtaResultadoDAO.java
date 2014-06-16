package DAO;

import java.util.List;

import javax.persistence.Query;

import Model.Aluno;
import Model.Ata;
import Model.AtaResultado;
import Model.InterfacePadraoEntidade;
import PrimaryKey.AtaResultadoPK;
import PrimaryKey.InterfaceKey;

/**
 * Classe concreta para realizar o CRUD da Entidade AtaResultado.
 * <p>
 * <b>Extends</b><br>
 * DAO
 * 
 * @author Adryano Escorcio
 * @version 1.5
 * */
public class AtaResultadoDAO extends DAO {

	/**
	 * <b>Construtor</b>
	 * <p>
	 * Transmite a conexao do BD para super classe.<br>
	 * E inicia uma conexa transacao de dados.
	 **/
	public AtaResultadoDAO(final JPAUtil conexaoBD) {
		super(conexaoBD);
	}

	/**
	 * Buscar Caixa usando o codigo
	 **/
	public AtaResultado buscar(final AtaResultadoPK codigo) {
		return (AtaResultado) this.consultar(codigo);
	}

	public List<AtaResultado> buscarAtaporAluno(final Aluno aluno) {

		final String codAluno = aluno.getCodigo();

		final Query query = em.createNamedQuery(Messages.getString("AtaResultadoDAO.0")); //$NON-NLS-1$
		query.setParameter(Messages.getString("AtaResultadoDAO.1"), codAluno); //$NON-NLS-1$

		@SuppressWarnings("unchecked")
		final List<AtaResultado> ataResultado = query.getResultList();

		return ataResultado;
	}

	@Override
	protected InterfacePadraoEntidade consultar(final InterfaceKey codigo) {
		em.clear();
		return em.find(AtaResultado.class, codigo);
	}

	public void excluirPorAluno(final Aluno aluno) {

		final String codAluno = aluno.getCodigo();

		try {
			em.getTransaction().begin();
			final Query query = em
					.createQuery(Messages.getString("AtaResultadoDAO.2")); //$NON-NLS-1$
			query.setParameter(Messages.getString("AtaResultadoDAO.3"), codAluno); //$NON-NLS-1$
			query.executeUpdate();
			em.getTransaction().commit();
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}

	public void excluirPorAta(final Ata ata) {

		final String turma = ata.getTurmaAta();
		final String turno = ata.getTurnoAta();
		final String ano = ata.getAnoAta();

		try {
			em.getTransaction().begin();
			final Query query = em
					.createQuery(Messages.getString("AtaResultadoDAO.4") //$NON-NLS-1$
							+ Messages.getString("AtaResultadoDAO.5")); //$NON-NLS-1$

			query.setParameter(Messages.getString("AtaResultadoDAO.6"), turma); //$NON-NLS-1$
			query.setParameter(Messages.getString("AtaResultadoDAO.7"), turno); //$NON-NLS-1$
			query.setParameter(Messages.getString("AtaResultadoDAO.8"), ano); //$NON-NLS-1$
			query.executeUpdate();
			em.getTransaction().commit();

		} catch (final Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Metodo para inserir/atualiza o Entidade no Banco de Dados.
	 **/
	public boolean save(final AtaResultado ataResultado) {
		return super.save(ataResultado);
	}

}
