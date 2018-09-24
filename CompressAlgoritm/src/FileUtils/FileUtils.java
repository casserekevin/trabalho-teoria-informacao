package FileUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JFileChooser;

import FileOperators.FileOpener;
import FileOperators.FileSaver;

public class FileUtils {
	
	private static FileOpener fileOpener;
	
	public static void salveFile(String content){
		FileSaver fileSaver = new FileSaver();
		if(fileSaver.run() == JFileChooser.APPROVE_OPTION){
			File file = fileSaver.getSelectedFile();
			try {
				FileWriter fileWriter = new FileWriter(file.getPath());
				fileWriter.write(content);
				fileWriter.flush();
				fileWriter.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static Scanner SearchFile(int tipoArquivo){
		fileOpener = new FileOpener(tipoArquivo);
		
		// Se a tecla apertada for a de Cancelar
		if (fileOpener.run() == JFileChooser.CANCEL_OPTION) {
			return null;
			
		}
		
		return getScanner();
	}
	
	private static Scanner getScanner(){
		Scanner scan = null;
		try {
			scan = new Scanner(fileOpener.getSelectedFile());
		} 
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return scan;
	}
	
}
