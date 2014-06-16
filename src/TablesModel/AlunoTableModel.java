package TablesModel;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import Model.Aluno;

public class AlunoTableModel extends AbstractTableModel {

	private static final long serialVersionUID = 1L;

	private static final int COL_ID = 0;
	private static final int COL_NOME = 1;
	private static final int COL_CPF = 2;
	private static final int COL_DATA_NASC = 3;
	private static final int COL_ESTADO_NASC = 4;
	private static final int COL_SEXO = 5;

	private List<Aluno> linhas;
	private final String[] colunas = new String[] { Messages.getString("AlunoTableModel.0"), Messages.getString("AlunoTableModel.1"), Messages.getString("AlunoTableModel.2"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
			Messages.getString("AlunoTableModel.3"), Messages.getString("AlunoTableModel.4"), Messages.getString("AlunoTableModel.5") }; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$

	public AlunoTableModel(final List<Aluno> Aluno) {
		this.linhas = new ArrayList<>(Aluno);
	}

	public void addContato(final Aluno contato) {
		linhas.add(contato);
		final int ultimoIndice = getRowCount() - 1;
		fireTableRowsInserted(ultimoIndice, ultimoIndice);

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

	public Aluno getContato(final int indiceLinha) {
		return linhas.get(indiceLinha);
	}

	@Override
	public int getRowCount() {
		return linhas.size();
	}

	@Override
	public Object getValueAt(final int row, final int column) {

		final Aluno m = linhas.get(row);

		if (column == COL_ID) {
			return m.getCodigo();
		} else if (column == COL_NOME) {
			return m.getNomeAluno();
		} else if (column == COL_DATA_NASC) {
			return m.getDataNascimento();
		} else if (column == COL_CPF) {
			return m.getCPF_Aluno();
		} else if (column == COL_ESTADO_NASC) {
			return m.getEstadoNascAluno();
		} else if (column == COL_SEXO) {
			return m.getSexoAluno();
		}

		return Messages.getString("AlunoTableModel.6"); //$NON-NLS-1$
	}

	@Override
	public boolean isCellEditable(final int rowIndex, final int columnIndex) {
		return false;
	}

	public void removeContato(final int indiceLinha) {
		linhas.remove(indiceLinha);
		fireTableRowsDeleted(indiceLinha, indiceLinha);

	}

	// REMOVE A PATIR DO OBJETO
	public void removeContato(final Object object) {
		final int indiceLinha = linhas.indexOf(object);
		linhas.remove(object);
		fireTableRowsDeleted(indiceLinha, indiceLinha);

	}

	public void setList(final List<Aluno> list) {
		this.linhas = list;
		fireTableDataChanged();
	}

	@Override
	public void setValueAt(final Object aValue, final int row, final int column) {
		// TODO
	}

	public void updateContato(final int indiceLinha, final Aluno marca) {
		linhas.set(indiceLinha, marca);
		fireTableRowsUpdated(indiceLinha, indiceLinha);

	}

	// ATUALIZAR NOVO A PARTIR DO VELHO
	public void updateContato(final Object velho, final Aluno novo) {
		final int indiceLinha = linhas.indexOf(velho);
		linhas.set(indiceLinha, novo);
		fireTableRowsUpdated(indiceLinha, indiceLinha);
	}

}
