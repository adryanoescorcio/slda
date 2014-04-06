package Eventos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import ComponentGroupPlus.MaskFormatterGroup;
import Model.Ata;
import TablesModel.AtaTableModel;

/**
 * Classe responsavel pelos eventos do painelAta
 * 
 * @author Walysson Oliveira
 * @author Adryano Escorcio
 * @version 2.0
 * @extends EventoPadrão
 **/
public class EventosAta extends EventosPadrão {

	//TABELA
	protected List<Ata> lista = daoAta.getTodasAtas();
	protected AtaTableModel modelo = new AtaTableModel(lista);
	
	// Objeto Mask
	MaskFormatterGroup mask = new MaskFormatterGroup();
	
	//COMPONENTES NECESSÁRIOS
	protected JTextField tfTurma = new JTextField();
	protected JFormattedTextField ftAno = new JFormattedTextField(mask.getMascaraAno());
	protected JComboBox<String> comboTurno = comboGroup.getComboBoxTurno(); 
	protected JComboBox<String> comboModalidade = comboGroup.getComboBoxModalidade();
	protected JComboBox<String> comboEnsino  = comboGroup.getComboBoxEnsino();
	
	public EventosAta() {
		btnAlterar.setEnabled(false); // necessario a pesquisa para ativar botão
		btnExcluir.setEnabled(false); // necessario a pesquisa para ativar botão
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
	public Object getValoresDosCampos() {
		Ata ata = new Ata();
		ata.setCodigo((String)comboTurno.getSelectedItem(), tfTurma.getText(), ftAno.getText());
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
			Ata ata2 = daoAta.buscar(ata.getCodigoKEY());
			
			if(!ata.toString().equals(ata2.toString())) {
				metodoSalvar();
				
			} else {
				JOptionPane.showMessageDialog(null, "(AT01) Não houve modificação.","ATENÇÃO AT01", 
						JOptionPane.WARNING_MESSAGE);
			}
		}
	};
	
	private void metodoSalvar() {
		// Tentar pegar os valores
		ata = (Ata) getValoresDosCampos();
		
		// Caso seja salvo com sucesso
		if(daoAta.save(ata)) {
			JOptionPane.showMessageDialog(null, SUCESSO);
			modelo.addContato(ata); // Insere a caixa na tabela.
			limparCampos();
			
			//LIMPA A ATA
			ata = null;
		}		
	}
	/**
	 * Metodo com a função de salvar e alterar uma caixa.
	 **/
	protected ActionListener onClickSalvarAta = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			metodoSalvar();
		}
	};

	/***
	 * Metodo com  a função de buscar um caixa
	 
	protected ActionListener onClickBuscarAta = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			String codigoLocalizar = tfLocalizar.getText().trim(); // pega o codigo digitado pelo cliente.

			AtaPK pk = new AtaPK(); // chave primaria da caixa.
			pk.setCodigo(codigoLocalizar); // seta a chave

			try{
				Ata at = daoAta.buscar(pk); // realiza a busca no banco de dados
				setValoresDosCampos(at); // atribui os valores recuperados para os campos.
				btnAlterar.setEnabled(true); // necessario a pesquisa para ativar botão
				btnExcluir.setEnabled(true); // necessario a pesquisa para ativar botão
				
				btnSalvar.setEnabled(false); // nao sera possivel salvar, somente alterar
				tfCodigo.setEditable(false); // nao sera possivel alterar o codigo de objeto consultado.
				
				ata = at;
			
			}catch(NullPointerException exc){
				throw new erroNullRequisitoException("(ER03) Nenhuma Ata \"" +codigoLocalizar+ "\" foi encontrada.", "ERRO ER03",null);
			}
		}
	};
*/
	
	/**
	 * Metodo com a função de excluir uma caixa
	 **/
	protected ActionListener onClickExcluirAta = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {			
			daoAta.remover(ata);
			JOptionPane.showMessageDialog(null, "Ata excluída com sucesso.");
			limparCampos();
		}
	};


}
