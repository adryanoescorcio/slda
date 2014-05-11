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
	private static final int COL_NIS = 3;
	private static final int COL_DATA_NASC = 4;
	private static final int COL_ESTADO_NASC = 5;
	private static final int COL_SEXO = 6;
	private static final int COL_COR = 7;
	private static final int COL_ENDERECO = 8;
	private static final int COL_TELEFONE = 9;
	private static final int COL_DATA_MATRI = 10;
	private static final int COL_ADMIT_TRANSF = 11;
	private static final int COL_SITUACAO = 12;
	private static final int COL_LIVRO = 13;
	private static final int COL_CERTIFICADO = 14;
	private static final int COL_FOLHA = 15;
	private static final int COL_DATA_REG = 16;

	private List<Aluno> linhas;
	private String[] colunas = new String[]{"CODIGO", "NOME", "CPF", "NIS", "DATA NASC.", "ESTADO NASC.", 
			"SEXO", "COR", "ENDEREÇO", "FONE", "DATA MATRIC.", "TRANSF.", "SITUAÇÃO", "CERTIFICADO", "LIVRO", "FOLHA", "DATA REG."};

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
		} else if (column == COL_CERTIFICADO) {
			return m.getNumCertificado();
		} else if (column == COL_NIS) {
			return m.getNis();
		} else if (column == COL_FOLHA) {
			return m.getFolha();
		} else if (column == COL_LIVRO) {
			return m.getTelefoneAluno();
		} else if (column == COL_DATA_REG) {
			return m.getDataRegCertif();
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
