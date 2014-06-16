package Eventos;

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

	public PlusEventoDiscenteAta(final EventosAta ataEvento) {
		this.aluno = ataEvento.getAluno();
		this.ata = ataEvento.getAta();
		this.main = ataEvento.getMain();
	}

	/**
	 * Metodo que encerra operação da aplicação em caso de sucesso
	 **/
	protected void finallyOperation() {
		JOptionPane.showMessageDialog(null, Messages.getString("PlusEventoDiscenteAta.0")); //$NON-NLS-1$
		main.atualizarTabelaAluno(aluno);
	}

	public List<Ata> getListaAta() {
		return listaAta;
	}

	@Override
	public Object getValoresDosCampos() {
		return ata;
	}

	@Override
	public void limparCampos() {
		// TODO
	}

	public void onClickRetirarAtaResultado() {
		if (JOptionPane
				.showConfirmDialog(null,
						Messages.getString("PlusEventoDiscenteAta.1")) == 0) { //$NON-NLS-1$
			final AtaResultado ataResul = new AtaResultado(); // cria o objeto
																// de resultados
			ataResul.setAluno(aluno.getCodigo()); // passa o codigo do aluno
			ataResul.setAta((Ata) getValoresDosCampos());

			if (daoAtaResultado.remover(ataResul)) {
				finallyOperation();
				JOptionPane.showMessageDialog(null,
						Messages.getString("PlusEventoDiscenteAta.2")); //$NON-NLS-1$
			} else {
				JOptionPane.showMessageDialog(null,
						Messages.getString("PlusEventoDiscenteAta.3")); //$NON-NLS-1$
			}
		}
	}

	public boolean onClickSalvarAtaResultado() {

		final AtaResultado ataResul = new AtaResultado(); // cria o objeto de
															// resultados
		ataResul.setAluno(aluno.getCodigo()); // passa o codigo do aluno

		try {
			// verificar se a ata existe no banco de dados
			// inseri todas as informações da ata.
			ataResul.setAta((Ata) getValoresDosCampos());

			daoAtaResultado.save(ataResul); // salva a entidade
			finallyOperation(); // realizando as operações apos salvar
			return true;
		} catch (final Exception ex) {
			new erroNullRequisitoException(
					Messages.getString("PlusEventoDiscenteAta.4"), //$NON-NLS-1$
					Messages.getString("PlusEventoDiscenteAta.5")); //$NON-NLS-1$
			return false;
		}
	}

	public void setListaAta(final List<Ata> listaAta) {
		this.listaAta = listaAta;
	}

	@Override
	public void setValoresDosCampos(final Object object) {

	}
}
