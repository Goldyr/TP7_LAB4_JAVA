package entidades;

public class Seguro {
	
	private int idSeguro;
	private String descripcion;
	private int idTipo; 
	private int costoContratacion; 
	private int costoAsegurado; 
	
	public Seguro() {}
	
	public Seguro(int idSeguro, String descripcion, int idTipo, int costoContratacion, int costoAsegurado) {
		setIdSeguro(idSeguro);
		setDescripcion(descripcion);
		setIdTipo(idTipo);
		setCostoContratacion(costoContratacion);
		setCostoAsegurado(costoAsegurado);
		
	}

	public int getIdSeguro() {
		return idSeguro;
	}
	public void setIdSeguro(int idSeguro) {
		this.idSeguro = idSeguro;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public int getIdTipo() {
		return idTipo;
	}
	public void setIdTipo(int idTipo) {
		this.idTipo = idTipo;
	}
	public int getCostoContratacion() {
		return costoContratacion;
	}
	public void setCostoContratacion(int costoContratacion) {
		this.costoContratacion = costoContratacion;
	}
	public int getCostoAsegurado() {
		return costoAsegurado;
	}
	public void setCostoAsegurado(int costoAsegurado) {
		this.costoAsegurado = costoAsegurado;
	}

}
