package web;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nowe.modelo.Usuario;
import com.nowe.persistencia.AccesoTiendaWeb;

/**
 * Servlet implementation class SVerifica
 */
@WebServlet("/sverifica")
public class SVerifica extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SVerifica() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1. Recoger los valores de los controles
		String sUsuario, sPassword;
		Usuario u1 = null;
		// usar el método getParameter del request
		sUsuario = request.getParameter("usuario");
		sPassword = request.getParameter("password");

		// 2. Llamar a la capa de persistencia
		AccesoTiendaWeb at1 = new AccesoTiendaWeb();
		try {
			u1 = at1.obtenerPassword(sUsuario);
			if (u1 != null) {
				u1.setIdUsuario(sUsuario);
			}

			// Verificar que la contraseña del formulario HTML es igual a la de la BBDD
			// Verificar que la contraseña de la BBDD no sea nulo
			if (u1 != null) {
				if (u1.getPassword().equals(sPassword)) {

					// Entra en el caso de que sea valida la contraseña
					// Guardar el request el objeto usuario
					request.setAttribute("objetoUsuarioJava", u1);
					System.out.println(u1.toString());
					// 3. Redirigimos a un jsp
					RequestDispatcher rd = null;
					rd = request.getRequestDispatcher("/plantilla.html");
					rd.forward(request, response);
				}
			}
			// 3. Redirigimos a un jsp
			RequestDispatcher rd = null;
			rd = request.getRequestDispatcher("/login.jsp");
			rd.forward(request, response);

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.toString());

			// 3. Redirigimos a un jsp
			RequestDispatcher rd = null;
			rd = request.getRequestDispatcher("/login.jsp");
			rd.forward(request, response);
		}

	}

}
