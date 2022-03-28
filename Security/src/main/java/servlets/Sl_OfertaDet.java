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
import datos.Dt_ofertadet;
import entidades.Vw_ofertadet;

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
		// INSTANCIAMOS LOS OBJETOS
		Vw_ofertadet tod = new Vw_ofertadet();
		Dt_ofertadet dtf = new Dt_ofertadet();
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
					tod.setFecha_inicio(sqlinicio);
					tod.setFecha_final(sqlfin);
					x=true;
				}
				else 
				{
					//Fecha final fuera de rango
					response.sendRedirect("production/addOfertaDet.jsp?msj=4");
				}
			}
			else
			{
				//Fecha inicio fuera de rango
				response.sendRedirect("production/addOfertaDet.jsp?msj=3");
			}
			
			
			
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			e1.getMessage();
		}
		
		//Salto de linea
		
		String horario = "";
		String temp = request.getParameter("horario");
		horario = temp.replace("\n" , "</br>");

		
		// CONSTRUIMOS EL OBJETO CON LOS VALORES DE LOS CONTROLES
		tod.setId_capacitacion(Integer.parseInt(request.getParameter("capacitacion")));
		tod.setId_facilitador(Integer.parseInt(request.getParameter("facilitador")));
		tod.setId_modalidad(Integer.parseInt(request.getParameter("modalidad")));
		tod.setDescripcion_horaria(horario);
		tod.setDias(request.getParameter("dias"));
		tod.setPublico(Integer.parseInt(request.getParameter("publico")));
		tod.setId_oferta(Integer.parseInt(request.getParameter("id_oferta")));
		
		System.out.print(tod.getDescripcion_horaria());
		////////////////////////////////////////////////////////////////////
		
		switch(opc) {
		//ingresar detalles de un encabezado recien creado
		case 1:
			try {
				if(x) {
					if(dtf.addOferta(tod)) {
						//Si
						response.sendRedirect("production/addOfertaDet.jsp?msj=1");
					}else {
						//No
						response.sendRedirect("production/addOfertaDet.jsp?msj=2");
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
