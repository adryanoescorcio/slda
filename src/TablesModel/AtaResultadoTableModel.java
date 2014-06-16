package TablesModel;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import Model.AtaResultado;

public class AtaResultadoTableModel extends AbstractTableModel {

	private static final long serialVersionUID = 1L;

	private static final int COL_ORDEM = 0;
	private static final int COL_TURMA = 1;
	private static final int COL_TURNO = 2;
	private static final int COL_ANO = 3;
	private static final int COL_MODALI = 4;
	private static final int COL_ENSINO = 5;

	private List<AtaResultado> linhas;
	private final String[] colunas = new String[] { Messages.getString("AtaResultadoTableModel.0"), Messages.getString("AtaResultadoTableModel.1"), Messages.getString("AtaResultadoTableModel.2"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
			Messages.getString("AtaResultadoTableModel.3"), Messages.getString("AtaResultadoTableModel.4"), Messages.getString("AtaResultadoTableModel.5") }; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$

	public AtaResultadoTableModel(final List<AtaResultado> ata) {
		this.linhas = new ArrayList<>(ata);
	}

	public void addContato(final AtaResultado contato) {
		linhas.add(contato);
		final int ultimoIndice = getRowCount() - 1;
		fireTableRowsInserted(ultimoIndice, ultimoIndice);
	}

	public void changedAll(final List<AtaResultado> list) {
		this.linhas.removeAll(this.linhas);
		fireTableRowsDeleted(0, this.linhas.size() - 1);
		this.linhas.addAll(list);
	}

	/**
	 * Apagar as linhas e limpar a lista da tabela.
	 **/
	public void clear() {
		if (linhas.size() > 0) {
			fireTableRowsDeleted(0, this.linhas.size() - 1);
			linhas.clear();
		}
	}

	@Override
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Class getColumnClass(final int columnIndex) {
		return String.class;
	}

	@Override
	public int getColumnCount() {
		return colunas.length;
	}

	@Override
	public String getColumnName(final int columnIndex) {
		return colunas[columnIndex];
	}

	public AtaResultado getContato(final int indiceLinha) {
		return linhas.get(indiceLinha);
	}

	@Override
	public int getRowCount() {
		return linhas.size();
	}

	@Override
	public Object getValueAt(final int row, final int column) {
		final AtaResultado m = linhas.get(row);

		if (column == COL_TURMA) {
			return m.getTurmaAta();
		} else if (column == COL_TURNO) {
			return m.getTurnoAta();
		} else if (column == COL_ORDEM) {
			return row + 1;
		} else if (column == COL_ANO) {
			return m.getAnoAta();
		} else if (column == COL_MODALI) {
			return m.getModalidadeAta();
		} else if (column == COL_ENSINO) {
			return m.getEnsinoAta();
		}
		return Messages.getString("AtaResultadoTableModel.6"); //$NON-NLS-1$
	}

	@Override
	public boolean isCellEditable(final int rowIndex, final int columnIndex) {
		return false;
	}

	public void removeContato(final int indiceLinha) {
		linhas.remove(indiceLinha);
		fireTableRowsDeleted(indiceLinha, indiceLinha);
	}

	public void setList(final List<AtaResultado> ata) {
		this.linhas = ata;
		fireTableDataChanged();
	}

	@Override
	public void setValueAt(final Object aValue, final int row, final int column) {
		// TODO
	}

	public void updateContato(final int indiceLinha, final AtaResultado marca) {
		linhas.set(indiceLinha, marca);
		fireTableRowsUpdated(indiceLinha, indiceLinha);
	}

}
