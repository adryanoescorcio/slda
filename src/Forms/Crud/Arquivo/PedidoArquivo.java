package Forms.Crud.Arquivo;

import java.awt.Label;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Forms.TelaPadrao;

/**
 * Classe que representa a tela Arquivo - Pedido
 * 
 * @author Walysson Oliveira
 * @version 1.5
 * @extends TelaPadrao
 **/

@SuppressWarnings("serial")
public class PedidoArquivo extends TelaPadrao{

	//DECLARAÇÃO DE VARIÁVEIS
	JButton botaoRegPedido;
	JButton botaoRegEntrega;
	JButton botaoVerificar;
	
	JTextField tf1;
	JTextField tf2;
	JTextField tf3;
	JTextField tf4;
	JTextField tf5;
	JTextField tf6;
		
	JComboBox<String> combo;

	public PedidoArquivo() {

		setLayout(layout);
		
		//INICIALIZAÇÃO DE VARIÁVEIS
		botaoRegPedido = new JButton("Registrar");
		botaoRegEntrega = new JButton("Registrar");
		botaoVerificar = new JButton("Verificar");
		
		tf1 = new JTextField();
		tf2 = new JTextField();
		tf3 = new JTextField();
		tf4 = new JTextField();
		tf5 = new JTextField();
		tf6 = new JTextField();
		
		combo = new JComboBox<String>();
		
		//CONFIGURAÇÕES DE VARIÁVEIS
		//------>ESSA CAIXA DE SELEÇÃO TAMBÉM PODE SER SUBSTITUIDA POR UMA JTABLE
		//------>ELA MOSTRA OS DOCUMENTOS QUE FORAM PEDIDOS, MAS AINDA NÃO FORAM ENTREGUES
				
		/*------>COLOQUEI ALGUNS ITENS SÓ PRA VER SE O TAMANHO ESTÁ BOM, MAS ELA TEM QUE SER INICIALIZADA VAZIA
		 * E PREENCHIDA PELOS DOCUMENTOS COM SITUAÇÃO AINDA ATIVO OU NÃO FINALIZADO
		 */
		combo.setBackground(corDeFundo);
		combo.addItem("");
		combo.addItem("1");
		combo.addItem("2");
		combo.addItem("3");
		combo.addItem("Testes para ver se o tamanho está bom: Reprovado");
		combo.addItem("Protocolo: 12345678 - Walysson Carlos Dos Santos Oliveira");
		combo.addItem("5");
		combo.addItem("6");
		combo.addItem("7");
		combo.addItem("5");
		combo.addItem("5");
		combo.addItem("5");
		
		//CRIANDO E ADICIONANDO PAINEIS DE DIVISÃO DE CÉLULA
		JPanel linha1 = criarDividirEConfigurarCelula(new JLabel("Documento:"), tf1);
		JPanel linha2 = criarDividirEConfigurarCelula(new JLabel("Matrícula do Aluno:"), tf2);
		JPanel linha3 = criarDividirEConfigurarCelula(new JLabel("Nome do Aluno:"), tf3);
		JPanel linha4 = criarDividirEConfigurarCelula(botaoRegPedido, new Label(""));
		JPanel linha5 = criarDividirEConfigurarCelula(new JLabel("Número do Protocolo:"), tf5);
		JPanel linha6 = criarDividirEConfigurarCelula(botaoRegEntrega, new Label(""));
		JPanel linha7 = criarDividirEConfigurarCelula(botaoVerificar, new Label(""));
			

		Label titulo1 = getTitulo("Registrar Pedido de Documento");
		Label titulo2 = getTitulo("Registrar Entrega");
		Label titulo3 = getTitulo("Verificar Pendentes");
			
		//ADICIONANDO COMPONENTES À TELA
		add(new Label(""));					add(new Label(""));									add(new Label(""));			add(new Label(""));
		add(new Label(""));					add(new Label(""));									add(new Label(""));			add(new Label(""));
		add(new Label(""));					add(titulo1);										add(new Label(""));			add(new Label(""));			
		add(new Label(""));					add(new Label(""));									add(new Label(""));			add(new Label(""));
		add(new Label(""));					add(linha1);										add(new Label(""));			add(new Label(""));
		add(new Label(""));					add(linha2);										add(new Label(""));			add(new Label(""));
		add(new Label(""));					add(linha3);										add(linha4);				add(new Label(""));
		add(new Label(""));					add(new Label(""));									add(new Label(""));			add(new Label(""));
		add(new Label(""));					add(titulo2);										add(new Label(""));			add(new Label(""));
		add(new Label(""));					add(new Label(""));									add(new Label(""));			add(new Label(""));
		add(new Label(""));					add(linha5);										add(linha6);				add(new Label(""));
		add(new Label(""));					add(new Label(""));									add(new Label(""));			add(new Label(""));
		add(new Label(""));					add(titulo3);										add(new Label(""));			add(new Label(""));
		add(new Label(""));					add(new Label(""));									add(new Label(""));			add(new Label(""));
		add(new Label(""));					add(combo);											add(linha7);				add(new Label(""));
		add(new Label(""));					add(new Label(""));									add(new Label(""));			add(new Label(""));
		add(new Label(""));					add(new Label(""));									add(new Label(""));			add(new Label(""));
		add(new Label(""));					add(new Label(""));									add(new Label(""));			add(new Label(""));
		add(new Label(""));					add(new Label(""));									add(new Label(""));			add(new Label(""));
	
		setBackground(corDeFundo);

	}

}
