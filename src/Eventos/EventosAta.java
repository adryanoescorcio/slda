package Eventos;

import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class EventosAta extends EventosPadrão{

	//DECLARAÇÃO DE VARIÁVEIS
	protected JTextField tfTurma;
	protected JTextField tfMatricula;
	protected JFormattedTextField tffAno;
	protected JComboBox<String> comboTurno, comboModalidade, comboEnsino;
	
	@Override
	public void limparCampos() {
		tfTurma.setText("");
		comboTurno.setSelectedIndex(0);
		tffAno.setText("");
		comboModalidade.setSelectedIndex(0);
		comboEnsino.setSelectedIndex(0);
		tfMatricula.setText("");
	}
	
	@Override
	public Object getValoresDosCampos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setValoresDosCampos(Object object) {
		// TODO Auto-generated method stub
		
	}

}
