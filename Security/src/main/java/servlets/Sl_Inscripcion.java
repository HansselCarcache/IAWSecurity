package servlets;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datos.Dt_inscripcion;

import entidades.Inscripcion;


@WebServlet("/Sl_Inscripcion")
public class Sl_Inscripcion extends HttpServlet {
	private static final long serialVersionUID = 1L;
public Sl_Inscripcion (){
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
	Inscripcion cr = new Inscripcion();
	Dt_inscripcion dtc = new Dt_inscripcion();
	// CONSTRUIMOS EL OBJETO CON LOS VALORES DE LOS CONTROLES
	
	
	//Date date = new Date();
	//SimpleDateFormat getYearFormat = new SimpleDateFormat("yyyy");
	//String currentYear = getYearFormat.format(date);
	Date dt=new Date();
	int year=dt.getYear();
int current_Year=year+1900;
	
	cr.setId_departamento(Integer.parseInt(request.getParameter("cbxDepartamento")));
	cr.setId_carrera(Integer.parseInt(request.getParameter("cbxCarrera")));
	cr.setId_facultad(Integer.parseInt(request.getParameter("cbxFacultad")));
	cr.setId_usuario(Integer.parseInt(request.getParameter("cbxUsuario")));
	cr.setId_oferta_detalle(Integer.parseInt(request.getParameter("cbxOfertaDetalle")));
	cr.setAno_inscripcion(String.valueOf(current_Year));
	////////////////////////////////////////////////////////////////////
	
	switch(opc) {
	case 1:
		try {
			if(dtc.addInscripcion(cr)) {
				response.sendRedirect("production/tbl_inscripcion.jsp?msj=1");
			}else {
				response.sendRedirect("production/tbl_inscripcion.jsp?msj=2");
			}
		}catch(Exception e) {
			System.out.println("Error Sl_Inscripcion opc1: "+e.getMessage());
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