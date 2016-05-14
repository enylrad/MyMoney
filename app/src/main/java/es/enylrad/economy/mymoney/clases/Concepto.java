package es.enylrad.economy.mymoney.clases;

/**
 * Created by enylr on 13/05/2016.
 */
public class Concepto {

    private String concepto;
    private int cantidad;

    public Concepto(){

    }

    public Concepto(int cantidad){
        this.cantidad = cantidad;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public boolean isIngreso(){
        return cantidad > 0;

    }
}
