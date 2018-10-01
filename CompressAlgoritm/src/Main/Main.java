package Main;

import Coders.LZW;
import Manager.ExecutionManager;



public class Main {

	public static void main(String[] args) {
		
		LZW lzw = new LZW();
		ExecutionManager executionManager = new ExecutionManager(lzw);

//		executionManager.encodar();
		executionManager.decodar();
		 


	}
}
