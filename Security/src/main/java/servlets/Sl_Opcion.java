package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import datos.Dt_opcion;

import entidades.Opcion;

@WebServlet("/Sl_Opcion")
public class Sl_Opcion extends HttpServlet {
	private static final long serialVersionUID = 1L;
public Sl_Opcion() {
super();
}
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	// TODO Auto-generated method stub
//	response.getWriter().append("Served at: ").append(request.getContextPath());
} 
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	int opc = 0;
	opc = Integer.parseInt(request.getParameter("opcion"));
	// INSTANCIAMOS LOS OBJETOS
	Opcion cr = new Opcion();
	Dt_opcion dtc = new Dt_opcion();
	// CONSTRUIMOS EL OBJETO CON LOS VALORES DE LOS CONTROLES
	cr.setNombre_opcion(request.getParameter("nombre"));
	cr.setDescripcion(request.getParameter("descripcion"));
	
	
	////////////////////////////////////////////////////////////////////
	
	switch(opc) {
	case 1:
		try {
			if(dtc.addOpcion(cr)) {
				response.sendRedirect("production/tbl_opcion.jsp?msj=1");
			}else {
				response.sendRedirect("production/tbl_opcion.jsp?msj=2");
			}
		}catch(Exception e) {
			System.out.println("Error Sl_Opcion opc1: "+e.getMessage());
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