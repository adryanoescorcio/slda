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

	private JPanel mainJPanel = new JPanel(new BorderLayout(2,2));
	private JPanel painelLocalizarArquivo = new JPanel(new BorderLayout(2,2));
	private JPanel painelInternoNorte = new JPanel(new BorderLayout(2,2));
	private JPanel painelInternoSul = new JPanel(new BorderLayout(2,2));
	private JPanel painelEsquerdoLabel = new JPanel(new GridLayout(QUANT_LINHAS_GRID,1,DIST,DIST));
	private JPanel painelDireitoField = new JPanel(new GridLayout(QUANT_LINHAS_GRID,1,DIST,DIST));
	private JPanel painelTabela= new JPanel(new BorderLayout(2,2));	
	private JPanel painelContentEIA = new JPanel(new BorderLayout(2,2));
	private JPanel contentPainel = new JPanel(new BorderLayout(2,2));

	private JScrollPane scroll = new JScrollPane();
	private JScrollPane scrollMain = new JScrollPane();

	private JLabel lbDadosAta = new JLabel("DADOS DA ATA", SwingConstants.CENTER);
	private JLabel lbTurma = new JLabel("Turma:* ", SwingConstants.RIGHT);
	private JLabel lbCodigo2 = new JLabel("Selecionar as atas do ano de: ", SwingConstants.RIGHT);
	private JLabel lbTurno = new JLabel("Turno:* ", SwingConstants.RIGHT);
	private JLabel lbAno = new JLabel("Ano:* ", SwingConstants.RIGHT);
	private JLabel lbModalidade = new JLabel("Modalidade: ", SwingConstants.RIGHT);
	private JLabel lbEnsino = new JLabel("Ensino: ", SwingConstants.RIGHT);
	private JLabel lbDiscente = new JLabel("Discente: ", SwingConstants.RIGHT);

	public PainelMainAta(MainJFrame main) {
		super(main);
		eventosBotoes(); // EVENTOS
		
		// painel principal
		JPanel contentFormulario = new JPanel(new BorderLayout(2,2));

		//painelEsquerdo são as label dos campos das atas
		painelEsquerdoLabel.add(lbTurma);
		painelEsquerdoLabel.add(lbTurno);
		painelEsquerdoLabel.add(lbAno);
		painelEsquerdoLabel.add(lbModalidade);

		// painelDireito são os campos das ata
		painelDireitoField.add(editPanel.painelContentComponent("West", tfTurma));
		painelDireitoField.add(editPanel.painelContentComponent("West", comboTurno));
		painelDireitoField.add(editPanel.painelContentComponent("West", ftAno));
		painelDireitoField.add(editPanel.painelContentComponent("West", painelLadoLado(comboModalidade, lbEnsino, comboEnsino)));
		
		// Content Formulario contém os campos de dados das Atas
		contentFormulario.setBorder(BorderFactory.createTitledBorder(
				BorderFactory.createSoftBevelBorder(2), "FORMULÁRIO"));

		contentFormulario.add("West", painelEsquerdoLabel);
		contentFormulario.add("Center", painelDireitoField);
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

	/**
	 * Painel para organizar horizontalmente o Telefone e o Endereço
	 **/
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
	
	private JPanel painelLabelConsultar() {
		JPanel painel = new JPanel(new BorderLayout(1,1));
		painel.add("North", lbDadosAta);
		painel.add("Center", contentPainelLocalizar());
		painel.add("East", editPanel.painelNull(200, 0));
		
		return painel;
	}

	private void eventosBotoes() {
		
		//ADD EVENTOS
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

	private void painelInternoNorte() {
		JPanel controleSuperior = new JPanel(new BorderLayout(2,2));

		controleSuperior.add("North",contentPainel);
		controleSuperior.setBorder(BorderFactory.createTitledBorder(
				BorderFactory.createSoftBevelBorder(2)));

		painelInternoNorte.add("North", painelDiscente());
		painelInternoNorte.add("Center", controleSuperior);
		painelInternoNorte.add("South", painelInternoSul());
	}
	
	private JPanel painelDiscente() {
		
		JPanel painelDiscenteLabel = new JPanel(new GridLayout(1,2,1,1));
		JPanel painelDiscenteText = new JPanel(new GridLayout(1,2,1,1));
		JPanel painelContentMain = new JPanel(new BorderLayout(2,2));
		JPanel contentMain = new JPanel(new BorderLayout(2,2));
		JPanel contentDiscenteBotoes = new JPanel(new BorderLayout(2,2));
		JPanel contentDiscente = new JPanel(new BorderLayout(2,2));
		JPanel painelDiscenteBotoes = new JPanel(new GridLayout(1,2,10,1));

		painelDiscenteLabel.add(lbDiscente);
		painelDiscenteText.add(editPanel.painelContentComponent("West", tfDiscente));

		contentDiscente.add("Center", painelDiscenteLabel);
		contentDiscente.add("West", editPanel.painelNull(10, 0));
		contentDiscente.add("Center", painelDiscenteLabel);
		contentDiscente.add("East", painelDiscenteText);
		
		painelDiscenteBotoes.add(btnInserir);
		painelDiscenteBotoes.add(btnRetirar);
		
		contentDiscenteBotoes.add("Center", editPanel.painelContentComponent("West", painelDiscenteBotoes));
		contentDiscenteBotoes.add("West", editPanel.painelNull(20, 0));

		contentMain.add("West", contentDiscente);
		contentMain.add("Center", contentDiscenteBotoes);
		
		painelContentMain.add("North", editPanel.painelNull(0, 5));
		painelContentMain.add("South", editPanel.painelNull(0, 5));
		painelContentMain.add("West", editPanel.painelContentComponent("West",contentMain));
		
		painelContentMain.setBorder(BorderFactory.createTitledBorder(
				BorderFactory.createSoftBevelBorder(2), "DISCENTE SELECIONADO"));

		return painelContentMain;
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

		return painelScrollMain;
	}

	private JPanel painelInternoSul() {
		painelInternoSul.add("West",editPanel.painelNull(200, 0));
		painelInternoSul.add("South",painelTable());

		return painelInternoSul;
	}

	private JPanel painelTable() {
		tabela.setModel(modeloAta);
		tabela.setToolTipText("Dê dois cliques para selecionar a ata.");

		scroll.setPreferredSize(new Dimension(0, 200)); // Define o tamanho da tabela.
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scroll.setViewportView(table.getTabela()); // insere a tabela no painel Scroll
		scroll.setWheelScrollingEnabled(true);

		painelTabela.add("North", editPanel.painelNull(0, 5));
		painelTabela.add("Center", scroll);

		return painelTabela;
	}

	private JPanel painelBotoes() {
		JPanel painelBotoes = new JPanel(new BorderLayout(2,2));
		JPanel painelContentBotoes = new JPanel(new GridLayout(1,6,5,1));

		painelContentBotoes.add(btnSalvar);
		painelContentBotoes.add(btnAlterar);
		painelContentBotoes.add(btnExcluir);
		painelContentBotoes.add(btnLimpar);

		painelBotoes.add("Center", painelContentBotoes);
		painelBotoes.add("North", editPanel.painelNull(0, 5));
		painelBotoes.add("West", editPanel.painelNull(250, 0));
		painelBotoes.add("South", editPanel.painelNull(0, 5));

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
		lbDiscente.setFont(font.font_PLA_14);
		lbDadosAta.setFont(font.font_NEG_15);

		// JTextField
		tfTurma.setFont(font.font_NEG_15);
		tfDiscente.setFont(font.font_NEG_15);
		tfTurma.setPreferredSize(new Dimension(70,0)); // Setado tamanho fixo do Text
		tfDiscente.setPreferredSize(new Dimension(350,0)); // Setado tamanho fixo do Text
		ftAno.setPreferredSize(new Dimension(45,0));

		// Button
		btnSalvar.setFont(font.font_PLA_14);
		btnLimpar.setFont(font.font_PLA_14);
		btnAlterar.setFont(font.font_PLA_14);
		btnExcluir.setFont(font.font_PLA_14);

	}
}
