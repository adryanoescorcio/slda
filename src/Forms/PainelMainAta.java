package Forms;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Panel;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
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
	private static final int QUANT_LINHAS_GRID = 4;

	private final JPanel mainJPanel = new JPanel(new BorderLayout(2, 2));
	private final Panel painelLocalizarArquivo = new Panel(new BorderLayout(
			2, 2));
	private final Panel painelInternoNorte = new Panel(new BorderLayout(2, 2));
	private final Panel painelInternoSul = new Panel(new BorderLayout(2, 2));
	private final Panel painelEsquerdoLabel = new Panel(new GridLayout(
			QUANT_LINHAS_GRID, 1, DIST, DIST));
	private final Panel painelDireitoField = new Panel(new GridLayout(
			QUANT_LINHAS_GRID, 1, DIST, DIST));
	private final Panel painelTabela = new Panel(new BorderLayout(2, 2));
	private final Panel painelContentEIA = new Panel(new BorderLayout(2, 2));
	private final Panel contentPainel = new Panel(new BorderLayout(2, 2));

	private final JScrollPane scroll = new JScrollPane();
	private final JScrollPane scrollMain = new JScrollPane();

	private final JLabel lbDadosAta = new JLabel(Messages.getString("PainelMainAta.0"), //$NON-NLS-1$
			SwingConstants.CENTER);
	private final JLabel lbTurma = new JLabel(Messages.getString("PainelMainAta.1"), SwingConstants.RIGHT); //$NON-NLS-1$
	private final JLabel lbCodigo2 = new JLabel(
			Messages.getString("PainelMainAta.2"), SwingConstants.RIGHT); //$NON-NLS-1$
	private final JLabel lbTurno = new JLabel(Messages.getString("PainelMainAta.3"), SwingConstants.RIGHT); //$NON-NLS-1$
	private final JLabel lbAno = new JLabel(Messages.getString("PainelMainAta.4"), SwingConstants.RIGHT); //$NON-NLS-1$
	private final JLabel lbModalidade = new JLabel(Messages.getString("PainelMainAta.5"), //$NON-NLS-1$
			SwingConstants.RIGHT);
	private final JLabel lbEnsino = new JLabel(Messages.getString("PainelMainAta.6"), SwingConstants.RIGHT); //$NON-NLS-1$
	private final JLabel lbDiscente = new JLabel(Messages.getString("PainelMainAta.7"), //$NON-NLS-1$
			SwingConstants.RIGHT);

	public PainelMainAta(final MainJFrame main) {
		super(main);
		eventosBotoes(); // EVENTOS

		// painel principal
		final JPanel contentFormulario = new JPanel(new BorderLayout(2, 2));

		// painelEsquerdo são as label dos campos das atas
		painelEsquerdoLabel.add(lbTurma);
		painelEsquerdoLabel.add(lbTurno);
		painelEsquerdoLabel.add(lbAno);
		painelEsquerdoLabel.add(lbModalidade);

		// painelDireito são os campos das ata
		painelDireitoField.add(editPanel
				.painelContentComponent(Messages.getString("PainelMainAta.8"), tfTurma)); //$NON-NLS-1$
		painelDireitoField.add(editPanel.painelContentComponent(Messages.getString("PainelMainAta.9"), //$NON-NLS-1$
				comboTurno));
		painelDireitoField.add(editPanel.painelContentComponent(Messages.getString("PainelMainAta.10"), ftAno)); //$NON-NLS-1$
		painelDireitoField.add(editPanel.painelContentComponent(Messages.getString("PainelMainAta.11"), //$NON-NLS-1$
				painelLadoLado(comboModalidade, lbEnsino, comboEnsino)));

		// Content Formulario contém os campos de dados das Atas
		contentFormulario.setBorder(BorderFactory.createTitledBorder(
				BorderFactory.createSoftBevelBorder(2), Messages.getString("PainelMainAta.12"))); //$NON-NLS-1$

		contentFormulario.add(Messages.getString("PainelMainAta.13"), painelEsquerdoLabel); //$NON-NLS-1$
		contentFormulario.add(Messages.getString("PainelMainAta.14"), painelDireitoField); //$NON-NLS-1$
		contentFormulario.add(Messages.getString("PainelMainAta.15"), editPanel.painelNull(200, 0)); //$NON-NLS-1$

		// Junta o campos de consulta com o formulario de dados mais os botões
		painelContentEIA.add(Messages.getString("PainelMainAta.16"), painelLabelConsultar()); //$NON-NLS-1$
		painelContentEIA.add(Messages.getString("PainelMainAta.17"), editPanel.painelNull(200, 0)); //$NON-NLS-1$
		painelContentEIA.add(Messages.getString("PainelMainAta.18"), contentFormulario); //$NON-NLS-1$
		// inserindo os botões.
		painelContentEIA.add(Messages.getString("PainelMainAta.19"), //$NON-NLS-1$
				editPanel.painelContentComponent(Messages.getString("PainelMainAta.20"), painelBotoes())); //$NON-NLS-1$

		// painel principal de Dados da Ata
		contentPainel.add(Messages.getString("PainelMainAta.21"), painelContentEIA); //$NON-NLS-1$
		contentPainel.add(Messages.getString("PainelMainAta.22"), editPanel.painelNull(0, 10)); //$NON-NLS-1$
		contentPainel.add(Messages.getString("PainelMainAta.23"), editPanel.painelNull(10, 0)); //$NON-NLS-1$

		alterarFontes();
		painelInternoNorte();
		getTelaPrincipal();
	}

	private void alterarFontes() {
		// FONTE
		lbTurma.setFont(font.font_PLA_14);
		lbCodigo2.setFont(font.font_PLA_14);
		lbTurno.setFont(font.font_PLA_14);
		lbAno.setFont(font.font_PLA_14);
		lbModalidade.setFont(font.font_PLA_14);
		lbEnsino.setFont(font.font_PLA_14);
		lbDiscente.setFont(font.font_PLA_14);
		lbDadosAta.setFont(font.font_NEG_15);

		// JTextField
		tfTurma.setFont(font.font_NEG_15);
		tfDiscente.setFont(font.font_NEG_15);
		tfTurma.setPreferredSize(new Dimension(70, 0)); // Setado tamanho fixo
														// do Text
		tfDiscente.setPreferredSize(new Dimension(350, 0)); // Setado tamanho
															// fixo do Text
		ftAno.setPreferredSize(new Dimension(45, 0));

		// Button
		btnSalvar.setFont(font.font_PLA_14);
		btnLimpar.setFont(font.font_PLA_14);
		btnAlterar.setFont(font.font_PLA_14);
		btnExcluir.setFont(font.font_PLA_14);

	}

	private JPanel contentPainelLocalizar() {
		final JPanel painel = new JPanel(new BorderLayout(2, 2));

		painel.setBorder(BorderFactory.createTitledBorder(
				BorderFactory.createSoftBevelBorder(2), Messages.getString("PainelMainAta.24"))); //$NON-NLS-1$

		painel.add(Messages.getString("PainelMainAta.25"), painelLocaliza(lbCodigo2)); //$NON-NLS-1$

		return painel;
	}

	private void eventosBotoes() {

		// ADD EVENTOS
		btnLimpar.addActionListener(onClickLimparCampos);
		btnSalvar.addActionListener(onClickSalvarAta);
		btnAlterar.addActionListener(onClickAterarAta);
		btnExcluir.addActionListener(onClickExcluirAta);
		btnPesquisar.addActionListener(onClickBuscarAta);
		btnInserir.addActionListener(onClickInitInserir);
		btnRetirar.addActionListener(onClickRetirarAtaResultado);

		comboModalidade.addItemListener(onClickChangeModalidade);
		tabela.addMouseListener(onClickRowTable);
	}

	public Panel getTelaPrincipal() {
		final Panel painelScrollMain = new Panel(new BorderLayout(1, 1));

		scrollMain.setPreferredSize(mainJPanel.getPreferredSize());
		scrollMain.setViewportView(mainJPanel);

		painelScrollMain.add(scrollMain);
		painelLocalizarArquivo.add(Messages.getString("PainelMainAta.26"), painelInternoNorte); //$NON-NLS-1$

		mainJPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));

		mainJPanel.add(Messages.getString("PainelMainAta.27"), painelLocalizarArquivo); //$NON-NLS-1$
		mainJPanel.add(Messages.getString("PainelMainAta.28"), editPanel.painelNull(20, 0)); //$NON-NLS-1$
		mainJPanel.add(Messages.getString("PainelMainAta.29"), editPanel.painelNull(20, 0)); //$NON-NLS-1$
		mainJPanel.add(Messages.getString("PainelMainAta.30"), editPanel.painelNull(0, 10)); //$NON-NLS-1$

		return painelScrollMain;
	}

	private Panel painelBotoes() {
		final Panel painelBotoes = new Panel(new BorderLayout(2, 2));
		final Panel painelContentBotoes = new Panel(
				new GridLayout(1, 6, 5, 1));

		painelContentBotoes.add(btnSalvar);
		painelContentBotoes.add(btnAlterar);
		painelContentBotoes.add(btnExcluir);
		painelContentBotoes.add(btnLimpar);

		painelBotoes.add(Messages.getString("PainelMainAta.31"), painelContentBotoes); //$NON-NLS-1$
		painelBotoes.add(Messages.getString("PainelMainAta.32"), editPanel.painelNull(0, 5)); //$NON-NLS-1$
		painelBotoes.add(Messages.getString("PainelMainAta.33"), editPanel.painelNull(250, 0)); //$NON-NLS-1$
		painelBotoes.add(Messages.getString("PainelMainAta.34"), editPanel.painelNull(0, 5)); //$NON-NLS-1$

		return painelBotoes;
	}

	private JPanel painelDiscente() {

		final Panel painelDiscenteLabel = new Panel(
				new GridLayout(1, 2, 1, 1));
		final Panel painelDiscenteText = new Panel(new GridLayout(1, 2, 1, 1));
		final JPanel painelContentMain = new JPanel(new BorderLayout(2, 2));
		final Panel contentMain = new Panel(new BorderLayout(2, 2));
		final Panel contentDiscenteBotoes = new Panel(new BorderLayout(2, 2));
		final Panel contentDiscente = new Panel(new BorderLayout(2, 2));
		final Panel painelDiscenteBotoes = new Panel(new GridLayout(1, 2, 10,
				1));

		painelDiscenteLabel.add(lbDiscente);
		painelDiscenteText.add(editPanel.painelContentComponent(Messages.getString("PainelMainAta.35"), //$NON-NLS-1$
				tfDiscente));

		contentDiscente.add(Messages.getString("PainelMainAta.36"), painelDiscenteLabel); //$NON-NLS-1$
		contentDiscente.add(Messages.getString("PainelMainAta.37"), editPanel.painelNull(10, 0)); //$NON-NLS-1$
		contentDiscente.add(Messages.getString("PainelMainAta.38"), painelDiscenteLabel); //$NON-NLS-1$
		contentDiscente.add(Messages.getString("PainelMainAta.39"), painelDiscenteText); //$NON-NLS-1$

		painelDiscenteBotoes.add(btnInserir);
		painelDiscenteBotoes.add(btnRetirar);

		contentDiscenteBotoes.add(Messages.getString("PainelMainAta.40"), //$NON-NLS-1$
				editPanel.painelContentComponent(Messages.getString("PainelMainAta.41"), painelDiscenteBotoes)); //$NON-NLS-1$
		contentDiscenteBotoes.add(Messages.getString("PainelMainAta.42"), editPanel.painelNull(20, 0)); //$NON-NLS-1$

		contentMain.add(Messages.getString("PainelMainAta.43"), contentDiscente); //$NON-NLS-1$
		contentMain.add(Messages.getString("PainelMainAta.44"), contentDiscenteBotoes); //$NON-NLS-1$

		painelContentMain.add(Messages.getString("PainelMainAta.45"), editPanel.painelNull(0, 5)); //$NON-NLS-1$
		painelContentMain.add(Messages.getString("PainelMainAta.46"), editPanel.painelNull(0, 5)); //$NON-NLS-1$
		painelContentMain.add(Messages.getString("PainelMainAta.47"), //$NON-NLS-1$
				editPanel.painelContentComponent(Messages.getString("PainelMainAta.48"), contentMain)); //$NON-NLS-1$

		painelContentMain
				.setBorder(BorderFactory.createTitledBorder(
						BorderFactory.createSoftBevelBorder(2),
						Messages.getString("PainelMainAta.49"))); //$NON-NLS-1$

		return painelContentMain;
	}

	private void painelInternoNorte() {
		final JPanel controleSuperior = new JPanel(new BorderLayout(2, 2));

		controleSuperior.add(Messages.getString("PainelMainAta.50"), contentPainel); //$NON-NLS-1$
		controleSuperior.setBorder(BorderFactory
				.createTitledBorder(BorderFactory.createSoftBevelBorder(2)));

		painelInternoNorte.add(Messages.getString("PainelMainAta.51"), painelDiscente()); //$NON-NLS-1$
		painelInternoNorte.add(Messages.getString("PainelMainAta.52"), controleSuperior); //$NON-NLS-1$
		painelInternoNorte.add(Messages.getString("PainelMainAta.53"), painelInternoSul()); //$NON-NLS-1$
	}

	private Panel painelInternoSul() {
		painelInternoSul.add(Messages.getString("PainelMainAta.54"), editPanel.painelNull(200, 0)); //$NON-NLS-1$
		painelInternoSul.add(Messages.getString("PainelMainAta.55"), painelTable()); //$NON-NLS-1$

		return painelInternoSul;
	}

	private Panel painelLabelConsultar() {
		final Panel painel = new Panel(new BorderLayout(1, 1));
		painel.add(Messages.getString("PainelMainAta.56"), lbDadosAta); //$NON-NLS-1$
		painel.add(Messages.getString("PainelMainAta.57"), contentPainelLocalizar()); //$NON-NLS-1$
		painel.add(Messages.getString("PainelMainAta.58"), editPanel.painelNull(200, 0)); //$NON-NLS-1$

		return painel;
	}

	/**
	 * Painel para organizar horizontalmente o Telefone e o Endereço
	 **/
	private Panel painelLadoLado(final Component comp1, final JLabel lb2,
			final Component comp2) {

		final Panel painelEndTelefone = new Panel(new BorderLayout(2, 2));
		final Panel painelTelefone = new Panel(new BorderLayout(2, 2));
		final Panel painelSeparador2 = new Panel(new BorderLayout(2, 2));

		// Telefone
		painelTelefone.add(Messages.getString("PainelMainAta.59"), lb2); //$NON-NLS-1$
		painelTelefone.add(Messages.getString("PainelMainAta.60"), //$NON-NLS-1$
				editPanel.painelContentComponent(Messages.getString("PainelMainAta.61"), comp2)); //$NON-NLS-1$
		// SEPARADOR
		painelSeparador2.add(Messages.getString("PainelMainAta.62"), editPanel.painelNull(50, 0)); //$NON-NLS-1$
		painelSeparador2.add(Messages.getString("PainelMainAta.63"), painelTelefone); //$NON-NLS-1$
		// Endereço
		painelEndTelefone.add(Messages.getString("PainelMainAta.64"), //$NON-NLS-1$
				editPanel.painelContentComponent(Messages.getString("PainelMainAta.65"), comp1)); //$NON-NLS-1$
		painelEndTelefone.add(Messages.getString("PainelMainAta.66"), painelSeparador2); //$NON-NLS-1$

		return painelEndTelefone;
	}

	private Panel painelTable() {
		tabela.setModel(modeloAta);
		tabela.setToolTipText(Messages.getString("PainelMainAta.67")); //$NON-NLS-1$

		scroll.setPreferredSize(new Dimension(0, 200)); // Define o tamanho da
														// tabela.
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scroll.setViewportView(table.getTabela()); // insere a tabela no painel
													// Scroll
		scroll.setWheelScrollingEnabled(true);

		painelTabela.add(Messages.getString("PainelMainAta.68"), editPanel.painelNull(0, 5)); //$NON-NLS-1$
		painelTabela.add(Messages.getString("PainelMainAta.69"), scroll); //$NON-NLS-1$

		return painelTabela;
	}
}
