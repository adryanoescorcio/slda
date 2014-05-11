package Forms;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import Eventos.PlusEventoDiscenteAta;
import Eventos.EventosAluno;

public class PlusPainelDiscenteAta extends PlusEventoDiscenteAta {

	private static JPanel mainDialog = new JPanel();

	private static final int DIST = 5;
	private static final int QUANT_LINHAS_GRID = 6;

	private JPanel painelInternoNorte = new JPanel(new BorderLayout(2,2));
	private JPanel painelEsquerdoInfoAluno = new JPanel(new GridLayout(QUANT_LINHAS_GRID,1,DIST,DIST));
	private JPanel painelDireito = new JPanel(new GridLayout(QUANT_LINHAS_GRID,1,DIST,DIST));
	private JPanel painelContentEIA = new JPanel(new BorderLayout(2,2));

	private JLabel lbDadosAta = new JLabel("DADOS DA ATA",SwingConstants.CENTER);
	private JLabel lbNomeAluno = new JLabel(evento.getAluno().getNomeAluno(), SwingConstants.CENTER);
	private JLabel lbTurma = new JLabel("Turma: ",SwingConstants.RIGHT);
	private JLabel lbTurno = new JLabel("Turno: ",SwingConstants.RIGHT);
	private JLabel lbAno = new JLabel("Ano: ",SwingConstants.RIGHT);
	private JLabel lbModalidade = new JLabel("Modalidade: ",SwingConstants.RIGHT);
	private JLabel lbEnsino = new JLabel("Ensino: ",SwingConstants.RIGHT);
	private JLabel lbPesquisaAta =new JLabel("Índice das atas do aluno: ",SwingConstants.RIGHT);

	public PlusPainelDiscenteAta(EventosAluno evento) {
		super(mainDialog, evento); // passado a tela principal e o evento de aluno com as instancias
		eventoBotoes();

		JPanel painelTopoTitulo = new JPanel(new BorderLayout(2,2));

		painelEsquerdoInfoAluno.add(editPanel.painelNull(0, 0));
		painelEsquerdoInfoAluno.add(lbTurma);
		painelEsquerdoInfoAluno.add(lbTurno);
		painelEsquerdoInfoAluno.add(lbAno);
		painelEsquerdoInfoAluno.add(lbModalidade);
		painelEsquerdoInfoAluno.add(lbEnsino);

		painelDireito.add(editPanel.painelNull(0, 0));
		painelDireito.add(editPanel.painelContentComponent("West", tfTurma));
		painelDireito.add(editPanel.painelContentComponent("West", comboTurno));
		painelDireito.add(editPanel.painelContentComponent("West", ftAno));
		painelDireito.add(editPanel.painelContentComponent("West", comboModalidade));
		painelDireito.add(editPanel.painelContentComponent("West", comboEnsino));

		painelTopoTitulo.add("North", lbDadosAta);
		painelTopoTitulo.add("Center", editPanel.painelNull(0, 10));
		painelTopoTitulo.add("South", lbNomeAluno);

		painelContentEIA.add("North", painelTopoTitulo);
		painelContentEIA.add("West", painelEsquerdoInfoAluno);
		painelContentEIA.add("Center", painelDireito);

		alterarFontes();
		mainDialog.add(painelInternoNorte());
		initJDialog();
	}

	public JPanel getMainDialog() {
		return mainDialog;
	}

	public static void setMainDialog(JPanel mainDialog) {
		PlusPainelDiscenteAta.mainDialog = mainDialog;
	}

	private void eventoBotoes() {
		btnLimpar.addActionListener(onClickLimparCampos);
		btnSalvar.addActionListener(onClickSalvarAtaResultado);
		btnExcluir.addActionListener(onClickExcluir);
		btnCancelar.addActionListener(onClickCancelarOperacao);
		btnPesquisar.addActionListener(onClickPesquisar);
	}

	private JPanel painelInternoNorte() {
		JPanel controleSuperior = new JPanel(new BorderLayout(2,2));
		JPanel contendControl = new JPanel(new BorderLayout(2,2));
		JPanel contentPainel = new JPanel(new BorderLayout(2,2));

		contentPainel.add("Center", painelContentEIA);
		contentPainel.add("West", editPanel.painelNull(10, 0));
		contentPainel.add("East", editPanel.painelNull(50, 0));

		controleSuperior.add("North",contentPainel);
		controleSuperior.setBorder(BorderFactory.createTitledBorder(
				BorderFactory.createSoftBevelBorder(2)));

		contendControl.add("Center", controleSuperior);
		contendControl.add("West", editPanel.painelNull(10, 0));
		contendControl.add("East", painelLocalizar());
		contendControl.add("North", editPanel.painelNull(0, 10));
		contendControl.add("South", editPanel.painelNull(0, 10));

		painelInternoNorte.add("North", contendControl);
		painelInternoNorte.add("East", editPanel.painelNull(10, 0));

		return painelInternoNorte;
	}

	/**
	 * Caixa de localização de item da lista de AtaResultados
	 **/
	private JPanel painelLocalizar() {
		JPanel painelContent = new JPanel(new BorderLayout(2,2));
		JPanel painelLocalizar = new JPanel(new GridLayout(3,1,2,2));
		JPanel ContentPainelLocalizar = new JPanel(new BorderLayout(2,2));

		ContentPainelLocalizar.setBorder(BorderFactory.createTitledBorder(
				BorderFactory.createSoftBevelBorder(2)));

		painelLocalizar.add(lbPesquisaAta);
		painelLocalizar.add(editPanel.painelContentComponent("West", itemComboBoxOrdem()));
		painelLocalizar.add(btnPesquisar);

		ContentPainelLocalizar.add("Center", painelLocalizar);
		ContentPainelLocalizar.add("North", editPanel.painelNull(0, 10));
		ContentPainelLocalizar.add("West", editPanel.painelNull(10, 0));
		ContentPainelLocalizar.add("East", editPanel.painelNull(10, 0));
		ContentPainelLocalizar.add("South", editPanel.painelNull(0, 10));

		painelContent.add("North", ContentPainelLocalizar);
		painelContent.add("Center", painelBotoesSul());
		painelContent.add("West", editPanel.painelNull(10, 0));
		painelContent.add("East", editPanel.painelNull(10, 0));

		return painelContent;
	}

	/**
	 * Paineis que ficam embaixo da caixa de localizar item
	 **/
	private JPanel painelBotoesSul() {
		JPanel contentPainelSul = new JPanel(new BorderLayout(2,2));
		JPanel painelSul = new JPanel(new GridLayout(4,1,5,5));

		painelSul.add(btnSalvar);
		painelSul.add(btnLimpar);
		painelSul.add(btnExcluir);
		painelSul.add(btnCancelar);

		contentPainelSul.add("Center", painelSul);
		contentPainelSul.add("West", editPanel.painelNull(10, 0));
		contentPainelSul.add("East", editPanel.painelNull(10, 0));
		contentPainelSul.add("North", editPanel.painelNull(0, 10));
		contentPainelSul.add("South", editPanel.painelNull(0, 30));

		return contentPainelSul;
	}

	private void initJDialog() {
		mainDialog.setSize(400, 350);
		mainDialog.setVisible(true);		
	}

	private void alterarFontes() {
		// FONTE
		lbTurma.setFont(font.font_PLA_14);
		lbTurno.setFont(font.font_PLA_14);
		lbAno.setFont(font.font_PLA_14);
		lbModalidade.setFont(font.font_PLA_14);
		lbEnsino.setFont(font.font_PLA_14);
		lbPesquisaAta.setFont(font.font_PLA_14);
		lbNomeAluno.setFont(font.font_PLA_14);
		lbDadosAta.setFont(font.font_NEG_15);

		// JTextField
		tfTurma.setFont(font.font_NEG_15);
		ftAno.setFont(font.font_NEG_15);
		tfTurma.setPreferredSize(new Dimension(70,0)); // Setado tamanho fixo do Text

		tfTurma.setSize(20, 10);

		// Cor
		lbTurno.setForeground(Color.RED);
		ftAno.setBackground(Color.WHITE);

		// Outros
		ftAno.setBorder(null); // tirando a borda do component
	}
}
