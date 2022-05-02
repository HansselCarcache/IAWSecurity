package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datos.Dt_Opciones;
import entidades.Tbl_opcion;

/**
 * Servlet implementation class Sl_Opciones
 */
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
	Tbl_opcion top = new Tbl_opcion();
	Dt_Opciones dto = new Dt_Opciones();
	
	
	
	
	switch(opc) {
	case 1:
		// CONSTRUIMOS EL OBJETO CON LOS VALORES DE LOS CONTROLES
		top.setNombre_opcion(request.getParameter("txtnombreopcion"));
		top.setDescripcion(request.getParameter("txtdescripcion"));
		top.setEstado(1);
		////////////////////////////////////////////////////////////////////
		try {
			if(dto.guardarOpcion(top)) {
				response.sendRedirect("production/Tbl_opciones.jsp?msj=1");
			}else {
				response.sendRedirect("production/Tbl_opciones.jsp?msj=2");
			}
		}catch(Exception e) {
			System.out.println("Error Sl_Opcion opc1: "+e.getMessage());
			e.printStackTrace();
		}
		break;
	case 2:
		top.setId_opcion(Integer.parseInt(request.getParameter("txtidopcion")));
		top.setNombre_opcion(request.getParameter("txtnombreopcion"));
		top.setDescripcion(request.getParameter("txtdescripcion"));
		
		try {
		if(dto.modificarOpcion(top)) {
			response.sendRedirect("production/Tbl_opciones.jsp?msj=3");
		}else {
			response.sendRedirect("production/Tbl_opciones.jsp?msj=4");
		}
	}catch(Exception e) {
			System.out.println("Error Sl_Opcion opc2: "+e.getMessage());
			e.printStackTrace();
		}
		break;
	case 3:
		top.setId_opcion(Integer.parseInt(request.getParameter("txtidopcion")));
		try {
		if(dto.eliminarOpcion(top)) {
			response.sendRedirect("production/Tbl_opciones.jsp?msj=5");
		}else {
			
			response.sendRedirect("production/Tbl_opciones.jsp?msj=6");
		}
		}catch(Exception e) {
			System.out.println("Error Sl_Opcion opc3: "+e.getMessage());
			e.printStackTrace();
		}
		break;
	default:
		//codigo
		break;
		
	}
}

}