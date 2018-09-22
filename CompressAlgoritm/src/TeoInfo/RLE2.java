package TeoInfo;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class RLE2 {

	public static String encode() throws IOException {
		//String p = "io";
		
		StringBuffer bufferAuxiliar = new StringBuffer();
		StringBuffer bufferEncodado = new StringBuffer();
		
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setDialogTitle("Procurar Arquivos");
		fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		fileChooser.setCurrentDirectory(new File(System.getProperty("user.home") + System.getProperty("file.separator")+ "Downloads"));
		
		FileNameExtensionFilter filter = new FileNameExtensionFilter(".txt e .exe", "txt", "exe");
		fileChooser.setFileFilter(filter);
		
		int resposta = fileChooser.showOpenDialog(null);
		
		if(resposta == JFileChooser.CANCEL_OPTION){
			System.out.println("Arquivo n�o selecionado");
		}
		else{
			Scanner in = new Scanner(fileChooser.getSelectedFile());
			
			while (in.hasNextLine()) {
			    String line = in.nextLine();
			    bufferAuxiliar.append(line+"\n");
			    //O \n vai acrescentar  um N�mero extra no final de todo encode!
			    
			    //System.out.println(line);
			    
			    }
			 
		        for (int j = 0; j < bufferAuxiliar.length(); j++) {
		            int runLength = 1;
		            while (j+1 < bufferAuxiliar.length() && bufferAuxiliar.charAt(j) == bufferAuxiliar.charAt(j+1)) {
		                runLength++;
		                j++;
		            }
		            bufferEncodado.append(runLength);
		            bufferEncodado.append(bufferAuxiliar.charAt(j));
		        }
		        
		    in.close();    
		}
		
		return bufferEncodado.toString();
	}
	
	
	public static String decode(String Fonte) {
		  int count = 0;
		    StringBuilder result = new StringBuilder () ;
		    for (int i = 0; i < Fonte.length(); i++) {
		        char c = Fonte.charAt(i);
		        if (Character.isDigit(c)) {
		            count = count * 10 + c - '0';
		        } else {  if (count == 0) {
		       
		            count = 1;
		        }
		            while (count >0){ 
		                result.append(c);
		                count--;
		            }
		        }

		    }
		    return result.toString();
		}
	

	public static void main (String[] args) throws IOException {
		System.out.println(encode());
		//System.out.println(decode(encode()));
		
	}
		}


