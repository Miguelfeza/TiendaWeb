package web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nowe.modelo.Producto;
import com.nowe.persistencia.AccesoTiendaWeb;

/**
 * Servlet implementation class STodosProductos
 */
@WebServlet("/stodosproductos")
public class STodosProductos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public STodosProductos() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//0.Declarar variables
		List<Producto> sProductos;
		// 1. Instanciar la capa de persistencia
		AccesoTiendaWeb atw1 = new AccesoTiendaWeb();
		// 2. Mandar llamar al metodo obtenertodoslosproductos
		try {
			sProductos = atw1.obtenerTodos();
			System.out.println(sProductos.toString());
			if (sProductos!=null) {
				System.out.println("Entra en el if");
				//Si hay productos q mostrar
				//Se guarda la coleccion de productos en el request para luego mostarlo en un jsp
				request.setAttribute("jspProductos", sProductos);
				RequestDispatcher rd = request.getRequestDispatcher("/mostrarProductos.jsp");
				rd.forward(request, response);
			}
			
			RequestDispatcher rd = request.getRequestDispatcher("/plantilla.html");
			   rd.forward(request, response);

		} catch (ClassNotFoundException | SQLException e) {
			RequestDispatcher rd = request.getRequestDispatcher("/plantilla.html");
			   rd.forward(request, response);
			// TODO Auto-generated catch block
			System.out.println(e.toString());
		}
		// 3. Guardar ese array list  de lo productos en el ambito request
		// 4. Redireccionarlo en un jsp q muestre los productos
	}

}
