package Eventos;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.text.MaskFormatter;

import DAO.AlunoDAO;
import DAO.CaixaDAO;
import Forms.TelaPadrao;
import Forms.TablesModel.AlunoTableModel;
import Model.Aluno;
import Model.Caixa;
import PrimaryKey.AlunoPK;

@SuppressWarnings("serial")
public class EventosAluno extends EventosPadrão{

	//OBJETO QUE SERÁ USADO NOS EVENTOS
	private Aluno aluno;
	//OBJETO QUE SERÁ USADO NOS EVENTOS
	private AlunoDAO dao;
	
	//DECLARAÇÃO DE VARIÁVEIS DE ALUNO
	protected static final String BORDER_INFO_ALUNO = "DOSSIÊ DO ALUNO";
	protected static final int QUANT_LINHAS_GRID = 9;
	
	protected JPanel mainJPanel = new JPanel(new BorderLayout(2,2));
	protected JPanel painelLocalizarArquivo = new JPanel(new BorderLayout(2,2));
	protected JPanel painelInternoNorte = new JPanel(new BorderLayout(2,2));
	protected JPanel painelInternoSul = new JPanel(new BorderLayout(2,2));
	protected JPanel painelEsquerdoInfoAluno = new JPanel(new GridLayout(QUANT_LINHAS_GRID,1,DIST,DIST));
	protected JPanel painelDireito = new JPanel(new GridLayout(QUANT_LINHAS_GRID,1,DIST,DIST));
	protected JPanel painelTabela= new JPanel(new BorderLayout(2,2));	
	protected JPanel painelContentEIA = new JPanel(new BorderLayout(2,2));
	
	protected JScrollPane scroll = new JScrollPane();
	protected JScrollPane scrollMain = new JScrollPane();
	
	protected JLabel lbDadosAluno = new JLabel("DADOS DO DISCENTE",SwingConstants.CENTER);
	protected JLabel lbNome = new JLabel("Nome: ",SwingConstants.RIGHT);
	protected JLabel lbCodigo2 = new JLabel("Codigo Aluno: ",SwingConstants.RIGHT);
	protected JLabel lbCodigo = new JLabel("Codigo: ",SwingConstants.RIGHT);
	protected JLabel lbCPF = new JLabel("CPF: ",SwingConstants.RIGHT);
	protected JLabel lbCor = new JLabel("Cor: ",SwingConstants.RIGHT);
	protected JLabel lbNis = new JLabel("NIS: ",SwingConstants.RIGHT);
	protected JLabel lbDataNasc = new JLabel("Data Nasc.: ",SwingConstants.RIGHT);
	protected JLabel lbSexo = new JLabel("Sexo: ",SwingConstants.RIGHT);
	protected JLabel lbNomeMae = new JLabel("Mãe: ",SwingConstants.RIGHT);
	protected JLabel lbEstadoMae = new JLabel("Estado Nasc. Mae: ",SwingConstants.RIGHT);
	protected JLabel lbNomePai = new JLabel("Pai: ",SwingConstants.RIGHT);
	protected JLabel lbEnd = new JLabel("Endereço: ",SwingConstants.RIGHT);
	protected JLabel lbCidade = new JLabel("Cidade Nasc.: ",SwingConstants.RIGHT);
	protected JLabel lbEstado = new JLabel("Estado Nasc.: ",SwingConstants.RIGHT);
	protected JLabel lbFone = new JLabel("Telefone: ",SwingConstants.RIGHT);
	protected JLabel lbDataMatricula = new JLabel("Data Matricula: ",SwingConstants.RIGHT);
	protected JLabel lbTransferencia = new JLabel("Admitido por Transferencia? ",SwingConstants.RIGHT); // Tem que ativar um campo de data
	protected JLabel lbSituacao = new JLabel("Situação Atual: ",SwingConstants.RIGHT);
	
	protected JTextField tfNome = new JTextField();
	protected JTextField tfLocalizar = new JTextField();
	protected JTextField tfCodigo = new JTextField();
	protected JTextField tfCidade = new JTextField();
	protected JTextField tfEnd = new JTextField();
	
	protected JFormattedTextField ftCpf = new JFormattedTextField(padrao.getMascaraCPF());
	protected JFormattedTextField ftDataNasc = new JFormattedTextField(padrao.getMascaraData());
	protected JFormattedTextField ftDataMatricula = new JFormattedTextField(padrao.getMascaraData());
	protected JFormattedTextField ftFone = new JFormattedTextField(padrao.getMascaraTelefone());
	
	protected ImageIcon icone = new ImageIcon("src/Icones/search.png");

	protected JButton btnSalvar = new JButton("Salvar");
	protected JButton btnLimpar = new JButton("Limpar");
	protected JButton btnExcluir = new JButton("Excluir");
	protected JButton btnAlterar = new JButton("Alterar");
	protected JButton btnPesquisar = new JButton("Pesquisar", icone);

	protected ArrayList<Aluno> lista = new ArrayList<Aluno>();
	protected AlunoTableModel modelo = new AlunoTableModel(lista);
	protected JTable tabela = new JTable(modelo);

	
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
			alunopk.setCodigo(tfCodigo.getText());
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
		
		tfCodigo.setText("");
		tfNome.setText("");
		tfCidade.setText("");
		tfEnd.setText("");
	
	}
	
	@Override
	public Aluno getValoresDosCampos(){
		Aluno aluno = new Aluno();
		/*if(radioFeminino.isSelected()){
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
*/
		return aluno;
	
	}
	
	@Override
	public void setValoresDosCampos(Object aluno){
/*
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
*/
	}

}
