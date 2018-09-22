package TeoInfo;

import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RLE2 {

	public static String encode() {
//String p = "io";
StringBuffer destino = new StringBuffer();
StringBuffer dest = new StringBuffer();
		Scanner in;
		try {
			in = new Scanner(new FileReader("C:/alice29.txt"));
			while (in.hasNextLine()) {
			    String line = in.nextLine();
			    destino.append(line+"\n");
			    //O \n vai acrescentar  um Número extra no final de todo encode!
			    
			    //System.out.println(line);
			    
			    }
			 
		        for (int j = 0; j < destino.length(); j++) {
		            int runLength = 1;
		            while (j+1 < destino.length() && destino.charAt(j) == destino.charAt(j+1)) {
		                runLength++;
		                j++;
		            }
		            dest.append(runLength);
		            dest.append(destino.charAt(j));
		        }
		       
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		 return dest.toString();
		}
	public static String decode(String Fonte) {
		  int count = 0;
		    StringBuilder result = new StringBuilder () ;
		    for (int i = 0; i < Fonte.length(); i++) {
		        char c = Fonte.charAt(i);
		        if (Character.isDigit(c)) {
		            count = count * 10 + c - '0';
		        } else {  if (count == 0) {
		       
		            count = 1;
		        }
		            while (count >0){ 
		                result.append(c);
		                count--;
		            }
		        }

		    }
		    return result.toString();
		}
	

	public static void main (String[] args) {
		System.out.println(encode());
		//System.out.println(decode(encode()));
		
	}
		}


