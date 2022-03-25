package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datos.Dt_Facilitador;
import entidades.Facilitador;

	@WebServlet("/Sl_Facilitador")

	public class Sl_Facilitador extends HttpServlet{
		
		
		private static final long serialVersionUID = 1L;
	    
	    /**
	     * @see HttpServlet#HttpServlet()
	     */
	    public Sl_Facilitador() {
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
			Facilitador Faci = new Facilitador();
			Dt_Facilitador dtm = new Dt_Facilitador();
			// CONSTRUIMOS EL OBJETO CON LOS VALORES DE LOS CONTROLES
			Faci.setEmail(request.getParameter("persEmail"));
			Faci.setGrado_academico(request.getParameter("academic"));
			Faci.setId_uca(request.getParameter("iduca"));
			Faci.setNombre_completo(request.getParameter("fullname"));
			Faci.setTelefono_contacto(request.getParameter("telephone"));
			
			
			
			////////////////////////////////////////////////////////////////////
			
			switch(opc) {
			case 1:
				try {
					
					if(dtm.addFacilitador(Faci)) {
						response.sendRedirect("production/tbl_facilitador.jsp?msj=1");
					}else {
						response.sendRedirect("production/tbl_facilitador.jsp?msj=2");
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

