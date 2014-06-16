package DAO;

import java.util.List;

import javax.persistence.TypedQuery;

import Model.InterfacePadraoEntidade;
import Model.Senha;
import PrimaryKey.InterfaceKey;

public class SenhaDAO extends DAO {

	public SenhaDAO(final JPAUtil conexaoBD) {
		super(conexaoBD);
	}

	@Override
	protected InterfacePadraoEntidade consultar(final InterfaceKey key) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Senha> getSenhas() {
		emPW.clear();
		final String comando = Messages.getString("SenhaDAO.0"); //$NON-NLS-1$
		final TypedQuery<Senha> query = emPW.createQuery(comando, Senha.class);

		List<Senha> senhas = null;

		try {
			senhas = query.getResultList();

		} catch (final Exception e) {
		}

		return senhas;
	}

	public void setMacSenhas(final Senha senha, final String mac) {
		senha.setMac(mac);

		emPW.getTransaction().begin();
		emPW.persist(senha);
		emPW.getTransaction().commit();
		emPW.clear(); // limpa a conexao
	}

}
