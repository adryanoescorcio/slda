package ComponentGroupPlus;

import java.awt.Color;

import javax.swing.JComboBox;

public class ComboBoxGroup {

	// FONTE
	FontGroup fonte = new FontGroup();
	
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
		combo.setFont(fonte.font_PLA_14);
		
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
		combo.setFont(fonte.font_PLA_14);
		
		return combo;
	}
	
	/**
	 * ComboBox para os Status de um arquivo
	 **/
	public JComboBox<String> getComboBoxStatus() {
		JComboBox<String> combo = new JComboBox<String>();
		
		combo.addItem("CORRENTE");
		combo.addItem("PERMANENTE");
		
		combo.setBackground(Color.white);
		combo.setFont(fonte.font_PLA_14);
		
		return combo;
	}
	
	/**
	 * METODO QUE CRIA UMA CAIXA DE COMBINAÇÃO COM O NOME DAS UFS DO BRASIL E A CONFIGURA
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
		
		combo.setFont(fonte.font_PLA_14);

		return combo;
	}

	/**
	 * Metodo que cria comboBox com a variedade de Cor/Raça da população
	 **/
	public JComboBox<String> getComboBoxCorRaca(){
		
		JComboBox<String> combo = new JComboBox<String>();
		
		combo.setBackground(Color.WHITE);
		combo.addItem("");
		combo.addItem("BRANCO");
		combo.addItem("PRETO");
		combo.addItem("PARDO");
		combo.addItem("AMARELO");
		combo.addItem("INDÍGENA");
		combo.setFont(fonte.font_PLA_14);
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
		combo.addItem("MASCULINO");
		combo.addItem("FEMININO");
		combo.setFont(fonte.font_PLA_14);
		
		return combo;
	}
	
	public JComboBox<String> getComboBoxTransferencia(){
		
		JComboBox<String> combo = new JComboBox<String>();
		
		combo.setBackground(Color.WHITE);
		combo.addItem("NÃO");
		combo.addItem("SIM");
		combo.setFont(fonte.font_PLA_14);
		combo.setLightWeightPopupEnabled(false);
		
		return combo;
	}

	/**
	 * ComboBox para a situação de um aluno
	 **/
	public JComboBox<String> getComboBoxSituacaoAluno(){
		
		JComboBox<String> combo = new JComboBox<String>();
		
		combo.addItem("CONCLUIDO");
		combo.addItem("CURSANDO");
		combo.addItem("TRASNFERIDO");
		combo.addItem("EVADIDO");
		
		combo.setFont(fonte.font_PLA_14);
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
		combo.addItem("MÉDIO");
		combo.addItem("FUNDAMENTAL");

		combo.setBackground(Color.WHITE);
		combo.setFont(fonte.font_PLA_14);
		
		return combo;
	}
	
	public JComboBox<String> getComboBoxEnsinoMEDIO(){
		
		JComboBox<String> combo = new JComboBox<String>();
		
		combo.addItem("REGULAR");
		combo.addItem("EJA");
		combo.addItem("PROEJA");
		combo.addItem("TÉC. CONTABILIDADE");
		
		combo.setBackground(Color.WHITE);
		combo.setFont(fonte.font_PLA_14);
		
		return combo;
	}
	
	public JComboBox<String> getComboBoxEnsinoFUNDAMENTAL(){
		
		JComboBox<String> combo = new JComboBox<String>();
		
		combo.addItem("REGULAR");
		combo.addItem("ACELERAÇÃO");
		combo.addItem("AVANÇO");
		combo.addItem("CLASSE ESPECIAL");
		combo.addItem("EJA");
		
		combo.setBackground(Color.WHITE);
		combo.setFont(fonte.font_PLA_14);
		
		return combo;
	}
	
	public JComboBox<String> getComboBoxSubSecao(){
	
		JComboBox<String> combo = new JComboBox<String>();
		
		combo.addItem("ÍNICIO");
		combo.addItem("MEIO");
		combo.addItem("FIM");
		
		combo.setBackground(Color.WHITE);
		combo.setFont(fonte.font_PLA_14);
		
		return combo;
	}
}
