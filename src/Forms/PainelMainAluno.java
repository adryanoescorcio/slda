package Forms;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

import Eventos.EventosAluno;

/**
 * Classe que representa a tela Aluno - Cadastrar
 * 
 * @author Walysson Oliveira
 * @version 1.5
 * @extends JFrame
 **/
@SuppressWarnings("serial")
public class PainelMainAluno extends EventosAluno{

	protected static final int DIST = 5;
	
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
	protected JLabel lbCor = new JLabel("Cor: ",SwingConstants.RIGHT);
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
	protected JLabel lbRefBox = new JLabel("Cod. Caixa");
	protected JLabel lbLocaInter = new JLabel("Localização Interna");
	
	public PainelMainAluno() {
		
		eventosBotoes();
		
		painelEsquerdoInfoAluno.add(padrao.painelNull(0, 0));
		painelEsquerdoInfoAluno.add(lbNome);
		painelEsquerdoInfoAluno.add(lbCodigo);
		painelEsquerdoInfoAluno.add(lbCPF);
		painelEsquerdoInfoAluno.add(lbNomeMae);
		painelEsquerdoInfoAluno.add(lbDataNasc);
		painelEsquerdoInfoAluno.add(lbCidade);
		painelEsquerdoInfoAluno.add(lbEnd);
		painelEsquerdoInfoAluno.add(lbDataMatricula);
		painelEsquerdoInfoAluno.add(lbSituacao);
		
		painelDireito.add(padrao.painelNull(0, 0)); // Vazio
		painelDireito.add(padrao.painelContentComponent("West", tfNome)); // Nome
		painelDireito.add(padrao.painelContentComponent("West", tfCodigo)); //Codigo
		painelDireito.add(padrao.painelContentComponent("West", painelCPFEstado())); // CPF - Estado
		painelDireito.add(padrao.painelContentComponent("West", tfNomeMae)); // Mae
		painelDireito.add(padrao.painelContentComponent("West", painelDataSexoCor())); // Data Nac. - Sexo - Cor
		painelDireito.add(padrao.painelContentComponent("West", tfCidade)); // Cidade
		painelDireito.add(painelTelefoneEnd()); // Telefone - Endereço
		painelDireito.add(painelDataMatriculaTransf()); // Data Matri - Transfe
		painelDireito.add(padrao.painelContentComponent("West", comboSituacao)); //Situação
		
		JPanel painete = new JPanel(new BorderLayout(2,2));
		painete.setBackground(Color.black);
		
		painelContentEIA.add("North", lbDadosAluno);
		painelContentEIA.add("West", painelEsquerdoInfoAluno);
		painelContentEIA.add("Center", painelDireito);
		
		ConfInit();
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
		painelTrasferencia.add("Center", padrao.painelContentComponent("West", comboTranferencia));
		// SEPARADOR
		painelSeparador2.add("West", padrao.painelNull(50, 0));
		painelSeparador2.add("Center", painelTrasferencia);
		// Endereço
		painelDataMatriculaTransf.add("West", padrao.painelContentComponent("West", ftDataMatricula));
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
		painelTelefone.add("Center", padrao.painelContentComponent("West", ftFone));
		// SEPARADOR
		painelSeparador2.add("West", padrao.painelNull(50, 0));
		painelSeparador2.add("Center", painelTelefone);
		// Endereço
		painelEndTelefone.add("West", padrao.painelContentComponent("West", tfEnd));
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
		painelEstado.add("Center", padrao.painelContentComponent("West", comboUFAluno));
		// SEPARADOR
		painelSeparador2.add("West", padrao.painelNull(50, 0));
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
		painelCor.add("Center", padrao.painelContentComponent("West", comboCor));
		// SEPARADOR
		painelSeparador.add("West", padrao.painelNull(50, 0));
		painelSeparador.add("Center", painelCor);
		// SEXO
		painelSexo.add("West", lbSexo); // SEXO
		painelSexo.add("Center", padrao.painelContentComponent("West", comboSexo));
		// SEPARADOR
		painelSeparador2.add("West", padrao.painelNull(50, 0));
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
		JPanel painel = new JPanel(new BorderLayout(2,2));
		JPanel painelGrid = new JPanel(new GridLayout(4,1,0,0));
		JPanel painelContent = new JPanel(new BorderLayout(2,2)); 
		
		ImageIcon imagem = new ImageIcon(DIR_ICONES+"box.jpg");
		JLabel lbImagem = new JLabel("",0);
		lbImagem.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		lbImagem.setIcon(imagem);
		
		painelGrid.add(padrao.painelContentComponent("West", lbRefBox));
		painelGrid.add(padrao.painelContentComponent("West", tfRefBox));
		painelGrid.add(padrao.painelContentComponent("West", lbLocaInter));
		painelGrid.add(padrao.painelContentComponent("West", tfLocaInter));
		
		painel.add("North", lbImagem);
		painel.add("Center",painelGrid);
		painel.add("South",padrao.painelNull(0, 50));
		
		painelContent.add("North", padrao.painelNull(0, 4));
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
		mainJPanel.add("West",padrao.painelNull(20, 0));
		mainJPanel.add("East",padrao.painelNull(20, 0));
		mainJPanel.add("North",padrao.painelNull(0, 10));
		mainJPanel.add("South",padrao.painelNull(0, 50));
		
		// Vai para Janela Principal
		return painelScrollMain;
	}

	private JPanel painelInternoSul() {
		painelInternoSul.add("Center",padrao.painelContentComponent("West", painelBotoes()));
		painelInternoSul.add("North",padrao.painelNull(0, 5));
		painelInternoSul.add("West",padrao.painelNull(120, 0));
		painelInternoSul.add("South",painelTable()); // TABELA
		
		return painelInternoSul;
	}
	
	private JPanel painelTable() {

		painelTabela.add("North", padrao.painelNull(0, 10));
		painelTabela.add("Center", padrao.organizandoColunasTables(modeloAtaResultado));
//		painelTabela.add("South", painelLocaliza(lbCodigo2)); // cria o painel de localizar

		return painelTabela;
	}

	private JPanel painelBotoes() {
		JPanel painelContentBotoes = new JPanel(new GridLayout(1,8,5,5));
		
		painelContentBotoes.add(btnSalvar);
		painelContentBotoes.add(btnAlterar);
		painelContentBotoes.add(btnExcluir);
		painelContentBotoes.add(btnLimpar);
		painelContentBotoes.add(padrao.painelNull(5, 0));
		painelContentBotoes.add(btnDocumento);
		painelContentBotoes.add(btnAtaResul);
		painelContentBotoes.add(btnCaixa);
		
		painelBotoes.add("Center", painelContentBotoes);
		
		return painelBotoes;
	}
	
	private void ConfInit() {
		// FONTE
		lbNome.setFont(padrao.font_PLA_14);
		lbCodigo2.setFont(padrao.font_PLA_14);
		lbCodigo.setFont(padrao.font_PLA_14);
		lbCPF.setFont(padrao.font_PLA_14);
		lbCor.setFont(padrao.font_PLA_14);
		lbNis.setFont(padrao.font_PLA_14);
		lbDataNasc.setFont(padrao.font_PLA_14);
		lbSexo.setFont(padrao.font_PLA_14);
		lbNomeMae.setFont(padrao.font_PLA_14);
		lbEstadoMae.setFont(padrao.font_PLA_14);
		lbNomePai.setFont(padrao.font_PLA_14);
		lbEnd.setFont(padrao.font_PLA_14);
		lbCidade.setFont(padrao.font_PLA_14);
		lbEstado.setFont(padrao.font_PLA_14);
		lbFone.setFont(padrao.font_PLA_14);
		lbDataMatricula.setFont(padrao.font_PLA_14);
		lbSituacao.setFont(padrao.font_PLA_14);		
		lbRefBox.setFont(padrao.font_PLA_14);
		lbLocaInter.setFont(padrao.font_PLA_14);
		
		// TITULO
		lbDadosAluno.setFont(padrao.font_NEG_15);

		// Cor
		lbCodigo.setForeground(Color.RED);
	}
	
}
