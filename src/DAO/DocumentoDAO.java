package DAO;

import Model.Documento;
import Model.PadraoEntidade;

/**
 * Classe concreta para realizar o CRUD da Entidade Aluno.
 * <p><b>Extends</b><br>DAO
 *  
 * @author Adryano Escorcio
 * @version 1.0
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
		
		// necess�rio a existencia de um aluno para continuar
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
	public Documento buscar(String codigo) {
		return (Documento) this.consultar(codigo);
	}
	
	@Override
	protected PadraoEntidade consultar(String codigo) {
		return em.find(Documento.class, codigo);
	}
}