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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import Eventos.EventosAluno;
import Forms.TelaPadrao;
import Forms.TablesModel.AlunoTableModel;
import Model.Aluno;

/**
 * Classe que representa a tela Aluno - Cadastrar
 * 
 * @author Walysson Oliveira
 * @version 1.5
 * @extends JFrame
 **/

@SuppressWarnings("serial")
public class CadastrarAluno extends EventosAluno {

	private static final int DIST = 5;

	private static final String BORDER_INFO_ALUNO = "DOSSIÊ DO ALUNO";
	private static final int QUANT_LINHAS_GRID = 9;
	
	TelaPadrao padrao = new TelaPadrao();

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
	
	private JLabel lbDadosAluno = new JLabel("DADOS DO DISCENTE",SwingConstants.CENTER);
	private JLabel lbNome = new JLabel("Nome: ",SwingConstants.RIGHT);
	private JLabel lbCodigo2 = new JLabel("Codigo Aluno: ",SwingConstants.RIGHT);
	private JLabel lbCodigo = new JLabel("Codigo: ",SwingConstants.RIGHT);
	private JLabel lbCPF = new JLabel("CPF: ",SwingConstants.RIGHT);
	private JLabel lbCor = new JLabel("Cor: ",SwingConstants.RIGHT);
	private JLabel lbNis = new JLabel("NIS: ",SwingConstants.RIGHT);
	private JLabel lbDataNasc = new JLabel("Data Nasc.: ",SwingConstants.RIGHT);
	private JLabel lbSexo = new JLabel("Sexo: ",SwingConstants.RIGHT);
	private JLabel lbNomeMae = new JLabel("Mãe: ",SwingConstants.RIGHT);
	private JLabel lbEstadoMae = new JLabel("Estado Nasc. Mae: ",SwingConstants.RIGHT);
	private JLabel lbNomePai = new JLabel("Pai: ",SwingConstants.RIGHT);
	private JLabel lbEnd = new JLabel("Endereço: ",SwingConstants.RIGHT);
	private JLabel lbCidade = new JLabel("Cidade Nasc.: ",SwingConstants.RIGHT);
	private JLabel lbEstado = new JLabel("Estado Nasc.: ",SwingConstants.RIGHT);
	private JLabel lbFone = new JLabel("Telefone: ",SwingConstants.RIGHT);
	private JLabel lbDataMatricula = new JLabel("Data Matricula: ",SwingConstants.RIGHT);
	private JLabel lbTransferencia = new JLabel("Admitido por Transferencia? ",SwingConstants.RIGHT); // Tem que ativar um campo de data
	private JLabel lbSituacao = new JLabel("Situação Atual: ",SwingConstants.RIGHT);
	
	private JTextField tfNome = new JTextField();
	private JTextField tfLocalizar = new JTextField();
	private JTextField tfCodigo = new JTextField();
	private JTextField tfCidade = new JTextField();
	private JTextField tfEnd = new JTextField();
	
	private JFormattedTextField ftCpf = new JFormattedTextField(padrao.getMascaraCPF());
	private JFormattedTextField ftDataNasc = new JFormattedTextField(padrao.getMascaraData());
	private JFormattedTextField ftDataMatricula = new JFormattedTextField(padrao.getMascaraData());
	private JFormattedTextField ftFone = new JFormattedTextField(padrao.getMascaraTelefone());
	
	private ImageIcon icone = new ImageIcon("src/Icones/search.png");

	private JButton btnSalvar = new JButton("Salvar");
	private JButton btnLimpar = new JButton("Limpar");
	private JButton btnExcluir = new JButton("Excluir");
	private JButton btnAlterar = new JButton("Alterar");
	private JButton btnPesquisar = new JButton("Pesquisar", icone);

	private ArrayList<Aluno> lista = new ArrayList<Aluno>();
	private AlunoTableModel modelo = new AlunoTableModel(lista);
	private JTable tabela = new JTable(modelo);
	
	public CadastrarAluno() {
		
		painelEsquerdoInfoAluno.add(padrao.painelNull(0, 0));
		painelEsquerdoInfoAluno.add(lbNome);
		painelEsquerdoInfoAluno.add(lbCodigo);
		painelEsquerdoInfoAluno.add(lbCPF);
		painelEsquerdoInfoAluno.add(lbDataNasc);
		painelEsquerdoInfoAluno.add(lbCidade);
		painelEsquerdoInfoAluno.add(lbEnd);
		painelEsquerdoInfoAluno.add(lbDataMatricula);
		painelEsquerdoInfoAluno.add(lbSituacao);
		
		painelDireito.add(padrao.painelNull(0, 0));
		painelDireito.add(tfNome);		painelDireito.add(tfCodigo);
		painelDireito.add(padrao.painelContentComponent("West", painelCPFEstado()));
		painelDireito.add(padrao.painelContentComponent("West", painelDataSexoCor()));
		painelDireito.add(tfCidade);
		painelDireito.add(painelTelefoneEnd());
		painelDireito.add(painelDataMatriculaTransf());
		painelDireito.add(padrao.painelContentComponent("West", padrao.getComboBoxSituacaoAluno()));
		
		painelContentEIA.add("North", lbDadosAluno);
		painelContentEIA.add("West", painelEsquerdoInfoAluno);
		painelContentEIA.add("Center", painelDireito);
		painelContentEIA.add("East",padrao.painelNull(200, 0));
		
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
		painelTrasferencia.add("Center", padrao.painelContentComponent("West", padrao.getComboBoxTransferencia()));
		// SEPARADOR
		painelSeparador2.add("West", padrao.painelNull(50, 0));
		painelSeparador2.add("Center", painelTrasferencia);
		// Endereço
		painelDataMatriculaTransf.add("West", padrao.painelContentComponent("West", ftDataMatricula));
		painelDataMatriculaTransf.add("Center", painelSeparador2);
		
		return painelDataMatriculaTransf;
	}

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
		painelEstado.add("Center", padrao.painelContentComponent("West", padrao.getComboBoxEstadosBR()));
		// SEPARADOR
		painelSeparador2.add("West", padrao.painelNull(50, 0));
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
		painelCor.add("Center", padrao.painelContentComponent("West", padrao.getComboBoxCorRaca()));
		// SEPARADOR
		painelSeparador.add("West", padrao.painelNull(50, 0));
		painelSeparador.add("Center", painelCor);
		// SEXO
		painelSexo.add("West", lbSexo);
		painelSexo.add("Center", padrao.painelContentComponent("West", padrao.getComboBoxSexo()));
		// SEPARADOR
		painelSeparador2.add("West", padrao.painelNull(50, 0));
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
		mainJPanel.add("West", padrao.painelNull(20, 0));
		mainJPanel.add("East", padrao.painelNull(20, 0));
		mainJPanel.add("North", padrao.painelNull(0, 15));
		
		return painelScrollMain;
	}

	private JPanel painelInternoSul() {
		painelInternoSul.add("Center", padrao.painelContentComponent("West", painelBotoes()));
		painelInternoSul.add("North", padrao.painelNull(0, 5));
		painelInternoSul.add("West", padrao.painelNull(220, 0));
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
		lbDadosAluno.setFont(padrao.font_NEG_15);
		
		// JTextField
		tfNome.setFont(padrao.font_NEG_15);
		tfLocalizar.setFont(padrao.font_NEG_15);
		
		// Button
		btnSalvar.setFont(padrao.font_PLA_14);
		btnPesquisar.setFont(padrao.font_PLA_14);
		btnLimpar.setFont(padrao.font_PLA_14);
		btnAlterar.setFont(padrao.font_PLA_14);
		btnExcluir.setFont(padrao.font_PLA_14);
		
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
