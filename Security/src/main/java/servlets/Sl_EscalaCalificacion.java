package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datos.Dt_EscalaCalificacion;
import entidades.EscalaCalificacion;


/**
 * Servlet implementation class Sl_EscalaCalificacion
 */
@WebServlet("/Sl_EscalaCalificacion")
public class Sl_EscalaCalificacion extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	/**
     * @see HttpServlet#HttpServlet()
     */
    public Sl_EscalaCalificacion() {
        super();
        // TODO Auto-generated constructor stub
    }
    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int opc = 0;
		opc = Integer.parseInt(request.getParameter("opcion"));
		// INSTANCIAMOS LOS OBJETOS
		EscalaCalificacion ec = new EscalaCalificacion();
		Dt_EscalaCalificacion dec = new Dt_EscalaCalificacion();
		
		// CONSTRUIMOS EL OBJETO CON LOS VALORES DE LOS CONTROLES
		ec.setCalificacion(request.getParameter("calificacion"));
		ec.setDescripcion(request.getParameter("descripcion"));

		
		////////////////////////////////////////////////////////////////////
		
		switch(opc) {
		case 1:
			try {
				if(dec.addEscalaCalificacion(ec)) {
					response.sendRedirect("production/tbl_EscalaCalificacion.jsp?msj=1");
				}else {
					response.sendRedirect("production/tbl_EscalaCalificacion.jsp?msj=2");
				}
			}catch(Exception e) {
				System.out.println("Error Sl_EscalaCalificacion: opc1"+e.getMessage());
				e.printStackTrace();
			}
			break;
		case 2:
			//codigo
			break;
		default:
			//codigo
			break;
			
		}
	}

}