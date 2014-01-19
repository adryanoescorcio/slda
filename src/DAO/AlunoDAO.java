package DAO;

import Model.Aluno;
import Model.PadraoEntidade;

/**
 * Classe concreta para realizar o CRUD da Entidade Aluno.
 * <br>Obs.: Excepetion SQL não são capturadas.
 *  
 * @author Adryano Escorcio
 * @version 1.0
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
		super.inicarTransicao();
	}

	@Override
	public boolean inserirAtualizar(PadraoEntidade entidade){
		
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
	public PadraoEntidade consultar(String codigo) {
		return em.find(Aluno.class, codigo);
	}

	@Override
	public boolean removerPorCodigoPK(String codigo) {
		return super.remover(this.consultar(codigo));
	}

	@Override
	public boolean removerPorObjetoEntidade(PadraoEntidade entidade) {
		return super.remover(this.consultar(entidade.getCodigo()));
	}

}
