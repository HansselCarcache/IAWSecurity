package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import datos.Dt_facilitadores;

import entidades.Tbl_facilitadores;
import negocio.Ng_Facilitador;

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
			Tbl_facilitadores Faci = new Tbl_facilitadores();
			Ng_Facilitador Ngf = new Ng_Facilitador();
			Dt_facilitadores dtm = new Dt_facilitadores();
			// CONSTRUIMOS EL OBJETO CON LOS VALORES DE LOS CONTROLES
			Faci.setEmail(request.getParameter("email"));
			Faci.setGrado_academico(request.getParameter("grado_academico"));
			Faci.setCedula(request.getParameter("cedula"));
			Faci.setId_uca(request.getParameter("id_uca"));
			Faci.setNombres(request.getParameter("nombre"));
			Faci.setTelefono(request.getParameter("telefono"));
			
			
			
			////////////////////////////////////////////////////////////////////
			
			switch(opc) {
			case 1:
				try {
					System.out.print(Faci.getCedula());
					if(Ngf.existeCedula(Faci.getCedula()) == false) {
						if(dtm.addFacilitador(Faci)) {
							response.sendRedirect("production/tbl_facilitadores.jsp?msj=1");
						}else {
							response.sendRedirect("production/tbl_facilitadores.jsp?msj=2");
						}
						
					}else {
						response.sendRedirect("production/tbl_facilitadores.jsp?msj=7");
					}
					
					
				}catch(Exception e) {
					System.out.println("Error Sl_Facilitador opc1: "+e.getMessage());
					e.printStackTrace();
				}
				break;
			case 2:
				Faci.setId_facilitador(Integer.parseInt(request.getParameter("id_facilitador")));
				if(dtm.updateFacilitador(Faci)) {
					response.sendRedirect("production/tbl_facilitadores.jsp?msj=3");
				}else {
					response.sendRedirect("production/tbl_facilitadores.jsp?msj=4");
				}
				//codigo
				break;
			case 3:
				Faci.setId_facilitador(Integer.parseInt(request.getParameter("id_facilitador")));
				if(dtm.DeleteFacilitador(Faci)) {
					response.sendRedirect("production/tbl_facilitadores.jsp?msj=5");
				}else {
					
					response.sendRedirect("production/tbl_facilitadores.jsp?msj=6");
				}
				break;
			default:
				//codigo
				break;
				
			}
		}

	}

