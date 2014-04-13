package DAO;

import java.util.List;

import javax.persistence.Query;

import Model.Aluno;
import Model.AtaResultado;
import Model.InterfacePadraoEntidade;
import PrimaryKey.AtaResultadoPK;
import PrimaryKey.InterfaceKey;

/**
 * Classe concreta para realizar o CRUD da Entidade AtaResultado.
 * <p><b>Extends</b><br>DAO
 * @author Adryano Escorcio
 * @version 1.5
 * */
public class AtaResultadoDAO extends DAO {

	/**
	 * <b>Construtor</b><p>
	 * Transmite a conexao do BD para super classe.<br>
	 * E inicia uma conexa transacao de dados.
	 **/ 
	public AtaResultadoDAO(JPAUtil conexaoBD) {
		super(conexaoBD);
	}
	
	/**
	 * Metodo para inserir/atualiza o Entidade no Banco de Dados.
	 **/
	public boolean save(AtaResultado ataResultado) {
		return super.save(ataResultado);
	}
	
	/**
	 * Buscar Caixa usando o codigo
	 **/
	public AtaResultado buscar(AtaResultadoPK codigo) {
		return (AtaResultado) this.consultar(codigo);
	}
	
	@Override
	protected InterfacePadraoEntidade consultar(InterfaceKey codigo) {
		return em.find(AtaResultado.class, codigo);
	}

	public List<AtaResultado> buscarAtaporAluno(Aluno aluno){
		
		String codAluno = aluno.getCodigo();
		
		Query query = em.createNamedQuery("AtaResultado.findByAluno");
		query.setParameter("aluno", codAluno);
		
		@SuppressWarnings("unchecked")
		List<AtaResultado> ataResultado = query.getResultList();
			
		return ataResultado;
	}
	
	 /**
     * Busta a AtaResultado com o codigo do aluno
     **/
//	public List<AtaResultado> buscaAta(Aluno aln) {
//		List<AtaResultado> list = new ArrayList<AtaResultado>();
//		try {
//			ResultSet rs = stm.executeQuery("Select * from ataresultado where aluno = '"+aln.getCodigo()+"'");
//			while(rs.next()){
//				AtaResultado ataResul = new AtaResultado();
//				ataResul.setAluno(rs.getString("aluno")); // setando o codigo do aluno
//				ataResul.setTurmaAta(rs.getString("turmaata")); // setando a turma da ata
//				ataResul.setAnoAta(rs.getString("anoata")); // setando o ano
//				ataResul.setTurnoAta(rs.getString("turnoata")); // setando o turno
//				ataResul.setNomeAluno(aln.getNomeAluno()); // setando o codigo do aluno
//				
//				list.add(ataResul); // inserindo na lista
//			}
//		} catch (SQLException e) {
//			System.out.println("ERS01");
//		}
//		return list;
//	}
}
