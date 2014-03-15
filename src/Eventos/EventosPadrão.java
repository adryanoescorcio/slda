package Eventos;

import javax.swing.JPanel;

import DAO.JPAUtil;
import Forms.TelaPadrao;

@SuppressWarnings("serial")
public abstract class EventosPadrão extends JPanel{
	protected JPAUtil conexaoBD = new JPAUtil();
	protected TelaPadrao padrao = new TelaPadrao();
	public abstract void limparCampos();
	public abstract Object getValoresDosCampos();
	public abstract void setValoresDosCampos(Object object);
	
}
