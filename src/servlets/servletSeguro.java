package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daoImpl.SeguroDaoImpl;
import entidades.Seguro;

/**
 * Servlet implementation class servletSeguro
 */
@WebServlet( name = "servletSeguro", urlPatterns = { "/servletSeguro" } )
public class servletSeguro extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servletSeguro() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		if(request.getParameter("btnaceptar")!=null){
			boolean confirmo=false;
			Seguro seguroaux = new Seguro();
			seguroaux.setCostoAsegurado(Integer.parseInt(request.getParameter("txtCosto")) );
			seguroaux.setCostoContratacion(Integer.parseInt(request.getParameter("txtCostoMax")) );
			seguroaux.setIdTipo(Integer.parseInt(request.getParameter("tipoSeguro")) );
			seguroaux.setDescripcion(request.getParameter("txtDescripcion"));
			
			SeguroDaoImpl sdao = new SeguroDaoImpl();
			int ultimoid= sdao.lastId()+1;
			seguroaux.setIdSeguro(ultimoid);
			confirmo = sdao.insert(seguroaux);
			
		
			
			request.setAttribute("confirmacion", confirmo);
			RequestDispatcher rd = request.getRequestDispatcher("AgregarSeguro.jsp");
			rd.forward(request, response);
			
		}

		
		if(request.getParameter("Param")!=null) {
			SeguroDaoImpl dao = new SeguroDaoImpl();
			ArrayList<Seguro> listaSeguros = (ArrayList<Seguro>) dao.readAll();

			request.setAttribute("listartodo", listaSeguros);

			RequestDispatcher rd = request.getRequestDispatcher("ListarSeguros.jsp");
			rd.forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
int selectedId = Integer.parseInt(request.getParameter("tipoSeguro"));
		
		if(request.getParameter("btnFiltrarSeguros") != null) {
			SeguroDaoImpl dao = new SeguroDaoImpl();
			ArrayList<Seguro> listaSeguros = (ArrayList<Seguro>) dao.readX_tiposeguro(selectedId);
			
			request.setAttribute("listaFiltrada", listaSeguros);


			RequestDispatcher rd = request.getRequestDispatcher("/ListarSeguros.jsp");
			rd.forward(request, response);
		}
	}

}
