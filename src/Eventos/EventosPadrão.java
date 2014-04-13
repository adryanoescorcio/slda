package Eventos;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
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
import Model.Ata;
import Model.Caixa;

/**
 * Classe responsavel pelos eventos comuns a todos os paineis
 * 
 * @author Walysson Oliveira
 * @author Adryano Escorcio
 * @version 2.0
 **/
public abstract class EventosPadr�o {
	
	//CONEX�O - DAOS
	protected JPAUtil conexaoBD = new JPAUtil();
	protected AlunoDAO daoAluno = new AlunoDAO(conexaoBD);	
	protected DocumentoDAO daoDoc = new DocumentoDAO(conexaoBD);
	protected AtaDAO daoAta = new AtaDAO(conexaoBD);
	protected ArquivoDAO daoArquivo = new ArquivoDAO(conexaoBD);
	protected CaixaDAO daoCaixa = new CaixaDAO(conexaoBD);
	protected AtaResultadoDAO daoAtaResultado = new AtaResultadoDAO(conexaoBD);
	
	//ENTIDADES
	protected Aluno aluno;
	protected Caixa caixa;
	protected Ata ata;
	
	// FONTE
	protected FontGroup font = new FontGroup();
	
	// ICONES
	public IconesGroup icone = new IconesGroup();
	
	protected EditPanelGroup editPanel = new EditPanelGroup();

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
	
	protected JTextField tfLocalizar = new JTextField();
	
	protected static final String SUCESSO = "Opera��o realizada com sucesso.";
	
	public EventosPadr�o() {
		
		configInit();
		alterarFont();
	}
	
	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}



	public JPanel painelLocaliza(JLabel titulo) {
		return editPanel.painelLocaliza(titulo, tfLocalizar, btnPesquisar);
	}

	private void alterarFont() {
		tfLocalizar.setFont(font.font_NEG_15);
		tfLocalizar.setPreferredSize(new Dimension(200,0));
	}

	private void configInit() {
		btnPesquisar.setFont(font.font_PLA_14);
		btnPesquisar.setPreferredSize(new Dimension(140,26));
		btnPesquisar.setRolloverEnabled(false);
		btnAlterar.setEnabled(false); // necessario a pesquisa para ativar bot�o
		btnExcluir.setEnabled(false); // necessario a pesquisa para ativar bot�o
		btnAtaResul.setEnabled(false);
		btnDocumento.setEnabled(false);
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
