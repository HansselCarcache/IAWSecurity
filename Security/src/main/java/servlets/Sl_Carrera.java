package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import datos.Dt_carrera;
import entidades.Carrera;


@WebServlet("/Sl_Carrera")
public class Sl_Carrera extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
public Sl_Carrera() {
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
	Carrera cr = new Carrera();
	Dt_carrera dtc = new Dt_carrera();
	// CONSTRUIMOS EL OBJETO CON LOS VALORES DE LOS CONTROLES
	cr.setNombre_carrera(request.getParameter("nombre"));
	cr.setId_departamento(Integer.parseInt(request.getParameter("cbxDep")));
	
	
	////////////////////////////////////////////////////////////////////
	
	switch(opc) {
	case 1:
		try {
			if(dtc.addCarrera(cr)) {
				response.sendRedirect("production/tbl_carrera.jsp?msj=1");
			}else {
				response.sendRedirect("production/tbl_carrera.jsp?msj=2");
			}
		}catch(Exception e) {
			System.out.println("Error Sl_Carrera opc1: "+e.getMessage());
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