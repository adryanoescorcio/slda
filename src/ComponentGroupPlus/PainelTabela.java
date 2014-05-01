package ComponentGroupPlus;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

public class PainelTabela {
	// tamanho padrao para tabela
	private static final int TAM_WITH_TABLE_COLUMN = 1000;
	// quantidade de linhas da tabela
	protected static final int TAM_ROW_TABLE = 22;
	
	// scroll que envolve a tabela
	public JScrollPane scroll = new JScrollPane();
	public JTable tabela = new JTable(); // Table para todas as Jframes
	
	public PainelTabela() {
		loadConfigTable();
	}
	
	/**
	 * Reestrutura a disposição das colunas na tabela insere o scroll
	 * @param tabela 
	 * @return tabela reorganizada
	 **/
	public JScrollPane organizandoColunasTables(AbstractTableModel modelo) {
	// carregando modelo da tabela.
				
		tabela.setModel(modelo);
		tabela.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		
		int x = TAM_WITH_TABLE_COLUMN/tabela.getColumnCount();
		
		for(int i=0;i<tabela.getColumnCount();i++) {
			tabela.getColumnModel().getColumn(i).setPreferredWidth(x);
		}
		
		scroll.setPreferredSize(new Dimension(0, 200)); // Define o tamanho da tabela.
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS); // Adiciona o scroll vertical
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS); // adiciona o scroll horizontal
		
		scroll.setViewportView(tabela); // insere a tabela no painel Scroll
		scroll.setWheelScrollingEnabled(true);
	
		return scroll;
	}
	
	/**
	 * Carrega as configurações padrões de todas as tabelas.
	 **/
	private void loadConfigTable() {
		tabela.setRowHeight(TAM_ROW_TABLE); // Define o tamanho da linha da tabela
		tabela.setFocusable(false);
		tabela.setShowVerticalLines(false);
		tabela.setShowHorizontalLines(true);
		tabela.setRowMargin(5);
		tabela.setGridColor(Color.BLUE);
	}
	
	/**
	 * Metodo que generaliza a tabela padrão que deveser utilizada nas Frames
	 **/
	public JTable getTabela() {
		return tabela;
	}

	public void setTabela(JTable tabela) {
		this.tabela = tabela;
	}

}
