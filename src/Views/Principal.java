package Views;

import java.awt.Color;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
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
	
	JTabbedPane camadaExterna;
	
	JTabbedPane camadaAluno;
	JTabbedPane camadaArquivo;
	JTabbedPane camadaAta;
	
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
		
		//---------> CRIANDO O USUARIO EXPORTAR E SEUS ITENS <-----------
		JMenu menuUsuario = new JMenu("Usuário");	
		//ADICIONA UM MNEMÔNICO OU ATALHO(ALT + U) 
		menuUsuario.setMnemonic('U');
		JMenuItem itemFazerLogin = new JMenuItem("Fazer Login"); 
		menuUsuario.add(itemFazerLogin); 
		JMenuItem itemFazerLogoff = new JMenuItem("Fazer Logoff"); 
		menuUsuario.add(itemFazerLogoff); 
		
		//---------> CRIANDO O MENU EXPORTAR E SEU ITEM <-----------
		JMenu menuExportar = new JMenu("Exportar");	
		//ADICIONA UM MNEMÔNICO OU ATALHO(ALT + E) 
		menuExportar.setMnemonic('E');
		JMenuItem itemBackup = new JMenuItem("Realizar Backup"); 
		menuExportar.add(itemBackup); 
		
		//---------> CRIANDO O MENU IMPORTAR E SEU ITEM <-----------
		JMenu menuImportar = new JMenu("Importar");	
		//ADICIONA UM MNEMÔNICO OU ATALHO(ALT + I) 
		menuImportar.setMnemonic('I');
		JMenuItem itemOutroBD = new JMenuItem("Usar outro Banco de Dados"); 
		menuImportar.add(itemOutroBD);
		
		//---------> CRIANDO O MENU VISUALIZAR E SEUS ITENS <-----------
		JMenu menuVisualizar = new JMenu("Visualizar");
		//ADICIONA UM MNEMÔNICO OU ATALHO(ALT + V)
		menuVisualizar.setMnemonic('V');
		JMenuItem itemVisAlunos = new JMenuItem("Todos os Alunos"); 
		menuVisualizar.add(itemVisAlunos); 
		JMenuItem itemVisCaixas = new JMenuItem("Todas as Caixas"); 
		menuVisualizar.add(itemVisCaixas);
		JMenuItem itemVisAtas = new JMenuItem("Todas as Atas"); 
		menuVisualizar.add(itemVisAtas);
		
		//---------> CRIANDO O MENU AVANÇADO E SEUS ITENS <-----------
		JMenu menuAvancado = new JMenu("Opções Avançadas");	
		//ADICIONA UM MNEMÔNICO OU ATALHO(ALT + A) 
		menuAvancado.setMnemonic('A');
		JMenuItem itemControle = new JMenuItem("Controle de Usuários"); 
		menuAvancado.add(itemControle);
		
		//---------> CRIANDO A BARRA DE MENUS E ADICIONANDO MENUS A ELA<-----------
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		menuBar.add(menuUsuario);
		menuBar.add(menuExportar);
		menuBar.add(menuImportar);
		menuBar.add(menuVisualizar);
		menuBar.add(menuAvancado);
		
		//---------> CRIANDO OS ÍCONES<-----------
		Icon iconLocalizar = new ImageIcon(getClass().getResource("img/localizar.jpg"));
		Icon iconAluno = new ImageIcon(getClass().getResource("img/aluno.jpg"));
		Icon iconCaixa = new ImageIcon(getClass().getResource("img/caixa.jpg"));
		Icon iconAta = new ImageIcon(getClass().getResource("img/ata.jpg"));
		Icon iconArquivo = new ImageIcon(getClass().getResource("img/arquivo.jpg"));
		Icon iconCadastrar = new ImageIcon(getClass().getResource("img/cadastrar.jpg"));
		Icon iconExcluir = new ImageIcon(getClass().getResource("img/excluir.jpg"));
		Icon iconMovimentacao = new ImageIcon(getClass().getResource("img/documento.jpg"));
		Icon iconAlterar = new ImageIcon(getClass().getResource("img/alterar.jpg"));
	
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
		
	public static void main(String[] args) {
		Principal tela = new Principal();
		
		//COMANDO QUE ABRE A TELA MAXIMIZADA, POIS É A MANEIRA DE MELHOR VISUALIZAÇÃO DO SISTEMA
		tela.setExtendedState(JFrame.MAXIMIZED_BOTH);
	}

}