
package src.models;

public class Reserva extends Modal {
    protected long codigo = 0;
    protected String codigoAluno;
    protected String nomeAluno;
    protected float valorContribuicao;
    protected String inputString = "";

    public Reserva(String inputString){
        this.inputString = inputString;
        String[] cells = this.inputString.split(";");
        this.codigo = Long.parseLong(cells[0]);
        this.codigoAluno = cells[1];
        this.nomeAluno = cells[2];
        this.valorContribuicao = Float.parseFloat(cells[3]);
    }

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public String getCodigoAluno() {
        return codigoAluno;
    }

    public void setCodigoAluno(String codigoAluno) {
        this.codigoAluno = codigoAluno;
    }

    public String getNomeAluno() {
        return nomeAluno;
    }

    public void setNomeAluno(String nomeAluno) {
        this.nomeAluno = nomeAluno;
    }

    public float getValorContribuicao() {
        return valorContribuicao;
    }

    public void setValorContribuicao(float valorContribuicao) {
        this.valorContribuicao = valorContribuicao;
    }

    public String getInputString() {
        return inputString;
    }

    public void setInputString(String inputString) {
        this.inputString = inputString;
    }
    
    
}
