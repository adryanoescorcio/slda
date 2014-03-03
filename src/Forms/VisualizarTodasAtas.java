package Forms;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableColumnModel;

import DAO.AtaDAO;
import DAO.JPAUtil;

@SuppressWarnings("serial")
public class VisualizarTodasAtas extends JFrame{

	JTable tabela;
	public VisualizarTodasAtas() {
		
		super("Todas Ata Cadastradas");
		String[] colunas = {"Turma", "Ano", "Turno", "Modalidade de Ensino", "Grau de Ensino"};
		
		JPAUtil conexaoBD = new JPAUtil();
		AtaDAO dao = new AtaDAO(conexaoBD);
		
		String[][] atas = dao.visualizarTodasAtas();
		tabela = new JTable(atas, colunas);
		
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
		setSize(550, 500);


	}
	
	public static void main(String[] args) {
		new VisualizarTodasAtas();
	}
	
	public void definirTamanhoDasColunas(){
		
		TableColumnModel modeloDaColuna = tabela.getColumnModel();
		modeloDaColuna.getColumn(0).setPreferredWidth(60);//TURMA
		modeloDaColuna.getColumn(1).setPreferredWidth(60);//ANO
		modeloDaColuna.getColumn(2).setPreferredWidth(60);//TURNO
		modeloDaColuna.getColumn(3).setPreferredWidth(110);//MODALIDADE
		modeloDaColuna.getColumn(4).setPreferredWidth(110);//GRAU DE ENSINO
		
	}

}
