package daoImpl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.TipoSeguroDao;
import entidades.TipoSeguro;

public class TipoSeguroDaoImpl implements TipoSeguroDao{
	private static final String tipoSeguro= "SELECT * FROM tiposeguros;"; 
	private static final String tipoSeguroXid= "SELECT * FROM tiposeguros where idTipo=?;"; 

	@Override
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
				listatiposeguros.add(getTipoSeguro(resultSet));
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}

		return listatiposeguros;
	}

	public TipoSeguro readTipo_id(int idTipoSeguro) { //lee tiposeguro segun el id del tipo de seguro Punto 3
		PreparedStatement statement;
		ResultSet resultSet; //Guarda el resultado de la query
		Connection conexion = Conexion.getConexion().getSQLConexion();
		TipoSeguro tiposeguro = new TipoSeguro();

		try
		{
			statement = conexion.prepareStatement(tipoSeguroXid);
			statement.setInt(1, idTipoSeguro);
			resultSet = statement.executeQuery();

			while(resultSet.next()) {
				tiposeguro = (getTipoSeguro(resultSet));
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();

		}
		return tiposeguro;

	}


	private TipoSeguro getTipoSeguro(ResultSet resultSet) throws SQLException
	{
		int idTipo = resultSet.getInt("idTipo");
		String descripcion = resultSet.getString("descripcion");
		return new TipoSeguro(idTipo,descripcion);
	}

}