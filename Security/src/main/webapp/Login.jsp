<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="entidades.Tbl_rol, datos.Dt_rol, java.util.*;"%>
    
    <%
	// INVALIDA LA CACHE DEL NAVEGADOR //
	response.setHeader( "Pragma", "no-cache" );
	response.setHeader( "Cache-Control", "no-store" );
	response.setDateHeader( "Expires", 0 );
	response.setDateHeader( "Expires", -1 );
	
	HttpSession hts = request.getSession(false);
	hts.removeAttribute("acceso");
	hts.invalidate();
	
	/* String mensaje = request.getParameter("msj");
 	mensaje=mensaje==null?"":mensaje; */
	
 	int opcion = 0;
	String codigo = request.getParameter("codverif");
	codigo=codigo==null?"":codigo;
	if(codigo.equals("")){
		opcion = 1;
	}
	else{
		opcion = 2;
	}
%>   

<%
String VarMsj = "";

VarMsj = request.getParameter("msj")==null?"0":request.getParameter("msj");


%> 
<!DOCTYPE html>
<html lang="en">
  <head>
  <style>
  .contenedor{
  	height: 713px;
  	display: flex;
  }
  
  .contenedorizq{
  	padding:80px 50px 100px 50px; 
  	background-color: #081c44; 
  	width: 60%;
  }
  
  .contenedorder{
  	background-color: #f8f9fa; 
  	width: 40%;
  }
  
  .imagen{
  	border-radius:5px;
  	border-color: #f8f9fa;
    border-width: 5px;
    border-style: outset;  
  	width:100%;
  	height:100%;
  }
  .titulo{
  	font-size: 20px;
  	text-align: center;
  	color: white;
  }
  </style>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!-- Meta, title, CSS, favicons, etc. -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Acceso de usuarios </title>

    <!-- Bootstrap -->
    <link href="vendors/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome -->
    <link href="vendors/font-awesome/css/font-awesome.min.css" rel="stylesheet">
    <!-- JAlert -->
    <link href="vendors/jAlert/dist/jAlert.css" rel="stylesheet">
    <!-- NProgress -->
    <link href="vendors/nprogress/nprogress.css" rel="stylesheet">
    <!-- Animate.css -->
    <link href="vendors/animate.css/animate.min.css" rel="stylesheet">
    
        <!-- PNotify -->
    <link href="vendors/pnotify/dist/pnotify.css" rel="stylesheet">
    <link href="vendors/pnotify/dist/pnotify.buttons.css" rel="stylesheet">
    <link href="vendors/pnotify/dist/pnotify.nonblock.css" rel="stylesheet">
    <style type="text/css">
		.center{
			right: calc(50% - 150px) !important;
		}
	</style>

    <!-- Custom Theme Style -->
    <link href="build/css/custom.min.css" rel="stylesheet">
  </head>

  <body class="login">
  <div class="contenedor">
  <div class="contenedorizq">
  <p class="titulo">Formaci�n docente</p>
  <img class="imagen" src="production/images/UCA.jpg" alt="..." >
  </div>
   <div class="contenedorder">
   <a class="hiddenanchor" id="signup"></a>
      <a class="hiddenanchor" id="signin"></a>

      <div class="login_wrapper">
        <div class="animate form login_form">
          <section class="login_content">
            <form method="post" action="./Sl_login">
              <h1>Acceso de Usuarios</h1>
              <input type="hidden" name="opcion" id="opcion" value="<%=opcion%>">
              <input type="hidden" name="codVerificacion" value="<%=codigo%>">
              <div>
                <input type="text" name="usuario" id="usuario"  class="form-control" placeholder="C�dula" required="required" />
              </div>
              
              <div>
                <input type="password" name="pwd" id="pwd" class="form-control" placeholder="Contrase�a" required="required" />
              </div>
              <div>
                <select class="form-control" name="rol" id="rol" required="required">
                 <%
                  	ArrayList<Tbl_rol> listRol = new ArrayList<Tbl_rol>();
                  	Dt_rol dtr = new Dt_rol();
                  	listRol = dtr.listaRolActivos();
              	%>
                	<option value="">Seleccione...</option>
                <% 
				  	for(Tbl_rol trol:listRol){
				  %>
				  <option value="<%=trol.getId_rol()%>"><%=trol.getNombre_rol()%></option>
				  <%
				  	}
				  %>
				</select>
              </div>
              <div class="clearfix"></div>
				<div class="separator"></div>
              <div>
              	<input type="submit" class="btn btn-primary" value="Ingresar"/>
              	<input type="reset" class="btn btn-danger" value="Cancelar"/>
              </div>
              <div class="separator">
                <p class="change_link">
                  <a href="#signup" class="to_register"> Recuperar Contrase�a </a>
                </p>

                <div class="clearfix"></div>
                <br />
                
                <div class="separator">
                <p class="change_link">
                  <a href="registrarNuevoDocente.jsp" class="to_register"> Registrarse en la plataforma </a>
                </p>

                <div class="clearfix"></div>
                <br />

                <div>
                  <h1><i class="fa fa-paw"></i> Gentelella Alela!</h1>
                  <p>�2016 All Rights Reserved. Gentelella Alela! is a Bootstrap 3 template. Privacy and Terms</p>
                </div>
              </div>
            </form>
          </section>
        </div>

        <div id="register" class="animate form registration_form">
          <section class="login_content">
            <form method="post" action="./Sl_login">
              <h1>Recuperar Contrase�a</h1>
              <input type="hidden" name="opcion" id="opcion" value="3">
              <div>
                <input type="text" name="usuario2" id="usuario2" class="form-control" placeholder="C�dula" required="required" />
              </div>
              <div>
                <input type="email" id="correo" name="correo"class="form-control" placeholder="Correo Personal" required />
              </div>
              
              <div style="margin-right: 38px; margin-left: -38px;">
                <input class="btn btn-primary btn-lg btn-block" type="submit" value="Enviar">
              </div>

              <div class="clearfix"></div>
              <div class="clearfix"></div>
              <div>
                <a class="btn btn-secondary btn-lg btn-block" type="button" href="#signin">Regresar</a>
              </div>

              <div class="separator">
               

                <div class="clearfix"></div>
                <br />

                <div>
                  <h1><i class="fa fa-paw"></i> Gentelella Alela!</h1>
                  <p>�2016 All Rights Reserved. Gentelella Alela! is a Bootstrap 3 template. Privacy and Terms</p>
                </div>
              </div>
            </form>
          </section>
        </div>
      </div>
   </div>
  </div>
    <div>
      
    </div>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.10/jquery.mask.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.inputmask/3.3.4/jquery.inputmask.bundle.min.js"></script>
     <!-- jQuery -->
    <script src="vendors/jquery/dist/jquery.min.js"></script>
    <!-- Bootstrap -->
   <script src="vendors/bootstrap/dist/js/bootstrap.bundle.min.js"></script>
    <!-- FastClick -->
    <script src="vendors/fastclick/lib/fastclick.js"></script>
    <!-- NProgress -->
    <script src="vendors/nprogress/nprogress.js"></script>
    <!-- iCheck -->
    <script src="vendors/iCheck/icheck.min.js"></script>
    <!-- JAlert js -->
	<script src="vendors/jAlert/dist/jAlert.min.js"></script>
	<script src="vendors/jAlert/dist/jAlert-functions.min.js"></script>
	
	
	<!-- PNotify -->
    <script src="vendors/pnotify/dist/pnotify.js"></script>
    <script src="vendors/pnotify/dist/pnotify.buttons.js"></script>
    <script src="vendors/pnotify/dist/pnotify.nonblock.js"></script>
	
	<script>
	 $(document).ready(function() {
    	 var mensaje = 0;
//     	 $('#usuario').mask('000-000000-0000A', {'translation': {A: {pattern: /[A-Z0-9]/}}}, { casing: "upper"});
    	 
    	 Inputmask("*{3}-*{6}-*{5}", {
    		 
             
             
    		 casing: "upper",
         }).mask('#usuario');
		Inputmask("*{3}-*{6}-*{5}", {
    		 
             
             
    		 casing: "upper",
         }).mask('#usuario2');
    	 
 	    mensaje = "<%=VarMsj %>";
		
	 	   if(mensaje == "1")
		      {
		 		  new PNotify({
		              type: 'success',
		              title: 'Exito',
		              text: 'Se ha enviado un mensaje a su correo para que pueda reestablecer su contrase�a',
		              styling: 'bootstrap3',
		              delay: 2000,
		              addclass: 'center'
		         });
		    	//successAlert('Exito', 'Se ha enviado un mensaje a su correo para que pueda reestablecer su contrase�a');
		      }
	 	  if(mensaje == "2")
		      {
		 		 new PNotify({
		             type: 'error',
		             title: 'Error',
		             text: 'No existe un usuario asociado a ese correo, intentelo de nuevo.',
		             styling: 'bootstrap3',
		             delay: 2000,
		             addclass: 'center'
				});
		    	//errorAlert('Error', 'No existe un usuario asociado a ese correo, intentelo de nuevo.');
		      }
	 	 if(mensaje == "3")
		     {
		 		new PNotify({
		             type: 'error',
		             title: 'Error',
		             text: 'Ha surgido un error a la hora de enviar el correo de reestablecimiento de contrase�a, intente de nuevo',
		             styling: 'bootstrap3',
		             delay: 2000,
		             addclass: 'center'
				});
		   	//errorAlert('Error', 'Ha surgido un error a la hora de enviar el correo de reestablecimiento de contrase�a, intente de nuevo');
		     }
	 	if(mensaje == "4")
	      {
	 		new PNotify({
	             type: 'success',
	             title: 'Exito',
	             text: 'La contrase�a ha sido reestablecida con �xito.',
	             styling: 'bootstrap3',
	             delay: 2000,
	             addclass: 'center'
	        });
	    	//successAlert('Exito', 'La contrase�a ha sido reestablecida con �xito.');
	      }
	 	if(mensaje == "5")
	     {
	 		new PNotify({
	             type: 'error',
	             title: 'Error',
	             text: 'Ha surgido un error a la hora de cambiar la contrase�a, intente de nuevo',
	             styling: 'bootstrap3',
	             delay: 2000,
	             addclass: 'center'
			});
	   	//errorAlert('Error', 'Ha surgido un error a la hora de cambiar la contrase�a, intente de nuevo');
	     }
 	    if(mensaje == "401")
 	      {
 	    	new PNotify({
 	             type: 'error',
 	             title: 'Error',
 	             text: 'Su sesi�n ha caducado, ingrese de nuevo al sistema.',
 	             styling: 'bootstrap3',
 	             delay: 2000,
 	             addclass: 'center'
 			});
 	    	//errorAlert('Error', 'Su sesi�n ha caducado, ingrese de nuevo al sistema.');
 	      }
 	    if(mensaje == "403")
 	      {
 	    	new PNotify({
 	             type: 'error',
 	             title: 'Error',
 	             text: 'Los datos de inicio de sesi�n son incorrectos, revise e intente  de nuevo.',
 	             styling: 'bootstrap3',
 	             delay: 2000,
 	             addclass: 'center'
 			});
 	        //errorAlert('Error', 'Los datos de inicio de sesi�n son incorrectos, revise e intente  de nuevo.');
 	      }
	 } );
	</script>
  </body>
</html>
