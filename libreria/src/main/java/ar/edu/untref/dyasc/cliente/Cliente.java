package ar.edu.untref.dyasc.cliente;

public class Cliente {
    private Direccion direccion;
    private CuentaCorriente cuentaCorriente;
    
    public Cliente(Direccion direccion) {
        this.direccion = direccion;
        this.cuentaCorriente = new CuentaCorriente();
    }
    
    public Direccion obtenerDireccion() {
        return direccion;
    }
    
    public CuentaCorriente obtenerCuentaCorriente() {
        return cuentaCorriente;
    }
}