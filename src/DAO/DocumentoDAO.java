package DAO;

import Model.Documento;
import Model.PadraoEntidade;

public class DocumentoDAO extends DAO {

	public DocumentoDAO(JPAUtil conexaoBD) {
		super(conexaoBD);
	}
	
	public boolean save(Documento objeto) {
		if(objeto.getAluno() != null){
			return super.save(objeto);
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
