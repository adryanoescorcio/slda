package TablesModel;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import Model.Arquivo;

public class ArquivoTableModel extends AbstractTableModel {

	private static final long serialVersionUID = 1L;

	private static final int COL_CAIXA = 0;
	private static final int COL_ORDEM = 1;
	private static final int COL_CODIGO_ALUNO = 2;
	private static final int COL_NOME_ALUNO = 3;
	private static final int COL_DATA = 4;

	private List<Arquivo> linhas;
	private final String[] colunas = new String[] {"COD_CAIXA", "ORDEM", "CODIGO_ALUNO", "NOME_ALUNO", "DATA_ENTRADA"};

	public ArquivoTableModel(final List<Arquivo> Arquivo) {
		this.linhas = new ArrayList<>(Arquivo);
	}

	public void addContato(final Arquivo contato) {
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

	public Arquivo getContato(final int indiceLinha) {
		return linhas.get(indiceLinha);
	}

	@Override
	public int getRowCount() {
		return linhas.size();
	}

	@Override
	public Object getValueAt(final int row, final int column) {

		final Arquivo m = linhas.get(row);

		if (column == COL_CAIXA) {
			return m.getCodigoCaixa();
		} else if (column == COL_ORDEM) {
			return m.getCodDossie();
		} else if (column == COL_CODIGO_ALUNO) {
			return m.getCodigoAluno();
		} else if (column == COL_NOME_ALUNO) {
			return m.getAluno().getNomeAluno();
		} else if (column == COL_DATA) {
			return m.getDatadeEntradaArquivo();
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

	public void setList(final List<Arquivo> list) {
		this.linhas = list;
		fireTableDataChanged();
	}

	@Override
	public void setValueAt(final Object aValue, final int row, final int column) {
		// TODO
	}

	public void updateContato(final int indiceLinha, final Arquivo marca) {
		linhas.set(indiceLinha, marca);
		fireTableRowsUpdated(indiceLinha, indiceLinha);

	}

	// ATUALIZAR NOVO A PARTIR DO VELHO
	public void updateContato(final Object velho, final Arquivo novo) {
		final int indiceLinha = linhas.indexOf(velho);
		linhas.set(indiceLinha, novo);
		fireTableRowsUpdated(indiceLinha, indiceLinha);
	}

}
