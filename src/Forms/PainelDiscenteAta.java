package Forms;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import Eventos.EventoDiscenteAta;
import Eventos.EventosAluno;

public class PainelDiscenteAta extends EventoDiscenteAta {
	
	private static JPanel mainDialog = new JPanel();
	
	private static final int DIST = 5;
	private static final int QUANT_LINHAS_GRID = 6;

	private JPanel painelInternoNorte = new JPanel(new BorderLayout(2,2));
	private JPanel painelEsquerdoInfoAluno = new JPanel(new GridLayout(QUANT_LINHAS_GRID,1,DIST,DIST));
	private JPanel painelDireito = new JPanel(new GridLayout(QUANT_LINHAS_GRID,1,DIST,DIST));
	private JPanel painelContentEIA = new JPanel(new BorderLayout(2,2));
	
	private JLabel lbDadosAta = new JLabel("DADOS DA ATA",SwingConstants.CENTER);
	private JLabel lbTurma = new JLabel("Turma: ",SwingConstants.RIGHT);
	private JLabel lbTurno = new JLabel("Turno: ",SwingConstants.RIGHT);
	private JLabel lbAno = new JLabel("Ano: ",SwingConstants.RIGHT);
	private JLabel lbModalidade = new JLabel("Modalidade: ",SwingConstants.RIGHT);
	private JLabel lbEnsino = new JLabel("Ensino: ",SwingConstants.RIGHT);
	
	public PainelDiscenteAta(EventosAluno evnAluno) {
		super(mainDialog,evnAluno);
		eventoBotoes();
		
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
		
		painelContentEIA.add("North", lbDadosAta);
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
		PainelDiscenteAta.mainDialog = mainDialog;
	}

	private void eventoBotoes() {
		btnLimpar.addActionListener(onClickLimparCampos);
		btnSalvar.addActionListener(onClickSalvarAtaResultado);
//		btnUltimaAta.addActionListener(onClickUltimaAta);
		btnCancelar.addActionListener(onClickCancelarOperacao);
	}

	private JPanel painelInternoNorte() {
		JPanel controleSuperior = new JPanel(new BorderLayout(2,2));
		JPanel contendControl = new JPanel(new BorderLayout(2,2));
		JPanel contentPainel = new JPanel(new BorderLayout(2,2));
		
		contentPainel.add("Center", painelContentEIA);
		contentPainel.add("West", editPanel.painelNull(10, 0));
		
		controleSuperior.add("North",contentPainel);
		controleSuperior.setBorder(BorderFactory.createTitledBorder(
				BorderFactory.createSoftBevelBorder(2)));
		
		contendControl.add("Center", controleSuperior);
		contendControl.add("West", editPanel.painelNull(10, 0));
		contendControl.add("East", editPanel.painelNull(10, 0));
		contendControl.add("North", editPanel.painelNull(0, 10));
		contendControl.add("South", editPanel.painelNull(0, 10));
		
		painelInternoNorte.add("North", contendControl);
		painelInternoNorte.add("Center", painelBotõesSul());
		
		return painelInternoNorte;
	}
	
	private JPanel painelBotõesSul() {
		JPanel contentPainelSul = new JPanel(new BorderLayout(2,2));
		JPanel painelSul = new JPanel(new GridLayout(1,3,5,5));
		
		painelSul.add(editPanel.painelContentComponent("East",btnSalvar));
		painelSul.add(editPanel.painelContentComponent("West",btnLimpar));
//		painelSul.add(editPanel.painelContentComponent("East",btnUltimaAta));
		painelSul.add(editPanel.painelContentComponent("West",btnCancelar));
		
		contentPainelSul.add("Center", painelSul);
		contentPainelSul.add("West", editPanel.painelNull(10, 0));
		contentPainelSul.add("East", editPanel.painelNull(10, 0));
		contentPainelSul.add("North", editPanel.painelNull(0, 10));
		contentPainelSul.add("South", editPanel.painelNull(0, 30));
		
		return contentPainelSul;
	}

	private void initJDialog() {
		mainDialog.setSize(400, 350);
//		mainDialog.setTitle(TITLE);
//		mainDialog.setLocationRelativeTo(null);
//		mainDialog.setModal(true);
//		mainDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//		mainDialog.setResizable(false);
		mainDialog.setVisible(true);		
	}
	
	private void alterarFontes() {
		// FONTE
		lbTurma.setFont(font.font_PLA_14);
		lbTurno.setFont(font.font_PLA_14);
		lbAno.setFont(font.font_PLA_14);
		lbModalidade.setFont(font.font_PLA_14);
		lbEnsino.setFont(font.font_PLA_14);
		lbDadosAta.setFont(font.font_NEG_15);
		
		// JTextField
		tfTurma.setFont(font.font_NEG_15);
		tfTurma.setPreferredSize(new Dimension(70,0)); // Setado tamanho fixo do Text
		
		tfTurma.setSize(20, 10);
		
		// Cor
		lbTurno.setForeground(Color.RED);
		ftAno.setBackground(Color.WHITE);
		
		// Outros
		ftAno.setBorder(null); // tirando a borda do component
	}
}
