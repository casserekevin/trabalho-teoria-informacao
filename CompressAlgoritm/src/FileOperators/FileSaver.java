package FileOperators;

import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class FileSaver {

	private JFileChooser fileSaver;
	
	public FileSaver(){
		fileSaver = new JFileChooser();
		fileSaver.setDialogTitle("Saving files...");
		fileSaver.setFileSelectionMode(JFileChooser.FILES_ONLY);
		fileSaver.setCurrentDirectory(new File(System.getProperty("user.home") + System.getProperty("file.separator")+ "Downloads"));
		
		FileNameExtensionFilter filter = new FileNameExtensionFilter(".lzw", "lzw");
		fileSaver.setFileFilter(filter);
	}
	
	public File getSelectedFile(boolean isLzw){
		if(isLzw){
			File file = new File(fileSaver.getSelectedFile().getAbsolutePath()+ ".lzw");
			return file;
		}
		return fileSaver.getSelectedFile();
	}
	
	public int run(){
		return fileSaver.showSaveDialog(null);
	}
}
