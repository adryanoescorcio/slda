package Eventos;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import ComponentGroupPlus.FontGroup;
import ComponentGroupPlus.MaskFormatterGroup;
import ComponentGroupPlus.PainelTabela;
import ExceptionSLDA.erroNullRequisitoException;
import Forms.TelaDeLogin;
import Model.Aluno;
import Model.Arquivo;
import Model.AtaResultado;
import Model.Documento;
import PrimaryKey.AlunoPK;
import TablesModel.AlunoTableModel;
import TablesModel.AtaResultadoTableModel;
import TablesModel.DocumentoTableModel;

/**
 * Classe responsavel pelos eventos do painelAluno
 * 
 * @author Walysson Oliveira
 * @author Adryano Escorcio
 * @version 2.0
 * @extends EventoPadrão
 **/
public class EventosAluno extends EventosPadrão{
	
	//Listas
	protected ArrayList<Aluno> listaAluno = new ArrayList<Aluno>();
	protected List<Documento> listaDocumento = new ArrayList<Documento>();
	protected List<AtaResultado> listaAtaResul = new ArrayList<AtaResultado>();
	
	// Table Model
	protected AlunoTableModel modeloAluno = new AlunoTableModel(listaAluno);
	protected AtaResultadoTableModel modeloAtaResultado = new AtaResultadoTableModel(listaAtaResul);
	protected DocumentoTableModel modeloDoc = new DocumentoTableModel(listaDocumento);
	
	// Tabela
	private PainelTabela table = new PainelTabela(); // instancia da tabela padrao
	private JTable tabela = table.getTabela(); // setando a tabela padrao
	
	// Objeto Mask
	private MaskFormatterGroup mask = new MaskFormatterGroup();	
	
	//COMPONENTES NECESSÁRIOS
	protected JTextField tfNome = new JTextField();
	protected JTextField tfCodigo = new JTextField();
	protected JTextField tfCidade = new JTextField();
	protected JTextField tfEnd = new JTextField();
	protected JTextField tfNomeMae = new JTextField();
	protected JTextField tfRefBox = new JTextField();
	protected JTextField tfLocaInter = new JTextField();
	protected JFormattedTextField ftCpf = new JFormattedTextField(mask.getMascaraCPF());
	protected JFormattedTextField ftDataNasc = new JFormattedTextField(mask.getMascaraData());
	protected JFormattedTextField ftDataMatricula = new JFormattedTextField(mask.getMascaraData());
	protected JFormattedTextField ftFone = new JFormattedTextField(mask.getMascaraTelefone());
	protected JComboBox<String> comboUFAluno = comboGroup.getComboBoxEstadosBR();
	protected JComboBox<String> comboCor = comboGroup.getComboBoxCorRaca();
	protected JComboBox<String> comboSexo = comboGroup.getComboBoxSexo();
	protected JComboBox<String> comboTranferencia = comboGroup.getComboBoxTransferencia();
	protected JComboBox<String> comboSituacao = comboGroup.getComboBoxSituacaoAluno();

	public EventosAluno() {
		btnAlterar.setEnabled(false); // necessario a pesquisa para ativar botão
		btnExcluir.setEnabled(false); // necessario a pesquisa para ativar botão
		alterarFontes();
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
		ftCpf.setText("");
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
		
		btnSalvar.setEnabled(true);
		tfCodigo.setEditable(true);
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
			aluno.setCPF_Aluno(ftCpf.getText());
			aluno.setDataNascimento(ftDataNasc.getText());
			aluno.setDataMatriculaAluno(ftDataMatricula.getText());
			aluno.setTelefoneAluno(ftFone.getText());
			aluno.setEstadoNascAluno((String) comboUFAluno.getSelectedItem());
			aluno.setCorAluno((String) comboCor.getSelectedItem());
			aluno.setSexoAluno((String) comboSexo.getSelectedItem());
			aluno.setTranferenciaAluno((String) comboTranferencia.getSelectedItem());
			aluno.setSituacaoAluno((String) comboSituacao.getSelectedItem());	
			return aluno;
			
		} else{
			throw new erroNullRequisitoException("(ER02) Preencha todos os requisitos com dados válidos.", "ERRO ER02",null);
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
		ftCpf.setText(aluno.getCPF_Aluno());
		ftDataNasc.setText(aluno.getDataNascimento());
		ftDataMatricula.setText(aluno.getDataMatriculaAluno());
		ftFone.setText(aluno.getTelefoneAluno());
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
		metodoSalvar();
		}
	};
	
	//OBJETO ActionListener QUE BUSCA O ALUNO NO BANCO
	protected ActionListener onClickBuscarAluno = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			String codigoLocalizar = tfLocalizar.getText().trim(); // pega o codigo digitado pelo cliente.

			AlunoPK pk = new AlunoPK(); // chave primaria da caixa.
			pk.setCodigo(codigoLocalizar); // seta a chave

			try{
				Aluno aln = daoAluno.buscar(pk); // realiza a busca no banco de dados
				setValoresDosCampos(aln); // atribui os valores recuperados para os campos.
				pesquisarCaixa(); // pesquisa se o aluno se encontra em alguma caixa
				pesquisarDoc();
				pesquisarAta(aln);
				btnAlterar.setEnabled(true); // necessario a pesquisa para ativar botão
				btnExcluir.setEnabled(true); // necessario a pesquisa para ativar botão
				
				btnSalvar.setEnabled(false); // nao sera possivel salvar, somente alterar
				tfCodigo.setEditable(false); // nao sera possivel alterar o codigo de objeto consultado.
				
				aluno = aln;
			
			} catch(NullPointerException exc){
				throw new erroNullRequisitoException("(ER03) Nenhum Aluno \"" +codigoLocalizar+ "\" foi encontrada.", "ERRO ER03",null);
			}
			
		}
	};

	//OBJETO ActionListener QUE EXCLUE O ALUNO NO BANCO
	protected ActionListener onClickExcluirAluno = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {			
			daoAluno.remover(aluno);
			JOptionPane.showMessageDialog(null, "Discente excluído com sucesso.");
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
			
	protected ActionListener onClickDocumento = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			tabela.setModel(modeloDoc);
			reconstruirTable();
		}
	};
	
	protected ActionListener onClickAtaResul = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			tabela.setModel(modeloAtaResultado);
			reconstruirTable();
			if(JOptionPane.showConfirmDialog(null, "Deseja inserir o aluno em uma ata?") == 0) {
				new TelaDeLogin();
			}
		}

	};
	
	protected void pesquisarCaixa() {
		String localizar = tfLocalizar.getText().trim();
		 
		 // colocar as informações para o cliente
		 try {
			 Arquivo arquivo = daoArquivo.buscar(localizar);
			 tfRefBox.setText(arquivo.getCodigoCaixa()); // a caixa em que se encontram os documentos
			 tfLocaInter.setText(arquivo.getCodDossie()); // a localização interna dos documentos
		 }catch (NullPointerException e) {
			 tfRefBox.setText("Sem caixa");
			 tfLocaInter.setText("Sem caixa");
		 }
	}
	
	protected void reconstruirTable() {
		tabela.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		int x = tabela.getWidth()/tabela.getColumnCount();
		
		for(int i=0;i<tabela.getColumnCount();i++) {
			tabela.getColumnModel().getColumn(i).setPreferredWidth(x);
		}
	}

	@SuppressWarnings("unchecked")
	protected void pesquisarAta(Aluno aln) {
		List lis = daoAta.buscaAta(aln);
		modeloAtaResultado.setList(lis);		
	}

	protected void pesquisarDoc() {
		// TODO Auto-generated method stub
		
	}

	private void metodoSalvar() {
		// Tentar pegar os valores
		aluno = (Aluno) getValoresDosCampos();
		
		// Caso seja salvo com sucesso
		if(daoAluno.save(aluno)) {
			JOptionPane.showMessageDialog(null, SUCESSO);
			limparCampos();
			
			//LIMPA A CAIXA
			aluno = null;
		}		
	}
	
	private void alterarFontes() {
		FontGroup font = new FontGroup();
		
		// JTextField
			tfNome.setFont(font.font_NEG_15);
			tfCidade.setFont(font.font_NEG_15);
			tfEnd.setFont(font.font_NEG_15);
			tfCodigo.setFont(font.font_NEG_15);
			tfRefBox.setFont(font.font_NEG_18);
			tfLocaInter.setFont(font.font_NEG_18);
			
			tfNome.setPreferredSize(new Dimension(450,0));
			tfCodigo.setPreferredSize(new Dimension(100,0));
			tfNomeMae.setPreferredSize(new Dimension(450,0));
			tfEnd.setPreferredSize(new Dimension(312,0));
			tfCidade.setPreferredSize(new Dimension(312,0));
			tfRefBox.setPreferredSize(new Dimension(130,0));
			tfLocaInter.setPreferredSize(new Dimension(130,0));
			
			// Button
			btnSalvar.setFont(font.font_PLA_14);
			
			btnLimpar.setFont(font.font_PLA_14);
			btnAlterar.setFont(font.font_PLA_14);
			btnExcluir.setFont(font.font_PLA_14);
			btnDocumento.setFont(font.font_PLA_14);
			btnAtaResul.setFont(font.font_PLA_14);
			btnCaixa.setFont(font.font_PLA_14);
			btnDocumento.setToolTipText("Documento");
			
			tfRefBox.setForeground(Color.RED);
			tfLocaInter.setForeground(Color.RED);
			
			// Outros
			ftFone.setBorder(null);
			ftCpf.setBorder(null);
			ftDataNasc.setBorder(null);
			ftDataMatricula.setBorder(null);
			
			//Desativando
			tfRefBox.setEditable(false);
			tfLocaInter.setEditable(false);
	}
}
