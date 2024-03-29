package Eventos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

import ComponentGroupPlus.MaskFormatterGroup;
import ComponentGroupPlus.PainelTabela;
import ExceptionSLDA.erroNullRequisitoException;
import Model.Aluno;
import Model.Ata;
import Model.AtaResultado;

public class PlusEventoDiscenteLista extends EventosPadrao {

	// Objeto Mask
	protected MaskFormatterGroup mask = new MaskFormatterGroup();

	protected JTextField tfRefCaixa = new JTextField();
	protected JTextField tfLocaInter = new JTextField();
	protected PainelTabela table = new PainelTabela();
	protected JTable tabela = table.getTabela();

	protected JFormattedTextField ftData;
	protected JComboBox<String> comboBoxSubSecao = comboGroup.getComboBoxSubSecao();

	private JPanel main;
	protected List<Ata> listaAta;
	protected Ata ultimaAtaList;

	protected AtaResultado ataResultadoGlobal;

	protected EventosAluno evento;

	public PlusEventoDiscenteLista(JPanel main, EventosAluno evento) {
		this.evento = evento;
		this.main = main;
		this.aluno = evento.getAluno();
	}

	protected ActionListener onClickCancelar = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			finalizeOperation();
		}
	};

	protected ActionListener onClickSalvar = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			try{
				Aluno aluno = evento.modeloAlunoTable.getContato(
						tabela.getSelectedRow());
				evento.processoMostarAluno(aluno);
				finalizeOperation();
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, "Selecione um aluno na tabela.", "ER09", JOptionPane.ERROR_MESSAGE);
			}
		}
	};

	//OBJETO QUE REALIZA UMA BUSCA ATRAV�S DAS LINHAS DA TABELA
		protected MouseListener onClickRowTable = new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount() == 2){
					try{
						Aluno aluno = evento.modeloAlunoTable.getContato(
								tabela.getSelectedRow());
						evento.processoMostarAluno(aluno);
						finalizeOperation();
					} catch (Exception ex) {
						JOptionPane.showMessageDialog(null, "Selecione um aluno na tabela.", "ER09", JOptionPane.ERROR_MESSAGE);
					}
				}
			}

			@Override
			public void mouseEntered(MouseEvent e) {}
			@Override
			public void mouseExited(MouseEvent e) {}
			@Override
			public void mousePressed(MouseEvent e) {}
			@Override
			public void mouseReleased(MouseEvent e) {}
		};

	
	public void setMainJDialog(JPanel mainJDialog) {
		this.main = mainJDialog;
	}

	protected void finalizeOperation() {
		evento.normalizarCamadas();
		main.removeAll();		
	}

	@Override
	public void limparCampos() {
		// TODO Auto-generated method stub
	}

	@Override
	public Object getValoresDosCampos() throws erroNullRequisitoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setValoresDosCampos(Object object) {
		// TODO Auto-generated method stub

	}

}
