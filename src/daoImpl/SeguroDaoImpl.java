package daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.SeguroDao;
import entidades.Seguro;




public class SeguroDaoImpl implements SeguroDao{

	private static final String insert = "INSERT INTO Seguros(idSeguro, descripcion, idTipo, costoContratacion, costoAsegurado) VALUES(?, ?, ?, ?, ?)";
	private static final String read_x_tipoSeguro = "Select * FROM Seguros where idTipo = ?";
	private static final String lastId = "SELECT MAX(idSeguro) FROM segurosgroup.seguros;";


	private static final String readall = "SELECT * FROM segurosgroup.seguros";
	
	@Override
	public boolean insert(Seguro seguro) {
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean successInsert = false;
		try
		{
			statement = conexion.prepareStatement(insert);
			statement.setInt(1, seguro.getIdSeguro());
			statement.setString(2, seguro.getDescripcion());
			statement.setInt(3, seguro.getIdTipo());
			statement.setInt(4, seguro.getCostoContratacion());
			statement.setInt(5, seguro.getCostoAsegurado());
			if(statement.executeUpdate() > 0)
			{
				conexion.commit();
				successInsert = true;
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
			try {
				conexion.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		
		return successInsert;
		
	}


	public List<Seguro> readX_tiposeguro(int idTipoSeguro) { //lee seguros segun el id del tipo de seguro Punto 3
		PreparedStatement statement;
		ResultSet resultSet; //Guarda el resultado de la query
		Connection conexion = Conexion.getConexion().getSQLConexion();
		ArrayList<Seguro> seguros = new ArrayList<Seguro>();

		try
		{
			statement = conexion.prepareStatement(read_x_tipoSeguro);
			statement.setInt(1, idTipoSeguro);
			resultSet = statement.executeQuery();
			
			while(resultSet.next())
			{
				seguros.add(getSeguro(resultSet));
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return seguros;

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
	

	
	




	private Seguro getSeguro(ResultSet resultSet) throws SQLException
	{
		int idSeguro = resultSet.getInt("idSeguro");
		String descripcion = resultSet.getString("descripcion");
		int idTipo = resultSet.getInt("idTipo");
		int costoContratacion  = resultSet.getInt("costoContratacion");
		int costoAsegurado = resultSet.getInt("costoAsegurado");
		return new Seguro(idSeguro, descripcion, idTipo, costoContratacion, costoAsegurado);
	}



	@Override
	public List<Seguro> readAll() {
		PreparedStatement statement;
		ResultSet resultSet; //Guarda el resultado de la query
		ArrayList<Seguro> seguros = new ArrayList<Seguro>();
		Conexion conexion = Conexion.getConexion();
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(readall);
			resultSet = statement.executeQuery();
			while(resultSet.next())
			{
				seguros.add(getSeguro(resultSet));
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return seguros;

	}
	
	

}
