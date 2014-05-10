package ComponentGroupPlus;

import java.text.ParseException;

import javax.swing.JFormattedTextField;
import javax.swing.text.MaskFormatter;

public class MaskFormatterGroup {
	
	protected MaskFormatter data;
	protected MaskFormatter tel;
	protected MaskFormatter cpf;
	protected MaskFormatter ano;
	
	public MaskFormatter getMascaraCPF(){
		try {
			cpf = new MaskFormatter("###.###.###-##");
			cpf.setPlaceholderCharacter('_');
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return cpf;
	}
	
	public MaskFormatter getMascaraData(){
		try {
			data = new MaskFormatter(" ##/##/####");
			data.setPlaceholderCharacter('_');
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return data;
	}
	
	public MaskFormatter getMascaraTelefone(){
		try {
			tel = new MaskFormatter("(##) ####-####");
			tel.setPlaceholderCharacter('_');
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return tel;
	}
	
	public MaskFormatter getMascaraAno(){
		try {
			ano = new MaskFormatter("####");
			ano.setPlaceholderCharacter('_');
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return ano;
	}
	
	public String verificarMascara(JFormattedTextField campo){              
        if(campo.getText().contains("_")){
                return "";
        }else{
                return campo.getText();
        }
}
	
}
