package Eventos;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
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
import DAO.ArquivoDAO;
import Forms.TelaPadrao;
import Forms.TablesModel.AlunoTableModel;
import Forms.TablesModel.AtaTableModel;
import Forms.TablesModel.DocumentoTableModel;
import Model.Aluno;
import Model.Arquivo;
import Model.Ata;
import Model.Documento;
import PrimaryKey.AlunoPK;

@SuppressWarnings("serial")
public class EventosAluno extends EventosPadrão{

	//DECLARAÇÃO DE VARIÁVEIS DE ALUNO
	protected JFormattedTextField tffMatricula, tffInep, tffCpf, tffRg, tffData, tffTelefone;
	protected JTextField tfEndereco, tfNomePai, tfCidadeMae, tfCidadePai;
	protected JComboBox<String> comboUFAluno, comboCor, comboUFMae, comboUFPai;
	protected ButtonGroup grupo;
	protected JRadioButton radioMasculino, radioFeminino;
	protected String sexo;
	protected AlunoDAO dao;
	protected MaskFormatter data, tel, cpf;
	protected JButton botaoSalvar, botaoLimpar, botaoExcluir, botaoBuscar;
	
	protected static final int DIST = 5;

	protected static final String BORDER_INFO_ALUNO = "DOSSIÊ DO DISCENTE";
	protected static final int QUANT_LINHAS_GRID = 10;
	
	protected TelaPadrao padrao = new TelaPadrao();

	protected JPanel mainJPanel = new JPanel(new BorderLayout(2,2));
	protected JPanel painelLocalizarArquivo = new JPanel(new BorderLayout(2,2));
	protected JPanel painelInternoNorte = new JPanel(new BorderLayout(2,2));
	protected JPanel painelInternoSul = new JPanel(new BorderLayout(2,2));
	protected JPanel painelEsquerdoInfoAluno = new JPanel(new GridLayout(QUANT_LINHAS_GRID,1,DIST,DIST));
	protected JPanel painelDireito = new JPanel(new GridLayout(QUANT_LINHAS_GRID,1,DIST,DIST));
	protected JPanel painelTabela= new JPanel(new BorderLayout(2,2));	
	protected JPanel painelContentEIA = new JPanel(new BorderLayout(2,2));
	protected JPanel painelBotoes = new JPanel(new BorderLayout(2,2));
	
	protected JScrollPane scroll = new JScrollPane();
	protected JScrollPane scrollMain = new JScrollPane();
	
	protected JLabel lbDadosAluno = new JLabel("DADOS DO DISCENTE",SwingConstants.CENTER);
	protected JLabel lbNome = new JLabel("Nome:* ",SwingConstants.RIGHT);
	protected JLabel lbCodigo2 = new JLabel("Discente: ",SwingConstants.RIGHT);
	protected JLabel lbCodigo = new JLabel("Código:* ",SwingConstants.RIGHT);
	protected JLabel lbCPF = new JLabel("CPF: ",SwingConstants.RIGHT);
	protected JLabel lbCor = new JLabel("Cor: ",SwingConstants.RIGHT);
	protected JLabel lbNis = new JLabel("NIS: ",SwingConstants.RIGHT);
	protected JLabel lbDataNasc = new JLabel("Data Nasc.:* ",SwingConstants.RIGHT);
	protected JLabel lbSexo = new JLabel("Sexo: ",SwingConstants.RIGHT);
	protected JLabel lbNomeMae = new JLabel("Mãe: ",SwingConstants.RIGHT);
	protected JLabel lbEstadoMae = new JLabel("Estado Nasc. Mae: ",SwingConstants.RIGHT);
	protected JLabel lbNomePai = new JLabel("Pai: ",SwingConstants.RIGHT);
	protected JLabel lbEnd = new JLabel("Endereço: ",SwingConstants.RIGHT);
	protected JLabel lbCidade = new JLabel("Cidade Nasc.: ",SwingConstants.RIGHT);
	protected JLabel lbEstado = new JLabel("Estado Nasc.: ",SwingConstants.RIGHT);
	protected JLabel lbFone = new JLabel("Telefone: ",SwingConstants.RIGHT);
	protected JLabel lbDataMatricula = new JLabel("Data Matrícula: ",SwingConstants.RIGHT);
	protected JLabel lbTransferencia = new JLabel("Admitido por Transferência? ",SwingConstants.RIGHT); // Tem que ativar um campo de data
	protected JLabel lbSituacao = new JLabel("Situação Atual: ",SwingConstants.RIGHT);
	protected JLabel lbRefBox = new JLabel("Cod. Caixa");
	protected JLabel lbLocaInter = new JLabel("Localização Interna");
	
	protected JTextField tfNome = new JTextField();
	protected JTextField tfCodigo = new JTextField();
	protected JTextField tfCidade = new JTextField();
	protected JTextField tfEnd = new JTextField();
	protected JTextField tfNomeMae = new JTextField();
	protected JTextField tfRefBox = new JTextField();
	protected JTextField tfLocaInter = new JTextField();
	
	protected JFormattedTextField ftCpf = new JFormattedTextField(padrao.getMascaraCPF());
	protected JFormattedTextField ftDataNasc = new JFormattedTextField(padrao.getMascaraData());
	protected JFormattedTextField ftDataMatricula = new JFormattedTextField(padrao.getMascaraData());
	protected JFormattedTextField ftFone = new JFormattedTextField(padrao.getMascaraTelefone());

	protected ArrayList<Aluno> listaAluno = new ArrayList<Aluno>();
	protected ArrayList<Documento> listaDocumento = new ArrayList<Documento>();
	protected ArrayList<Ata> listaAta = new ArrayList<Ata>();
	
	protected AlunoTableModel modeloAluno = new AlunoTableModel(listaAluno);
	protected AtaTableModel modeloAta = new AtaTableModel(listaAta);
	protected DocumentoTableModel modeloDoc = new DocumentoTableModel(listaDocumento);
	
	protected JTable tabela = padrao.getTabela();
	
	protected ArquivoDAO arquivoDao = new ArquivoDAO(conexaoBD);

	private Aluno aluno;
	
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
	
	protected ActionListener onClickDocumento = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			tabela.setModel(modeloDoc);
			tabela.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			int x = tabela.getWidth()/tabela.getColumnCount();
			
			for(int i=0;i<tabela.getColumnCount();i++) {
				tabela.getColumnModel().getColumn(i).setPreferredWidth(x);
			}
		}
	};
	
	protected ActionListener onClickAta = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			tabela.setModel(modeloAta);
			tabela.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			int x = tabela.getWidth()/tabela.getColumnCount();
			
			for(int i=0;i<tabela.getColumnCount();i++) {
				tabela.getColumnModel().getColumn(i).setPreferredWidth(x);
			}
		}

	};
	
	protected ActionListener onClickPesquisar = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			//TODO o set dos formularios para aluno
			pesquisarCaixa(); // procura a referencia de caixas onde o aluno esta inserido
		}
	};

	protected void pesquisarCaixa() {
		String localizar = tfLocalizar.getText().trim();
		 
		 // colocar as informações para o cliente
		 try {
			 Arquivo arquivo = arquivoDao.buscar(localizar);
			 tfRefBox.setText(arquivo.getCodigoCaixa()); // a caixa em que se encontram os documentos
			 tfLocaInter.setText(arquivo.getCodDossie()); // a localização interna dos documentos
		 }catch (NullPointerException e) {
			 tfRefBox.setText("Sem caixa");
			 tfLocaInter.setText("Sem caixa");
		 }
	}
}
