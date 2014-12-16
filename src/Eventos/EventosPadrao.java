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
import ComponentGroupPlus.MaskFormatterGroup;
import DAO.AlunoDAO;
import DAO.ArquivoDAO;
import DAO.AtaDAO;
import DAO.AtaResultadoDAO;
import DAO.CaixaDAO;
import DAO.DocumentoDAO;
import DAO.JPAUtil;
import ExceptionSLDA.erroNullRequisitoException;
import Forms.MainJFrame;
import Model.Aluno;
import Model.Arquivo;
import Model.Ata;
import Model.Caixa;
import Model.Documento;

/**
 * Classe responsavel pelos eventos comuns a todos os paineis
 * 
 * @author Walysson Oliveira
 * @author Adryano Escorcio
 * @version 2.0
 **/
public abstract class EventosPadrao {

	// CONEXÃO - DAOS
	public JPAUtil conexaoBD = new JPAUtil();
	protected AlunoDAO daoAluno = new AlunoDAO(conexaoBD);
	protected DocumentoDAO daoDoc = new DocumentoDAO(conexaoBD);
	protected AtaDAO daoAta = new AtaDAO(conexaoBD);
	protected ArquivoDAO daoArquivo = new ArquivoDAO(conexaoBD);
	protected CaixaDAO daoCaixa = new CaixaDAO(conexaoBD);
	protected AtaResultadoDAO daoAtaResultado = new AtaResultadoDAO(conexaoBD);
	protected MainJFrame main;

	// scroll que envolve a tabela
	public JScrollPane scroll = new JScrollPane();

	// ENTIDADES
	protected Aluno aluno;
	protected Caixa caixa;
	protected Ata ata;
	public Arquivo arquivo;
	protected Documento documento;

	// FONTE
	protected FontGroup font = new FontGroup();

	// ICONES
	public IconesGroup icone = new IconesGroup();

	protected EditPanelGroup editPanel = new EditPanelGroup();

	public JTextField tfDiscente = new JTextField(); // campo que estará em
														// todos os Jpanel
	protected MaskFormatterGroup mask = new MaskFormatterGroup();

	protected ComboBoxGroup comboGroup = new ComboBoxGroup();

	public JButton btnPesquisar = new JButton(Messages.getString("EventosPadrao.0"), //$NON-NLS-1$
			icone.getIconePesquisar());
	
	public JButton btnSalvar = new JButton(Messages.getString("EventosPadrao.1"), icone.getIconeSalvar()); //$NON-NLS-1$
	public JButton btnLimpar = new JButton(Messages.getString("EventosPadrao.2"), icone.getIconeLimpar()); //$NON-NLS-1$
	public JButton btnAbrirCaixa = new JButton("Abrir", icone.getIconeAbrir());
	public JButton btnExcluir = new JButton(Messages.getString("EventosPadrao.3"), icone.getIconeExcluir()); //$NON-NLS-1$
	public JButton btnAlterar = new JButton(Messages.getString("EventosPadrao.4"), icone.getIconeAlterar()); //$NON-NLS-1$
	public JButton btnDocumento = new JButton(Messages.getString("EventosPadrao.5"), icone.getIconeDoc()); //$NON-NLS-1$
	public JButton btnAta = new JButton(Messages.getString("EventosPadrao.6"), icone.getIconeAta()); //$NON-NLS-1$
	public JButton btnAtaResul = new JButton(Messages.getString("EventosPadrao.7"), icone.getIconeAta()); //$NON-NLS-1$
	public JButton btnCaixa = new JButton(Messages.getString("EventosPadrao.8"), icone.getIconeCaixa()); //$NON-NLS-1$
	public JButton btnCancelar = new JButton(Messages.getString("EventosPadrao.9"), //$NON-NLS-1$
			icone.getIconeCancelar());
	public JButton btnInserirCaixa = new JButton(Messages.getString("EventosPadrao.10"), //$NON-NLS-1$
			icone.getIconeCaixa());
	public JButton btnInserir = new JButton(Messages.getString("EventosPadrao.11"), icone.getIconeInserir()); //$NON-NLS-1$
	public JButton btnRetirar = new JButton(Messages.getString("EventosPadrao.12"), icone.getIconeRetirar()); //$NON-NLS-1$

	protected JTextField tfLocalizar = new JTextField();

	protected static final String SUCESSO = Messages.getString("EventosPadrao.13"); //$NON-NLS-1$
	protected static final String ERROPROC = Messages.getString("EventosPadrao.14"); //$NON-NLS-1$

	public EventosPadrao() {
		configInit();
		alterarFont();
	}

	private void alterarFont() {
		tfLocalizar.setFont(font.font_NEG_15);
		tfLocalizar.setPreferredSize(new Dimension(200, 0));
		tfDiscente.setEditable(false); // nunca ira mudar.
	}

	private void configInit() {
		btnRetirar.setFont(font.font_PLA_14);
		btnInserir.setFont(font.font_PLA_14);
		btnPesquisar.setFont(font.font_PLA_14);
		btnPesquisar.setPreferredSize(new Dimension(140, 26));
		btnPesquisar.setRolloverEnabled(false);
		btnAlterar.setEnabled(false); // necessario a pesquisa para ativar botão
		btnExcluir.setEnabled(false); // necessario a pesquisa para ativar botão
		btnAtaResul.setEnabled(false);
		btnDocumento.setEnabled(false);
		btnCaixa.setEnabled(false);
		btnInserir.setEnabled(false);
		btnRetirar.setEnabled(false);
	}

	public Aluno getAluno() {
		return aluno;
	}

	public Ata getAta() {
		return ata;
	}

	/**
	 * Captura os valores dos campos.
	 * 
	 * @throws erroNullRequisitoException
	 **/
	public abstract Object getValoresDosCampos()
			throws erroNullRequisitoException;

	/**
	 * Classe que limpa todos os campos de um Frame
	 **/
	public abstract void limparCampos();

	public JPanel painelLocaliza(final JLabel titulo) {
		return editPanel.painelLocaliza(titulo, tfLocalizar, btnPesquisar);
	}

	public void setAluno(final Aluno aluno) {
		tfDiscente.setText(aluno.getNomeAluno());
		this.aluno = aluno;
	}

	/**
	 * Atribui valores aos campos da Frame
	 **/
	public abstract void setValoresDosCampos(Object object);
	
	public void direcionarParaCamada(int i) {
		main.direcionarParaCamada(i);
	}

}
