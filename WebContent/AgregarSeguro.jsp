<%@ page import= "daoImpl.SeguroDaoImpl" %>
<%@ page import= "daoImpl.TipoSeguroDaoImpl" %>
<%@ page import = "entidades.TipoSeguro" %>
<%@ page import = "java.util.ArrayList" %>
<%@ page import = "java.util.List" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"

    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Agregar Seguro</title>
</head>
<body>

	<a href="Inicio.jsp">Inicio</a>
	<br>
	<a href="AgregarSeguro.jsp">Agregar seguro</a>
	<br>
	<a href="servletSeguro?Param=1" name="listar">Listar seguros</a>
	
	<h2>Agregar seguros</h2>

	<form method="get">
		<%TipoSeguroDaoImpl segImpl = new TipoSeguroDaoImpl(); %>
		<%SeguroDaoImpl segImplSeguro = new SeguroDaoImpl(); %>
		<p>Id seguro <%=segImplSeguro.lastId()+1 %></p> 
		<p>Descripcion <input type="text" name="txtDescripcion"> </p>
		<p>Tipo de seguro 
		<select name="tipoSeguro">
			<%
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
		</p>
		<p>Costo contratacion <input type="text" name="txtCosto"> </p>
		<p>Costo maximo asegurado <input type="text" name="txtCostoMax"> </p>
		
		<button> Aceptar </button>
	
	</form>
</body>
</html>