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
 * <p><b>Extends</b><br>DAO
 *  
 * @author Adryano Escorcio
 * @version 1.5
 * */
public class DocumentoDAO extends DAO {

	/**
	 * <b>Construtor</b><p>
	 * Transmite a conexao do BD para super classe.<br>
	 * E inicia uma conexa transacao de dados.
	 **/ 
	public DocumentoDAO(JPAUtil conexaoBD) {
		super(conexaoBD);
	}

	/**
	 * Metodo para inserir/atualiza o Entidade no Banco de Dados.
	 **/
	public boolean save(Documento doc) {

		// necessário a existencia de um aluno para continuar
		if(doc.getAluno() != null){
			return super.save(doc);
		} else {
			System.out.println("Referencie um aluno do BD para criar a Entidade.");
			return false;
		}
	}

	/**
	 * Buscar Documento usando o protocolo(codigo)
	 **/
	public Documento buscar(DocumentoPK codigo) {
		return (Documento) this.consultar(codigo);
	}

	@Override
	protected InterfacePadraoEntidade consultar(InterfaceKey codigo) {
		return em.find(Documento.class, codigo);
	}

	/**
	 * RETORNA TODAS OS DOCUMENTOS DO BANCO
	 **/
	public List<Documento> getTodosDocumentos(){

		Query query = em.createNamedQuery("Documento.findAll");
		@SuppressWarnings("unchecked")
		List<Documento> documentos = query.getResultList();

		return documentos;
	}

	public List<Documento> buscarDocumentoporAluno(Aluno aluno){

		Query query = em.createNamedQuery("Documento.findByAluno");
		query.setParameter("aluno", aluno);
		@SuppressWarnings("unchecked")
		List<Documento> listaDocumento = query.getResultList();

		return listaDocumento;
	}

}
