package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datos.Dt_carreras ;
import entidades.Tbl_Carreras;


@WebServlet("/Sl_Carrera")

public class Sl_Carrera  extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Sl_Carrera() {
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
		Tbl_Carreras  tc = new Tbl_Carreras();
		Dt_carreras  dtc = new Dt_carreras();
		
		switch(opc) {
		case 1:
			// CONSTRUIMOS EL OBJETO CON LOS VALORES DE LOS CONTROLES
			tc.setNombre_carrera(request.getParameter("txtnombrecarrera"));
			tc.setId_departamento(Integer.parseInt(request.getParameter("cbxdepartamento")));
			tc.setEstado(1);
			////////////////////////////////////////////////////////////////////
			
			try {
				if(dtc.guardarCarrera(tc)) {
					response.sendRedirect("production/tbl_Carreras.jsp?msj=1");
				}else {
					response.sendRedirect("production/tbl_Carreras.jsp?msj=2");
				}
			}catch(Exception e) {
				System.out.println("Error Sl_Carrera opc1: "+e.getMessage());
				e.printStackTrace();
			}
			break;
			
		case 2:
			// CONSTRUIMOS EL OBJETO CON LOS VALORES DE LOS CONTROLES
			tc.setNombre_carrera(request.getParameter("txtnombrecarrera"));
			tc.setId_departamento(Integer.parseInt(request.getParameter("cbxdepartamento")));
			tc.setId_carrera(Integer.parseInt(request.getParameter("idcarrera")));
			try {
				
				if(dtc.modificarCarrera(tc)) {
					response.sendRedirect("production/tbl_Carreras.jsp?msj=3");
				}
				else {
					response.sendRedirect("production/tbl_Carreras.jsp?msj=4");
				}
			}catch(Exception e) {
				System.out.println("Error Sl_Carrera opc2: "+e.getMessage());
				e.printStackTrace();
			}
			break;
			
		case 3:
			// CONSTRUIMOS EL OBJETO CON LOS VALORES DE LOS CONTROLES
			tc.setId_carrera(Integer.parseInt(request.getParameter("idcarrera")));
			try {
				
				if(dtc.eliminarCarrera(tc)) {
					response.sendRedirect("production/tbl_Carreras.jsp?msj=5");
				}
				else {
					response.sendRedirect("production/tbl_Carreras.jsp?msj=6");
				}
			}catch(Exception e) {
				System.out.println("Error Sl_Carrera opc3: "+e.getMessage());
				e.printStackTrace();
			}
			break;
			
		default:
			//codigo
			break;
			
		}
		
	}
    
    
    
    
    
}