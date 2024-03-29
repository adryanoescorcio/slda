package Eventos;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import ComponentGroupPlus.PainelTabela;
import ExceptionSLDA.erroNullRequisitoException;
import Forms.MainJFrame;
import Model.Arquivo;
import Model.Caixa;
import PrimaryKey.CaixaPK;
import TablesModel.CaixaTableModel;

/**
 * Classe responsavel pelos eventos do painelCaixa
 * $$
 * @author Walysson Oliveira
 * @author Adryano Escorcio
 * @version 2.0
 * @extends EventoPadr�o
 **/

public class EventosCaixa extends EventosPadrao {

	//OBJETO UTILIZADO NAS BUSCAS
	Caixa caixaPesquisa = new Caixa();

	//COMPARADOR DE OBJETOS PARA ORDENAR O ARRAY
	ComparadorObjetos comparador = new ComparadorObjetos();

	//TABELA
	PainelTabela table = new PainelTabela();
	protected JTable tabela = table.getTabela();
	protected List<Caixa> lista = daoCaixa.getTodasCaixas();
	protected CaixaTableModel modelo;
	protected String strCodigo;

	//COMPONENTES NECESS�RIOS
	protected JTextField tfCodigo = new JTextField();
	protected JComboBox<String> comboTurno = comboGroup.getComboBoxTurno();
	protected JComboBox<String> comboLetra = comboGroup.getComboBoxLetra();
	protected JComboBox<String> comboStatus = comboGroup.getComboBoxStatus();
	protected JComboBox<String> comboNumero = comboGroup.getComboBoxNumero();
	protected JComboBox<String> comboModalidade  = comboGroup.getComboBoxEnsinoMF();
	protected JComboBox<String> comboEnsino  = comboGroup.getComboBoxEnsinoFUNDAMENTAL();

	protected MainJFrame main;

	public EventosCaixa(MainJFrame main) {
		this.main = main;
		//INICIA A TABELA ORDENADA
		Collections.sort(lista, comparador);
		modelo = new CaixaTableModel(lista);
		tfCodigo.setEditable(false);
		comboNumero.setEnabled(false);
	}

	public MainJFrame getMain() {
		return main;
	}

	public void setMain(MainJFrame main) {
		this.main = main;
	}

	@Override
	public Object getValoresDosCampos() {


		if(!(((String) comboTurno.getSelectedItem()) == null) &&
				!(((String) comboLetra.getSelectedItem()) == null)){

			caixa = new Caixa();
			caixa.setCodigo(tfCodigo.getText().trim());
			caixa.setTurno((String) comboTurno.getSelectedItem());
			caixa.setLetra((String) comboLetra.getSelectedItem());
			caixa.setStatus((String) comboStatus.getSelectedItem());
			caixa.setModalidadeAta((String) comboModalidade.getSelectedItem());
			caixa.setEnsinoAta((String) comboEnsino.getSelectedItem());

			return caixa;
		} else {
			throw new erroNullRequisitoException("(ER02) Preencha todos os requisitos com dados v�lidos.", "ERRO ER02");
		}
	}

	@Override
	public void setValoresDosCampos(Object object) throws NullPointerException {
		Caixa caixa = (Caixa) object;

		tfCodigo.setText(caixa.getCodigo());
		comboTurno.setSelectedItem(caixa.getTurno());
		comboLetra.setSelectedItem(caixa.getLetra());
		comboStatus.setSelectedItem(caixa.getStatus());
		comboEnsino.setSelectedItem(caixa.getEnsinoAta());
		comboModalidade.setSelectedItem(caixa.getModalidadeAta());
		
	}

	/**
	 * Metodos que realiza a fun��o de limpar os campos.
	 **/
	protected ActionListener onClickLimparCampos = new ActionListener() {  
		@Override
		public void actionPerformed(ActionEvent e) {
			limparCampos();
		}
	};

	/**
	 * Necess�rio verificar se houve altera��o para poder atualiza a caixa modificada.
	 **/
	protected ActionListener onClickAlterarCaixa = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			caixa = (Caixa) getValoresDosCampos();

			if(!caixa.toString().equals(caixaPesquisa.toString())) {                        
				if(daoCaixa.save(caixa)) {
					JOptionPane.showMessageDialog(null, SUCESSO);
					modelo.updateContato(caixaPesquisa, caixa);
					limparCampos();
				}      
			} else {
				JOptionPane.showMessageDialog(null, "(AT01) N�o houve modifica��o.","ATEN��O AT01",
						JOptionPane.WARNING_MESSAGE);
			}
		}
	};

	protected ItemListener onClickChangeModalidade = new ItemListener() {
		@Override
		public void itemStateChanged(ItemEvent ev) {
			//SE FUNDAMENTAL ESSE METODO RECONTR�I O COMBO
			if(comboModalidade.getSelectedIndex() == 0){
				comboEnsino.removeAllItems();
				comboEnsino.addItem("REGULAR");
				comboEnsino.addItem("ACELERA��O");
				comboEnsino.addItem("AVAN�ADO");
				comboEnsino.addItem("CLASSE ESPECIAL");
				comboEnsino.addItem("EJA");

				//SE MEDIO ESSE METODO RECONTR�I O COMBO	
			} else if(comboModalidade.getSelectedIndex() == 1){
				comboEnsino.removeAllItems();
				comboEnsino.addItem("REGULAR");
				comboEnsino.addItem("EJA");
				comboEnsino.addItem("PROEJA");
				comboEnsino.addItem("T�C. CONTABILIDADE");
			}	
		}
	};
	
	/**
	 * Metodo com a fun��o de salvar e alterar uma caixa.
	 **/
	protected ActionListener onClickSalvarCaixa = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {

			try {
				caixa = (Caixa) getValoresDosCampos();

				int num = 1;
				String codCaixaTMP = ((String) comboLetra.getSelectedItem()) + "-" +
						((String) comboTurno.getSelectedItem()).substring(0,1) + 
						((String) comboModalidade.getSelectedItem()).substring(0,1) +
						((String) comboEnsino.getSelectedItem()).substring(0,1) + "0";

				String codCaixa = ((String) comboLetra.getSelectedItem()) + "-" +
						((String) comboTurno.getSelectedItem()).substring(0,1) +
						((String) comboModalidade.getSelectedItem()).substring(0,1) +
						((String) comboEnsino.getSelectedItem()).substring(0,1) +
						"0" +String.valueOf(num);

				caixa.setCodigo(codCaixa);

				boolean boo = true;
				while (boo) {
					CaixaPK pk = new CaixaPK();
					pk.setCodigo(codCaixa);
					Caixa cx = daoCaixa.buscar(pk);

					if(cx == null) {
						boo = false;
					} else {
						num = num+1;
						String strNum = String.valueOf(num);
						codCaixa = codCaixaTMP.concat(strNum);
						caixa.setCodigo(codCaixa);
					}
				}

				if(daoCaixa.save(caixa)) {
					JOptionPane.showMessageDialog(null, SUCESSO);
					lista.add(caixa);
					//ORDENA A LISTA
					Collections.sort(lista, comparador);
					//RECRIA A TABELA
					modelo = new CaixaTableModel(lista);
					tabela.setModel(modelo);
					mostarDadoSalvo(caixa);
				}

			} catch (Exception ex) {
				System.out.println("Dados est�o incompletos");
			}
		}
	};

	/***
	 * Metodo com  a fun��o de buscar um caixa
	 */
	protected ActionListener onClickBuscarCaixa = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {

			String codigoLocalizar = tfLocalizar.getText().trim().toUpperCase(); // pega o codigo digitado pelo cliente.

			CaixaPK pk = new CaixaPK(); // chave primaria da caixa.
			pk.setCodigo(codigoLocalizar); // seta a chave

			try{
				caixaPesquisa = daoCaixa.buscar(pk); // realiza a busca no banco de dados
				setValoresDosCampos(caixaPesquisa); // atribui os valores recuperados para os campos.
				habilitarBotoes(true);
				desabilitarCamposPesquisa();

			}catch(NullPointerException exc){
				JOptionPane.showMessageDialog(null,"(ER03) Nenhuma Caixa \"" +codigoLocalizar+ "\" foi encontrada.");
			}
		}
	};

	/**
	 * Metodo com a fun��o de excluir uma caixa
	 **/
	protected ActionListener onClickExcluirCaixa = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {

			if (JOptionPane.showConfirmDialog(null, "Deseja excluir a Caixa?") == 0) {
				daoCaixa.remover(caixaPesquisa);
				daoArquivo.excluirPorCaixa(caixaPesquisa);
				JOptionPane.showMessageDialog(null, "Caixa exclu�do com sucesso.");
				lista.remove(caixaPesquisa);
				Collections.sort(lista, comparador);
				
				modelo = new CaixaTableModel(lista);
				tabela.setModel(modelo);
				
				limparCampos();

				//LIMPA A CAIXA
				caixa = null;
			}
		}
	};

	protected ActionListener onClickInitInserir = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				PlusEventoDiscenteArquivo disArquivo = new PlusEventoDiscenteArquivo(EventosCaixa.this);

				// verificar se tudo deu certo.
				if(disArquivo.onClickSalvarArquivo()){
					main.direcionarParaCamada(0);
					main.limparCaixa();
				}
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, "Um erro inesperado ocorreu. Verifique os dados e os campos preenchidos.");
			}
		}
	};

	protected ActionListener onClickInitRetirar = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				PlusEventoDiscenteArquivo disArquivo = new PlusEventoDiscenteArquivo(EventosCaixa.this);

				// verificar se tudo deu certo.
				if(disArquivo.onClickRetirarArquivo()){
					main.direcionarParaCamada(0);
					main.atualizarCaixaAluno(aluno);
					main.limparCaixa();
				}
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, "Um erro inesperado ocorreu. Verifique os dados e os campos preenchidos.");
			}
		}
	};


	//OBJETO QUE REALIZA UMA BUSCA ATRAV�S DAS LINHAS DA TABELA
	protected MouseListener onClickRowTable = new MouseListener() {

		@Override
		public void mouseClicked(MouseEvent e) {
			if(e.getClickCount() == 2){
				int linha = tabela.getSelectedRow();
				caixaPesquisa = modelo.getContato(linha);
				setValoresDosCampos(caixaPesquisa);

				if (aluno == null) {
					habilitarBotoes(true);
					desabilitarCamposPesquisa();
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

	@Override
	public void limparCampos() {
		tfCodigo.setText(null);
		comboTurno.setSelectedIndex(0);
		comboLetra.setSelectedIndex(0);
		comboStatus.setSelectedIndex(0);
		comboNumero.setSelectedIndex(0);
		comboEnsino.setSelectedIndex(0);
		comboModalidade.setSelectedIndex(0);
		
		tfDiscente.setText(null);

		setMudarPerfil(false);
		habilitarBotoes(false);
	}

	protected void desabilitarCamposPesquisa() {
		comboTurno.setEnabled(false);
		comboLetra.setEnabled(false);
	}

	protected void mostarDadoSalvo(Caixa caixa) {
		setValoresDosCampos(caixa);
		comboLetra.setEnabled(false);
		comboTurno.setEnabled(false);
		comboStatus.setEnabled(false);
		comboEnsino.setEnabled(false);
		comboModalidade.setEnabled(false);
		comboLetra.setForeground(Color.BLACK);
		btnSalvar.setEnabled(false);
	}

	//METODO PARA HABILITAR OU DESABILITAR OS BOTOES QUE INICIAM Enabled E TAMB�M OUTROS COMPONENTES NECESS�RIOS
	public void habilitarBotoes(boolean bool) {
		comboTurno.setEnabled(true);
		comboLetra.setEnabled(true);
		comboStatus.setEnabled(true);
		comboEnsino.setEnabled(false);
		comboModalidade.setEnabled(false);
		btnAlterar.setEnabled(bool);
		btnExcluir.setEnabled(bool);
		btnSalvar.setEnabled(!bool);
	}

	//PEQUENA CLASSE DE COMPARA��O UTILIZADA NA ORDENA��O DA LISTA
	public static class  ComparadorObjetos implements Comparator<Caixa> {

		@Override
		public int compare(Caixa objetoParaComparar, Caixa objetoAserComparado) {
			return  objetoParaComparar.getCodigo().compareTo(objetoAserComparado.getCodigo());
		}
	}   
	
	public void setMudarPerfil(boolean bool) {
		btnSalvar.setEnabled(!bool);
		btnAlterar.setEnabled(!bool);
		btnExcluir.setEnabled(!bool);

		comboNumero.setEnabled(bool);
		btnRetirar.setEnabled(bool);
		btnInserir.setEnabled(bool);

		comboLetra.setEnabled(!bool);
		comboStatus.setEnabled(!bool);
		comboTurno.setEnabled(!bool);
		comboEnsino.setEnabled(!bool);
		comboModalidade.setEnabled(!bool);
	}

	protected void desabilitarTudoFormulario() {
		comboTurno.setEnabled(false);
		comboLetra.setEnabled(false);
		comboStatus.setEditable(false);
		comboEnsino.setEditable(false);
		comboModalidade.setEditable(false);
		tfCodigo.setEditable(false);

		btnAlterar.setEnabled(false);
	}

	public Arquivo getArquivo() {
		
		if(!(((String) comboTurno.getSelectedItem()) == null) &&
				!(((String) comboLetra.getSelectedItem()) == null)){
			
			arquivo = new Arquivo();
			arquivo.setCodigo(aluno.getCodigo(), tfCodigo.getText().trim());
			arquivo.setCodDossie((String) comboNumero.getSelectedItem());

			return arquivo;
			
		} else {
			return null;
		}
	}

	public Arquivo setArquivo(Arquivo arquivo) {
		return this.arquivo = arquivo;
	}

	public Caixa getCaixa() {
		return caixa;
	}
}
