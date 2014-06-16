package ComponentGroupPlus;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Label;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class EditPanelGroup {

	// Intervalo para o Random
	protected BorderLayout LAYOUT = new BorderLayout(1, 1);

	public Label getTitulo(final String titulo) {
		final Label nome = new Label(titulo);
		nome.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 19));

		return nome;
	}

	/**
	 * Cria um painel Content para limitar horizontalmente o tamanho dos
	 * componentes ao maximo.
	 **/
	public JPanel painelContentComponent(final String lado,
			final Component componente) {
		final JPanel painelContent = new JPanel(new BorderLayout());
		painelContent.add(lado, componente);

		return painelContent;
	}

	public JPanel painelContentComponent(final String lado,
			final Component componente1, final Component componente2) {
		final JPanel painelContent1 = new JPanel(new GridLayout(1, 2));
		final JPanel painelContent2 = new JPanel(new BorderLayout());
		painelContent1.add(componente1);
		painelContent1.add(componente2);
		painelContent2.add(lado, painelContent1);

		return painelContent2;
	}

	/**
	 * Painel especifico para a criação de botões de pesquisa parte inferior
	 **/
	public JPanel painelLocaliza(final JLabel titulo,
			final JTextField localizar, final JButton search) {
		final JPanel painelLocalizar = new JPanel(new GridLayout(1, 2, 2, 2));
		final JPanel painelContentLocalizar = new JPanel(new BorderLayout(2, 2));
		final JPanel painelBtnSearch = new JPanel(new BorderLayout(2, 2));

		painelLocalizar.add(painelContentComponent(Messages.getString("EditPanelGroup.0"), titulo)); //$NON-NLS-1$
		painelLocalizar.add(painelContentComponent(Messages.getString("EditPanelGroup.1"), localizar)); //$NON-NLS-1$
		painelBtnSearch.add(Messages.getString("EditPanelGroup.2"), painelLocalizar); //$NON-NLS-1$
		painelBtnSearch.add(Messages.getString("EditPanelGroup.3"), painelContentComponent(Messages.getString("EditPanelGroup.4"), search)); //$NON-NLS-1$ //$NON-NLS-2$

		painelContentLocalizar.add(Messages.getString("EditPanelGroup.5"), painelNull(0, 1)); //$NON-NLS-1$
		painelContentLocalizar.add(Messages.getString("EditPanelGroup.6"), painelNull(0, 1)); //$NON-NLS-1$
		painelContentLocalizar.add(Messages.getString("EditPanelGroup.7"), painelBtnSearch); //$NON-NLS-1$

		return painelContentLocalizar;
	}

	/**
	 * Criar um painel vazio.
	 **/
	public JPanel painelNull(final int i, final int j) {
		final JPanel painelNull = new JPanel();
		painelNull.setPreferredSize(new Dimension(i, j));

		return painelNull;
	}

}
