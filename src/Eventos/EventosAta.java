package Eventos;

import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JTextField;

import Model.Ata;

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
		Ata ata = new Ata();
		ata.setCodigo(tfTurma.getText(), (String)comboTurno.getSelectedItem(), tffAno.getText());
		ata.setModalidadeAta((String)comboModalidade.getSelectedItem());
		ata.setEnsinoAta((String)comboEnsino.getSelectedItem());
		
		return ata;
	}

	@Override
	public void setValoresDosCampos(Object ata) {
		ata = new Ata();
		tfTurma.setText(((Ata) ata).getTurmaAta());
		comboTurno.setSelectedItem(((Ata) ata).getTurnoAta());
		tffAno.setText(((Ata) ata).getAnoAta());
		comboModalidade.setSelectedItem(((Ata) ata).getModalidadeAta());
		comboEnsino.setSelectedItem(((Ata) ata).getEnsinoAta());
		
	}

}
