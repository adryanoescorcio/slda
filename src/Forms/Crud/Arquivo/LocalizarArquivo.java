package Forms.Crud.Arquivo;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import Eventos.EventosCaixa;
import Forms.TelaPadrao;
import Forms.TablesModel.CaixaTableModel;
import Model.Caixa;

/**
 * Classe que representa a tela Arquivo - Localizar
 * 
 * @author Walysson Oliveira
 * @version 1.5
 * @extends TelaPadrao
 **/

@SuppressWarnings("serial")
public class LocalizarArquivo extends EventosCaixa {
	public LocalizarArquivo() {
		
		painelEsquerdo.setPreferredSize(new Dimension(100,0));
		painelEsquerdo.add(lbCodigo);
		painelEsquerdo.add(lbTurno);
		painelEsquerdo.add(lbLetra);
		painelEsquerdo.add(lbStatus);
		
		painelDireito.add(tfCodigo);
		painelDireito.add(padrao.painelContentComponent("West", padrao.getComboBoxTurno()));
		painelDireito.add(padrao.painelContentComponent("West", padrao.getComboBoxLetra()));
		painelDireito.add(padrao.painelContentComponent("West", padrao.getComboBoxStatus()));
		
		alterarFontes();
		painelInternoNorte();
		telaPrincipal();
	}

	private void painelInternoNorte() {
		JPanel controleSuperior = new JPanel(new BorderLayout(2,2));
		
		controleSuperior.setPreferredSize(new Dimension(0,120));
		controleSuperior.add("West",painelEsquerdo);
		controleSuperior.add("Center",painelDireito);
		controleSuperior.add("East",padrao.painelNull(400, 0));
		
		painelInternoNorte.add("Center",controleSuperior);
		painelInternoNorte.add("South",painelInternoSul());
	}

	public JPanel telaPrincipal() {
		
		painelLocalizarArquivo.add("North",painelInternoNorte);
		
		mainJPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		
		mainJPanel.add("Center",painelLocalizarArquivo);
		mainJPanel.add("West",padrao.painelNull(20, 0));
		mainJPanel.add("East",padrao.painelNull(20, 0));
		mainJPanel.add("North",padrao.painelNull(0, 15));
		
		return mainJPanel;
	}

	private JPanel painelInternoSul() {
		painelInternoSul.add("Center",padrao.painelContentComponent("West", painelBotoes()));
		painelInternoSul.add("North",padrao.painelNull(0, 5));
		painelInternoSul.add("West",padrao.painelNull(220, 0));
		painelInternoSul.add("South",painelTable());
		
		return painelInternoSul;
	}
	
	private JPanel painelTable() {
		scroll.setPreferredSize(new Dimension(0, 200)); // Define o tamanho da tabela.
		scroll.setViewportView(tabela); // insere a tabela no painel Scroll
		
		painelTabela.add("North", padrao.painelNull(0, 10));
		painelTabela.add("Center",scroll);
		painelTabela.add("South",painelLocaliza());
		
		return painelTabela;
	}

	private JPanel painelLocaliza() {
		JPanel painelLocalizar = new JPanel(new BorderLayout(2,2));
		JPanel painelContentLocalizar = new JPanel(new BorderLayout(2,2));
		
		painelLocalizar.add("East", padrao.painelContentComponent("East", btnPesquisar));
		painelLocalizar.add("Center", tfLocalizar);
		painelLocalizar.add("West", padrao.painelContentComponent("West", lbCodigo2));
		painelLocalizar.add("North", padrao.painelNull(0, 5));
		
		painelContentLocalizar.add("Center", painelLocalizar);
		painelContentLocalizar.add("East", padrao.painelNull(400, 0));
		
		return painelContentLocalizar;
	}

	private JPanel painelBotoes() {
		JPanel painelBotoes = new JPanel(new BorderLayout(2,2));
		JPanel painelContentBotoes = new JPanel(new GridLayout(1,2,5,5));
		
		painelContentBotoes.add(btnSalvar);
		painelContentBotoes.add(btnAlterar);
		painelContentBotoes.add(btnExcluir);
		painelContentBotoes.add(btnLimpar);
		
		painelBotoes.add("Center", painelContentBotoes);
		
		return painelBotoes;
	}

	private void alterarFontes() {
		lbCodigo.setFont(padrao.font_PLA_15);
		lbCodigo2.setFont(padrao.font_PLA_15);
		lbLetra.setFont(padrao.font_PLA_15);
		lbTurno.setFont(padrao.font_PLA_15);
		lbStatus.setFont(padrao.font_PLA_15);
		
		tfCodigo.setFont(padrao.font_NEG_15);
		tfLocalizar.setFont(padrao.font_NEG_15);
		
		btnSalvar.setFont(padrao.font_PLA_15);
		btnPesquisar.setFont(padrao.font_PLA_15);
		btnLimpar.setFont(padrao.font_PLA_15);
		btnAlterar.setFont(padrao.font_PLA_15);
		btnExcluir.setFont(padrao.font_PLA_15);
		
		btnPesquisar.setPreferredSize(new Dimension(25,25));
		btnPesquisar.setRolloverEnabled(false);
	}

}
