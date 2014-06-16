package DAO;

import java.util.List;

import javax.persistence.Query;

import Model.Aluno;
import Model.Documento;
import Model.InterfacePadraoEntidade;
import PrimaryKey.DocumentoPK;
import PrimaryKey.InterfaceKey;

/**
 * Classe concreta para realizar o CRUD da Entidade Aluno.
 * <p>
 * <b>Extends</b><br>
 * DAO
 * 
 * @author Adryano Escorcio
 * @version 1.5
 * */
public class DocumentoDAO extends DAO {

	/**
	 * <b>Construtor</b>
	 * <p>
	 * Transmite a conexao do BD para super classe.<br>
	 * E inicia uma conexa transacao de dados.
	 **/
	public DocumentoDAO(final JPAUtil conexaoBD) {
		super(conexaoBD);
	}

	/**
	 * Buscar Documento usando o protocolo(codigo)
	 **/
	public Documento buscar(final DocumentoPK codigo) {
		return (Documento) this.consultar(codigo);
	}

	public List<Documento> buscarDocumentoporAluno(final Aluno aluno) {

		final Query query = em.createNamedQuery(Messages.getString("DocumentoDAO.0")); //$NON-NLS-1$
		query.setParameter(Messages.getString("DocumentoDAO.1"), aluno); //$NON-NLS-1$
		@SuppressWarnings("unchecked")
		final List<Documento> listaDocumento = query.getResultList();

		return listaDocumento;
	}

	@Override
	protected InterfacePadraoEntidade consultar(final InterfaceKey codigo) {
		em.clear();
		return em.find(Documento.class, codigo);
	}

	/**
	 * RETORNA TODAS OS DOCUMENTOS DO BANCO
	 **/
	public List<Documento> getTodosDocumentos() {

		final Query query = em.createNamedQuery(Messages.getString("DocumentoDAO.2")); //$NON-NLS-1$
		@SuppressWarnings("unchecked")
		final List<Documento> documentos = query.getResultList();

		return documentos;
	}

	/**
	 * Metodo para inserir/atualiza o Entidade no Banco de Dados.
	 **/
	public boolean save(final Documento doc) {

		// necessário a existencia de um aluno para continuar
		if (doc.getAluno() != null) {
			return super.save(doc);
		} else {
			System.out
					.println(Messages.getString("DocumentoDAO.3")); //$NON-NLS-1$
			return false;
		}
	}

}
