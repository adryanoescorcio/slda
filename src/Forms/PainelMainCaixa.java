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
import javax.swing.SwingConstants;

import ComponentGroupPlus.FontGroup;
import Eventos.EventosCaixa;

/**
 * Classe que representa a tela Arquivo - Localizar
 * 
 * @author Walysson Oliveira
 * @author Adryano Escorcio
 * @version 3.0
 * @extends EventoCaixa
 **/

public class PainelMainCaixa extends EventosCaixa {

	protected static final int DIST = 3;

	// Fonte
	private final FontGroup font = new FontGroup();

	protected static final String BORDER_INFO_CAIXA = Messages.getString("PainelMainCaixa.0"); //$NON-NLS-1$
	protected static final int QUANT_LINHAS_GRID = 4;

	protected JPanel mainJPanel = new JPanel(new BorderLayout(2, 2));
	protected Panel painelLocalizarArquivo = new Panel(new BorderLayout(2, 2));
	protected Panel painelInternoNorte = new Panel(new BorderLayout(2, 2));
	protected Panel painelInternoSul = new Panel(new BorderLayout(2, 2));
	protected Panel painelEsquerdo = new Panel(new GridLayout(
			QUANT_LINHAS_GRID, 1, DIST, DIST));
	protected Panel painelDireito = new Panel(new GridLayout(
			QUANT_LINHAS_GRID, 1, DIST, DIST));
	protected Panel painelTabela = new Panel(new BorderLayout(2, 2));
	protected Panel painelContentEIA = new Panel(new BorderLayout(2, 2));
	protected Panel contentPainel = new Panel(new BorderLayout(2, 2));

	protected JScrollPane scroll = new JScrollPane();
	protected JScrollPane scrollMain = new JScrollPane();

	protected JLabel lbCodigo = new JLabel(Messages.getString("PainelMainCaixa.1"), //$NON-NLS-1$
			SwingConstants.RIGHT);
	protected JLabel lbCodigo2 = new JLabel(Messages.getString("PainelMainCaixa.2"), //$NON-NLS-1$
			SwingConstants.RIGHT);
	protected JLabel lbTurno = new JLabel(Messages.getString("PainelMainCaixa.3"), SwingConstants.RIGHT); //$NON-NLS-1$
	protected JLabel lbLetra = new JLabel(Messages.getString("PainelMainCaixa.4"), SwingConstants.RIGHT); //$NON-NLS-1$
	protected JLabel lbStatus = new JLabel(Messages.getString("PainelMainCaixa.5"), SwingConstants.RIGHT); //$NON-NLS-1$
	protected JLabel lbDadosCaixa = new JLabel(Messages.getString("PainelMainCaixa.6"), //$NON-NLS-1$
			SwingConstants.CENTER);
	protected JLabel lbDiscente = new JLabel(Messages.getString("PainelMainCaixa.7"), SwingConstants.RIGHT); //$NON-NLS-1$
	private final JLabel lbModalidade = new JLabel(Messages.getString("PainelMainCaixa.8"), //$NON-NLS-1$
			SwingConstants.RIGHT);
	private final JLabel lbEnsino = new JLabel(Messages.getString("PainelMainCaixa.9"), SwingConstants.RIGHT); //$NON-NLS-1$

	public PainelMainCaixa(final MainJFrame main) {
		super(main);
		eventosBotoes();

		// painel principal
		final JPanel contentFormulario = new JPanel(new BorderLayout(2, 2));

		painelEsquerdo.add(lbCodigo);
		painelEsquerdo.add(lbLetra);
		painelEsquerdo.add(lbTurno);
		painelEsquerdo.add(lbModalidade);

		painelDireito.add(editPanel.painelContentComponent(Messages.getString("PainelMainCaixa.10"), tfCodigo)); //$NON-NLS-1$

		painelDireito.add(editPanel.painelContentComponent(Messages.getString("PainelMainCaixa.11"), comboLetra)); //$NON-NLS-1$

		painelDireito.add(editPanel.painelContentComponent(Messages.getString("PainelMainCaixa.12"), //$NON-NLS-1$
				painelLadoLado(comboTurno, lbStatus, comboStatus)));
		painelDireito.add(editPanel.painelContentComponent(Messages.getString("PainelMainCaixa.13"), //$NON-NLS-1$
				painelLadoLado(comboModalidade, lbEnsino, comboEnsino)));

		// Content Formulario contém os campos de dados das Atas
		contentFormulario.setBorder(BorderFactory.createTitledBorder(
				BorderFactory.createSoftBevelBorder(2), Messages.getString("PainelMainCaixa.14"))); //$NON-NLS-1$

		contentFormulario.add(Messages.getString("PainelMainCaixa.15"), painelEsquerdo); //$NON-NLS-1$
		contentFormulario.add(Messages.getString("PainelMainCaixa.16"), painelDireito); //$NON-NLS-1$
		contentFormulario.add(Messages.getString("PainelMainCaixa.17"), editPanel.painelNull(200, 0)); //$NON-NLS-1$

		// Junta o campos de consulta com o formulario de dados mais os botões
		painelContentEIA.add(Messages.getString("PainelMainCaixa.18"), painelLabelConsultar()); //$NON-NLS-1$
		painelContentEIA.add(Messages.getString("PainelMainCaixa.19"), editPanel.painelNull(200, 0)); //$NON-NLS-1$
		painelContentEIA.add(Messages.getString("PainelMainCaixa.20"), contentFormulario); //$NON-NLS-1$
		// inserindo os botões.
		painelContentEIA.add(Messages.getString("PainelMainCaixa.21"), //$NON-NLS-1$
				editPanel.painelContentComponent(Messages.getString("PainelMainCaixa.22"), painelBotoes())); //$NON-NLS-1$

		// painel principal de Dados da Ata
		contentPainel.add(Messages.getString("PainelMainCaixa.23"), painelContentEIA); //$NON-NLS-1$
		contentPainel.add(Messages.getString("PainelMainCaixa.24"), editPanel.painelNull(0, 10)); //$NON-NLS-1$
		contentPainel.add(Messages.getString("PainelMainCaixa.25"), editPanel.painelNull(10, 0)); //$NON-NLS-1$

		alterarFontes();
		painelInternoNorte();
		getTelaPrincipal();
	}

	private void alterarFontes() {
		lbCodigo.setFont(font.font_PLA_14);
		lbCodigo2.setFont(font.font_PLA_14);
		lbLetra.setFont(font.font_PLA_14);
		lbTurno.setFont(font.font_PLA_14);
		lbStatus.setFont(font.font_PLA_14);
		lbEnsino.setFont(font.font_PLA_14);
		lbModalidade.setFont(font.font_PLA_14);
		lbDadosCaixa.setFont(font.font_NEG_15);
		lbDiscente.setFont(font.font_PLA_14);

		tfCodigo.setFont(font.font_NEG_15);
		tfCodigo.setPreferredSize(new Dimension(200, 0));
		tfDiscente.setFont(font.font_NEG_15);

		tfDiscente.setPreferredSize(new Dimension(350, 0));

		btnSalvar.setFont(font.font_PLA_14);
		btnLimpar.setFont(font.font_PLA_14);
		btnAlterar.setFont(font.font_PLA_14);
		btnExcluir.setFont(font.font_PLA_14);
	}

	private JPanel contentPainelLocalizar() {
		final JPanel painel = new JPanel(new BorderLayout(2, 2));
		painel.setBorder(BorderFactory.createTitledBorder(
				BorderFactory.createSoftBevelBorder(2), Messages.getString("PainelMainCaixa.26"))); //$NON-NLS-1$
		painel.add(Messages.getString("PainelMainCaixa.27"), painelLocaliza(lbCodigo2)); //$NON-NLS-1$

		return painel;
	}

	private void eventosBotoes() {
		// ADD EVENTOS
		btnLimpar.addActionListener(onClickLimparCampos);
		btnSalvar.addActionListener(onClickSalvarCaixa);
		btnAlterar.addActionListener(onClickAlterarCaixa);
		btnPesquisar.addActionListener(onClickBuscarCaixa);
		btnExcluir.addActionListener(onClickExcluirCaixa);
		btnInserir.addActionListener(onClickInitInserir);
		btnRetirar.addActionListener(onClickInitRetirar);
		btnAbrirCaixa.addActionListener(onClickAbrirCaixa);
		
		tabela.addMouseListener(onClickRowTable);
		comboModalidade.addItemListener(onClickChangeModalidade);
	}

	public Panel getTelaPrincipal() {

		final Panel painelScrollMain = new Panel(new BorderLayout(1, 1));

		scrollMain.setPreferredSize(mainJPanel.getPreferredSize());
		scrollMain.setViewportView(mainJPanel);

		painelScrollMain.add(scrollMain);
		painelLocalizarArquivo.add(Messages.getString("PainelMainCaixa.28"), painelInternoNorte); //$NON-NLS-1$

		mainJPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));

		mainJPanel.add(Messages.getString("PainelMainCaixa.29"), painelLocalizarArquivo); //$NON-NLS-1$
		mainJPanel.add(Messages.getString("PainelMainCaixa.30"), editPanel.painelNull(20, 0)); //$NON-NLS-1$
		mainJPanel.add(Messages.getString("PainelMainCaixa.31"), editPanel.painelNull(20, 0)); //$NON-NLS-1$
		mainJPanel.add(Messages.getString("PainelMainCaixa.32"), editPanel.painelNull(0, 5)); //$NON-NLS-1$

		// Vai para Janela Principal
		return painelScrollMain;
	}

	private Panel painelBotoes() {
		// painel que guarda o painel de botões. estiliza o posicionamento.
		final Panel painelBotoes = new Panel(new BorderLayout(2, 2));
		// painel que guarda os botões
		final Panel painelContentBotoes = new Panel(
				new GridLayout(1, 5, 5, 5));

		painelContentBotoes.add(btnSalvar);
		painelContentBotoes.add(btnAlterar);
		painelContentBotoes.add(btnExcluir);
		painelContentBotoes.add(btnLimpar);
		painelContentBotoes.add(btnAbrirCaixa);

		painelBotoes.add(Messages.getString("PainelMainCaixa.33"), painelContentBotoes); //$NON-NLS-1$
		painelBotoes.add(Messages.getString("PainelMainCaixa.34"), editPanel.painelNull(0, 10)); //$NON-NLS-1$
		painelBotoes.add(Messages.getString("PainelMainCaixa.35"), editPanel.painelNull(200, 0)); //$NON-NLS-1$
		painelBotoes.add(Messages.getString("PainelMainCaixa.36"), editPanel.painelNull(0, 10)); //$NON-NLS-1$

		return painelBotoes;
	}

	private JPanel painelDiscente() {

		final Panel painelDiscenteLabel = new Panel(
				new GridLayout(1, 2, 2, 2));
		final Panel painelDiscenteText = new Panel(new GridLayout(1, 2, 2, 2));
		final JPanel painelContentMain = new JPanel(new BorderLayout(2, 2));
		final Panel contentMain = new Panel(new BorderLayout(2, 2));
		final Panel contentDiscenteBotoes = new Panel(new BorderLayout(2, 2));
		final Panel contentDiscente = new Panel(new BorderLayout(2, 2));
		final Panel painelDiscenteBotoes = new Panel(new GridLayout(1, 3, 2,
				2));

		painelDiscenteLabel.add(lbDiscente);
		painelDiscenteText.add(editPanel.painelContentComponent(Messages.getString("PainelMainCaixa.37"), //$NON-NLS-1$
				tfDiscente));

		contentDiscente.add(Messages.getString("PainelMainCaixa.38"), painelDiscenteLabel); //$NON-NLS-1$
		contentDiscente.add(Messages.getString("PainelMainCaixa.39"), painelDiscenteText); //$NON-NLS-1$

		painelDiscenteBotoes.add(editPanel.painelContentComponent(Messages.getString("PainelMainCaixa.40"), //$NON-NLS-1$
				comboNumero));
		painelDiscenteBotoes.add(btnInserir);
		painelDiscenteBotoes.add(btnRetirar);

		contentDiscenteBotoes.add(Messages.getString("PainelMainCaixa.41"), //$NON-NLS-1$
				editPanel.painelContentComponent(Messages.getString("PainelMainCaixa.42"), painelDiscenteBotoes)); //$NON-NLS-1$
		contentDiscenteBotoes.add(Messages.getString("PainelMainCaixa.43"), editPanel.painelNull(20, 0)); //$NON-NLS-1$

		contentMain.add(Messages.getString("PainelMainCaixa.44"), contentDiscente); //$NON-NLS-1$
		contentMain.add(Messages.getString("PainelMainCaixa.45"), contentDiscenteBotoes); //$NON-NLS-1$

		painelContentMain.add(Messages.getString("PainelMainCaixa.46"), editPanel.painelNull(0, 5)); //$NON-NLS-1$
		painelContentMain.add(Messages.getString("PainelMainCaixa.47"), editPanel.painelNull(0, 5)); //$NON-NLS-1$
		painelContentMain.add(Messages.getString("PainelMainCaixa.48"), //$NON-NLS-1$
				editPanel.painelContentComponent(Messages.getString("PainelMainCaixa.49"), contentMain)); //$NON-NLS-1$

		painelContentMain
				.setBorder(BorderFactory.createTitledBorder(
						BorderFactory.createSoftBevelBorder(2),
						Messages.getString("PainelMainCaixa.50"))); //$NON-NLS-1$

		return painelContentMain;
	}

	private void painelInternoNorte() {
		final JPanel controleSuperior = new JPanel(new BorderLayout(2, 2));

		controleSuperior.add(Messages.getString("PainelMainCaixa.51"), contentPainel); //$NON-NLS-1$
		controleSuperior.setBorder(BorderFactory
				.createTitledBorder(BorderFactory.createSoftBevelBorder(2)));

		painelInternoNorte.add(Messages.getString("PainelMainCaixa.52"), painelDiscente()); //$NON-NLS-1$
		painelInternoNorte.add(Messages.getString("PainelMainCaixa.53"), controleSuperior); //$NON-NLS-1$
		painelInternoNorte.add(Messages.getString("PainelMainCaixa.54"), painelInternoSul()); //$NON-NLS-1$
	}

	private Panel painelInternoSul() {
		// painelInternoSul.add("Center",editPanel.painelContentComponent("West",
		// painelBotoes()));
		painelInternoSul.add(Messages.getString("PainelMainCaixa.55"), editPanel.painelNull(0, 5)); //$NON-NLS-1$
		painelInternoSul.add(Messages.getString("PainelMainCaixa.56"), editPanel.painelNull(220, 0)); //$NON-NLS-1$
		painelInternoSul.add(Messages.getString("PainelMainCaixa.57"), painelTable()); //$NON-NLS-1$

		return painelInternoSul;
	}

	private Component painelLabelConsultar() {
		final Panel painel = new Panel(new BorderLayout(2, 2));
		painel.add(Messages.getString("PainelMainCaixa.58"), lbDadosCaixa); //$NON-NLS-1$
		painel.add(Messages.getString("PainelMainCaixa.59"), contentPainelLocalizar()); //$NON-NLS-1$
		painel.add(Messages.getString("PainelMainCaixa.60"), editPanel.painelNull(200, 0)); //$NON-NLS-1$

		return painel;
	}

	private Panel painelLadoLado(final Component comp1, final JLabel lb2,
			final Component comp2) {

		final Panel painelEndTelefone = new Panel(new BorderLayout(2, 2));
		final Panel painelTelefone = new Panel(new BorderLayout(2, 2));
		final Panel painelSeparador2 = new Panel(new BorderLayout(2, 2));

		// Telefone
		painelTelefone.add(Messages.getString("PainelMainCaixa.61"), lb2); //$NON-NLS-1$
		painelTelefone.add(Messages.getString("PainelMainCaixa.62"), //$NON-NLS-1$
				editPanel.painelContentComponent(Messages.getString("PainelMainCaixa.63"), comp2)); //$NON-NLS-1$
		// SEPARADOR
		painelSeparador2.add(Messages.getString("PainelMainCaixa.64"), editPanel.painelNull(50, 0)); //$NON-NLS-1$
		painelSeparador2.add(Messages.getString("PainelMainCaixa.65"), painelTelefone); //$NON-NLS-1$
		// Endereço
		painelEndTelefone.add(Messages.getString("PainelMainCaixa.66"), //$NON-NLS-1$
				editPanel.painelContentComponent(Messages.getString("PainelMainCaixa.67"), comp1)); //$NON-NLS-1$
		painelEndTelefone.add(Messages.getString("PainelMainCaixa.68"), painelSeparador2); //$NON-NLS-1$

		return painelEndTelefone;
	}

	private Panel painelTable() {
		tabela.setModel(modelo);
		tabela.setToolTipText(Messages.getString("PainelMainCaixa.69")); //$NON-NLS-1$

		scroll.setPreferredSize(new Dimension(0, 200)); // Define o tamanho da
														// tabela.
		scroll.setViewportView(tabela); // insere a tabela no painel Scroll

		painelTabela.add(Messages.getString("PainelMainCaixa.70"), editPanel.painelNull(0, 5)); //$NON-NLS-1$
		painelTabela.add(Messages.getString("PainelMainCaixa.71"), scroll); //$NON-NLS-1$
		// painelTabela.add("South", painelLocaliza(lbCodigo2));

		return painelTabela;
	}

}
