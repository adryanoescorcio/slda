package Forms;

import java.awt.Color;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

/**
 * Classe que representa a tela Principal - Aquela que chama todas as outras
 * 
 * @author Walysson Oliveira
 * @version 1.5
 * @extends JFrame
 **/

@SuppressWarnings("serial")
public class Principal extends JFrame{
	
	private static final String DIR_MAIN_ICONES = "../Icones/";
	
	JTabbedPane camadaExterna;
	JTabbedPane camadaAluno;
	JTabbedPane camadaArquivo;
	JTabbedPane camadaAta;
	
	Icon iconLocalizar;
	Icon iconAluno;
	Icon iconCaixa;
	Icon iconAta;
	Icon iconArquivo;
	Icon iconCadastrar;
	Icon iconExcluir;
	Icon iconMovimentacao;
	Icon iconAlterar;
	
	MenuUsuario menuUsuario = new MenuUsuario();
	MenuExportar menuExportar = new MenuExportar();
	MenuImportar menuImportar = new MenuImportar();
	MenuVisualizar menuVisualizar = new MenuVisualizar();
	MenuAvancado menuAvancado = new MenuAvancado();
	
	public Principal(){
		super("SLDA - Sistema de Localização de Documentos do Aluno");
		
		//------->AQUI É CRIADO UM PAINEL EM CAMADAS(JTabbedPane) EM QUE CADA CAMADA TEM OUTRO PAINEL EM CAMADAS(JTabbedPane)
		camadaExterna = new JTabbedPane();
	
		//ATRIBUTO QUE DEIXA AS ABAS DO JTabbedPane DO LADO DIREITO DA TELA
		int lado = JTabbedPane.RIGHT;
		
		camadaAluno = new JTabbedPane(lado);
		camadaArquivo = new JTabbedPane(lado);
		camadaAta = new JTabbedPane(lado);
		
		//SETANDO AS CAMADAS COM O FUNDO BRANCO
		camadaExterna.setBackground(Color.WHITE);
		camadaAluno.setBackground(Color.WHITE);
		camadaArquivo.setBackground(Color.WHITE);
		camadaAta.setBackground(Color.WHITE);
		
		//---------> CRIANDO A BARRA DE MENUS E ADICIONANDO MENUS A ELA<-----------
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		menuBar.add(menuUsuario.getMenuUsuario());
		menuBar.add(menuExportar.getMenuExportar());
		menuBar.add(menuImportar.getMenuImportar());
		menuBar.add(menuVisualizar.getMenuVisualizar());
		menuBar.add(menuAvancado.getMenuAvancado());
				
		//INSTANCIANDO OS PAINEIS
		JPanel localizarAluno = new LocalizarArquivo();
		JPanel cadastrarAluno = new CadastrarAluno();
		JPanel excluirAluno = new ExcluirAluno();
		JPanel alterarAluno = new AlterarAluno();
		JPanel cadastrarAta = new CadastrarAta();
		JPanel alterarAta = new AlterarAta();
		JPanel excluirAta = new ExcluirAta();
		JPanel caixaArquivo = new CaixaArquivo();
		JPanel pedidoArquivo = new PedidoArquivo();
		
		criandoIcones();
		
		//DEFININDO OS PAINEIS DA CAMADA ARQUIVO
		camadaArquivo.addTab("Localizar", iconLocalizar, localizarAluno);
		camadaArquivo.addTab("Caixa", iconCaixa, caixaArquivo);
		camadaArquivo.addTab("Pedido", iconMovimentacao, pedidoArquivo);
		
		//DEFININDO OS PAINEIS DA CAMADA ALUNO
		camadaAluno.addTab("Cadastrar", iconCadastrar, cadastrarAluno);
		camadaAluno.addTab("Alterar", iconAlterar, alterarAluno);
		camadaAluno.addTab("Excluir", iconExcluir, excluirAluno);
		
		//DEFININDO OS PAINEIS DA CAMADA ATA
		camadaAta.addTab("Cadastrar", iconCadastrar, cadastrarAta);
		camadaAta.addTab("Alterar", iconAlterar, alterarAta);
		camadaAta.addTab("Excluir", iconExcluir, excluirAta);
		
		//DEFININDO OS PAINEIS DA CAMADA EXTERNA 
		camadaExterna.addTab("Arquivo", iconArquivo, camadaArquivo);
		camadaExterna.addTab("Aluno", iconAluno, camadaAluno);
		camadaExterna.addTab("  Ata", iconAta, camadaAta);
		
		//ADICIONANDO A CAMADA EXTERNA À JANELA(JFrame)
		add(camadaExterna);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setSize(1050, 700);
	}
		
	private void criandoIcones() {
		
		//---------> CRIANDO OS ÍCONES<-----------
		 iconLocalizar = new ImageIcon(getClass().getResource(DIR_MAIN_ICONES+"localizar.jpg"));
		 iconAluno = new ImageIcon(getClass().getResource(DIR_MAIN_ICONES+"aluno.jpg"));
		 iconCaixa = new ImageIcon(getClass().getResource(DIR_MAIN_ICONES+"caixa.jpg"));
		 iconAta = new ImageIcon(getClass().getResource(DIR_MAIN_ICONES+"ata.jpg"));
		 iconArquivo = new ImageIcon(getClass().getResource(DIR_MAIN_ICONES+"arquivo.jpg"));
		 iconCadastrar = new ImageIcon(getClass().getResource(DIR_MAIN_ICONES+"cadastrar.jpg"));
		 iconExcluir = new ImageIcon(getClass().getResource(DIR_MAIN_ICONES+"excluir.jpg"));
		 iconMovimentacao = new ImageIcon(getClass().getResource(DIR_MAIN_ICONES+"documento.jpg"));
		 iconAlterar = new ImageIcon(getClass().getResource(DIR_MAIN_ICONES+"alterar.jpg"));
	}

	public static void main(String[] args) {
		Principal tela = new Principal();
		
		//COMANDO QUE ABRE A TELA MAXIMIZADA, POIS É A MANEIRA DE MELHOR VISUALIZAÇÃO DO SISTEMA
		tela.setExtendedState(JFrame.MAXIMIZED_BOTH);
	}

}