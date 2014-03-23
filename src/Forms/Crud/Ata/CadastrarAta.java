package Forms.Crud.Ata;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import Forms.TelaPadrao;
import Forms.TablesModel.AtaTableModel;
import Model.Ata;

/**
 * Classe que representa a tela Ata - Cadastrar
 * 
 * @author Walysson Oliveira
 * @version 1.5
 * @extends TelaPadrao
 **/

public class CadastrarAta extends TelaPadrao {

	private static final int DIST = 5;

	private static final String BORDER_INFO_ATA = "DADOS DA ATA";
	private static final int QUANT_LINHAS_GRID = 6;

	private JPanel mainJPanel = new JPanel(new BorderLayout(2,2));
	private JPanel painelLocalizarArquivo = new JPanel(new BorderLayout(2,2));
	private JPanel painelInternoNorte = new JPanel(new BorderLayout(2,2));
	private JPanel painelInternoSul = new JPanel(new BorderLayout(2,2));
	private JPanel painelEsquerdoInfoAluno = new JPanel(new GridLayout(QUANT_LINHAS_GRID,1,DIST,DIST));
	private JPanel painelDireito = new JPanel(new GridLayout(QUANT_LINHAS_GRID,1,DIST,DIST));
	private JPanel painelTabela= new JPanel(new BorderLayout(2,2));	
	private JPanel painelContentEIA = new JPanel(new BorderLayout(2,2));
	
	private JScrollPane scroll = new JScrollPane();
	private JScrollPane scrollMain = new JScrollPane();
	
	private JLabel lbDadosAta = new JLabel("DADOS DA ATA",SwingConstants.CENTER);
	private JLabel lbTurma = new JLabel("Turma: ",SwingConstants.RIGHT);
	private JLabel lbCodigo2 = new JLabel("Código Ata: ",SwingConstants.RIGHT);
	private JLabel lbTurno = new JLabel("Turno: ",SwingConstants.RIGHT);
	private JLabel lbAno = new JLabel("Ano: ",SwingConstants.RIGHT);
	private JLabel lbModalidade = new JLabel("Modalidade: ",SwingConstants.RIGHT);
	private JLabel lbEnsino = new JLabel("Ensino: ",SwingConstants.RIGHT);
	
	private JTextField tfTurma = new JTextField();
	private JTextField tfTurno2 = new JTextField();
	
	private JFormattedTextField ftAno = new JFormattedTextField(getMascaraAno());
	
	private JButton btnSalvar = new JButton("Salvar");
	private JButton btnLimpar = new JButton("Limpar");
	private JButton btnExcluir = new JButton("Excluir");
	private JButton btnAlterar = new JButton("Alterar");

	private ArrayList<Ata> lista = new ArrayList<Ata>();
	private AtaTableModel modelo = new AtaTableModel(lista);
	
	
	public CadastrarAta() {
		
		painelEsquerdoInfoAluno.add(painelNull(0, 0));
		painelEsquerdoInfoAluno.add(lbTurma);
		painelEsquerdoInfoAluno.add(lbTurno);
		painelEsquerdoInfoAluno.add(lbAno);
		painelEsquerdoInfoAluno.add(lbModalidade);
		painelEsquerdoInfoAluno.add(lbEnsino);
		
		painelDireito.add(painelNull(0, 0));
		painelDireito.add(painelContentComponent("West", tfTurma));
		painelDireito.add(painelContentComponent("West", getComboBoxTurno()));
		painelDireito.add(painelContentComponent("West", ftAno));
		painelDireito.add(painelContentComponent("West", getComboBoxModalidade()));
		painelDireito.add(painelContentComponent("West", getComboBoxEnsino()));
		
		painelContentEIA.add("North", lbDadosAta);
		painelContentEIA.add("West", painelEsquerdoInfoAluno);
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
				BorderFactory.createSoftBevelBorder(2), BORDER_INFO_ATA));
		
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
		mainJPanel.add("West",painelNull(20, 0));
		mainJPanel.add("East",painelNull(20, 0));
		mainJPanel.add("North",painelNull(0, 15));
		
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
		// carregando modelo da tabela.
		getTabela().setModel(modelo);
		
		scroll.setPreferredSize(new Dimension(0, 200)); // Define o tamanho da tabela.
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		// Teste para a tabela
		
		Ata at = new Ata();
		at.setCodigo("Matutino", "201", "2012");
		at.setEnsinoAta("Regular");
		at.setModalidadeAta("EAD");
		
		Ata at3 = new Ata();
		at3.setCodigo("Matutino", "201", "2012");
		at3.setEnsinoAta("Regular");
		at3.setModalidadeAta("EAD");
		
		modelo.addContato(at3);
		modelo.addContato(at);
		
		scroll.setViewportView(getTabela()); // insere a tabela no painel Scroll
		scroll.setWheelScrollingEnabled(true);
		
		painelTabela.add("North", painelNull(0, 10));
		painelTabela.add("Center",scroll);
		painelTabela.add("South",painelLocaliza(lbCodigo2));
		
		return painelTabela;
	}

	private JPanel painelBotoes() {
		JPanel painelBotoes = new JPanel(new BorderLayout(2,2));
		JPanel painelContentBotoes = new JPanel(new GridLayout(1,6,5,5));
		
		painelContentBotoes.add(btnSalvar);
		painelContentBotoes.add(btnAlterar);
		painelContentBotoes.add(btnExcluir);
		painelContentBotoes.add(btnLimpar);
	
		painelBotoes.add("Center", painelContentBotoes);
		
		return painelBotoes;
	}

	private void alterarFontes() {
		// FONTE
		lbTurma.setFont(font_PLA_14);
		lbCodigo2.setFont(font_PLA_14);
		lbTurno.setFont(font_PLA_14);
		lbAno.setFont(font_PLA_14);
		lbModalidade.setFont(font_PLA_14);
		lbEnsino.setFont(font_PLA_14);
		lbDadosAta.setFont(font_NEG_15);
		
		// JTextField
		tfTurma.setFont(font_NEG_15);
		tfTurno2.setFont(font_NEG_15);
		tfTurma.setPreferredSize(new Dimension(70,0)); // Setado tamanho fixo do Text
		
		// Button
		btnSalvar.setFont(font_PLA_14);
		btnLimpar.setFont(font_PLA_14);
		btnAlterar.setFont(font_PLA_14);
		btnExcluir.setFont(font_PLA_14);
		
		tfTurma.setSize(20, 10);
		
		// Cor
		lbTurno.setForeground(Color.RED);
		ftAno.setBackground(Color.WHITE);
		
		// Outros
		ftAno.setBorder(null); // tirando a borda do component
	
	}

}
