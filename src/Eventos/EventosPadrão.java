package Eventos;

import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import DAO.AlunoDAO;
import DAO.ArquivoDAO;
import DAO.AtaDAO;
import DAO.CaixaDAO;
import DAO.DocumentoDAO;
import DAO.JPAUtil;
import ExceptionSLDA.erroNullRequisitoException;
import Forms.ComboBoxGroup;
import Forms.TelaPadrao;
import Model.Aluno;
import Model.Ata;
import Model.Caixa;

@SuppressWarnings("serial")
public abstract class EventosPadrão extends JPanel{
	
	//CONEXÃO - DAOS
	protected JPAUtil conexaoBD = new JPAUtil();
	protected AlunoDAO daoAluno = new AlunoDAO(conexaoBD);	
	protected DocumentoDAO daoDoc = new DocumentoDAO(conexaoBD);
	protected AtaDAO daoAta = new AtaDAO(conexaoBD);
	protected ArquivoDAO daoArquivo = new ArquivoDAO(conexaoBD);
	protected CaixaDAO daoCaixa = new CaixaDAO(conexaoBD);
	
	//ENTIDADES
	protected Aluno aluno;
	protected Caixa caixa;
	protected Ata ata;
	
	protected TelaPadrao padrao = new TelaPadrao();
	protected ComboBoxGroup comboGroup = new ComboBoxGroup();
	
	public static final String DIR_ICONES = "src/Icones/";
	
	private ImageIcon iconePesquisar = new ImageIcon(DIR_ICONES+"search.png");
	private ImageIcon iconeSalvar = new ImageIcon(DIR_ICONES+"save.png");
	private ImageIcon iconeLimpar = new ImageIcon(DIR_ICONES+"limpar.png");
	private ImageIcon iconeExcluir = new ImageIcon(DIR_ICONES+"delete.png");
	private ImageIcon iconeAlterar = new ImageIcon(DIR_ICONES+"atualizar.png");
	private ImageIcon iconeDoc = new ImageIcon(DIR_ICONES+"doc.png");
	private ImageIcon iconeAta = new ImageIcon(DIR_ICONES+"ata2.png");
	private ImageIcon iconeCaixa = new ImageIcon(DIR_ICONES+"caixa.png");
	
	protected JButton btnPesquisar = new JButton("Pesquisar",iconePesquisar);
	protected JButton btnSalvar = new JButton("Salvar",iconeSalvar);
	protected JButton btnLimpar = new JButton("Limpar",iconeLimpar);
	protected JButton btnExcluir = new JButton("Excluir",iconeExcluir);
	protected JButton btnAlterar = new JButton("Alterar",iconeAlterar);
	protected JButton btnDocumento = new JButton("Doc", iconeDoc);
	protected JButton btnAta = new JButton("Ata",iconeAta);
	protected JButton btnCaixa = new JButton("Caixa", iconeCaixa);
	
	protected JTextField tfLocalizar = new JTextField();
	
	protected static final String SUCESSO = "Operação realizada com sucesso.";
	
	public EventosPadrão() {
		configInit();
		alterarFont();
	}
	
	public JPanel painelLocaliza(JLabel titulo) {
		return padrao.painelLocaliza(titulo, tfLocalizar, btnPesquisar);
	}

	private void alterarFont() {
		tfLocalizar.setFont(padrao.font_NEG_15);
		tfLocalizar.setPreferredSize(new Dimension(200,0));
	}

	private void configInit() {
		btnPesquisar.setFont(padrao.font_PLA_14);
		btnPesquisar.setPreferredSize(new Dimension(140,26));
		btnPesquisar.setRolloverEnabled(false);
	}
	
	/**
	 * Classe que limpa todos os campos de um Frame
	 **/
	public abstract void limparCampos();
	
	/**
	 * Captura os valores dos campos.
	 * @throws erroNullRequisitoException 
	 **/
	public abstract Object getValoresDosCampos() throws erroNullRequisitoException;
	
	/**
	 * Atribui valores aos campos da Frame
	 **/
	public abstract void setValoresDosCampos(Object object);
	
}
