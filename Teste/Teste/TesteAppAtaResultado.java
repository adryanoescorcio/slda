package Teste;
import java.util.Random;

import javax.persistence.EntityManager;

import org.junit.Test;

import DAO.AlunoDAO;
import DAO.AtaDAO;
import DAO.AtaResultadoDAO;
import DAO.CaixaDAO;
import DAO.JPAUtil;
import Model.Aluno;
import Model.Ata;
import Model.AtaPK;
import Model.AtaResultado;

public class TesteAppAtaResultado {

	private static final int INTERVALO = 999999999;
	EntityManager em;
	private JPAUtil conexaoBD;
	private Random rand;
	private AtaResultadoDAO dao;
	private AlunoDAO alunoDAO;
	private AtaDAO ataDAO;
	

	public TesteAppAtaResultado() {
		this.conexaoBD = new JPAUtil();
		dao = new AtaResultadoDAO(conexaoBD);
		alunoDAO = new AlunoDAO(conexaoBD);
		ataDAO = new AtaDAO(conexaoBD);
	}

    @Test
	public void conexao() {
		EntityManager em = dao.getEm();
		System.out.println(em.isOpen()); 
		em.getTransaction().begin();
		AtaResultado ataResultado = new AtaResultado();
		Aluno aluno = new Aluno();
		aluno.setCodigo(numAleatorio());
		AtaPK ata = new AtaPK();
		ata.setAnoAta("2014");
		ata.setTurmaAta("309");
		ata.setTurnoAta("Vespertino");
		ataResultado.setCodigo("688560366 - 309 - 2014 - Vespertino");
		ataResultado.setCodAluno("688560366");
		ataResultado.setAta(ata);
		em.persist(ataResultado); 
		em.getTransaction().commit();
	}

	public String numAleatorio(){
		rand = new Random();
		String numAle = String.valueOf(rand.nextInt(INTERVALO));
		return numAle;
	}

}