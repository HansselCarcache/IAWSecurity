package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import datos.Dt_enviarEmail;
import datos.Dt_usuario;
import datos.Dt_usuario2;
import datos.Encrypt;
import entidades.Tbl_user;
import entidades.Tbl_user2;
import entidades.Vw_userrol;
import negocio.Ng_Usuario;

/**
 * Servlet implementation class Sl_login
 */
@WebServlet("/Sl_login")
public class Sl_login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Sl_login() {
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
		//doGet(request, response);
		Dt_usuario dtu = new Dt_usuario();
		Dt_usuario2 dtu2 = new Dt_usuario2();
		Dt_enviarEmail dte = new Dt_enviarEmail();
		Vw_userrol vwur = new Vw_userrol();
		Ng_Usuario ngu = new Ng_Usuario();
		String usuario = "";
		String usuarioCedula = "";
		String clave = "";
		String codigoV = "";
		String correo = "";
		int rolId = 0;
		int opc = 0;
		
		opc = Integer.parseInt(request.getParameter("opcion"));
		
		boolean accesoAdmin = false;
		boolean accesoDocente = false;
		boolean accesoFacilitador=false;
		
		switch(opc) {
		case 1:
			
			usuario = request.getParameter("usuario");
			clave = request.getParameter("pwd");
			rolId = Integer.parseInt(request.getParameter("rol"));
			codigoV = request.getParameter("codVerificacion");
			try {
				//Validacion de ADMINISTRADOR con usuario o cedula
				if(ngu.accesoAdmin(rolId)) {
					if(dtu.dtverificarLogin(usuario, clave, rolId)) {
						vwur = dtu.dtGetVwUR(usuario, rolId);
						HttpSession hts = request.getSession(true);
						hts.setAttribute("acceso", vwur);
						accesoAdmin = true;
						
					}
					else if(dtu.dtverificarLoginCedula(usuario, clave, rolId)){
						vwur = dtu.dtGetVwURCedula(usuario, rolId);
						HttpSession hts = request.getSession(true);
						hts.setAttribute("acceso", vwur);
						accesoAdmin = true;
					}
				//Validacion de DOCENTE con usuario o cedula	
				}else if(ngu.accesoDocente(rolId)) {
					if(dtu.dtverificarLogin(usuario, clave, rolId)) {
						vwur = dtu.dtGetVwUR(usuario, rolId);
						HttpSession hts = request.getSession(true);
						hts.setAttribute("acceso", vwur);
						accesoDocente = true;
						
					}
					else if(dtu.dtverificarLoginCedula(usuario, clave, rolId)){
						vwur = dtu.dtGetVwURCedula(usuario, rolId);
						HttpSession hts = request.getSession(true);
						hts.setAttribute("acceso", vwur);
						accesoDocente = true;
					}
				//Validacion de FACILITADOR con usuario o cedula	
				}else {
					if(dtu.dtverificarLogin(usuario, clave, rolId)) {
						vwur = dtu.dtGetVwUR(usuario, rolId);
						HttpSession hts = request.getSession(true);
						hts.setAttribute("acceso", vwur);
						accesoFacilitador = true;
						
					}
					else if(dtu.dtverificarLoginCedula(usuario, clave, rolId)){
						vwur = dtu.dtGetVwURCedula(usuario, rolId);
						HttpSession hts = request.getSession(true);
						hts.setAttribute("acceso", vwur);
						accesoFacilitador = true;
					}
				}
				
				////Donde se inicia el sistema
				if(accesoAdmin) {
					response.sendRedirect("production/Inicio.jsp");
				}else if(accesoDocente){
					response.sendRedirect("production/InicioDocente.jsp");
					
				}else if(accesoFacilitador) {
					response.sendRedirect("production/InicioFacilitador.jsp");
				}else {
					response.sendRedirect("Login.jsp?msj=403");
				}
				
			}
			catch(Exception e){
				System.out.println("Servlet: El error es: "+e.getMessage());
				e.printStackTrace();
			}
			break;
		
		case 2:
			
			usuario = request.getParameter("usuario");
			clave = request.getParameter("pwd");
			rolId = Integer.parseInt(request.getParameter("rol"));
			codigoV = request.getParameter("codVerificacion");
			try {
				//Validacion de ADMINISTRADOR con usuario o cedula
				if(ngu.accesoAdmin(rolId)) {
					if(dtu.dtverificarLogin2(usuario,clave, rolId, codigoV)) {
						vwur = dtu.dtGetVwUR(usuario, rolId);
						HttpSession hts = request.getSession(true);
						hts.setAttribute("acceso", vwur);
						accesoAdmin = true;
						
					}
					else if(dtu.dtverificarLogin2Cedula(usuario, clave, rolId, codigoV)){
						vwur = dtu.dtGetVwURCedula(usuario, rolId);
						HttpSession hts = request.getSession(true);
						hts.setAttribute("acceso", vwur);
						accesoAdmin = true;
					}
				//Validacion de DOCENTE con usuario o cedula
				}else if(ngu.accesoDocente(rolId)) {
					if(dtu.dtverificarLogin2(usuario,clave, rolId, codigoV)) {
						vwur = dtu.dtGetVwUR(usuario, rolId);
						HttpSession hts = request.getSession(true);
						hts.setAttribute("acceso", vwur);
						accesoDocente = true;
						
					}
					else if(dtu.dtverificarLogin2Cedula(usuario, clave, rolId, codigoV)) {
						vwur = dtu.dtGetVwURCedula(usuario, rolId);
						HttpSession hts = request.getSession(true);
						hts.setAttribute("acceso", vwur);
						accesoDocente = true;
					}
				//Validacion de FACILITADOR con usuario o cedula
				}else {
					if(dtu.dtverificarLogin2(usuario,clave, rolId, codigoV)) {
						vwur = dtu.dtGetVwUR(usuario, rolId);
						HttpSession hts = request.getSession(true);
						hts.setAttribute("acceso", vwur);
						accesoFacilitador = true;
						
					}
					else if(dtu.dtverificarLogin2Cedula(usuario, clave, rolId, codigoV)){
						vwur = dtu.dtGetVwURCedula(usuario, rolId);
						HttpSession hts = request.getSession(true);
						hts.setAttribute("acceso", vwur);
						accesoFacilitador = true;
					}
				}
				
				////Donde se inicia el sistema
				if(accesoAdmin) {
					response.sendRedirect("production/Inicio.jsp");
				}else if(accesoDocente){
					response.sendRedirect("production/InicioDocente.jsp");
					
				}else if(accesoFacilitador) {
					response.sendRedirect("production/InicioFacilitador.jsp");
				}else {
					
				}
				
				
			}
			catch(Exception e){
				System.out.println("Servlet: El error es: "+e.getMessage());
				e.printStackTrace();
			}
			break;
			////CORREO PARA REESTABLECER CONTRASEÑA
		case 3:
			
			usuario = request.getParameter("usuario2");
			correo = request.getParameter("correo");
			try {
				if(dtu.dtUsuarioCorreo(usuario, correo)) {
					if(dte.enviarEmailContraseña(usuario, correo)) {
						response.sendRedirect("Login.jsp?msj=1");
					}else {
						response.sendRedirect("Login.jsp?msj=3");
					}
					
					
				}
				//SI NO SE ENCONTRO EL USER SE PRUEBA RECUPERAR EL USUARIO A PARTIR DE LA CEDULA
				usuarioCedula=dtu.cedulaUsuario(usuario);
				
				if(dtu.dtUsuarioCorreo(usuarioCedula, correo)) {
					if(dte.enviarEmailContraseña(usuarioCedula, correo)) {
						response.sendRedirect("Login.jsp?msj=1");
					}else {
						response.sendRedirect("Login.jsp?msj=3");
					}
				}else {
					
					response.sendRedirect("Login.jsp?msj=2");
				}
			}
			catch(Exception e){
				System.out.println("Servlet: El error es: "+e.getMessage());
				e.printStackTrace();
			}
			break;
		case 4:
			//CAMBIO DE CONTRASEÑA 
			correo = request.getParameter("correo");
			Encrypt dtenc = new Encrypt();
			Tbl_user tus  = new Tbl_user();
			Tbl_user2 tus2 = new Tbl_user2();
			///////VARIABLES PARA ENCRIPTAR LA PWD/////////////
			String key = "";
			String pwd = "";
			String pwdEncrypt = "";
			////////////////////////////////////////////////////////////////////
			tus.setNombre_usuario(request.getParameter("usuario2"));
			tus.setPwd(request.getParameter("txtpwd").trim());
			
			//PARA ENCRIPTAR LA PWD//	
			key=dtenc.generarLLave();
			tus2.setToken(key);
			pwd = tus.getPwd();
			pwdEncrypt = dtenc.getAES(pwd, key);
			tus.setPwd(pwdEncrypt);
			///////////////////////////
			
			try {
				if(dtu.dtUsuarioCorreo(tus.getNombre_usuario(), correo)) {
				tus2.setId_user(dtu.dtUsuarioCorreo2(tus.getNombre_usuario(), correo));	
					if(tus2.getId_user()>0) {
						if(dtu2.modificarT(tus2)) {
							if(dtu.modificarPwd(tus)) {
								response.sendRedirect("Login.jsp?msj=4");
							}else {
								response.sendRedirect("Login.jsp?msj=5");
							}
						}else {
							response.sendRedirect("Login.jsp?msj=5");
						}
					}
				}else {
					response.sendRedirect("Login.jsp?msj=2");
				}
				
			}
			catch(Exception e){
				System.out.println("Servlet: El error es: "+e.getMessage());
				e.printStackTrace();
			}
			break;
		default:
			break;
		}
	}

}
