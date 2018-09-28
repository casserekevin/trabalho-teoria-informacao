package DTO;

import java.io.BufferedInputStream;
import java.io.File;

public class InputAndFileDTO implements IInputOutputDTO {

	BufferedInputStream input;
	File file;
	
	public InputAndFileDTO(BufferedInputStream input, File file) {
		this.input = input;
		this.file = file;
	}

	@Override
	public BufferedInputStream getIO() {
		return input;
	}

	@Override
	public File getFile() {
		return file;
	}
	
	
}
