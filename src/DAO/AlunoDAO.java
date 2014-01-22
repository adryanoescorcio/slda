package DAO;

import Model.Aluno;
import Model.PadraoEntidade;

/**
 * Classe concreta para realizar o CRUD da Entidade Aluno.
 * <br>Obs.: Excepetion SQL não são capturadas.
 * <p><b>Extends</b><br>DAO
 *  
 * @author Adryano Escorcio
 * @version 2.0
 * */
public class AlunoDAO extends DAO {
	
	/**
	 * <b>Construtor</b><p>
	 * Transmite a conexao do BD para super classe.<br>
	 * E iniciar uma conexa transicao de dados.
	 **/ 
	public AlunoDAO(JPAUtil conexaoBD) {
		super(conexaoBD);
	}
	
	/**
	 * Metodo para inserir/atualiza o Entidade no Banco de Dados.
	 **/
	public boolean save(Aluno aluno) {
		return super.save(aluno);
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
