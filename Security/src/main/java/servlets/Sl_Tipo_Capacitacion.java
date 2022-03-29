package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datos.Dt_Facultad;
import datos.Dt_Modalidad;
import entidades.Facultad;
import entidades.Modalidad;

@WebServlet("/Sl_Modalidad")

public class Sl_Modalidad extends HttpServlet{
	
	
	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Sl_Modalidad() {
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
		Modalidad Mod = new Modalidad();
		Dt_Modalidad dtm = new Dt_Modalidad();
		// CONSTRUIMOS EL OBJETO CON LOS VALORES DE LOS CONTROLES
		Mod.setNombre_modalidad(request.getParameter("name"));
		 int certif = Integer.parseInt(request.getParameter("certificada"));
		Mod.setCertificada(certif);
		
		Mod.setDescripcion(request.getParameter("descripcion"));
		
		
		////////////////////////////////////////////////////////////////////
		
		switch(opc) {
		case 1:
			try {
				
				if(dtm.addModalidad(Mod)) {
					response.sendRedirect("production/tbl_modalidad.jsp?msj=1");
				}else {
					response.sendRedirect("production/tbl_modalidad.jsp?msj=2");
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
