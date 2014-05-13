package Eventos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import ComponentGroupPlus.MaskFormatterGroup;
import ExceptionSLDA.erroNullRequisitoException;
import Model.Arquivo;
import Model.Ata;
import Model.AtaResultado;
import Model.Caixa;
import PrimaryKey.CaixaPK;

public class PlusEventoDiscenteArquivo extends EventosPadrao {

	// Objeto Mask
	protected MaskFormatterGroup mask = new MaskFormatterGroup();

	protected JTextField tfRefCaixa = new JTextField();
	protected JTextField tfLocaInter = new JTextField();

	protected JFormattedTextField ftData = new JFormattedTextField(mask.getMascaraData());
	protected JComboBox<String> comboBoxSubSecao = comboGroup.getComboBoxSubSecao();

	private JPanel mainJDialog;
	protected List<Ata> listaAta;
	protected Ata ultimaAtaList;

	protected AtaResultado ataResultadoGlobal;

	protected EventosAluno evento;

	public PlusEventoDiscenteArquivo(JPanel mainDialog, EventosAluno evAluno) {
		this.evento = evAluno;
		initVar();
		this.setMainJDialog(mainDialog);
		this.aluno = evAluno.getAluno();
	}

	/**
	 * Inicializar a variaveis
	 **/
	private void initVar() {
		tfRefCaixa = new JTextField();
		ftData.setText(dateToday());
	}

	private String dateToday() {

		Date date = new Date();
		SimpleDateFormat dateToday = new SimpleDateFormat("dd/MM/yyyy");
		String strDateToday = dateToday.format(date);

		return strDateToday;
	}

	@Override
	public void limparCampos() {
		tfRefCaixa.setText("");
		ftData.setText("");
		tfLocaInter.setText("");
		btnExcluir.setEnabled(false);
	}

	@Override
	public Object getValoresDosCampos() throws erroNullRequisitoException {
		Arquivo arquivo = new Arquivo();
		arquivo.setCodigoAluno(aluno.getCodigo());
		arquivo.setCodDossie(tfLocaInter.getText());
		arquivo.setDatadeEntradaArquivo(ftData.getText());
		arquivo.setCodigoCaixa(tfRefCaixa.getText());

		return arquivo;
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
			Arquivo arquivoBD = new Arquivo(); // cria o objeto de resultados
			arquivoBD.setCodigoAluno(aluno.getCodigo()); // passa o codigo do aluno

			// inseri todas as informações do arquivo.
			arquivoBD.setArquivo(
					(Arquivo) getValoresDosCampos());

			try {
				// verificar se a ata existe no banco de dados
				if(validaCaixa(arquivoBD.getCodigoCaixa())) {
					daoArquivo.save(arquivoBD); //salva a entidade
					finallyOperation(); // realizando as operações apos salvar

				} else {
					new erroNullRequisitoException("Caixa não foi cadastrada, insira a nova Caixa no banco de dados.", "ER06");
				}
			} catch (Exception ex) {
				new erroNullRequisitoException("Errou de inserção.\nVerifique os dados inseridos ou se o aluno já foi inserido nesta Caixa.","ER07");
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
			if(JOptionPane.showConfirmDialog(null, "O aluno será retirado do Arquivo Atual. Deseja continuar com a operação?") == 0) {
				daoArquivo.remover(evento.arquivo);
				evento.arquivo = null; // o arquivo é excluido
				btnExcluir.setEnabled(false); // o botão volta ao normal
				limparCampos();
				acaoFinal();

			}
		}
	};

	protected ActionListener onClickInserirCaixa = new ActionListener() {	
		@Override
		public void actionPerformed(ActionEvent e) {
			direcionarParaCamada();
		}
	};
	
	protected boolean validaCaixa(String codigoCaixa) {
		CaixaPK pkCaixa = new CaixaPK();
		pkCaixa.setCodigo(codigoCaixa);

		Caixa caixa = daoCaixa.buscar(pkCaixa);

		try {
			caixa.toString();
			return true;
		} catch (NullPointerException ex) {
			return false;
		}
	}

	/**
	 * Metodo que encerra operação da aplicação em caso de sucesso
	 **/
	protected void finallyOperation() {
		JOptionPane.showMessageDialog(null, "Operação realizada com sucesso.");
		acaoFinal();
	}

	private void acaoFinal() {
		evento.normalizarCamadas(); // colocar as abas superiores normais
		mainJDialog.removeAll(); // remove todos os compnentes da janela de aluno
		evento.pesquisarCaixa(aluno); // atualiza o painel de caixa na janela aluno
	}
	
	protected void direcionarParaCamada() {
		evento.normalizarCamadas(); // colocar as abas superiores normais
		evento.direcionarParaCamada(1);
		mainJDialog.removeAll();
	}

	@Override
	public void setValoresDosCampos(Object object) {
		// TODO Auto-generated method stub
	}

}
