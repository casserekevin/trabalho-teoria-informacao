package Manager;

import java.util.Scanner;

import Coders.Coders;
import FileUtils.FileUtils;
import Screens.ProcessorScreen;

public class ExecutionManager {
	
	private Coders coder;
	private int tipoArquivo;

	public ExecutionManager(Coders coder, int tipoArquivo){
		this.coder = coder;
		this.tipoArquivo = tipoArquivo;
	}
	
	public void encodar(){
		
		Scanner in = FileUtils.SearchFile(tipoArquivo);
		if(in == null){
			System.out.println("Arquivo não encontrado");
		}
		else{
			ProcessorScreen loading = new ProcessorScreen();
			loading.setVisible(true);
			
			// Aki vai o código do Algorítmo de Compressao;
			String encodado = coder.encode(in);
			
			in.close();
			loading.dispose();
			
			FileUtils.salveFile(encodado);			
		}
	}
	
	public void decodar(){
		
	}
}
