package Segurança;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

import Model.Senha;
import PrimaryKey.SenhaPK;

public class Validar extends MAC{

	private JPanel padrao = new JPanel();
	private JPasswordField campo = new JPasswordField(10);
	
	public Validar(Path url) {
		super(url);
		// TODO Auto-generated constructor stub
	}
	
	//--- MÉTODO QUE VERIFICA SE PELO MENOS UM MAC DA MÁQUINA É COMPATÍVEL COM O DO TXT
	public boolean validarMAC(){
		
		ArrayList<String> macs1 = new ArrayList<>();
		ArrayList<String> macs2 = new ArrayList<>();
		List<Senha> macsBD = dao.getSenhas();
		String mac = null;
		boolean boo = true;
		
		try{
			macs1 = getMac();
			macs2 = getMacTxt();
			mac = macsBD.get(0).getMac();
		}catch(IOException e){
			e.printStackTrace();
		}
		
		if(mac != null) {
			for (String string2 : macs2) {
				if(mac.equals(string2)){
					boo = false;
				}
			}
		}
		
		
		if(mac != null) {
			for (String string2 : macs1) {
				if(mac.equals(string2)){
					boo = false;
				}
			}
		}
		
		if(!boo){
			for (String string1 : macs1) {
				for (String string2 : macs2) {
					if(string1.equals(string2)){
						return true;
					}
				}
			}
			
		}
		
		return false;	
	}
	
	//--- MÉTODO QUE VERIFICA SE A SENHA É COMPATÍVEL
	public boolean validarSenha(){
		
		List<Senha> senhas = dao.getSenhas();
		
		if(senhas == null){
			
			JOptionPane.showMessageDialog(null, "Contatos:\n\n(98) 9163-0360\n(98) 8120-0104\n\nescorciomax@gmail.com\n" +
					"walysson21@gmail.com\n ", "Sem Permissão de Acesso", JOptionPane.WARNING_MESSAGE);
			
			return false;
		}
		padrao.add(new JLabel("Senha: "));
		padrao.add(campo);
		
		String[] options = new String[]{"Autenticar", "Cancelar"};
		
		int x = JOptionPane.showOptionDialog(null, padrao, "Permissão do Fabricante", 
				JOptionPane.NO_OPTION, JOptionPane.WARNING_MESSAGE, null, options, campo);
		
		String senha = String.valueOf(campo.getPassword());
		
		if(x == 0){
			for (Senha pass : senhas) {
				
				SenhaPK pk = (SenhaPK) pass.getCodigoKEY();	
				
				try {
					/**	--- 1 - TESTA SE A SENHA DIGITADA ESTÁ NO BANCO
						--- 2 - TESTA SE O MAC É NULL OU SE O MAC É COMPATÍVEL COM O DA MÁQUINA */
					if(pk.getCodigo().equals(senha) && (pass.getMac().equals("INATIVO") || pass.getMac().equals(getMacString()))){
						setMacTxt(pass);
						return true;
					}
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Contatos:\n\n(98) 9163-0360\n(98) 8120-0104\n\nescorciomax@gmail.com\n" +
							"walysson21@gmail.com\n ", "Senha Incorreta", JOptionPane.WARNING_MESSAGE);
				}
			}
			JOptionPane.showMessageDialog(null, "Contatos:\n\n(98) 9163-0360\n(98) 8120-0104\n\nescorciomax@gmail.com\n" +
					"walysson21@gmail.com\n ", "Senha Incorreta", JOptionPane.WARNING_MESSAGE);
		}
		return false;
	}
	
	//---METODO QUE VALIDA MAC E SENHA 
	public boolean validar(){
		if(!validarMAC()){
			if(validarSenha()){
				return true;
			}else{
				conexaoBD.closeAllConexao();
				return false;
			}
		}
		return true;
	}	
}