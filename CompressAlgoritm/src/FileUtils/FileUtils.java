package FileUtils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JFileChooser;

import DTO.IInputOutputDTO;
import DTO.InputAndFileDTO;
import DTO.OutputAndFileDTO;
import FileOperators.FileOpener;
import FileOperators.FileSaver;

public class FileUtils {

	private static FileOpener fileOpener;
	private static FileSaver fileSaver;

	public static final int OPEN = 1;
	public static final int SAVE_PADRAO = 2;
	public static final int SAVE_LZW = 3;

	public static IInputOutputDTO ChooseFileToOpen(int tipoArquivo) {
		fileOpener = new FileOpener(tipoArquivo);

		// Se a tecla apertada for a de Cancelar
		if (fileOpener.run() == JFileChooser.CANCEL_OPTION) {
			return null;
		}

		return getIOAndFile(OPEN);
	}

	public static IInputOutputDTO ChooseFileToSave(int tipoSave) {
		fileSaver = new FileSaver();

		// Se a tecla apertada for a de Cancelar
		if (fileSaver.run() == JFileChooser.CANCEL_OPTION) {
			return null;
		}

		if (tipoSave == SAVE_LZW) {
			return getIOAndFile(SAVE_LZW);
		}

		return getIOAndFile(SAVE_PADRAO);
	}

	public static byte[] read(IInputOutputDTO inputAndFile) {
		BufferedInputStream input = (BufferedInputStream) inputAndFile.getIO();
		File file = inputAndFile.getFile();

		// Criação buffer
		long tamanhoBuffer = file.length();
		byte[] buffer = new byte[(int) tamanhoBuffer];

		// Leitura dos dados
		try {
			input.read(buffer);
			input.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// retorno dados lidos
		return buffer;
	}

	public static void write(IInputOutputDTO outputAndFile, byte[] content) {
		BufferedOutputStream output = (BufferedOutputStream) outputAndFile.getIO();
		try {
			output.write(content);
			output.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static IInputOutputDTO getIOAndFile(int acao) {

		if (acao == FileUtils.OPEN) {
			try {
				File file = fileOpener.getSelectedFile();
				BufferedInputStream in = new BufferedInputStream(new FileInputStream(file));
				return new InputAndFileDTO(in, file);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (acao == FileUtils.SAVE_PADRAO) {
			try {
				File file = fileSaver.getSelectedFile(false);
				BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(file));
				return new OutputAndFileDTO(out, file);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (acao == FileUtils.SAVE_LZW) {
			try {
				File file = fileSaver.getSelectedFile(true);
				BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(file));
				return new OutputAndFileDTO(out, file);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return null;
	}

}
