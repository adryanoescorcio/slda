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
	private FontGroup font = new FontGroup();

	protected static final String BORDER_INFO_CAIXA = "DADOS DA CAIXA";
	protected static final int QUANT_LINHAS_GRID = 6;

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

	protected JLabel lbCodigo = new JLabel("Protocolo: ",SwingConstants.RIGHT);
	protected JLabel lbDocumento = new JLabel("Documento:* ",SwingConstants.RIGHT);
	protected JLabel lbDescricao = new JLabel("DADOS DO DOCUMENTO",SwingConstants.CENTER);
	protected JLabel lbDescricaoDocumento = new JLabel("Descrição",SwingConstants.CENTER);
	protected JLabel lbPedido = new JLabel("Data Pedido:* ",SwingConstants.RIGHT);
	protected JLabel lbEntrega = new JLabel("Data Entrega: ",SwingConstants.RIGHT);
	protected JLabel lbNomeDiscente = new JLabel("Nome: ", SwingConstants.RIGHT);
	protected JLabel lbStatus = new JLabel("Status Doc.: ", SwingConstants.RIGHT);


	public PlusPainelDocumento(MainJFrame main, EventosAluno evento) {
		super(main,evento);
		atualizarAlunoTela();
		eventosBotoes();

		// painel principal
		JPanel contentFormulario = new JPanel(new BorderLayout(2,2));

		painelEsquerdo.add(editPanel.painelNull(0, 0));
		painelEsquerdo.add(lbCodigo);
		painelEsquerdo.add(lbDocumento);
		painelEsquerdo.add(lbPedido);
		painelEsquerdo.add(lbEntrega);
		painelEsquerdo.add(lbStatus);

		painelDireito.add(editPanel.painelNull(0, 0));

		painelDireito.add(editPanel.painelContentComponent("West", tfProtocolo));

		painelDireito.add(editPanel.painelContentComponent("West", tfDocumento));

		painelDireito.add(editPanel.painelContentComponent("West", ftDataPedido));

		painelDireito.add(editPanel.painelContentComponent("West", ftDataEntrega));
		
		painelDireito.add(editPanel.painelContentComponent("West", comboStatus));
		

		// Content Formulario contém os campos de dados das Atas
		contentFormulario.setBorder(BorderFactory.createTitledBorder(
				BorderFactory.createSoftBevelBorder(2), "FORMULÁRIO"));

		contentFormulario.add("West", painelEsquerdo);
		contentFormulario.add("Center", painelDireito);
		contentFormulario.add("South", painelDescricao());
		contentFormulario.add("East", editPanel.painelNull(200, 0));

		// Junta o campos de consulta com o formulario de dados mais os botões
//		painelContentEIA.add("North", painelLabelConsultar());
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

	private JPanel painelDescricao() {
		JPanel painelDescricao = new JPanel(new BorderLayout(2,2));
		JPanel painelDescricaoButton = new JPanel(new GridLayout(1,2,5,5));
		
		taDescricao.setBorder(BorderFactory.createTitledBorder(
				BorderFactory.createSoftBevelBorder(2)));
		painelDescricaoButton.add(editPanel.painelContentComponent("West", taDescricao));
		
		painelDescricao.add("Center", painelDescricaoButton);
		painelDescricao.add("North", editPanel.painelNull(0, 30));
		painelDescricao.add("West", editPanel.painelNull(30, 0));
		painelDescricao.add("South", editPanel.painelNull(0, 30));
		
		return painelDescricao;
	}

	private JPanel painelDiscente() {

		JPanel painelDiscenteLabel = new JPanel(new GridLayout(1,2,5,5));
		JPanel painelDiscenteText = new JPanel(new GridLayout(1,3,5,5));
		JPanel painelContentMain = new JPanel(new BorderLayout(2,2));
		JPanel contentMain = new JPanel(new BorderLayout(2,2));
		JPanel contentDiscente = new JPanel(new BorderLayout(2,2));

		btnPesquisar.setEnabled(false);
		
		painelDiscenteLabel.add(lbNomeDiscente);
		painelDiscenteText.add(editPanel.painelContentComponent("West", tfDiscente));
		painelDiscenteText.add(editPanel.painelContentComponent("West", btnPesquisar));

		contentDiscente.add("Center", painelDiscenteLabel);
		contentDiscente.add("East", painelDiscenteText);

		contentMain.add("West", contentDiscente);

		painelContentMain.add("North", editPanel.painelNull(0, 10));
		painelContentMain.add("South", editPanel.painelNull(0, 10));
		painelContentMain.add("West", editPanel.painelContentComponent("West",contentMain));

		painelContentMain.setBorder(BorderFactory.createTitledBorder(
				BorderFactory.createSoftBevelBorder(2), "DISCENTE SELECIONADO"));

		return painelContentMain;
	}

	private void eventosBotoes() {
		//ADD EVENTOS
		btnLimpar.addActionListener(onClickLimparCampos);
		btnSalvar.addActionListener(onClickSalvarCaixa);
		btnAlterar.addActionListener(onClickAlterarCaixa);
		btnExcluir.addActionListener(onClickExcluirCaixa);
		btnCancelar.addActionListener(onClickCancelarOperacao);
		tabela.addMouseListener(onClickRowTable);
		comboStatus.addItemListener(onClickChangeModalidade);

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
		JPanel painelContentBotoes = new JPanel(new GridLayout(1,5,5,5));

		btnCancelar.setText("Voltar");
		
		painelContentBotoes.add(btnSalvar);
		painelContentBotoes.add(btnAlterar);
		painelContentBotoes.add(btnExcluir);
		painelContentBotoes.add(btnLimpar);
		painelContentBotoes.add(btnCancelar);

		painelBotoes.add("Center", painelContentBotoes);
		painelBotoes.add("North", editPanel.painelNull(0, 10));
		painelBotoes.add("West", editPanel.painelNull(150, 0));
		painelBotoes.add("South", editPanel.painelNull(0, 10));

		return painelBotoes;
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
		tfProtocolo.setPreferredSize(new Dimension(200,0));
		tfDocumento.setFont(font.font_NEG_15);
		tfDocumento.setPreferredSize(new Dimension(200,0));
		
		ftDataEntrega.setPreferredSize(new Dimension(70,0));
		ftDataPedido.setPreferredSize(new Dimension(70,0));
		
		tfDiscente.setFont(font.font_NEG_15);

		tfDiscente.setPreferredSize(new Dimension(350,0));
		
		taDescricao.setPreferredSize(new Dimension(200,100));
		taDescricao.setToolTipText("Digite a descrição do documento ou avisos.");
		taDescricao.setLineWrap(true);
		taDescricao.setWrapStyleWord(true);
		
		btnSalvar.setFont(font.font_PLA_14);
		btnLimpar.setFont(font.font_PLA_14);
		btnAlterar.setFont(font.font_PLA_14);
		btnExcluir.setFont(font.font_PLA_14);
	}

}
