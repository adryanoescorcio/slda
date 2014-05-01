package Forms;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import sun.security.action.GetLongAction;

import ComponentGroupPlus.PainelTabela;
import Eventos.EventosAluno;
import Eventos.PlusEventoDiscenteLista;

public class PlusPainelDiscenteLista extends PlusEventoDiscenteLista {
	
	private static JPanel mainDialog = new JPanel(new BorderLayout(2,2));
	// Tabela
	protected JPanel painelTabela= new JPanel(new BorderLayout(2,2));	
	protected JScrollPane scroll = new JScrollPane();
	protected JScrollPane scrollMain = new JScrollPane();
	protected PainelTabela table = new PainelTabela();
	protected JTable tabela = table.getTabela();
	
	private JPanel painelInternoNorte = new JPanel(new BorderLayout(2,2));
	
	public PlusPainelDiscenteLista(EventosAluno evento) {
		super(mainDialog, evento); // passado a tela principal e o evento de aluno com as instancias

		mainDialog.add("North", painelInternoNorte());
		initJDialog();
	}
	
	public JPanel getMainDialog() {
		return mainDialog;
	}

	public static void setMainDialog(JPanel mainDialog) {
		PlusPainelDiscenteLista.mainDialog = mainDialog;
	}
	
	private JPanel painelTable() {
		eventos();
		// carregando modelo da tabela.
		tabela.setModel(evento.modeloAlunoTable);
		
		scroll.setPreferredSize(new Dimension(0, 200)); // Define o tamanho da tabela.
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		scroll.setViewportView(tabela); // insere a tabela no painel Scroll
		
		painelTabela.add("North", editPanel.painelNull(0, 10));
		painelTabela.add("Center",table.organizandoColunasTables(evento.modeloAlunoTable));
		painelTabela.add("South", editPanel.painelNull(0, 10));
		
		return painelTabela;
	}

	private void eventos() {
		btnCancelar.addActionListener(onClickCancelar);
		btnSalvar.addActionListener(onClickSalvar);
	}

	/**
	 * Painel para construir GUI
	 **/
	private JPanel painelInternoNorte() {
		
		JPanel controleSuperior = new JPanel(new BorderLayout(2,2));
		JPanel contendControl = new JPanel(new BorderLayout(2,2));
		JPanel contentPainel = new JPanel(new BorderLayout(2,2));
		JPanel contentPainelBotao = new JPanel(new BorderLayout(2,2));

		contentPainelBotao.add("Center", editPanel.painelContentComponent("West", painelbotoes()));
		contentPainelBotao.add("North", editPanel.painelNull(0, 10));
		contentPainelBotao.add("South", editPanel.painelNull(0, 10));
		contentPainelBotao.add("West", editPanel.painelNull(20, 0));
		
		contentPainel.add("Center", painelTable());
		contentPainel.add("North", editPanel.painelNull(0, 20));
		contentPainel.add("West", editPanel.painelNull(20, 0));
		contentPainel.add("East", editPanel.painelNull(20, 0));
		contentPainel.add("South", contentPainelBotao);
		
		
		controleSuperior.add("South",contentPainel);
		controleSuperior.setBorder(BorderFactory.createTitledBorder(
				BorderFactory.createSoftBevelBorder(2)));
		
		contendControl.add("Center", controleSuperior);
		contendControl.add("West", editPanel.painelNull(20, 0));
		contendControl.add("East", editPanel.painelNull(20, 0));
		contendControl.add("North", editPanel.painelNull(0, 20));
		contendControl.add("South", editPanel.painelNull(0, 20));
		
		painelInternoNorte.add("North", contendControl);
		
		return painelInternoNorte;
	}
	
	private JPanel painelbotoes() {
		JPanel painelbotoe = new JPanel(new GridLayout(1,2,5,5));
		painelbotoe.add(btnSalvar);
		painelbotoe.add(btnCancelar);
		
		return painelbotoe;
	}

	private void initJDialog() {
		mainDialog.setSize(400, 350);
		mainDialog.setVisible(true);	
		
		if(evento.arquivo != null) {
			btnExcluir.setEnabled(true);
		}
	}
}
