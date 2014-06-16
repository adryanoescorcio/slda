package TablesModel;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import Model.Ata;

public class AtaTableModel extends AbstractTableModel {

	private static final long serialVersionUID = 1L;

	private static final int COL_TURMA = 0;
	private static final int COL_TURNO = 1;
	private static final int COL_ANO = 2;
	private static final int COL_MODALIDADE = 3;
	private static final int COL_ENSINO = 4;

	private final ArrayList<Ata> linhas;
	private final String[] colunas = new String[] { Messages.getString("AtaTableModel.0"), Messages.getString("AtaTableModel.1"), Messages.getString("AtaTableModel.2"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
			Messages.getString("AtaTableModel.3"), Messages.getString("AtaTableModel.4") }; //$NON-NLS-1$ //$NON-NLS-2$

	public AtaTableModel(final List<Ata> ata) {
		this.linhas = new ArrayList<>(ata);
	}

	public void addContato(final Ata contato) {
		linhas.add(contato);
		final int ultimoIndice = getRowCount() - 1;
		fireTableRowsInserted(ultimoIndice, ultimoIndice);

	}

	public void changedAll(final List<Ata> list) {
		this.linhas.removeAll(this.linhas);
		fireTableRowsDeleted(0, this.linhas.size() - 1);
		this.linhas.addAll(list);
	}

	@Override
	public Class<String> getColumnClass(final int columnIndex) {
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

	public Ata getContato(final int indiceLinha) {
		return linhas.get(indiceLinha);
	}

	@Override
	public int getRowCount() {
		return linhas.size();
	}

	@Override
	public Object getValueAt(final int row, final int column) {
		final Ata m = linhas.get(row);

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

		return Messages.getString("AtaTableModel.5"); //$NON-NLS-1$
	}

	@Override
	public boolean isCellEditable(final int rowIndex, final int columnIndex) {
		return false;
	}

	// REMOVE A PATIR DO OBJETO
	public void removeContato(final Ata object) {
		int indice = 0;
		for (int i = 0; i < linhas.size(); i++) {
			if (linhas.get(i).toString().equals(object.toString())) {
				indice = i;
			}
		}
		linhas.remove(indice);
		fireTableRowsDeleted(indice, indice);
	}

	public void removeContato(final int indiceLinha) {
		linhas.remove(indiceLinha);
		fireTableRowsDeleted(indiceLinha, indiceLinha);

	}

	@Override
	public void setValueAt(final Object aValue, final int row, final int column) {
		// TODO
	}

	public void updateContato(final Ata velho, final Ata novo) {
		Integer indice = null;
		for (int i = 0; i < linhas.size(); i++) {
			if (linhas.get(i).toString().equals(velho.toString())) {
				indice = i;
			}
		}
		if (indice == null) {
			System.out.println(Messages.getString("AtaTableModel.6")); //$NON-NLS-1$
		} else {
			linhas.set(indice, novo);
			fireTableRowsUpdated(indice, indice);
		}
	}

	// ATUALIZAR NOVO A PARTIR DO VELHO

	public void updateContato(final int indiceLinha, final Ata marca) {
		linhas.set(indiceLinha, marca);
		fireTableRowsUpdated(indiceLinha, indiceLinha);

	}
}
