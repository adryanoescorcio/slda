package Forms;

import java.awt.Color;
import javax.swing.JComboBox;

public class ComboBoxGroup extends TelaPadrao{

	/**
	 * ComboBox para selecionar os Turnos.
	 **/
	public JComboBox<String> getComboBoxTurno() {
		
		JComboBox<String> combo = new JComboBox<String>();
		
		combo.addItem(null);
		combo.addItem("MATUTINO");
		combo.addItem("VESPERTINO");
		combo.addItem("NOTURNO");
		
		combo.setBackground(Color.white);
		combo.setFont(font_PLA_14);
		
		return combo;
	}
	
	/**
	 * ComboBox para as Letras do alfabeto
	 **/
	public JComboBox<String> getComboBoxLetra() {
		JComboBox<String> combo = new JComboBox<String>();
		
		combo.addItem(null);
		combo.addItem("A");
		combo.addItem("B");
		combo.addItem("C");
		combo.addItem("D");
		combo.addItem("E");
		combo.addItem("F");
		combo.addItem("G");
		combo.addItem("H");
		combo.addItem("I");
		combo.addItem("J");
		combo.addItem("K");
		combo.addItem("L");
		combo.addItem("M");
		combo.addItem("N");
		combo.addItem("O");
		combo.addItem("P");
		combo.addItem("R");
		combo.addItem("S");
		combo.addItem("T");
		combo.addItem("U");
		combo.addItem("V");
		combo.addItem("W");
		combo.addItem("X");
		combo.addItem("Y");
		combo.addItem("Z");
		
		combo.setBackground(Color.white);
		combo.setFont(font_PLA_14);
		
		return combo;
	}
	
	/**
	 * ComboBox para os Status de um arquivo
	 **/
	public JComboBox<String> getComboBoxStatus() {
		JComboBox<String> combo = new JComboBox<String>();
		
		combo.addItem("CORRENTE");
		combo.addItem("INTERMEDI�RIO");
		combo.addItem("PERMANENTE");
		
		combo.setBackground(Color.white);
		combo.setFont(font_PLA_14);
		
		return combo;
	}
	
	/**
	 * METODO QUE CRIA UMA CAIXA DE COMBINA��O COM O NOME DAS UFS DO BRASIL E A CONFIGURA
	 **/
	public JComboBox<String> getComboBoxEstadosBR(){
		
		JComboBox<String> combo = new JComboBox<String>();
		
		combo.setBackground(Color.WHITE);
		combo.addItem("");
		combo.addItem("MA");
		combo.addItem("AC");
		combo.addItem("AL");
		combo.addItem("AP");
		combo.addItem("AM");
		combo.addItem("BA");
		combo.addItem("CA");
		combo.addItem("DF");
		combo.addItem("SE");
		combo.addItem("GO");
		combo.addItem("MT");
		combo.addItem("MS");
		combo.addItem("MG");
		combo.addItem("PA");
		combo.addItem("PB");
		combo.addItem("PR");
		combo.addItem("PE");
		combo.addItem("PI");
		combo.addItem("RJ");
		combo.addItem("RN");
		combo.addItem("RS");
		combo.addItem("RO");
		combo.addItem("RR");
		combo.addItem("CS");
		combo.addItem("SP");
		combo.addItem("SE");
		combo.addItem("TO");
		
		combo.setFont(font_PLA_14);

		return combo;
	}

	/**
	 * Metodo que cria comboBox com a variedade de Cor/Ra�a da popula��o
	 **/
	public JComboBox<String> getComboBoxCorRaca(){
		
		JComboBox<String> combo = new JComboBox<String>();
		
		combo.setBackground(Color.WHITE);
		combo.addItem("");
		combo.addItem("1 - BRANCO");
		combo.addItem("2 - PRETO");
		combo.addItem("3 - PARDO");
		combo.addItem("4 - AMARELO");
		combo.addItem("5 - IND�GENA");
		combo.setFont(font_PLA_14);
		combo.setLightWeightPopupEnabled(false);
		
		
		return combo;
	}
	
	/**
	 * ComboBox com tipos de sexo selecionaveis
	 **/
	public JComboBox<String> getComboBoxSexo(){
		
		JComboBox<String> combo = new JComboBox<String>();
		
		combo.setBackground(Color.WHITE);
		combo.addItem("");
		combo.addItem("1 - MASCULINO");
		combo.addItem("2 - FEMININO");
		combo.setFont(font_PLA_14);
		
		return combo;
	}
	
	public JComboBox<String> getComboBoxTransferencia(){
		
		JComboBox<String> combo = new JComboBox<String>();
		
		combo.setBackground(Color.WHITE);
		combo.addItem("1 - N�O");
		combo.addItem("2 - SIM");
		combo.setFont(font_PLA_14);
		combo.setLightWeightPopupEnabled(false);
		
		return combo;
	}

	/**
	 * ComboBox para a situa��o de um aluno
	 **/
	public JComboBox<String> getComboBoxSituacaoAluno(){
		
		JComboBox<String> combo = new JComboBox<String>();
		
		combo.addItem("CURSANDO");
		combo.addItem("CONCLUIDO");
		combo.addItem("TRASNFERIDO");
		combo.addItem("EVADIDO");
		
		combo.setFont(font_PLA_14);
		combo.setBackground(Color.WHITE);
		combo.setLightWeightPopupEnabled(false);
		
		return combo;
	}


	/**
	 * Metodo que cria comboBox com as Modalidades de Ensino
	 **/
	public JComboBox<String> getComboBoxModalidade(){
		
		JComboBox<String> combo = new JComboBox<String>();
		
		combo.addItem("");
		combo.addItem("NORMAL");
		combo.addItem("EJA");

		combo.setBackground(Color.WHITE);
		combo.setFont(font_PLA_14);
		
		return combo;
	}
	
	public JComboBox<String> getComboBoxEnsino(){
		
		JComboBox<String> combo = new JComboBox<String>();
		
		combo.addItem("MEDIO");
		combo.addItem("FUNDAMENTAL");
		
		combo.setBackground(Color.WHITE);
		combo.setFont(font_PLA_14);
		
		return combo;
	}
}