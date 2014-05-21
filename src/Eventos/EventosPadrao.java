package Eventos;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import ComponentGroupPlus.ComboBoxGroup;
import ComponentGroupPlus.EditPanelGroup;
import ComponentGroupPlus.FontGroup;
import ComponentGroupPlus.IconesGroup;
import DAO.AlunoDAO;
import DAO.ArquivoDAO;
import DAO.AtaDAO;
import DAO.AtaResultadoDAO;
import DAO.CaixaDAO;
import DAO.DocumentoDAO;
import DAO.JPAUtil;
import ExceptionSLDA.erroNullRequisitoException;
import Model.Aluno;
import Model.Arquivo;
import Model.Ata;
import Model.Caixa;

/**
 * Classe responsavel pelos eventos comuns a todos os paineis
 * 
 * @author Walysson Oliveira
 * @author Adryano Escorcio
 * @version 2.0
 **/
public abstract class EventosPadrao {

	//CONEXÃO - DAOS
	protected JPAUtil conexaoBD = new JPAUtil();
	protected AlunoDAO daoAluno = new AlunoDAO(conexaoBD);	
	protected DocumentoDAO daoDoc = new DocumentoDAO(conexaoBD);
	protected AtaDAO daoAta = new AtaDAO(conexaoBD);
	protected ArquivoDAO daoArquivo = new ArquivoDAO(conexaoBD);
	protected CaixaDAO daoCaixa = new CaixaDAO(conexaoBD);
	protected AtaResultadoDAO daoAtaResultado = new AtaResultadoDAO(conexaoBD);

	// scroll que envolve a tabela
	public JScrollPane scroll = new JScrollPane();
	
	//ENTIDADES
	protected Aluno aluno;
	protected Caixa caixa;
	protected Ata ata;
	public Arquivo arquivo;

	// FONTE
	protected FontGroup font = new FontGroup();

	// ICONES
	public IconesGroup icone = new IconesGroup();

	protected EditPanelGroup editPanel = new EditPanelGroup();
	
	public JTextField tfDiscente = new JTextField(); // campo que estará em todos os Jpanel

	protected ComboBoxGroup comboGroup = new ComboBoxGroup();

	public JButton btnPesquisar = new JButton("Pesquisar",icone.getIconePesquisar());
	public JButton btnSalvar = new JButton("Salvar",icone.getIconeSalvar());
	public JButton btnLimpar = new JButton("Limpar",icone.getIconeLimpar());
	public JButton btnExcluir = new JButton("Excluir",icone.getIconeExcluir());
	public JButton btnAlterar = new JButton("Alterar",icone.getIconeAlterar());
	public JButton btnDocumento = new JButton("Doc", icone.getIconeDoc());
	public JButton btnAta = new JButton("Ata",icone.getIconeAta());
	public JButton btnAtaResul = new JButton("Ata",icone.getIconeAta());
	public JButton btnCaixa = new JButton("Caixa", icone.getIconeCaixa());
	public JButton btnCancelar = new JButton("Cancelar", icone.getIconeCancelar());
	public JButton btnInserirCaixa = new JButton("Criar Caixa", icone.getIconeCaixa());
	public JButton btnInserir = new JButton("Inserir", icone.getIconeInserir());
	public JButton btnRetirar = new JButton("Retirar", icone.getIconeRetirar());

	protected JTextField tfLocalizar = new JTextField();

	protected static final String SUCESSO = "Operação realizada com sucesso.";

	public EventosPadrao() {
		configInit();
		alterarFont();
	}

	public Aluno getAluno() {
		return aluno;
	}
	
	public Ata getAta() {
		return ata;
	}

	public void setAluno(Aluno aluno) {
		tfDiscente.setText(aluno.getNomeAluno());
		this.aluno = aluno;
	}

	public JPanel painelLocaliza(JLabel titulo) {
		return editPanel.painelLocaliza(titulo, tfLocalizar, btnPesquisar);
	}

	private void alterarFont() {
		tfLocalizar.setFont(font.font_NEG_15);
		tfLocalizar.setPreferredSize(new Dimension(200,0));
		tfDiscente.setEditable(false); // nunca ira mudar.
	}

	private void configInit() {
		btnRetirar.setFont(font.font_PLA_14);
		btnInserir.setFont(font.font_PLA_14);
		btnPesquisar.setFont(font.font_PLA_14);
		btnPesquisar.setPreferredSize(new Dimension(140,26));
		btnPesquisar.setRolloverEnabled(false);
		btnAlterar.setEnabled(false); // necessario a pesquisa para ativar botão
		btnExcluir.setEnabled(false); // necessario a pesquisa para ativar botão
		btnAtaResul.setEnabled(false);
		btnDocumento.setEnabled(false);
		btnCaixa.setEnabled(false);
		btnInserir.setEnabled(false);
		btnRetirar.setEnabled(false);
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
