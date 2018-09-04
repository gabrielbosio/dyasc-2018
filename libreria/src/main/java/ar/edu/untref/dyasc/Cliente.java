package ar.edu.untref.dyasc;

public class Cliente {
	private Direccion direccion;
	private CuentaCorriente cuentaCorriente;
	
	public Cliente(Direccion direccion, CuentaCorriente cuentaCorriente) {
		this.direccion = direccion;
		this.cuentaCorriente = cuentaCorriente;
	}

	public Direccion obtenerDireccion() {
		return direccion;
	}

	public CuentaCorriente obtenerCuentaCorriente() {
		return cuentaCorriente;
	}
}
