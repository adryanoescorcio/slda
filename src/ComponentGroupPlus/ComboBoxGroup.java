package ComponentGroupPlus;

import java.awt.Color;

import javax.swing.JComboBox;

public class ComboBoxGroup {

	// FONTE
	FontGroup fonte = new FontGroup();

	/**
	 * Metodo que cria comboBox com a variedade de Cor/Raça da população
	 **/
	public JComboBox<String> getComboBoxCorRaca() {

		final JComboBox<String> combo = new JComboBox<String>();

		combo.setBackground(Color.WHITE);
		combo.addItem(Messages.getString("ComboBoxGroup.0")); //$NON-NLS-1$
		combo.addItem(Messages.getString("ComboBoxGroup.1")); //$NON-NLS-1$
		combo.addItem(Messages.getString("ComboBoxGroup.2")); //$NON-NLS-1$
		combo.addItem(Messages.getString("ComboBoxGroup.3")); //$NON-NLS-1$
		combo.addItem(Messages.getString("ComboBoxGroup.4")); //$NON-NLS-1$
		combo.addItem(Messages.getString("ComboBoxGroup.5")); //$NON-NLS-1$
		combo.addItem(Messages.getString("ComboBoxGroup.6")); //$NON-NLS-1$
		combo.setFont(fonte.font_PLA_14);
		combo.setLightWeightPopupEnabled(false);

		return combo;
	}

	public JComboBox<String> getComboBoxEnsinoFUNDAMENTAL() {

		final JComboBox<String> combo = new JComboBox<String>();

		combo.addItem(Messages.getString("ComboBoxGroup.7")); //$NON-NLS-1$
		combo.addItem(Messages.getString("ComboBoxGroup.8")); //$NON-NLS-1$
		combo.addItem(Messages.getString("ComboBoxGroup.9")); //$NON-NLS-1$
		combo.addItem(Messages.getString("ComboBoxGroup.10")); //$NON-NLS-1$
		combo.addItem(Messages.getString("ComboBoxGroup.11")); //$NON-NLS-1$

		combo.setBackground(Color.WHITE);
		combo.setFont(fonte.font_PLA_14);
		combo.setLightWeightPopupEnabled(false);

		return combo;
	}

	public JComboBox<String> getComboBoxEnsinoMEDIO() {
		final JComboBox<String> combo = new JComboBox<String>();

		combo.addItem(Messages.getString("ComboBoxGroup.12")); //$NON-NLS-1$
		combo.addItem(Messages.getString("ComboBoxGroup.13")); //$NON-NLS-1$
		combo.addItem(Messages.getString("ComboBoxGroup.14")); //$NON-NLS-1$
		combo.addItem(Messages.getString("ComboBoxGroup.15")); //$NON-NLS-1$

		combo.setBackground(Color.WHITE);
		combo.setFont(fonte.font_PLA_14);
		combo.setLightWeightPopupEnabled(false);

		return combo;
	}

	/**
	 * Metodo que cria comboBox com as Modalidades de Ensino
	 **/
	public JComboBox<String> getComboBoxEnsinoMF() {

		final JComboBox<String> combo = new JComboBox<String>();

		combo.addItem(Messages.getString("ComboBoxGroup.16")); //$NON-NLS-1$
		combo.addItem(Messages.getString("ComboBoxGroup.17")); //$NON-NLS-1$

		combo.setBackground(Color.WHITE);
		combo.setFont(fonte.font_PLA_14);
		combo.setLightWeightPopupEnabled(false);

		return combo;
	}

	/**
	 * METODO QUE CRIA UMA CAIXA DE COMBINAÇÃO COM O NOME DAS UFS DO BRASIL E A
	 * CONFIGURA
	 **/
	public JComboBox<String> getComboBoxEstadosBR() {

		final JComboBox<String> combo = new JComboBox<String>();

		combo.setBackground(Color.WHITE);
		combo.addItem(Messages.getString("ComboBoxGroup.18")); //$NON-NLS-1$
		combo.addItem(Messages.getString("ComboBoxGroup.19")); //$NON-NLS-1$
		combo.addItem(Messages.getString("ComboBoxGroup.20")); //$NON-NLS-1$
		combo.addItem(Messages.getString("ComboBoxGroup.21")); //$NON-NLS-1$
		combo.addItem(Messages.getString("ComboBoxGroup.22")); //$NON-NLS-1$
		combo.addItem(Messages.getString("ComboBoxGroup.23")); //$NON-NLS-1$
		combo.addItem(Messages.getString("ComboBoxGroup.24")); //$NON-NLS-1$
		combo.addItem(Messages.getString("ComboBoxGroup.25")); //$NON-NLS-1$
		combo.addItem(Messages.getString("ComboBoxGroup.26")); //$NON-NLS-1$
		combo.addItem(Messages.getString("ComboBoxGroup.27")); //$NON-NLS-1$
		combo.addItem(Messages.getString("ComboBoxGroup.28")); //$NON-NLS-1$
		combo.addItem(Messages.getString("ComboBoxGroup.29")); //$NON-NLS-1$
		combo.addItem(Messages.getString("ComboBoxGroup.30")); //$NON-NLS-1$
		combo.addItem(Messages.getString("ComboBoxGroup.31")); //$NON-NLS-1$
		combo.addItem(Messages.getString("ComboBoxGroup.32")); //$NON-NLS-1$
		combo.addItem(Messages.getString("ComboBoxGroup.33")); //$NON-NLS-1$
		combo.addItem(Messages.getString("ComboBoxGroup.34")); //$NON-NLS-1$
		combo.addItem(Messages.getString("ComboBoxGroup.35")); //$NON-NLS-1$
		combo.addItem(Messages.getString("ComboBoxGroup.36")); //$NON-NLS-1$
		combo.addItem(Messages.getString("ComboBoxGroup.37")); //$NON-NLS-1$
		combo.addItem(Messages.getString("ComboBoxGroup.38")); //$NON-NLS-1$
		combo.addItem(Messages.getString("ComboBoxGroup.39")); //$NON-NLS-1$
		combo.addItem(Messages.getString("ComboBoxGroup.40")); //$NON-NLS-1$
		combo.addItem(Messages.getString("ComboBoxGroup.41")); //$NON-NLS-1$
		combo.addItem(Messages.getString("ComboBoxGroup.42")); //$NON-NLS-1$
		combo.addItem(Messages.getString("ComboBoxGroup.43")); //$NON-NLS-1$
		combo.addItem(Messages.getString("ComboBoxGroup.44")); //$NON-NLS-1$
		combo.addItem(Messages.getString("ComboBoxGroup.45")); //$NON-NLS-1$

		combo.setFont(fonte.font_PLA_14);
		combo.setLightWeightPopupEnabled(false);

		return combo;
	}

	/**
	 * ComboBox para as Letras do alfabeto
	 **/
	public JComboBox<String> getComboBoxLetra() {
		final JComboBox<String> combo = new JComboBox<String>();

		combo.addItem(null);
		combo.addItem(Messages.getString("ComboBoxGroup.46")); //$NON-NLS-1$
		combo.addItem(Messages.getString("ComboBoxGroup.47")); //$NON-NLS-1$
		combo.addItem(Messages.getString("ComboBoxGroup.48")); //$NON-NLS-1$
		combo.addItem(Messages.getString("ComboBoxGroup.49")); //$NON-NLS-1$
		combo.addItem(Messages.getString("ComboBoxGroup.50")); //$NON-NLS-1$
		combo.addItem(Messages.getString("ComboBoxGroup.51")); //$NON-NLS-1$
		combo.addItem(Messages.getString("ComboBoxGroup.52")); //$NON-NLS-1$
		combo.addItem(Messages.getString("ComboBoxGroup.53")); //$NON-NLS-1$
		combo.addItem(Messages.getString("ComboBoxGroup.54")); //$NON-NLS-1$
		combo.addItem(Messages.getString("ComboBoxGroup.55")); //$NON-NLS-1$
		combo.addItem(Messages.getString("ComboBoxGroup.56")); //$NON-NLS-1$
		combo.addItem(Messages.getString("ComboBoxGroup.57")); //$NON-NLS-1$
		combo.addItem(Messages.getString("ComboBoxGroup.58")); //$NON-NLS-1$
		combo.addItem(Messages.getString("ComboBoxGroup.59")); //$NON-NLS-1$
		combo.addItem(Messages.getString("ComboBoxGroup.60")); //$NON-NLS-1$
		combo.addItem(Messages.getString("ComboBoxGroup.61")); //$NON-NLS-1$
		combo.addItem(Messages.getString("ComboBoxGroup.62")); //$NON-NLS-1$
		combo.addItem(Messages.getString("ComboBoxGroup.63")); //$NON-NLS-1$
		combo.addItem(Messages.getString("ComboBoxGroup.64")); //$NON-NLS-1$
		combo.addItem(Messages.getString("ComboBoxGroup.65")); //$NON-NLS-1$
		combo.addItem(Messages.getString("ComboBoxGroup.66")); //$NON-NLS-1$
		combo.addItem(Messages.getString("ComboBoxGroup.67")); //$NON-NLS-1$
		combo.addItem(Messages.getString("ComboBoxGroup.68")); //$NON-NLS-1$
		combo.addItem(Messages.getString("ComboBoxGroup.69")); //$NON-NLS-1$
		combo.addItem(Messages.getString("ComboBoxGroup.70")); //$NON-NLS-1$

		combo.setBackground(Color.white);
		combo.setFont(fonte.font_PLA_14);
		combo.setLightWeightPopupEnabled(false);

		return combo;
	}

	public JComboBox<String> getComboBoxNumero() {
		final JComboBox<String> combo = new JComboBox<String>();

		// colocar os valores de 1 ate 100
		for (int i = 1; i < 101; i++) {
			combo.addItem(String.valueOf(i));
		}

		combo.setBackground(Color.WHITE);
		combo.setFont(fonte.font_PLA_14);
		combo.setLightWeightPopupEnabled(false);

		return combo;
	}

	/**
	 * ComboBox com tipos de sexo selecionaveis
	 **/
	public JComboBox<String> getComboBoxSexo() {

		final JComboBox<String> combo = new JComboBox<String>();

		combo.setBackground(Color.WHITE);
		combo.addItem(Messages.getString("ComboBoxGroup.71")); //$NON-NLS-1$
		combo.addItem(Messages.getString("ComboBoxGroup.72")); //$NON-NLS-1$
		combo.addItem(Messages.getString("ComboBoxGroup.73")); //$NON-NLS-1$
		combo.setFont(fonte.font_PLA_14);
		combo.setLightWeightPopupEnabled(false);
		
		return combo;
	}

	/**
	 * ComboBox para a situação de um aluno
	 **/
	public JComboBox<String> getComboBoxSituacaoAluno() {

		final JComboBox<String> combo = new JComboBox<String>();

		combo.addItem(Messages.getString("ComboBoxGroup.74")); //$NON-NLS-1$
		combo.addItem(Messages.getString("ComboBoxGroup.75")); //$NON-NLS-1$
		combo.addItem(Messages.getString("ComboBoxGroup.91")); //$NON-NLS-1$
		combo.addItem(Messages.getString("ComboBoxGroup.92")); //$NON-NLS-1$
		combo.addItem(Messages.getString("ComboBoxGroup.76")); //$NON-NLS-1$
		combo.addItem(Messages.getString("ComboBoxGroup.77")); //$NON-NLS-1$
		combo.addItem(Messages.getString("ComboBoxGroup.78")); //$NON-NLS-1$
		combo.addItem("REPROVADO");
		combo.addItem("APROVADO");

		combo.setFont(fonte.font_PLA_14);
		combo.setBackground(Color.WHITE);
		combo.setLightWeightPopupEnabled(false);

		return combo;
	}

	/**
	 * ComboBox para os Status de um arquivo
	 **/
	public JComboBox<String> getComboBoxStatus() {
		final JComboBox<String> combo = new JComboBox<String>();

		combo.addItem(Messages.getString("ComboBoxGroup.79")); //$NON-NLS-1$
		combo.addItem(Messages.getString("ComboBoxGroup.80")); //$NON-NLS-1$

		combo.setBackground(Color.white);
		combo.setFont(fonte.font_PLA_14);
		combo.setLightWeightPopupEnabled(false);

		return combo;
	}

	public JComboBox<String> getComboBoxStatusDocumento() {

		final JComboBox<String> combo = new JComboBox<String>();

		combo.addItem(Messages.getString("ComboBoxGroup.81")); //$NON-NLS-1$
		combo.addItem(Messages.getString("ComboBoxGroup.82")); //$NON-NLS-1$

		combo.setBackground(Color.white);
		combo.setFont(fonte.font_PLA_14);
		combo.setLightWeightPopupEnabled(false);
		
		return combo;
	}

	public JComboBox<String> getComboBoxSubSecao() {

		final JComboBox<String> combo = new JComboBox<String>();

		combo.addItem(Messages.getString("ComboBoxGroup.83")); //$NON-NLS-1$
		combo.addItem(Messages.getString("ComboBoxGroup.84")); //$NON-NLS-1$
		combo.addItem(Messages.getString("ComboBoxGroup.85")); //$NON-NLS-1$

		combo.setBackground(Color.WHITE);
		combo.setFont(fonte.font_PLA_14);
		combo.setLightWeightPopupEnabled(false);

		return combo;
	}

	public JComboBox<String> getComboBoxTransferencia() {

		final JComboBox<String> combo = new JComboBox<String>();

		combo.setBackground(Color.WHITE);
		combo.addItem(Messages.getString("ComboBoxGroup.86")); //$NON-NLS-1$
		combo.addItem(Messages.getString("ComboBoxGroup.87")); //$NON-NLS-1$
		combo.setFont(fonte.font_PLA_14);
		combo.setLightWeightPopupEnabled(false);

		return combo;
	}

	/**
	 * ComboBox para selecionar os Turnos.
	 **/
	public JComboBox<String> getComboBoxTurno() {

		final JComboBox<String> combo = new JComboBox<String>();

		combo.addItem(null);
		combo.addItem(Messages.getString("ComboBoxGroup.88")); //$NON-NLS-1$
		combo.addItem(Messages.getString("ComboBoxGroup.89")); //$NON-NLS-1$
		combo.addItem(Messages.getString("ComboBoxGroup.90")); //$NON-NLS-1$

		combo.setBackground(Color.white);
		combo.setFont(fonte.font_PLA_14);
		combo.setLightWeightPopupEnabled(false);

		return combo;
	}
}
