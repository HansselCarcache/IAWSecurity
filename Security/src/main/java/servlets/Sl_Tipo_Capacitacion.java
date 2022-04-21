package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datos.Dt_tipo_capacitacion;
import entidades.Tbl_tipo_capacitacion;


@WebServlet("/Sl_Tipo_Capacitacion")

public class Sl_Tipo_Capacitacion extends HttpServlet{
	
	
	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Sl_Tipo_Capacitacion() {
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
		Tbl_tipo_capacitacion TipCap = new Tbl_tipo_capacitacion();
		Dt_tipo_capacitacion dttc = new Dt_tipo_capacitacion();
		 
		// CONSTRUIMOS EL OBJETO CON LOS VALORES DE LOS CONTROLES
		TipCap.setTipo_capacitacion(request.getParameter("tipo_capacitacion"));
		 
		TipCap.setDescripcion(request.getParameter("descripcion"));
		TipCap.setEstado(1);
		
		
		////////////////////////////////////////////////////////////////////
		
		switch(opc) {
		case 1:
			int certif = Integer.parseInt(request.getParameter("certificada"));
			TipCap.setCertificada(certif);
			try {
				 if(dttc.addTipoCapacitacion(TipCap)) {
						response.sendRedirect("production/tbl_tipo_capacitacion.jsp?msj=1");
				 }else {
						response.sendRedirect("production/tbl_tipo_capacitacion.jsp?msj=2");
				 }
				}catch(Exception e) {
				System.out.println("Error Sl_Tipo_Capacitacion opc1: "+e.getMessage());
				e.printStackTrace();
			}
			break;
		case 2:
			TipCap.setId_tipo_capacitacion(Integer.parseInt(request.getParameter("id_tipo_capacitacion")));
			int certif2 = Integer.parseInt(request.getParameter("certificada"));
			TipCap.setCertificada(certif2);

			try {
				 if(dttc.updateTipoCapacitacion(TipCap)) {
						response.sendRedirect("production/tbl_tipo_capacitacion.jsp?msj=3");
				 }else {
						response.sendRedirect("production/tbl_tipo_capacitacion.jsp?msj=4");
				 }
				}catch(Exception e) {
				System.out.println("Error Sl_Tipo_Capacitacion opc2: "+e.getMessage());
				e.printStackTrace();
			}
			break;
		case 3:
			TipCap.setId_tipo_capacitacion(Integer.parseInt(request.getParameter("id_tipo_capacitacion")));

			try {
				
				 if(dttc.deleteTipoCapacitacion(TipCap)) {
						response.sendRedirect("production/tbl_tipo_capacitacion.jsp?msj=5");
				 }else {
						response.sendRedirect("production/tbl_tipo_capacitacion.jsp?msj=6");
				 }
				}catch(Exception e) {
				System.out.println("Error Sl_Tipo_Capacitacion opc3: "+e.getMessage());
				e.printStackTrace();
			}
			break;
		default:
			//codigo
			break;
			
		}
	}
	

}