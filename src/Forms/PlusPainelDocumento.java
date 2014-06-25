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

import ComponentGroupPlus.FontGroup;
import Eventos.EventosAluno;
import Eventos.PlusEventoDocumento;

public class PlusPainelDocumento extends PlusEventoDocumento {

	protected static final int DIST = 5;

	// Fonte
	private final FontGroup font = new FontGroup();

	protected static final String BORDER_INFO_CAIXA = Messages.getString("PlusPainelDocumento.0"); //$NON-NLS-1$
	protected static final int QUANT_LINHAS_GRID = 6;

	protected JPanel mainJPanel = new JPanel(new BorderLayout(2, 2));
	protected JPanel painelLocalizarArquivo = new JPanel(new BorderLayout(2, 2));
	protected JPanel painelInternoNorte = new JPanel(new BorderLayout(2, 2));
	protected JPanel painelInternoSul = new JPanel(new BorderLayout(2, 2));
	protected JPanel painelEsquerdo = new JPanel(new GridLayout(
			QUANT_LINHAS_GRID, 1, DIST, DIST));
	protected JPanel painelDireito = new JPanel(new GridLayout(
			QUANT_LINHAS_GRID, 1, DIST, DIST));
	protected JPanel painelTabela = new JPanel(new BorderLayout(2, 2));
	protected JPanel painelContentEIA = new JPanel(new BorderLayout(2, 2));
	protected JPanel contentPainel = new JPanel(new BorderLayout(2, 2));

	protected JScrollPane scroll = new JScrollPane();
	protected JScrollPane scrollMain = new JScrollPane();

	protected JLabel lbCodigo = new JLabel(Messages.getString("PlusPainelDocumento.1"), SwingConstants.RIGHT); //$NON-NLS-1$
	protected JLabel lbDocumento = new JLabel(Messages.getString("PlusPainelDocumento.2"), //$NON-NLS-1$
			SwingConstants.RIGHT);
	protected JLabel lbDescricao = new JLabel(Messages.getString("PlusPainelDocumento.3"), //$NON-NLS-1$
			SwingConstants.CENTER);
	protected JLabel lbDescricaoDocumento = new JLabel(Messages.getString("PlusPainelDocumento.4"), //$NON-NLS-1$
			SwingConstants.CENTER);
	protected JLabel lbPedido = new JLabel(Messages.getString("PlusPainelDocumento.5"), //$NON-NLS-1$
			SwingConstants.RIGHT);
	protected JLabel lbEntrega = new JLabel(Messages.getString("PlusPainelDocumento.6"), //$NON-NLS-1$
			SwingConstants.RIGHT);
	protected JLabel lbNomeDiscente = new JLabel(Messages.getString("PlusPainelDocumento.7"), SwingConstants.RIGHT); //$NON-NLS-1$
	protected JLabel lbStatus = new JLabel(Messages.getString("PlusPainelDocumento.8"), //$NON-NLS-1$
			SwingConstants.RIGHT);

	public PlusPainelDocumento(final MainJFrame main, final EventosAluno evento) {
		super(main, evento);
		atualizarAlunoTela();
		eventosBotoes();

		// painel principal
		final JPanel contentFormulario = new JPanel(new BorderLayout(2, 2));

		painelEsquerdo.add(editPanel.painelNull(0, 0));
		painelEsquerdo.add(lbCodigo);
		painelEsquerdo.add(lbDocumento);
		painelEsquerdo.add(lbPedido);
		painelEsquerdo.add(lbEntrega);
		painelEsquerdo.add(lbStatus);

		painelDireito.add(editPanel.painelNull(0, 0));

		painelDireito
				.add(editPanel.painelContentComponent(Messages.getString("PlusPainelDocumento.9"), tfProtocolo)); //$NON-NLS-1$

		painelDireito
				.add(editPanel.painelContentComponent(Messages.getString("PlusPainelDocumento.10"), tfDocumento)); //$NON-NLS-1$

		painelDireito.add(editPanel
				.painelContentComponent(Messages.getString("PlusPainelDocumento.11"), ftDataPedido)); //$NON-NLS-1$

		painelDireito.add(editPanel.painelContentComponent(Messages.getString("PlusPainelDocumento.12"), //$NON-NLS-1$
				ftDataEntrega));

		painelDireito
				.add(editPanel.painelContentComponent(Messages.getString("PlusPainelDocumento.13"), comboStatus)); //$NON-NLS-1$

		// Content Formulario contém os campos de dados das Atas
		contentFormulario.setBorder(BorderFactory.createTitledBorder(
				BorderFactory.createSoftBevelBorder(2), Messages.getString("PlusPainelDocumento.14"))); //$NON-NLS-1$

		contentFormulario.add(Messages.getString("PlusPainelDocumento.15"), painelEsquerdo); //$NON-NLS-1$
		contentFormulario.add(Messages.getString("PlusPainelDocumento.16"), painelDireito); //$NON-NLS-1$
		contentFormulario.add(Messages.getString("PlusPainelDocumento.17"), painelDescricao()); //$NON-NLS-1$
		contentFormulario.add(Messages.getString("PlusPainelDocumento.18"), editPanel.painelNull(200, 0)); //$NON-NLS-1$

		// Junta o campos de consulta com o formulario de dados mais os botões
		painelContentEIA.add(Messages.getString("PlusPainelDocumento.19"), editPanel.painelNull(200, 0)); //$NON-NLS-1$
		painelContentEIA.add(Messages.getString("PlusPainelDocumento.20"), contentFormulario); //$NON-NLS-1$
		// inserindo os botões.
		painelContentEIA.add(Messages.getString("PlusPainelDocumento.21"), //$NON-NLS-1$
				editPanel.painelContentComponent(Messages.getString("PlusPainelDocumento.22"), painelBotoes())); //$NON-NLS-1$

		// painel principal de Dados da Ata
		contentPainel.add(Messages.getString("PlusPainelDocumento.23"), painelContentEIA); //$NON-NLS-1$
		contentPainel.add(Messages.getString("PlusPainelDocumento.24"), editPanel.painelNull(0, 10)); //$NON-NLS-1$
		contentPainel.add(Messages.getString("PlusPainelDocumento.25"), editPanel.painelNull(10, 0)); //$NON-NLS-1$

		alterarFontes();
		painelInternoNorte();
		getTelaPrincipal();
	}

	private void alterarFontes() {
		lbCodigo.setFont(font.font_PLA_14);
		lbPedido.setFont(font.font_PLA_14);
		lbDocumento.setFont(font.font_PLA_14);
		lbEntrega.setFont(font.font_PLA_14);
		lbDescricao.setFont(font.font_NEG_15);
		lbStatus.setFont(font.font_PLA_14);
		lbNomeDiscente.setFont(font.font_PLA_14);

		tfProtocolo.setFont(font.font_NEG_15);
		tfProtocolo.setPreferredSize(new Dimension(200, 0));
		tfDocumento.setFont(font.font_NEG_15);
		tfDocumento.setPreferredSize(new Dimension(400, 0));

		ftDataEntrega.setPreferredSize(new Dimension(70, 0));
		ftDataPedido.setPreferredSize(new Dimension(70, 0));

		tfDiscente.setFont(font.font_NEG_15);

		tfDiscente.setPreferredSize(new Dimension(350, 0));

		taDescricao.setPreferredSize(new Dimension(200, 200));
		taDescricao
				.setToolTipText(Messages.getString("PlusPainelDocumento.26")); //$NON-NLS-1$
		taDescricao.setLineWrap(true);
		taDescricao.setWrapStyleWord(true);

		btnSalvar.setFont(font.font_PLA_14);
		btnLimpar.setFont(font.font_PLA_14);
		btnAlterar.setFont(font.font_PLA_14);
		btnExcluir.setFont(font.font_PLA_14);
	}

	private void eventosBotoes() {
		// ADD EVENTOS
		btnLimpar.addActionListener(onClickLimparCampos);
		btnSalvar.addActionListener(onClickSalvarCaixa);
		btnAlterar.addActionListener(onClickAlterarCaixa);
		btnExcluir.addActionListener(onClickExcluirCaixa);
		btnCancelar.addActionListener(onClickCancelarOperacao);
		tabela.addMouseListener(onClickRowTable);
		comboStatus.addItemListener(onClickChangeModalidade);

	}

	public JPanel getTelaPrincipal() {

		final JPanel painelScrollMain = new JPanel(new BorderLayout(1, 1));

		scrollMain.setPreferredSize(mainJPanel.getPreferredSize());
		scrollMain.setViewportView(mainJPanel);

		painelScrollMain.add(scrollMain);
		painelLocalizarArquivo.add(Messages.getString("PlusPainelDocumento.27"), painelInternoNorte); //$NON-NLS-1$

		mainJPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));

		mainJPanel.add(Messages.getString("PlusPainelDocumento.28"), painelLocalizarArquivo); //$NON-NLS-1$
		mainJPanel.add(Messages.getString("PlusPainelDocumento.29"), editPanel.painelNull(20, 0)); //$NON-NLS-1$
		mainJPanel.add(Messages.getString("PlusPainelDocumento.30"), editPanel.painelNull(20, 0)); //$NON-NLS-1$
		mainJPanel.add(Messages.getString("PlusPainelDocumento.31"), editPanel.painelNull(0, 10)); //$NON-NLS-1$

		// Vai para Janela Principal
		return painelScrollMain;
	}

	private JPanel painelBotoes() {
		final JPanel painelBotoes = new JPanel(new BorderLayout(2, 2));
		final JPanel painelContentBotoes = new JPanel(
				new GridLayout(1, 5, 5, 5));

		btnCancelar.setText(Messages.getString("PlusPainelDocumento.32")); //$NON-NLS-1$

		painelContentBotoes.add(btnSalvar);
		painelContentBotoes.add(btnAlterar);
		painelContentBotoes.add(btnExcluir);
		painelContentBotoes.add(btnLimpar);
		painelContentBotoes.add(btnCancelar);

		painelBotoes.add(Messages.getString("PlusPainelDocumento.33"), painelContentBotoes); //$NON-NLS-1$
		painelBotoes.add(Messages.getString("PlusPainelDocumento.34"), editPanel.painelNull(0, 10)); //$NON-NLS-1$
		painelBotoes.add(Messages.getString("PlusPainelDocumento.35"), editPanel.painelNull(150, 0)); //$NON-NLS-1$
		painelBotoes.add(Messages.getString("PlusPainelDocumento.36"), editPanel.painelNull(0, 10)); //$NON-NLS-1$

		return painelBotoes;
	}

	private JPanel painelDescricao() {
		final JPanel painelDescricao = new JPanel(new BorderLayout(2, 2));
		final JPanel painelDescricaoButton = new JPanel(new GridLayout(1, 2, 5,
				5));

		taDescricao.setBorder(BorderFactory.createTitledBorder(BorderFactory
				.createSoftBevelBorder(2)));
		painelDescricaoButton.add(editPanel.painelContentComponent(Messages.getString("PlusPainelDocumento.37"), //$NON-NLS-1$
				taDescricao));

		painelDescricao.add(Messages.getString("PlusPainelDocumento.38"), painelDescricaoButton); //$NON-NLS-1$
		painelDescricao.add(Messages.getString("PlusPainelDocumento.39"), editPanel.painelNull(0, 30)); //$NON-NLS-1$
		painelDescricao.add(Messages.getString("PlusPainelDocumento.40"), editPanel.painelNull(30, 0)); //$NON-NLS-1$
		painelDescricao.add(Messages.getString("PlusPainelDocumento.41"), editPanel.painelNull(0, 30)); //$NON-NLS-1$

		return painelDescricao;
	}

	private JPanel painelDiscente() {

		final JPanel painelDiscenteLabel = new JPanel(
				new GridLayout(1, 2, 5, 5));
		final JPanel painelDiscenteText = new JPanel(new GridLayout(1, 3, 5, 5));
		final JPanel painelContentMain = new JPanel(new BorderLayout(2, 2));
		final JPanel contentMain = new JPanel(new BorderLayout(2, 2));
		final JPanel contentDiscente = new JPanel(new BorderLayout(2, 2));

		btnPesquisar.setEnabled(false);

		painelDiscenteLabel.add(lbNomeDiscente);
		painelDiscenteText.add(editPanel.painelContentComponent(Messages.getString("PlusPainelDocumento.42"), //$NON-NLS-1$
				tfDiscente));
		painelDiscenteText.add(editPanel.painelContentComponent(Messages.getString("PlusPainelDocumento.43"), //$NON-NLS-1$
				btnPesquisar));

		contentDiscente.add(Messages.getString("PlusPainelDocumento.44"), painelDiscenteLabel); //$NON-NLS-1$
		contentDiscente.add(Messages.getString("PlusPainelDocumento.45"), painelDiscenteText); //$NON-NLS-1$

		contentMain.add(Messages.getString("PlusPainelDocumento.46"), contentDiscente); //$NON-NLS-1$

		painelContentMain.add(Messages.getString("PlusPainelDocumento.47"), editPanel.painelNull(0, 10)); //$NON-NLS-1$
		painelContentMain.add(Messages.getString("PlusPainelDocumento.48"), editPanel.painelNull(0, 10)); //$NON-NLS-1$
		painelContentMain.add(Messages.getString("PlusPainelDocumento.49"), //$NON-NLS-1$
				editPanel.painelContentComponent(Messages.getString("PlusPainelDocumento.50"), contentMain)); //$NON-NLS-1$

		painelContentMain
				.setBorder(BorderFactory.createTitledBorder(
						BorderFactory.createSoftBevelBorder(2),
						Messages.getString("PlusPainelDocumento.51"))); //$NON-NLS-1$

		return painelContentMain;
	}

	private void painelInternoNorte() {
		final JPanel controleSuperior = new JPanel(new BorderLayout(2, 2));

		controleSuperior.add(Messages.getString("PlusPainelDocumento.52"), contentPainel); //$NON-NLS-1$
		controleSuperior.setBorder(BorderFactory
				.createTitledBorder(BorderFactory.createSoftBevelBorder(2)));

		painelInternoNorte.add(Messages.getString("PlusPainelDocumento.53"), painelDiscente()); //$NON-NLS-1$
		painelInternoNorte.add(Messages.getString("PlusPainelDocumento.54"), controleSuperior); //$NON-NLS-1$
		painelInternoNorte.add(Messages.getString("PlusPainelDocumento.55"), painelInternoSul()); //$NON-NLS-1$
	}

	private JPanel painelInternoSul() {
		painelInternoSul.add(Messages.getString("PlusPainelDocumento.56"), editPanel.painelNull(0, 5)); //$NON-NLS-1$
		painelInternoSul.add(Messages.getString("PlusPainelDocumento.57"), editPanel.painelNull(220, 0)); //$NON-NLS-1$
		painelInternoSul.add(Messages.getString("PlusPainelDocumento.58"), painelTable()); //$NON-NLS-1$

		return painelInternoSul;
	}

	private JPanel painelTable() {
		tabela.setModel(modelo);
		tabela.setToolTipText(Messages.getString("PlusPainelDocumento.59")); //$NON-NLS-1$

		scroll.setPreferredSize(new Dimension(0, 200)); // Define o tamanho da
														// tabela.
		scroll.setViewportView(tabela); // insere a tabela no painel Scroll

		painelTabela.add(Messages.getString("PlusPainelDocumento.60"), editPanel.painelNull(0, 10)); //$NON-NLS-1$
		painelTabela.add(Messages.getString("PlusPainelDocumento.61"), scroll); //$NON-NLS-1$

		return painelTabela;
	}

}
