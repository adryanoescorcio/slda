package DAO;
import Model.Arquivo;
import Model.PadraoEntidade;

/**
 * Classe concreta para realizar o CRUD da Entidade Arquivo.
 * <p><b>Extends</b><br>DAO
 *  
 * @author Walysson Oliveira
 * @version 1.0
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
	 **/
	public Arquivo buscar(String codigo) {
		return (Arquivo) this.consultar(codigo);
	}
	
	@Override
	protected PadraoEntidade consultar(String codigo) {
		return em.find(Arquivo.class, codigo);
	}
	
}
