package Eventos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JPanel;
import javax.swing.JTextField;

import ComponentGroupPlus.MaskFormatterGroup;
import ExceptionSLDA.erroNullRequisitoException;
import Model.Ata;
import Model.AtaResultado;

public class PlusEventoDiscenteLista extends EventosPadrao{
	
	// Objeto Mask
		protected MaskFormatterGroup mask = new MaskFormatterGroup();
		
		protected JTextField tfRefCaixa = new JTextField();
		protected JTextField tfLocaInter = new JTextField();
		
		protected JFormattedTextField ftData;
		protected JComboBox<String> comboBoxSubSecao = comboGroup.getComboBoxSubSecao();
		
		private JPanel mainJDialog;
		protected List<Ata> listaAta;
		protected Ata ultimaAtaList;
		
		protected AtaResultado ataResultadoGlobal;

		protected EventosAluno evento;

	public PlusEventoDiscenteLista(JPanel mainDialog, EventosAluno evento) {
		this.evento = evento;
		this.setMainJDialog(mainDialog);
		this.aluno = evento.getAluno();
	}

	protected ActionListener onClickCancelar = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			evento.normalizarCamadas();
			mainJDialog.removeAll();
		}
	};
	
	protected ActionListener onClickSalvar = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			//TODO
		}
	};
	
	
	public void setMainJDialog(JPanel mainJDialog) {
		this.mainJDialog = mainJDialog;
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
