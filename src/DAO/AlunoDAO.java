package DAO;

import Model.Aluno;
import Model.InterfacePadraoEntidade;
import PrimaryKey.AlunoPK;
import PrimaryKey.InterfaceKey;

/**
 * Classe concreta para realizar o CRUD da Entidade Aluno.
 * <br>Obs.: Excepetion SQL não são capturadas.
 * <p><b>Extends</b><br>DAO
 *  
 * @author Adryano Escorcio
 * @version 2.0
 * */
public class AlunoDAO extends DAO {
	
	private AlunoPK pk;

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
		pk = new AlunoPK();
		pk.setCodigo(codigo);
		
		return (Aluno) this.consultar(pk);
	}
	
	@Override
	protected InterfacePadraoEntidade consultar(InterfaceKey codigo) {
		return em.find(Aluno.class, codigo);
	}

}
