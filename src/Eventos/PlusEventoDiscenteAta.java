package Eventos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JOptionPane;

import ExceptionSLDA.erroNullRequisitoException;
import Forms.MainJFrame;
import Model.Ata;
import Model.AtaResultado;

public class PlusEventoDiscenteAta extends EventosPadrao {

	protected List<Ata> listaAta;
	protected Ata ultimaAtaList;

	protected AtaResultado ataResultadoGlobal;

	protected EventosAluno evento;
	
	protected MainJFrame main;

	public PlusEventoDiscenteAta(EventosAta ataEvento) {
		this.aluno = ataEvento.getAluno();
		this.ata = ataEvento.getAta();
		this.main = ataEvento.getMain();
	}

	public List<Ata> getListaAta() {
		return listaAta;
	}

	public void setListaAta(List<Ata> listaAta) {
		this.listaAta = listaAta;
	}

	@Override
	public Object getValoresDosCampos() {
		return ata;
	}

	@Override
	public void setValoresDosCampos(Object object) {

	}

	public void onClickSalvarAtaResultado() {
		
		AtaResultado ataResul = new AtaResultado(); // cria o objeto de resultados
		ataResul.setAluno(aluno.getCodigo()); // passa o codigo do aluno

		try {
			// verificar se a ata existe no banco de dados
			// inseri todas as informa��es da ata.
			ataResul.setAta((Ata) getValoresDosCampos());
	
			daoAtaResultado.save(ataResul); //salva a entidade
			finallyOperation(); // realizando as opera��es apos salvar
		} catch (Exception ex) {
			new erroNullRequisitoException("Errou de inser��o. Verifique os dados inseridos ou se o aluno j� foi inserido nesta Ata.","ER05");
		}
	}

	protected ActionListener onClickExcluir = new ActionListener() {	
		@Override
		public void actionPerformed(ActionEvent e) {
			if(JOptionPane.showConfirmDialog(null, "O aluno ser� retirado da Ata. Deseja continuar com a opera��o?") == 0) {
				daoAtaResultado.remover(ataResultadoGlobal);
				evento.tabelaAta(aluno);
				JOptionPane.showMessageDialog(null, "Aluno foi retirado da ata com sucesso.");
				limparCampos();
			}
		}
	};

	/**
	 * Metodo que encerra opera��o da aplica��o em caso de sucesso
	 **/
	protected void finallyOperation() {
		JOptionPane.showMessageDialog(null, "Opera��o realizada com sucesso.");
		main.atualizarTabelaAluno(aluno);
	}

	@Override
	public void limparCampos() {
		
	}
}
