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

	protected static final String BORDER_INFO_ALUNO = "DOSSIÊ DO DISCENTE";
	protected static final int QUANT_LINHAS_GRID = 13;

	protected JScrollPane scrollMain = new JScrollPane();

	protected JPanel mainJPanel = new JPanel(new BorderLayout(2,2));
	protected JPanel painelLocalizarArquivo = new JPanel(new BorderLayout(2,2));
	protected JPanel painelInternoNorte = new JPanel(new BorderLayout(2,2));
	protected JPanel painelInternoSul = new JPanel(new BorderLayout(2,2));
	protected JPanel painelEsquerdoInfoAluno = new JPanel(new GridLayout(QUANT_LINHAS_GRID,1,DIST,DIST));
	protected JPanel painelDireito = new JPanel(new GridLayout(QUANT_LINHAS_GRID,1,DIST,DIST));
	protected JPanel painelTabela= new JPanel(new BorderLayout(2,2));	
	protected JPanel painelContentEIA = new JPanel(new BorderLayout(2,2));
	protected JPanel painelBotoes = new JPanel(new BorderLayout(2,2));

	protected JLabel lbDadosAluno = new JLabel("DADOS DO DISCENTE",SwingConstants.CENTER);
	protected JLabel lbNome = new JLabel("Nome:* ",SwingConstants.RIGHT);
	protected JLabel lbCodigo2 = new JLabel("Discente: ",SwingConstants.RIGHT);
	protected JLabel lbCodigo = new JLabel("Código:* ",SwingConstants.RIGHT);
	protected JLabel lbCPF = new JLabel("CPF: ",SwingConstants.RIGHT);
	protected JLabel lbCor = new JLabel("Cor/Raça: ",SwingConstants.RIGHT);
	protected JLabel lbNis = new JLabel("NIS: ",SwingConstants.RIGHT);
	protected JLabel lbDataNasc = new JLabel("Nascimento.:* ",SwingConstants.RIGHT);
	protected JLabel lbSexo = new JLabel("Sexo: ",SwingConstants.RIGHT);
	protected JLabel lbNomeMae = new JLabel("Mãe: ",SwingConstants.RIGHT);
	protected JLabel lbEstadoMae = new JLabel("Estado Nasc. Mae: ",SwingConstants.RIGHT);
	protected JLabel lbCertRegNum = new JLabel("Certificado Reg. Nº: ",SwingConstants.RIGHT);
	protected JLabel lbEnd = new JLabel("Endereço: ",SwingConstants.RIGHT);
	protected JLabel lbCidade = new JLabel("Cidade Nasc.: ",SwingConstants.RIGHT);
	protected JLabel lbEstado = new JLabel("Estado Nasc.: ",SwingConstants.RIGHT);
	protected JLabel lbFone = new JLabel("Telefone: ",SwingConstants.RIGHT);
	protected JLabel lbDataMatricula = new JLabel("Data Matrícula: ",SwingConstants.RIGHT);
	protected JLabel lbTransferencia = new JLabel("Admitido por Transferência? ",SwingConstants.RIGHT); // Tem que ativar um campo de data
	protected JLabel lbSituacao = new JLabel("Situação Atual: ",SwingConstants.RIGHT);
	protected JLabel lbRefBox = new JLabel("Cód. Caixa",SwingConstants.RIGHT);
	protected JLabel lbLocaInter = new JLabel("Ordem",SwingConstants.RIGHT);
	protected JLabel lbLivro = new JLabel("Livro:",SwingConstants.RIGHT);
	protected JLabel lbFolha = new JLabel("Fls.:",SwingConstants.RIGHT);
	protected JLabel lbData = new JLabel("Data Entrada:",SwingConstants.RIGHT);
	protected JLabel lbDataReg = new JLabel("Data Reg.:",SwingConstants.RIGHT);

	public PainelMainAluno(MainJFrame mainJFrame) {
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
		painelDireito.add(editPanel.painelContentComponent("West", tfNome)); // Nome
		painelDireito.add(painelLadoLado(tfCodigo, lbNis, tfNis)); //Codigo - NIS
		painelDireito.add(painelLadoLado(ftCpf,lbEstado, comboUFAluno)); // CPF - Estado
		painelDireito.add(editPanel.painelContentComponent("West", tfNomeMae)); // Mae
		painelDireito.add(editPanel.painelContentComponent("West", painelDataSexoCor())); // Data Nac. - Sexo - Cor
		painelDireito.add(editPanel.painelContentComponent("West", tfCidade)); // Cidade
		painelDireito.add(painelLadoLado(tfEnd,lbFone,ftFone)); // Telefone - Endereço
		painelDireito.add(painelLadoLado(ftDataMatricula,lbTransferencia,comboTranferencia)); // Data Matri - Transfe
		painelDireito.add(editPanel.painelContentComponent("West", comboSituacao)); //Situação
		painelDireito.add(editPanel.painelContentComponent("West", tfNumCertificado)); //Certificado
		painelDireito.add(painelLadoLado(tfLivro, lbFolha, tfFolha)); //Livro - Folha
		painelDireito.add(editPanel.painelContentComponent("West", ftDataReg)); //Data

		JPanel painete = new JPanel(new BorderLayout(2,2));
		painete.setBackground(Color.black);

		painelContentEIA.add("North", lbDadosAluno);
		painelContentEIA.add("West", painelEsquerdoInfoAluno);
		painelContentEIA.add("Center", painelDireito);

		alterarFontes();
		painelInternoNorte();
		getTelaPrincipal();
	}

	/**
	 * Carregar as dicas dos botões;
	 **/
	private void iniTToolTips() {
		btnAtaResul.setToolTipText("1 (um) clique para mudar a tabela abaixo. " +
				"Ou 2 (dois) clique para alterar os dados.");
		
		btnDocumento.setToolTipText("1 (um) clique para mudar a tabela abaixo. " +
				"Ou 2 (dois) cliques para alterar os dados.");
		
		btnCaixa.setToolTipText("Alterar Caixa do aluno.");
	}

	private void eventosBotoes() {
		// Evento botão excluir
		btnExcluir.addActionListener(
				onClickExcluirAluno);

		// Evento do botão Limpar
		btnLimpar.addActionListener(
				onClickLimparCampos);

		// Evento do botão Salvar
		btnSalvar.addActionListener(
				onClickSalvarAluno);

		//Evento do botão Alterar
		btnAlterar.addActionListener(
				onClickAlterarAluno);

		// Evento do Botão Documento
		btnDocumento.addMouseListener(onClickMudarTabelaDocumento);

		// Evento do botão Ata
		btnAtaResul.addMouseListener(onClickMudarTabelaAta);

		//Evento do botão Buscar
		btnPesquisar.addActionListener(onClickBuscarAluno);

		btnCaixa.addActionListener(onClickCaixa);
		
		table.getTabela().addMouseListener(onClickSelecionarAtaAluno);
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

	/**
	 * Painel para organizar horizontalmente a Data, Sexo e a Cor lado-a-lado.
	 **/
	private JPanel painelDataSexoCor() {
		JPanel painelDataSexoCor = new JPanel(new BorderLayout(10,10));
		JPanel painelCor = new JPanel(new BorderLayout(10,10));
		JPanel painelSexo = new JPanel(new BorderLayout(10,10));

		JPanel painelSeparador = new JPanel(new BorderLayout(10,10));
		JPanel painelSeparador2 = new JPanel(new BorderLayout(10,10));

		// COR
		painelCor.add("West", lbCor); // COR
		painelCor.add("Center", editPanel.painelContentComponent("West", comboCor));
		// SEPARADOR
		painelSeparador.add("West", editPanel.painelNull(50, 0));
		painelSeparador.add("Center", painelCor);
		// SEXO
		painelSexo.add("West", lbSexo); // SEXO
		painelSexo.add("Center", editPanel.painelContentComponent("West", comboSexo));
		// SEPARADOR
		painelSeparador2.add("West", editPanel.painelNull(50, 0));
		painelSeparador2.add("Center", painelSexo);
		// DATA
		painelDataSexoCor.add("West", ftDataNasc); // DATA
		painelDataSexoCor.add("Center", painelSeparador2);
		painelDataSexoCor.add("East", painelSeparador);

		return painelDataSexoCor;
	}

	private void painelInternoNorte() {
		JPanel controleSuperior = new JPanel(new BorderLayout(2,2));

		controleSuperior.add("North",painelContentEIA);
		controleSuperior.setBorder(BorderFactory.createTitledBorder(
				BorderFactory.createSoftBevelBorder(2), BORDER_INFO_ALUNO));

		painelInternoNorte.add("Center",controleSuperior);
		painelInternoNorte.add("South",painelInternoSul());
		painelInternoNorte.add("North", contentPainelLocalizar());
		painelInternoNorte.add("East", painelReferenciaDireito());
	}

	private JPanel contentPainelLocalizar() {
		JPanel painel = new JPanel(new BorderLayout(2,2));
		painel.setBorder(BorderFactory.createTitledBorder(
				BorderFactory.createSoftBevelBorder(2), "CONSULTAR"));
		painel.add("North", painelLocaliza(lbCodigo2));
		return painel;
	}

	private JPanel painelReferenciaDireito() {
		// Icone
		IconesGroup icone = new IconesGroup();

		JPanel painel = new JPanel(new BorderLayout(2,2));
		JPanel painelGrid = new JPanel(new GridLayout(6,1,0,0));
		JPanel painelContent = new JPanel(new BorderLayout(2,2)); 

		JLabel lbImagem = new JLabel("",0);
		lbImagem.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		lbImagem.setIcon(icone.getIconeBox());

		painelGrid.add(editPanel.painelContentComponent("West", lbRefBox));
		painelGrid.add(editPanel.painelContentComponent("West", tfRefBox));
		painelGrid.add(editPanel.painelContentComponent("West", lbLocaInter));
		painelGrid.add(editPanel.painelContentComponent("West", tfLocaInter));
		painelGrid.add(editPanel.painelContentComponent("West", lbData));
		painelGrid.add(editPanel.painelContentComponent("West", ftData));

		painel.add("North", lbImagem);
		painel.add("Center",painelGrid);
		painel.add("South",editPanel.painelNull(0, 50)); // comprimir o lado direto da referencia das caixas

		painelContent.add("North", editPanel.painelNull(0, 4));
		painelContent.add("Center", painel);

		return painelContent;
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
		mainJPanel.add("North",editPanel.painelNull(0, 2));
		mainJPanel.add("South",editPanel.painelNull(0, 2));

		// Vai para Janela Principal
		return painelScrollMain;
	}

	private JPanel painelInternoSul() {
		painelInternoSul.add("Center",editPanel.painelContentComponent("West", painelBotoes()));
		painelInternoSul.add("North",editPanel.painelNull(0, 5));
		painelInternoSul.add("West",editPanel.painelNull(120, 0));
		painelInternoSul.add("South",painelTable()); // TABELA

		return painelInternoSul;
	}

	private JPanel painelTable() {
		scroll = table.organizandoColunasTables(modeloAtaResultado);
		
		painelTabela.add("North", editPanel.painelNull(0, 10));
		painelTabela.add("Center", scroll);

		return painelTabela;
	}

	private JPanel painelBotoes() {
		JPanel painelContentBotoes = new JPanel(new GridLayout(1,8,5,5));

		painelContentBotoes.add(btnSalvar);
		painelContentBotoes.add(btnAlterar);
		painelContentBotoes.add(btnExcluir);
		painelContentBotoes.add(btnLimpar);
		painelContentBotoes.add(editPanel.painelNull(5, 0));
		painelContentBotoes.add(btnDocumento);
		painelContentBotoes.add(btnAtaResul);
		painelContentBotoes.add(btnCaixa);

		painelBotoes.add("Center", painelContentBotoes);

		return painelBotoes;
	}

	private void alterarFontes() {
		FontGroup font = new FontGroup();

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

		tfNome.setPreferredSize(new Dimension(450,0));
		tfCodigo.setPreferredSize(new Dimension(100,0));
		tfNis.setPreferredSize(new Dimension(100,0));
		tfNomeMae.setPreferredSize(new Dimension(450,0));
		tfEnd.setPreferredSize(new Dimension(312,0));
		tfCidade.setPreferredSize(new Dimension(312,0));
		tfRefBox.setPreferredSize(new Dimension(130,0));
		tfLocaInter.setPreferredSize(new Dimension(130,0));
		tfNumCertificado.setPreferredSize(new Dimension(130,0));
		tfLivro.setPreferredSize(new Dimension(100,0));
		tfFolha.setPreferredSize(new Dimension(100,0));
		
		ftCpf.setPreferredSize(new Dimension(100,0));
		ftDataMatricula.setPreferredSize(new Dimension(80,0));
		ftDataReg.setPreferredSize(new Dimension(80,0));
		ftFone.setPreferredSize(new Dimension(100,0));
		ftData.setPreferredSize(new Dimension(80,0));
		ftDataNasc.setPreferredSize(new Dimension(80,0));

		tfRefBox.setForeground(Color.RED);
		tfLocaInter.setForeground(Color.RED);

		// Outros
		ftFone.setBorder(null);
		ftCpf.setBorder(null);
		ftDataNasc.setBorder(null);
		ftDataMatricula.setBorder(null);
		ftDataReg.setBorder(null);

		//Desativando
		tfRefBox.setEditable(false);
		ftData.setEditable(false);
		tfLocaInter.setEditable(false);
	}
}
