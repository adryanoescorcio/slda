package Eventos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import ExceptionSLDA.erroNullRequisitoException;
import Model.Caixa;
import PrimaryKey.CaixaPK;
import TablesModel.CaixaTableModel;

/**
 * Classe responsavel pelos eventos do painelCaixa
 * 
 * @author Walysson Oliveira
 * @author Adryano Escorcio
 * @version 2.0
 * @extends EventoPadrão
 **/
public class EventosCaixa extends EventosPadrão {
		
	//TABELA
	protected List<Caixa> lista = daoCaixa.getTodasCaixas();
	protected CaixaTableModel modelo = new CaixaTableModel(lista);
	
	//COMPONENTES NECESSÁRIOS
	protected JTextField tfCodigo = new JTextField();
	protected JComboBox<String> comboTurno = comboGroup.getComboBoxTurno();
	protected JComboBox<String> comboLetra = comboGroup.getComboBoxLetra();
	protected JComboBox<String> comboStatus = comboGroup.getComboBoxStatus();
	
	public EventosCaixa() {
		btnAlterar.setEnabled(false); // necessario a pesquisa para ativar botão
		btnExcluir.setEnabled(false); // necessario a pesquisa para ativar botão
	}
	
	@Override
	public Object getValoresDosCampos() {
		
		if(!tfCodigo.getText().trim().equals("")){
			
			caixa = new Caixa();
			caixa.setCodigo(tfCodigo.getText().trim());
			caixa.setTurno((String) comboTurno.getSelectedItem());
			caixa.setStatus((String) comboStatus.getSelectedItem());
			caixa.setLetra((String) comboLetra.getSelectedItem());
			
			return caixa;
			
		} else {
			throw new erroNullRequisitoException("(ER02) Preencha todos os requisitos com dados válidos.", "ERRO ER02",null);
		}
	}

	@Override
	public void setValoresDosCampos(Object object) throws NullPointerException {
		Caixa caixa = (Caixa) object;
		
		tfCodigo.setText(caixa.getCodigo());
		comboTurno.setSelectedItem(caixa.getTurno());
		comboLetra.setSelectedItem(caixa.getLetra());
		comboStatus.setSelectedItem(caixa.getStatus());
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
	 * Necessário verificar se houve alteração para poder atualiza a caixa modificada.
	 **/
	protected ActionListener onClickAterarCaixa = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			caixa = (Caixa) getValoresDosCampos();
			Caixa caixa2 = daoCaixa.buscar(caixa.getCodigoKEY());
			
			if(!caixa.toString().equals(caixa2.toString())) {
				
				modelo.updateContato(caixa2, caixa);
				
				//LIMPA A CAIXA
				caixa = null;
				
			} else {
				JOptionPane.showMessageDialog(null, "(AT01) Não houve modificação.","ATENÇÃO AT01", 
						JOptionPane.WARNING_MESSAGE);
			}
		}
	};
	
	private void metodoSalvar() {
		// Tentar pegar os valores
		caixa = (Caixa) getValoresDosCampos();
		
		// Caso seja salvo com sucesso
		if(daoCaixa.save(caixa)) {
			JOptionPane.showMessageDialog(null, SUCESSO);
			limparCampos();
		}		
	}
	/**
	 * Metodo com a função de salvar e alterar uma caixa.
	 **/
	protected ActionListener onClickSalvarCaixa = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			String codigo = tfCodigo.getText().trim(); // pega o codigo digitado pelo cliente.

			CaixaPK pk = new CaixaPK(); // chave primaria da caixa.
			pk.setCodigo(codigo); // seta a chave
			
			try{
				daoCaixa.buscar(pk); // realiza a busca no banco de dados
				throw new erroNullRequisitoException("(ER04) Caixa \"" +codigo+ "\" já existe.", "ERRO ER04",null);
			}catch(NullPointerException exc){
				metodoSalvar();
			}
			
		}
	};

	/***
	 * Metodo com  a função de buscar um caixa
	 */
	protected ActionListener onClickBuscarCaixa = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
		
			String codigoLocalizar = tfLocalizar.getText().trim(); // pega o codigo digitado pelo cliente.

			CaixaPK pk = new CaixaPK(); // chave primaria da caixa.
			pk.setCodigo(codigoLocalizar); // seta a chave

			try{
				Caixa cx = daoCaixa.buscar(pk); // realiza a busca no banco de dados
				setValoresDosCampos(cx); // atribui os valores recuperados para os campos.
				btnAlterar.setEnabled(true); // necessario a pesquisa para ativar botão
				btnExcluir.setEnabled(true); // necessario a pesquisa para ativar botão
				
				btnSalvar.setEnabled(false); // nao sera possivel salvar, somente alterar
				tfCodigo.setEditable(false); // nao sera possivel alterar o codigo de objeto consultado.
				
				caixa = cx;
			
			}catch(NullPointerException exc){
				throw new erroNullRequisitoException("(ER03) Nenhuma Caixa \"" +codigoLocalizar+ "\" foi encontrada.", "ERRO ER03",null);
			}
		}
	};

	/**
	 * Metodo com a função de excluir uma caixa
	 **/
	protected ActionListener onClickExcluirCaixa = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			if (JOptionPane.showConfirmDialog(null, "Deseja excluir a ata?") == 0) {
				daoCaixa.remover(caixa);
				JOptionPane.showMessageDialog(null, "Caixa excluído com sucesso.");
				modelo.removeContato(caixa);
				lista.remove(caixa);
				limparCampos();
				
				//LIMPA A CAIXA
				caixa = null;
			}
		}
	};
	
	@Override
	public void limparCampos() {
		tfCodigo.setText(null);
		comboTurno.setSelectedIndex(0);
		comboLetra.setSelectedIndex(0);
		comboStatus.setSelectedIndex(0);
		
		btnAlterar.setEnabled(false); // necessario a pesquisa para ativar botão
		btnExcluir.setEnabled(false);
		
		btnSalvar.setEnabled(true);
		tfCodigo.setEditable(true);
	}
	
}
