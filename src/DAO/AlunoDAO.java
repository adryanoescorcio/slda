package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;
import javax.swing.JOptionPane;

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

	public List<Aluno> buscarNome(String nomeLocalizar) {

		// tenta fazer consulta composta usando o codigo PK
		List<Aluno> list = new ArrayList<Aluno>();
		try {
			Aluno aluno = null;
			ResultSet rs = this.consultarAlunoNome((String) nomeLocalizar);
			
			while (rs.next()) {
				aluno = new Aluno(); // cria um aluno vindo dos resultados
				
				aluno.setCodigo(rs.getString("codigoaluno")); // insere o codigoDossie
				aluno.setTranferenciaAluno(rs.getString("tranferenciaaluno"));
				aluno.setTelefoneAluno(rs.getString("telefonealuno"));
				aluno.setSituacaoAluno(rs.getString("situacaoaluno"));
				aluno.setSexoAluno(rs.getString("sexoaluno"));
				aluno.setNomeMae(rs.getString("nomemae"));
				aluno.setNomeAluno(rs.getString("nomealuno"));
				aluno.setEstadoNascAluno(rs.getString("estadonascaluno"));
				aluno.setEnderecoAluno(rs.getString("enderecoaluno"));
				aluno.setDataNascimento(rs.getString("datanascimento"));
				aluno.setDataMatriculaAluno(rs.getString("datamatriculaaluno"));
				aluno.setCorAluno(rs.getString("coraluno"));
				aluno.setCidadeNascAluno(rs.getString("cidadenascaluno"));
				aluno.setCPF_Aluno(rs.getString("cpf_aluno"));
				aluno.setNis(rs.getString("nis"));
				aluno.setLivro(rs.getString("livro"));
				aluno.setFolha(rs.getString("folha"));
				aluno.setNumCertificado(rs.getString("numcertificado"));
				aluno.setDataRegCertif(rs.getString("dataregcertif"));
				
				list.add(aluno); // adiciona o aluno na lista
//				System.out.println(aluno.getNomeAluno());
			}
			
			// serve para verificar se o objeto não é null;
			System.out.println("Não Excluir: "+ aluno.getCodigo() +"(TESTE OBJETO)"); // forçar o erro de nullPoint
			return list;
			
		} catch (NullPointerException e1) {
			JOptionPane.showMessageDialog(null, "Nenhum Aluno foi encontrado no banco de dados.");
			return list;
		} catch (SQLException e1) {
			JOptionPane.showMessageDialog(null, "Erro SQL: " + e1.getMessage());
			return list;
		}
	}

	private ResultSet consultarAlunoNome(String codigo) throws SQLException {
		return stm.executeQuery("SELECT * FROM ALUNO WHERE nomealuno LIKE '%"+codigo+"%'");
	}
	
}
