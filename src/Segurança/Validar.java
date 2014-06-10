package Segurança;

import java.io.IOException;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
	List<Senha> macsBD = dao.getSenhas();
	
	public Validar(Path url) {
		super(url);
		// TODO Auto-generated constructor stub
	}
	
	//--- MÉTODO QUE VERIFICA SE PELO MENOS UM MAC DA MÁQUINA É COMPATÍVEL COM O DO TXT
	public boolean validarMAC(){
		
		ArrayList<String> macs1 = new ArrayList<>();
		ArrayList<String> macs2 = new ArrayList<>();
		
		String mac = null;
		boolean boo = true;
		
		try {
			macs1 = getMac();
			macs2 = getMacTxt();
			mac = macsBD.get(0).getMac();
		} catch(IOException e){
			e.printStackTrace();
		}
		
		
		if(mac != null && mac.length() >= 20) {
			String[] str = mac.split(mac.substring(17, 18));
			for (String string2 : macs1) {
				if(str[0].equals(string2)){
					boo = false;
					System.out.println(boo);
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
	
	private boolean dateToday() {

		Date date = new Date();
		SimpleDateFormat dateToday = new SimpleDateFormat("dd/MM/yyyy");
		String strDateToday = dateToday.format(date);
		
		Boolean boo = false;
		Boolean ano = false;
		Boolean dia = false;
		Boolean mes = false;
		
		String[] data= String.valueOf(strDateToday).split("/");
		String [] dataBD = macsBD.get(0).getData().split("/");
 		
		System.out.println(Integer.parseInt(data[2]));
		// verifica ano, se for menor verificar o mes, se for menor verificar o dia.
			if(Integer.parseInt(data[2]) <= Integer.parseInt(dataBD[2])) {
				ano = true;
			} 

			if(Integer.parseInt(data[1]) <= Integer.parseInt(dataBD[1])) {
				mes = true;
			}
			
			if(Integer.parseInt(data[0]) <= Integer.parseInt(dataBD[0])) {
				dia = true;
			}
			
			if(ano) {
				if(mes) {
					if(dia) {
						return true;
					}	
				}
			}

		System.out.println(strDateToday);
		return boo;
	}
	
	//---METODO QUE VALIDA MAC E SENHA 
	public boolean validar(){
		if(dateToday()) {
			if(!validarMAC()){
				if(validarSenha()){
					return true;
				}else{
					conexaoBD.closeAllConexao();
					return false;
				}
			}
		} else {
			JOptionPane.showMessageDialog(null, "A chave de acesso expirou.", "Acesso Negado", JOptionPane.WARNING_MESSAGE);
			conexaoBD.closeAllConexao();
			return false;
		}
		
		return true;
	}	
}