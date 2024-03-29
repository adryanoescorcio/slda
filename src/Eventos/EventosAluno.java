	package Eventos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import ComponentGroupPlus.PainelTabela;
import ExceptionSLDA.erroNullRequisitoException;
import Forms.MainJFrame;
import Forms.PlusPainelDiscenteLista;
import Forms.PlusPainelDocumento;
import Model.Aluno;
import Model.Arquivo;
import Model.Ata;
import Model.AtaResultado;
import Model.Documento;
import PrimaryKey.AlunoPK;
import PrimaryKey.ArquivoPK;
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
 * @extends EventoPadr�o
 **/

public class EventosAluno extends EventosPadrao {

	//Listas
	protected List<Aluno> listaAluno = new ArrayList<Aluno>();
	protected List<Documento> listaDocumento = new ArrayList<Documento>();
	protected List<AtaResultado> listaAtaResul = new ArrayList<AtaResultado>();

	// Table Model
	public AlunoTableModel modeloAlunoTable = new AlunoTableModel(listaAluno);
	protected AtaResultadoTableModel modeloAtaResultado = new AtaResultadoTableModel(listaAtaResul);
	protected DocumentoTableModel modeloDoc = new DocumentoTableModel(listaDocumento);

	// Tabela
	protected PainelTabela table = new PainelTabela();

	// Objeto Mask
	protected List<Ata> listaAta = new ArrayList<Ata>();;
	protected AtaTableModel modeloAta = new AtaTableModel(listaAta);

	//COMPONENTES NECESS�RIOS
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
	protected JFormattedTextField ftData = new JFormattedTextField(mask.getMascaraData());
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
		
		ftData.setValue(null);
		ftCpf.setValue(null);
		ftDataReg.setValue(null);
		ftDataNasc.setValue(null);
		ftDataMatricula.setValue(null);
		ftFone.setValue(null);	

		comboUFAluno.setSelectedIndex(0);
		comboCor.setSelectedIndex(0);		
		comboSexo.setSelectedIndex(0);	
		comboTranferencia.setSelectedIndex(0);	
		comboSituacao.setSelectedIndex(0);	

		//DESABILITA OS BOTOES
		habilitarBotoes(false);		
		modeloAtaResultado.clear();
		modeloDoc.clear();
		
	}

	 @Override
     public Aluno getValoresDosCampos(){

             aluno = new Aluno();
            
             //TESTA SE O CAMPO C�DIGO DO ALUNO EST� VAZIO, SE SIM ELE GERA AUTOMATICAMENTE UM C�DIGO
             if(tfCodigo.getText().trim().equals("")){
            	 String codigo = daoAluno.gerarCodigo();
            	 System.out.println(codigo + " SKIS");
                     aluno.setCodigo(codigo);
             }else{
                     aluno.setCodigo(tfCodigo.getText());
             }
            
             if(!tfNome.getText().trim().equals("")){

                     aluno.setNomeAluno(tfNome.getText());
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
                     throw new erroNullRequisitoException("(ER02) Preencha todos os requisitos com dados v�lidos.", "ERRO ER02");
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
				metodoSalvarValidar();

			} else {
				JOptionPane.showMessageDialog(null, "(AT01) N�o houve modifica��o.","ATEN��O AT01", 
						JOptionPane.WARNING_MESSAGE);
			}
		}
	};

	//OBJETO ActionListener QUE SALVA O ALUNO
	protected ActionListener onClickSalvarAluno = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			String codigo = tfCodigo.getText().trim(); // pega o codigo digitado pelo cliente.

			if(!(codigo.length() >= 4 && codigo.substring(0, 4).equals("SLDA"))) {
				AlunoPK pk = new AlunoPK(); // chave primaria da caixa.
				pk.setCodigo(codigo); // seta a chave
	
				try{
					// realiza a busca no banco de dados
					daoAluno.buscar(pk).getCodigo();
					throw new erroNullRequisitoException("(ER04) Aluno \"" +codigo+ "\" j� existe.", "ERRO ER04");
				}catch(NullPointerException exc){
					metodoSalvarValidar();
				}
			} else {
				JOptionPane.showMessageDialog(null, "Codigo digitado � invalido.");
			}
		}
	};

	//OBJETO ActionListener QUE BUSCA O ALUNO NO BANCO
	protected ActionListener onClickBuscarAluno = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			aluno = null;
			String codigoLocalizar = tfLocalizar.getText().trim(); // pega o codigo digitado pelo cliente.
			
			try {
				if(codigoLocalizar.length() >= 4 && codigoLocalizar.substring(0, 4).equals("SLDA")) {
					buscarCodigo(codigoLocalizar);
				} else if (verificarCodigo(codigoLocalizar)){
					buscarCodigo(codigoLocalizar);
				} else {
					buscaNomeAluno(codigoLocalizar);
				}
			} catch (IndexOutOfBoundsException ex) {
				
			}
		}
	};

	//OBJETO ActionListener QUE EXCLUI O ALUNO NO BANCO
	protected ActionListener onClickExcluirAluno = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {			
			if(JOptionPane.showConfirmDialog(null, "Deseja excluir o Discente?") == 0) {
				
				//CHAVE DO TIPO ARQUIVO - NECESSARIO PARA EXCLUIR O ALUNO DA CAIXA
				ArquivoPK pk = new ArquivoPK();
				pk.setCodigoAluno(aluno.getCodigo());
				
				//REMOVE O ALUNO E SEUS VEST�GIOS
				daoAluno.remover(aluno);
				daoAtaResultado.excluirPorAluno(aluno);
				daoArquivo.remover(pk);
				
				JOptionPane.showMessageDialog(null, "Discente exclu�do com sucesso.");
				limparCampos();
			}
		}
	};

	protected ActionListener onClickCaixa = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {	
			if(JOptionPane.showConfirmDialog(null, "Deseja inserir/remover o aluno de uma caixa?") == 0) {
				try {
					main.mudarPerfilCaixa(aluno, EventosAluno.this);
					main.direcionarParaCamada(1);
				} catch (Exception ex) {
					// o metodo foi parado por falta dos requisitos minimos.
				}
			}
		}
	};
	
	protected MouseListener onClickMudarTabelaAta = new MouseListener() {

		@Override
		public void mouseClicked(MouseEvent e) {
			if(e.getClickCount() == 1){
				scroll = table.organizandoColunasTables(modeloAtaResultado);
			} else if (e.getClickCount() == 2) {
				if(JOptionPane.showConfirmDialog(null, "Deseja inserir/remover o aluno de uma ata?") == 0) {
					try {
						main.mudarPerfilAta(aluno);
						main.direcionarParaCamada(2);
					} catch (Exception ex) {
						// o metodo foi parado por falta dos requisitos minimos.
					}
				}
			}
		}
		
		@Override
		public void mouseEntered(MouseEvent e) {}
		@Override
		public void mouseExited(MouseEvent e) {}
		@Override
		public void mousePressed(MouseEvent e) {}
		@Override
		public void mouseReleased(MouseEvent e) {}
	};
	
	protected MouseListener onClickDocumento = new MouseListener() {

		@Override
		public void mouseClicked(MouseEvent e) {
			if(e.getClickCount() == 1){
				scroll = table.organizandoColunasTables(modeloAtaResultado);
			} else if (e.getClickCount() == 2) {
				if(JOptionPane.showConfirmDialog(null, "Deseja inserir/remover o aluno de um documento?") == 0) {
					try {
						main.mudarPerfilAta(aluno);
						main.direcionarParaCamada(2);
					} catch (Exception ex) {
						// o metodo foi parado por falta dos requisitos minimos.
					}
				}
			}
		}
		
		@Override
		public void mouseEntered(MouseEvent e) {}
		@Override
		public void mouseExited(MouseEvent e) {}
		@Override
		public void mousePressed(MouseEvent e) {}
		@Override
		public void mouseReleased(MouseEvent e) {}
	};


	protected MouseListener onClickMudarTabelaDocumento = new MouseListener() {

		@Override
		public void mouseClicked(MouseEvent e) {
			if(e.getClickCount() == 1){
				scroll = table.organizandoColunasTables(modeloDoc);
			} else if (e.getClickCount() == 2) {
				if(JOptionPane.showConfirmDialog(null, "Deseja inserir/remover o documento requisitado pelo aluno?") == 0) {
					try {
						 PlusPainelDocumento painelDocumento= new PlusPainelDocumento(main, EventosAluno.this);

						 main.addCamada(painelDocumento.getTelaPrincipal(), "Inserir Documento");
					} catch (Exception ex) {
						// o metodo foi parado por falta dos requisitos minimos.
					}
				}
			}
		}

		@Override
		public void mouseEntered(MouseEvent e) {
		}
		@Override
		public void mouseExited(MouseEvent e) {
		}
		@Override
		public void mousePressed(MouseEvent e) {
		}
		@Override
		public void mouseReleased(MouseEvent e) {
		}
	};
	
	protected MouseListener onClickSelecionarAtaAluno = new MouseListener() {

		@Override
		public void mouseClicked(MouseEvent e) {
			if (e.getClickCount() == 2) {
				if(JOptionPane.showConfirmDialog(null, "Deseja selecionar esta ata?") == 0) {
					try {
						int linha = table.getTabela().getSelectedRow();
						System.out.println(linha);
						 AtaResultado ataR = modeloAtaResultado.getContato(linha);
						 main.mudarPerfilAta(aluno, ataR);
						 main.direcionarParaCamada(2);
					} catch (Exception ex) {
						// o metodo foi parado por falta dos requisitos minimos.
					}
				}
			}
		}

		@Override
		public void mouseEntered(MouseEvent e) {
		}
		@Override
		public void mouseExited(MouseEvent e) {
		}
		@Override
		public void mousePressed(MouseEvent e) {
		}
		@Override
		public void mouseReleased(MouseEvent e) {
		}
	};
	
	//OBJETO ActionListener QUE LIMPA OS CAMPOS DA TELA
	protected ActionListener onClickLimparCampos = new ActionListener() {	
		@Override
		public void actionPerformed(ActionEvent e) {
			limparCampos();
		}
	};
	
	public void tabelaAta(Aluno aln){
		List<AtaResultado> lista = daoAtaResultado.buscarAtaporAluno(aln); // realizando a busca
		listaAtaResul = lista; // passando para a variavel global
		modeloAtaResultado.setList(lista); // Inserindo a nova lista no modelo
		scroll = table.organizandoColunasTables(modeloAtaResultado);
	}

	/**
	 * Verificar se o codigo digitado pelo usu�rio � numero ou letra
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
//		}
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
			throw new erroNullRequisitoException("(ER03) Nenhum Aluno \"" +codigoLocalizar+ "\" foi encontrado.", "ERRO ER03");
		}		
	}

	public void processoMostarAluno(Aluno aln) {
		setValoresDosCampos(aln); // atribui os valores recuperados para os campos.
		pesquisarCaixa(aln); // pesquisa se o aluno se encontra em alguma caixa
		pesquisarDoc();

		modeloDoc = new DocumentoTableModel(daoDoc.buscarDocumentoporAluno(aln));
		tabelaDocumento();
		tabelaAta(aln);

		//HABILITA OS BOTOES
		habilitarBotoes(true);

		aluno = aln;
	}

	private void tabelaDocumento(){
		scroll = table.organizandoColunasTables(modeloDoc);
	}

	public void direcionarParaCamada(int i) {
		main.direcionarParaCamada(i);
	}

	public void normalizarCamadas() {
		main.normalizarCamadas();
		try {
			tabelaAta(aluno);
		}catch (Exception ex) {
			// nenhum aluno foi escolhido pelo usu�rio. sem erro. 
		}
	}

	public void pesquisarCaixa(Aluno aln) {
		
		Arquivo arq = new Arquivo();
		ArquivoPK pk = new ArquivoPK();
		pk.setCodigoAluno(aln.getCodigo());

		// colocar as informa��es para o cliente
		try {
			arq = daoArquivo.buscar(pk);
		
			tfRefBox.setText("");
			tfLocaInter.setText("");
			ftData.setText("");
			
			tfRefBox.setText(arq.getCodigoCaixa()); // a caixa em que se encontram os documentos
			tfLocaInter.setText(arq.getCodDossie()); // a localiza��o interna dos documentos
			ftData.setText(arq.getDatadeEntradaArquivo());
			
			arq = null;
			
		}catch (NullPointerException e) {
			System.out.println(e.getMessage());
			tfRefBox.setText("Sem caixa");
			tfLocaInter.setText("Sem caixa");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void pesquisarDoc() {
		// TODO Auto-generated method stub
	}

	private void metodoSalvarValidar() {
		// Tentar pegar os valores
		aluno = (Aluno) getValoresDosCampos();
		String nome = aluno.getNomeAluno();
		String data = aluno.getDataNascimento().trim();

		// Verificar se os campos foram digitados
		if(nome.equals("") || data.length() < 10) {
			JOptionPane.showMessageDialog(null, "Preencha os campos obrigat�rios.", "ER08", JOptionPane.ERROR_MESSAGE);                
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
	
	//METODO PARA HABILITAR OU DESABILITAR OS BOTOES QUE INICIAM Enabled E TAMB�M OUTROS COMPONENTES NECESS�RIOS
	public void habilitarBotoes(boolean bool) {
		tfCodigo.setEditable(!bool);
		btnSalvar.setEnabled(!bool);
		btnAlterar.setEnabled(bool); 
		btnExcluir.setEnabled(bool);
		btnAtaResul.setEnabled(bool);
		btnDocumento.setEnabled(bool);
		btnCaixa.setEnabled(bool);
	}
}
