<%@ page import= "daoImpl.SeguroDaoImpl" %>
<%@ page import = "entidades.TipoSeguro" %>
<%@ page import = "java.util.ArrayList" %>
<%@ page import = "java.util.List" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Listar Seguro</title>
</head>
<body>
<a href="Inicio.jsp">Inicio</a>
<br>
<a href="AgregarSeguro.jsp">Agregar seguro</a>
<br>
<a href="ListarSeguros.jsp">Listar seguros</a>
<br>

<h3>"Tipo de seguros de la base de datos"</h3>

<form>
	<p>Busqueda por tipo de seguros: </p>
		<select name="tipoSeguro">
			<%
			SeguroDaoImpl segImpl = new SeguroDaoImpl();
			List<TipoSeguro> listatiposeguros = new ArrayList<TipoSeguro>();
			listatiposeguros = segImpl.ddlTipoSeguros();
			for(TipoSeguro ts : listatiposeguros)//Por cada objeto dentro de la lista me genera una opcion mas para el ddl
			{
			%>
				<option value="<%=ts.getIdTipo()%>"> <%=ts.getDescripcion()%> </option>
			<%
			}
			%>
		</select>
</form>

</body>
</html>