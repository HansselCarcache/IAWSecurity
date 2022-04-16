package servlets;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datos.Dt_carreras;
import datos.Dt_inscripcionDocente;
import entidades.Tbl_carrera_inscripcion;
import entidades.Tbl_inscripcion;
import entidades.Vw_carrera_departamento;


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
	Tbl_inscripcion tins = new Tbl_inscripcion();
	Tbl_carrera_inscripcion tcari = new Tbl_carrera_inscripcion();
	Vw_carrera_departamento cardf = new Vw_carrera_departamento();
	Dt_inscripcionDocente dti = new Dt_inscripcionDocente();
	Dt_carreras dtc = new Dt_carreras();
	
	// CONSTRUIMOS EL OBJETO CON LOS VALORES DE LOS CONTROLES
	
	
	
	////////////////////////////////////////////////////////////////////
	
	switch(opc) {
	case 1:
		// CONSTRUIMOS EL OBJETO CON LOS VALORES DE LOS CONTROLES
		tins.setNombre_completo(request.getParameter("nombre_completo"));
		tins.setTelefono(request.getParameter("telefono_contacto"));
		tins.setCorreo(request.getParameter("correo"));
		tins.setId_usuario(Integer.parseInt(request.getParameter("iduser")));
		tins.setId_oferta_detalle(Integer.parseInt(request.getParameter("idoferd")));
		try {
		// CONSTRUIMOS EL OBJETO CARRERA INSCRIPCION
		cardf = dtc.getCarreraDFbyID(Integer.parseInt(request.getParameter("cbxCarrera")));
		tcari.setId_departamento(cardf.getId_departamento());
		tcari.setId_facultad(cardf.getId_facultad());
		tcari.setEstado(1);
		tcari.setId_carrera(cardf.getId_carrera());
		tcari.setId_inscripcion(dti.guardarInscripcion(tins));
		if(tcari.getId_inscripcion()>0) {
			if(dtc.guardarCarrerainsc(tcari)) {
				response.sendRedirect("production/tbl_capacitacionD.jsp?msj=1");
			}
			else {
				response.sendRedirect("production/tbl_capacitacionD.jsp?msj=2");
			}
		}else {
			response.sendRedirect("production/tbl_capacitacionD.jsp?msj=2");
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