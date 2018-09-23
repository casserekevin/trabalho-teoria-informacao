package FileOperators;

import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class FileOpener {
	
	public static final int TXT = 1;
	public static final int TXT_E_EXE = 2;
	
	private JFileChooser fileOpener;
	
	public FileOpener(int tipoArquivo){
		
		fileOpener = new JFileChooser();
		fileOpener.setDialogTitle("Searching files...");
		fileOpener.setFileSelectionMode(JFileChooser.FILES_ONLY);
		fileOpener.setCurrentDirectory(new File(System.getProperty("user.home") + System.getProperty("file.separator")+ "Downloads"));
		
		FileNameExtensionFilter filter = null;
		if(tipoArquivo == TXT){
			filter = new FileNameExtensionFilter(".txt", "txt");		
		}
		else if(tipoArquivo == TXT_E_EXE){
			filter = new FileNameExtensionFilter(".txt e .exe", "txt", "exe");
		}
		fileOpener.setFileFilter(filter);
		
	}
	
	public File getSelectedFile(){
		return fileOpener.getSelectedFile();
	}
	
	public int run(){
		return fileOpener.showOpenDialog(null);
	}

}
