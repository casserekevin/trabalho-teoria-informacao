package Coders;

import java.util.Scanner;

public class RLE implements Coders{
	
	@Override
	public String encode(Scanner in) {

		StringBuffer bufferAuxiliar = new StringBuffer();
		StringBuffer bufferEncodado = new StringBuffer();

			while (in.hasNextLine()) {
				String line = in.nextLine();
				bufferAuxiliar.append(line + "\n");
				// O \n vai acrescentar um Número extra no final de todo encode!

				// System.out.println(line);

			}

			for (int j = 0; j < bufferAuxiliar.length(); j++) {
				int runLength = 1;
				while (j + 1 < bufferAuxiliar.length() && bufferAuxiliar.charAt(j) == bufferAuxiliar.charAt(j + 1)) {
					runLength++;
					j++;
				}
				bufferEncodado.append(runLength);
				bufferEncodado.append(bufferAuxiliar.charAt(j));
			}
	
		return bufferEncodado.toString();
	}
	
	public String decode(String Fonte) {
		StringBuilder dest = new StringBuilder();
			
			for (int i = 0; i < Fonte.length() -1; i+=1+1 ) {
				char charAt = Fonte.charAt(i+1);
				int cnt = Fonte.charAt(i ) - '0';
				for (int j = 0; j < cnt; j++) {
					dest.append(charAt);
				}

			
			
		}
			return dest.toString();
	}
	
}
