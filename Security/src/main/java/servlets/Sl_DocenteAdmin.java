package servlets;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datos.Dt_enviarEmail;
import datos.Dt_roluser;
import datos.Dt_usuario;
import datos.Dt_usuario2;
import datos.Encrypt;
import entidades.Tbl_user;
import entidades.Tbl_user2;
import entidades.Tbl_userRol;
import negocio.Ng_Usuario;


@WebServlet("/Sl_DocenteAdmin")

public class Sl_DocenteAdmin extends HttpServlet{
	
	
	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Sl_DocenteAdmin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// INSTANCIAMOS LOS OBJETOS
	    Tbl_user tus  = new Tbl_user();
	    Tbl_user2 tus2 = new Tbl_user2();
		Dt_usuario dtus = new Dt_usuario();
		Dt_usuario2 dtus2 = new Dt_usuario2();
		Encrypt dtenc = new Encrypt();
		Ng_Usuario ngu = new Ng_Usuario();
		Dt_enviarEmail dtem = new Dt_enviarEmail();
		
		//PARA GUARDAR LA FECHA Y HORA DE CREACION/ EDICION/ ELIMINACION
		Date fechaSistema = new Date();
		
		//GENERAMOS EL CODIGO DE VERIFICACION Y LO ASIGNAMOS AL OBJETO
		tus.setCodVerificacion(dtus.randomAlphaNumeric(10));
		
		///////VARIABLES PARA ENCRIPTAR LA PWD/////////////
		String key = "";
		String pwd = "";
		String pwdEncrypt = "";
		//Variables globales
		String iduca = request.getParameter("txtiduca");
		String correoi = request.getParameter("txtcorreoi");
		
		
		////////////////////////////////////////////////////////////////////
		
		// CONTRUIMOS EL OBJETO CON LOS VALORES DE LOS CONTROLES
		String nombres = request.getParameter("txtnombres");
		String apellidos = request.getParameter("txtapellidos");
		String nombreC = nombres+' '+apellidos;
		tus.setNombre_real(nombreC);
		tus.setNombre_usuario(request.getParameter("txtusername"));
		tus.setSexo(Integer.parseInt(request.getParameter("cbxsexo")));
		tus.setCedula(request.getParameter("txtcedula"));
		tus.setTelefono_contacto(request.getParameter("txttelefono"));
		tus.setCargo(request.getParameter("txtcargo"));
		tus.setCorreo_personal(request.getParameter("txtcorreop"));
		tus.setPwd(request.getParameter("txtpwd").trim());
		tus.setEstado(1);
				
		if(iduca.equals("")) {
			tus.setId_uca(null);
		}else {
			tus.setId_uca(iduca);
		}
		
		if(correoi.equals("")) {
			tus.setCorreo_institucional(null);
		}else {
			tus.setCorreo_institucional(correoi);
		}
		
		tus.setUsuario_creacion(2);//2 valor temporal mientras se programa la sesion
		tus.setFecha_creacion(new java.sql.Timestamp(fechaSistema.getTime()));
				
		//PARA ENCRIPTAR LA PWD//	
		key=dtenc.generarLLave();
		tus2.setToken(key);
		pwd = tus.getPwd();
		pwdEncrypt = dtenc.getAES(pwd, key);
		tus.setPwd(pwdEncrypt);
		///////////////////////////
				
		try {
			if(ngu.existeIdUCA(tus.getId_uca())) {
				response.sendRedirect("production/NuevoDocente.jsp?msj=1");
			}else if(ngu.existeCedula(tus.getCedula())) {
				response.sendRedirect("production/NuevoDocente.jsp?msj=2");
			}else
			tus2.setId_user(dtus.guardarUser(tus));
			if(tus2.getId_user()>0) {
				Tbl_userRol tur = new Tbl_userRol();
				Dt_roluser dtur = new Dt_roluser();
				tur.setId_user(tus2.getId_user());
				tur.setId_rol(2);
				if(dtus2.guardarUser(tus2) && dtur.guardarRoluser(tur)) {
					if(dtem.enviarEmailVerificacion(tus.getNombre_usuario(), tus.getCorreo_personal(), tus.getCodVerificacion())) {
						response.sendRedirect("production/Inicio.jsp");
					}
					
				}
				else {
					response.sendRedirect("production/Inicio.jsp");
				}
			}
			

		}catch(Exception e) {
			System.out.println("Error al crear el nuevo docente: "+e.getMessage());
			e.printStackTrace();
		}
				

	}
}
	