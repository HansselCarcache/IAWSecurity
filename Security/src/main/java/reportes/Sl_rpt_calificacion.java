package reportes;

import java.io.IOException;
import java.io.OutputStream;
import java.sql.Connection;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datos.poolConexion;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.export.Exporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;

/**
 * Servlet implementation class Sl_rpt_calificacion
 */
@WebServlet("/Sl_rpt_calificacion")
public class Sl_rpt_calificacion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Sl_rpt_calificacion() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		try {
		String idUs = "";
		idUs = request.getParameter("idI")==null?"0":request.getParameter("idI");
		System.out.println("IdUs: "+idUs);
		
		poolConexion pc = poolConexion.getInstance(); 
		Connection c = poolConexion.getConnection();
		HashMap<String, Object>hm = new HashMap<>();
		hm.put("Id_user", Integer.parseInt(idUs));
		
		OutputStream otps = response.getOutputStream();
		ServletContext context = getServletContext();
		String path = context.getRealPath("/");
		System.out.println("Path: "+path);
		String template = "reportes\\rpt_calificacion.jasper";
		Exporter exporter = new JRPdfExporter();
		JasperPrint jasperPrint = JasperFillManager.fillReport(path+template, hm, c);
		response.setContentType("application/pdf");
		response.setHeader("Content-Disposition", "inline; filename=\"rpt_calificacion_" + idUs +".pdf");
		exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
		exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(otps));
		exporter.exportReport();
		
	}
	catch (Exception e) {
		e.printStackTrace();
		System.out.println("REPORTE: ERROR AL GENERAR REPORTE " + e.getMessage());
	}

	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		


	}

}