package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datos.Dt_escalaCalificacionDet;
import datos.Dt_escalacalificacion;
import entidades.Tbl_escalaCalificacion;
import entidades.Tbl_escalaCalificacionDet;

/**
 * Servlet implementation class Sl_escalaCalificacionDet
 */
@WebServlet("/Sl_escalaCalificacionDet")
public class Sl_escalaCalificacionDet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Sl_escalaCalificacionDet() {
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
		String frm = "";
		frm = request.getParameter("frm");
		doGet(request, response);
		
	

		int opc = Integer.parseInt(request.getParameter("opcion"));
		// INSTANCIAMOS LOS OBJETOS
		Tbl_escalaCalificacionDet ec = new Tbl_escalaCalificacionDet();
		Dt_escalaCalificacionDet dec = new Dt_escalaCalificacionDet();
		Dt_escalacalificacion dto = new Dt_escalacalificacion();
		
		
		// CONSTRUIMOS EL OBJETO CON LOS VALORES DE LOS CONTROLES
		ec.setId_escala(Integer.parseInt(request.getParameter("id_escala")));
		System.out.print(ec.getId_escala());
		ec.setValor1(request.getParameter("val1"));
		ec.setValor2(request.getParameter("val2"));
		ec.setDescripcion(request.getParameter("desc"));
		

		
		////////////////////////////////////////////////////////////////////
		
		switch(opc) {
		case 1:
			
			ec.setEstado(1);
			try {
				 
					if(dec.addEscalaDet(ec)) {
						int opc2 = 0;
						opc2 = Integer.parseInt(request.getParameter("estado"));
						System.out.println("OPCION ESTADO: " + opc2);
						
						if (opc2 == 1) {
							dto.setEstado(ec.getId_escala());
							//Se agrego un detalle dentro de una oferta existente
							response.sendRedirect("production/updateEscalaCalificacion.jsp?msj=6&m=" + ec.getId_escala());
						}else {
							// Se agrego un detalle en una oferta recien hecha
							response.sendRedirect("production/addEscalaCalificacionDet.jsp?msj=1&m=" + ec.getId_escala());	
						}
						
						
					
				}else {
					response.sendRedirect("production/"+frm+"?msj=2&m="+ec.getId_escala());
				}
			}catch(Exception e) {
				System.out.println("Error Sl_escalaCalificacion: opc1"+e.getMessage());
				e.printStackTrace();
			}
			break;
		case 2:

			ec.setId_det_escalaCalificacion(Integer.parseInt(request.getParameter("IdDet")));
			ec.setId_escala(Integer.parseInt(request.getParameter("id_escala")));
			try {
				if (dec.editEscalaDet(ec)) {
					// Si
					response.sendRedirect("production/updateEscalaCalificacion.jsp?msj=1&m=" + ec.getId_escala());
				} else {
					// No
					response.sendRedirect("production/updateEscalaCalificacion.jsp?msj=2&m=" + ec.getId_escala());
				}

			}catch(Exception e) {
				System.out.println("Error Sl_Escala opc2: "+e.getMessage());
				e.printStackTrace();
			}
			break;	
			case 3:
				
			
				ec.setId_det_escalaCalificacion(Integer.parseInt(request.getParameter("IdDet")));
			ec.setId_escala(Integer.parseInt(request.getParameter("id_escala")));
			try {
				if (dec.deleteEscalaDet(ec)) {
					// Si
					response.sendRedirect("production/tbl_escalaCalificacion.jsp?msj=1");
				} else {
					// No
					response.sendRedirect("production/deleteEscalaCalificacionDet.jsp?msj=1&m=" + ec.getId_escala() +"&d="+ec.getId_det_escalaCalificacion());
				}

			}catch(Exception e) {
				System.out.println("Error Sl_Oferta opc3: "+e.getMessage());
				e.printStackTrace();
			}
			
			break;
	
	
	}

	}

	}


