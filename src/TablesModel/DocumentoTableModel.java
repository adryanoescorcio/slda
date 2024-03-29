package TablesModel;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import Model.Documento;

public class DocumentoTableModel extends AbstractTableModel{

	private static final long serialVersionUID = 1L;

	private static final int COL_PROT = 0; // protocolo
	private static final int COL_NOMEDOC = 1; // nome do documento
	private static final int COL_DATA_PED = 2; // data do pedido
	private static final int COL_DATA_ENT = 3; // data da entrega
	private static final int COL_STATUS = 4; // status
	private static final int COL_DESC = 5; // descri��o

	private List<Documento> linhas;
	private String[] colunas = new String[]{"PROTOCOLO", "DOCUMENTO", "DATA PEDIDO", "DATA ENTREGA", "STATUS", "DESCRI��O"};

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

	public Class<String> getColumnClass(int columnIndex) {
		return String.class;
	}

	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}

	public Object getValueAt(int row, int column) {
		Documento m = linhas.get(row);

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

	//REMOVE A PATIR DO OBJETO
	public void removeContato(Object object) {
		int indice = 0;
		for(int i = 0; i < linhas.size(); i++){
			if(linhas.get(i).toString().equals(object.toString())){
				indice = i;
			}
		}
		linhas.remove(indice);
		fireTableRowsDeleted(indice, indice);

	}

	//ATUALIZAR NOVO A PARTIR DO VELHO
	public void updateContato(Object velho, Documento novo) {
		int indiceLinha = linhas.indexOf(velho);
		linhas.set(indiceLinha, novo);
		fireTableRowsUpdated(indiceLinha, indiceLinha);
	}

	/**
	 * Apagar as linhas e limpar a lista da tabela.
	 **/
	public void clear() {
		if(linhas.size() > 0) {
			fireTableRowsDeleted(0, this.linhas.size()-1);
			linhas.clear();
		}
	}

}

