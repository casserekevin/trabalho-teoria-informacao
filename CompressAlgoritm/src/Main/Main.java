package Main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

//import Coders.RLE;
import Coders.LzwComp;
//import Coders.LzwDec;

//import FileOperators.FileOpener;
//import Manager.ExecutionManager;



public class Main {

	public static void main(String[] args) throws IOException {
//-------------------------------------------------------------------------------------------------------//
//-------------------------------------RLE COMPACTADOR---------------------------------------------------//
//-------------------------------------------------------------------------------------------------------//
		/*
		RLE rle = new RLE();
		ExecutionManager executionManager = new ExecutionManager(rle);

		executionManager.encodar(FileOpener.TXT_E_EXE);
//		executionManager.decodar();
		 */
//-------------------------------------------------------------------------------------------------------//
//-------------------------------------LZW COMPACTADOR---------------------------------------------------//
//-------------------------------------------------------------------------------------------------------//
		try {
			LzwComp lzw = new LzwComp();

			Scanner input = new Scanner(System.in);

			System.out.println("Adicione a localização e o nome do arquivo.");

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
//------------------------------------------------------------------------------------------------------//		
//-------------------------------------------LZW DESCOMPACTADOR-----------------------------------------//
//------------------------------------------------------------------------------------------------------//
/*
		try {
			LzwDec lzw = new LzwDec();

			Scanner input = new Scanner(System.in);

			System.out.println("Enter the name of your (input.txt.lzw) file.");

			String str = input.nextLine();

			File file = new File(str);

			Scanner fileScanner = new Scanner(file);

			String line = "";

			while (fileScanner.hasNext()) {
				line = fileScanner.nextLine();
				System.out.println("Contents of your file being decompressed:\n"
						+ line);
			}
			lzw.LZW_Decompress(str);
			System.out.println("Decompression of your file is complete!");
			System.out.println("Your new file is named: "
					+ str.replace(".lzw", ""));
		} catch (FileNotFoundException e) {
			System.out.println("File was not found!");
		}
*/
	}
}
