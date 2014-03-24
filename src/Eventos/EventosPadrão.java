package Eventos;

import javax.swing.JComboBox;
import javax.swing.JPanel;
import DAO.JPAUtil;
import Forms.ComboBoxGroup;
import Forms.TelaPadrao;

@SuppressWarnings("serial")
public abstract class EventosPadrão extends JPanel{
	
	protected JPAUtil conexaoBD = new JPAUtil();
	protected TelaPadrao padrao = new TelaPadrao();
	
	protected static final String SUCESSO = "Operação realizada com sucesso.";
	protected static final String DIR_ICONES = "src/Icones/";
	
	protected ComboBoxGroup comboGroup = new ComboBoxGroup();
	
	public JComboBox<String> getComboBoxTurno() {
		return comboGroup.getComboBoxTurno();
	}

	public JComboBox<String> getComboBoxLetra() {
		return comboGroup.getComboBoxLetra();
	}

	public JComboBox<String> getComboBoxStatus() {
		return comboGroup.getComboBoxStatus();
	}

	public JComboBox<String> getComboBoxEstadosBR() {
		return comboGroup.getComboBoxEstadosBR();
	}

	public JComboBox<String> getComboBoxCorRaca() {
		return comboGroup.getComboBoxCorRaca();
	}

	public JComboBox<String> getComboBoxSexo() {
		return comboGroup.getComboBoxSexo();
	}

	public JComboBox<String> getComboBoxTransferencia() {
		return comboGroup.getComboBoxTransferencia();
	}

	public JComboBox<String> getComboBoxSituacaoAluno() {
		return comboGroup.getComboBoxSituacaoAluno();
	}

	public JComboBox<String> getComboBoxModalidade() {
		return comboGroup.getComboBoxModalidade();
	}

	public JComboBox<String> getComboBoxEnsino() {
		return comboGroup.getComboBoxEnsino();
	}

	/**
	 * Classe que limpa todos os campos de um Frame
	 **/
	public abstract void limparCampos();
	
	/**
	 * Captura os valores dos campos.
	 * @throws erroNullRequisito 
	 **/
	public abstract Object getValoresDosCampos() throws erroNullRequisito;
	
	/**
	 * Atribui valores aos campos da Frame
	 **/
	public abstract void setValoresDosCampos(Object object);
	
	
	
}
