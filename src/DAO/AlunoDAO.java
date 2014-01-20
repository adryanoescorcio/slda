package DAO;

import Model.Aluno;
import Model.PadraoEntidade;

/**
 * Classe concreta para realizar o CRUD da Entidade Aluno.
 * <br>Obs.: Excepetion SQL não são capturadas.
 *  
 * @author Adryano Escorcio
 * @version 1.5
 * @extends DAO
 * 
 * */
public class AlunoDAO extends DAO {
	
	private JPAUtil conexaoBD;

	/**
	 * Construtor
	 * 
	 * Transmite a conexao do BD para super classe.
	 * E iniciar uma conexa transicao de dados.
	 **/ 
	public AlunoDAO(JPAUtil conexaoBD) {
		super(conexaoBD);
		this.conexaoBD = conexaoBD;
	}

	/**
	 * Metodo para inserir/atualiza o Aluno no Banco de Dados
	 **/	
	public boolean save(Aluno aluno){
		super.inicarTransicao();
		try {
			
			return this.saveEntidade(aluno);
			
		} catch (NullPointerException e) {
			System.out.println("Não foi setado EM da classe:" + e.getMessage());
			return false;
		}
	}
	
	/**
	 * Remover Aluno do Banco de Dados
	 * @param <li><b>String</b> codigoAluno</li> <b>or</b>
	 * <li><b>PadraoEntidade</b> aluno </li>
	 **/
	public boolean remover(Object params) {
		super.inicarTransicao();
		
		try {
			return this.removerPorObjetoEntidade((PadraoEntidade) params);
		} catch (Exception e) {
			
			return this.removerPorCodigoPK((String) params);
		}
	}
	/**
	 * Buscar Aluno usando o CodigoAluno
	 **/
	public Aluno buscar(String codigo) {
		super.inicarTransicao();
		return (Aluno) this.consultar(codigo);
	}
	
	@Override
	public JPAUtil getConexaoBD() {
		return this.conexaoBD;
	}
	
	@Override
	public void setConexaoBD(JPAUtil conexaoBD) {
		this.conexaoBD = conexaoBD;
	}
	
	@Override
	protected boolean saveEntidade(PadraoEntidade entidade){
		
		// verificar se a entidade já existe no banco de dados
		PadraoEntidade entidadeTeste = this.consultar(entidade.getCodigo());
		
		//se não existir no BD, persistir entidade
		if(entidadeTeste == null) {
			System.out.println("Salvando: " +entidade.getCodigo());
			
			em.persist(entidade);
			super.fazerCommit();
			
			return true;
			
		} else {
			// se existir no BD, verificar se a entidade foi alterada.
			if(entidadeTeste.toString().equals(entidade.toString())){
				
				System.out.println("Alerta: Não houve modificações na entidade");
				return true;
				
			} else{
				// a entidade foi alterada, então atualize BD
				return super.atualizar(entidade);
			}
		}
	}

	@Override
	protected PadraoEntidade consultar(String codigo) {
		Aluno aluno = em.find(Aluno.class, codigo);
		
		return aluno;
	}

	@Override
	protected boolean removerPorCodigoPK(String codigo) {
		return super.remover(this.consultar(codigo));
	}

	@Override
	protected boolean removerPorObjetoEntidade(PadraoEntidade entidade) {
		return super.remover(this.consultar(entidade.getCodigo()));
	}

}
