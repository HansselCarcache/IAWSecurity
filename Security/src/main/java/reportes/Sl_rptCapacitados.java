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
 * Servlet implementation class Sl_rptCapacitados
 */
@WebServlet("/Sl_rptCapacitados")
public class Sl_rptCapacitados extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Sl_rptCapacitados() {
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
		
		
		//HashMap<String, Object>hm = new HashMap<>();
				HashMap<String, Object>hm = new HashMap<>();
try {
			
			String Convocatoria = "";
			Convocatoria = request.getParameter("pconv")==null?"0":request.getParameter("pconv");
			if(Convocatoria.equals("0"))
			{
				hm.put("pconv", null);
			}
			else
			{
				hm.put("pconv", Integer.parseInt(Convocatoria));
			}
			
			
			String Sexo = "";
			Sexo = request.getParameter("psexo")==null?"0":request.getParameter("psexo");
			if(Sexo.equals("0"))
			{
				hm.put("psexo", null);
			}
			else
			{
				hm.put("psexo", Integer.parseInt(Sexo));
			}
			
			
			String Anio = "";
			Anio = request.getParameter("yearr");
			System.out.print("AAAAAAAAAAAAAA: "+ Anio);
			if(Anio.isBlank())
			{
				hm.put("yearr", null);
			}
			else
			{
				hm.put("yearr", Integer.parseInt(Anio));
			}

			
			String Facultad = "";
			Facultad = request.getParameter("pfacultad")==null?"0":request.getParameter("pfacultad");
			if(Facultad.equals("0"))
			{
				hm.put("pfacultad", null);
			}
			else
			{
				hm.put("pfacultad",Facultad);
			}

			
			String Departamento = "";
			Departamento = request.getParameter("pdepartamento")==null?"0":request.getParameter("pdepartamento");
			if(Departamento.equals("0"))
			{
				hm.put("pdepartamento", null);
			}
			else
			{
				hm.put("pdepartamento", Departamento);
			}

			
			String Carrera = "";
			Carrera = request.getParameter("pcarrera")==null?"0":request.getParameter("pcarrera");
			if(Carrera.equals("0"))
			{
				hm.put("pcarrera", null);
			}
			else
			{
				hm.put("pcarrera", Carrera);
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
			String template = "reportes\\rpt_capacitados.jasper";
			Exporter exporter = new JRPdfExporter();
			JasperPrint jasperPrint = JasperFillManager.fillReport(path+template, hm, c);
			response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
			response.setHeader("Content-Disposition", "inline; filename=\"rpt_capacitados"+id+".xlsx");
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
