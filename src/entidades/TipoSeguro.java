package entidades;



public class TipoSeguro {
	private int idTipo;
	private String descripcion;
	
	public TipoSeguro(int idTipo, String descripcion)
	{
		this.setIdTipo(idTipo);
		this.setDescripcion(descripcion);
		
	}
	
	public TipoSeguro() {
		
	}
	public int getIdTipo() {
		return idTipo;
	}
	public void setIdTipo(int idTipo) {
		this.idTipo = idTipo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
}
