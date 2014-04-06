package TablesModel;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import Model.Caixa;

public class CaixaTableModel extends AbstractTableModel {

	private static final long serialVersionUID = 1L;
	
	private static final int COL_ID = 0;
	private static final int COL_TURNO = 1;
	private static final int COL_STATUS = 2;
	private static final int COL_LETRA = 3;

	private List<Caixa> linhas;
	private String[] colunas = new String[]{"CODIGO", "TURNO", "STATUS", "LETRA"};

	public CaixaTableModel(List<Caixa> caixa) {
		this.linhas = new ArrayList<>(caixa);
	}

	public int getRowCount() {
		return linhas.size();
	}

	public int getColumnCount() {
		return colunas.length;
	}

	public String getColumnName(int columnIndex) {
		return colunas[columnIndex];
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Class getColumnClass(int columnIndex) {
		return String.class;
	}

	public boolean isCellEditable(int rowIndex, int columnIndex) {
		
		return false;
	}
	
	public Object getValueAt(int row, int column) {

		Caixa m = linhas.get(row);

		if (column == COL_ID) {
			return m.getCodigo();
		} else if (column == COL_TURNO) {
			return m.getTurno();
		} else if (column == COL_LETRA) {
			return m.getLetra();
		} else if (column == COL_STATUS) {
			return m.getStatus();
		}
		
		return "";
	}

	public void setValueAt(Object aValue, int row, int column) {
		Caixa u = linhas.get(row);
		if (column == COL_ID) {
			u.setCodigo((String) aValue);
		} else if (column == COL_TURNO) {
			u.setTurno(aValue.toString());
		} else if (column == COL_LETRA) {
			u.setLetra(aValue.toString());
		} else if (column == COL_STATUS) {
			u.setStatus(aValue.toString());
		}
	}

	public Caixa getContato(int indiceLinha) {
		return linhas.get(indiceLinha);
	}

	public void addContato(Caixa contato) {
		linhas.add(contato);
		int ultimoIndice = getRowCount() - 1;
		fireTableRowsInserted(ultimoIndice, ultimoIndice);
		System.out.println("A lista: " + linhas);
	}

	public void updateContato(int indiceLinha, Caixa marca) {
		linhas.set(indiceLinha, marca);
		fireTableRowsUpdated(indiceLinha, indiceLinha);
	}

	public void removeContato(int indiceLinha) {
		linhas.remove(indiceLinha);
		fireTableRowsDeleted(indiceLinha, indiceLinha);
	}
	
	//REMOVE A PATIR DO OBJETO
	public void removeContato(Caixa object) {
		System.out.println("A caixa setada é: " + object);
		
		int indiceLinha = linhas.indexOf(object);
		System.out.println("Antes: Lista é: " + linhas);
		System.out.println("O indice a ser deletado é: " + indiceLinha);
		linhas.remove(object);
		System.out.println("Depois: Lista é: " + linhas);
		fireTableRowsDeleted(indiceLinha, indiceLinha);

	}
	
	//ATUALIZAR NOVO A PARTIR DO VELHO
	public void updateContato(Caixa velho, Caixa novo) {
		int indiceLinha = linhas.indexOf(velho);
		System.out.println("O indice a ser atualizado é: " + indiceLinha);
		linhas.set(indiceLinha, novo);
		fireTableRowsUpdated(indiceLinha, indiceLinha);
	}

}
