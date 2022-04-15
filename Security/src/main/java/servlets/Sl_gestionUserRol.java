package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidades.Tbl_userRol;
import datos.Dt_roluser;


/**
 * Servlet implementation class Sl_gestionUserRol
 */
@WebServlet("/Sl_gestionUserRol")
public class Sl_gestionUserRol extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Sl_gestionUserRol() {
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
		// TODO Auto-generated method stub
		//	doGet(request, response);
		
		//obtenemos el valor de opcion
		int opc = 0;
		opc = Integer.parseInt(request.getParameter("opcion"));
		
		
		// INSTANCIAMOS LOS OBJETOS
		Tbl_userRol tur = new Tbl_userRol();
		Dt_roluser dtur = new Dt_roluser();
		
		
		// CONSTRUIMOS EL OBJETO CON LOS VALORES DE LOS CONTROLES
		tur.setId_user(Integer.parseInt(request.getParameter("cbxUser")));
		tur.setId_rol(Integer.parseInt(request.getParameter("cbxRol")));
		
		////////////////////////////////////////////////////////////////////
		
		switch(opc) {
		case 1:
			try {
				if(dtur.guardarRoluser(tur)) {
					response.sendRedirect("production/tbl_rolusuario.jsp?msj=1");
				}else {
					response.sendRedirect("production/tbl_rolusuario.jsp?msj=2");
				}
			}catch(Exception e) {
				System.out.println("Error Sl_gestionUserRol opc1: "+e.getMessage());
				e.printStackTrace();
			}
			break;
		case 2:
			tur.setId_userRol(Integer.parseInt(request.getParameter("idrolu")));
			try {
				tur.setId_rol(Integer.parseInt(request.getParameter("cbxRol")));
				if(dtur.modificarRolUser(tur)) {
					response.sendRedirect("production/tbl_rolusuario.jsp?msj=3");
				}
				else {
					response.sendRedirect("production/tbl_rolusuario.jsp?msj=4");
				}
			}catch(Exception e) {
				System.out.println("Error Sl_gestionUserRol opc2: "+e.getMessage());
				e.printStackTrace();
			}
			break;
		case 3:
			tur.setId_userRol(Integer.parseInt(request.getParameter("idrolu")));
			try {
				tur.setId_user(Integer.parseInt(request.getParameter("cbxUser")));
				tur.setId_rol(Integer.parseInt(request.getParameter("cbxRol")));
				if(dtur.eliminarRolUser(tur)) {
					response.sendRedirect("production/tbl_rolusuario.jsp?msj=5");
				}
				else {
					response.sendRedirect("production/tbl_rolusuario.jsp?msj=6");
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
