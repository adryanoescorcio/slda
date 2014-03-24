package Forms.Crud.Aluno;

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

	private static final String BORDER_INFO_ALUNO = "DOSSIÊ DO DISCENTE";
	private static final int QUANT_LINHAS_GRID = 10;
	
	private TelaPadrao padrao = new TelaPadrao();

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
	private JLabel lbNome = new JLabel("Nome:* ",SwingConstants.RIGHT);
	private JLabel lbCodigo2 = new JLabel("Discente: ",SwingConstants.RIGHT);
	private JLabel lbCodigo = new JLabel("Código:* ",SwingConstants.RIGHT);
	private JLabel lbCPF = new JLabel("CPF: ",SwingConstants.RIGHT);
	private JLabel lbCor = new JLabel("Cor: ",SwingConstants.RIGHT);
	private JLabel lbNis = new JLabel("NIS: ",SwingConstants.RIGHT);
	private JLabel lbDataNasc = new JLabel("Data Nasc.:* ",SwingConstants.RIGHT);
	private JLabel lbSexo = new JLabel("Sexo: ",SwingConstants.RIGHT);
	private JLabel lbNomeMae = new JLabel("Mãe: ",SwingConstants.RIGHT);
	private JLabel lbEstadoMae = new JLabel("Estado Nasc. Mae: ",SwingConstants.RIGHT);
	private JLabel lbNomePai = new JLabel("Pai: ",SwingConstants.RIGHT);
	private JLabel lbEnd = new JLabel("Endereço: ",SwingConstants.RIGHT);
	private JLabel lbCidade = new JLabel("Cidade Nasc.: ",SwingConstants.RIGHT);
	private JLabel lbEstado = new JLabel("Estado Nasc.: ",SwingConstants.RIGHT);
	private JLabel lbFone = new JLabel("Telefone: ",SwingConstants.RIGHT);
	private JLabel lbDataMatricula = new JLabel("Data Matrícula: ",SwingConstants.RIGHT);
	private JLabel lbTransferencia = new JLabel("Admitido por Transferência? ",SwingConstants.RIGHT); // Tem que ativar um campo de data
	private JLabel lbSituacao = new JLabel("Situação Atual: ",SwingConstants.RIGHT);
	
	private JTextField tfNome = new JTextField();
	private JTextField tfCodigo = new JTextField();
	private JTextField tfCidade = new JTextField();
	private JTextField tfEnd = new JTextField();
	private JTextField tfNomeMae = new JTextField();
	
	private JFormattedTextField ftCpf = new JFormattedTextField(padrao.getMascaraCPF());
	private JFormattedTextField ftDataNasc = new JFormattedTextField(padrao.getMascaraData());
	private JFormattedTextField ftDataMatricula = new JFormattedTextField(padrao.getMascaraData());
	private JFormattedTextField ftFone = new JFormattedTextField(padrao.getMascaraTelefone());

	private JButton btnSalvar = new JButton("Salvar");
	private JButton btnLimpar = new JButton("Limpar");
	private JButton btnExcluir = new JButton("Excluir");
	private JButton btnAlterar = new JButton("Alterar");
	private JButton btnDocumento = new JButton("Documento");
	private JButton btnAta = new JButton("Ata");

	private ArrayList<Aluno> lista = new ArrayList<Aluno>();
	private AlunoTableModel modelo = new AlunoTableModel(lista);
	
	public CadastrarAluno() {
		
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
		painelDireito.add(padrao.painelContentFieldTamanhoLargura(tfCodigo ,400)); //Codigo
		painelDireito.add(padrao.painelContentComponent("West", painelCPFEstado())); // CPF - Estado
		painelDireito.add(padrao.painelContentFieldTamanhoLargura(tfNomeMae, 200));
		painelDireito.add(padrao.painelContentComponent("West", painelDataSexoCor())); // Data Nac. - Sexo - Cor
		painelDireito.add(padrao.painelContentFieldTamanhoLargura(tfCidade, 400)); // Cidade
		painelDireito.add(painelTelefoneEnd()); // Telefone - Endereço
		painelDireito.add(painelDataMatriculaTransf()); // Data Matri - Transfe
		
		painelDireito.add(padrao.painelContentComponent("West",
				comboGroup.getComboBoxSituacaoAluno())); //Situação
		
		painelContentEIA.add("North", lbDadosAluno);
		painelContentEIA.add("West", painelEsquerdoInfoAluno);
		painelContentEIA.add("Center", painelDireito);
		painelContentEIA.add("East",padrao.painelNull(200, 0));
		
		alterarFontes();
		painelInternoNorte();
		getTelaPrincipal();
		
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
		painelTrasferencia.add("Center", padrao.painelContentComponent("West", comboGroup.getComboBoxTransferencia()));
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
		painelEndTelefone.add("Center", tfEnd);
		painelEndTelefone.add("East", painelSeparador2);
		
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
		painelEstado.add("Center", padrao.painelContentComponent("West", comboGroup.getComboBoxEstadosBR()));
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
		painelCor.add("West", lbCor);
		painelCor.add("Center", padrao.painelContentComponent("West", comboGroup.getComboBoxCorRaca()));
		// SEPARADOR
		painelSeparador.add("West", padrao.painelNull(50, 0));
		painelSeparador.add("Center", painelCor);
		// SEXO
		painelSexo.add("West", lbSexo);
		painelSexo.add("Center", padrao.painelContentComponent("West", comboGroup.getComboBoxSexo()));
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
		painelInternoSul.add("West",padrao.painelNull(100, 0));
		painelInternoSul.add("South",painelTable());
		
		return painelInternoSul;
	}
	
	private JPanel painelTable() {
		
		// carregando modelo da tabela.
		JTable tabela = padrao.getTabela();
		tabela.setModel(modelo);
		
		Aluno aluno1 = new Aluno();
		aluno1.setCodigo("20120");
		aluno1.setCPF_Aluno(padrao.numAleatorio());
		aluno1.setNomeAluno("Alan Kardec Souza");
		aluno1.setINEP(padrao.numAleatorio());
		aluno1.setRG_Aluno(padrao.numAleatorio());
		aluno1.setSexoAluno("Masculino");
		aluno1.setCorAluno("Branca");
		aluno1.setDataNascimento("07/02/1994");
		aluno1.setCidadeNascAluno("Paratins");
		aluno1.setEstadoNascAluno("Mato Grosso");
		aluno1.setNomePai("Leal");
		aluno1.setCidadePaiNasc("Itapirapoca");
		aluno1.setEstadoPaiNasc("São Paulo");
		aluno1.setNomeMae("Jessica");
		aluno1.setCidadeMaeNasc("Sao José dos Patos");
		aluno1.setEstadoMaeNasc("Rio Branco");
		aluno1.setEnderecoAluno("Rua 25 Quadra 24");
		aluno1.setTelefoneAluno(padrao.numAleatorio());
		
		modelo.addContato(aluno1);
		
		scroll.setPreferredSize(new Dimension(0, 200)); // Define o tamanho da tabela.
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS); // Adiciona o scroll vertical
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS); // adiciona o scroll horizontal
		
		// Definindo o scorll sem resize (torna o scroll horizontal automatico)
		tabela.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		
		// Setando o tamanho padrão da largura das colunas.
		tabela.getColumnModel().getColumn(0).setPreferredWidth(100);
		tabela.getColumnModel().getColumn(1).setPreferredWidth(100);
		tabela.getColumnModel().getColumn(2).setPreferredWidth(100);
		tabela.getColumnModel().getColumn(3).setPreferredWidth(100);
		tabela.getColumnModel().getColumn(4).setPreferredWidth(120);
		tabela.getColumnModel().getColumn(5).setPreferredWidth(100);
		tabela.getColumnModel().getColumn(6).setPreferredWidth(100);
		tabela.getColumnModel().getColumn(7).setPreferredWidth(100);
		tabela.getColumnModel().getColumn(8).setPreferredWidth(130);
		tabela.getColumnModel().getColumn(9).setPreferredWidth(120);
		tabela.getColumnModel().getColumn(10).setPreferredWidth(120);
		tabela.getColumnModel().getColumn(11).setPreferredWidth(100);
		
		scroll.setViewportView(tabela); // insere a tabela no painel Scroll
		scroll.setWheelScrollingEnabled(true);
		
		painelTabela.add("North", padrao.painelNull(0, 10));
		painelTabela.add("Center",scroll);
		painelTabela.add("South",padrao.painelLocaliza(lbCodigo2)); // cria o painel de localizar
		
		return painelTabela;
	}

	private JPanel painelBotoes() {
		JPanel painelBotoes = new JPanel(new BorderLayout(2,2));
		JPanel painelContentBotoes = new JPanel(new GridLayout(1,7,5,5));
		
		painelContentBotoes.add(btnSalvar);
		painelContentBotoes.add(btnAlterar);
		painelContentBotoes.add(btnExcluir);
		painelContentBotoes.add(btnLimpar);
		painelContentBotoes.add(padrao.painelNull(5, 0));
		painelContentBotoes.add(btnDocumento);
		painelContentBotoes.add(btnAta);
		
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
		tfCidade.setFont(padrao.font_NEG_15);
		tfEnd.setFont(padrao.font_NEG_15);
		tfCodigo.setFont(padrao.font_NEG_15);
		
		tfNome.setPreferredSize(new Dimension(450,0));
		
		// Button
		btnSalvar.setFont(padrao.font_PLA_14);
		
		btnLimpar.setFont(padrao.font_PLA_14);
		btnAlterar.setFont(padrao.font_PLA_14);
		btnExcluir.setFont(padrao.font_PLA_14);
		btnDocumento.setFont(padrao.font_PLA_14);
		btnAta.setFont(padrao.font_PLA_14);
		
		// Cor
		lbCodigo.setForeground(Color.RED);
		
		// Outros
		ftFone.setBorder(null);
		ftCpf.setBorder(null);
		ftDataNasc.setBorder(null);
		ftDataMatricula.setBorder(null);
	}
	
}
