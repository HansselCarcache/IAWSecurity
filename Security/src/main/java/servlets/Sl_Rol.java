package servlets;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datos.Dt_rol;
import entidades.Tbl_rol;

	@WebServlet("/Sl_Rol")

	public class Sl_Rol  extends HttpServlet{
		
		
		private static final long serialVersionUID = 1L;
	    
	    /**
	     * @see HttpServlet#HttpServlet()
	     */
	    public Sl_Rol () {
	        super();
	        // TODO Auto-generated constructor stub
	    }

		/**
		 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
		 */
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// TODO Auto-generated method stub
//			response.getWriter().append("Served at: ").append(request.getContextPath());
		}

		/**
		 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
		 */
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			int opc = 0;
			opc = Integer.parseInt(request.getParameter("opcion"));
			// INSTANCIAMOS LOS OBJETOS
			Tbl_rol  Rol = new Tbl_rol();
			Dt_rol  dtm = new Dt_rol ();
			// CONSTRUIMOS EL OBJETO CON LOS VALORES DE LOS CONTROLES

			
			
			////////////////////////////////////////////////////////////////////
			
			switch(opc) {
			case 1:
				Rol.setNombre_rol(request.getParameter("name"));
				Rol.setDescripcion(request.getParameter("desc"));
				Rol.setEstado(1);
				try {
					
					if(dtm.guardarRol (Rol)) {
						response.sendRedirect("production/tbl_Rol.jsp?msj=1");
					}else {
						response.sendRedirect("production/tbl_Rol.jsp?msj=2");
					}
				}catch(Exception e) {
					System.out.println("Error Sl_Rol opc1: "+e.getMessage());
					e.printStackTrace();
				}
				break;
			case 2:
				//codigo
				Rol.setId_rol(Integer.parseInt(request.getParameter("idrol")));
				Rol.setNombre_rol(request.getParameter("name"));
				Rol.setDescripcion(request.getParameter("desc"));
				
				try {
					if(dtm.modificarRol(Rol)) {
						response.sendRedirect("production/tbl_Rol.jsp?msj=3");
					}
					else {
						response.sendRedirect("production/tbl_Rol.jsp?msj=4");
					}
				}catch(Exception e) {
					System.out.println("Error Sl_Rol opc2: "+e.getMessage());
					e.printStackTrace();
				}
				break;
			case 3:
				
				Rol.setId_rol(Integer.parseInt(request.getParameter("idrol")));
				try {
					if(dtm.eliminarRol(Rol)) {
						response.sendRedirect("production/tbl_Rol.jsp?msj=5");
					}else {
						
						response.sendRedirect("production/tbl_Rol.jsp?msj=6");
					}
					}catch(Exception e) {
						System.out.println("Error Sl_Rol opc3: "+e.getMessage());
						e.printStackTrace();
					}
				break;
			default:
				//codigo
				break;
				
			}
		}

	}
