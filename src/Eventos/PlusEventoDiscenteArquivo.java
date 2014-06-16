package Eventos;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

import ExceptionSLDA.erroNullRequisitoException;
import Forms.MainJFrame;
import Model.Arquivo;

public class PlusEventoDiscenteArquivo extends EventosPadrao {

	protected MainJFrame main;

	public PlusEventoDiscenteArquivo(final EventosCaixa caixa) {
		this.main = caixa.getMain();
		this.aluno = caixa.getAluno();
		this.arquivo = caixa.getArquivo();
	}

	private String dateToday() {

		final Date date = new Date();
		final SimpleDateFormat dateToday = new SimpleDateFormat(Messages.getString("PlusEventoDiscenteArquivo.0")); //$NON-NLS-1$
		final String strDateToday = dateToday.format(date);

		return strDateToday;
	}

	/**
	 * Metodo que encerra operação da aplicação em caso de sucesso
	 **/
	protected void finallyOperation() {
		JOptionPane.showMessageDialog(null, Messages.getString("PlusEventoDiscenteArquivo.1")); //$NON-NLS-1$
		main.atualizarCaixaAluno(aluno);
	}

	@Override
	public Object getValoresDosCampos() {
		try {
			arquivo.setDatadeEntradaArquivo(dateToday());
			return arquivo;
		} catch (final Exception ex) {
			JOptionPane.showMessageDialog(null, Messages.getString("PlusEventoDiscenteArquivo.2")); //$NON-NLS-1$
			return null;
		}
	}

	@Override
	public void limparCampos() {
	};

	protected boolean onClickRetirarArquivo() {

		final Arquivo arquivoBD = new Arquivo(); // cria o objeto de resultados
		arquivoBD.setCodigoAluno(aluno.getCodigo()); // passa o codigo do aluno

		if (daoArquivo.remover(arquivoBD)) {
			finallyOperation();
			return true;
		} else {
			JOptionPane
					.showMessageDialog(null,
							Messages.getString("PlusEventoDiscenteArquivo.3")); //$NON-NLS-1$
			return false;
		}
	};

	protected boolean onClickSalvarArquivo() {

		final Arquivo arquivoBD = new Arquivo(); // cria o objeto de resultados
		arquivoBD.setCodigoAluno(aluno.getCodigo()); // passa o codigo do aluno

		try {
			// inseri todas as informações do arquivo.
			arquivoBD.setArquivo((Arquivo) getValoresDosCampos());

			daoArquivo.save(arquivoBD); // salva a entidade
			finallyOperation(); // realizando as operações apos salvar
			return true;
		} catch (final Exception ex) {
			new erroNullRequisitoException(
					Messages.getString("PlusEventoDiscenteArquivo.4") //$NON-NLS-1$
							+ ex.getMessage(), Messages.getString("PlusEventoDiscenteArquivo.5")); //$NON-NLS-1$
			return false;
		}
	}

	@Override
	public void setValoresDosCampos(final Object object) {
		// TODO Auto-generated method stub
	}

}
