package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datos.Dt_Departamento ;
import entidades.Departamento ;

	@WebServlet("/Sl_Departamento")

	public class Sl_Departamento  extends HttpServlet{
		
		
		private static final long serialVersionUID = 1L;
	    
	    /**
	     * @see HttpServlet#HttpServlet()
	     */
	    public Sl_Departamento () {
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
			Departamento  Dep = new Departamento ();
			Dt_Departamento  dtm = new Dt_Departamento ();
			// CONSTRUIMOS EL OBJETO CON LOS VALORES DE LOS CONTROLES
			Dep.setNombre_departamento(request.getParameter("nombre_departamento"));
			Dep.setId_facultad(Integer.parseInt(request.getParameter("facultad")));
			Dep.setEstado(1);
			
			
			
			////////////////////////////////////////////////////////////////////
			
			switch(opc) {
			case 1:
				try {
					
					if(dtm.addDepartamento (Dep)) {
						response.sendRedirect("production/tbl_departamento.jsp?msj=1");
					}else {
						response.sendRedirect("production/tbl_departamento.jsp?msj=2");
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
