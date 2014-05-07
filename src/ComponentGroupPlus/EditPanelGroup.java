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
	protected BorderLayout LAYOUT = new BorderLayout(1,1);
	
	public Label getTitulo(String titulo){
		Label nome = new Label(titulo);
		nome.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 19));
	
		return nome;
	}
	
	/**
	 * Criar um painel vazio.
	 **/
	public JPanel painelNull(int i, int j) {
		JPanel painelNull = new JPanel();
		painelNull.setPreferredSize(new Dimension(i,j));
		
		return painelNull;
	}
	
	/**
	 * Cria um painel Content para limitar horizontalmente o tamanho dos componentes ao maximo.
	 **/
	public JPanel painelContentComponent(String lado, Component componente) {
		JPanel painelContent = new JPanel(new BorderLayout());
		painelContent.add(lado,componente);
		
		return painelContent;
	}
	
	public JPanel painelContentComponent(String lado, Component componente1, Component componente2) {
		JPanel painelContent1 = new JPanel(new GridLayout(1, 2));
		JPanel painelContent2 = new JPanel(new BorderLayout());
		painelContent1.add(componente1);
		painelContent1.add(componente2);
		painelContent2.add(lado,painelContent1);
		
		return painelContent2;
	}
	
	/**
	 * Painel especifico para a criação de botões de pesquisa parte inferior
	 **/
	public JPanel painelLocaliza(JLabel titulo,JTextField localizar, JButton search) {
		JPanel painelLocalizar = new JPanel(new GridLayout(1,2,2,2));
		JPanel painelContentLocalizar = new JPanel(new BorderLayout(2,2));
		JPanel painelBtnSearch = new JPanel(new BorderLayout(2,2));
		
		painelLocalizar.add(painelContentComponent("East", titulo));
		painelLocalizar.add(painelContentComponent("West", localizar));
		painelBtnSearch.add("West", painelLocalizar);
		painelBtnSearch.add("Center", painelContentComponent("West", search));
		
		painelContentLocalizar.add("North", painelNull(0, 10));
		painelContentLocalizar.add("South", painelNull(0, 10));
		painelContentLocalizar.add("Center", painelBtnSearch);
		
		return painelContentLocalizar;
	}
	
}
