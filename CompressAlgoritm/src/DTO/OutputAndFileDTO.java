package DTO;

import java.io.File;
import java.io.FileWriter;

public class OutputAndFileDTO implements IInputOutputDTO {

	FileWriter output;
	File file;
	
	public OutputAndFileDTO(FileWriter output, File file) {
		this.output = output;
		this.file = file;
	}

	@Override
	public FileWriter getIO() {
		return output;
	}

	@Override
	public File getFile() {
		return file;
	}
	
	
}
