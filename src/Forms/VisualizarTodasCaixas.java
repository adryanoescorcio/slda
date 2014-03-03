package Forms;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableColumnModel;

import DAO.CaixaDAO;
import DAO.JPAUtil;

@SuppressWarnings("serial")
public class VisualizarTodasCaixas extends JFrame{

	JTable tabela;
	public VisualizarTodasCaixas() {
				
		super("Todas Caixas Cadastradas");
		String[] colunas = {"Código da Caixa", "Turno", "Status"};

		JPAUtil conexaoBD = new JPAUtil();
		CaixaDAO dao = new CaixaDAO(conexaoBD);
		
		String[][] caixas = dao.visualizarTodasCaixas();
		tabela = new JTable(caixas, colunas);
		
		definirTamanhoDasColunas();
		
		tabela.setPreferredScrollableViewportSize(new Dimension(500, 500));
		tabela.setFillsViewportHeight(true);
		tabela.setBackground(Color.WHITE);
		JScrollPane scroll = new JScrollPane(tabela);
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		c.add(BorderLayout.CENTER, scroll);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setSize(380, 500);

	}
	
	public static void main(String[] args) {
		new VisualizarTodasCaixas();
	}
	
	public void definirTamanhoDasColunas(){
		
		TableColumnModel modeloDaColuna = tabela.getColumnModel();
		modeloDaColuna.getColumn(0).setPreferredWidth(120);//CÓDIGO DA CAIXA
		modeloDaColuna.getColumn(1).setPreferredWidth(120);//TURNO
		modeloDaColuna.getColumn(2).setPreferredWidth(120);//STATUS
		
	}


}
