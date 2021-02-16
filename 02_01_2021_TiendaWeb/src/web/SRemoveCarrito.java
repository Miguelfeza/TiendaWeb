package web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.nowe.negocio.Carrito;

/**
 * Servlet implementation class SRemoveCarrito
 */
@WebServlet("/sremovecarrito")
public class SRemoveCarrito extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SRemoveCarrito() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// recuperar/crear el carrito de la sesion
		HttpSession miSesion = request.getSession();
		//recuperare el carrito
		Carrito c1 = (Carrito) miSesion.getAttribute("carrito");
		//validar q si es nulo hay q instanciarlo y guardarlo en sesion
		if (c1==null) {
			c1= new Carrito();
			miSesion.setAttribute("carrito", c1);
		}
	
		// mandar llamar a la capa modelo para eliminar el producto del carrito
		//recoger el id de la url
		int id = Integer.parseInt(request.getParameter("id"));
		c1.removeCarrito(id);
		// redireccionar al nuevo carrito  (mostrar carrito)
		RequestDispatcher rd = request.getRequestDispatcher("/mostrarcarrito.jsp");
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
