package Eventos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import ComponentGroupPlus.MaskFormatterGroup;
import ExceptionSLDA.erroNullRequisitoException;
import Model.Ata;
import Model.AtaResultado;

public class EventoDiscenteAta extends EventosPadrão {
	
	// Objeto Mask
	protected MaskFormatterGroup mask = new MaskFormatterGroup();
	
	protected JTextField tfTurma = new JTextField();
	protected JFormattedTextField ftAno;
	protected JComboBox<String> comboTurno;
	protected JComboBox<String> comboModalidade;
	protected JComboBox<String> comboEnsino;
	protected JButton btnUltimaAta = new JButton(icone.getIconeAta());

	private JPanel mainJDialog;
	protected List<Ata> listaAta;
	protected Ata ultimaAtaList;

	private EventosAluno evento;
	
	public EventoDiscenteAta(JPanel mainDialog, EventosAluno evAluno) {
		this.evento = evAluno;
		initVar();
		this.setMainJDialog(mainDialog);
		this.aluno = evAluno.getAluno();
		
		setListaAta(daoAta.getTodasAtas()); // pega todas do banco de dados
		ultimaAtaList = listaAta.get(listaAta.size()-1); // pega a ultima ata da lista
		setValoresDosCampos(ultimaAtaList);
	}
	
	/**
	 * Inicializar a variaveis
	 **/
	private void initVar() {
		tfTurma = new JTextField();
		ftAno = new JFormattedTextField(mask.getMascaraAno());
		comboTurno = comboGroup.getComboBoxTurno();
		comboModalidade = comboGroup.getComboBoxModalidade();
		comboEnsino  = comboGroup.getComboBoxEnsino();
	}

	public List<Ata> getListaAta() {
		return listaAta;
	}

	public void setListaAta(List<Ata> listaAta) {
		this.listaAta = listaAta;
	}
	
	@Override
	public void limparCampos() {
		tfTurma.setText("");
		ftAno.setText("");
		comboTurno.setSelectedIndex(0);
		comboModalidade.setSelectedIndex(0);
		comboEnsino.setSelectedIndex(0);
	}

	@Override
	public Object getValoresDosCampos() throws erroNullRequisitoException {
		Ata ata = new Ata();
		
		ata.setCodigo((String)comboTurno.getSelectedItem(), 
				tfTurma.getText(), mask.verificarMascara(ftAno));
		
		ata.setModalidadeAta((String)comboModalidade.getSelectedItem());
		ata.setEnsinoAta((String)comboEnsino.getSelectedItem());
		
		return ata;
	}

	@Override
	public void setValoresDosCampos(Object object) {
		Ata ataLocal = (Ata) object;
		
		tfTurma.setText(ataLocal.getTurmaAta());
		comboTurno.setSelectedItem(ataLocal.getTurnoAta());
		ftAno.setText(ataLocal.getAnoAta());
		comboModalidade.setSelectedItem(ataLocal.getModalidadeAta());
		comboEnsino.setSelectedItem(ataLocal.getEnsinoAta());
	}
	
	public JPanel getMainJDialog() {
		return mainJDialog;
	}

	public void setMainJDialog(JPanel mainDialog) {
		this.mainJDialog = mainDialog;
	}

	/**
	 * Metodos que realiza a função de limpar os campos.
	 **/
	protected ActionListener onClickLimparCampos = new ActionListener() {	
		@Override
		public void actionPerformed(ActionEvent e) {
			limparCampos();
		}
	};
	
	protected ActionListener onClickSalvarAtaResultado = new ActionListener() {	
		@Override
		public void actionPerformed(ActionEvent e) {
			AtaResultado ataResul = new AtaResultado(); // cria o objeto de resultados
			ataResul.setAluno(aluno.getCodigo()); // passa o codigo do aluno
			
			try {
				// verificar se a ata existe no banco de dados
				if(validaAta(
						(Ata) getValoresDosCampos())) {
					
					// inseri todas as informações da ata.
					ataResul.setAta(
							(Ata) getValoresDosCampos());
					
					daoAtaResultado.save(ataResul); //salva a entidade
					finallyOperation();
				} else {
					new erroNullRequisitoException("Ata não foi cadastrada, insira a nova ata no banco de dados.", "ER04" ,null);
				}
			} catch (Exception ex) {
				new erroNullRequisitoException("Errou de inserção. Verifique os dados inseridos ou se o aluno já foi inserido nesta Ata.","ER05",null);
			}
		}
	};
	
	protected ActionListener onClickCancelarOperacao = new ActionListener() {	
		@Override
		public void actionPerformed(ActionEvent e) {
			evento.normalizarCamadas();
			mainJDialog.removeAll();
		}
	};

	protected boolean validaAta(Ata ataTest) {
		int i = listaAta.size()-1; // pega todos os elementos da lista
		boolean boo = true;

		while (i >=0 && boo) { // inicia do ultimo elemento para o primeiro
			// compara todos.
			boo = !(listaAta.get(i).toString().equals(ataTest.toString())); // caso encontre (true) ele retorna falso para acabar com o loop
		}
		return !boo; // retorna o resultado final. encontrou ou nao? true ou falso.
	}

	/**
	 * Metodo que encerra operação da aplicação em caso de sucesso
	 **/
	protected void finallyOperation() {
		JOptionPane.showMessageDialog(null, "Operação realizada com sucesso.");
		evento.normalizarCamadas();
		mainJDialog.removeAll();
	}

}
