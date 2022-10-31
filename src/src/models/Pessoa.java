package src.models;

import com.google.gson.Gson;

public class Pessoa extends Modal {

    protected String codigo;
    protected String nome;
    protected String email;
    protected float totalRendimentos;
    protected String inputString = "";

    public Pessoa(String inputString) {
        this.inputString = null;
        this.inputString = inputString;
        String[] cells = this.inputString.split(";");
        this.codigo = cells[0];
        this.nome = cells[1];
        this.email = cells[2];
        this.totalRendimentos = Float.parseFloat(cells[3]);
    }

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

    //    public static Pessoa create(String nome, String email, float totalRendimentos){
//        if(nome != null && email != null){
//            String codigo = RandomString.getAlphaNumericString(Constantes.NUMERO_DIGITOS_CODIGOS);
//            return new Pessoa(codigo,nome, email, totalRendimentos);
//        }
//        
//        return null;
//    }
    @Override
    public String toJson() {
        Gson gson = new Gson();
        return gson.toJson(Pessoa.this);
    }

}
