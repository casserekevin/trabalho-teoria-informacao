package FileUtils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFileChooser;

import FileOperators.FileSaver;

public class FileUtils {
	
	public static void salvar(String content){
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

}
