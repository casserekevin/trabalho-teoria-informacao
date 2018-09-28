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

	@Override
	public String decode(StringBuffer fonte) {

		int count = 0;
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < fonte.length(); i++) {
			char c = fonte.charAt(i);
			if (Character.isDigit(c)) {
				count = count * 10 + c - '0';
			} else {
				if (count == 0) {

					count = 1;
				}
				while (count > 0) {
					result.append(c);
					count--;
				}
			}

		}
		return result.toString();
	}
}
