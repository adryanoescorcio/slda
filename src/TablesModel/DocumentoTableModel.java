package TablesModel;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import Model.Documento;

public class DocumentoTableModel extends AbstractTableModel {

	private static final long serialVersionUID = 1L;

	private static final int COL_PROT = 0; // protocolo
	private static final int COL_NOMEDOC = 1; // nome do documento
	private static final int COL_DATA_PED = 2; // data do pedido
	private static final int COL_DATA_ENT = 3; // data da entrega
	private static final int COL_STATUS = 4; // status
	private static final int COL_DESC = 5; // descrição

	private final List<Documento> linhas;
	private final String[] colunas = new String[] { Messages.getString("DocumentoTableModel.0"), Messages.getString("DocumentoTableModel.1"), //$NON-NLS-1$ //$NON-NLS-2$
			Messages.getString("DocumentoTableModel.2"), Messages.getString("DocumentoTableModel.3"), Messages.getString("DocumentoTableModel.4"), Messages.getString("DocumentoTableModel.5") }; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$

	public DocumentoTableModel(final List<Documento> documento) {
		this.linhas = new ArrayList<>(documento);
	}

	public void addContato(final Documento contato) {
		linhas.add(contato);
		final int ultimoIndice = getRowCount() - 1;
		fireTableRowsInserted(ultimoIndice, ultimoIndice);

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

	public Documento getContato(final int indiceLinha) {
		return linhas.get(indiceLinha);
	}

	@Override
	public int getRowCount() {
		return linhas.size();
	}

	@Override
	public Object getValueAt(final int row, final int column) {
		final Documento m = linhas.get(row);

		if (column == COL_PROT) {
			return m.getCodigo();
		} else if (column == COL_NOMEDOC) {
			return m.getNomeDocumento();
		} else if (column == COL_DESC) {
			return m.getDescricao();
		} else if (column == COL_DATA_ENT) {
			return m.getDataEntrega();
		} else if (column == COL_DATA_PED) {
			return m.getDataPedido();
		} else if (column == COL_STATUS) {
			return m.getStatus();
		}

		return Messages.getString("DocumentoTableModel.6"); //$NON-NLS-1$
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
		int indice = 0;
		for (int i = 0; i < linhas.size(); i++) {
			if (linhas.get(i).toString().equals(object.toString())) {
				indice = i;
			}
		}
		linhas.remove(indice);
		fireTableRowsDeleted(indice, indice);

	}

	@Override
	public void setValueAt(final Object aValue, final int row, final int column) {
		// TODO
	}

	public void updateContato(final int indiceLinha, final Documento marca) {
		linhas.set(indiceLinha, marca);
		fireTableRowsUpdated(indiceLinha, indiceLinha);

	}

	// ATUALIZAR NOVO A PARTIR DO VELHO
	public void updateContato(final Object velho, final Documento novo) {
		final int indiceLinha = linhas.indexOf(velho);
		linhas.set(indiceLinha, novo);
		fireTableRowsUpdated(indiceLinha, indiceLinha);
	}

}
