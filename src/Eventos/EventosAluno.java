package Eventos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import ComponentGroupPlus.MaskFormatterGroup;
import ComponentGroupPlus.PainelTabela;
import ExceptionSLDA.erroNullRequisitoException;
import Forms.MainJFrame;
import Forms.PlusPainelDiscenteArquivo;
import Forms.PlusPainelDiscenteAta;
import Forms.PlusPainelDiscenteLista;
import Model.Aluno;
import Model.Ata;
import Model.AtaResultado;
import Model.Documento;
import PrimaryKey.AlunoPK;
import TablesModel.AlunoTableModel;
import TablesModel.AtaResultadoTableModel;
import TablesModel.AtaTableModel;
import TablesModel.DocumentoTableModel;

/**
 * Classe responsavel pelos eventos do painelAluno
 * 
 * @author Walysson Oliveira
 * @author Adryano Escorcio
 * @version 2.0
 * @extends EventoPadrão
 **/
public class EventosAluno extends EventosPadrao{
	
	//Listas
	protected List<Aluno> listaAluno = new ArrayList<Aluno>();
	protected List<Documento> listaDocumento = new ArrayList<Documento>();
	protected List<AtaResultado> listaAtaResul = new ArrayList<AtaResultado>();
	
	// Table Model
	public AlunoTableModel modeloAlunoTable = new AlunoTableModel(listaAluno);
	protected AtaResultadoTableModel modeloAtaResultado = new AtaResultadoTableModel(listaAtaResul);
	protected DocumentoTableModel modeloDoc = new DocumentoTableModel(listaDocumento);
	
	// Tabela
	public PainelTabela tablePadrao = new PainelTabela(); // instancia da tabela padrao
	private JTable tabela = tablePadrao.getTabela(); // setando a tabela padrao
	
	// Objeto Mask
	private MaskFormatterGroup mask = new MaskFormatterGroup();	
	protected List<Ata> listaAta = new ArrayList<Ata>();;
	protected AtaTableModel modeloAta = new AtaTableModel(listaAta);
	
	//COMPONENTES NECESSÁRIOS
	protected JTextField tfNome = new JTextField();
	protected JTextField tfCodigo = new JTextField();
	protected JTextField tfCidade = new JTextField();
	protected JTextField tfEnd = new JTextField();
	protected JTextField tfNomeMae = new JTextField();
	protected JTextField tfRefBox = new JTextField();
	protected JTextField tfNis = new JTextField();
	protected JTextField tfNumCertificado = new JTextField();
	protected JTextField tfLocaInter = new JTextField();
	protected JTextField tfLivro = new JTextField();
	protected JTextField tfFolha = new JTextField();
	protected JFormattedTextField ftCpf = new JFormattedTextField(mask.getMascaraCPF());
	protected JFormattedTextField ftDataNasc = new JFormattedTextField(mask.getMascaraData());
	protected JFormattedTextField ftDataMatricula = new JFormattedTextField(mask.getMascaraData());
	protected JFormattedTextField ftDataReg = new JFormattedTextField(mask.getMascaraData());
	protected JFormattedTextField ftFone = new JFormattedTextField(mask.getMascaraTelefone());
	protected JComboBox<String> comboUFAluno = comboGroup.getComboBoxEstadosBR();
	protected JComboBox<String> comboCor = comboGroup.getComboBoxCorRaca();
	protected JComboBox<String> comboSexo = comboGroup.getComboBoxSexo();
	protected JComboBox<String> comboTranferencia = comboGroup.getComboBoxTransferencia();
	protected JComboBox<String> comboSituacao = comboGroup.getComboBoxSituacaoAluno();
	
	private MainJFrame main;
	
	public EventosAluno(MainJFrame mainJFrame) {
		this.main = mainJFrame;
	}

	public MainJFrame getMain() {
		return main;
	}

	public void setMain(MainJFrame main) {
		this.main = main;
	}

	@Override	
	public void limparCampos(){
		
		tfNome.setText("");
		tfCodigo.setText("");
		tfCidade.setText("");
		tfEnd.setText("");
		tfNomeMae.setText("");
		tfRefBox.setText("");
		tfLocaInter.setText("");
		tfNis.setText("");
		tfNumCertificado.setText("");
		tfFolha.setText("");
		tfLivro.setText("");
		
		tfCodigo.setEditable(true);

		ftCpf.setText("");
		ftDataReg.setText("");
		ftDataNasc.setText("");
		ftDataMatricula.setText("");
		ftFone.setText("");	
		
		comboUFAluno.setSelectedIndex(0);
		comboCor.setSelectedIndex(0);		
		comboSexo.setSelectedIndex(0);	
		comboTranferencia.setSelectedIndex(0);	
		comboSituacao.setSelectedIndex(0);	
		
		btnAlterar.setEnabled(false); // necessario a pesquisa para ativar botão
		btnExcluir.setEnabled(false);
		btnAtaResul.setEnabled(false);
		btnDocumento.setEnabled(false);
		btnSalvar.setEnabled(true);
		btnCaixa.setEnabled(false);
		
		modeloAtaResultado.clear();
	}
	
	@Override
	public Aluno getValoresDosCampos(){
		
		if(!tfCodigo.getText().trim().equals("")){
			
			aluno = new Aluno();
			aluno.setNomeAluno(tfNome.getText());
			aluno.setCodigo(tfCodigo.getText());
			aluno.setCidadeNascAluno(tfCidade.getText());
			aluno.setEnderecoAluno(tfEnd.getText());
			aluno.setNomeMae(tfNomeMae.getText());
			aluno.setNis(tfNis.getText());
			aluno.setNumCertificado(tfNumCertificado.getText());
			aluno.setFolha(tfFolha.getText());
			aluno.setLivro(tfLivro.getText());
			
			aluno.setCPF_Aluno(mask.verificarMascara(ftCpf));
			aluno.setDataNascimento(mask.verificarMascara(ftDataNasc));
			aluno.setDataMatriculaAluno(mask.verificarMascara(ftDataMatricula));
			aluno.setTelefoneAluno(mask.verificarMascara(ftFone));
			aluno.setDataRegCertif(mask.verificarMascara(ftDataReg));
			
			aluno.setEstadoNascAluno((String) comboUFAluno.getSelectedItem());
			aluno.setCorAluno((String) comboCor.getSelectedItem());
			aluno.setSexoAluno((String) comboSexo.getSelectedItem());
			aluno.setTranferenciaAluno((String) comboTranferencia.getSelectedItem());
			aluno.setSituacaoAluno((String) comboSituacao.getSelectedItem());	
			
			return aluno;
			
		} else{
			throw new erroNullRequisitoException("(ER02) Preencha todos os requisitos com dados válidos.", "ERRO ER02");
		}
	}
	
	@Override
	public void setValoresDosCampos(Object object) throws NullPointerException{
		Aluno aluno = (Aluno) object;
		
		tfNome.setText(aluno.getNomeAluno());
		tfCodigo.setText(aluno.getCodigo());
		tfCidade.setText(aluno.getCidadeNascAluno());
		tfEnd.setText(aluno.getEnderecoAluno());
		tfNomeMae.setText(aluno.getNomeMae());
		tfNis.setText(aluno.getNis());
		tfNumCertificado.setText(aluno.getNumCertificado());
		tfLivro.setText(aluno.getLivro());
		tfFolha.setText(aluno.getFolha());
		
		ftCpf.setText(aluno.getCPF_Aluno());
		ftDataNasc.setText(aluno.getDataNascimento());
		ftDataMatricula.setText(aluno.getDataMatriculaAluno());
		ftFone.setText(aluno.getTelefoneAluno());
		ftDataReg.setText(aluno.getDataRegCertif());
		
		comboUFAluno.setSelectedItem(aluno.getEstadoNascAluno());
		comboCor.setSelectedItem(aluno.getCorAluno());
		comboSexo.setSelectedItem(aluno.getSexoAluno());
		comboTranferencia.setSelectedItem(aluno.getTranferenciaAluno());
		comboSituacao.setSelectedItem(aluno.getSituacaoAluno());
	}

	//OBJETO ActionListener QUE SALVA O ALUNO
	protected ActionListener onClickAlterarAluno = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			aluno = (Aluno) getValoresDosCampos();
			Aluno aluno2 = daoAluno.buscar(aluno.getCodigoKEY());
			
			if(!aluno.toString().equals(aluno2.toString())) {
				metodoSalvar();
				
			} else {
				JOptionPane.showMessageDialog(null, "(AT01) Não houve modificação.","ATENÇÃO AT01", 
						JOptionPane.WARNING_MESSAGE);
			}
		}
	};
	
	//OBJETO ActionListener QUE SALVA O ALUNO
	protected ActionListener onClickSalvarAluno = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			String codigo = tfCodigo.getText().trim(); // pega o codigo digitado pelo cliente.

			AlunoPK pk = new AlunoPK(); // chave primaria da caixa.
			pk.setCodigo(codigo); // seta a chave
			
			try{
				daoAluno.buscar(pk).getCodigo(); // realiza a busca no banco de dados
				throw new erroNullRequisitoException("(ER04) Aluno \"" +codigo+ "\" já existe.", "ERRO ER04");
			}catch(NullPointerException exc){
				metodoSalvar();
			}
			
		}
	};
	
	//OBJETO ActionListener QUE BUSCA O ALUNO NO BANCO
	protected ActionListener onClickBuscarAluno = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			String codigoLocalizar = tfLocalizar.getText().trim(); // pega o codigo digitado pelo cliente.
			if(verificarCodigo(codigoLocalizar)) {
				buscarCodigo(codigoLocalizar);
			} else {
				buscaNomeAluno(codigoLocalizar);
			}
		}
	};

	//OBJETO ActionListener QUE EXCLUE O ALUNO NO BANCO
	protected ActionListener onClickExcluirAluno = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {			
			if(JOptionPane.showConfirmDialog(null, "Deseja excluir o Discente?") == 0) {
				daoAluno.remover(aluno);
				JOptionPane.showMessageDialog(null, "Discente excluído com sucesso.");
				limparCampos();
			}
		}
	};
	
	protected ActionListener onClickCaixa = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {			
			PlusPainelDiscenteArquivo painelDisCaixa = 
					new PlusPainelDiscenteArquivo(EventosAluno.this);
			main.addCamada(painelDisCaixa.getMainDialog(),"Inserir Aluno-Caixa");
		}
	};
	
	//OBJETO ActionListener QUE LIMPA OS CAMPOS DA TELA
	protected ActionListener onClickLimparCampos = new ActionListener() {	
		@Override
		public void actionPerformed(ActionEvent e) {
			limparCampos();
		}
	};
			
	protected ActionListener onClickDocumento = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			tabelaDocumento();
		}
	};
	
	protected ActionListener onClickAtaResul = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			if(JOptionPane.showConfirmDialog(null, "Deseja inserir ou remover o aluno de uma ata?") == 0) {
				PlusPainelDiscenteAta painelDiscAta = 
						new PlusPainelDiscenteAta(EventosAluno.this);
				
				main.addCamada(painelDiscAta.getMainDialog(), "Inserir Aluno-Ata");
			}
		}
	};
	
	public void tabelaAta(Aluno aln){
		List<AtaResultado> lista = daoAtaResultado.buscarAtaporAluno(aln); // realizando a busca
		listaAtaResul = lista; // passando para a variavel global
		modeloAtaResultado.setList(lista); // Inserindo a nova lista no modelo
	}
	
	/**
	 * Verificar se o codigo digitado pelo usuário é numero ou letra
	 **/
	protected boolean verificarCodigo(String codigoLocalizar) {
		try {
			Integer.parseInt(codigoLocalizar); // caso erro tratar no catch
			return true;
		}catch(Exception ex) {
			return false;
		}
	}

	/**
	 * Realizar a busca por nome do aluno
	 **/
	protected void buscaNomeAluno(String nomeLocalizar) {
		List<Aluno> lista = daoAluno.buscarNome(nomeLocalizar);
		listaAluno = lista;
		modeloAlunoTable.setList(lista);
		if (lista.size() > 0) {
			PlusPainelDiscenteLista painelListaDiscente = 
					new PlusPainelDiscenteLista(EventosAluno.this);
			main.addCamada(painelListaDiscente.getMainDialog(), "Selecionar Aluno");
			
		}
	}

	/**
	 * Realiza busca usando o codigo do Aluno
	 **/
	protected void buscarCodigo(String codigoLocalizar) {
		
		AlunoPK pk = new AlunoPK(); // chave primaria da caixa.
		pk.setCodigo(codigoLocalizar); // seta a chave

		try{
			Aluno aln = daoAluno.buscar(pk); // realiza a busca no banco de dados
			processoMostarAluno(aln);
		} catch(NullPointerException exc){
			throw new erroNullRequisitoException("(ER03) Nenhum Aluno \"" +codigoLocalizar+ "\" foi encontrada.", "ERRO ER03");
		}		
	}

	public void processoMostarAluno(Aluno aln) {
		setValoresDosCampos(aln); // atribui os valores recuperados para os campos.
		pesquisarCaixa(aln); // pesquisa se o aluno se encontra em alguma caixa
		pesquisarDoc();

		modeloDoc = new DocumentoTableModel(daoDoc.buscarDocumentoporAluno(aln));
		tabelaDocumento();
		tabelaAta(aln);

		btnAlterar.setEnabled(true); // necessario a pesquisa para ativar botão
		btnExcluir.setEnabled(true); // necessario a pesquisa para ativar botão
		btnAtaResul.setEnabled(true);
		btnDocumento.setEnabled(true);
		btnCaixa.setEnabled(true);
		
		btnSalvar.setEnabled(false); // nao sera possivel salvar, somente alterar
		tfCodigo.setEditable(false); // nao sera possivel alterar o codigo de objeto consultado.
		
		aluno = aln;
	}

	private void tabelaDocumento(){
		tabela.setModel(modeloDoc);
	}

	public void normalizarCamadas() {
		main.normalizarCamadas();
		try {
			tabelaAta(aluno);
		}catch (Exception ex) {
			// nenhum aluno foi escolhido pelo usuário. sem erro. 
		}
	}
 
	protected void pesquisarCaixa(Aluno aln) {
		String localizar = aln.getCodigo();
		 
		 // colocar as informações para o cliente
		 try {
			 arquivo = daoArquivo.buscar(localizar);
			 tfRefBox.setText(arquivo.getCodigoCaixa()); // a caixa em que se encontram os documentos
			 tfLocaInter.setText(arquivo.getCodDossie()); // a localização interna dos documentos
		 }catch (NullPointerException e) {
			 tfRefBox.setText("Sem caixa");
			 tfLocaInter.setText("Sem caixa");
		 }
	}
	
	protected void pesquisarDoc() {
		// TODO Auto-generated method stub
	}

	private void metodoSalvar() {
		// Tentar pegar os valores
		aluno = (Aluno) getValoresDosCampos();
		String matricula = aluno.getCodigo();
		String nome = aluno.getNomeAluno();
		String data = aluno.getDataNascimento();
		
		// Verificar se os campos foram digitados
        if(matricula.equals("") || 
        	nome.equals("") || data.equals("")){
        	JOptionPane.showMessageDialog(null, "Preencha os campos obrigatórios.", "ER08", JOptionPane.ERROR_MESSAGE);                
        }else if(daoAluno.save(aluno)) {
        	JOptionPane.showMessageDialog(null, SUCESSO);
			limparCampos();
			//LIMPA A CAIXA
			aluno = null;
        }
	}

	public List<AtaResultado> getListaAtaResul() {
		return listaAtaResul;
	}

	public void setListaAtaResul(List<AtaResultado> listaAtaResul) {
		this.listaAtaResul = listaAtaResul;
	}	
}
