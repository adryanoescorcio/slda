package Forms.Crud.Aluno;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableColumnModel;

import DAO.AlunoDAO;
import DAO.JPAUtil;




@SuppressWarnings("serial")
public class VisualizarTodosAlunos extends JFrame{

	JTable tabela;
	public VisualizarTodosAlunos() {
		super("Todos Alunos Cadastrados");
		String[] colunas = {"Matrícula", "Nome do Aluno", "INEP", "CPF", "RG", "UF de Nascimento", "Cidade de Nascimento", 
				"Data de Nascimento", "Sexo","Cor", "Telefone", "Endereço", "Nome do Pai", "Nome da Mãe", "UF de Nascimento da Mãe",
				"UF de Nascimento do Pai", "Cidade de Nascimento da Mãe", "Cidade de Nascimento do Pai"};

		JPAUtil conexaoBD = new JPAUtil();
		AlunoDAO dao = new AlunoDAO(conexaoBD);
		
		String[][] alunos = dao.visualizarTodosAluno();
		tabela = new JTable(alunos, colunas);
		
		definirTamanhoDasColunas();
		
		tabela.setPreferredScrollableViewportSize(new Dimension(500, 500));
		//tabela.setFillsViewportHeight(true);
		tabela.setBackground(Color.WHITE);
		tabela.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		JScrollPane scroll = new JScrollPane(tabela);
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		c.add(BorderLayout.CENTER, scroll);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setSize(1350, 700);
		
	}
	
	public static void main(String[] args) {
		
		new VisualizarTodosAlunos();
	}
	
	
	public void definirTamanhoDasColunas(){
		
		TableColumnModel modeloDaColuna = tabela.getColumnModel();
		modeloDaColuna.getColumn(0).setPreferredWidth(100);//MATRICULA
		modeloDaColuna.getColumn(1).setPreferredWidth(280);//NOME
		modeloDaColuna.getColumn(2).setPreferredWidth(100);//INEP
		modeloDaColuna.getColumn(3).setPreferredWidth(100);//CPF
		modeloDaColuna.getColumn(4).setPreferredWidth(100);//RG
		modeloDaColuna.getColumn(5).setPreferredWidth(110);//UF
		modeloDaColuna.getColumn(6).setPreferredWidth(150);//CIDADE DE NASCIMENTO DO ALUNO
		modeloDaColuna.getColumn(7).setPreferredWidth(120);//DATA DE NASCIMENTO
		modeloDaColuna.getColumn(8).setPreferredWidth(80);//SEXO
		modeloDaColuna.getColumn(9).setPreferredWidth(80);//COR
		modeloDaColuna.getColumn(10).setPreferredWidth(100);//TELEFONE
		modeloDaColuna.getColumn(11).setPreferredWidth(180);//ENDEREÇO
		modeloDaColuna.getColumn(12).setPreferredWidth(200);//NOME DA MAE
		modeloDaColuna.getColumn(13).setPreferredWidth(200);//NOME DO PAI
		modeloDaColuna.getColumn(14).setPreferredWidth(150);//UF DA MAE
		modeloDaColuna.getColumn(15).setPreferredWidth(150);//UF DO PAI
		modeloDaColuna.getColumn(16).setPreferredWidth(180);//CIDADE NASC MAE
		modeloDaColuna.getColumn(17).setPreferredWidth(180);//CIDADE NASC PAI
	}

}
