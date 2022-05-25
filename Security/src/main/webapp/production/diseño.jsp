<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    import="entidades.Vw_userrol, entidades.Vw_rolopcion, datos.Dt_rolopciones, java.util.*" pageEncoding="ISO-8859-1"%>
    <%
	//INVALIDA LA CACHE DEL NAVEGADOR //
	response.setHeader( "Pragma", "no-cache" );
	response.setHeader( "Cache-Control", "no-store" );
	response.setDateHeader( "Expires", 0 );
	response.setDateHeader( "Expires", -1 );
	
	//DECLARACIONES
	Vw_userrol vwur = new Vw_userrol();
	Dt_rolopciones dtro = new Dt_rolopciones();
	ArrayList<Vw_rolopcion> listOpc = new ArrayList<Vw_rolopcion>();
	boolean permiso = false; //VARIABLE DE CONTROL
	
	//OBTENEMOS LA SESION
	vwur = (Vw_userrol) session.getAttribute("acceso");
	if(vwur!=null){
		//OBTENEMOS LA LISTA DE OPCIONES ASIGNADAS AL ROL
		listOpc = dtro.listaRolOpc(vwur.getId_rol());
		
		//RECUPERAMOS LA URL = MI OPCION ACTUAL
		int index = request.getRequestURL().lastIndexOf("/");
		String miPagina = request.getRequestURL().substring(index+1);
		
		//VALIDAR SI EL ROL CONTIENE LA OPCION ACTUAL DENTRO DE LA MATRIZ DE OPCIONES
		for(Vw_rolopcion vrop : listOpc){
			if(vrop.getnombre_opcion().trim().equals(miPagina.trim())){
				permiso = true; //ACCESO CONCEDIDO
				break;
			}
		}
	}
	else{
		response.sendRedirect("../Login.jsp?msj=401");
		return;
	}
		
	if(!permiso){
		// response.sendRedirect("../login.jsp?msj=401");
		response.sendRedirect("page_403.jsp");
		return;
	}
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
 <body class="nav-md">
   <!-- menu profile quick info -->
            <div class="profile clearfix">
              <div class="profile_pic">
                <img src="images/UCAlogo.png" alt="..." class="img-circle profile_img">
              </div>
              <div class="profile_info">
                <span>Bienvenido,</span>
                <h2><%=vwur.getUsuario() %></h2>
              </div>
            </div>
            <!-- /menu profile quick info -->

            <br />

            <!-- sidebar menu -->
            <div id="sidebar-menu" class="main_menu_side hidden-print main_menu">
              <div class="menu_section">
                <h3>General</h3>
                <ul class="nav side-menu">
                  <li><a><i class="fa-solid fa-lock"></i> Seguridad <span class="fa fa-chevron-down"></span></a>
                    <ul class="nav child_menu">
                      <li><a href="Tbl_opciones.jsp">Opciones</a></li>
                      <li><a href="tbl_rolopciones.jsp">Rol Opciones</a></li>
                      <li><a href="tbl_Rol.jsp">Roles</a></li>
                      <li><a href="tbl_rolusuario.jsp">Roles de Usuario</a></li>
                      <li><a href="tbl_Usuario.jsp">Usuarios</a></li>
                    </ul>
                  </li>
                  <li><a><i class="fa-solid fa-landmark"></i> Universidad <span class="fa fa-chevron-down"></span></a>
                    <ul class="nav child_menu">
                      <li><a href="tbl_facultad.jsp">Facultades</a></li>
                      <li><a href="tbl_departamento.jsp">Departamentos</a></li>
                      <li><a href="tbl_Carreras.jsp">Carreras</a></li>
                      <li><a href="NuevoDocente.jsp">Registrar nuevo docente</a></li>
                    </ul>
                  </li>
                  <li><a><i class="fa-solid fa-graduation-cap"></i> Oferta <span class="fa fa-chevron-down"></span></a>
                    <ul class="nav child_menu">
                      <li><a href="tbl_oferta.jsp">Oferta</a></li>
                      <li><a href="tbl_capacitacion.jsp">Capacitaciones</a></li>
                      <li><a href="tbl_tipo_capacitacion.jsp">Tipo de Capacitación</a></li>
                      <li><a href="tbl_modalidad.jsp">Modalidades</a></li>
                      <li><a href="tbl_facilitadores.jsp">Facilitadores</a></li>
                      
                    </ul>
                  </li>
                  
                  <li><a><i class="fa-solid fa-school"></i> Inscripciones <span class="fa fa-chevron-down"></span></a>
                    <ul class="nav child_menu">
                      <li><a href="tbl_inscripcion.jsp">Inscripciones</a></li>
                      <li><a href="tbl_escalaCalificacion.jsp">Escala de evaluación</a></li>
                    </ul>
                  </li>
                  
                  <li><a><i class="fa-solid fa-file-text-o"></i> Reportes <span class="fa fa-chevron-down"></span></a>
                    <ul class="nav child_menu">
                      <li><a href="reportCertificado.jsp">Reporte Certificados</a></li>
                      <li><a href="reportConsolidado.jsp">Reprote Consolidados</a></li>
                      <li><a href="reportCapacitados.jsp">Reprote Capacitados</a></li>
                      <li><a href="reportTipoCalificacion.jsp">Reprote por Evaluación</a></li>
                      
                    </ul>
                  </li>
<!--                     <li><a><i class="fa-solid fa-school"></i> Calificaciones <span class="fa fa-chevron-down"></span></a> -->
<!--                     <ul class="nav child_menu"> -->
<!--                       <li><a href="evaluacion.jsp">Evaluacion</a></li> -->
<!--                     </ul> -->
<!--                   </li> -->
                  
                </ul>
              </div>

            </div>
            <!-- /sidebar menu -->

            <!-- /menu footer buttons -->
            <div class="sidebar-footer hidden-small">
              <a data-toggle="tooltip" data-placement="top" title="Settings">
                <span class="glyphicon glyphicon-cog" aria-hidden="true"></span>
              </a>
              <a data-toggle="tooltip" data-placement="top" title="FullScreen">
                <span class="glyphicon glyphicon-fullscreen" aria-hidden="true"></span>
              </a>
              <a data-toggle="tooltip" data-placement="top" title="Lock">
                <span class="glyphicon glyphicon-eye-close" aria-hidden="true"></span>
              </a>
              <a data-toggle="tooltip" data-placement="top" title="Logout" href="../Login.jsp">
                <span class="glyphicon glyphicon-off" aria-hidden="true"></span>
              </a>
            </div>
            <!-- /menu footer buttons -->
          </div>
        </div>

        <!-- top navigation -->
        <div class="top_nav">
            <div class="nav_menu">
                <div class="nav toggle">
                  <a id="menu_toggle"><i class="fa fa-bars"></i></a>
                </div>
                <nav class="nav navbar-nav">
                <ul class=" navbar-right">
                  <li class="nav-item dropdown open" style="padding-left: 15px;">
                    <a href="javascript:;" class="user-profile dropdown-toggle" aria-haspopup="true" id="navbarDropdown" data-toggle="dropdown" aria-expanded="false">
                      <img src="../<%=vwur.getUrlFoto()==null?"production/images/no-user.jpg":vwur.getUrlFoto()%>" alt=""><%=vwur.getUsuario() %>
                    </a>
                    <div class="dropdown-menu dropdown-usermenu pull-right" aria-labelledby="navbarDropdown">
                      <a class="dropdown-item"  href="profile.jsp?idU=<%=vwur.getId_usuario()%>">Perfil</a>
<!--                         <a class="dropdown-item"  href="javascript:;"> -->
<!--                           <span class="badge bg-red pull-right">50%</span> -->
<!--                           <span>Configuración</span> -->
<!--                         </a> -->
<!--                     <a class="dropdown-item"  href="javascript:;">Ayuda</a> -->
                      <a class="dropdown-item"  href="../Login.jsp"><i class="fa fa-sign-out pull-right"></i>Cerrar sesión</a>
                    </div>
                  </li>
  
                  
                </ul>
              </nav>
            </div>
          </div>
        <!-- /top navigation -->

</body>
</html>