package Eventos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import ComponentGroupPlus.PainelTabela;
import ExceptionSLDA.erroNullRequisitoException;
import Model.Caixa;
import PrimaryKey.CaixaPK;
import TablesModel.CaixaTableModel;

/**
 * Classe responsavel pelos eventos do painelCaixa
 * $$
 * @author Walysson Oliveira
 * @author Adryano Escorcio
 * @version 2.0
 * @extends EventoPadrão
 **/

public class EventosCaixa extends EventosPadrao {
       
        //OBJETO UTILIZADO NAS BUSCAS
        Caixa caixaPesquisa = new Caixa();
               
        //COMPARADOR DE OBJETOS PARA ORDENAR O ARRAY
        ComparadorObjetos comparador = new ComparadorObjetos();
       
        //TABELA
        PainelTabela table = new PainelTabela();
        protected JTable tabela = table.getTabela();
        protected List<Caixa> lista = daoCaixa.getTodasCaixas();
        protected CaixaTableModel modelo;
       
        //COMPONENTES NECESSÁRIOS
        protected JTextField tfCodigo = new JTextField();
        protected JComboBox<String> comboTurno = comboGroup.getComboBoxTurno();
        protected JComboBox<String> comboLetra = comboGroup.getComboBoxLetra();
        protected JComboBox<String> comboStatus = comboGroup.getComboBoxStatus();
       
        public EventosCaixa() {
                //INICIA A TABELA ORDENADA
                Collections.sort(lista, comparador);
                modelo = new CaixaTableModel(lista);
                btnAlterar.setEnabled(false); // necessario a pesquisa para ativar botão
                btnExcluir.setEnabled(false); // necessario a pesquisa para ativar botão
        }
       
        @Override
        public Object getValoresDosCampos() {
               
                if(!tfCodigo.getText().trim().equals("")){
                       
                        caixa = new Caixa();
                        caixa.setCodigo(tfCodigo.getText().trim());
                        caixa.setTurno((String) comboTurno.getSelectedItem());
                        caixa.setStatus((String) comboStatus.getSelectedItem());
                        caixa.setLetra((String) comboLetra.getSelectedItem());
                       
                        return caixa;
                } else {
                        throw new erroNullRequisitoException("(ER02) Preencha todos os requisitos com dados válidos.", "ERRO ER02");
                }
        }

        @Override
        public void setValoresDosCampos(Object object) throws NullPointerException {
                Caixa caixa = (Caixa) object;
               
                tfCodigo.setText(caixa.getCodigo());
                comboTurno.setSelectedItem(caixa.getTurno());
                comboLetra.setSelectedItem(caixa.getLetra());
                comboStatus.setSelectedItem(caixa.getStatus());
        }
       
        /**
         * Metodos que realiza a função de limpar os campos.
         **/
        protected ActionListener onClickLimparCampos = new ActionListener() {  
                @Override
                public void actionPerformed(ActionEvent e) {
                        limparCampos();
                }
        };
       
        /**
         * Necessário verificar se houve alteração para poder atualiza a caixa modificada.
         **/
        protected ActionListener onClickAlterarCaixa = new ActionListener() {
               
                @Override
                public void actionPerformed(ActionEvent e) {
                        caixa = (Caixa) getValoresDosCampos();
                       
                        if(!caixa.toString().equals(caixaPesquisa.toString())) {                        
                                if(daoCaixa.save(caixa)) {
                                        JOptionPane.showMessageDialog(null, SUCESSO);
                                        modelo.updateContato(caixaPesquisa, caixa);
                                        limparCampos();
                                }      
                        } else {
                                JOptionPane.showMessageDialog(null, "(AT01) Não houve modificação.","ATENÇÃO AT01",
                                                JOptionPane.WARNING_MESSAGE);
                        }
                }
        };
       
        /**
         * Metodo com a função de salvar e alterar uma caixa.
         **/
        protected ActionListener onClickSalvarCaixa = new ActionListener() {
               
                @Override
                public void actionPerformed(ActionEvent e) {
                        caixa = (Caixa) getValoresDosCampos();

                        //BUSCA NECESSARIO PARA SABER SE O OBJETO JÁ EXISTE NO BANCO
                        CaixaPK pk = new CaixaPK();
                        pk.setCodigo(caixa.getCodigo());
                        try{
                                daoCaixa.buscar(pk).getCodigo();
                                throw new erroNullRequisitoException("(ER04) Caixa \"" + caixa.getCodigo() + "\" já existe.", "ERRO ER04");
                        }catch(NullPointerException exc){
                               
                                if(daoCaixa.save(caixa)) {
                                        JOptionPane.showMessageDialog(null, SUCESSO);
                                        lista.add(caixa);
                                        //ORDENA A LISTA
                                        Collections.sort(lista, comparador);
                                        //RECRIA A TABELA
                                        modelo = new CaixaTableModel(lista);
                                        tabela.setModel(modelo);
                                        limparCampos();
                                }
                        }
                }
        };

        /***
         * Metodo com  a função de buscar um caixa
         */
        protected ActionListener onClickBuscarCaixa = new ActionListener() {
               
                @Override
                public void actionPerformed(ActionEvent e) {
               
                        String codigoLocalizar = tfLocalizar.getText().trim(); // pega o codigo digitado pelo cliente.

                        CaixaPK pk = new CaixaPK(); // chave primaria da caixa.
                        pk.setCodigo(codigoLocalizar); // seta a chave

                        try{
                                caixaPesquisa = daoCaixa.buscar(pk); // realiza a busca no banco de dados
                                setValoresDosCampos(caixaPesquisa); // atribui os valores recuperados para os campos.
                                habilitarBotoes(true);  
                       
                        }catch(NullPointerException exc){
                                throw new erroNullRequisitoException("(ER03) Nenhuma Caixa \"" +codigoLocalizar+ "\" foi encontrada.", "ERRO ER03");
                        }
                }
        };

        /**
         * Metodo com a função de excluir uma caixa
         **/
        protected ActionListener onClickExcluirCaixa = new ActionListener() {
               
                @Override
                public void actionPerformed(ActionEvent e) {
                       
                        if (JOptionPane.showConfirmDialog(null, "Deseja excluir a Caixa?") == 0) {
                                daoCaixa.remover(caixaPesquisa);
                                JOptionPane.showMessageDialog(null, "Caixa excluído com sucesso.");
                                modelo.removeContato(caixaPesquisa);
                                limparCampos();
                               
                                //LIMPA A CAIXA
                                caixa = null;
                        }
                }
        };
       
        //OBJETO QUE REALIZA UMA BUSCA ATRAVÉS DAS LINHAS DA TABELA
        protected MouseListener onClickRowTable = new MouseListener() {

                @Override
                public void mouseClicked(MouseEvent e) {
                        if(e.getClickCount() == 2){
                                int linha = tabela.getSelectedRow();
                                caixaPesquisa = modelo.getContato(linha);
                               
                                setValoresDosCampos(caixaPesquisa);
                                habilitarBotoes(true);
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
       
        @Override
        public void limparCampos() {
                tfCodigo.setText(null);
                comboTurno.setSelectedIndex(0);
                comboLetra.setSelectedIndex(0);
                comboStatus.setSelectedIndex(0);
               
                habilitarBotoes(false);
        }
       
        //METODO PARA HABILITAR OU DESABILITAR OS BOTOES QUE INICIAM Enabled E TAMBÉM OUTROS COMPONENTES NECESSÁRIOS
        public void habilitarBotoes(boolean bool) {
               
                btnAlterar.setEnabled(bool);
                btnExcluir.setEnabled(bool);
                btnSalvar.setEnabled(!bool);
                tfCodigo.setEditable(!bool);
        }
       
        //PEQUENA CLASSE DE COMPARAÇÃO UTILIZADA NA ORDENAÇÃO DA LISTA
        public static class  ComparadorObjetos implements Comparator<Caixa> {
     
                @Override
                public int compare(Caixa objetoParaComparar, Caixa objetoAserComparado) {
                        return  objetoParaComparar.getCodigo().compareTo(objetoAserComparado.getCodigo());
                }
    }          
}
