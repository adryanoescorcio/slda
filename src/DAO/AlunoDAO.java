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
	
	//METODO QUE RETORNA UMA MATRIZ DE ALUNOS CONTENDO TODOS OS ALUNOS DO BANCO PARA PREENCHER UMA JTABLE
	public String[][] visualizarTodosAluno(){
		String[][] matriz;
		Query query = em.createNamedQuery("Aluno.findAll");
		@SuppressWarnings("unchecked")
		List<Aluno> alunos = query.getResultList();
		
		matriz = new String[alunos.size()][18];
		
		for (int i = 0; i < alunos.size(); i++) {
			Aluno aluno = alunos.get(i); 
			
			matriz[i][0] = aluno.getCodigo();
			matriz[i][1] = aluno.getNomeAluno();
			matriz[i][2] = aluno.getINEP();
			matriz[i][3] = aluno.getCPF_Aluno();
			matriz[i][4] = aluno.getRG_Aluno();
			matriz[i][5] = aluno.getEstadoNascAluno();
			matriz[i][6] = aluno.getCidadeNascAluno();
			matriz[i][7] = aluno.getDataNascimento();
			matriz[i][8] = aluno.getSexoAluno();
			matriz[i][9] = aluno.getCorAluno();
			matriz[i][10] = aluno.getTelefoneAluno();
			matriz[i][11] = aluno.getEnderecoAluno();
			matriz[i][12] = aluno.getNomeMae();
			matriz[i][13] = aluno.getNomePai();
			matriz[i][14] = aluno.getEstadoMaeNasc();
			matriz[i][15] = aluno.getEstadoPaiNasc();
			matriz[i][16] = aluno.getCidadeMaeNasc();
			matriz[i][17] = aluno.getCidadePaiNasc();
			
		}
		
		return matriz;
	}
	

}
