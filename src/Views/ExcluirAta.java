package Views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Label;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class ExcluirAta extends JPanel{

	JButton botaoExcluir;
	JButton botaoBuscar;
	
	JTextField tf1 = new JTextField();
	JTextField tf2 = new JTextField();
	JTextField tf3 = new JTextField();
	JTextField tf4 = new JTextField();
	JTextField tf5 = new JTextField();
	JTextField tf6 = new JTextField();
	
	public ExcluirAta() {

		setLayout(new BorderLayout());
		
		botaoExcluir = new JButton("Excluir");
		botaoBuscar = new JButton("Buscar");
		
		JPanel centro = new JPanel();
		centro.setLayout(new GridLayout(20, 4, 5, 5));
		centro.setBackground(Color.WHITE);
		
		JPanel linha = new JPanel();
		linha.setLayout(new GridLayout(1, 2, 5, 5));
		linha.setBackground(Color.WHITE);
		
		JPanel linha1 = new JPanel();
		linha1.setLayout(new GridLayout(1, 2, 5, 5));
		linha1.setBackground(Color.WHITE);
		
		JPanel linha2 = new JPanel();
		linha2.setLayout(new GridLayout(1, 2, 5, 5));
		linha2.setBackground(Color.WHITE);
		
		JPanel linha3 = new JPanel();
		linha3.setLayout(new GridLayout(1, 2, 5, 5));
		linha3.setBackground(Color.WHITE);
		
		JPanel linha4 = new JPanel();
		linha4.setLayout(new GridLayout(1, 2, 5, 5));
		linha4.setBackground(Color.WHITE);
		
		JPanel linha5 = new JPanel();
		linha5.setLayout(new GridLayout(1, 2, 5, 5));
		linha5.setBackground(Color.WHITE);
		
		JPanel linha6 = new JPanel();
		linha6.setLayout(new GridLayout(1, 2, 5, 5));
		linha6.setBackground(Color.WHITE);
		
		Label nome = new Label("Ata");
		nome.setFont(new Font("san_serif", Font.BOLD, 22));
		nome.setForeground(Color.GRAY);
	
		linha.add(botaoBuscar);									linha.add(new Label(""));
		linha1.add(new JLabel("Turma:"));						linha1.add(tf1);						
		linha2.add(new JLabel("Turno:"));						linha2.add(tf2);						
		linha3.add(new JLabel("Ano:"));							linha3.add(tf3);						
		linha4.add(new JLabel("Modalidade de Ensino:"));		linha4.add(tf4);						
		linha5.add(new JLabel("Grau de Ensino:"));				linha5.add(tf5);
		linha6.add(new Label(""));								linha6.add(botaoExcluir);								
		
		centro.add(new Label(""));			centro.add(new Label(""));					centro.add(new Label(""));		centro.add(new Label(""));
		centro.add(new Label(""));			centro.add(linha1);							centro.add(new JLabel(""));		centro.add(new Label(""));	
		centro.add(new Label(""));			centro.add(linha2);							centro.add(new JLabel(""));		centro.add(new Label(""));
		centro.add(new Label(""));			centro.add(linha3);							centro.add(linha);				centro.add(new Label(""));
		centro.add(new Label(""));			centro.add(new JLabel(""));					centro.add(new JLabel(""));		centro.add(new Label(""));
		centro.add(new Label(""));			centro.add(nome);							centro.add(new Label(""));		centro.add(new Label(""));			
		centro.add(new Label(""));			centro.add(new Label(""));					centro.add(new Label(""));		centro.add(new Label(""));
		centro.add(new Label(""));			centro.add(linha4);							centro.add(new Label(""));		centro.add(new Label(""));
		centro.add(new Label(""));			centro.add(linha5);							centro.add(new JLabel(""));		centro.add(new Label(""));
		centro.add(new Label(""));			centro.add(new JLabel(""));					centro.add(new JLabel(""));		centro.add(new Label(""));
		centro.add(new Label(""));			centro.add(linha6);							centro.add(new JLabel(""));				centro.add(new Label(""));
		centro.add(new Label(""));			centro.add(new JLabel(""));					centro.add(new JLabel(""));		centro.add(new Label(""));
		centro.add(new Label(""));			centro.add(new JLabel(""));					centro.add(new JLabel(""));		centro.add(new Label(""));
		centro.add(new Label(""));			centro.add(new JLabel(""));					centro.add(new JLabel(""));		centro.add(new Label(""));
		centro.add(new Label(""));			centro.add(new JLabel(""));					centro.add(new JLabel(""));		centro.add(new Label(""));
		centro.add(new Label(""));			centro.add(new JLabel(""));					centro.add(new JLabel(""));		centro.add(new Label(""));
		centro.add(new Label(""));			centro.add(new JLabel(""));					centro.add(new JLabel(""));		centro.add(new Label(""));
			
		add(centro, BorderLayout.CENTER);
		setBackground(Color.WHITE);

	}

}
