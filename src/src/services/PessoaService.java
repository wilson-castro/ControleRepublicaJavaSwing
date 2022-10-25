
package src.services;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;
import src.models.Pessoa;
import src.utils.Constantes;
import src.utils.FileManager;
import src.utils.RandomString;

public class PessoaService {
    public List<Pessoa> save(Pessoa pessoa ){       
        try{
            String filePath = Constantes.DIRETORIO_FILE + Constantes.NOME_BASE_FILE_USUARIOS;
            File file = new File(filePath);
            
            if(!file.exists()){ file.createNewFile(); }
            
            RandomAccessFile raf = new RandomAccessFile(file, "rw");
            
            boolean codigoJaCadastrado = false;
            
            String auxLinhasJaExistentes;
            String auxCodigoJaExistentes;
            
            while (raf.getFilePointer() < raf.length()) {
 
                auxLinhasJaExistentes = raf.readLine();
 
                String[] valores = auxLinhasJaExistentes.split(",");
 
                auxCodigoJaExistentes = valores[0];
 
                if (auxCodigoJaExistentes.equals(pessoa.getCodigo())) {
                    codigoJaCadastrado = true;
                    break;
                }
            }
            
            if(codigoJaCadastrado){
                pessoa.setCodigo(RandomString.getAlphaNumericString(Constantes.NUMERO_DIGITOS_CODIGOS));
            }
            
            String novaLina = FileManager.toFileLine(pessoa.getValues());

            raf.writeBytes(novaLina);

            raf.writeBytes(System.lineSeparator());

            raf.close();
            
        } catch (IOException ex) {
            System.out.println("Error IO: " + ex.getMessage());
        }
        catch(Exception ex) {
            System.out.println("Error Exception: " + ex.getMessage());
        }
        
        
        return getAll();
    }
    
    public List<Pessoa> getAll() {
            List<Pessoa> pessoas = new ArrayList<>();
        
        try {
            String filePath = Constantes.DIRETORIO_FILE + Constantes.NOME_BASE_FILE_USUARIOS;
            File file = new File(filePath);

            if(!file.exists()){ file.createNewFile(); }
            
            RandomAccessFile raf = new RandomAccessFile(file, "rw");

            String linha;
            
            while (raf.getFilePointer() < raf.length()) {
                linha = raf.readLine();
                
                String[] valores = linha.split(",");
                
                pessoas.add(
                    new Pessoa(
                        valores[0],
                        valores[1].replaceAll(Constantes.STRING_VIRGULA_NO_ARQUIVO, ","),
                        valores[2].replaceAll(Constantes.STRING_VIRGULA_NO_ARQUIVO, ","),
                        Float.parseFloat(valores[3])
                    )
                );
                
            }
        } catch(IOException iex){
            System.out.println("Error IO: " + iex.getMessage());
        } catch(NumberFormatException nef){
            System.out.println("Error NumerFormat: " + nef.getMessage());
        } catch(Exception ex) {
            System.out.println("Error Exception: " + ex.getMessage());
        }
        
        return pessoas;
    }
}
