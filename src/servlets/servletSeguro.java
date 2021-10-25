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
@WebServlet("/servletSeguro")
public class servletSeguro extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public servletSeguro() {
        super();

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		int selectedId = Integer.parseInt(request.getParameter("tipoSeguro"));
		
		// 
		if(request.getParameter("btnFiltrarSeguros") != null) {
			SeguroDaoImpl dao = new SeguroDaoImpl();
			ArrayList<Seguro> listaSeguros = (ArrayList<Seguro>) dao.readX_tiposeguro(selectedId);
			
			request.setAttribute("listaFiltrada", listaSeguros);
			
			for (Seguro seguro : listaSeguros) {
				System.out.println(seguro.getDescripcion());
			}
			
			RequestDispatcher rd = request.getRequestDispatcher("/ListarSeguros.jsp");
			rd.forward(request, response);
		}

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
