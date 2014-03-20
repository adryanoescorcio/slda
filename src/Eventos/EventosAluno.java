package Eventos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import DAO.AlunoDAO;
import Model.Aluno;
import PrimaryKey.AlunoPK;

@SuppressWarnings("serial")
public class EventosAluno extends EventosPadrão{

	//DECLARAÇÃO DE VARIÁVEIS DE ALUNO
	protected JFormattedTextField tffMatricula, tffInep, tffCpf, tffRg, tffData, tffTelefone;
	protected JTextField tfNome, tfCidade, tfEndereco, tfNomeMae, tfNomePai, tfCidadeMae, tfCidadePai;
	protected JComboBox<String> comboUFAluno, comboCor, comboUFMae, comboUFPai;
	protected ButtonGroup grupo;
	protected JRadioButton radioMasculino, radioFeminino;
	protected String sexo;
	protected AlunoDAO dao;
	protected MaskFormatter data, tel, cpf;
	protected JButton botaoSalvar, botaoLimpar, botaoExcluir, botaoBuscar;
	protected Aluno aluno;
	
	//OBJETO ActionListener QUE SALVA O ALUNO
	protected ActionListener onClickSalvarAluno = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
		aluno = getValoresDosCampos();
		dao = new AlunoDAO(conexaoBD);
		String matricula = aluno.getCodigo();
		String nome = aluno.getNomeAluno();
		
		//TESTE PARA VERIFICAR SE O ALUNO EXISTE
		if(matricula.equals("") || nome.equals("")){
			JOptionPane.showMessageDialog(null, "Preencha os campos obrigatórios.");
		}else if(dao.isExist(matricula)){
			dao.save(aluno);
			JOptionPane.showMessageDialog(null, "Alterado com sucesso.");
			limparCampos();
		}else{
			dao.save(aluno);
			JOptionPane.showMessageDialog(null, "Salvo com sucesso.");
			limparCampos();
		}
		//LIMPA O ALUNO
		aluno = new Aluno();
		}
	};
	
	//OBJETO ActionListener QUE BUSCA O ALUNO NO BANCO
	protected ActionListener onClickBuscarAluno = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			AlunoPK alunopk = new AlunoPK();
			alunopk.setCodigo(tffMatricula.getText());
			dao = new AlunoDAO(conexaoBD);
			aluno = dao.buscar(alunopk);

			try{
				setValoresDosCampos(aluno);
			}catch(NullPointerException exc){
				JOptionPane.showMessageDialog(null, "Aluno não encontrado.");
				limparCampos();
			}
		}
	};

	//OBJETO ActionListener QUE EXCLUE O ALUNO NO BANCO
	protected ActionListener onClickExcluirAluno = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {			
			dao.remover(aluno);
			JOptionPane.showMessageDialog(null, "Aluno excluído com sucesso.");
			limparCampos();
		}
	};
	
	//OBJETO ActionListener QUE LIMPA OS CAMPOS DA TELA
	protected ActionListener onClickLimparCampos = new ActionListener() {	
		@Override
		public void actionPerformed(ActionEvent e) {
			limparCampos();
		}
	};
		
	@Override	
	public void limparCampos(){
		
		tffMatricula.setText("");
		tffInep.setText("");
		tffCpf.setText("");
		tffRg.setText("");
		tffData.setText("");
		tffTelefone.setText("");
		tfNome.setText("");
		tfCidade.setText("");
		tfEndereco.setText("");
		tfNomeMae.setText("");
		tfNomePai.setText("");
		tfCidadeMae.setText("");
		tfCidadePai.setText("");
		comboUFAluno.setSelectedIndex(0);
		comboCor.setSelectedIndex(0);
		comboUFMae.setSelectedIndex(0);
		comboUFPai.setSelectedIndex(0);
		grupo.clearSelection();
		
	}
	
	@Override
	public Aluno getValoresDosCampos(){
		Aluno aluno = new Aluno();
		if(radioFeminino.isSelected()){
			sexo = "FEMININO";
		}if(radioMasculino.isSelected()){
			sexo = "MASCULINO";
		}else{
			sexo = " ";
		}
		
		aluno.setCodigo(tffMatricula.getText());
		aluno.setNomeAluno(tfNome.getText());
		aluno.setINEP(tffInep.getText());
		aluno.setCPF_Aluno(tffCpf.getText());
		aluno.setRG_Aluno(tffRg.getText());
		aluno.setEstadoNascAluno((String) comboUFAluno.getSelectedItem());
		aluno.setCidadeNascAluno(tfCidade.getText());
		aluno.setDataNascimento(tffData.getText());
		aluno.setSexoAluno(sexo);
		aluno.setCorAluno((String) comboCor.getSelectedItem());
		aluno.setTelefoneAluno(tffTelefone.getText());
		aluno.setEnderecoAluno(tfEndereco.getText());
		aluno.setNomeMae(tfNomeMae.getText());
		aluno.setNomePai(tfNomePai.getText());
		aluno.setEstadoMaeNasc((String) comboUFMae.getSelectedItem());
		aluno.setEstadoPaiNasc((String) comboUFPai.getSelectedItem());
		aluno.setCidadeMaeNasc(tfCidadeMae.getText());
		aluno.setCidadePaiNasc(tfCidadePai.getText());

		return aluno;
	}
	
	@Override
	public void setValoresDosCampos(Object aluno){

		aluno = new Aluno();
		
		tfNome.setText(((Aluno) aluno).getNomeAluno());
		tffInep.setText(((Aluno) aluno).getINEP());
		tffCpf.setText(((Aluno) aluno).getCPF_Aluno());
		tffRg.setText(((Aluno) aluno).getRG_Aluno());
		comboUFAluno.setSelectedItem(((Aluno) aluno).getEstadoNascAluno());
		tfCidade.setText(((Aluno) aluno).getCidadeNascAluno());
		tffData.setText(((Aluno) aluno).getDataNascimento());
		if(((Aluno) aluno).getSexoAluno().equals("FEMININO")){
			radioFeminino.setSelected(true);
		}
		if(((Aluno) aluno).getSexoAluno().equals("MASCULINO")){
			radioMasculino.setSelected(true);
		}
		comboCor.setSelectedItem(((Aluno) aluno).getCorAluno());
		tffTelefone.setText(((Aluno) aluno).getTelefoneAluno());
		tfEndereco.setText(((Aluno) aluno).getEnderecoAluno());
		tfNomeMae.setText(((Aluno) aluno).getNomeMae());
		tfNomePai.setText(((Aluno) aluno).getNomePai());
		comboUFMae.setSelectedItem(((Aluno) aluno).getEstadoMaeNasc());
		comboUFPai.setSelectedItem(((Aluno) aluno).getEstadoPaiNasc());
		tfCidadeMae.setText(((Aluno) aluno).getCidadeMaeNasc());
		tfCidadePai.setText(((Aluno) aluno).getCidadePaiNasc());

	}

}
