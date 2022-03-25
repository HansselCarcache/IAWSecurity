package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import datos.Dt_capacitacion;
import entidades.Capacitacion;

/**
 * Servlet implementation class Sl_Facultad
 */
@WebServlet("/Sl_Capacitacion")
public class Sl_Capacitacion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Sl_Capacitacion() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int opc = 0;
		opc = Integer.parseInt(request.getParameter("opcion"));
		// INSTANCIAMOS LOS OBJETOS
		Capacitacion cp = new Capacitacion();
		Dt_capacitacion dc = new Dt_capacitacion();
		// CONSTRUIMOS EL OBJETO CON LOS VALORES DE LOS CONTROLES
		cp.setNombre(request.getParameter("nombre"));
		cp.setId_modalidad(Integer.parseInt(request.getParameter("modalidad")));
		cp.setEstado(1);
		
		////////////////////////////////////////////////////////////////////
		
		switch(opc) {
		case 1:
			try {
				if(dc.addCapacitacion(cp)) {
					response.sendRedirect("production/tbl_capacitacion.jsp?msj=1");
				}else {
					response.sendRedirect("production/tbl_capacitacion.jsp?msj=2");
				}
			}catch(Exception e) {
				System.out.println("Error Sl_gestionUserRol opc1: "+e.getMessage());
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
