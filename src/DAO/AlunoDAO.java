package DAO;

import Model.Aluno;
import Model.PadraoEntidade;

/**
 * Classe concreta para realizar o CRUD da Entidade Aluno.
 * <br>Obs.: Excepetion SQL não são capturadas.
 *  
 * @author Adryano Escorcio
 * @version 1.8
 * @extends DAO
 * 
 * */
public class AlunoDAO extends DAO {
	
	/**
	 * Construtor
	 * 
	 * Transmite a conexao do BD para super classe.
	 * E iniciar uma conexa transicao de dados.
	 **/ 
	public AlunoDAO(JPAUtil conexaoBD) {
		super(conexaoBD);
	}
	
	@Override
	public boolean save(PadraoEntidade objeto) {
		return super.save(objeto);
	}
	
	/**
	 * Buscar Aluno usando o CodigoAluno
	 **/
	public Aluno buscar(String codigo) {
		return (Aluno) this.consultar(codigo);
	}
	
	@Override
	protected PadraoEntidade consultar(String codigo) {
		return em.find(Aluno.class, codigo);
	}

}
