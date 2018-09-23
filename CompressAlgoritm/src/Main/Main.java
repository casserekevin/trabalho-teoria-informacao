package Main;

import Coders.RLE;
import Manager.ExecutionManager;

public class Main {

	public static void main(String[] args) {
		
		final int TXT = 1;
		@SuppressWarnings("unused")
		final int TXT_E_EXE = 2;
		
		RLE rle = new RLE();
		ExecutionManager executionManager = new ExecutionManager(rle, TXT);
		
		executionManager.encodar();
	}

}
