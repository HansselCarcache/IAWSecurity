package servlets;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import datos.Dt_usuario;
import datos.Dt_usuario2;
import datos.Encrypt;
import entidades.Tbl_user;
import entidades.Tbl_user2;
import negocio.Ng_Usuario;


@WebServlet("/Sl_Usuario")

public class Sl_Usuario extends HttpServlet{
	
	
	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Sl_Usuario() {
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
		//Obtenemos el valor de la opcion
		int opc = 0;
		opc = Integer.parseInt(request.getParameter("opcion"));
		
		// INSTANCIAMOS LOS OBJETOS
	    Tbl_user tus  = new Tbl_user();
	    Tbl_user2 tus2 = new Tbl_user2();
		Dt_usuario dtus = new Dt_usuario();
		Dt_usuario2 dtus2 = new Dt_usuario2();
		Encrypt dtenc = new Encrypt();
		Ng_Usuario ngu = new Ng_Usuario();
		
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
		
		switch(opc) {
		case 1:
			
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
						response.sendRedirect("production/addUsuario.jsp?msj=1");
					}else if(ngu.existeCedula(tus.getCedula())) {
						response.sendRedirect("production/addUsuario.jsp?msj=2");
					}else
					tus2.setId_user(dtus.guardarUser(tus));
					if(tus2.getId_user()>0) {
						if(dtus2.guardarUser(tus2)) {
							response.sendRedirect("production/tbl_Usuario.jsp?msj=1");
						}
						else {
							response.sendRedirect("production/tbl_Usuario.jsp?msj=2");
						}
					}
					
		
				}catch(Exception e) {
					System.out.println("Error Sl_gestionUser opc1: "+e.getMessage());
					e.printStackTrace();
				}
				
			break;
		case 2:
			//CONTRUIMOS EL OBJETO CON LOS VALORES DE LOS CONTROLES
			tus.setId_usuario(Integer.parseInt(request.getParameter("txtiduser")));
			
			if(iduca.equals("")) {
				tus.setId_uca(null);
			}else {
				tus.setId_uca(iduca);
			}
			
			if(correoi.equals("")) {
				tus.setCorreo_institucional(null);
			}else {
				tus.setCorreo_institucional(request.getParameter("txtcorreoi"));
			}
			tus.setNombre_real(request.getParameter("txtnombreC"));
			tus.setSexo(Integer.parseInt(request.getParameter("cbxsexo")));
			tus.setTelefono_contacto(request.getParameter("txttelefono"));
			tus.setCargo(request.getParameter("txtcargo"));
			try {
				tus.setFecha_edicion(new java.sql.Timestamp(fechaSistema.getTime()));
				tus.setUsuario_edicion(2);//2 valor temporal mientras se programa la sesion
				//Comprobamos que no exista el idUCA en la BD
				if(ngu.existeIdUCA(tus.getId_uca())) {
					
					if(dtus.modificarUserNoID(tus)) {
						response.sendRedirect("production/tbl_Usuario.jsp?msj=7");
					}
					
				}else if(dtus.modificarUser(tus)) {
					response.sendRedirect("production/tbl_Usuario.jsp?msj=3");
				}
				else {
					response.sendRedirect("production/tbl_Usuario.jsp?msj=4");
				}
			}catch(Exception e) {
				System.out.println("Error Sl_gestionUser opc2: "+e.getMessage());
				e.printStackTrace();
			}
			break;
		case 3:
			// CONSTRUIMOS EL OBJETO CON LOS VALORES DE LOS CONTROLES
			tus.setId_usuario(Integer.parseInt(request.getParameter("txtiduser")));
			try {
				tus.setFecha_eliminacion(new java.sql.Timestamp(fechaSistema.getTime()));
				tus.setUsuario_eliminacion(2);//2 valor temporal mientras se programa la sesion
				if(dtus.eliminarUser(tus)) {
					response.sendRedirect("production/tbl_Usuario.jsp?msj=5");
				}
				else {
					response.sendRedirect("production/tbl_Usuario.jsp?msj=6");
				}
			}catch(Exception e) {
				System.out.println("Error Sl_gestionUser opc3: "+e.getMessage());
				e.printStackTrace();
			}
			break;
		case 4:
			//CONTRUIMOS EL OBJETO CON LOS VALORES DE LOS CONTROLES
			tus.setId_usuario(Integer.parseInt(request.getParameter("txtiduser")));
			
			
			
			try {
				tus.setFecha_edicion(new java.sql.Timestamp(fechaSistema.getTime()));
				tus.setUsuario_edicion(2);//2 valor temporal mientras se programa la sesion
				if(dtus.restaurarUsuario(tus)) {
					response.sendRedirect("production/tbl_Usuario.jsp?msj=8");
				}
				else {
					response.sendRedirect("production/tbl_Usuario.jsp?msj=9");
				}
			}catch(Exception e) {
				System.out.println("Error Sl_gestionUser opc2: "+e.getMessage());
				e.printStackTrace();
			}
			break;
		default:
			//codigo
			break;
			
		}

	}
}
	