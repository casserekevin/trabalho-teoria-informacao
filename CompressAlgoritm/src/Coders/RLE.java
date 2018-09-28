package Coders;

public class RLE implements ICoders {

	@Override
	public String encode(StringBuffer content) {

		StringBuffer bufferEncodado = new StringBuffer();
		for (int j = 0; j < content.length(); j++) {
			int runLength = 1;
			while (j + 1 < content.length() && content.charAt(j) == content.charAt(j + 1)) {
				runLength++;
				j++;
			}
			bufferEncodado.append(runLength);
			bufferEncodado.append(content.charAt(j));
		}

		return bufferEncodado.toString();
	}

	
	public String decode(StringBuffer Fonte) {
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
