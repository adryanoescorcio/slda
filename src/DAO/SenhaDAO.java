package DAO;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.TypedQuery;

import Model.InterfacePadraoEntidade;
import Model.Senha;
import PrimaryKey.InterfaceKey;
import PrimaryKey.SenhaPK;

public class SenhaDAO extends DAO {

	public SenhaDAO(JPAUtil conexaoBD) {
		super(conexaoBD);
	}
	
	public List<Senha> getSenhas(){
		
		String comando = "Select s From Senha s";
		TypedQuery<Senha> query = emPW.createQuery(comando, Senha.class);
		
		List<Senha> senhas = query.getResultList();
	
		return senhas;
	}
	
	public void setMacSenhas(Senha senha, String mac){
		senha.setMac(mac);
		super.save(senha);
		
	}
	
	public boolean del(String senha){
		
		SenhaPK pk = new SenhaPK();
		pk.setCodigo(senha);
		
		try{
			emPW.getTransaction().begin();
			Query query = em.createQuery("DELETE FROM Senha s where s.pass = :senha");
			query.setParameter("senha", pk);
			query.executeUpdate();
			emPW.getTransaction().commit();
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	@Override
	protected InterfacePadraoEntidade consultar(InterfaceKey key) {
		// TODO Auto-generated method stub
		return null;
	}

}