package Seguran�a;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.util.ArrayList;

import DAO.JPAUtil;
import DAO.SenhaDAO;
import Model.Senha;

public class MAC {

	private Path url;
	private Charset utf8 = StandardCharsets.UTF_8;
	private JPAUtil conexaoBD = new JPAUtil();
	protected SenhaDAO dao = new SenhaDAO(conexaoBD);
	
	public MAC(Path url) {
		this.url = url;
	}
	
	public Path getUrl(){
		return this.url;
	}
	
	public void setUrl(Path url){
		this.url = url;
	}
	
	//--- M�TODO QUE PEGA O(S) ENDERE�O(S) MAC DIRETAMENTE DO PROMPT (ARRAYLIST)
	public ArrayList<String> getMac() throws IOException{
		
		ArrayList<String> mac = new ArrayList<>();
		Process p = Runtime.getRuntime().exec("getmac");
		
		try(BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()))){
			
			String linha = null;
			int i = 0;
			while((linha = input.readLine()) != null ){
				if(i > 2)
					mac.add(linha.substring(0, 17));  
				i++;
			}
		}
 
		return mac;
	}
	
	//--- M�TODO QUE PEGA O(S) ENDERE�O(S) MAC DIRETAMENTE DO PROMPT (STRING)
	public String getMacString() throws IOException{
		ArrayList<String> macs = getMac();
		String mac = "";
		
		for (String string : macs) {
			mac += string + "\n";
		}
		
		return mac;
	}

	//--- M�TODO QUE PEGA O(S) ENDERE�O(S) MAC DO ARQUIVO TXT
	public ArrayList<String> getMacTxt() throws IOException{
		ArrayList<String> mac = new ArrayList<>();

		try(BufferedReader input = Files.newBufferedReader(url, utf8)){
			String linha = null;
			
			while((linha = input.readLine()) != null ){
					mac.add(linha);  
			}
		}catch(NoSuchFileException e){
			System.out.println("MAC_ERRO01 - Arquivo Inexistente!");
		}
		
		return mac;
	}
	
	//--- M�TODO QUE CRIA UM ARQUIVO TXT E O PREENCHE COM O(S) ENDERE�O(S) MAC COLETADO DO PROMPT
	public void setMacTxt(Senha senha) throws IOException{
		
		//--- CRIA UM DIRET�RIO
		Files.createDirectories(url.getParent());	
		//--- OCULTA O DIRET�RIO
		Runtime.getRuntime().exec("attrib +h /s /d " + url.getParent());
	
		try(BufferedWriter writer = Files.newBufferedWriter(url, utf8)){
			
			ArrayList<String> mac = getMac();
			
			dao.setMacSenhas(senha, getMacString());
		
			for (String string : mac) {
				writer.write(string + "\n");
			}	
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
}