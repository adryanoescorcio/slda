package DAO;
import java.sql.SQLException;

import javax.persistence.Query;

import Model.Arquivo;
import Model.Caixa;
import Model.InterfacePadraoEntidade;
import PrimaryKey.InterfaceKey;

/**
 * Classe concreta para realizar o CRUD da Entidade Arquivo.
 * <p><b>Extends</b><br>DAO
 *  
 * @author Walysson Oliveira
 * @version 1.5
 * */
public class ArquivoDAO extends DAO {

	/**
	 * <b>Construtor</b><p>
	 * Transmite a conexao do BD para super classe.<br>
	 * E inicia uma conexa transacao de dados.
	 **/ 
	public ArquivoDAO(JPAUtil conexaoBD) {
		super(conexaoBD);
	}

	/**
	 * Metodo para inserir/atualiza o Entidade no Banco de Dados.
	 **/
	public boolean save(Arquivo arquivo) {
		return super.save(arquivo);
	}

	/**
	 * Buscar Caixa usando o codigo
	 * @return arquivo
	 * @throws SQLException 
	 **/
	public Arquivo buscar(Object codigo) throws SQLException {
		
			Arquivo arq = new Arquivo();
			em.getTransaction().begin();
			// tenta realizar consulta usando a interface
			arq = (Arquivo) this.consultar((InterfaceKey) codigo);
			em.getTransaction().commit();
			return arq;
	}

	/**
	 * Realiza a consulta do aluno usando o codigo e retorna um arquivo
	 **/
//	private ResultSet consultarAluno(String codigo) throws SQLException {
//		return stm.executeQuery("Select * from arquivo where codigoaluno =="+codigo);
//	}

	@Override
	protected InterfacePadraoEntidade consultar(InterfaceKey codigo) {
		em.clear();
		return em.find(Arquivo.class, codigo);
	}
	
	
	public void excluirPorCaixa(Caixa caixa){
		
		String codCaixa = caixa.getCodigo();
		
		try{
			em.getTransaction().begin();
			Query query = em.createQuery("DELETE FROM Arquivo a where a.codigoCaixa = :caixa");
			query.setParameter("caixa", codCaixa);
			query.executeUpdate();
			em.getTransaction().commit();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
