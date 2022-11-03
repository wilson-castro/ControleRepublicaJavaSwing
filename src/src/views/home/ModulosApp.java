
package src.views.home;

public enum ModulosApp {
    PESSOAS, DESPESAS, RESERVAS, INFO_RESERVA, VALOR_PAGAR, CALCULAR;

    public boolean isPessoas(){ return this.equals(PESSOAS); }
    
    public boolean isDespesas(){ return this.equals(DESPESAS); }
    
    public boolean isReservas(){ return this.equals(RESERVAS); }
    
    public boolean isInfoReserva(){ return this.equals(INFO_RESERVA); }
    
    public boolean isValorAPagar() { return this.equals(VALOR_PAGAR); }
    
    public boolean isCalcular() { return this.equals(CALCULAR); }
    
}
