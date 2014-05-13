package Forms;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

import Eventos.EventosAta;

/**
 * Classe que representa a tela Ata - Cadastrar
 * 
 * @author Walysson Oliveira
 * @author Adryano Escorcio
 * @version 3.0
 * @extends EventosAta
 **/
public class PainelMainAta extends EventosAta {

	private static final int DIST = 5;
	private static final String BORDER_INFO_ATA = "DADOS DA ATA";
	private static final int QUANT_LINHAS_GRID = 6;

	private JPanel mainJPanel = new JPanel(new BorderLayout(2,2));
	private JPanel painelLocalizarArquivo = new JPanel(new BorderLayout(2,2));
	private JPanel painelInternoNorte = new JPanel(new BorderLayout(2,2));
	private JPanel painelInternoSul = new JPanel(new BorderLayout(2,2));
	private JPanel painelEsquerdoInfoAluno = new JPanel(new GridLayout(QUANT_LINHAS_GRID,1,DIST,DIST));
	private JPanel painelDireito = new JPanel(new GridLayout(QUANT_LINHAS_GRID,1,DIST,DIST));
	private JPanel painelTabela= new JPanel(new BorderLayout(2,2));	
	private JPanel painelContentEIA = new JPanel(new BorderLayout(2,2));

	private JScrollPane scroll = new JScrollPane();
	private JScrollPane scrollMain = new JScrollPane();

	private JLabel lbDadosAta = new JLabel("DADOS DA ATA", SwingConstants.CENTER);
	private JLabel lbTurma = new JLabel("Turma:* ", SwingConstants.RIGHT);
	private JLabel lbCodigo2 = new JLabel("Ano da Ata: ", SwingConstants.RIGHT);
	private JLabel lbTurno = new JLabel("Turno:* ", SwingConstants.RIGHT);
	private JLabel lbAno = new JLabel("Ano:* ", SwingConstants.RIGHT);
	private JLabel lbModalidade = new JLabel("Modalidade: ", SwingConstants.RIGHT);
	private JLabel lbEnsino = new JLabel("Ensino: ", SwingConstants.RIGHT);

	public PainelMainAta() {

		eventosBotoes();

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
		painelContentEIA.add("East",editPanel.painelNull(200, 0));

		alterarFontes();
		painelInternoNorte();
		getTelaPrincipal();

	}

	private void eventosBotoes() {
		//ADD EVENTOS
		btnLimpar.addActionListener(onClickLimparCampos);
		btnSalvar.addActionListener(onClickSalvarAta);
		btnAlterar.addActionListener(onClickAterarAta);
		btnExcluir.addActionListener(onClickExcluirAta);
		btnPesquisar.addActionListener(onClickBuscarAta);
		comboModalidade.addItemListener(onClickChangeModalidade);
		tabela.addMouseListener(onClickRowTable);
	}

	private void painelInternoNorte() {
		JPanel controleSuperior = new JPanel(new BorderLayout(2,2));

		controleSuperior.add("North",painelContentEIA);
		controleSuperior.setBorder(BorderFactory.createTitledBorder(
				BorderFactory.createSoftBevelBorder(2), BORDER_INFO_ATA));

		painelInternoNorte.add("North", contentPainelLocalizar());
		painelInternoNorte.add("Center", controleSuperior);
		painelInternoNorte.add("South", painelInternoSul());
	}

	private JPanel contentPainelLocalizar() {
		JPanel painel = new JPanel(new BorderLayout(2,2));
		painel.setBorder(BorderFactory.createTitledBorder(
				BorderFactory.createSoftBevelBorder(2), "CONSULTAR"));
		painel.add("North", painelLocaliza(lbCodigo2));
		return painel;
	}

	public JPanel getTelaPrincipal() {
		JPanel painelScrollMain = new JPanel(new BorderLayout(1,1));

		scrollMain.setPreferredSize(mainJPanel.getPreferredSize());
		scrollMain.setViewportView(mainJPanel);

		painelScrollMain.add(scrollMain);
		painelLocalizarArquivo.add("North",painelInternoNorte);

		mainJPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));

		mainJPanel.add("Center",painelLocalizarArquivo);
		mainJPanel.add("West",editPanel.painelNull(20, 0));
		mainJPanel.add("East",editPanel.painelNull(20, 0));
		mainJPanel.add("North",editPanel.painelNull(0, 15));

		return painelScrollMain;
	}

	private JPanel painelInternoSul() {
		painelInternoSul.add("Center",editPanel.painelContentComponent("West", painelBotoes()));
		painelInternoSul.add("North",editPanel.painelNull(0, 5));
		painelInternoSul.add("West",editPanel.painelNull(200, 0));
		painelInternoSul.add("South",painelTable());

		return painelInternoSul;
	}

	private JPanel painelTable() {
		tabela.setModel(modeloAta);
		tabela.setToolTipText("D� um duplo clique na Ata para Excluir ou Alterar");

		scroll.setPreferredSize(new Dimension(0, 200)); // Define o tamanho da tabela.
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scroll.setViewportView(table.getTabela()); // insere a tabela no painel Scroll
		scroll.setWheelScrollingEnabled(true);

		painelTabela.add("North", editPanel.painelNull(0, 10));
		painelTabela.add("Center", scroll);
		//		painelTabela.add("South", painelLocaliza(lbCodigo2));

		return painelTabela;
	}

	private JPanel painelBotoes() {
		JPanel painelBotoes = new JPanel(new BorderLayout(2,2));
		JPanel painelContentBotoes = new JPanel(new GridLayout(1,6,5,5));

		painelContentBotoes.add(btnSalvar);
		painelContentBotoes.add(btnAlterar);
		painelContentBotoes.add(btnExcluir);
		painelContentBotoes.add(btnLimpar);

		painelBotoes.add("Center", painelContentBotoes);

		return painelBotoes;
	}

	private void alterarFontes() {
		// FONTE
		lbTurma.setFont(font.font_PLA_14);
		lbCodigo2.setFont(font.font_PLA_14);
		lbTurno.setFont(font.font_PLA_14);
		lbAno.setFont(font.font_PLA_14);
		lbModalidade.setFont(font.font_PLA_14);
		lbEnsino.setFont(font.font_PLA_14);
		lbDadosAta.setFont(font.font_NEG_15);

		// JTextField
		tfTurma.setFont(font.font_NEG_15);
		tfTurma.setPreferredSize(new Dimension(70,0)); // Setado tamanho fixo do Text

		// Button
		btnSalvar.setFont(font.font_PLA_14);
		btnLimpar.setFont(font.font_PLA_14);
		btnAlterar.setFont(font.font_PLA_14);
		btnExcluir.setFont(font.font_PLA_14);

		tfTurma.setSize(20, 10);

		// Outros
		ftAno.setBorder(null); // tirando a borda do component
	}


}
