package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import datos.Dt_escalacalificacion;
import entidades.Tbl_escalaCalificacion;


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
		Tbl_escalaCalificacion ec = new Tbl_escalaCalificacion();
		Dt_escalacalificacion dec = new Dt_escalacalificacion();
		
		// CONSTRUIMOS EL OBJETO CON LOS VALORES DE LOS CONTROLES
		ec.setTipo_calificacion(request.getParameter("tipo"));
		ec.setDescripcion(request.getParameter("desc"));

		
		////////////////////////////////////////////////////////////////////
		
		switch(opc) {
		case 1:
			try {
				  int id = dec.addEscalaCalificacion(ec);
					if(id > 0  ) {
						
						
					response.sendRedirect("production/addEscalaCalificacionDet.jsp?msj=1&m="+id);
				}else {
					response.sendRedirect("production/addEscalaCalificacion.jsp?msj=2");
				}
			}catch(Exception e) {
				System.out.println("Error Sl_escalaCalificacion: opc1"+e.getMessage());
				e.printStackTrace();
			}
			break;
	
			
		case 2:
			
			ec.setId_escala(Integer.parseInt(request.getParameter("id_escala")));
			try {
				if (dec.editEscala(ec)) {
					// Si
					response.sendRedirect("production/updateEscalaCalificacion.jsp?msj=1&m=" + ec.getId_escala());
				} else {
					// No
					response.sendRedirect("production/updateEscalaCalificacion.jsp?msj=2&m=" + ec.getId_escala());
				}

			}catch(Exception e) {
				System.out.println("Error Sl_Escala opc2: "+e.getMessage());
				e.printStackTrace();
			}
			break;	
		case 3:
			
			ec.setId_escala(Integer.parseInt(request.getParameter("id_escala")));
			try {
				if (dec.deleteEscala(ec)) {
					// Si
					response.sendRedirect("production/tbl_escalaCalificacion.jsp?msj=1");
				} else {
					// No
					response.sendRedirect("production/deleteEscalaCalificacion.jsp?msj=1&m=" + ec.getId_escala());
				}

			}catch(Exception e) {
				System.out.println("Error Sl_Oferta opc3: "+e.getMessage());
				e.printStackTrace();
			}
			
			break;
		
			
		}
		
			
	
			
		}
	

}