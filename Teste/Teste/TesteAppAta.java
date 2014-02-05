package Teste;

import java.util.Random;

import javax.persistence.EntityManager;

import org.junit.Test;

import DAO.AtaDAO;
import DAO.JPAUtil;
import Model.Ata;
import Model.AtaPK;

public class TesteAppAta {

	private static final int INTERVALO = 999999999;
	EntityManager em;
	private JPAUtil conexaoBD;
	private Random rand;
	private AtaDAO dao;

	public TesteAppAta() {
		this.conexaoBD = new JPAUtil();
		dao = new AtaDAO(conexaoBD);
	}

    @Test
	public void conexao() {
		EntityManager em = dao.getEm();
		System.out.println(em.isOpen()); 
	}
	
//	@Test
	public void inserirAtualizarAta() {
	
		// instanciando caixa
		Ata ata = new Ata();
		
		// Setando os valores
		AtaPK atapk = new AtaPK();
		atapk.setTurmaAta("402");
		atapk.setAnoAta("2014");
		atapk.setTurnoAta("Vespertino");
//		ata.setAtapk(atapk);
		ata.setCodigo(getCodigoDaAta(atapk));
		ata.setModalidadeAta("Normal");
		ata.setEnsinoAta("Medio");
		
		System.out.println("\n####### Iniciando Teste 1 #######");
		System.out.println("\n+++ Primeiro Teste - Inserir");
				
		// inserindo caixa
		boolean retorno = dao.save(ata);
				
		// verificando o retorno
		if(retorno)
			System.out.println("\n****** Teste 1 - 100% OK ******");
	}
	
//	@Test
	public void removerAluno(){
		
		Ata ata = new Ata();
		// instanciando caixa
		AtaPK atapk = new AtaPK();
		atapk.setTurmaAta("406");
		atapk.setAnoAta("2013");
		atapk.setTurnoAta("Vespertino");
//		ata.setAtapk(atapk);
		ata.setCodigo(getCodigoDaAta(atapk));
		ata.setModalidadeAta("Normal");
		ata.setEnsinoAta("Superior");
		
		System.out.println("\n#### Iniciando Teste 2 ####");
		// caixa é inserida
		dao.save(ata);
		
		// remover aluno
		boolean retorno = dao.remover(ata);
		
		if(retorno)
			System.out.println("****** OK Teste 2. ******");
	}
	
//	@Test
	public void consultarCaixa(){
		System.out.println("\n#### Iniciando Teste 3 ####");
		
		// Codigo: 20120124500
		Ata ata = dao.buscar("402 - 2014 - Vespertino");
		
		try{
			System.out.println(ata.toString());
		} catch (NullPointerException e) {
			System.out.println("Atencao: Não existe nenhuma caixa com o codigo digitado");
		}
		
		System.out.println("****** OK Teste 3. ******");
	}
	
	public String numAleatorio(){
		rand = new Random();
		String numAle = String.valueOf(rand.nextInt(INTERVALO));
		return numAle;
	}
	
	public String getCodigoDaAta(AtaPK atapk){
		return atapk.getTurmaAta() + " - " + atapk.getAnoAta() + " - " + atapk.getTurnoAta();
	}

}
