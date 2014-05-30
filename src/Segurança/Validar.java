package Segurança;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

import DAO.JPAUtil;
import DAO.SenhaDAO;

public class Validar extends MAC{

	private JPAUtil conexaoBD = new JPAUtil();
	private SenhaDAO dao = new SenhaDAO(conexaoBD);
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
		
		try{
			macs1 = getMac();
			macs2 = getMacTxt();
		}catch(IOException e){
			e.printStackTrace();
		}
		
		for (String string1 : macs1) {
			for (String string2 : macs2) {
				if(string1.equals(string2))
					return true;
			}
		}
		return false;	
	}
	
	//--- MÉTODO QUE VERIFICA SE A SENHA É COMPATÍVEL
	public boolean validarSenha(){
		
		List<String> senhas = dao.getSenhas();
		
		padrao.add(new JLabel("Senha: "));
		padrao.add(campo);
		String[] options = new String[]{"Autenticar", "Cancelar"};
		
		int x = JOptionPane.showOptionDialog(null, padrao, "Permissão do Fabricante", 
				JOptionPane.NO_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[1]);
		
		String senha = String.valueOf(campo.getPassword());
		
		if(x == 0){
			for (String string : senhas) {
				
				if(string.equals(senha)){
					try {
						setMacTxt();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					//--- EXCLUINDO SENHA USADA
					dao.del(senha);
					return true;
				}
			}
			JOptionPane.showMessageDialog(null, "Contatos:\n\n(98) 9163-0360\n(98) 8120-0104\n\nescorciomax@gmail.com\n" +
					"walysson21@gmail.com\n ", "Senha Incorreta", JOptionPane.WARNING_MESSAGE);
		}
		
		return false;
	}
	
	public boolean validar(){
		if(!validarMAC()){
			if(validarSenha()){
				return true;
			}else{
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		new Validar(Paths.get("C:/SLDA/mac.txt")).validar();
	}
	
}