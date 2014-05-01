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
import ComponentGroupPlus.IconesGroup;
import ComponentGroupPlus.PainelTabela;
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

	protected static final int DIST = 5;
	
	private FontGroup font = new FontGroup();
	
	protected static final String BORDER_INFO_ALUNO = "DOSSIÊ DO DISCENTE";
	protected static final int QUANT_LINHAS_GRID = 10;

	protected JScrollPane scroll = new JScrollPane();
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
	protected JLabel lbDataNasc = new JLabel("Data Nasc.:* ",SwingConstants.RIGHT);
	protected JLabel lbSexo = new JLabel("Sexo: ",SwingConstants.RIGHT);
	protected JLabel lbNomeMae = new JLabel("Mãe: ",SwingConstants.RIGHT);
	protected JLabel lbEstadoMae = new JLabel("Estado Nasc. Mae: ",SwingConstants.RIGHT);
	protected JLabel lbNomePai = new JLabel("Pai: ",SwingConstants.RIGHT);
	protected JLabel lbEnd = new JLabel("Endereço: ",SwingConstants.RIGHT);
	protected JLabel lbCidade = new JLabel("Cidade Nasc.: ",SwingConstants.RIGHT);
	protected JLabel lbEstado = new JLabel("Estado Nasc.: ",SwingConstants.RIGHT);
	protected JLabel lbFone = new JLabel("Telefone: ",SwingConstants.RIGHT);
	protected JLabel lbDataMatricula = new JLabel("Data Matrícula: ",SwingConstants.RIGHT);
	protected JLabel lbTransferencia = new JLabel("Admitido por Transferência? ",SwingConstants.RIGHT); // Tem que ativar um campo de data
	protected JLabel lbSituacao = new JLabel("Situação Atual: ",SwingConstants.RIGHT);
	protected JLabel lbRefBox = new JLabel("Cód. Caixa");
	protected JLabel lbLocaInter = new JLabel("Subseção");

	public PainelMainAluno(MainJFrame mainJFrame) {
		super(mainJFrame);
		eventosBotoes();
		
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
		
		painelDireito.add(editPanel.painelNull(0, 0)); // Vazio
		painelDireito.add(editPanel.painelContentComponent("West", tfNome)); // Nome
		painelDireito.add(editPanel.painelContentComponent("West", tfCodigo)); //Codigo
		painelDireito.add(editPanel.painelContentComponent("West", painelCPFEstado())); // CPF - Estado
		painelDireito.add(editPanel.painelContentComponent("West", tfNomeMae)); // Mae
		painelDireito.add(editPanel.painelContentComponent("West", painelDataSexoCor())); // Data Nac. - Sexo - Cor
		painelDireito.add(editPanel.painelContentComponent("West", tfCidade)); // Cidade
		painelDireito.add(painelTelefoneEnd()); // Telefone - Endereço
		painelDireito.add(painelDataMatriculaTransf()); // Data Matri - Transfe
		painelDireito.add(editPanel.painelContentComponent("West", comboSituacao)); //Situação
		
		JPanel painete = new JPanel(new BorderLayout(2,2));
		painete.setBackground(Color.black);
		
		painelContentEIA.add("North", lbDadosAluno);
		painelContentEIA.add("West", painelEsquerdoInfoAluno);
		painelContentEIA.add("Center", painelDireito);
		
		ConfInit();
		alterarFontes();
		painelInternoNorte();
		getTelaPrincipal();
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
		btnDocumento.addActionListener(
				onClickDocumento);
		
		// Evento do botão Ata
		btnAtaResul.addActionListener(
				onClickAtaResul);
		
		//Evento do botão Buscar
		btnPesquisar.addActionListener(
				onClickBuscarAluno);
		
		btnCaixa.addActionListener(
				onClickCaixa);
	}

	/**
	 * Painel para organizar horizontalmente os atributos Data e Transferencia lado-a-lado
	 **/
	private JPanel painelDataMatriculaTransf() {
		
		JPanel painelDataMatriculaTransf = new JPanel(new BorderLayout(2,2));
		JPanel painelTrasferencia = new JPanel(new BorderLayout(2,2));
		JPanel painelSeparador2 = new JPanel(new BorderLayout(2,2));
		
		// Telefone
		painelTrasferencia.add("West", lbTransferencia);
		painelTrasferencia.add("Center", editPanel.painelContentComponent("West", comboTranferencia));
		// SEPARADOR
		painelSeparador2.add("West", editPanel.painelNull(50, 0));
		painelSeparador2.add("Center", painelTrasferencia);
		// Endereço
		painelDataMatriculaTransf.add("West", editPanel.painelContentComponent("West", ftDataMatricula));
		painelDataMatriculaTransf.add("Center", painelSeparador2);
		
		return painelDataMatriculaTransf;
	}

	/**
	 * Painel para organizar horizontalmente o Telefone e o Endereço
	 **/
	private JPanel painelTelefoneEnd() {
		
		JPanel painelEndTelefone = new JPanel(new BorderLayout(2,2));
		JPanel painelTelefone = new JPanel(new BorderLayout(2,2));
		JPanel painelSeparador2 = new JPanel(new BorderLayout(2,2));
		
		// Telefone
		painelTelefone.add("West", lbFone);
		painelTelefone.add("Center", editPanel.painelContentComponent("West", ftFone));
		// SEPARADOR
		painelSeparador2.add("West", editPanel.painelNull(50, 0));
		painelSeparador2.add("Center", painelTelefone);
		// Endereço
		painelEndTelefone.add("West", editPanel.painelContentComponent("West", tfEnd));
		painelEndTelefone.add("Center", painelSeparador2);
		
		return painelEndTelefone;
	}

	/**
	 * Paine para organizar horizontalmente o CPF e o Estado lado-a-lado
	 **/
	private JPanel painelCPFEstado() {
		JPanel painelCpfEstado = new JPanel(new BorderLayout(2,2));
		JPanel painelEstado = new JPanel(new BorderLayout(2,2));
		JPanel painelSeparador2 = new JPanel(new BorderLayout(2,2));
		
		// SEXO
		painelEstado.add("West", lbEstado);
		painelEstado.add("Center", editPanel.painelContentComponent("West", comboUFAluno));
		// SEPARADOR
		painelSeparador2.add("West", editPanel.painelNull(50, 0));
		painelSeparador2.add("Center", painelEstado);
		// DATA
		painelCpfEstado.add("West", ftCpf);
		painelCpfEstado.add("Center", painelSeparador2);
		
		return painelCpfEstado;
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
		JPanel painelGrid = new JPanel(new GridLayout(4,1,0,0));
		JPanel painelContent = new JPanel(new BorderLayout(2,2)); 
		
		JLabel lbImagem = new JLabel("",0);
		lbImagem.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		lbImagem.setIcon(icone.getIconeBox());
		
		painelGrid.add(editPanel.painelContentComponent("West", lbRefBox));
		painelGrid.add(editPanel.painelContentComponent("West", tfRefBox));
		painelGrid.add(editPanel.painelContentComponent("West", lbLocaInter));
		painelGrid.add(editPanel.painelContentComponent("West", tfLocaInter));
		
		painel.add("North", lbImagem);
		painel.add("Center",painelGrid);
		painel.add("South",editPanel.painelNull(0, 50));
		
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
		mainJPanel.add("North",editPanel.painelNull(0, 10));
		mainJPanel.add("South",editPanel.painelNull(0, 50));
		
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
		PainelTabela table = new PainelTabela();
		
		painelTabela.add("North", editPanel.painelNull(0, 10));
		painelTabela.add("Center", table.organizandoColunasTables(modeloAtaResultado));

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
	
	private void ConfInit() {
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
		lbNomePai.setFont(font.font_PLA_14);
		lbEnd.setFont(font.font_PLA_14);
		lbCidade.setFont(font.font_PLA_14);
		lbEstado.setFont(font.font_PLA_14);
		lbFone.setFont(font.font_PLA_14);
		lbDataMatricula.setFont(font.font_PLA_14);
		lbSituacao.setFont(font.font_PLA_14);		
		lbRefBox.setFont(font.font_PLA_14);
		lbLocaInter.setFont(font.font_PLA_14);
		
		// TITULO
		lbDadosAluno.setFont(font.font_NEG_15);

		// Cor
		lbCodigo.setForeground(Color.RED);
	}
	
	private void alterarFontes() {
		FontGroup font = new FontGroup();
		
		// JTextField
			tfNome.setFont(font.font_NEG_15);
			tfCidade.setFont(font.font_NEG_15);
			tfEnd.setFont(font.font_NEG_15);
			tfCodigo.setFont(font.font_NEG_15);
			tfRefBox.setFont(font.font_NEG_18);
			tfLocaInter.setFont(font.font_NEG_18);
			
			tfNome.setPreferredSize(new Dimension(450,0));
			tfCodigo.setPreferredSize(new Dimension(100,0));
			tfNomeMae.setPreferredSize(new Dimension(450,0));
			tfEnd.setPreferredSize(new Dimension(312,0));
			tfCidade.setPreferredSize(new Dimension(312,0));
			tfRefBox.setPreferredSize(new Dimension(130,0));
			tfLocaInter.setPreferredSize(new Dimension(130,0));
			
			tfRefBox.setForeground(Color.RED);
			tfLocaInter.setForeground(Color.RED);
			
			// Outros
			ftFone.setBorder(null);
			ftCpf.setBorder(null);
			ftDataNasc.setBorder(null);
			ftDataMatricula.setBorder(null);
			
			//Desativando
			tfRefBox.setEditable(false);
			tfLocaInter.setEditable(false);
	}
}
