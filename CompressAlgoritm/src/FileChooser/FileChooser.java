package FileChooser;

import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class FileChooser {
	
	public static final int TXT = 1;
	public static final int TXT_E_EXE = 2;
	
	private JFileChooser fileChooser;
	
	public FileChooser(int tipoArquivo){
		
		fileChooser = new JFileChooser();
		fileChooser.setDialogTitle("Procurar Arquivos");
		fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		fileChooser.setCurrentDirectory(new File(System.getProperty("user.home") + System.getProperty("file.separator")+ "Downloads"));
		
		FileNameExtensionFilter filter = null;
		if(tipoArquivo == TXT){
			filter = new FileNameExtensionFilter(".txt", "txt");		
		}
		else if(tipoArquivo == TXT_E_EXE){
			filter = new FileNameExtensionFilter(".txt e .exe", "txt", "exe");
		}
		fileChooser.setFileFilter(filter);
		
	}
	
	public File getSelectedFile(){
		return fileChooser.getSelectedFile();
	}
	
	public int open(){
		return fileChooser.showOpenDialog(null);
	}

}
