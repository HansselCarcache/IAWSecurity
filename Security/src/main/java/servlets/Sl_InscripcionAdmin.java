package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datos.Dt_carreras;
import datos.Dt_inscripcionAdmin;
import entidades.Vw_carrera_departamento;
import entidades.Vw_inscripcionAdmin;

/**
 * Servlet implementation class Sl_InscripcionAdmin
 */
@WebServlet("/Sl_InscripcionAdmin")
public class Sl_InscripcionAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Sl_InscripcionAdmin() {
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
		// TODO Auto-generated method stub
		int opc = 0;
		opc = Integer.parseInt(request.getParameter("opcion"));
		// INSTANCIAMOS LOS OBJETOS
		Vw_inscripcionAdmin ia = new Vw_inscripcionAdmin();
		Dt_inscripcionAdmin dia = new Dt_inscripcionAdmin();
		// CONSTRUIMOS EL OBJETO CON LOS VALORES DE LOS CONTROLES
		ia.setNombre_completo(request.getParameter("nombre_completo"));
		ia.setTelefono(request.getParameter("telefono"));
		ia.setCorreo(request.getParameter("correo"));
		ia.setOtras_dependencias(request.getParameter("otras_dependencias"));
		ia.setId_usuario(Integer.parseInt(request.getParameter("id_usuarios")));
		ia.setId_oferta_detalle(Integer.parseInt(request.getParameter("oferta")));
		
		
		
		
		
		////////////////////////////////////////////////////////////////////
		
		switch(opc) {
		case 1:
			try {
				int id=dia.addInscripcionAdmin(ia);
				if(id !=0) {
					//OBTENER ARRAY DE CARRERAS A INSCRIBIR
					String[] a = request.getParameterValues("carreras");
					Dt_carreras dac = new Dt_carreras();
					
					for(String s:a) {
						System.out.print("CARERRAS: " + s);
						//CONVERTIR CADA INDICE A UN OBJETO
						Vw_carrera_departamento car = dac.getCarreraDFbyID(Integer.parseInt(s));
						System.out.print("CARERRAS OBJ: " + car.getNombre_carrera());
					
						dia.addInscripcionCarrera(car, id);
					
					}
					
					response.sendRedirect("production/tbl_inscripcion.jsp?msj=1");
				}else {
					response.sendRedirect("production/tbl_inscripcion.jsp?msj=2");
				}
			}catch(Exception e) {
				System.out.println("Error Sl_InscripcionAdmin opc1: "+e.getMessage());
				e.printStackTrace();
			}
			break;
			
		case 2:
			// CONSTRUIMOS EL OBJETO CON LOS VALORES DE LOS CONTROLES
			ia.setId_inscripcion(Integer.parseInt(request.getParameter("id_inscripcion")));
			ia.setId_oferta_detalle(Integer.parseInt(request.getParameter("oferta")));
			
			
			
			try {
				if(dia.updateInscripcionAdmin(ia)) {
					if(dia.deleteCarreraInscripcionById(ia.getId_inscripcion())) {
						String[] b = {};
						String[] a = request.getParameterValues("carreras") == null ? b : request.getParameterValues("carreras");
						
						Dt_carreras dac = new Dt_carreras();
						
						for(String s:a) {
							
							System.out.print("CARERRAS: " + s);
							//CONVERTIR CADA INDICE A UN OBJETO
							Vw_carrera_departamento car = dac.getCarreraDFbyID(Integer.parseInt(s));
							System.out.print("CARERRAS OBJ: " + car.getNombre_carrera());
						
							dia.addInscripcionCarrera(car, ia.getId_inscripcion());
						}
						response.sendRedirect("production/tbl_inscripcion.jsp?msj=3");

					}else {
						response.sendRedirect("production/tbl_inscripcion.jsp?msj=5");
					}
				}
				else {
					response.sendRedirect("production/tbl_inscripcion.jsp?msj=4");
				}
			}catch(Exception e) {
				System.out.println("Error Sl_gestionUser opc2: "+e.getMessage());
				e.printStackTrace();
			}
			break;
			
			
			
		case 3:
			// CONSTRUIMOS EL OBJETO CON LOS VALORES DE LOS CONTROLES
			ia.setId_inscripcion(Integer.parseInt(request.getParameter("id_inscripcion")));
			try {
				
				
				if(dia.deleteInscripcion(ia)) {
					response.sendRedirect("production/tbl_inscripcion.jsp?msj=5");
				}
				else {
					response.sendRedirect("production/tbl_inscripcion.jsp?msj=6");
				}
			}catch(Exception e) {
				System.out.println("Error Sl_inscripcionAdmin opc3: "+e.getMessage());
				e.printStackTrace();
			}
			break;
		default:
			//codigo
			break;
		}
	}

}
//doGet(request, response);
