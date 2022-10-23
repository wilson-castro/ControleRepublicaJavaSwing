
package src.views.home;

public enum ModulosApp {
    USUARIO, DESPESAS, RESERVAS, VALOR_PAGO_NO_MES;

    public boolean isUsuario(){ return this.equals(USUARIO); }
    
    public boolean isDespesas(){ return this.equals(DESPESAS); }
    
    public boolean isReservas(){ return this.equals(RESERVAS); }
    
    public boolean isValorPagoNoMes(){ return this.equals(VALOR_PAGO_NO_MES); }
    
}
