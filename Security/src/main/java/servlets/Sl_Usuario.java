package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import datos.Dt_usuario;
import entidades.Usuario;

@WebServlet("/Sl_Usuario")

public class Sl_Usuario extends HttpServlet{
	
	
	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Sl_Usuario() {
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
	      Usuario Us = new Usuario();
		Dt_usuario dtus = new Dt_usuario();
		// CONSTRUIMOS EL OBJETO CON LOS VALORES DE LOS CONTROLES
		Us.setId_uca(request.getParameter("idU"));
		Us.setNombre_real(request.getParameter("name"));
		Us.setNombre_usuario(request.getParameter("username"));
		Us.setTelefono_contacto(request.getParameter("telephone"));
		Us.setCorreo_institucional(request.getParameter("insEmail"));
		Us.setCorreo_personal(request.getParameter("persEmail"));
		int sex= Integer.parseInt(request.getParameter("sexo"));
		Us.setSexo(sex);
		Us.setCargo(request.getParameter("cargo"));
		Us.setPwd(request.getParameter("pwd"));
		int fac = Integer.parseInt(request.getParameter("facultad"));
		Us.setId_facultad(fac);
		int dept = Integer.parseInt(request.getParameter("depto"));
		Us.setId_departamento(dept);
		int car = Integer.parseInt(request.getParameter("carrera"));
		Us.setId_carrera(car);
		Us.setEstado(1);
	
		


		
		
		
		////////////////////////////////////////////////////////////////////
		
		switch(opc) {
		case 1:
			try {
				
				if(dtus.addUsuario(Us)) {
					response.sendRedirect("production/tbl_usuario.jsp?msj=1");
				}else {
					response.sendRedirect("production/tbl_usuario.jsp?msj=2");
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
	