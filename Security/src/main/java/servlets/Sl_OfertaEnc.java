package servlets;

import java.io.IOException;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import datos.Dt_oferta;
import entidades.Tbl_oferta;

/**
 * Servlet implementation class Sl_OfertaEnc
 */
@WebServlet("/Sl_OfertaEnc")
public class Sl_OfertaEnc extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Sl_OfertaEnc() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */

	@SuppressWarnings("deprecation")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int opc = 0;
		opc = Integer.parseInt(request.getParameter("opcion"));
		// INSTANCIAMOS LOS OBJETOS
		Tbl_oferta tf = new Tbl_oferta();
		Dt_oferta dtf = new Dt_oferta();
		//CAMPOS DE CONTROL
		Date fechaSistema =new Date();
		boolean x=false;
		
		try {
			String cfinicio = request.getParameter("finicio").toString();
			
			SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
			Date finicio = formato.parse(cfinicio);
			java.sql.Date sqlinicio= new java.sql.Date(finicio.getTime());
			
			
			
			java.util.Date ffinal =  new SimpleDateFormat("yyyy-MM-dd").parse( request.getParameter("ffinal"));
			java.sql.Date sqlfin= new java.sql.Date(ffinal.getTime());
			
			//Validacion de las fechas
			if(sqlinicio.getYear()==sqlfin.getYear()) {
				if(sqlinicio.getTime()<=sqlfin.getTime()) {
					tf.setFecha_inicial(sqlinicio);
					tf.setFecha_final(sqlfin);
					x=true;
				}else {
					//Inicio es mayor que final so bai
					response.sendRedirect("production/addOferta.jsp?msj=4");
				}
			}else {
				//Fechas en distintos a�os so no
				response.sendRedirect("production/addOferta.jsp?msj=3");
			}
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			e1.getMessage();
		}
		
		
		// CONSTRUIMOS EL OBJETO CON LOS VALORES DE LOS CONTROLES
		tf.setNombre(request.getParameter("nombre"));
		int year = tf.getFecha_inicial().getYear()+1900;
		tf.setYear(year+"");
		tf.setDescripcion(request.getParameter("descr"));
		
		int id=0;
		////////////////////////////////////////////////////////////////////
		
		switch(opc) {
		case 1:
			tf.setFecha_creacion(new java.sql.Timestamp(fechaSistema.getTime()));
			tf.setUsuario_creacion(1);
			try {
				if(x) {
					id =dtf.addOferta(tf);
					
					if(id!=0) {
						//Si
						response.sendRedirect("production/addOfertaDet.jsp?msj=1&id="+id);
					}else {
						//No
						response.sendRedirect("production/addOferta.jsp?msj=2");
					}
				}
				
			}catch(Exception e) {
				System.out.println("Error Sl_Oferta opc1: "+e.getMessage());
				e.printStackTrace();
			}
			break;
		case 2:
			tf.setId_oferta(Integer.parseInt(request.getParameter("id")));
			tf.setFecha_modificacion(new java.sql.Timestamp(fechaSistema.getTime()));
			tf.setUsuario_modificacion(1);
			try {
				if(x) {
					//id =dtf.editOferta(tf);
					
					if(dtf.editOferta(tf)) {
						//Si
						response.sendRedirect("production/updateOferta.jsp?msj=1&id="+tf.getId_oferta());
					}else {
						//No
						response.sendRedirect("production/updateOferta.jsp?msj=2&id="+tf.getId_oferta());
					}
				}
				
			}catch(Exception e) {
				System.out.println("Error Sl_Oferta opc1: "+e.getMessage());
				e.printStackTrace();
			}
			break;
		default:
			//codigo
			break;
			
		}
	}
}


