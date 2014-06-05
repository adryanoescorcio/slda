package Forms;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;

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

	protected static final int DIST = 5;

	// Fonte
	private FontGroup font = new FontGroup();

	protected static final String BORDER_INFO_CAIXA = "DADOS DA CAIXA";
	protected static final int QUANT_LINHAS_GRID = 3;

	protected JPanel mainJPanel = new JPanel(new BorderLayout(2,2));
	protected JPanel painelLocalizarArquivo = new JPanel(new BorderLayout(2,2));
	protected JPanel painelInternoNorte = new JPanel(new BorderLayout(2,2));
	protected JPanel painelInternoSul = new JPanel(new BorderLayout(2,2));
	protected JPanel painelEsquerdo = new JPanel(new GridLayout(QUANT_LINHAS_GRID,1,DIST,DIST));
	protected JPanel painelDireito = new JPanel(new GridLayout(QUANT_LINHAS_GRID,1,DIST,DIST));
	protected JPanel painelTabela= new JPanel(new BorderLayout(2,2));	
	protected JPanel painelContentEIA = new JPanel(new BorderLayout(2,2));
	protected JPanel contentPainel = new JPanel(new BorderLayout(2,2));

	protected JScrollPane scroll = new JScrollPane();
	protected JScrollPane scrollMain = new JScrollPane();

	protected JLabel lbCodigo = new JLabel("Cód. Caixa:* ",SwingConstants.RIGHT);
	protected JLabel lbCodigo2 = new JLabel("Cód. Caixa: ",SwingConstants.RIGHT);
	protected JLabel lbTurno = new JLabel("Turno:* ",SwingConstants.RIGHT);
	protected JLabel lbLetra = new JLabel("Letra:* ",SwingConstants.RIGHT);
	protected JLabel lbStatus = new JLabel("Status: ",SwingConstants.RIGHT);
	protected JLabel lbDadosCaixa = new JLabel("DADOS DA CAIXA",SwingConstants.CENTER);
	protected JLabel lbDiscente = new JLabel("Discente: ", SwingConstants.RIGHT);

	public PainelMainCaixa(MainJFrame main) {
		super(main);
		eventosBotoes();

		// painel principal
		JPanel contentFormulario = new JPanel(new BorderLayout(2,2));

		painelEsquerdo.add(lbCodigo);
		painelEsquerdo.add(lbLetra);
		painelEsquerdo.add(lbTurno);

		painelDireito.add(editPanel.painelContentComponent("West",tfCodigo));

		painelDireito.add(editPanel.painelContentComponent("West", comboLetra));

		painelDireito.add(editPanel.painelContentComponent("West", painelLadoLado(comboTurno, lbStatus, comboStatus)));


		// Content Formulario contém os campos de dados das Atas
		contentFormulario.setBorder(BorderFactory.createTitledBorder(
				BorderFactory.createSoftBevelBorder(2), "FORMULÁRIO"));

		contentFormulario.add("West", painelEsquerdo);
		contentFormulario.add("Center", painelDireito);
		contentFormulario.add("East", editPanel.painelNull(200, 0));

		// Junta o campos de consulta com o formulario de dados mais os botões
		painelContentEIA.add("North", painelLabelConsultar());
		painelContentEIA.add("East", editPanel.painelNull(200, 0));
		painelContentEIA.add("Center", contentFormulario);
		// inserindo os botões.
		painelContentEIA.add("South", editPanel.painelContentComponent("West", painelBotoes()));

		// painel principal de Dados da Ata
		contentPainel.add("Center", painelContentEIA);
		contentPainel.add("North", editPanel.painelNull(0, 10));
		contentPainel.add("West", editPanel.painelNull(10, 0));

		alterarFontes();
		painelInternoNorte();
		getTelaPrincipal();
	}

	private JPanel painelLadoLado(Component comp1, JLabel lb2, Component comp2) {

		JPanel painelEndTelefone = new JPanel(new BorderLayout(2,2));
		JPanel painelTelefone = new JPanel(new BorderLayout(2,2));
		JPanel painelSeparador2 = new JPanel(new BorderLayout(2,2));

		// Telefone
		painelTelefone.add("West", lb2);
		painelTelefone.add("Center", editPanel.painelContentComponent("West", comp2));
		// SEPARADOR
		painelSeparador2.add("West", editPanel.painelNull(50, 0));
		painelSeparador2.add("Center", painelTelefone);
		// Endereço
		painelEndTelefone.add("West", editPanel.painelContentComponent("West", comp1));
		painelEndTelefone.add("Center", painelSeparador2);

		return painelEndTelefone;
	}
	
	private JPanel painelDiscente() {

		JPanel painelDiscenteLabel = new JPanel(new GridLayout(1,2,5,5));
		JPanel painelDiscenteText = new JPanel(new GridLayout(1,2,5,5));
		JPanel painelContentMain = new JPanel(new BorderLayout(2,2));
		JPanel contentMain = new JPanel(new BorderLayout(2,2));
		JPanel contentDiscenteBotoes = new JPanel(new BorderLayout(2,2));
		JPanel contentDiscente = new JPanel(new BorderLayout(2,2));
		JPanel painelDiscenteBotoes = new JPanel(new GridLayout(1,3,5,5));

		painelDiscenteLabel.add(lbDiscente);
		painelDiscenteText.add(editPanel.painelContentComponent("West", tfDiscente));

		contentDiscente.add("Center", painelDiscenteLabel);
		contentDiscente.add("East", painelDiscenteText);

		painelDiscenteBotoes.add(editPanel.painelContentComponent("West", comboNumero));
		painelDiscenteBotoes.add(btnInserir);
		painelDiscenteBotoes.add(btnRetirar);

		contentDiscenteBotoes.add("Center", editPanel.painelContentComponent("West", painelDiscenteBotoes));
		contentDiscenteBotoes.add("West", editPanel.painelNull(20, 0));

		contentMain.add("West", contentDiscente);
		contentMain.add("Center", contentDiscenteBotoes);

		painelContentMain.add("North", editPanel.painelNull(0, 10));
		painelContentMain.add("South", editPanel.painelNull(0, 10));
		painelContentMain.add("West", editPanel.painelContentComponent("West",contentMain));

		painelContentMain.setBorder(BorderFactory.createTitledBorder(
				BorderFactory.createSoftBevelBorder(2), "DISCENTE SELECIONADO"));

		return painelContentMain;
	}

	private Component painelLabelConsultar() {
		JPanel painel = new JPanel(new BorderLayout(2,2));
		painel.add("North", lbDadosCaixa);
		painel.add("Center", contentPainelLocalizar());
		painel.add("East", editPanel.painelNull(200, 0));

		return painel;
	}

	private void eventosBotoes() {
		//ADD EVENTOS
		btnLimpar.addActionListener(onClickLimparCampos);
		btnSalvar.addActionListener(onClickSalvarCaixa);
		btnAlterar.addActionListener(onClickAlterarCaixa);
		btnPesquisar.addActionListener(onClickBuscarCaixa);
		btnExcluir.addActionListener(onClickExcluirCaixa);
		btnInserir.addActionListener(onClickInitInserir);
		btnRetirar.addActionListener(onClickInitRetirar);
		tabela.addMouseListener(onClickRowTable);

	}

	private void painelInternoNorte() {
		JPanel controleSuperior = new JPanel(new BorderLayout(2,2));

		controleSuperior.add("North",contentPainel);
		controleSuperior.setBorder(BorderFactory.createTitledBorder(
				BorderFactory.createSoftBevelBorder(2)));

		painelInternoNorte.add("North", painelDiscente());
		painelInternoNorte.add("Center",controleSuperior);
		painelInternoNorte.add("South",painelInternoSul());
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
		mainJPanel.add("North",editPanel.painelNull(0, 10));

		// Vai para Janela Principal
		return painelScrollMain;
	}

	private JPanel painelInternoSul() {
		//		painelInternoSul.add("Center",editPanel.painelContentComponent("West", painelBotoes()));
		painelInternoSul.add("North",editPanel.painelNull(0, 5));
		painelInternoSul.add("West",editPanel.painelNull(220, 0));
		painelInternoSul.add("South",painelTable());

		return painelInternoSul;
	}

	private JPanel painelTable() {
		tabela.setModel(modelo);
		tabela.setToolTipText("Dê um duplo clique na Caixa para Excluir ou Alterar");

		scroll.setPreferredSize(new Dimension(0, 200)); // Define o tamanho da tabela.
		scroll.setViewportView(tabela); // insere a tabela no painel Scroll

		painelTabela.add("North", editPanel.painelNull(0, 10));
		painelTabela.add("Center",scroll);
		//		painelTabela.add("South", painelLocaliza(lbCodigo2));

		return painelTabela;
	}

	private JPanel painelBotoes() {
		JPanel painelBotoes = new JPanel(new BorderLayout(2,2));
		JPanel painelContentBotoes = new JPanel(new GridLayout(1,4,5,5));

		painelContentBotoes.add(btnSalvar);
		painelContentBotoes.add(btnAlterar);
		painelContentBotoes.add(btnExcluir);
		painelContentBotoes.add(btnLimpar);

		painelBotoes.add("Center", painelContentBotoes);
		painelBotoes.add("North", editPanel.painelNull(0, 10));
		painelBotoes.add("West", editPanel.painelNull(250, 0));
		painelBotoes.add("South", editPanel.painelNull(0, 10));

		return painelBotoes;
	}

	private void alterarFontes() {
		lbCodigo.setFont(font.font_PLA_14);
		lbCodigo2.setFont(font.font_PLA_14);
		lbLetra.setFont(font.font_PLA_14);
		lbTurno.setFont(font.font_PLA_14);
		lbStatus.setFont(font.font_PLA_14);
		lbDadosCaixa.setFont(font.font_NEG_15);
		lbDiscente.setFont(font.font_PLA_14);

		tfCodigo.setFont(font.font_NEG_15);
		tfCodigo.setPreferredSize(new Dimension(200,0));
		tfDiscente.setFont(font.font_NEG_15);

		tfDiscente.setPreferredSize(new Dimension(350,0));

		btnSalvar.setFont(font.font_PLA_14);
		btnLimpar.setFont(font.font_PLA_14);
		btnAlterar.setFont(font.font_PLA_14);
		btnExcluir.setFont(font.font_PLA_14);
	}

}
