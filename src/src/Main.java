
package src;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;
import src.models.Pessoa;
import src.utils.Constantes;
import src.utils.FileManager;
import src.utils.RandomString;

public class Main {
    public static void main(String[] args) {
        float totalRendimetnos = 22.00f;
        Pessoa pessoaAtualizada = new Pessoa("1noaA6N+", "Wilson Castro atualizado", "wilson@email", totalRendimetnos);
       
       try {
            String filePath = Constantes.DIRETORIO_FILE + Constantes.NOME_BASE_FILE_USUARIOS;
            File file = new File(filePath);
            
            if(!file.exists()){ file.createNewFile(); }
            
                        
            RandomAccessFile raf = new RandomAccessFile(file, "rw");
            
            boolean existePessoaComCodigo = false;
            
            String auxLinhasJaExistentes;
            String auxCodigoJaExistentes;
            
            while (raf.getFilePointer() < raf.length()) {
 
                auxLinhasJaExistentes = raf.readLine();
 
                String[] linhaDoArquivoDividida = auxLinhasJaExistentes.split(",");
 
                auxCodigoJaExistentes = linhaDoArquivoDividida[0];
 
                if (auxCodigoJaExistentes == pessoaAtualizada.getCodigo()) {
                    existePessoaComCodigo = true;
                    break;
                }
            }
            
            if(existePessoaComCodigo) {
                while (raf.getFilePointer() < raf.length()) {
                    File tmpFile = new File("arquivoTemporarioAlunos.txt");
                    RandomAccessFile tmpraf = new RandomAccessFile(tmpFile, "rw");
                    
                    raf.seek(0);
                    
                    
    
                }
            } else 
                raf.close();
            
        } catch (IOException ex) {
            System.out.println("Error IO: " + ex.getMessage());
        }
        catch(Exception ex) {
            System.out.println("Error Exception: " + ex.getMessage());
        }
    }
}
