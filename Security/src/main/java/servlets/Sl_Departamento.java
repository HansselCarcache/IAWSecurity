package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datos.Dt_departamento ;
import entidades.Tbl_departamento;

	@WebServlet("/Sl_Departamento")

	public class Sl_Departamento  extends HttpServlet{
		
		
		private static final long serialVersionUID = 1L;
	    
	    /**
	     * @see HttpServlet#HttpServlet()
	     */
	    public Sl_Departamento() {
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
			Tbl_departamento  tdepa = new Tbl_departamento();
			Dt_departamento  dtdepa = new Dt_departamento();
			
			switch(opc) {
			case 1:
				// CONSTRUIMOS EL OBJETO CON LOS VALORES DE LOS CONTROLES
				tdepa.setNombre_departamento(request.getParameter("txtnombredepartamento"));
				tdepa.setId_facultad(Integer.parseInt(request.getParameter("cbxfacultad")));
				tdepa.setEstado(1);
				////////////////////////////////////////////////////////////////////
				
				try {
					if(dtdepa.addDepartamento(tdepa)) {
						response.sendRedirect("production/tbl_departamento.jsp?msj=1");
					}else {
						response.sendRedirect("production/tbl_departamento.jsp?msj=2");
					}
				}catch(Exception e) {
					System.out.println("Error Sl_Departamento opc1: "+e.getMessage());
					e.printStackTrace();
				}
				break;
				
			case 2:
				// CONSTRUIMOS EL OBJETO CON LOS VALORES DE LOS CONTROLES
				tdepa.setNombre_departamento(request.getParameter("txtnombredepartamento"));
				tdepa.setId_facultad(Integer.parseInt(request.getParameter("cbxfacultad")));
				tdepa.setId_departamento(Integer.parseInt(request.getParameter("idDepartamento")));
				try {
					
					if(dtdepa.modificarDepartamento(tdepa)) {
						response.sendRedirect("production/tbl_departamento.jsp?msj=3");
					}
					else {
						response.sendRedirect("production/tbl_departamento.jsp?msj=4");
					}
				}catch(Exception e) {
					System.out.println("Error Sl_Departamento opc2: "+e.getMessage());
					e.printStackTrace();
				}
				break;
				
			case 3:
				// CONSTRUIMOS EL OBJETO CON LOS VALORES DE LOS CONTROLES
				tdepa.setId_departamento(Integer.parseInt(request.getParameter("idDepartamento")));
				try {
					
					if(dtdepa.eliminarDepartamento(tdepa)) {
						response.sendRedirect("production/tbl_departamento.jsp?msj=5");
					}
					else {
						response.sendRedirect("production/tbl_departamento.jsp?msj=6");
					}
				}catch(Exception e) {
					System.out.println("Error Sl_Departamento opc3: "+e.getMessage());
					e.printStackTrace();
				}
				break;
				
			default:
				//codigo
				break;
				
			}
			
		}

	}
