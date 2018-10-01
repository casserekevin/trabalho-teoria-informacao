package Manager;

import Coders.ICoders;
import DTO.IInputOutputDTO;
import FileOperators.FileOpener;
import FileUtils.FileUtils;
import Screens.ProcessorScreen;

public class ExecutionManager {
	
	private ICoders coder;

	public ExecutionManager(ICoders coder){
		this.coder = coder;
	}
	
	public void encodar(){
		
		IInputOutputDTO inputAndFile = FileUtils.ChooseFileToOpen(FileOpener.PADRAO );
		if(inputAndFile == null){
			System.out.println("Input não encontrado");
		}
		else{
			//tela de processamento
			ProcessorScreen loading = new ProcessorScreen();
			loading.setVisible(true);
			
			byte[] dadosLidos = FileUtils.read(inputAndFile);
			// Aki vai o código do Algorítmo de Compressao;
			byte[] encodado = coder.encode(dadosLidos);
			
			loading.dispose();
			
			IInputOutputDTO outputAndFile = FileUtils.ChooseFileToSave(FileUtils.SAVE_LZW);
			if(outputAndFile == null){
				System.out.println("Output não encontrado");
			}
			else{
				FileUtils.write(outputAndFile, encodado);
			}	
			
		}
	}
	
	public void decodar(){
		
		IInputOutputDTO inputAndFile = FileUtils.ChooseFileToOpen(FileOpener.LZW);
		if(inputAndFile == null){
			System.out.println("Input não encontrado");
		}
		else{
			ProcessorScreen loading = new ProcessorScreen();
			loading.setVisible(true);
			
			byte[] dadosLidos = FileUtils.read(inputAndFile);
			// Aki vai o código do Algorítmo de Decompressao;
			byte[] decodado = coder.decode(dadosLidos);
			
			loading.dispose();
			
			IInputOutputDTO outputAndFile = FileUtils.ChooseFileToSave(FileUtils.SAVE_PADRAO);
			if(outputAndFile == null){
				System.out.println("Output não encontrado");
			}
			else{
				FileUtils.write(outputAndFile, decodado);
			}
		}
	}
}
