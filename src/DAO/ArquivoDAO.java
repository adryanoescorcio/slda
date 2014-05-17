package DAO;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.persistence.Query;
import javax.swing.JOptionPane;

import Model.Aluno;
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
	 **/
	public Arquivo buscar(Object codigo) {
		try {
			// tenta realizar consulta usando a interface
			return (Arquivo) this.consultar((InterfaceKey) codigo);

		} catch (Exception e) {
			// tenta fazer consulta composta usando o codigo PK
			try {
				Arquivo arquivo = null;
				ResultSet rs = this.consultarAluno((String) codigo);

				while (rs.next()) {
					arquivo = new Arquivo();
					arquivo.setCodDossie(rs.getString("coddossie")); // insere o codigoDossie
					arquivo.setCodigo(rs.getString("codigoaluno"), rs.getString("codigocaixa"));
					arquivo.setDatadeEntradaArquivo(rs.getString("datadeentradaarquivo"));
				}

				// serve para verificar se o objeto não é null;
				System.out.println("Não Excluir: "+ arquivo.getCodigoAluno() +"(TESTE OBJETO)"); // forçar o erro de nullPoint
				return (Arquivo) arquivo;

			} catch (NullPointerException e1) {
				throw new NullPointerException();
			} catch (SQLException e1) {
				JOptionPane.showMessageDialog(null, "Erro SQL" + e1);
				return null;
			}
		}
	}

	/**
	 * Realiza a consulta do aluno usando o codigo e retorna um arquivo
	 **/
	private ResultSet consultarAluno(String codigo) throws SQLException {
		return stm.executeQuery("Select * from arquivo where codigoaluno =="+codigo);
	}

	@Override
	protected InterfacePadraoEntidade consultar(InterfaceKey codigo) {
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
