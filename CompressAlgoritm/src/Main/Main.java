package Main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		
//		RLE rle = new RLE();
//		ExecutionManager executionManager = new ExecutionManager(rle, FileOpener.TXT);
//		
//		executionManager.encodar();
		
		FileInputStream file = null;
	    byte a = -1;
	    byte b = -1;
	    byte c = -1;
	    byte d = -1;
	    byte e = -1;
	    byte f = -1;
	    byte g = -1;
	    byte h = -1;
	    byte i = -1;
	    byte j = -1;
	    byte k = -1;
	    byte l = -1;
	    try {
	      file = new FileInputStream("D:\\Users\\Kevin\\Downloads\\cantrbry\\sum");
	      a = (byte) file.read();
	      b = (byte) file.read();
	      c = (byte) file.read();
	      d = (byte) file.read();
	      e = (byte) file.read();
	      f = (byte) file.read();
	      g = (byte) file.read();
	      h = (byte) file.read();
	      i = (byte) file.read();
	      j = (byte) file.read();
	      k = (byte) file.read();
	      l = (byte) file.read();
	      System.out.println(a);
	      System.out.println(b);
	      System.out.println(c);
	      System.out.println(d);
	      System.out.println(e);
	      System.out.println(f);
	      System.out.println(g);
	      System.out.println(h);
	      System.out.println(i);
	      System.out.println(j);
	      System.out.println(k);
	      System.out.println(l);
	      System.out.println((char) a);
	      System.out.println((char) b);
	      System.out.println((char) c);
	      System.out.println((char) d);
	      System.out.println((char) e);
	      System.out.println((char) f);
	      System.out.println((char) g);
	      System.out.println((char) h);
	      System.out.println((char) i);
	      System.out.println((char) j);
	      System.out.println((char) k);
	      System.out.println((char) l);
	    } catch (FileNotFoundException ex) {
	      throw ex;
	    } catch (IOException ioex) {
	      ioex.printStackTrace();
	    } finally {
	      try {
	        if (file != null) {
	          file.close();
	        }
	      } catch (IOException ex) {
	      }
	    }
	}

}
