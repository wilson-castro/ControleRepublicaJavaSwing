
package src.views.home;

public enum ModulosApp {
    PESSOAS, DESPESAS, RESERVAS, VALOR_PAGO_NO_MES;

    public boolean isPessoas(){ return this.equals(PESSOAS); }
    
    public boolean isDespesas(){ return this.equals(DESPESAS); }
    
    public boolean isReservas(){ return this.equals(RESERVAS); }
    
    public boolean isValorPagoNoMes(){ return this.equals(VALOR_PAGO_NO_MES); }
    
}
