package web;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nowe.negocio.Carrito;

/**
 * Servlet implementation class SAddCarrito
 */
@WebServlet("/saddcarrito")
public class SAddCarrito extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SAddCarrito() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//1. declarar el objeto sesion (referencia sesion)
		HttpSession miSesion;
		Carrito miCarrito;
		// Recuperar o crear la sesion
		miSesion = request.getSession();
		//Recuperar el carrito de la sesion
		 miCarrito = (Carrito) miSesion.getAttribute("carrito");
		//la primera vez
		if (miCarrito == null) {
			miCarrito = new Carrito();
			miSesion.setAttribute("carrito", miCarrito);
		}
		
		
		//regoger el valor del id del request
		int sIdProducto = Integer.parseInt(request.getParameter("id"));
		//Añadir al carrito el id q nos llega del request
		try {
			miCarrito.addProducto(sIdProducto);
			//Guardar la variable en el request
			if (miCarrito!=null) {
				
				RequestDispatcher rd = request.getRequestDispatcher("/mostrarcarrito.jsp");
				rd.forward(request, response);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
