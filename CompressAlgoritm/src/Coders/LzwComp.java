package Coders;

import java.io.*;
import java.util.*;

public class LzwComp {
//----------------------------------------------------------------------------------------------------//
//--------------------------------------VARI�VEIS-----------------------------------------------------//
//----------------------------------------------------------------------------------------------------//
// define a hashmap e outras variaveis que ser�o utilizadas pelo programa
    public HashMap<String, Integer> dictionary = new HashMap<>();
    public int dictSize = 256;
    public String str = "";
    public byte inputByte;
    public byte[] buffer = new byte[3];
    public boolean onleft = true;
//----------------------------------------------------------------------------------------------------//
//----------------------------------M�TODOS DE COMPRESS�O---------------------------------------------//
//----------------------------------------------------------------------------------------------------//
//Recebe um arquivo para comprimir. Ao final adiciona .lzw como extens�o
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
      public String to12bit(int i) {
          String str = Integer.toBinaryString(i);
          while (str.length() < 12) {
              str = "0" + str;
          }
          return str;
      }
  }