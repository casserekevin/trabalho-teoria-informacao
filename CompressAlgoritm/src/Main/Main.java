package Main;

import Coders.RLE;
import FileOperators.FileOpener;
import Manager.ExecutionManager;

public class Main {

	public static void main(String[] args) {
		
		RLE rle = new RLE();
		ExecutionManager executionManager = new ExecutionManager(rle);
		
		executionManager.encodar(FileOpener.TXT_E_EXE);
//		executionManager.decodar();
	}

}
