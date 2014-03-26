package Forms.Crud.Caixa;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JTable;

import Eventos.EventosCaixa;
import Model.Caixa;

/**
 * Classe que representa a tela Arquivo - Localizar
 * 
 * @author Walysson Oliveira
 * @version 1.5
 * @extends TelaPadrao
 **/

@SuppressWarnings("serial")
public class PainelMainCaixa extends EventosCaixa {

	//TODOS OS ATRIBUTOS DEVEM FICAR NA CLASE EventosCaixa
	public PainelMainCaixa() {
		
		eventosBotoes();
		
		painelEsquerdo.add(padrao.painelNull(0, 0));
		painelEsquerdo.add(lbCodigo);
		painelEsquerdo.add(lbTurno);
		painelEsquerdo.add(lbLetra);
		painelEsquerdo.add(lbStatus);
		
		painelDireito.add(padrao.painelNull(0, 0));
		painelDireito.add(padrao.painelContentFieldTamanhoLargura(tfCodigo, 400));
		
		painelDireito.add(padrao.painelContentComponent("West", 
				comboTurno));
		painelDireito.add(padrao.painelContentComponent("West", 
				comboLetra));
		painelDireito.add(padrao.painelContentComponent("West", 
				comboStatus));
		
		// Este painel guarda o lado direito e esquedo descrito acima. Define também a borda especifica.
		painelContentEIA.add("North", lbDadosCaixa );
		painelContentEIA.add("West", painelEsquerdo);
		painelContentEIA.add("Center", painelDireito);
		painelContentEIA.add("East",padrao.painelNull(200, 0));
		
		alterarFontes();
		painelInternoNorte();
		getTelaPrincipal();
	}

	private void eventosBotoes() {
		//ADD EVENTOS
		btnLimpar.addActionListener(onClickLimparCampos);
		btnSalvar.addActionListener(onClickSalvarCaixa);
		btnAlterar.addActionListener(onClickAterarCaixa);
		btnPesquisar.addActionListener(onClickBuscarCaixa);
		btnExcluir.addActionListener(onClickExcluirCaixa);
	}

	private void painelInternoNorte() {
		JPanel controleSuperior = new JPanel(new BorderLayout(2,2));
		
		controleSuperior.add("North",painelContentEIA);
		controleSuperior.setBorder(BorderFactory.createTitledBorder(
		BorderFactory.createSoftBevelBorder(2), BORDER_INFO_CAIXA));

		
		painelInternoNorte.add("Center",controleSuperior);
		painelInternoNorte.add("South",painelInternoSul());
	}

	public JPanel getTelaPrincipal() {
		
		JPanel painelScrollMain = new JPanel(new BorderLayout(1,1));
		
		scrollMain.setPreferredSize(mainJPanel.getPreferredSize());
		scrollMain .setViewportView(mainJPanel);
		
		painelScrollMain.add(scrollMain);
		painelLocalizarArquivo.add("North",painelInternoNorte);
		
		mainJPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		
		mainJPanel.add("Center",painelLocalizarArquivo);
		mainJPanel.add("West",padrao.painelNull(20, 0));
		mainJPanel.add("East",padrao.painelNull(20, 0));
		mainJPanel.add("North",padrao.painelNull(0, 10));
		
		// Vai para Janela Principal
		return painelScrollMain;
	}

	private JPanel painelInternoSul() {
		painelInternoSul.add("Center",padrao.painelContentComponent("West", painelBotoes()));
		painelInternoSul.add("North",padrao.painelNull(0, 5));
		painelInternoSul.add("West",padrao.painelNull(220, 0));
		painelInternoSul.add("South",painelTable());
		
		return painelInternoSul;
	}
	
	private JPanel painelTable() {
		// carregando modelo da tabela.
		JTable tabela = padrao.getTabela();
		tabela.setModel(modelo);
		
		// Teste para a tabela
		Caixa cx = new Caixa();
		cx.setCodigo("9292");
		cx.setLetra("L");
		cx.setStatus("Ativo");
		cx.setTurno("Matutino");
		
		modelo.addContato(cx);
		
		scroll.setPreferredSize(new Dimension(0, 200)); // Define o tamanho da tabela.
		scroll.setViewportView(tabela); // insere a tabela no painel Scroll
		
		painelTabela.add("North", padrao.painelNull(0, 10));
		painelTabela.add("Center",scroll);
		painelTabela.add("South", painelLocaliza(lbCodigo2));
		
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
		
		return painelBotoes;
	}

	private void alterarFontes() {
		lbCodigo.setFont(padrao.font_PLA_14);
		lbCodigo2.setFont(padrao.font_PLA_14);
		lbLetra.setFont(padrao.font_PLA_14);
		lbTurno.setFont(padrao.font_PLA_14);
		lbStatus.setFont(padrao.font_PLA_14);
		lbDadosCaixa.setFont(padrao.font_NEG_15);
		
		tfCodigo.setFont(padrao.font_NEG_15);
		
		btnSalvar.setFont(padrao.font_PLA_14);
		btnLimpar.setFont(padrao.font_PLA_14);
		btnAlterar.setFont(padrao.font_PLA_14);
		btnExcluir.setFont(padrao.font_PLA_14);

		// COR
		lbCodigo.setForeground(Color.red);
	}
}
