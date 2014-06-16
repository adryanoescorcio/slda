package Forms;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import Eventos.EventosAluno;
import Eventos.PlusEventoDiscenteLista;

public class PlusPainelDiscenteLista extends PlusEventoDiscenteLista {

	private static JPanel mainDialog = new JPanel(new BorderLayout(2, 2));

	public static void setMainDialog(final JPanel mainDialog) {
		PlusPainelDiscenteLista.mainDialog = mainDialog;
	}

	// Tabela
	protected JPanel painelTabela = new JPanel(new BorderLayout(2, 2));
	protected JScrollPane scroll = new JScrollPane();

	protected JScrollPane scrollMain = new JScrollPane();

	private final JPanel painelInternoNorte = new JPanel(new BorderLayout(2, 2));

	public PlusPainelDiscenteLista(final EventosAluno evento) {
		super(mainDialog, evento); // passado a tela principal e o evento de
									// aluno com as instancias

		mainDialog.add(Messages.getString("PlusPainelDiscenteLista.0"), painelInternoNorte()); //$NON-NLS-1$
		initJDialog();
	}

	private void eventos() {
		btnCancelar.addActionListener(onClickCancelar);
		btnSalvar.addActionListener(onClickSalvar);
		tabela.addMouseListener(onClickRowTable);

	}

	public JPanel getMainDialog() {
		return mainDialog;
	}

	private void initJDialog() {
		mainDialog.setSize(400, 350);
		mainDialog.setVisible(true);

		if (evento.arquivo != null) {
			btnExcluir.setEnabled(true);
		}
	}

	private JPanel painelbotoes() {
		// mudando o nome do botão salvar
		btnSalvar.setText(Messages.getString("PlusPainelDiscenteLista.1")); //$NON-NLS-1$
		btnCancelar.setText(Messages.getString("PlusPainelDiscenteLista.2")); //$NON-NLS-1$

		final JPanel painelbotoe = new JPanel(new GridLayout(1, 2, 5, 5));
		painelbotoe.add(btnSalvar);
		painelbotoe.add(btnCancelar);

		return painelbotoe;
	}

	/**
	 * Painel para construir GUI
	 **/
	private JPanel painelInternoNorte() {

		final JPanel controleSuperior = new JPanel(new BorderLayout(2, 2));
		final JPanel contendControl = new JPanel(new BorderLayout(2, 2));
		final JPanel contentPainel = new JPanel(new BorderLayout(2, 2));
		final JPanel contentPainelBotao = new JPanel(new BorderLayout(2, 2));

		contentPainelBotao.add(Messages.getString("PlusPainelDiscenteLista.3"), //$NON-NLS-1$
				editPanel.painelContentComponent(Messages.getString("PlusPainelDiscenteLista.4"), painelbotoes())); //$NON-NLS-1$
		contentPainelBotao.add(Messages.getString("PlusPainelDiscenteLista.5"), editPanel.painelNull(0, 10)); //$NON-NLS-1$
		contentPainelBotao.add(Messages.getString("PlusPainelDiscenteLista.6"), editPanel.painelNull(0, 10)); //$NON-NLS-1$
		contentPainelBotao.add(Messages.getString("PlusPainelDiscenteLista.7"), editPanel.painelNull(20, 0)); //$NON-NLS-1$

		contentPainel.add(Messages.getString("PlusPainelDiscenteLista.8"), painelTable()); //$NON-NLS-1$
		contentPainel.add(Messages.getString("PlusPainelDiscenteLista.9"), editPanel.painelNull(0, 20)); //$NON-NLS-1$
		contentPainel.add(Messages.getString("PlusPainelDiscenteLista.10"), editPanel.painelNull(20, 0)); //$NON-NLS-1$
		contentPainel.add(Messages.getString("PlusPainelDiscenteLista.11"), editPanel.painelNull(20, 0)); //$NON-NLS-1$
		contentPainel.add(Messages.getString("PlusPainelDiscenteLista.12"), contentPainelBotao); //$NON-NLS-1$

		controleSuperior.add(Messages.getString("PlusPainelDiscenteLista.13"), contentPainel); //$NON-NLS-1$
		controleSuperior.setBorder(BorderFactory
				.createTitledBorder(BorderFactory.createSoftBevelBorder(2)));

		contendControl.add(Messages.getString("PlusPainelDiscenteLista.14"), controleSuperior); //$NON-NLS-1$
		contendControl.add(Messages.getString("PlusPainelDiscenteLista.15"), editPanel.painelNull(20, 0)); //$NON-NLS-1$
		contendControl.add(Messages.getString("PlusPainelDiscenteLista.16"), editPanel.painelNull(20, 0)); //$NON-NLS-1$
		contendControl.add(Messages.getString("PlusPainelDiscenteLista.17"), editPanel.painelNull(0, 20)); //$NON-NLS-1$
		contendControl.add(Messages.getString("PlusPainelDiscenteLista.18"), editPanel.painelNull(0, 20)); //$NON-NLS-1$

		painelInternoNorte.add(Messages.getString("PlusPainelDiscenteLista.19"), contendControl); //$NON-NLS-1$

		return painelInternoNorte;
	}

	private JPanel painelTable() {
		eventos();
		// carregando modelo da tabela.
		tabela.setModel(evento.modeloAlunoTable);

		scroll.setPreferredSize(new Dimension(0, 200)); // Define o tamanho da
														// tabela.
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);

		scroll.setViewportView(tabela); // insere a tabela no painel Scroll

		painelTabela.add(Messages.getString("PlusPainelDiscenteLista.20"), editPanel.painelNull(0, 10)); //$NON-NLS-1$
		painelTabela.add(Messages.getString("PlusPainelDiscenteLista.21"), //$NON-NLS-1$
				table.organizandoColunasTables(evento.modeloAlunoTable));
		painelTabela.add(Messages.getString("PlusPainelDiscenteLista.22"), editPanel.painelNull(0, 10)); //$NON-NLS-1$

		return painelTabela;
	}
}
