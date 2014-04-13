package TablesModel;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import Model.AtaResultado;

public class AtaResultadoTableModel extends AbstractTableModel{

	private static final long serialVersionUID = 1L;
	
	private static final int COL_CODIGO = 0;
	private static final int COL_TURMA = 1;
	private static final int COL_TURNO = 2;
	private static final int COL_ANO = 3;
	
	private List<AtaResultado> linhas;
	private String[] colunas = new String[]{"CODIGO","TURMA", "TURNO", "ANO",};

	public AtaResultadoTableModel(List<AtaResultado> ata) {
		this.linhas = new ArrayList<>(ata);
	}

	public void setList(List<AtaResultado> ata) {
		this.linhas = ata;
		fireTableDataChanged();
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
		AtaResultado m = linhas.get(row);

		if (column == COL_TURMA) {
			return m.getTurmaAta();
		} else if (column == COL_TURNO) {
			return m.getTurnoAta();
		} else if (column == COL_ANO) {
			return m.getAnoAta();
		} else if (column == COL_CODIGO) {
			return m.getAluno();
		}
		
		return "";
	}

	public void setValueAt(Object aValue, int row, int column) {
		// TODO
	}

	public AtaResultado getContato(int indiceLinha) {
		return linhas.get(indiceLinha);
	}

	public void addContato(AtaResultado contato) {
		linhas.add(contato);
		int ultimoIndice = getRowCount() - 1;
		fireTableRowsInserted(ultimoIndice, ultimoIndice);
	}

	public void updateContato(int indiceLinha, AtaResultado marca) {
		linhas.set(indiceLinha, marca);
		fireTableRowsUpdated(indiceLinha, indiceLinha);
	}

	public void removeContato(int indiceLinha) {
		linhas.remove(indiceLinha);
		fireTableRowsDeleted(indiceLinha, indiceLinha);
	}
	
	public void changedAll(List<AtaResultado> list){
		this.linhas.removeAll(this.linhas);
		fireTableRowsDeleted(0, this.linhas.size()-1);
		this.linhas.addAll(list);
	}
}
