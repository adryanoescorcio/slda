package Eventos;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import Forms.TablesModel.CaixaTableModel;
import Model.Caixa;

@SuppressWarnings("serial")
public class EventosCaixa extends EventosPadrão{


	private static final int DIST = 5;

	protected JPanel mainJPanel = new JPanel(new BorderLayout(2,2));
	protected JPanel painelLocalizarArquivo = new JPanel(new BorderLayout(2,2));
	protected JPanel painelInternoNorte = new JPanel(new BorderLayout(2,2));
	protected JPanel painelInternoSul = new JPanel(new BorderLayout(2,2));
	protected JPanel painelEsquerdo = new JPanel(new GridLayout(4,1,DIST,DIST));
	protected JPanel painelDireito = new JPanel(new GridLayout(4,1,DIST,DIST));
	protected JPanel painelTabela= new JPanel(new BorderLayout(2,2));	
	
	protected JScrollPane scroll = new JScrollPane();
	
	protected JLabel lbCodigo = new JLabel("Codigo Caixa: ");
	protected JLabel lbCodigo2 = new JLabel("Codigo Caixa: ");
	protected JLabel lbTurno = new JLabel("Turno: ");
	protected JLabel lbLetra = new JLabel("Letra: ");
	protected JLabel lbStatus = new JLabel("Status: ");
	
	protected JTextField tfCodigo = new JTextField();
	protected JTextField tfLocalizar = new JTextField();
	
	protected ImageIcon icone = new ImageIcon(padrao.DIR_ICONES+"search.png");

	protected JButton btnSalvar = new JButton("Salvar");
	protected JButton btnLimpar = new JButton("Limpar");
	protected JButton btnExcluir = new JButton("Excluir");
	protected JButton btnAlterar = new JButton("Alterar");
	protected JButton btnPesquisar = new JButton(icone);

	protected ArrayList<Caixa> lista = new ArrayList<Caixa>();
	protected CaixaTableModel modelo = new CaixaTableModel(lista);
	protected JTable tabela = new JTable(modelo);
		
	@Override
	public void limparCampos() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Object getValoresDosCampos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setValoresDosCampos(Object object) {
		// TODO Auto-generated method stub
		
	}

}
