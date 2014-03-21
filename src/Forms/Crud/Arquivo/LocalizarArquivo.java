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
import javax.swing.SwingConstants;

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
public class LocalizarArquivo extends TelaPadrao {

	private static final int DIST = 5;

	private static final String BORDER_INFO_CAIXA = "DADOS DA CAIXA";
	private static final int QUANT_LINHAS_GRID = 5;

	private JPanel mainJPanel = new JPanel(new BorderLayout(2,2));
	private JPanel painelLocalizarArquivo = new JPanel(new BorderLayout(2,2));
	private JPanel painelInternoNorte = new JPanel(new BorderLayout(2,2));
	private JPanel painelInternoSul = new JPanel(new BorderLayout(2,2));
	private JPanel painelEsquerdo = new JPanel(new GridLayout(QUANT_LINHAS_GRID,1,DIST,DIST));
	private JPanel painelDireito = new JPanel(new GridLayout(QUANT_LINHAS_GRID,1,DIST,DIST));
	private JPanel painelTabela= new JPanel(new BorderLayout(2,2));	
	private JPanel painelContentEIA = new JPanel(new BorderLayout(2,2));
	
	private JScrollPane scroll = new JScrollPane();
	
	private JLabel lbCodigo = new JLabel("Cód. Caixa: ",SwingConstants.RIGHT);
	private JLabel lbCodigo2 = new JLabel("Cód. Caixa: ",SwingConstants.RIGHT);
	private JLabel lbTurno = new JLabel("Turno: ",SwingConstants.RIGHT);
	private JLabel lbLetra = new JLabel("Letra: ",SwingConstants.RIGHT);
	private JLabel lbStatus = new JLabel("Status: ",SwingConstants.RIGHT);
	private JLabel lbDadosCaixa = new JLabel("DADOS DA CAIXA",SwingConstants.CENTER);
	
	private JTextField tfCodigo = new JTextField();
	private JTextField tfLocalizar = new JTextField();
	
	private ImageIcon icone = new ImageIcon(DIR_ICONES+"search.png");

	private JButton btnSalvar = new JButton("Salvar");
	private JButton btnLimpar = new JButton("Limpar");
	private JButton btnExcluir = new JButton("Excluir");
	private JButton btnAlterar = new JButton("Alterar");
	private JButton btnPesquisar = new JButton("Pesquisar", icone);

	private ArrayList<Caixa> lista = new ArrayList<Caixa>();
	private CaixaTableModel modelo = new CaixaTableModel(lista);
	private JTable tabela = new JTable(modelo);

	private JScrollPane scrollMain = new JScrollPane();


	public LocalizarArquivo() {

		painelEsquerdo.add(painelNull(0, 0));
		painelEsquerdo.add(lbCodigo);
		painelEsquerdo.add(lbTurno);
		painelEsquerdo.add(lbLetra);
		painelEsquerdo.add(lbStatus);
		
		painelDireito.add(painelNull(0, 0));
		painelDireito.add(painelContentFieldTamanhoLargura(tfCodigo, 400));
		painelDireito.add(painelContentComponent("West", getComboBoxTurno()));
		painelDireito.add(painelContentComponent("West", getComboBoxLetra()));
		painelDireito.add(painelContentComponent("West", getComboBoxStatus()));
		
		// Este painel guarda o lado direito e esquedo descrito acima. Define também a borda especifica.
		painelContentEIA.add("North", lbDadosCaixa );
		painelContentEIA.add("West", painelEsquerdo);
		painelContentEIA.add("Center", painelDireito);
		painelContentEIA.add("East",painelNull(200, 0));
		
		alterarFontes();
		painelInternoNorte();
		getTelaPrincipal();
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
		mainJPanel.add("West",painelNull(20, 0));
		mainJPanel.add("East",painelNull(20, 0));
		mainJPanel.add("North",painelNull(0, 10));
		
		// Vai para Janela Principal
		return painelScrollMain;
	}

	private JPanel painelInternoSul() {
		painelInternoSul.add("Center",painelContentComponent("West", painelBotoes()));
		painelInternoSul.add("North",painelNull(0, 5));
		painelInternoSul.add("West",painelNull(220, 0));
		painelInternoSul.add("South",painelTable());
		
		return painelInternoSul;
	}
	
	private JPanel painelTable() {
		scroll.setPreferredSize(new Dimension(0, 200)); // Define o tamanho da tabela.
		scroll.setViewportView(tabela); // insere a tabela no painel Scroll
		
		painelTabela.add("North", painelNull(0, 10));
		painelTabela.add("Center",scroll);
		painelTabela.add("South",painelLocaliza());
		
		return painelTabela;
	}

	private JPanel painelLocaliza() {
		JPanel painelLocalizar = new JPanel(new BorderLayout(2,2));
		JPanel painelContentLocalizar = new JPanel(new BorderLayout(2,2));
		
		painelLocalizar.add("East", painelContentComponent("East", btnPesquisar));
		painelLocalizar.add("Center", tfLocalizar);
		painelLocalizar.add("West", painelContentComponent("West", lbCodigo2));
		painelLocalizar.add("North", painelNull(0, 5));
		
		painelContentLocalizar.add("Center", painelLocalizar);
		painelContentLocalizar.add("East", painelNull(400, 0));
		
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
		lbCodigo.setFont(font_PLA_14);
		lbCodigo2.setFont(font_PLA_14);
		lbLetra.setFont(font_PLA_14);
		lbTurno.setFont(font_PLA_14);
		lbStatus.setFont(font_PLA_14);
		lbDadosCaixa.setFont(font_NEG_15);
		
		tfCodigo.setFont(font_NEG_15);
		tfLocalizar.setFont(font_NEG_15);
		
		btnSalvar.setFont(font_PLA_14);
		btnPesquisar.setFont(font_PLA_14);
		btnLimpar.setFont(font_PLA_14);
		btnAlterar.setFont(font_PLA_14);
		btnExcluir.setFont(font_PLA_14);
		
		// COR
		lbCodigo.setForeground(Color.red);
		
		btnPesquisar.setPreferredSize(new Dimension(140,26));
		btnPesquisar.setRolloverEnabled(false);
	}
}
