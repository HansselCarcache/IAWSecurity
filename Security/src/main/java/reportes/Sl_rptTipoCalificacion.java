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
 * Servlet implementation class Sl_rptTipoCalificacion
 */
@WebServlet("/Sl_rptTipoCalificacion")
public class Sl_rptTipoCalificacion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Sl_rptTipoCalificacion() {
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
		HashMap<String, Object>hm = new HashMap<>();

		try {
			String curso = "";
			String ptcurso = "";
			String Convocatoria = "";
			
			Convocatoria = request.getParameter("pconvTC")==null?"0":request.getParameter("pconvTC");
			if(Convocatoria.equals("0"))
			{
				hm.put("pconv", null);
			}
			else
			{
				hm.put("pconv", Integer.parseInt(Convocatoria));
			}

			String TipoCalificacion = "";
			TipoCalificacion = request.getParameter("pTipoCal")==null?"0":request.getParameter("pTipoCal");
			if(TipoCalificacion.equals("0"))
			{
				hm.put("ptipo_calificacion", null);
			}else {
				hm.put("ptipo_calificacion", Integer.parseInt(TipoCalificacion));
			}
			
			curso = request.getParameter("pcurso");
			System.out.println("curso: "+curso);
			if(curso.equals("0"))
			{
				hm.put("pcurso", null);
			} else {
				hm.put("pcurso", Integer.parseInt(curso));
			}
			
			ptcurso = request.getParameter("ptcurso");
			System.out.println("ptcurso: "+ptcurso);
			if(ptcurso.equals("0"))
			{
				hm.put("ptcurso", null);
			} else {
				hm.put("ptcurso", Integer.parseInt(ptcurso));
			}
			
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		String id = dtf.format(LocalDateTime.now());
		
		System.out.println("AAAAAAA : "+id);
		
		poolConexion pc = poolConexion.getInstance(); 
		Connection c = poolConexion.getConnection();
		
		OutputStream otps = response.getOutputStream();
		ServletContext context = getServletContext();
		String path = context.getRealPath("/");
		System.out.println("Path: "+path);
		String template = "reportes\\rpt_tipo_calificacion.jasper";
		net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter exporter = new net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter();
		JasperPrint jasperPrint = JasperFillManager.fillReport(path+template, hm, c);
		response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
		response.setHeader("Content-Disposition", "inline; filename=\"rpt_tipo_calificacion_"+id+".xlsx");
		exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
		exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(otps));
		exporter.exportReport();
		
	}
	catch (Exception e) {
		e.printStackTrace();
		System.out.println("REPORTE: ERROR AL GENERAR REPORTE " + e.getMessage());
	}
	}

}
