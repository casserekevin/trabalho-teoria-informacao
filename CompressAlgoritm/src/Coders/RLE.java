package Coders;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JFileChooser;

import FileChooser.FileChooser;

public class RLE {

	public String encode() {

		StringBuffer bufferAuxiliar = new StringBuffer();
		StringBuffer bufferEncodado = new StringBuffer();

		FileChooser fileChooser = new FileChooser(FileChooser.TXT_E_EXE);

		// Se a tecla apertada for a de Cancelar
		if (fileChooser.open() == JFileChooser.CANCEL_OPTION) {
			System.out.println("Arquivo não selecionado");
		} else {
			Scanner in = null;
			try {
				in = new Scanner(fileChooser.getSelectedFile());
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

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

			in.close();
		}

		return bufferEncodado.toString();
	}

	public String decode(String Fonte) {
		int count = 0;
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < Fonte.length(); i++) {
			char c = Fonte.charAt(i);
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
