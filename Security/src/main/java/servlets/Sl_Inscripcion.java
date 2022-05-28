package servlets;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datos.Dt_carreras;
import datos.Dt_carrerasInsc;
import datos.Dt_inscripcionDocente;
import entidades.Tbl_carrera_inscripcion;
import entidades.Tbl_inscripcion;
import entidades.Vw_carrera_departamento;
import negocio.Ng_InscripcionD;


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
	Dt_carrerasInsc dtc = new Dt_carrerasInsc();
	Ng_InscripcionD ngi = new Ng_InscripcionD();
	String valor="";
	
	
	// CONSTRUIMOS EL OBJETO CON LOS VALORES DE LOS CONTROLES
	
	
	
	////////////////////////////////////////////////////////////////////
	
	switch(opc) {
	case 1:
		// CONSTRUIMOS EL OBJETO CON LOS VALORES DE LOS CONTROLES
		int idconvocatoria= Integer.parseInt(request.getParameter("convocatoria"));
		tins.setNombre_completo(request.getParameter("nombre_completo"));
		tins.setTelefono(request.getParameter("telefono_contacto"));
		tins.setCorreo(request.getParameter("correo"));
		tins.setId_usuario(Integer.parseInt(request.getParameter("iduser")));
		tins.setId_oferta_detalle(Integer.parseInt(request.getParameter("idoferd")));
		try {
		// CONSTRUIMOS EL OBJETO CARRERA INSCRIPCION
//		cardf = dtc.getCarreraDFbyID(Integer.parseInt(request.getParameter("cbxCarrera")));
//		tcari.setId_departamento(cardf.getId_departamento());
//		tcari.setId_facultad(cardf.getId_facultad());
//		tcari.setEstado(1);
//		tcari.setId_carrera(cardf.getId_carrera());
		
			
				
			
		if(ngi.existeInscripcion(tins.getId_oferta_detalle(), tins.getId_usuario())) {
			response.sendRedirect("production/tbl_capacitacionD.jsp?msj=3&idC="+idconvocatoria);
		}else {
			
			int id = dti.guardarInscripcion(tins);
			
			if(id !=0) {
				//OBTENER ARRAY DE CARRERAS A INSCRIBIR
				String[] a = request.getParameterValues("carreras");
				Dt_carrerasInsc dac = new Dt_carrerasInsc();
				
				for(String s:a) {
					System.out.print("CARERRAS: " + s);
					//CONVERTIR CADA INDICE A UN OBJETO
					Vw_carrera_departamento car = dac.getCarreraDFbyID(Integer.parseInt(s));
					System.out.print("CARERRAS OBJ: " + car.getNombre_carrera());
				
					dtc.addInscripcionCarrera(car, id);
				
				}
				response.sendRedirect("production/tbl_capacitacionD.jsp?msj=1&idC="+idconvocatoria);
			}else {
				response.sendRedirect("production/tbl_capacitacionD.jsp?msj=2&idC="+idconvocatoria);
			}
			
			
//			if(tcari.getId_inscripcion()>0) {
//				if(dtc.guardarCarrerainsc(tcari)) {
//					response.sendRedirect("production/tbl_capacitacionD.jsp?msj=1");
//				}
//				else {
//					response.sendRedirect("production/tbl_capacitacionD.jsp?msj=2");
//				}
//			}else {
//				response.sendRedirect("production/tbl_capacitacionD.jsp?msj=2");
//			}
		}
		
		
		}catch(Exception e) {
			System.out.println("Error Sl_Inscripcion opc1: "+e.getMessage());
			e.printStackTrace();
		}
		break;
	case 2:
		tins.setId_inscripcion(Integer.parseInt(request.getParameter("id_inscripcion")));
		tins.setId_usuario(Integer.parseInt(request.getParameter("id_usuario")));
		
		if(ngi.cursoEvaluado(tins.getId_inscripcion(), tins.getId_usuario())) {
			response.sendRedirect("production/tbl_inscripcionD.jsp?msj=5");
		}else {
			
			dtc.eliminarCarreraInsc(tins.getId_inscripcion());
			if(dti.eliminarInsc(tins.getId_inscripcion())) {
				response.sendRedirect("production/tbl_inscripcionD.jsp?msj=3");
			}else {
				response.sendRedirect("production/tbl_inscripcionD.jsp?msj=4");
			}
		}
		
		break;
	case 3:
		int id = Integer.parseInt(request.getParameter("cbxConvo"));
		response.sendRedirect("production/tbl_capacitacionD.jsp?idC="+id);
		break;
	default:
		//codigo
		break;
		
	}
}

}