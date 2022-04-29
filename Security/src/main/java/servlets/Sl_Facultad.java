package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datos.Dt_facultad;
import entidades.Tbl_facultad;

/**
 * Servlet implementation class Sl_Facultad
 */
@WebServlet("/Sl_Facultad")
public class Sl_Facultad extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Sl_Facultad() {
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
		Tbl_facultad tfacu = new Tbl_facultad();
		Dt_facultad dtfacu = new Dt_facultad();
		
		
		
		////////////////////////////////////////////////////////////////////
		
		switch(opc) {
		case 1:
			// CONSTRUIMOS EL OBJETO CON LOS VALORES DE LOS CONTROLES
			tfacu.setNombre_facultad(request.getParameter("txtnombrefacultad"));
			tfacu.setEstado(1);
		////////////////////////////////////////////////////////////////////
			
			try {
				if(dtfacu.addFacultad(tfacu)) {
					response.sendRedirect("production/tbl_facultad.jsp?msj=1");
				}else {
					response.sendRedirect("production/tbl_facultad.jsp?msj=2");
				}
			}catch(Exception e) {
				System.out.println("Error Sl_facultad opc1: "+e.getMessage());
				e.printStackTrace();
			}
			break;
		case 2:
			tfacu.setId_facultad(Integer.parseInt(request.getParameter("idFacultad")));
			tfacu.setNombre_facultad(request.getParameter("txtnombrefacultad"));
			
			try {
			if(dtfacu.modificarFacultad(tfacu)) {
				response.sendRedirect("production/tbl_facultad.jsp?msj=3");
			}else {
				response.sendRedirect("production/tbl_facultad.jsp?msj=4");
			}
		}catch(Exception e) {
				System.out.println("Error Sl_Facultad opc2: "+e.getMessage());
				e.printStackTrace();
			}
			
			break;
		case 3:
			tfacu.setId_facultad(Integer.parseInt(request.getParameter("idFacultad")));
			try {
			if(dtfacu.eliminarFacultad(tfacu)) {
				response.sendRedirect("production/tbl_facultad.jsp?msj=5");
			}else {
				
				response.sendRedirect("production/tbl_facultad.jsp?msj=6");
			}
			}catch(Exception e) {
				System.out.println("Error Sl_Facultad opc2: "+e.getMessage());
				e.printStackTrace();
			}
			break;
		default:
			//codigo
			break;
			
		}
	}

}
