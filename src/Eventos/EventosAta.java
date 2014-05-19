package Eventos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import ComponentGroupPlus.MaskFormatterGroup;
import ComponentGroupPlus.PainelTabela;
import ExceptionSLDA.erroNullRequisitoException;
import Forms.MainJFrame;
import Model.Ata;
import PrimaryKey.AtaPK;
import TablesModel.AtaTableModel;

/**
 * Classe responsavel pelos eventos do painelAta
 * $$
 * @author Walysson Oliveira
 * @author Adryano Escorcio
 * @version 2.0
 * @extends EventoPadrão
 **/

public class EventosAta extends EventosPadrao {

	//OBJETO UTILIZADO NAS BUSCAS
	private Ata ataPesquisa = new Ata();
	
	private MainJFrame main;

	//TABELA
	protected PainelTabela table = new PainelTabela();
	protected JTable tabela = table.getTabela();
	protected List<Ata> lista = daoAta.getTodasAtas();
	protected AtaTableModel modeloAta = new AtaTableModel(lista);

	// Objeto Mask
	protected MaskFormatterGroup mask = new MaskFormatterGroup();

	//COMPONENTES NECESSÁRIOS
	protected JTextField tfTurma = new JTextField();
	protected JFormattedTextField ftAno = new JFormattedTextField(mask.getMascaraAno());
	protected JComboBox<String> comboTurno = comboGroup.getComboBoxTurno();
	protected JComboBox<String> comboEnsino  = comboGroup.getComboBoxEnsinoFUNDAMENTAL();
	protected JComboBox<String> comboModalidade  = comboGroup.getComboBoxEnsinoMF();

	protected AtaPK pk = new AtaPK(); // chave primaria da ata.

	public EventosAta(MainJFrame main) {
		this.main = main;
		btnAlterar.setEnabled(false); // necessario a pesquisa para ativar botão
		btnExcluir.setEnabled(false); // necessario a pesquisa para ativar botão
	}

	@Override
	public void limparCampos() {

		tfTurma.setText("");
		ftAno.setText("");
		aluno = null;
		ata = null;
		tfDiscente.setText("");
		comboTurno.setSelectedIndex(0);
		comboModalidade.setSelectedIndex(0);
		comboEnsino.setSelectedIndex(0);

		//RESCONTRÓI A TABELA CASO ELA TENHA SIDO REDUZIDA NA BUSCA 
		lista = daoAta.getTodasAtas();
		modeloAta = new AtaTableModel(lista);
		tabela.setModel(modeloAta);
	
		setMudarPerfil(false);
		habilitarBotoes(false);

	}
	
	public MainJFrame getMain() {
		return main;
	}

	public void setMain(MainJFrame main) {
		this.main = main;
	}
	
	public void setMudarPerfil(boolean bool) {
		btnSalvar.setEnabled(!bool);
		btnAlterar.setEnabled(!bool);
		btnExcluir.setEnabled(!bool);
		
		btnRetirar.setEnabled(bool);
		btnInserir.setEnabled(bool);
		
		tfTurma.setEditable(!bool);
		ftAno.setEditable(!bool);
		
		comboEnsino.setEnabled(!bool);
		comboModalidade.setEnabled(!bool);
		comboTurno.setEnabled(!bool);
		
	}

	@Override
	public Object getValoresDosCampos() {
		ata = new Ata();
		ata.setCodigo((String)comboTurno.getSelectedItem(), tfTurma.getText(), mask.verificarMascara(ftAno));
		ata.setModalidadeAta((String)comboModalidade.getSelectedItem());
		ata.setEnsinoAta((String)comboEnsino.getSelectedItem());

		return ata;
	}

	@Override
	public void setValoresDosCampos(Object objeto) {
		ata = (Ata) objeto;

		tfTurma.setText(ata.getTurmaAta());
		comboTurno.setSelectedItem(ata.getTurnoAta());
		ftAno.setText(ata.getAnoAta());
		comboModalidade.setSelectedItem(ata.getModalidadeAta());
		comboEnsino.setSelectedItem(ata.getEnsinoAta());
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

	/**
	 * Necessário verificar se houve alteração para poder atualiza a ata modificada.
	 **/
	protected ActionListener onClickAterarAta = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			ata = (Ata) getValoresDosCampos();

			if(!ata.toString().equals(ataPesquisa.toString())) {
				if(daoAta.save(ata)) {
					JOptionPane.showMessageDialog(null, SUCESSO);
					modeloAta.updateContato(ataPesquisa, ata);
					limparCampos();					
				}		
			} else {
				JOptionPane.showMessageDialog(null, "(AT01) Não houve modificação.","ATENÇÃO AT01", 
						JOptionPane.WARNING_MESSAGE);
			}
		}
	};

	/**
	 * Metodo com a função de salvar e alterar uma caixa.
	 **/
	protected ActionListener onClickSalvarAta = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			ata = (Ata) getValoresDosCampos();
			pk.setCodigo(ata.getTurmaAta(), ata.getTurnoAta(), ata.getAnoAta()); // seta a chave

			try{
				daoAta.buscar(pk).getCodigoKEY(); // realiza a busca no banco de dados
				throw new erroNullRequisitoException("(ER04) Esta Ata já existe.", "ERRO ER04");
			}catch(NullPointerException exc){

				if(daoAta.save(ata)) {
					JOptionPane.showMessageDialog(null, SUCESSO);
					modeloAta.addContato(ata); // Insere a ata na tabela da tela ATA.
					limparCampos();

				}		
			}
		}
	};

	/***
	 * Metodo com  a função de buscar um caixa
	 */
	protected ActionListener onClickBuscarAta = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			String ano = tfLocalizar.getText().trim(); // pega o codigo digitado pelo cliente.

			try{
				List<Ata> atas = daoAta.getAtasByYear(ano); 
				modeloAta = new AtaTableModel(atas);
				tabela.setModel(modeloAta);

			}catch(NullPointerException exc){
				throw new erroNullRequisitoException("(ER03) Nenhuma Ata com ano: \"" +ano+ "\" foi encontrada.", "ERRO ER03");
			}
		}
	};
	
	protected ActionListener onClickInitInserir = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			PlusEventoDiscenteAta disAta = new PlusEventoDiscenteAta(EventosAta.this);
			disAta.onClickSalvarAtaResultado();
			main.direcionarParaCamada(0);
			main.atualizarTabelaAluno(aluno);
		}
	};
	
	protected ActionListener onClickRetirarAtaResultado= new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			PlusEventoDiscenteAta disAta = new PlusEventoDiscenteAta(EventosAta.this);
			disAta.onClickRetirarAtaResultado();
			main.direcionarParaCamada(0);
			main.atualizarTabelaAluno(aluno);
		}
	};

	/**
	 * Metodo com a função de excluir uma caixa
	 **/
	protected ActionListener onClickExcluirAta = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {			
			if(JOptionPane.showConfirmDialog(null, "Deseja excluir a ata?") == 0) {
				daoAta.remover(ataPesquisa);
				daoAtaResultado.excluirPorAta(ataPesquisa);
				JOptionPane.showMessageDialog(null, "Ata excluída com sucesso.");
				modeloAta.removeContato(ataPesquisa);
				limparCampos();
			}
		}
	};

	protected ItemListener onClickChangeModalidade = new ItemListener() {
		@Override
		public void itemStateChanged(ItemEvent ev) {
			//SE FUNDAMENTAL ESSE METODO RECONTRÓI O COMBO
			if(comboModalidade.getSelectedIndex() == 0){
				comboEnsino.removeAllItems();
				comboEnsino.addItem("REGULAR");
				comboEnsino.addItem("ACELERAÇÃO");
				comboEnsino.addItem("AVANÇADO");
				comboEnsino.addItem("CLASSE ESPECIAL");
				comboEnsino.addItem("EJA");

				//SE MEDIO ESSE METODO RECONTRÓI O COMBO	
			} else if(comboModalidade.getSelectedIndex() == 1){
				comboEnsino.removeAllItems();
				comboEnsino.addItem("REGULAR");
				comboEnsino.addItem("EJA");
				comboEnsino.addItem("PROEJA");
				comboEnsino.addItem("TÉC. CONTABILIDADE");
			}	
		}
	};

	protected MouseListener onClickRowTable = new MouseListener() {

		@Override
		public void mouseClicked(MouseEvent e) {
			if(e.getClickCount() == 2){
				int linha = tabela.getSelectedRow();
				ataPesquisa = modeloAta.getContato(linha);
				setValoresDosCampos(ataPesquisa);
				
				if (aluno == null) {
					habilitarBotoes(true);
				} else {
					desabilitarTudoFormulario();
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

	//METODO PARA HABILITAR OU DESABILITAR OS BOTOES QUE INICIAM Enabled E TAMBÉM OUTROS COMPONENTES NECESSÁRIOS
	public void habilitarBotoes(boolean bool) {

		btnAlterar.setEnabled(bool); 
		btnExcluir.setEnabled(bool);
		btnSalvar.setEnabled(!bool); 
		tfTurma.setEditable(!bool); 
		ftAno.setEditable(!bool); 
		comboTurno.setEnabled(!bool);
	}

	protected void desabilitarTudoFormulario() {
		tfTurma.setEditable(false); // nao sera possivel alterar o codigo de objeto consultado.
		ftAno.setEditable(false); // nao sera possivel alterar o codigo de objeto consultado.
		comboTurno.setEnabled(false);
		comboModalidade.setEnabled(false);
		comboEnsino.setEnabled(false);
	}

}
