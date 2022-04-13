package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datos.Dt_evaluacion;
import entidades.Tbl_inscripcion;

/**
 * Servlet implementation class Sl_Evaluacion
 */
@WebServlet("/Sl_Evaluacion")
public class Sl_Evaluacion extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Sl_Evaluacion() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int opc = 0;
		opc = Integer.parseInt(request.getParameter("opcion"));
		int id = Integer.parseInt(request.getParameter("id"));
		
		String valorCual = request.getParameter("valor"+id);
		String valCuan = request.getParameter("calificacion"+id);
		String of = "";
		of = request.getParameter("t_cual"+id) == null ? "0" : request.getParameter("t_cual"+id);
		
		System.out.println(id);
		// INSTANCIAMOS LOS OBJETOS
		Tbl_inscripcion ins = new Tbl_inscripcion();
		Dt_evaluacion dte = new Dt_evaluacion();
		// CONSTRUIMOS EL OBJETO CON LOS VALORES DE LOS CONTROLES
		ins.setId_inscripcion(id);
		ins.setId_escala(Integer.parseInt(request.getParameter("tipo_cal"+id)));
		ins.setId_escala_det(Integer.parseInt(of));
		ins.setDesc_valor(request.getParameter("descripcion"+id));
		if(valCuan.isBlank()) {
			ins.setValor(valorCual);
		}else {
			ins.setValor(valCuan);
		}
		

////////////////////////////////////////////////////////////////////

		switch (opc) {
			case 1:
				try {
	
					if (dte.calificar(ins)) {
						response.sendRedirect("production/evaluacion.jsp?msj=1");
					} else {
						response.sendRedirect("production/evaluacion.jsp?msj=2");
					}
				} catch (Exception e) {
					System.out.println("Error Sl_gestionUserRol opc1: " + e.getMessage());
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
