package Forms.Crud.Arquivo;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import Forms.TelaPadrao;
import Forms.TablesModel.CaixaTableModel;
import Model.Caixa;

@SuppressWarnings("serial")
public class LocalizarArquivo2 extends TelaPadrao  {

	private static final int DIST = 5;
	
	private JPanel painelEsquerdo = new JPanel(new GridLayout(4,1,DIST,DIST));
	private JPanel painelDireito = new JPanel(new GridLayout(4,1,DIST,DIST));
	
	private JScrollPane scroll = new JScrollPane();
	
	private JLabel lbCodigo = new JLabel("Codigo Caixa: ");
	private JLabel lbCodigo2 = new JLabel("Codigo Caixa: ");
	private JLabel lbTurno = new JLabel("Turno: ");
	private JLabel lbLetra = new JLabel("Letra: ");
	private JLabel lbStatus = new JLabel("Status: ");
	
	private JTextField tfCodigo = new JTextField();
	private JTextField tfLocalizar = new JTextField();
	
	private ImageIcon icone = new ImageIcon(DIR_ICONES+"search.png");

	private JButton btnSalvar = new JButton("Salvar");
	private JButton btnLimpar = new JButton("Limpar");
	private JButton btnExcluir = new JButton("Excluir");
	private JButton btnAlterar = new JButton("Alterar");
	private JButton btnPesquisar = new JButton(icone);

	private ArrayList<Caixa> lista = new ArrayList<Caixa>();
	private CaixaTableModel modelo = new CaixaTableModel(lista);
	private JTable tabela = new JTable(modelo);
	private GridBagConstraints regras = new GridBagConstraints();

	public LocalizarArquivo2() {
		
		setLayout(new GridBagLayout());
		
		painelEsquerdo.setPreferredSize(new Dimension(100,0));
		painelEsquerdo.add(lbCodigo);
		painelEsquerdo.add(lbTurno);
		painelEsquerdo.add(lbLetra);
		painelEsquerdo.add(lbStatus);
		
		painelDireito.add(tfCodigo);
		painelDireito.add(painelContentComponent("West", getComboBoxTurno()));
		painelDireito.add(painelContentComponent("West", getComboBoxLetra()));
		painelDireito.add(painelContentComponent("West", getComboBoxStatus()));
		
		alterarFontes();
	//	painelInternoNorte();
	//	telaPrincipal();
	}
	
	private void alterarFontes() {
		lbCodigo.setFont(font_PLA_15);
		lbCodigo2.setFont(font_PLA_15);
		lbLetra.setFont(font_PLA_15);
		lbTurno.setFont(font_PLA_15);
		lbStatus.setFont(font_PLA_15);
		
		tfCodigo.setFont(font_NEG_15);
		tfLocalizar.setFont(font_NEG_15);
		
		btnSalvar.setFont(font_PLA_15);
		btnPesquisar.setFont(font_PLA_15);
		btnLimpar.setFont(font_PLA_15);
		btnAlterar.setFont(font_PLA_15);
		btnExcluir.setFont(font_PLA_15);
		
		btnPesquisar.setPreferredSize(new Dimension(25,25));
		btnPesquisar.setRolloverEnabled(false);
	}

}
