package Forms;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Label;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Classe que representa a tela Arquivo - Pedido
 * 
 * @author Walysson Oliveira
 * @version 1.5
 * @extends JPanel
 **/

@SuppressWarnings("serial")
public class PedidoArquivo extends JPanel{

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
	JTextField tf7;
	JTextField tf8;
		
	JComboBox<String> combo;

	public PedidoArquivo() {

		setLayout(new GridLayout(20, 4, 5, 5));
		
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
		tf7 = new JTextField();
		tf8 = new JTextField();
		
		combo = new JComboBox<String>();
		
		//CONFIGURAÇÕES DE VARIÁVEIS
		//------>ESSA CAIXA DE SELEÇÃO TAMBÉM PODE SER SUBSTITUIDA POR UMA JTABLE
		//------>ELA MOSTRA OS DOCUMENTOS QUE FORAM PEDIDOS, MAS AINDA NÃO FORAM ENTREGUES
				
		/*------>COLOQUEI ALGUNS ITENS SÓ PRA VER SE O TAMANHO ESTÁ BOM, MAS ELA TEM QUE SER INICIALIZADA VAZIA
		 * E PREENCHIDA PELOS DOCUMENTOS COM SITUAÇÃO AINDA ATIVO OU NÃO FINALIZADO
		 */
		combo.setBackground(Color.WHITE);
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
		
		//PAINEIS DE DIVISÃO DE CÉLULA
		JPanel linha = new JPanel();
		linha.setLayout(new GridLayout(1, 2, 5, 5));
		linha.setBackground(Color.WHITE);
		
		JPanel linha1 = new JPanel();
		linha1.setLayout(new GridLayout(1, 2, 5, 5));
		linha1.setBackground(Color.WHITE);
		
		JPanel linha2 = new JPanel();
		linha2.setLayout(new GridLayout(1, 2, 5, 5));
		linha2.setBackground(Color.WHITE);
		
		JPanel linha3 = new JPanel();
		linha3.setLayout(new GridLayout(1, 2, 5, 5));
		linha3.setBackground(Color.WHITE);
		
		JPanel linha4 = new JPanel();
		linha4.setLayout(new GridLayout(1, 2, 5, 5));
		linha4.setBackground(Color.WHITE);
		
		JPanel linha5 = new JPanel();
		linha5.setLayout(new GridLayout(1, 2, 5, 5));
		linha5.setBackground(Color.WHITE);
		
		JPanel linha6 = new JPanel();
		linha6.setLayout(new GridLayout(1, 2, 5, 5));
		linha6.setBackground(Color.WHITE);
		
		JPanel linha7 = new JPanel();
		linha7.setLayout(new GridLayout(1, 2, 5, 5));
		linha7.setBackground(Color.WHITE);
		
		JPanel linha8 = new JPanel();
		linha8.setLayout(new GridLayout(1, 2, 5, 5));
		linha8.setBackground(Color.WHITE);
		
		JPanel linha9 = new JPanel();
		linha9.setLayout(new GridLayout(1, 2, 5, 5));
		linha9.setBackground(Color.WHITE);
		
		JPanel linha10 = new JPanel();
		linha10.setLayout(new GridLayout(1, 2, 5, 5));
		linha10.setBackground(Color.WHITE);
		
		Label nome1 = new Label("Registrar Pedido de Documento");
		nome1.setFont(new Font("san_serif", Font.BOLD, 19));
		nome1.setForeground(Color.GRAY);

		Label nome2 = new Label("Registrar Entrega");
		nome2.setFont(new Font("san_serif", Font.BOLD, 19));
		nome2.setForeground(Color.GRAY);
		
		Label nome3 = new Label("Verificar Pendentes");
		nome3.setFont(new Font("san_serif", Font.BOLD, 19));
		nome3.setForeground(Color.GRAY);
		
		//ADICIONANDO COMPONENTES AOS PAINEIS DE DIVISÃO DE CÉLULA
		linha1.add(new JLabel("Documento:"));					linha1.add(tf2);						
		linha2.add(new JLabel("Matrícula do Aluno:"));			linha2.add(tf3);						
		linha3.add(new JLabel("Nome do Aluno:"));				linha3.add(tf4);						
		linha4.add(botaoRegPedido);								linha4.add(new Label(""));
	
		linha5.add(new JLabel("Número do Protocolo:"));			linha5.add(tf5);						
		linha6.add(botaoRegEntrega);							linha6.add(new Label(""));
		
		linha7.add(botaoVerificar);								linha7.add(new Label(""));

		//ADICIONANDO COMPONENTES À TELA
		add(new Label(""));					add(new Label(""));									add(new Label(""));			add(new Label(""));
		add(new Label(""));					add(new Label(""));									add(new Label(""));			add(new Label(""));
		add(new Label(""));					add(nome1);											add(new Label(""));			add(new Label(""));			
		add(new Label(""));					add(new Label(""));									add(new Label(""));			add(new Label(""));
		add(new Label(""));					add(linha1);										add(new Label(""));			add(new Label(""));
		add(new Label(""));					add(linha2);										add(new Label(""));			add(new Label(""));
		add(new Label(""));					add(linha3);										add(linha4);				add(new Label(""));
		add(new Label(""));					add(new Label(""));									add(new Label(""));			add(new Label(""));
		add(new Label(""));					add(nome2);											add(new Label(""));			add(new Label(""));
		add(new Label(""));					add(new Label(""));									add(new Label(""));			add(new Label(""));
		add(new Label(""));					add(linha5);										add(linha6);				add(new Label(""));
		add(new Label(""));					add(new Label(""));									add(new Label(""));			add(new Label(""));
		add(new Label(""));					add(nome3);											add(new Label(""));			add(new Label(""));
		add(new Label(""));					add(new Label(""));									add(new Label(""));			add(new Label(""));
		add(new Label(""));					add(combo);											add(linha7);				add(new Label(""));
		add(new Label(""));					add(new Label(""));									add(new Label(""));			add(new Label(""));
		add(new Label(""));					add(new Label(""));									add(new Label(""));			add(new Label(""));
		add(new Label(""));					add(new Label(""));									add(new Label(""));			add(new Label(""));
		add(new Label(""));					add(new Label(""));									add(new Label(""));			add(new Label(""));
	
		setBackground(Color.WHITE);

	}

}
