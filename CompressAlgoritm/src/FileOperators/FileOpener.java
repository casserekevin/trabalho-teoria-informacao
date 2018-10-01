package FileOperators;

import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class FileOpener {
	
	public static final int PADRAO = 1;
	public static final int LZW = 2;
	
	private JFileChooser fileOpener;
	
	public FileOpener(int tipoArquivo){
		
		fileOpener = new JFileChooser();
		fileOpener.setDialogTitle("Searching files...");
		fileOpener.setFileSelectionMode(JFileChooser.FILES_ONLY);
		fileOpener.setCurrentDirectory(new File(System.getProperty("user.home") + System.getProperty("file.separator")+ "Downloads"));
		
		FileNameExtensionFilter filter = null;
		if(tipoArquivo == LZW){
			filter = new FileNameExtensionFilter(".lzw", "lzw");	
			fileOpener.setFileFilter(filter);
		}
	}
	
	public File getSelectedFile(){
		return fileOpener.getSelectedFile();
	}
	
	public int run(){
		return fileOpener.showOpenDialog(null);
	}

}
