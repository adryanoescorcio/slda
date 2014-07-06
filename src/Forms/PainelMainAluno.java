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
import ComponentGroupPlus.IconesGroup;
import Eventos.EventosAluno;

/**
 * Classe que representa a tela Aluno - Cadastrar
 * 
 * @author Walysson Oliveira
 * @author Adryano Escorcio
 * @version 3.0
 * @extends EventosAluno
 **/
public class PainelMainAluno extends EventosAluno {

	protected static final int DIST = 3;

	protected static final String BORDER_INFO_ALUNO = Messages.getString("PainelMainAluno.0"); //$NON-NLS-1$
	protected static final int QUANT_LINHAS_GRID = 13;

	protected JScrollPane scrollMain = new JScrollPane();

	protected JPanel mainJPanel = new JPanel(new BorderLayout(2, 2));
	protected Panel painelLocalizarArquivo = new Panel(new BorderLayout(2, 2));
	protected Panel painelInternoNorte = new Panel(new BorderLayout(2, 2));
	protected Panel painelInternoSul = new Panel(new BorderLayout(2, 2));
	protected Panel painelEsquerdoInfoAluno = new Panel(new GridLayout(
			QUANT_LINHAS_GRID, 1, DIST, DIST));
	protected Panel painelDireito = new Panel(new GridLayout(
			QUANT_LINHAS_GRID, 1, DIST, DIST));
	protected Panel painelTabela = new Panel(new BorderLayout(2, 2));
	protected Panel painelContentEIA = new Panel(new BorderLayout(2, 2));
	protected Panel painelBotoes = new Panel(new BorderLayout(2, 2));

	protected JLabel lbDadosAluno = new JLabel(Messages.getString("PainelMainAluno.1"), //$NON-NLS-1$
			SwingConstants.CENTER);
	protected JLabel lbNome = new JLabel(Messages.getString("PainelMainAluno.2"), SwingConstants.RIGHT); //$NON-NLS-1$
	protected JLabel lbCodigo2 = new JLabel(Messages.getString("PainelMainAluno.3"), SwingConstants.RIGHT); //$NON-NLS-1$
	protected JLabel lbCodigo = new JLabel(Messages.getString("PainelMainAluno.4"), SwingConstants.RIGHT); //$NON-NLS-1$
	protected JLabel lbCPF = new JLabel(Messages.getString("PainelMainAluno.5"), SwingConstants.RIGHT); //$NON-NLS-1$
	protected JLabel lbCor = new JLabel(Messages.getString("PainelMainAluno.6"), SwingConstants.RIGHT); //$NON-NLS-1$
	protected JLabel lbNis = new JLabel(Messages.getString("PainelMainAluno.7"), SwingConstants.RIGHT); //$NON-NLS-1$
	protected JLabel lbDataNasc = new JLabel(Messages.getString("PainelMainAluno.8"), //$NON-NLS-1$
			SwingConstants.RIGHT);
	protected JLabel lbSexo = new JLabel(Messages.getString("PainelMainAluno.9"), SwingConstants.RIGHT); //$NON-NLS-1$
	protected JLabel lbNomeMae = new JLabel(Messages.getString("PainelMainAluno.10"), SwingConstants.RIGHT); //$NON-NLS-1$
	protected JLabel lbEstadoMae = new JLabel(Messages.getString("PainelMainAluno.11"), //$NON-NLS-1$
			SwingConstants.RIGHT);
	protected JLabel lbCertRegNum = new JLabel(Messages.getString("PainelMainAluno.12"), //$NON-NLS-1$
			SwingConstants.RIGHT);
	protected JLabel lbEnd = new JLabel(Messages.getString("PainelMainAluno.13"), SwingConstants.RIGHT); //$NON-NLS-1$
	protected JLabel lbCidade = new JLabel(Messages.getString("PainelMainAluno.14"), //$NON-NLS-1$
			SwingConstants.RIGHT);
	protected JLabel lbEstado = new JLabel(Messages.getString("PainelMainAluno.15"), //$NON-NLS-1$
			SwingConstants.RIGHT);
	protected JLabel lbFone = new JLabel(Messages.getString("PainelMainAluno.16"), SwingConstants.RIGHT); //$NON-NLS-1$
	protected JLabel lbDataMatricula = new JLabel(Messages.getString("PainelMainAluno.17"), //$NON-NLS-1$
			SwingConstants.RIGHT);
	protected JLabel lbTransferencia = new JLabel(
			Messages.getString("PainelMainAluno.18"), SwingConstants.RIGHT); // Tem que //$NON-NLS-1$
																	// ativar um
																	// campo de
																	// data
	protected JLabel lbSituacao = new JLabel(Messages.getString("PainelMainAluno.19"), //$NON-NLS-1$
			SwingConstants.RIGHT);
	protected JLabel lbRefBox = new JLabel(Messages.getString("PainelMainAluno.20"), SwingConstants.RIGHT); //$NON-NLS-1$
	protected JLabel lbLocaInter = new JLabel(Messages.getString("PainelMainAluno.21"), SwingConstants.RIGHT); //$NON-NLS-1$
	protected JLabel lbLivro = new JLabel(Messages.getString("PainelMainAluno.22"), SwingConstants.RIGHT); //$NON-NLS-1$
	protected JLabel lbFolha = new JLabel(Messages.getString("PainelMainAluno.23"), SwingConstants.RIGHT); //$NON-NLS-1$
	protected JLabel lbData = new JLabel(Messages.getString("PainelMainAluno.24"), SwingConstants.RIGHT); //$NON-NLS-1$
	protected JLabel lbDataReg = new JLabel(Messages.getString("PainelMainAluno.25"), SwingConstants.RIGHT); //$NON-NLS-1$

	public PainelMainAluno(final MainJFrame mainJFrame) {
		super(mainJFrame);
		eventosBotoes();
		iniTToolTips();

		painelEsquerdoInfoAluno.add(editPanel.painelNull(0, 0));
		painelEsquerdoInfoAluno.add(lbNome);
		painelEsquerdoInfoAluno.add(lbCodigo);
		painelEsquerdoInfoAluno.add(lbCPF);
		painelEsquerdoInfoAluno.add(lbNomeMae);
		painelEsquerdoInfoAluno.add(lbDataNasc);
		painelEsquerdoInfoAluno.add(lbCidade);
		painelEsquerdoInfoAluno.add(lbEnd);
		painelEsquerdoInfoAluno.add(lbDataMatricula);
		painelEsquerdoInfoAluno.add(lbSituacao);
		painelEsquerdoInfoAluno.add(lbCertRegNum);
		painelEsquerdoInfoAluno.add(lbLivro);
		painelEsquerdoInfoAluno.add(lbDataReg);

		painelDireito.add(editPanel.painelNull(0, 0)); // Vazio
		painelDireito.add(editPanel.painelContentComponent(Messages.getString("PainelMainAluno.26"), tfNome)); // Nome //$NON-NLS-1$
		painelDireito.add(painelLadoLado(tfCodigo, lbNis, tfNis)); // Codigo -
																	// NIS
		painelDireito.add(painelLadoLado(ftCpf, lbEstado, comboUFAluno)); // CPF
																			// -
																			// Estado
		painelDireito.add(editPanel.painelContentComponent(Messages.getString("PainelMainAluno.27"), tfNomeMae)); // Mae //$NON-NLS-1$
		painelDireito.add(editPanel.painelContentComponent(Messages.getString("PainelMainAluno.28"), //$NON-NLS-1$
				painelDataSexoCor())); // Data Nac. - Sexo - Cor
		painelDireito.add(editPanel.painelContentComponent(Messages.getString("PainelMainAluno.29"), tfCidade)); // Cidade //$NON-NLS-1$
		painelDireito.add(painelLadoLado(tfEnd, lbFone, ftFone)); // Telefone -
																	// Endereço
		painelDireito.add(painelLadoLado(ftDataMatricula, lbTransferencia,
				comboTranferencia)); // Data Matri - Transfe
		painelDireito.add(editPanel.painelContentComponent(Messages.getString("PainelMainAluno.30"), //$NON-NLS-1$
				comboSituacao)); // Situação
		painelDireito.add(editPanel.painelContentComponent(Messages.getString("PainelMainAluno.31"), //$NON-NLS-1$
				tfNumCertificado)); // Certificado
		painelDireito.add(painelLadoLado(tfLivro, lbFolha, tfFolha)); // Livro -
																		// Folha
		painelDireito.add(editPanel.painelContentComponent(Messages.getString("PainelMainAluno.32"), ftDataReg)); // Data //$NON-NLS-1$

		final Panel painete = new Panel(new BorderLayout(2, 2));
		painete.setBackground(Color.black);

		painelContentEIA.add(Messages.getString("PainelMainAluno.33"), lbDadosAluno); //$NON-NLS-1$
		painelContentEIA.add(Messages.getString("PainelMainAluno.34"), painelEsquerdoInfoAluno); //$NON-NLS-1$
		painelContentEIA.add(Messages.getString("PainelMainAluno.35"), painelDireito); //$NON-NLS-1$

		alterarFontes();
		painelInternoNorte();
		getTelaPrincipal();
	}

	private void alterarFontes() {
		final FontGroup font = new FontGroup();

		// FONTE
		lbNome.setFont(font.font_PLA_14);
		lbCodigo2.setFont(font.font_PLA_14);
		lbCodigo.setFont(font.font_PLA_14);
		lbCPF.setFont(font.font_PLA_14);
		lbCor.setFont(font.font_PLA_14);
		lbNis.setFont(font.font_PLA_14);
		lbDataNasc.setFont(font.font_PLA_14);
		lbSexo.setFont(font.font_PLA_14);
		lbNomeMae.setFont(font.font_PLA_14);
		lbEstadoMae.setFont(font.font_PLA_14);
		lbCertRegNum.setFont(font.font_PLA_14);
		lbEnd.setFont(font.font_PLA_14);
		lbCidade.setFont(font.font_PLA_14);
		lbEstado.setFont(font.font_PLA_14);
		lbFone.setFont(font.font_PLA_14);
		lbDataMatricula.setFont(font.font_PLA_14);
		lbSituacao.setFont(font.font_PLA_14);
		lbRefBox.setFont(font.font_PLA_14);
		lbLocaInter.setFont(font.font_PLA_14);
		lbData.setFont(font.font_PLA_14);
		lbFolha.setFont(font.font_PLA_14);
		lbDataReg.setFont(font.font_PLA_14);
		lbCertRegNum.setFont(font.font_PLA_14);
		lbLivro.setFont(font.font_PLA_14);

		// TITULO
		lbDadosAluno.setFont(font.font_NEG_15);

		// JTextField
		tfNome.setFont(font.font_NEG_15);
		tfCidade.setFont(font.font_NEG_15);
		tfEnd.setFont(font.font_NEG_15);
		tfNumCertificado.setFont(font.font_NEG_15);
		tfNis.setFont(font.font_NEG_15);
		tfCodigo.setFont(font.font_NEG_15);
		tfLivro.setFont(font.font_NEG_15);
		tfFolha.setFont(font.font_NEG_15);
		tfNomeMae.setFont(font.font_NEG_15);

		tfRefBox.setFont(font.font_NEG_18);
		tfLocaInter.setFont(font.font_NEG_18);

		tfNome.setPreferredSize(new Dimension(450, 0));
		tfCodigo.setPreferredSize(new Dimension(100, 0));
		tfNis.setPreferredSize(new Dimension(100, 0));
		tfNomeMae.setPreferredSize(new Dimension(450, 0));
		tfEnd.setPreferredSize(new Dimension(312, 0));
		tfCidade.setPreferredSize(new Dimension(312, 0));
		tfRefBox.setPreferredSize(new Dimension(130, 0));
		tfLocaInter.setPreferredSize(new Dimension(130, 0));
		tfNumCertificado.setPreferredSize(new Dimension(130, 0));
		tfLivro.setPreferredSize(new Dimension(100, 0));
		tfFolha.setPreferredSize(new Dimension(100, 0));

		ftCpf.setPreferredSize(new Dimension(100, 0));
		ftDataMatricula.setPreferredSize(new Dimension(80, 0));
		ftDataReg.setPreferredSize(new Dimension(80, 0));
		ftFone.setPreferredSize(new Dimension(100, 0));
		ftData.setPreferredSize(new Dimension(80, 0));
		ftDataNasc.setPreferredSize(new Dimension(80, 0));

		tfRefBox.setForeground(Color.RED);
		tfLocaInter.setForeground(Color.RED);

		// Outros
		ftFone.setBorder(null);
		ftCpf.setBorder(null);
		ftDataNasc.setBorder(null);
		ftDataMatricula.setBorder(null);
		ftDataReg.setBorder(null);

		// Desativando
		tfRefBox.setEditable(false);
		ftData.setEditable(false);
		tfLocaInter.setEditable(false);
	}

	private JPanel contentPainelLocalizar() {
		final JPanel painel = new JPanel(new BorderLayout(2, 2));
		painel.setBorder(BorderFactory.createTitledBorder(
				BorderFactory.createSoftBevelBorder(2), Messages.getString("PainelMainAluno.36"))); //$NON-NLS-1$
		painel.add(Messages.getString("PainelMainAluno.37"), painelLocaliza(lbCodigo2)); //$NON-NLS-1$
		return painel;
	}

	private void eventosBotoes() {
		// Evento botão excluir
		btnExcluir.addActionListener(onClickExcluirAluno);

		// Evento do botão Limpar
		btnLimpar.addActionListener(onClickLimparCampos);

		// Evento do botão Salvar
		btnSalvar.addActionListener(onClickSalvarAluno);

		// Evento do botão Alterar
		btnAlterar.addActionListener(onClickAlterarAluno);

		// Evento do Botão Documento
		btnDocumento.addMouseListener(onClickMudarTabelaDocumento);

		// Evento do botão Ata
		btnAtaResul.addMouseListener(onClickMudarTabelaAta);

		// Evento do botão Buscar
		btnPesquisar.addActionListener(onClickBuscarAluno);

		btnCaixa.addActionListener(onClickCaixa);

		table.getTabela().addMouseListener(onClickSelecionarAtaAluno);
	}

	public Panel getTelaPrincipal() {
		final Panel painelScrollMain = new Panel(new BorderLayout(1, 1));

		scrollMain.setPreferredSize(mainJPanel.getPreferredSize());
		scrollMain.setViewportView(mainJPanel);

		painelScrollMain.add(scrollMain);
		painelLocalizarArquivo.add(Messages.getString("PainelMainAluno.38"), painelInternoNorte); //$NON-NLS-1$

		mainJPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));

		mainJPanel.add(Messages.getString("PainelMainAluno.39"), painelLocalizarArquivo); //$NON-NLS-1$
		mainJPanel.add(Messages.getString("PainelMainAluno.40"), editPanel.painelNull(20, 0)); //$NON-NLS-1$
		mainJPanel.add(Messages.getString("PainelMainAluno.41"), editPanel.painelNull(20, 0)); //$NON-NLS-1$
		mainJPanel.add(Messages.getString("PainelMainAluno.42"), editPanel.painelNull(0, 2)); //$NON-NLS-1$
		mainJPanel.add(Messages.getString("PainelMainAluno.43"), editPanel.painelNull(0, 2)); //$NON-NLS-1$

		// Vai para Janela Principal
		return painelScrollMain;
	}

	/**
	 * Carregar as dicas dos botões;
	 **/
	private void iniTToolTips() {
		btnAtaResul.setToolTipText(Messages.getString("PainelMainAluno.44") //$NON-NLS-1$
				+ Messages.getString("PainelMainAluno.45")); //$NON-NLS-1$

		btnDocumento
				.setToolTipText(Messages.getString("PainelMainAluno.46") //$NON-NLS-1$
						+ Messages.getString("PainelMainAluno.47")); //$NON-NLS-1$

		btnCaixa.setToolTipText(Messages.getString("PainelMainAluno.48")); //$NON-NLS-1$
	}

	private Panel painelBotoes() {
		final Panel painelContentBotoes = new Panel(
				new GridLayout(1, 8, 5, 5));

		painelContentBotoes.add(btnSalvar);
		painelContentBotoes.add(btnAlterar);
		painelContentBotoes.add(btnExcluir);
		painelContentBotoes.add(btnLimpar);
		painelContentBotoes.add(editPanel.painelNull(5, 0));
		painelContentBotoes.add(btnDocumento);
		painelContentBotoes.add(btnAtaResul);
		painelContentBotoes.add(btnCaixa);

		painelBotoes.add(Messages.getString("PainelMainAluno.49"), painelContentBotoes); //$NON-NLS-1$

		return painelBotoes;
	}

	/**
	 * Painel para organizar horizontalmente a Data, Sexo e a Cor lado-a-lado.
	 **/
	private Panel painelDataSexoCor() {
		final Panel painelDataSexoCor = new Panel(new BorderLayout(10, 10));
		final Panel painelCor = new Panel(new BorderLayout(10, 10));
		final Panel painelSexo = new Panel(new BorderLayout(10, 10));

		final Panel painelSeparador = new Panel(new BorderLayout(10, 10));
		final Panel painelSeparador2 = new Panel(new BorderLayout(10, 10));

		// COR
		painelCor.add(Messages.getString("PainelMainAluno.50"), lbCor); // COR //$NON-NLS-1$
		painelCor.add(Messages.getString("PainelMainAluno.51"), //$NON-NLS-1$
				editPanel.painelContentComponent(Messages.getString("PainelMainAluno.52"), comboCor)); //$NON-NLS-1$
		// SEPARADOR
		painelSeparador.add(Messages.getString("PainelMainAluno.53"), editPanel.painelNull(50, 0)); //$NON-NLS-1$
		painelSeparador.add(Messages.getString("PainelMainAluno.54"), painelCor); //$NON-NLS-1$
		// SEXO
		painelSexo.add(Messages.getString("PainelMainAluno.55"), lbSexo); // SEXO //$NON-NLS-1$
		painelSexo.add(Messages.getString("PainelMainAluno.56"), //$NON-NLS-1$
				editPanel.painelContentComponent(Messages.getString("PainelMainAluno.57"), comboSexo)); //$NON-NLS-1$
		// SEPARADOR
		painelSeparador2.add(Messages.getString("PainelMainAluno.58"), editPanel.painelNull(50, 0)); //$NON-NLS-1$
		painelSeparador2.add(Messages.getString("PainelMainAluno.59"), painelSexo); //$NON-NLS-1$
		// DATA
		painelDataSexoCor.add(Messages.getString("PainelMainAluno.60"), ftDataNasc); // DATA //$NON-NLS-1$
		painelDataSexoCor.add(Messages.getString("PainelMainAluno.61"), painelSeparador2); //$NON-NLS-1$
		painelDataSexoCor.add(Messages.getString("PainelMainAluno.62"), painelSeparador); //$NON-NLS-1$

		return painelDataSexoCor;
	}

	private void painelInternoNorte() {
		final JPanel controleSuperior = new JPanel(new BorderLayout(2, 2));

		controleSuperior.add(Messages.getString("PainelMainAluno.63"), painelContentEIA); //$NON-NLS-1$
		controleSuperior.setBorder(BorderFactory.createTitledBorder(
				BorderFactory.createSoftBevelBorder(2), BORDER_INFO_ALUNO));

		painelInternoNorte.add(Messages.getString("PainelMainAluno.64"), controleSuperior); //$NON-NLS-1$
		painelInternoNorte.add(Messages.getString("PainelMainAluno.65"), painelInternoSul()); //$NON-NLS-1$
		painelInternoNorte.add(Messages.getString("PainelMainAluno.66"), contentPainelLocalizar()); //$NON-NLS-1$
		painelInternoNorte.add(Messages.getString("PainelMainAluno.67"), painelReferenciaDireito()); //$NON-NLS-1$
	}

	private Panel painelInternoSul() {
		painelInternoSul.add(Messages.getString("PainelMainAluno.68"), //$NON-NLS-1$
				editPanel.painelContentComponent(Messages.getString("PainelMainAluno.69"), painelBotoes())); //$NON-NLS-1$
		painelInternoSul.add(Messages.getString("PainelMainAluno.70"), editPanel.painelNull(0, 5)); //$NON-NLS-1$
		painelInternoSul.add(Messages.getString("PainelMainAluno.71"), editPanel.painelNull(120, 0)); //$NON-NLS-1$
		painelInternoSul.add(Messages.getString("PainelMainAluno.72"), painelTable()); // TABELA //$NON-NLS-1$

		return painelInternoSul;
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
		painelTelefone.add(Messages.getString("PainelMainAluno.73"), lb2); //$NON-NLS-1$
		painelTelefone.add(Messages.getString("PainelMainAluno.74"), //$NON-NLS-1$
				editPanel.painelContentComponent(Messages.getString("PainelMainAluno.75"), comp2)); //$NON-NLS-1$
		// SEPARADOR
		painelSeparador2.add(Messages.getString("PainelMainAluno.76"), editPanel.painelNull(50, 0)); //$NON-NLS-1$
		painelSeparador2.add(Messages.getString("PainelMainAluno.77"), painelTelefone); //$NON-NLS-1$
		// Endereço
		painelEndTelefone.add(Messages.getString("PainelMainAluno.78"), //$NON-NLS-1$
				editPanel.painelContentComponent(Messages.getString("PainelMainAluno.79"), comp1)); //$NON-NLS-1$
		painelEndTelefone.add(Messages.getString("PainelMainAluno.80"), painelSeparador2); //$NON-NLS-1$

		return painelEndTelefone;
	}

	private Panel painelReferenciaDireito() {
		// Icone
		final IconesGroup icone = new IconesGroup();

		final Panel painel = new Panel(new BorderLayout(2, 2));
		final Panel painelGrid = new Panel(new GridLayout(6, 1, 0, 0));
		final Panel painelContent = new Panel(new BorderLayout(2, 2));

		final JLabel lbImagem = new JLabel(Messages.getString("PainelMainAluno.81"), 0); //$NON-NLS-1$
		lbImagem.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		lbImagem.setIcon(icone.getIconeBox());

		painelGrid.add(editPanel.painelContentComponent(Messages.getString("PainelMainAluno.82"), lbRefBox)); //$NON-NLS-1$
		painelGrid.add(editPanel.painelContentComponent(Messages.getString("PainelMainAluno.83"), tfRefBox)); //$NON-NLS-1$
		painelGrid.add(editPanel.painelContentComponent(Messages.getString("PainelMainAluno.84"), lbLocaInter)); //$NON-NLS-1$
		painelGrid.add(editPanel.painelContentComponent(Messages.getString("PainelMainAluno.85"), tfLocaInter)); //$NON-NLS-1$
		painelGrid.add(editPanel.painelContentComponent(Messages.getString("PainelMainAluno.86"), lbData)); //$NON-NLS-1$
		painelGrid.add(editPanel.painelContentComponent(Messages.getString("PainelMainAluno.87"), ftData)); //$NON-NLS-1$

		painel.add(Messages.getString("PainelMainAluno.88"), lbImagem); //$NON-NLS-1$
		painel.add(Messages.getString("PainelMainAluno.89"), painelGrid); //$NON-NLS-1$
		painel.add(Messages.getString("PainelMainAluno.90"), editPanel.painelNull(0, 50)); // comprimir o lado //$NON-NLS-1$
															// direto da
															// referencia das
															// caixas

		painelContent.add(Messages.getString("PainelMainAluno.91"), editPanel.painelNull(0, 4)); //$NON-NLS-1$
		painelContent.add(Messages.getString("PainelMainAluno.92"), painel); //$NON-NLS-1$

		return painelContent;
	}

	private Panel painelTable() {
		scroll = table.organizandoColunasTables(modeloAtaResultado);

		painelTabela.add(Messages.getString("PainelMainAluno.93"), editPanel.painelNull(0, 10)); //$NON-NLS-1$
		painelTabela.add(Messages.getString("PainelMainAluno.94"), scroll); //$NON-NLS-1$

		return painelTabela;
	}
}
