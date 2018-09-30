package Coders;

import java.io.*;
import java.util.*;

public class LzwComp {
	  // define a hashmap e outras variaveis que ser�o utilizadas pelo programa
    public HashMap<String, Integer> dictionary = new HashMap<>();
    public int dictSize = 256;
    public String str = "";
    public byte inputByte;
    public byte[] buffer = new byte[3];
    public boolean onleft = true;

    /**
     * recebe  o nome de um arquivo que n�o esta encodado e vai encodar ele.
     * coloca um .lzw no final do nome do arquivo
     *
     * @param uncompressed -Nome do arquivo uncompr sendo comprimido
     * @throws java.io.IOException -falha input/output
     */
    public void compress(String uncompressed) throws IOException {
        // Dictionary size limit, builds dictionary
        for (int i = 0; i < 256; i++) {
            dictionary.put(Character.toString((char) i), i);
        }

        //L� o impute uncompr e escreve na compr 
        RandomAccessFile read = new RandomAccessFile(uncompressed, "r");
        RandomAccessFile out = new RandomAccessFile(uncompressed.concat(
                ".lzw"), "rw");

        try {
            // l�  o primeiro caractere do imput em uma String
            inputByte = read.readByte();
            int i = new Byte(inputByte).intValue();
            if (i < 0) {
                i += 256;
            }
            char ch = (char) i;
            str = "" + ch;

            // L� caractere por caractere
            while (true) {
                inputByte = read.readByte();
                i = new Byte(inputByte).intValue();

                if (i < 0) {
                    i += 256;
                }
                System.out.print(i + ", ");
                ch = (char) i;

                //Se 	str + ch est]ao no dicion�rio
                // Set str to str + ch
                if (dictionary.containsKey(str + ch)) {
                    str = str + ch;
                } else {
                    String s12 = to12bit(dictionary.get(str));

                    // Coloca os 12 bit sem um array e ent�o esceve iusto no arquivo output
                    
                    if (onleft) {
                        buffer[0] = (byte) Integer.parseInt(
                                s12.substring(0, 8), 2);
                        buffer[1] = (byte) Integer.parseInt(
                                s12.substring(8, 12) + "0000", 2);
                    } else {
                        buffer[1] += (byte) Integer.parseInt(
                                s12.substring(0, 4), 2);
                        buffer[2] = (byte) Integer.parseInt(
                                s12.substring(4, 12), 2);
                        for (int b = 0; b < buffer.length; b++) {
                            out.writeByte(buffer[b]);
                            buffer[b] = 0;
                        }
                    }
                    onleft = !onleft;

                    // adiciona str + ch ao dicion�rio
                    if (dictSize < 4096) {
                        dictionary.put(str + ch, dictSize++);
                    }

                    // Set str to ch
                    str = "" + ch;
                }
            }
            
        } catch (IOException e) {
            String str12bit = to12bit(dictionary.get(str));
            if (onleft) {
                buffer[0] = (byte) Integer.parseInt(str12bit.substring(0, 8), 2);
                buffer[1] = (byte) Integer.parseInt(str12bit.substring(8, 12)
                        + "0000", 2);
                out.writeByte(buffer[0]);
                out.writeByte(buffer[1]);
            } else {
                buffer[1] += (byte) Integer.parseInt(str12bit.substring(0, 4), 2);
                buffer[2] = (byte) Integer.parseInt(str12bit.substring(4, 12), 2);

                for (int b = 0; b < buffer.length; b++) {
                    out.writeByte(buffer[b]);
                    buffer[b] = 0;
                }
            }
            read.close();
            out.close();
        }
    }

    /**
     * Converte 8 bits para 12 bits
     *
     * @param i - Integer value
     * @return - String value of integer in 12 bit
     */
    public String to12bit(int i) {
        String str = Integer.toBinaryString(i);
        while (str.length() < 12) {
            str = "0" + str;
        }
        return str;
    }

    /**
     * depois de criar o obj lzw, procura por um imput do us�rio por um arquivo para comprimir, e
     * printa o conte�do do arquivo sendo comprimido junt com valroes integer dos
     *caracteres sendo compressed, via retornar o nome do arquivo com .lzw no final
     *
     * @param args - The command line arguments
     * @throws java.io.IOException - File input/output failure
     */
    public static void main(String[] args) throws IOException {
        try {
            LzwComp lzw = new LzwComp();

            Scanner input = new Scanner(System.in);

            System.out.println("Coloque o nome do (input.txt) arquivo.");

            String str = input.nextLine();

            File file = new File(str);

            Scanner fileScanner = new Scanner(file);

            String line = "";

            while (fileScanner.hasNext()) {
                line = fileScanner.nextLine();
                System.out.println("Comprimindo o conte�do do arquivo: \n"
                        + line);
            }
            lzw.compress(str);
            System.out.println("\nA compress�o foi um sucesso!");
            System.out.println("Seu novo arquivo se chama: " + str.concat(".lzw"));
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo n�o encontrado!");
        }
    }
}