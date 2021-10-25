package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.SeguroDao;
import daoImpl.SeguroDaoImpl;
import entidades.Seguro;

/**
 * Servlet implementation class serlvletSeguro
 */
@WebServlet("/serlvletSeguro")
public class serlvletSeguro extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public serlvletSeguro() {
        super();

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean confirmo=false;
		if(request.getParameter("btnaceptar")!=null){
			Seguro seguroaux = new Seguro();
			seguroaux.setCostoAsegurado(Integer.parseInt(request.getParameter("txtCosto")) );
			seguroaux.setCostoContratacion(Integer.parseInt(request.getParameter("txtCostoMax")) );
			seguroaux.setIdTipo(Integer.parseInt(request.getParameter("tipoSeguro")) );
			seguroaux.setDescripcion(request.getParameter("txtDescripcion"));
				
			SeguroDaoImpl sdao = new SeguroDaoImpl();
			int ultimoid= sdao.lastId()+1;
			seguroaux.setIdSeguro(ultimoid);
			confirmo = sdao.insert(seguroaux);
		}
		request.setAttribute("confirmacion", confirmo);
		RequestDispatcher rd = request.getRequestDispatcher("AgregarSeguro.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
