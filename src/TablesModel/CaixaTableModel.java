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
	private static final int COL_MODALIDADE = 4;
	private static final int COL_ENSINO = 5;

	private final ArrayList<Caixa> linhas;
	private final String[] colunas = new String[] { Messages.getString("CaixaTableModel.0"), Messages.getString("CaixaTableModel.1"), //$NON-NLS-1$ //$NON-NLS-2$
			Messages.getString("CaixaTableModel.2"), Messages.getString("CaixaTableModel.3"), Messages.getString("CaixaTableModel.4"), Messages.getString("CaixaTableModel.5") }; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$

	public CaixaTableModel(final List<Caixa> caixa) {
		this.linhas = new ArrayList<>(caixa);
	}

	public void addContato(final Caixa contato) {
		linhas.add(contato);
		final int ultimoIndice = getRowCount() - 1;
		fireTableRowsInserted(ultimoIndice, ultimoIndice);
		// System.out.println("A lista: " + linhas);
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

	public Caixa getContato(final int indiceLinha) {
		return linhas.get(indiceLinha);
	}

	@Override
	public int getRowCount() {
		return linhas.size();
	}

	@Override
	public Object getValueAt(final int row, final int column) {

		final Caixa m = linhas.get(row);

		if (column == COL_ID) {
			return m.getCodigo();
		} else if (column == COL_TURNO) {
			return m.getTurno();
		} else if (column == COL_LETRA) {
			return m.getLetra();
		} else if (column == COL_STATUS) {
			return m.getStatus();
		} else if (column == COL_ENSINO) {
			return m.getEnsinoAta();
		} else if (column == COL_MODALIDADE) {
			return m.getModalidadeAta();
		}

		return Messages.getString("CaixaTableModel.6"); //$NON-NLS-1$
	}

	@Override
	public boolean isCellEditable(final int rowIndex, final int columnIndex) {

		return false;
	}

	// REMOVE A PATIR DO OBJETO
	public void removeContato(final Caixa object) {
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
	}

	// ATUALIZAR NOVO A PARTIR DO VELHO
	public void updateContato(final Caixa velho, final Caixa novo) {
		Integer indice = null;
		for (int i = 0; i < linhas.size(); i++) {
			if (linhas.get(i).toString().equals(velho.toString())) {
				indice = i;
			}
		}
		if (indice == null) {
			System.out.println(Messages.getString("CaixaTableModel.7")); //$NON-NLS-1$
		} else {
			linhas.set(indice, novo);
			fireTableRowsUpdated(indice, indice);
		}
	}

	public void updateContato(final int indiceLinha, final Caixa marca) {
		linhas.set(indiceLinha, marca);
		fireTableRowsUpdated(indiceLinha, indiceLinha);
	}

}
