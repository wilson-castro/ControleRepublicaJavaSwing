
package src.utils;

public abstract class FileManager {
   public static String toFileLine(String[] atributos) {
       String line = "";
       
       for(int i = 0; i < atributos.length; i++){
           line += atributos[i].replaceAll(",", Constantes.STRING_VIRGULA_NO_ARQUIVO);
           if((i+1) != atributos.length) line += ",";
       }
       
       return line;
   }
   
}
