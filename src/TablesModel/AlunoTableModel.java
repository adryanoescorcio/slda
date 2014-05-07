package TablesModel;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import Model.Aluno;

public class AlunoTableModel extends AbstractTableModel{

private static final long serialVersionUID = 1L;
	
	private static final int COL_ID = 0;
	private static final int COL_NOME = 1;
	private static final int COL_CPF = 2;
	private static final int COL_DATA_NASC = 3;
	private static final int COL_ESTADO_NASC = 4;
	private static final int COL_SEXO = 5;
	private static final int COL_COR = 6;
	private static final int COL_ENDERECO = 7;
	private static final int COL_TELEFONE = 8;
	private static final int COL_DATA_MATRI = 9;
	private static final int COL_ADMIT_TRANSF = 10;
	private static final int COL_SITUACAO = 11;

	private List<Aluno> linhas;
	private String[] colunas = new String[]{"CODIGO", "NOME", "CPF", "DATA NASC", "ESTADO NASC", 
			"SEXO", "COR", "ENDEREÇO", "TELEFONE", "DATA MATRICULA", "TRANSFERENCIA", "SITUAÇÃO"};

	public AlunoTableModel(List<Aluno> Aluno) {
		this.linhas = new ArrayList<>(Aluno);
	}

	public void setList(List<Aluno> list) {
		this.linhas = list;
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

	
	public Class<String> getColumnClass(int columnIndex) {
		return String.class;
	}

	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}

	public Object getValueAt(int row, int column) {

		Aluno m = linhas.get(row);

		if (column == COL_ID) {
			return m.getCodigo();
		} else if (column == COL_NOME) {
			return m.getNomeAluno();
		} else if (column == COL_DATA_NASC) {
			return m.getDataNascimento();
		} else if (column == COL_CPF) {
			return m.getCPF_Aluno();
		} else if (column == COL_COR) {
			return m.getCorAluno();
		} else if (column == COL_ADMIT_TRANSF) {
			return m.getTranferenciaAluno();
		} else if (column == COL_DATA_MATRI) {
			return m.getDataMatriculaAluno();
		} else if (column == COL_ENDERECO) {
			return m.getEnderecoAluno();
		} else if (column == COL_ESTADO_NASC) {
			return m.getEstadoNascAluno();
		} else if (column == COL_SITUACAO) {
			return m.getSituacaoAluno();
		} else if (column == COL_SEXO) {
			return m.getSexoAluno();
		} else if (column == COL_TELEFONE) {
			return m.getTelefoneAluno();
		}
		
		return "";
	}

	public void setValueAt(Object aValue, int row, int column) {
		// TODO
	}

	public Aluno getContato(int indiceLinha) {
		return linhas.get(indiceLinha);
	}

	public void addContato(Aluno contato) {
		linhas.add(contato);
		int ultimoIndice = getRowCount() - 1;
		fireTableRowsInserted(ultimoIndice, ultimoIndice);

	}

	public void updateContato(int indiceLinha, Aluno marca) {
		linhas.set(indiceLinha, marca);
		fireTableRowsUpdated(indiceLinha, indiceLinha);

	}

	public void removeContato(int indiceLinha) {
		linhas.remove(indiceLinha);
		fireTableRowsDeleted(indiceLinha, indiceLinha);

	}
	
	//REMOVE A PATIR DO OBJETO
	public void removeContato(Object object) {
		int indiceLinha = linhas.indexOf(object);
		linhas.remove(object);
		fireTableRowsDeleted(indiceLinha, indiceLinha);

	}
	
	//ATUALIZAR NOVO A PARTIR DO VELHO
	public void updateContato(Object velho, Aluno novo) {
		int indiceLinha = linhas.indexOf(velho);
		linhas.set(indiceLinha, novo);
		fireTableRowsUpdated(indiceLinha, indiceLinha);
	}

}
