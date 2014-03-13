package Forms.Crud.Aluno;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;

import Forms.TelaPadrao;
import Forms.TablesModel.AlunoTableModel;
import Model.Aluno;

/**
 * Classe que representa a tela Aluno - Cadastrar
 * 
 * @author Walysson Oliveira
 * @version 1.5
 * @extends TelaPadrao
 **/
@SuppressWarnings("serial")
public class CadastrarAluno extends TelaPadrao{

	private static final int DIST = 5;

	private static final String BORDER_INFO_ALUNO = "DOSSIÊ DO ALUNO";
	private static final int QUANT_LINHAS_GRID = 9;

	private JPanel mainJPanel = new JPanel(new BorderLayout(2,2));
	private JPanel painelLocalizarArquivo = new JPanel(new BorderLayout(2,2));
	private JPanel painelInternoNorte = new JPanel(new BorderLayout(2,2));
	private JPanel painelInternoSul = new JPanel(new BorderLayout(2,2));
	private JPanel painelEsquerdoInfoAluno = new JPanel(new GridLayout(QUANT_LINHAS_GRID,1,DIST,DIST));
	private JPanel painelDireito = new JPanel(new GridLayout(QUANT_LINHAS_GRID,1,DIST,DIST));
	private JPanel painelTabela= new JPanel(new BorderLayout(2,2));	
	
	private JScrollPane scroll = new JScrollPane();
	private JScrollPane scrollMain = new JScrollPane();
	
	private JLabel lbDadosAluno = new JLabel("DADOS DO DISCENTE",SwingConstants.CENTER);
	private JLabel lbNome = new JLabel("Nome: ");
	private JLabel lbCodigo2 = new JLabel("Codigo Aluno: ");
	private JLabel lbCodigo = new JLabel("Codigo: ");
	private JLabel lbCPF = new JLabel("CPF: ");
	private JLabel lbCor = new JLabel("Cor: ");
	private JLabel lbNis = new JLabel("NIS: ");
	private JLabel lbDataNasc = new JLabel("Data Nasc.: ");
	private JLabel lbSexo = new JLabel("Sexo: ");
	private JLabel lbNomeMae = new JLabel("Mãe: ");
	private JLabel lbEstadoMae = new JLabel("Estado Nasc. Mae: ");
	private JLabel lbNomePai = new JLabel("Pai: ");
	private JLabel lbEnd = new JLabel("Endereço: ");
	private JLabel lbCidade = new JLabel("Cidade Nasc.: ");
	private JLabel lbEstado = new JLabel("Estado Nasc.: ");
	private JLabel lbFone = new JLabel("Telefone: ");
	private JLabel lbDataMatricula = new JLabel("Data Matricula: ");
	private JLabel lbTransferencia = new JLabel("Admitido por Transferencia? "); // Tem que ativar um campo de data
	private JLabel lbSituacao = new JLabel("Situação Atual: ");
	
	private JTextField tfNome = new JTextField();
	private JTextField tfLocalizar = new JTextField();
	private JTextField tfCodigo = new JTextField();
	private JTextField tfCidade = new JTextField();
	private JTextField tfEnd = new JTextField();
	
	private JFormattedTextField ftCpf = new JFormattedTextField(getMascaraCPF());
	private JFormattedTextField ftDataNasc = new JFormattedTextField(getMascaraData());
	private JFormattedTextField ftDataMatricula = new JFormattedTextField(getMascaraData());
	private JFormattedTextField ftFone = new JFormattedTextField(getMascaraTelefone());
	
	private ImageIcon icone = new ImageIcon(DIR_ICONES+"search.png");

	private JButton btnSalvar = new JButton("Salvar");
	private JButton btnLimpar = new JButton("Limpar");
	private JButton btnExcluir = new JButton("Excluir");
	private JButton btnAlterar = new JButton("Alterar");
	private JButton btnPesquisar = new JButton("Pesquisar", icone);

	private ArrayList<Aluno> lista = new ArrayList<Aluno>();
	private AlunoTableModel modelo = new AlunoTableModel(lista);
	private JTable tabela = new JTable(modelo);
	
	JPanel painelContentEIA;
	
	public CadastrarAluno() {
		painelContentEIA = new JPanel(new BorderLayout(2,2));
		
		painelEsquerdoInfoAluno.add(painelNull(0, 0));
		painelEsquerdoInfoAluno.add(lbNome);
		painelEsquerdoInfoAluno.add(lbCodigo);
		painelEsquerdoInfoAluno.add(lbCPF);
		painelEsquerdoInfoAluno.add(lbDataNasc);
		painelEsquerdoInfoAluno.add(lbCidade);
		painelEsquerdoInfoAluno.add(lbEnd);
		painelEsquerdoInfoAluno.add(lbDataMatricula);
		painelEsquerdoInfoAluno.add(lbSituacao);
		
		painelDireito.add(painelNull(0, 0));
		painelDireito.add(tfNome);
		painelDireito.add(tfCodigo);
		painelDireito.add(painelContentComponent("West", painelCPFEstado()));
		painelDireito.add(painelContentComponent("West", painelDataSexoCor()));
		painelDireito.add(tfCidade);
		painelDireito.add(painelTelefoneEnd());
		painelDireito.add(painelDataMatriculaTransf());
		painelDireito.add(painelContentComponent("West", getComboBoxSituacaoAluno()));
		
		painelContentEIA.add("North", lbDadosAluno);
		painelContentEIA.add("West", painelEsquerdoInfoAluno);
		painelContentEIA.add("Center", painelDireito);
		painelContentEIA.add("East",painelNull(200, 0));
		
		alterarFontes();
		painelInternoNorte();
		getTelaPrincipal();
	}

	private JPanel painelDataMatriculaTransf() {
		JPanel painelDataMatriculaTransf = new JPanel(new BorderLayout(2,2));
		JPanel painelTrasferencia = new JPanel(new BorderLayout(2,2));
		JPanel painelSeparador2 = new JPanel(new BorderLayout(2,2));
		
		// Telefone
		painelTrasferencia.add("West", lbTransferencia);
		painelTrasferencia.add("Center", painelContentComponent("West", getComboBoxTransferencia()));
		// SEPARADOR
		painelSeparador2.add("West", painelNull(50, 0));
		painelSeparador2.add("Center", painelTrasferencia);
		// Endereço
		painelDataMatriculaTransf.add("West", painelContentComponent("West", ftDataMatricula));
		painelDataMatriculaTransf.add("Center", painelSeparador2);
		
		return painelDataMatriculaTransf;
	}

	private JPanel painelTelefoneEnd() {
		
		JPanel painelEndTelefone = new JPanel(new BorderLayout(2,2));
		JPanel painelTelefone = new JPanel(new BorderLayout(2,2));
		JPanel painelSeparador2 = new JPanel(new BorderLayout(2,2));
		
		// Telefone
		painelTelefone.add("West", lbFone);
		painelTelefone.add("Center", painelContentComponent("West", ftFone));
		// SEPARADOR
		painelSeparador2.add("West", painelNull(50, 0));
		painelSeparador2.add("Center", painelTelefone);
		// Endereço
		painelEndTelefone.add("Center", tfEnd);
		painelEndTelefone.add("East", painelSeparador2);
		
		return painelEndTelefone;
	}

	private JPanel painelCPFEstado() {
		JPanel painelCpfEstado = new JPanel(new BorderLayout(2,2));
		JPanel painelEstado = new JPanel(new BorderLayout(2,2));
		JPanel painelSeparador2 = new JPanel(new BorderLayout(2,2));
		
		// SEXO
		painelEstado.add("West", lbEstado);
		painelEstado.add("Center", painelContentComponent("West", getComboBoxEstadosBR()));
		// SEPARADOR
		painelSeparador2.add("West", painelNull(50, 0));
		painelSeparador2.add("Center", painelEstado);
		// DATA
		painelCpfEstado.add("West", ftCpf);
		painelCpfEstado.add("Center", painelSeparador2);
		
		return painelCpfEstado;
	}

	private JPanel painelDataSexoCor() {
		JPanel painelDataSexoCor = new JPanel(new BorderLayout(10,10));
		JPanel painelCor = new JPanel(new BorderLayout(10,10));
		JPanel painelSexo = new JPanel(new BorderLayout(10,10));
		
		JPanel painelSeparador = new JPanel(new BorderLayout(10,10));
		JPanel painelSeparador2 = new JPanel(new BorderLayout(10,10));
		
		// COR
		painelCor.add("West", lbCor);
		painelCor.add("Center", painelContentComponent("West", getComboBoxCorRaca()));
		// SEPARADOR
		painelSeparador.add("West", painelNull(50, 0));
		painelSeparador.add("Center", painelCor);
		// SEXO
		painelSexo.add("West", lbSexo);
		painelSexo.add("Center", painelContentComponent("West", getComboBoxSexo()));
		// SEPARADOR
		painelSeparador2.add("West", painelNull(50, 0));
		painelSeparador2.add("Center", painelSexo);
		// DATA
		painelDataSexoCor.add("West", ftDataNasc);
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
		scroll.setPreferredSize(new Dimension(0, 200)); // Define o tamanho da tabela.
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		tabela.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		
		scroll.setViewportView(tabela); // insere a tabela no painel Scroll
		scroll.setWheelScrollingEnabled(true);
		
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
		// FONTE
		lbNome.setFont(font_PLA_14);
		lbCodigo2.setFont(font_PLA_14);
		lbCodigo.setFont(font_PLA_14);
		lbCPF.setFont(font_PLA_14);
		lbCor.setFont(font_PLA_14);
		lbNis.setFont(font_PLA_14);
		lbDataNasc.setFont(font_PLA_14);
		lbSexo.setFont(font_PLA_14);
		lbNomeMae.setFont(font_PLA_14);
		lbEstadoMae.setFont(font_PLA_14);
		lbNomePai.setFont(font_PLA_14);
		lbEnd.setFont(font_PLA_14);
		lbCidade.setFont(font_PLA_14);
		lbEstado.setFont(font_PLA_14);
		lbFone.setFont(font_PLA_14);
		lbDataMatricula.setFont(font_PLA_14);
		lbDadosAluno.setFont(font_NEG_15);
		
		// JTextField
		tfNome.setFont(font_NEG_15);
		tfLocalizar.setFont(font_NEG_15);
		
		// Button
		btnSalvar.setFont(font_PLA_14);
		btnPesquisar.setFont(font_PLA_14);
		btnLimpar.setFont(font_PLA_14);
		btnAlterar.setFont(font_PLA_14);
		btnExcluir.setFont(font_PLA_14);
		
		// Cor
		lbCodigo.setForeground(Color.RED);
		
		// Outros
		btnPesquisar.setPreferredSize(new Dimension(140,26));
		btnPesquisar.setRolloverEnabled(false);
		ftFone.setBorder(null);
		ftCpf.setBorder(null);
		ftDataNasc.setBorder(null);
		ftDataMatricula.setBorder(null);
	}

}
