package servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datos.Dt_oferta;
import datos.Dt_ofertadet;
import entidades.Vw_ofertadet;
import negocio.Ng_Oferta_Det;

/**
 * Servlet implementation class Sl_OfertaDet
 */
@WebServlet("/Sl_OfertaDet")
public class Sl_OfertaDet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Sl_OfertaDet() {
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
		
		String frm = "";
		frm = request.getParameter("frm");
		// INSTANCIAMOS LOS OBJETOS
		Vw_ofertadet tod = new Vw_ofertadet();
		Dt_ofertadet dtf = new Dt_ofertadet();
		Dt_oferta dto = new Dt_oferta();
		Ng_Oferta_Det ngod = new Ng_Oferta_Det();
		
		
		tod.setId_oferta(Integer.parseInt(request.getParameter("id_oferta")));
		tod.setId_oferta_detalle(Integer.parseInt(request.getParameter("id_oferta_det")));
		int x = 0;
		//boolean x = false;
		try {
			String cfinicio = request.getParameter("finiciod").toString();
			SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
			
			
			Date finicio = formato.parse(cfinicio);
			java.sql.Date sqlinicio= new java.sql.Date(finicio.getTime());
			
			java.util.Date ffinal =  formato.parse( request.getParameter("ffinald"));
			java.sql.Date sqlfin= new java.sql.Date(ffinal.getTime());
			
			//id_oferta_det
			
			Date ffinale = formato.parse(request.getParameter("ffinal"));
			java.sql.Date sqlfine= new java.sql.Date(ffinale.getTime());
			
			Date finicioe =  formato.parse(request.getParameter("finicio"));
			java.sql.Date sqlfinicioe= new java.sql.Date(finicioe.getTime());
			
			x= ngod.verifyDates(sqlinicio, sqlfin, sqlfinicioe, sqlfine);
			
			if(x==1) {
				tod.setFecha_inicio(sqlinicio);
				tod.setFecha_final(sqlfin);
				
				//Salto de linea
				
				String horario = "";
				String temp = request.getParameter("horario");
				horario = temp.replace("\n" , "</br>");

				
				// CONSTRUIMOS EL OBJETO CON LOS VALORES DE LOS CONTROLES
				
				tod.setDescripcion_horaria(horario);
				tod.setDias(request.getParameter("dias"));
				
				
				
				System.out.print(tod.getDescripcion_horaria());
				////////////////////////////////////////////////////////////////////
				
				switch(opc) {
				//ingresar detalles de un encabezado recien creado
				case 1:
					try {
						tod.setPublico(Integer.parseInt(request.getParameter("publico")));
						tod.setId_capacitacion(Integer.parseInt(request.getParameter("capacitacion")));
						tod.setId_facilitador(Integer.parseInt(request.getParameter("facilitador")));
						tod.setId_modalidad(Integer.parseInt(request.getParameter("modalidad")));
						
						if (dtf.addOferta(tod)) {
							// Si
							// Habilitar cambiar estado a modif si es el ingreso nuevo de un maestro ya
							// existente
							int opc2 = 0;
							opc2 = Integer.parseInt(request.getParameter("estado"));
							System.out.println("OPCION ESTADO: " + opc2);
							// Cambiar estado de oferta master
							if (opc2 == 1) {
								dto.setEstado(tod.getId_oferta(), 1);
								//Se agrego un detalle dentro de una oferta existente
								response.sendRedirect("production/updateOferta.jsp?msj=6&m=" + tod.getId_oferta());
							}else {
								// Se agrego un detalle en una oferta recien hecha
								response.sendRedirect("production/addOfertaDet.jsp?msj=1&m=" + tod.getId_oferta());	
							}
							
						} else {
							// No
							response.sendRedirect("production/addOfertaDet.jsp?msj=2");
						}
						
						
					}catch(Exception e) {
						System.out.println("Error Sl_OfertaDet opc1: "+e.getMessage());
						e.printStackTrace();
					}
					break;
					
				//ingresar detalles de un encabezado a modificar
				case 2:
					try {
						tod.setPublico(Integer.parseInt(request.getParameter("publico")));
						tod.setId_capacitacion(Integer.parseInt(request.getParameter("capacitacion")));
						tod.setId_facilitador(Integer.parseInt(request.getParameter("facilitador")));
						tod.setId_modalidad(Integer.parseInt(request.getParameter("modalidad")));
						
						tod.setId_oferta_detalle(Integer.parseInt(request.getParameter("id_oferta_det")));
						if (dtf.editOfertaDet(tod)) {
							// Redirigir
							dto.setEstado(tod.getId_oferta(), 1);
							response.sendRedirect("production/updateOferta.jsp?msj=7&m=" + tod.getId_oferta());
						} else {
							// No
							response.sendRedirect("production/updateOfertaDet.jsp?msj=8&m=" + tod.getId_oferta()+"&d="+tod.getId_oferta_detalle());
						}				
						
					}catch(Exception e) {
						System.out.println("Error Sl_OfertaDet opc1: "+e.getMessage());
						e.printStackTrace();
					}
					break;
				case 3:
					try {
						tod.setId_oferta_detalle(Integer.parseInt(request.getParameter("id_oferta_det")));
						if (dtf.deleteOfertaDet(tod)) {
							// Redirigir
							dto.setEstado(tod.getId_oferta(), 1);
							response.sendRedirect("production/deleteOferta.jsp?msj=2&m=" + tod.getId_oferta());
						} else {
							// No
							response.sendRedirect("production/deleteOfertaDet.jsp?msj=1&m=" + tod.getId_oferta()+"&d="+tod.getId_oferta_detalle());
						}				
						
					}catch(Exception e) {
						System.out.println("Error Sl_OfertaDet opc1: "+e.getMessage());
						e.printStackTrace();
					}
					break;
				default:
					//codigo
					break;
					
				}
			}
			
			if(x==2) {
				//Inicio mayor que final
				response.sendRedirect("production/"+frm+"?msj=3&m="+tod.getId_oferta()+"&d="+tod.getId_oferta_detalle());
			}
			
			if(x==3) {
				//Fecha final fuera de rango
				response.sendRedirect("production/"+frm+"?msj=4&m="+tod.getId_oferta()+"&d="+tod.getId_oferta_detalle());
			}
			
			if(x==4) {
				//Fecha inicial fuera de rango
				response.sendRedirect("production/"+frm+"?msj=5&m="+tod.getId_oferta()+"&d="+tod.getId_oferta_detalle());
			}
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			e1.getMessage();
		}
	}
}
