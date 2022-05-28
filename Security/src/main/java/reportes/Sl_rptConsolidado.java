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
 * Servlet implementation class Sv_rptConsolidado
 */
@WebServlet("/Sl_rptConsolidado")
public class Sl_rptConsolidado extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Sl_rptConsolidado() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		// en el hashmap van los parametros
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		try {
			String year = "";
			String sexo = "";
			String carrera = "";
			String departamento = "";
			String facultad = "";
			String curso = "";
			String ptcurso = "";
			HashMap<String, Object>hm = new HashMap<>();
			
			carrera = request.getParameter("pcarrera")==null?"0":request.getParameter("pcarrera");
			System.out.println("carrera: "+carrera);
			if(carrera.equals("0"))
			{
				hm.put("pcarrera", null);
			} else {			
				hm.put("pcarrera", carrera);
			}
			
			departamento = request.getParameter("pdepartamento")==null?"0":request.getParameter("pdepartamento");
			System.out.println("departamento: "+departamento);
			if(departamento.equals("0"))
			{
				hm.put("pdepartamento", null);
			} else {
				hm.put("pdepartamento", departamento);
			}
			
			facultad = request.getParameter("pfacultad")==null?"0":request.getParameter("pfacultad");
			System.out.println("facultad: "+facultad);
			if(facultad.equals("0"))
			{
				hm.put("pfacultad", null);
			} else {
				hm.put("pfacultad", facultad);
			}
			
			sexo = request.getParameter("psexo")==null?"0":request.getParameter("psexo");
			System.out.println("sexo: "+sexo);
			if(sexo.equals("0"))
			{
				hm.put("psexo", null);
			} else {
				hm.put("psexo", Integer.parseInt(sexo));
			}
			
			year = request.getParameter("yearr");
			System.out.println("year: "+year);
			if(year.isBlank())
			{
				hm.put("yearr", null);
			} else {
				hm.put("yearr", Integer.parseInt(year));
			}
			
			curso = request.getParameter("pcurso");
			System.out.println("curso: "+curso);
			if(curso.isBlank())
			{
				hm.put("pcurso", null);
			} else {
				hm.put("pcurso", Integer.parseInt(curso));
			}
			
			ptcurso = request.getParameter("ptcurso");
			System.out.println("ptcurso: "+ptcurso);
			if(ptcurso.isBlank())
			{
				hm.put("ptcurso", null);
			} else {
				hm.put("ptcurso", Integer.parseInt(ptcurso));
			}
			
			
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			String id = dtf.format(LocalDateTime.now());
			System.out.println("AAAAAAA : "+id);
			
			poolConexion pc = poolConexion.getInstance(); 
			Connection c = poolConexion.getConnection();

			OutputStream otps = response.getOutputStream();
			ServletContext context = getServletContext();
			String path = context.getRealPath("/");
			System.out.println("Path: "+path);
			String template = "reportes\\rpt_consolidado.jasper";
			Exporter exporter = new JRPdfExporter();
			JasperPrint jasperPrint = JasperFillManager.fillReport(path+template, hm, c);
			response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
			response.setHeader("Content-Disposition", "inline; filename=\"rpt_tipo_calificacion"+id+".xlsx");
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
