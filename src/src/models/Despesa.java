
package src.models;

import src.utils.Constantes;


public class Despesa extends Modal {

    protected long codigo = 0;
    protected String nome = null;
    protected String descricao = null;
    protected String categoria = null;
    protected String prioridade = Constantes.DEFAULT_VALUE_PRIORIDADE;
    protected float valor_despesa = 0f;
    protected String inputString = "";

    public Despesa(String inputString) {
        this.inputString = inputString;
        String[] cells = this.inputString.split(";");
        this.codigo = Long.parseLong(cells[0]);
        this.nome = cells[1];
        this.descricao = cells[2];
        this.categoria = cells[3];
        this.prioridade = cells[4];
        this.valor_despesa = Float.parseFloat(cells[5]);
    }

    public long getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(String prioridade) {
        this.prioridade = prioridade;
    }

    public float getValor_despesa() {
        return valor_despesa;
    }

    public void setValor_despesa(float valor_despesa) {
        this.valor_despesa = valor_despesa;
    }

}
