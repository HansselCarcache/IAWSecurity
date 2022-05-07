package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datos.Dt_rol;
import datos.Dt_rolopciones;
import entidades.Tbl_rol;
import entidades.Tbl_rolopcion;


/**
 * Servlet implementation class Sl_OfertaDet
 */
@WebServlet("/Sl_OpcionRol")
public class Sl_OpcionRol extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Sl_OpcionRol() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int opc = 0;
		opc = Integer.parseInt(request.getParameter("opcion"));
		// INSTANCIAMOS LOS OBJETOS
		Tbl_rolopcion or = new Tbl_rolopcion();
		Dt_rolopciones dor = new Dt_rolopciones();
				
		// CONSTRUIMOS EL OBJETO CON LOS VALORES DE LOS CONTROLES

	
		////////////////////////////////////////////////////////////////////
		
		switch(opc) {
		case 1:
			or.setId_rol(Integer.parseInt(request.getParameter("cbxRol")));
			or.setId_opcion(Integer.parseInt(request.getParameter("cbxOpc")));
			try {
				if(dor.guardarRoluser(or)) {
					response.sendRedirect("production/tbl_rolopciones.jsp?msj=1");
				}else {
					response.sendRedirect("production/tbl_rolopciones.jsp?msj=2");
				}
			}catch(Exception e) {
				System.out.println("Error Sl_EscalaCalificacion: opc1"+e.getMessage());
				e.printStackTrace();
			}
			break;
		case 2:
			or.setId_rol(Integer.parseInt(request.getParameter("cbxRol")));
			or.setId_opcion(Integer.parseInt(request.getParameter("cbxOpc")));
			or.setId_rol_opciones(Integer.parseInt(request.getParameter("idrolop")));
			try {
				or.setId_rol(Integer.parseInt(request.getParameter("cbxRol")));
				or.setId_opcion(Integer.parseInt(request.getParameter("cbxOpc")));
				if(dor.modificarRolOp(or)) {
					response.sendRedirect("production/tbl_rolopciones.jsp?msj=3");
				}
				else {
					response.sendRedirect("production/tbl_rolopciones.jsp?msj=4");
				}
			}catch(Exception e) {
				System.out.println("Error Sl_gestionUserRol opc2: "+e.getMessage());
				e.printStackTrace();
			}
			break;
			
		case 3: 
			or.setId_rol_opciones(Integer.parseInt(request.getParameter("idrolop")));
			try {
	
				if(dor.eliminarRolO(or)) {
					response.sendRedirect("production/tbl_rolopciones.jsp?msj=5");
				}
				else {
					response.sendRedirect("production/tbl_rolopciones.jsp?msj=6");
				}
			}catch(Exception e) {
				System.out.println("Error Sl_gestionUserRol opc3: "+e.getMessage());
				e.printStackTrace();
			}
			break;
		default:
			//codigo
			break;
			
		}
	}
}

