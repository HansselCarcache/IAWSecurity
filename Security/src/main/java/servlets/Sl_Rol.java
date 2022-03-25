package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datos.Dt_Rol ;
import entidades.Rol ;

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
			Rol  Rol = new Rol ();
			Dt_Rol  dtm = new Dt_Rol ();
			// CONSTRUIMOS EL OBJETO CON LOS VALORES DE LOS CONTROLES
			Rol.setNombre_rol(request.getParameter("name"));
			Rol.setEstado(1);
			Rol.setDescripcion(request.getParameter("descripcion"));
			
			
			////////////////////////////////////////////////////////////////////
			
			switch(opc) {
			case 1:
				try {
					
					if(dtm.addRol (Rol)) {
						response.sendRedirect("production/tbl_rol.jsp?msj=1");
					}else {
						response.sendRedirect("production/tbl_rol.jsp?msj=2");
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
