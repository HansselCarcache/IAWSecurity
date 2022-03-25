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
import datos.Dt_Oferta;
import entidades.Oferta;

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
		Oferta tf = new Oferta();
		Dt_Oferta dtf = new Dt_Oferta();
		
		try {
			String cfinicio = request.getParameter("finicio").toString();
			
			SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
			Date finicio = formato.parse(cfinicio);
			java.sql.Date sqlinicio= new java.sql.Date(finicio.getTime());
			
			
			
			java.util.Date ffinal =  new SimpleDateFormat("yyyy-MM-dd").parse( request.getParameter("ffinal"));
			java.sql.Date sqlfin= new java.sql.Date(ffinal.getTime());
			tf.setFecha_inicial(sqlinicio);
			tf.setFecha_final(sqlfin);
			
			
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			e1.getMessage();
		}
		// CONSTRUIMOS EL OBJETO CON LOS VALORES DE LOS CONTROLES
		tf.setNombre(request.getParameter("nombre"));
		tf.setPeriodo(request.getParameter("periodo"));
		tf.setDescripcion(request.getParameter("descr"));
		
		
		////////////////////////////////////////////////////////////////////
		
		switch(opc) {
		case 1:
			try {
				if(tf.getFecha_inicial().getYear()==tf.getFecha_final().getYear()) {
					if(dtf.addOferta(tf)) {
						//Si
						response.sendRedirect("production/frm_addNewOfertaDet.jsp?msj=1");
					}else {
						//No
						response.sendRedirect("production/frm_addOfertaEnc.jsp?msj=2");
					}
				}else {
					//Fechas en distintos años so no
					response.sendRedirect("production/frm_addOfertaEnc.jsp?msj=3");
				}
				
			}catch(Exception e) {
				System.out.println("Error Sl_Oferta opc1: "+e.getMessage());
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


