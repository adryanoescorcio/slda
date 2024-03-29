package DAO;

import java.util.List;

import javax.persistence.TypedQuery;

import Model.InterfacePadraoEntidade;
import Model.Senha;
import PrimaryKey.InterfaceKey;

public class SenhaDAO extends DAO {

	public SenhaDAO(JPAUtil conexaoBD) {
		super(conexaoBD);
	}
	
	public List<Senha> getSenhas(){
		emPW.clear();
		String comando = "Select s From Senha s";
		TypedQuery<Senha> query = emPW.createQuery(comando, Senha.class);
		
		List<Senha> senhas = null;
		
		try{
			senhas = query.getResultList();
		}catch(Exception e){
		}
	
		return senhas;
	}
	
	public void setMacSenhas(Senha senha, String mac){
		senha.setMac(mac);
		
		emPW.getTransaction().begin();
		emPW.persist(senha);
		emPW.getTransaction().commit();
		emPW.clear(); // limpa a conexao
	}
	
	@Override
	protected InterfacePadraoEntidade consultar(InterfaceKey key) {
		// TODO Auto-generated method stub
		return null;
	}

}
