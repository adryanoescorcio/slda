package Eventos;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import ComponentGroupPlus.MaskFormatterGroup;
import ExceptionSLDA.erroNullRequisitoException;
import Model.Ata;
import Model.AtaResultado;
import Model.InterfacePadraoAta;

public class EventoDiscenteAta extends EventosPadrão {
	
	// Objeto Mask
	protected MaskFormatterGroup mask = new MaskFormatterGroup();
	
	protected JTextField tfTurma = new JTextField();
	protected JFormattedTextField ftAno;
	protected JComboBox<String> comboTurno;
	protected JComboBox<String> comboModalidade;
	protected JComboBox<String> comboEnsino;
	protected JComboBox<Integer> comboOrdem = new JComboBox<Integer>();
	
//	protected JButton btnUltimaAta = new JButton(icone.getIconeAta());

	private JPanel mainJDialog;
	protected List<Ata> listaAta;
	protected Ata ultimaAtaList;
	
	protected AtaResultado ataResultadoGlobal;

	protected EventosAluno evento;
	
	public EventoDiscenteAta(JPanel mainDialog, EventosAluno evAluno) {
		this.evento = evAluno;
		initVar();
		this.setMainJDialog(mainDialog);
		this.aluno = evAluno.getAluno();
		
		// pega a ultima ata inserida
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
		btnExcluir.setEnabled(false);
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
		// verifica qual o tipo de objeto que esta sendo inserido
		try {
			Ata ata = (Ata) object;
			atribuirValoresNosCampos((Ata)ata);
		} catch (Exception ex) {
			AtaResultado ataResultado = (AtaResultado) object;
			atribuirValoresNosCampos((AtaResultado)ataResultado);
		}
	}
	
	/**
	 * Metodo para inserir os valores nos campos. Aceita tanto objeto tipo ata quanto objeto tipo AtaResultado
	 **/
	private void atribuirValoresNosCampos(InterfacePadraoAta model) {
		tfTurma.setText(model.getTurmaAta());
		comboTurno.setSelectedItem(model.getTurnoAta());
		ftAno.setText(model.getAnoAta());
		comboModalidade.setSelectedItem(model.getModalidadeAta());
		comboEnsino.setSelectedItem(model.getEnsinoAta());
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
	
	protected ActionListener onClickPesquisar = new ActionListener() {	
		@Override
		public void actionPerformed(ActionEvent e) {
			List<AtaResultado> lista = evento.getListaAtaResul(); // pega o resultado das atas com o aluno
			
			int valorComboBox = comboOrdem.getSelectedIndex(); // cria uma combox com os itens da lista sequenciados
			ataResultadoGlobal = new AtaResultado();
			
			try {
				if(valorComboBox > 0) {
					ataResultadoGlobal = lista.get(valorComboBox-1); //é retirado um para que seja contado corretamento da lista, pois a lista na combo incrementa um
					setValoresDosCampos(ataResultadoGlobal); // inserindo os valores nos campos
					btnExcluir.setEnabled(true); // ativar o botão excluir
					btnSalvar.setEnabled(false); // desativa o botão salvar do aluno
				} else {
					JOptionPane.showMessageDialog(null, "Escolha uma ata válida.");
				}
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, "Item foi excluído ou não existe.");
			}
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
					finallyOperation(); // realizando as operações apos salvar
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
	
	protected ActionListener onClickExcluir = new ActionListener() {	
		@Override
		public void actionPerformed(ActionEvent e) {
			if(JOptionPane.showConfirmDialog(null, "O aluno será retirado da Ata. Deseja continuar com a operação?") == 0) {
				daoAtaResultado.remover(ataResultadoGlobal);
				evento.tabelaAta(aluno);
				itemDaComboBox();
				JOptionPane.showMessageDialog(null, "Aluno foi retirado da ata com sucesso.");
				limparCampos();
			}
		}
	};

	protected boolean validaAta(Ata ataTest) {
		int i = listaAta.size()-1; // pega todos os elementos da lista
		boolean boo = true;

		while (i !=0 && boo) { // inicia do ultimo elemento para o primeiro
			// compara todos.
			boo = !(listaAta.get(i).toString().equals(ataTest.toString())); // caso encontre (true) ele retorna falso para acabar com o loop
			System.out.println(boo);
			i--;
		}
		return !boo; // retorna o resultado final. encontrou ou nao? true ou falso.
	}
	
	/**
	 * Pega a quantidade de item da lista de ataResultados e transforma em comoboBox
	 **/
	public JComboBox<Integer> itemComboBoxOrdem() {
		comboOrdem.setBackground(Color.white);
		comboOrdem.setFont(font.font_PLA_14);
		comboOrdem.setPreferredSize(new Dimension(50,0));
		
		itemDaComboBox();

		return comboOrdem;
	}

	private void itemDaComboBox() {
		comboOrdem.removeAllItems();
		comboOrdem.addItem(null);
		int i;
		int quantElementList = evento.getListaAtaResul().size();
		for(i=0;i<quantElementList;i++) {
			comboOrdem.addItem(i+1);
		}
		
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
