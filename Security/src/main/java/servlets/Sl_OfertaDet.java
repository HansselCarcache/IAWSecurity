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

import datos.Dt_Oferta;
import datos.Dt_Oferta_Det;
import entidades.Oferta;
import entidades.Oferta_Detalle;

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
	
	
	@SuppressWarnings("deprecation")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int opc = 0;
		opc = Integer.parseInt(request.getParameter("opcion"));
		// INSTANCIAMOS LOS OBJETOS
		Oferta_Detalle tod = new Oferta_Detalle();
		Dt_Oferta_Det dtf = new Dt_Oferta_Det();
		boolean x = false;
		try {
			String cfinicio = request.getParameter("finiciod").toString();
			
			SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
			Date finicio = formato.parse(cfinicio);
			java.sql.Date sqlinicio= new java.sql.Date(finicio.getTime());
			
			
			
			java.util.Date ffinal =  new SimpleDateFormat("yyyy-MM-dd").parse( request.getParameter("ffinald"));
			java.sql.Date sqlfin= new java.sql.Date(ffinal.getTime());
			
			
			
			Date ffinale =  new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("ffinal"));
			java.sql.Date sqlfine= new java.sql.Date(ffinale.getTime());
			
			Date finicioe =  new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("finicio"));
			java.sql.Date sqlfinicioe= new java.sql.Date(finicioe.getTime());
			
			if( sqlfinicioe.getTime() <= sqlinicio.getTime() && sqlfine.getTime() >= sqlinicio.getTime()) {
				//Fecha inicio esta en rango
				
				if(sqlfinicioe.getTime() <= sqlfin.getTime() && sqlfine.getTime() >= sqlfin.getTime() && sqlinicio.getTime() <= sqlfin.getTime()) {
					//Fecha en rango y mayor que inicio
					tod.setFecha_inicial(sqlinicio);
					tod.setFecha_final(sqlfin);
					x=true;
				}
				else 
				{
					//Fecha final fuera de rango
					response.sendRedirect("production/frm_addNewOfertaDet.jsp?msj=4");
				}
			}
			else
			{
				//Fecha inicio fuera de rango
				response.sendRedirect("production/frm_addNewOfertaDet.jsp?msj=3");
			}
			
			
			
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			e1.getMessage();
		}
		
		// CONSTRUIMOS EL OBJETO CON LOS VALORES DE LOS CONTROLES
		tod.setId_capacitacion(Integer.parseInt(request.getParameter("capacitacion")));
		tod.setId_facilitador(Integer.parseInt(request.getParameter("facilitador")));
		tod.setHora_inicio(request.getParameter("hinicial"));
		tod.setHora_final(request.getParameter("hfinal"));
		
		tod.setDias(request.getParameter("dias"));
		tod.setPublico(Integer.parseInt(request.getParameter("publico")));
		tod.setId_oferta(Integer.parseInt(request.getParameter("id_oferta")));
		
		
		////////////////////////////////////////////////////////////////////
		
		switch(opc) {
		//ingresar detalles de un encabezado recien creado
		case 1:
			try {
				if(x) {
					if(dtf.addOferta(tod)) {
						//Si
						response.sendRedirect("production/frm_addNewOfertaDet.jsp?msj=1");
					}else {
						//No
						response.sendRedirect("production/frm_addNewOfertaDet.jsp?msj=2");
					}
				}
				
				
			}catch(Exception e) {
				System.out.println("Error Sl_OfertaDet opc1: "+e.getMessage());
				e.printStackTrace();
			}
			break;
			
		//ingresar detalles de un encabezado a modificar
		case 2:
			//codigo
			break;
		default:
			//codigo
			break;
			
		}
	}

}
