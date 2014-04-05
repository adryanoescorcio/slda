package TablesModel;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import Model.Documento;

public class DocumentoTableModel extends AbstractTableModel{

private static final long serialVersionUID = 1L;
	
	private static final int COL_PROT = 0; // protocolo
	private static final int COL_NOMEDOC = 1; // nome do documento
	private static final int COL_DESC = 2; // descrição
	private static final int COL_DATA_PED = 3; // data do pedido
	private static final int COL_DATA_ENT = 4; // data da entrega
	private static final int COL_STATUS = 5; // status
	private static final int COL_ALUNO = 6; // status
	
	private List<Documento> linhas;
	private String[] colunas = new String[]{"PROTOCOLO", "CÓD. ALUNO", "DOCUMENTO", "DATA PEDIDO", "DATA ENTREGA", "STATUS", "DESCRIÇÃO"};

	public DocumentoTableModel(List<Documento> documento) {
		this.linhas = new ArrayList<>(documento);
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
		Documento m = linhas.get(row);

		if (column == COL_PROT) {
			return m.getCodigo();
		} else if (column == COL_ALUNO) {
			return m.getAluno();
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
		
		return "";
	}

	public void setValueAt(Object aValue, int row, int column) {
		// TODO
	}

	public Documento getContato(int indiceLinha) {
		return linhas.get(indiceLinha);
	}

	public void addContato(Documento contato) {
		linhas.add(contato);
		int ultimoIndice = getRowCount() - 1;
		fireTableRowsInserted(ultimoIndice, ultimoIndice);

	}

	public void updateContato(int indiceLinha, Documento marca) {
		linhas.set(indiceLinha, marca);
		fireTableRowsUpdated(indiceLinha, indiceLinha);

	}

	public void removeContato(int indiceLinha) {
		linhas.remove(indiceLinha);
		fireTableRowsDeleted(indiceLinha, indiceLinha);
	}
	
}

