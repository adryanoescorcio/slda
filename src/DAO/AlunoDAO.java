package DAO;

import java.util.List;

import javax.persistence.Query;

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
	public Aluno buscar(AlunoPK codigo) {
		return (Aluno) this.consultar(codigo);
	}
	
	@Override
	protected InterfacePadraoEntidade consultar(InterfaceKey codigo) {
		return em.find(Aluno.class, codigo);
	}
	
	public boolean isExist(String codigo) {
		AlunoPK pk = new AlunoPK();
		pk.setCodigo(codigo);
		
		Aluno alunoDaConsulta = (Aluno) this.consultar(pk);
		
		try{
			alunoDaConsulta.toString();
			return true;
		} catch (NullPointerException e) {
			return false;
		}
	}
	
	/**
	 * RETORNA TODAS OS ALUNOS DO BANCO
	 **/
	public List<Aluno> getTodosAlunos(){
		
		Query query = em.createNamedQuery("Aluno.findAll");
		@SuppressWarnings("unchecked")
		List<Aluno> alunos = query.getResultList();
		
		return alunos;
	}
	
}
