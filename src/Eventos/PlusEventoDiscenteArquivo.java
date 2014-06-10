package Eventos;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

import ExceptionSLDA.erroNullRequisitoException;
import Forms.MainJFrame;
import Model.Arquivo;

public class PlusEventoDiscenteArquivo extends EventosPadrao {

	protected MainJFrame main;

	public PlusEventoDiscenteArquivo(EventosCaixa caixa) {
		this.main = caixa.getMain();
		this.aluno = caixa.getAluno();
		this.arquivo = caixa.getArquivo();
	}

	private String dateToday() {

		Date date = new Date();
		SimpleDateFormat dateToday = new SimpleDateFormat("dd/MM/yyyy");
		String strDateToday = dateToday.format(date);

		return strDateToday;
	}

	@Override
	public void limparCampos() {
	}

	@Override
	public Object getValoresDosCampos() {
		try {
			arquivo.setDatadeEntradaArquivo(dateToday());
			return arquivo;
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "Selecione uma caixa.");
			return null;
		}
	}

	protected boolean onClickSalvarArquivo () {	

		Arquivo arquivoBD = new Arquivo(); // cria o objeto de resultados
		arquivoBD.setCodigoAluno(aluno.getCodigo()); // passa o codigo do aluno

		try {
			// inseri todas as informações do arquivo.
			arquivoBD.setArquivo((Arquivo) getValoresDosCampos());
			
			daoArquivo.save(arquivoBD); //salva a entidade
			finallyOperation(); // realizando as operações apos salvar
			return true;
		} catch (Exception ex) {
			new erroNullRequisitoException("Erro de inserção.\nVerifique os dados inseridos ou se o aluno já foi inserido nesta Caixa. " + ex.getMessage(),"ER07");
			return false;
		}
	};

	protected boolean onClickRetirarArquivo () {	
		
		Arquivo arquivoBD = new Arquivo(); // cria o objeto de resultados
		arquivoBD.setCodigoAluno(aluno.getCodigo()); // passa o codigo do aluno
		
		if(daoArquivo.remover(arquivoBD)){
			finallyOperation();
			return true;
		}else {
			JOptionPane.showMessageDialog(null, "Ocorreu um erro. O aluno não está inserido em nenhuma caixa.");
			return false;
		}
	};
	
	/**
	 * Metodo que encerra operação da aplicação em caso de sucesso
	 **/
	protected void finallyOperation() {
		JOptionPane.showMessageDialog(null, "Operação realizada com sucesso.");
		main.atualizarCaixaAluno(aluno);
	}

	@Override
	public void setValoresDosCampos(Object object) {
		// TODO Auto-generated method stub
	}

}
