package src.models;


public class Pessoa extends Modal {

    protected String codigo;
    protected String nome;
    protected String email;
    protected float totalRendimentos;
    protected String inputString = "";

    public Pessoa(String inputString) {
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

}
