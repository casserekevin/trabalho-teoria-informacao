package Main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import Coders.LzwComp;
//import Coders.RLE;
//import FileOperators.FileOpener;
//import Manager.ExecutionManager;

public class Main {

	public static void main(String[] args) throws IOException {

		/*
		RLE rle = new RLE();
		ExecutionManager executionManager = new ExecutionManager(rle);

		executionManager.encodar(FileOpener.TXT_E_EXE);
//		executionManager.decodar();
		 */
//-------------------------------------LZW COMPACTADOR---------------------------------------------------//
		try {
			LzwComp lzw = new LzwComp();

			Scanner input = new Scanner(System.in);

			System.out.println("Coloque o nome do (input.txt) arquivo.");

			String str = input.nextLine();

			File file = new File(str);

			Scanner fileScanner = new Scanner(file);

			String line = "";

			while (fileScanner.hasNext()) {
				line = fileScanner.nextLine();
				System.out.println("Comprimindo o conteúdo do arquivo: \n"
						+ line);
			}
			lzw.compress(str);
			System.out.println("\nA compressão foi um sucesso!");
			System.out.println("Seu novo arquivo se chama: " + str.concat(".lzw"));
			input.close();
			fileScanner.close();
		} catch (FileNotFoundException e) {
			System.out.println("Arquivo não encontrado!");
		}

		//-------------------------------------LZW DESCOMPACTADOR-----------------------------------------//

		
	}

}
