package ComponentGroupPlus;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.InputStreamReader;

public class IDHD {
	
	    public String getHDSerial(String drive) {  
	        String result = "";  
	        try {  
	            //File file = File.createTempFile("tmp",".vbs");  
	            File file = File.createTempFile("tmp", ".vbs");  
	            file.deleteOnExit();  
	            FileWriter fw = new java.io.FileWriter(file);  
	  
	            String vbs = "Set objFSO = CreateObject(\"Scripting.FileSystemObject\")\n" + "Set colDrives = objFSO.Drives\n"   
	                            + "Set objDrive = colDrives.item(\"" + drive + "\")\n" + "Wscript.Echo objDrive.SerialNumber";    
	            fw.write(vbs);  
	            fw.close();  
	            Process p = Runtime.getRuntime().exec("cscript //NoLogo " + file.getPath());  
	            BufferedReader input =  
	                new BufferedReader(new InputStreamReader(p.getInputStream()));  
	            String line;  
	            while ((line = input.readLine()) != null) {  
	                result += line;  
	            }  
	            input.close();  
	        } catch (Exception e) {  
	  
	        }  
	        if (result.trim().length() < 1  || result == null) {  
	            result = "NO_DISK_ID";  
	        }  
	  
	        return result.trim();  
	    }  
	    
}
