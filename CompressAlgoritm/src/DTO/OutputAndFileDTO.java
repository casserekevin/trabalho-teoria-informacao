package DTO;

import java.io.BufferedOutputStream;
import java.io.File;

public class OutputAndFileDTO implements IInputOutputDTO {

	BufferedOutputStream output;
	File file;
	
	public OutputAndFileDTO(BufferedOutputStream output, File file) {
		this.output = output;
		this.file = file;
	}

	@Override
	public BufferedOutputStream getIO() {
		return output;
	}

	@Override
	public File getFile() {
		return file;
	}
	
	
}
