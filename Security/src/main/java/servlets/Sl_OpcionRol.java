package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datos.Dt_Rol;
import datos.Dt_OpcionRol;
import entidades.Rol;
import entidades.OpcionRol;


/**
 * Servlet implementation class Sl_OfertaDet
 */
@WebServlet("/Sl_OpcionRol")
public class Sl_OpcionRol extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Sl_OpcionRol() {
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
		OpcionRol or = new OpcionRol();
		Dt_OpcionRol dor = new Dt_OpcionRol();
				
		// CONSTRUIMOS EL OBJETO CON LOS VALORES DE LOS CONTROLES
		or.setId_opcion(Integer.parseInt(request.getParameter("opcion")));
		or.setId_rol(Integer.parseInt(request.getParameter("rol")));
		////////////////////////////////////////////////////////////////////
		
		switch(opc) {
		case 1:
			try {
				if(dor.addOpcionRol(or)) {
					response.sendRedirect("production/tbl_RolOpciones.jsp?msj=1");
				}else {
					response.sendRedirect("production/tbl_RolOpciones.jsp?msj=2");
				}
			}catch(Exception e) {
				System.out.println("Error Sl_EscalaCalificacion: opc1"+e.getMessage());
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

