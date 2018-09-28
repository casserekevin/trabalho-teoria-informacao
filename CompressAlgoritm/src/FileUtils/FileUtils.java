package FileUtils;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
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
	public static final int SAVE_TXT = 3;
	
	
	public static IInputOutputDTO ChooseFileToOpen(int tipoArquivo){
		fileOpener = new FileOpener(tipoArquivo);
		
		// Se a tecla apertada for a de Cancelar
		if (fileOpener.run() == JFileChooser.CANCEL_OPTION) {
			return null;		
		}
		
		return getIOAndFile(OPEN);
	}
	
	public static IInputOutputDTO ChooseFileToSave(int tipoSave){
		fileSaver = new FileSaver();
		
		// Se a tecla apertada for a de Cancelar
		if (fileSaver.run() == JFileChooser.CANCEL_OPTION) {
			return null;		
		}
		
		if(tipoSave == SAVE_TXT){
			return getIOAndFile(SAVE_TXT);			
		}
		
		return getIOAndFile(SAVE_PADRAO);
	}
	
	@SuppressWarnings("unused")
	public static StringBuffer read(IInputOutputDTO inputAndFile){
		BufferedInputStream input = (BufferedInputStream)inputAndFile.getIO();
		File file = inputAndFile.getFile();
		
		//Criação buffer
		long tamanhoBuffer;
		if(file.length() % 4 != 0){
			tamanhoBuffer = (file.length() / 4) + 1;
		}
		else{
			tamanhoBuffer = file.length() / 4;
		}
		byte[] buffer = new byte[(int) tamanhoBuffer];
		
		//Leitura dos dados
		StringBuffer dadosLidos = new StringBuffer();
		try {
			int read = 0;
			while ((read = input.read(buffer)) != -1) {
				String bytesReaded = new String(buffer);
				dadosLidos.append(bytesReaded);
			}
			input.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//retorno dados lidos
		return dadosLidos;
	}
	
	public static void write(IInputOutputDTO outputAndFile, String content){
		FileWriter fileWriter = (FileWriter) outputAndFile.getIO();
		try {
			fileWriter.write(content);
			fileWriter.flush();
			fileWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	private static IInputOutputDTO getIOAndFile(int acao){
		
		if(acao == FileUtils.OPEN){
			try {
				BufferedInputStream in = new BufferedInputStream(new FileInputStream(fileOpener.getSelectedFile()));
				File file = fileOpener.getSelectedFile();
				return new InputAndFileDTO(in, file);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		}
		else if(acao == FileUtils.SAVE_PADRAO){
			try {
				File file = fileSaver.getSelectedFile(false);
				FileWriter out = new FileWriter(file);
				return new OutputAndFileDTO(out, file);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		else if(acao == FileUtils.SAVE_TXT){
			try {
				File file = fileSaver.getSelectedFile(true);
				FileWriter out = new FileWriter(file);
				return new OutputAndFileDTO(out, file);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		
		return null;
	}
	
}
