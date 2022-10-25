
package src.models;

import java.util.UUID;
import src.utils.Constantes;
import src.utils.RandomString;

public class Pessoa {    
    
    private String codigo;
    private String nome;
    private String email;
    private float totalRendimentos;
        
    public Pessoa() {}

    public Pessoa(String nome, String email, float totalRendimentos) {
        this.nome = nome;
        this.email = email;
        this.totalRendimentos = totalRendimentos;
    }
    
    public Pessoa(String codigo, String nome, String email, float totalRendimentos) {
     this.codigo = codigo;
     this.nome = nome;
     this.email = email;
     this.totalRendimentos = totalRendimentos;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public float getTotalRendimentos() {
        return totalRendimentos;
    }

    public void setTotalRendimentos(float totalRendimentos) {
        this.totalRendimentos = totalRendimentos;
    }
    
    
    public static Pessoa create(String nome, String email, float totalRendimentos){
        if(nome != null && email != null){
            String codigo = RandomString.getAlphaNumericString(Constantes.NUMERO_DIGITOS_CODIGOS);
            return new Pessoa(codigo,nome, email, totalRendimentos);
        }
        
        return null;
    }
    
    public String[] getValues(){
        String[] values = { this.codigo, this.nome, this.email, this.totalRendimentos+""};
        return values;
    }
}
