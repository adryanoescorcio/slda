package ComponentGroupPlus;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

public class PainelTabela {
	// quantidade de linhas da tabela
	protected static final int TAM_ROW_TABLE = 22;

	// scroll que envolve a tabela
	public JScrollPane scroll = new JScrollPane();
	public JTable tabela = new JTable(); // Table para todas as Jframes

	public PainelTabela() {
		loadConfigTable();
	}

	/**
	 * Metodo que generaliza a tabela padr�o que deveser utilizada nas Frames
	 **/
	public JTable getTabela() {
		return tabela;
	}

	/**
	 * Carrega as configura��es padr�es de todas as tabelas.
	 **/
	private void loadConfigTable() {
		tabela.setRowHeight(TAM_ROW_TABLE); // Define o tamanho da linha da
											// tabela
		tabela.setFocusable(false);
		tabela.setShowVerticalLines(false);
		tabela.setShowHorizontalLines(true);
		tabela.setRowMargin(5);
		tabela.setGridColor(Color.BLUE);
	}

	/**
	 * Reestrutura a disposi��o das colunas na tabela insere o scroll
	 * 
	 * @param tabela
	 * @return tabela reorganizada
	 **/
	public JScrollPane organizandoColunasTables(final AbstractTableModel modelo) {
		// carregando modelo da tabela.

		tabela.setModel(modelo);
		tabela.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		final int numColunas = tabela.getColumnCount();
		final int x = 100 * numColunas;
		int y = 100; // valor padr�o para o tamanho das colunas.

		// x tem que preencher 800, ou seja o minimo de 8 colunas.
		// Sen�o as colunas ser�o divididas outras vez para caber na tabela.
		if (x < 900) {
			y = 1000 / numColunas;
		}

		for (int i = 0; i < tabela.getColumnCount(); i++) {
			tabela.getColumnModel().getColumn(i).setPreferredWidth(y);
		}

		scroll.setPreferredSize(new Dimension(800, 200)); // Define o tamanho da
															// tabela.
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS); // Adiciona
																							// o
																							// scroll
																							// vertical
		scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS); // adiciona
																								// o
																								// scroll
																								// horizontal

		scroll.setViewportView(tabela); // insere a tabela no painel Scroll
		scroll.setWheelScrollingEnabled(true);

		return scroll;
	}

	public void setModelTabela(final TableModel dataModel) {
		this.tabela.setModel(dataModel);
	}

	public void setTabela(final JTable tabela) {
		this.tabela = tabela;
	}

}
