package ar.edu.untref.dyasc;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import ar.edu.untref.dyasc.cliente.Cliente;
import ar.edu.untref.dyasc.cliente.CuentaCorriente;
import ar.edu.untref.dyasc.productos.Producto;
import ar.edu.untref.dyasc.productos.ProductoSuscribible;

public class Libreria {
    private Set<Cliente> clientes;
    
    public Libreria() {
        clientes = new HashSet<>();
    }
    
    public void vender(Cliente cliente, Producto producto, int mes, int anio) {
        CuentaCorriente cuentaDelCliente = cliente.obtenerCuentaCorriente();
        registrarCliente(cliente);
        cuentaDelCliente.agregarCompra(producto, mes, anio);
    }
    
    public void suscribirA(Cliente cliente, ProductoSuscribible producto, int mes, int anio,
            int duracion) {
        
        CuentaCorriente cuentaDelCliente = cliente.obtenerCuentaCorriente();
        registrarCliente(cliente);
        cuentaDelCliente.agregarSuscripcion(producto, mes, anio, duracion);
    }
    
    public Map<Cliente, Float> calcularCobrosMensuales(int mes, int anio) {
        Map<Cliente, Float> cobros = new HashMap<>();
        
        for (Cliente cliente : clientes) {
            CuentaCorriente cuentaDelCliente = cliente.obtenerCuentaCorriente();
            float total = cuentaDelCliente.obtenerTotal(mes, anio);                
            cobros.put(cliente, total);
        }
        
        return cobros;
    }
    
    public Map<Cliente, Float> calcularCobrosAnuales(int anio) {
        Map<Cliente, Float> cobros = new HashMap<>();
        
        for (Cliente cliente : clientes) {
            CuentaCorriente cuentaDelCliente = cliente.obtenerCuentaCorriente();
            float total = cuentaDelCliente.obtenerTotal(anio);                
            cobros.put(cliente, total);
        }
        
        return cobros;
    }
        
    private void registrarCliente(Cliente cliente) {
        clientes.add(cliente);
    }
}
