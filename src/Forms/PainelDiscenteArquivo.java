package Forms;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import Eventos.EventoDiscenteArquivo;
import Eventos.EventosAluno;

public class PainelDiscenteArquivo extends EventoDiscenteArquivo {
	
	private static JPanel mainDialog = new JPanel();
	
	private static final int DIST = 5;
	private static final int QUANT_LINHAS_GRID = 5;

	private JPanel painelInternoNorte = new JPanel(new BorderLayout(2,2));
	private JPanel painelEsquerdoInfoAluno = new JPanel(new GridLayout(QUANT_LINHAS_GRID,1,DIST,DIST));
	private JPanel painelDireito = new JPanel(new GridLayout(QUANT_LINHAS_GRID,1,DIST,DIST));
	private JPanel painelContentEIA = new JPanel(new BorderLayout(2,2));
	
	private JLabel lbDadosAta = new JLabel("DADOS DA CAIXA",SwingConstants.CENTER);
	private JLabel lbNomeAluno = new JLabel(evento.getAluno().getNomeAluno(), SwingConstants.CENTER);
	private JLabel lbRefCaixa = new JLabel("Cód. da Caixa: ",SwingConstants.RIGHT);
	private JLabel lbLocalInterno = new JLabel("Subseção: ",SwingConstants.RIGHT);
	private JLabel lbData = new JLabel("Data de Entrada: ",SwingConstants.RIGHT);
	
	public PainelDiscenteArquivo(EventosAluno evento) {
		super(mainDialog, evento); // passado a tela principal e o evento de aluno com as instancias
		eventoBotoes();
		
		JPanel painelTopoTitulo = new JPanel(new BorderLayout(2,2));
		
		painelEsquerdoInfoAluno.add(editPanel.painelNull(0, 0));
		painelEsquerdoInfoAluno.add(lbRefCaixa);
		painelEsquerdoInfoAluno.add(lbLocalInterno);
		painelEsquerdoInfoAluno.add(lbData);
		
		painelDireito.add(editPanel.painelNull(0, 0));
		painelDireito.add(tfRefCaixa);
		painelDireito.add(comboBoxSubSecao);
		painelDireito.add(ftData);
		
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
		PainelDiscenteArquivo.mainDialog = mainDialog;
	}

	private void eventoBotoes() {
		btnExcluir.setText("Excluir Cx Atual");
		
		btnLimpar.addActionListener(onClickLimparCampos);
		btnSalvar.addActionListener(onClickSalvarAtaResultado);
		btnExcluir.addActionListener(onClickExcluir);
		btnCancelar.addActionListener(onClickCancelarOperacao);
	}

	private JPanel painelInternoNorte() {
		JPanel controleSuperior = new JPanel(new BorderLayout(2,2));
		JPanel contendControl = new JPanel(new BorderLayout(2,2));
		JPanel contentPainel = new JPanel(new BorderLayout(2,2));
		
		contentPainel.add("Center", painelContentEIA);
		contentPainel.add("West", editPanel.painelNull(10, 0));
		contentPainel.add("East", editPanel.painelNull(50, 0));
		
		controleSuperior.add("Center",contentPainel);
		controleSuperior.setBorder(BorderFactory.createTitledBorder(
				BorderFactory.createSoftBevelBorder(2)));
		
		contendControl.add("Center", controleSuperior);
		contendControl.add("West", editPanel.painelNull(10, 0));
		contendControl.add("East", painelBotoesSul());
		contendControl.add("North", editPanel.painelNull(0, 10));
		
		painelInternoNorte.add("North", contendControl);
		painelInternoNorte.add("East", editPanel.painelNull(10, 0));
		
		return painelInternoNorte;
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
		contentPainelSul.add("South", editPanel.painelNull(0, 80)); 
		
		return contentPainelSul;
	}

	private void initJDialog() {
		mainDialog.setSize(400, 350);
		mainDialog.setVisible(true);	
		
		if(evento.arquivo != null) {
			btnExcluir.setEnabled(true);
		}
	}
	
	private void alterarFontes() {
		// FONTE
		lbRefCaixa.setFont(font.font_PLA_14);
		lbLocalInterno.setFont(font.font_PLA_14);
		lbData.setFont(font.font_PLA_14);
		lbNomeAluno.setFont(font.font_PLA_14);
		lbDadosAta.setFont(font.font_NEG_15);
		
		// JTextField
		tfRefCaixa.setFont(font.font_NEG_15);
		tfLocaInter.setFont(font.font_NEG_15);
		ftData.setFont(font.font_NEG_15);

		tfRefCaixa.setPreferredSize(new Dimension(70,0)); // Setado tamanho fixo do Text
		tfLocaInter.setPreferredSize(new Dimension(70,0)); // Setado tamanho fixo do Text
		
		// Cor
		lbLocalInterno.setForeground(Color.RED);
		ftData.setBackground(Color.WHITE);
		
		// Outros
		ftData.setBorder(null); // tirando a borda do component
	}
}
