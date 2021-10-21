package daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.SeguroDao;
import entidades.Seguro;
import entidades.TipoSeguro;



public class SeguroDaoImpl implements SeguroDao{

	private static final String insert = "INSERT INTO personas(Dni, Nombre, Apellido) VALUES(?, ?, ?)";
	
	private static final String lastId = "SELECT MAX(idSeguro) FROM segurosgroup.seguros;";
	private static final String tipoSeguro= "SELECT * FROM tiposeguros;"; 

	
	@Override
	public boolean insert(Seguro persona) {
		return false;
		
	}


	

	

	
	//Devuelve la ultima id 
	public int lastId() {

				PreparedStatement statement;
				ResultSet resultSet;
				Seguro seguro = new Seguro();
				Conexion conexion = Conexion.getConexion();
				try 
				{
					statement = conexion.getSQLConexion().prepareStatement(lastId);
					resultSet = statement.executeQuery();
					resultSet.next();
					seguro.setIdSeguro(resultSet.getInt("MAX(idSeguro)"));
					
				} 
				catch (SQLException e) 
				{
					e.printStackTrace();
				}
				return seguro.getIdSeguro();
		
	}
	
	//Devuelve una lista de seguros donde van a tener definido Tipo de seguro y el id del tipo de seguro
	public List<TipoSeguro> ddlTipoSeguros() {
		PreparedStatement statement;
		ResultSet resultSet; 
		ArrayList<TipoSeguro> listatiposeguros = new ArrayList<TipoSeguro>();
		Conexion conexion = Conexion.getConexion();
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(tipoSeguro);
			resultSet = statement.executeQuery();
			while(resultSet.next())
			{
				listatiposeguros.add(setTipoSeguro(resultSet));
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		return listatiposeguros;
	}
	
	
	private TipoSeguro setTipoSeguro(ResultSet resultSet) throws SQLException
	{
		int idTipo = resultSet.getInt("idTipo");
		String descripcion = resultSet.getString("descripcion");
		return new TipoSeguro(idTipo,descripcion);
	}







	@Override
	public List<Seguro> readAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
