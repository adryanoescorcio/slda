package Forms.TablesModel;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import Model.Ata;

public class AtaTableModel extends AbstractTableModel{

	private static final long serialVersionUID = 1L;
	
	private static final int COL_TURMA = 0;
	private static final int COL_TURNO = 1;
	private static final int COL_ANO = 2;
	private static final int COL_MODALIDADE = 3;
	private static final int COL_ENSINO = 4;
	
	private List<Ata> linhas;
	private String[] colunas = new String[]{"TURMA", "TURNO", "ANO", "MODALIDADE", "ENSINO"};

	public AtaTableModel(List<Ata> ata) {
		this.linhas = new ArrayList<>(ata);
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

	public Class getColumnClass(int columnIndex) {
		return String.class;
	}

	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}

	public Object getValueAt(int row, int column) {
		Ata m = linhas.get(row);

		if (column == COL_TURMA) {
			return m.getTurmaAta();
		} else if (column == COL_TURNO) {
			return m.getTurnoAta();
		} else if (column == COL_ANO) {
			return m.getAnoAta();
		} else if (column == COL_ENSINO) {
			return m.getEnsinoAta();
		} else if (column == COL_MODALIDADE) {
			return m.getModalidadeAta();
		}
		
		return "";
	}

	public void setValueAt(Object aValue, int row, int column) {
		// TODO
	}

	public Ata getContato(int indiceLinha) {
		return linhas.get(indiceLinha);
	}

	public void addContato(Ata contato) {
		linhas.add(contato);
		int ultimoIndice = getRowCount() - 1;
		fireTableRowsInserted(ultimoIndice, ultimoIndice);

	}

	public void updateContato(int indiceLinha, Ata marca) {
		linhas.set(indiceLinha, marca);
		fireTableRowsUpdated(indiceLinha, indiceLinha);

	}

	public void removeContato(int indiceLinha) {
		linhas.remove(indiceLinha);
		fireTableRowsDeleted(indiceLinha, indiceLinha);

	}
	

}
