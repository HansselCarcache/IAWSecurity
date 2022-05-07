<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="entidades.Tbl_user, datos.Dt_usuario, datos.Dt_usuario2, java.util.*" %>
<%
String VarMsj = "";

VarMsj = request.getParameter("msj")==null?"0":request.getParameter("msj");
Dt_usuario dtu = new Dt_usuario();
dtu.crearJSON();

%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <!-- Meta, title, CSS, favicons, etc. -->
    <meta charset="ISO-8859-1">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Usuarios | Registrar </title>

    <!-- Bootstrap -->
    <link href="../vendors/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome -->
    <link href="../vendors/font-awesome/css/font-awesome.min.css" rel="stylesheet">
  	<link href="../vendors/fontawesome-free-6.0.0-web/css/all.min.css" rel="stylesheet">
  	<!-- JAlert -->
    <link href="../vendors/jAlert/dist/jAlert.css" rel="stylesheet">
    <!-- NProgress -->
    <link href="../vendors/nprogress/nprogress.css" rel="stylesheet">

    <!-- Custom Theme Style -->
    <link href="../custom.min.css" rel="stylesheet">
    
    <!-- Select2 -->
    <link href="../vendors/select2/dist/css/select2.min.css" rel="stylesheet" />
<!-- <link href="https://cdn.jsdelivr.net/npm/select2@4.1.0-rc.0/dist/css/select2.min.css" rel="stylesheet" /> -->
</head>

<body class="nav-md">
    <div class="container body">
        <div class="main_container">
            <div class="col-md-3 left_col">
                <div class="left_col scroll-view">
                    <div class="navbar nav_title" style="border: 0;">
                        <a href="Inicio.jsp" class="site_title"> <i class="fa-solid fa-book"></i><span>Gesti�n Docente</span></a>
                    </div>

                    <div class="clearfix"></div>

                    <%@include file="dise�o.jsp"%>

            <!-- page content -->
            <div class="right_col" role="main">
                <div class="">
                    <div class="page-title">
                        <div class="title_left">
                            <h3>Registro de Docentes</h3>
                        </div>

                    </div>
                    <div class="clearfix"></div>

                    <div class="row">
                        <div class="col-md-12 col-sm-12">
                            <div class="x_panel">
                                <div class="x_title">
                                    <h2>Ingresar datos del nuevo docente </h2>
                                    <ul class="nav navbar-right panel_toolbox">
                                        <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
                                        </li>
                                        <li class="dropdown">
                                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false"><i class="fa fa-wrench"></i></a>
                                            <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                                                <a class="dropdown-item" href="#">Settings 1</a>
                                                <a class="dropdown-item" href="#">Settings 2</a>
                                            </div>
                                        </li>
                                        <li><a class="close-link"><i class="fa fa-close"></i></a>
                                        </li>
                                    </ul>
                                    <div class="clearfix"></div>
                                </div>
                                <div class="x_content">
                                    <form id="frmDocente" name="frmDocente" action="../Sl_DocenteAdmin" method="post" onsubmit="toSubmit(event)">
<!--                                         <p>For alternative validation library <code>parsleyJS</code> check out in the <a href="form.html">form page</a> -->
<!--                                         </p> -->
<!--                                         <span class="section">Personal Info</span> -->
										<input type="hidden" value="1" name="opcion" id="opcion"/>
										<div class="field item form-group">
											<label class="col-form-label col-md-3 col-sm-3 label-align" >Nombres: <span class="required">*</span>
											</label>
											<div class="col-md-6 col-sm-6 ">
												<input type="text" id="txtnombres" name="txtnombres" data-validate-length-range="5,50" data-validate-words="2" placeholder="ex. Nombre1 Nombre2" title="Primer y Segundo Nombre" required="required" class="form-control ">
											</div>
										</div>
										
										<div class="field item form-group">
											<label class="col-form-label col-md-3 col-sm-3 label-align" >Apellidos: <span class="required">*</span>
											</label>
											<div class="col-md-6 col-sm-6 ">
												<input type="text" id="txtapellidos" name="txtapellidos" data-validate-length-range="5,50" data-validate-words="2" placeholder="ex. Apellido1 Apellido2" title="Primer y Segundo Apellido" required="required" class="form-control ">
											</div>
										</div>
										
										<div class="field item form-group">
											<label class="col-form-label col-md-3 col-sm-3 label-align" >Nombre Usuario: <span class="required">*</span>
											</label>
											<div class="col-md-6 col-sm-6 ">
												<input type="text" id="txtusername" name="txtusername" data-validate-length-range="5,50" required="required" title="Escriba su nombre de usuario" class="form-control ">
											</div>
										</div>
										
										<div class="field item form-group">
                                            <label class="col-form-label col-md-3 col-sm-3  label-align">Sexo: <span class="required">*</span></label>
                                            <div class="col-md-6 col-sm-6">
<!--                                            <input class="form-control" data-validate-length-range="6" data-validate-words="2" name="name" placeholder="ex. John f. Kennedy" required="required" /> -->
											
												<select class="form-control js-example-basic-single" name="cbxsexo" id="cbxsexo" required="required">
												  <option value="">Seleccione...</option>
												  
												  <option value="1">Masculino</option>
												  <option value="2">Femenino</option>
												  
												</select>
                                            </div>
                                        </div>
                                        <div class="field item form-group">
											<label class="col-form-label col-md-3 col-sm-3 label-align" >C�dula: <span class="required">*</span>
											</label>
											<div class="col-md-6 col-sm-6 ">
												<input type="text" id="txtcedula" name="txtcedula" onchange="comprobarJSON()" data-validate-length-range="5,50" title="Escriba su c�dula" required="required" class="form-control ">
											</div>
										</div>
                                        <div class="field item form-group">
											<label class="col-form-label col-md-3 col-sm-3 label-align" >Tel�fono: <span class="required">*</span>
											</label>
											<div class="col-md-6 col-sm-6 ">
												<input type="text" id="txttelefono" name="txttelefono" data-validate-length-range="5,50" title="Escriba su tel�fono de contacto" required="required" class="form-control ">
											</div>
										</div>
                                        
                                        <div class="field item form-group">
											<label class="col-form-label col-md-3 col-sm-3 label-align" >Cargo: <span class="required">*</span>
											</label>
											<div class="col-md-6 col-sm-6 ">
												<input type="text" id="txtcargo" name="txtcargo" data-validate-length-range="5,50" title="Escriba el cargo que ocupa actualmente" required="required" class="form-control ">
											</div>
										</div>
										
										<div class="field item form-group">
											<label class="col-form-label col-md-3 col-sm-3 label-align" >Correo personal: <span class="required">*</span>
											</label>
											<div class="col-md-6 col-sm-6 ">
												<input type="text" id="txtcorreop" name="txtcorreop" title="Escriba su correo personal" required="required" class="form-control ">
											</div>
										</div>
										
										<div class="field item form-group">
											<label class="col-form-label col-md-3 col-sm-3 label-align" >Contrase�a: <span class="required">*</span>
											</label>
											<div class="col-md-6 col-sm-6 ">
												<input type="password" id="txtpwd" name="txtpwd" title="Escriba su contrase�a" required="required" class="form-control ">
											</div>
										</div>
										
										<div class="field item form-group">
											<label class="col-form-label col-md-3 col-sm-3 label-align" >Confirmar contrase�a: <span class="required">*</span>
											</label>
											<div class="col-md-6 col-sm-6 ">
												<input type="password" id="txtpwd2" name="txtpwd2" onkeyUp="habilitar()" title="Escriba de nuevo su contrase�a" required="required" class="form-control ">
												
											</div>
											
										</div>
										
										<div class="field item form-group">
											<label class="col-form-label col-md-3 col-sm-3 label-align" >ID UCA: 
											</label>
											<div class="col-md-6 col-sm-6 ">
												<input type="text" id="txtiduca" name="txtiduca" onchange="comprobarJSON()" title="Escriba su ID UCA"  class="form-control ">
											</div>
										</div>
										
										<div class="field item form-group">
											<label class="col-form-label col-md-3 col-sm-3 label-align" >Correo institucional: 
											</label>
											<div class="col-md-6 col-sm-6 ">
												<input type="text" id="txtcorreoi" onchange="comprobarJSON()" name="txtcorreoi" title="Escriba su correo institucional"  class="form-control ">
											</div>
										</div>
										
										
                                        
										
                                       
                                        
                                        
                                        
                                        
                                        
                                        
                                        <div class="ln_solid">
                                            <div class="form-group">
                                                <div class="col-md-6 offset-md-3">
                                                    <button onclick="comprobarClave()" class="btn btn-primary">Guardar</button>
                                                    <button type='reset' class="btn btn-danger">Cancelar</button>
                                                    
                                                </div>
                                            </div>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- /page content -->

            <!-- footer content -->
            <footer>
                <div class="pull-right">
                    Gentelella - Bootstrap Admin Template by <a href="https://colorlib.com">Colorlib</a>
                </div>
                <div class="clearfix"></div>
            </footer>
            <!-- /footer content -->
        </div>
    </div>


    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
    <script src="../vendors/validator/multifield.js"></script>
    <script src="../vendors/validator/validator.js"></script>
    
    <!-- Javascript functions	-->
	<script>
		function hideshow(){
			var password = document.getElementById("password1");
			var slash = document.getElementById("slash");
			var eye = document.getElementById("eye");
			
			if(password.type === 'password'){
				password.type = "text";
				slash.style.display = "block";
				eye.style.display = "none";
			}
			else{
				password.type = "password";
				slash.style.display = "none";
				eye.style.display = "block";
			}
		}
	</script>

    <script>
        // initialize a validator instance from the "FormValidator" constructor.
        // A "<form>" element is optionally passed as an argument, but is not a must
        var validator = new FormValidator({
            "events": ['blur', 'input', 'change']
        }, document.forms[0]);
        // on form "submit" event
       /* document.forms[0].onsubmit = function(e) {
            var submit = true,
                validatorResult = validator.checkAll(this);
            console.log(validatorResult);
            return !!validatorResult.valid;
        };*/
        // on form "reset" event
        document.forms[0].onreset = function(e) {
            validator.reset();
        };
        // stuff related ONLY for this demo page:
        $('.toggleValidationTooltips').change(function() {
            validator.settings.alerts = !this.checked;
            if (this.checked)
                $('form .alert').remove();
        }).prop('checked', false);
        
        function toSubmit(e){
    		e.preventDefault(); 
 			 try {
   					someBug();
  					} catch (e) {
   					throw new Error(e.message);
  					}
  					return false;
   		}
   
   		function submitForm(){
    		var form = document.getElementById("frmDocente");
			form.onsubmit = function() {
  			return true;
			}
   		}
   		
        
        function comprobarClave(){
            
        	
        	clave1 = document.frmDocente.txtpwd.value
        	clave2 = document.frmDocente.txtpwd2.value
        	sexo= document.frmDocente.cbxsexo.value
        	
        	if(sexo==""){
        		errorAlert('Error!', 'Es necesario que escoger un sexo para registrar el usuario');
        	}else if (clave1 == clave2)
        	    {
        	    submitForm();
        	    
        	    }    
        	    else{
        	      errorAlert('Error!', 'Las contrase�as no son iguales, intente de nuevo!');
        	      document.frmDocente.txtpwd.value = ""
        	      document.frmDocente.txtpwd2.value = ""
        	      document.frmDocente.txtpwd.focus
        	    }
            
        }
        
        function comprobarJSON(){
        	var txtiduca = document.getElementById("txtiduca");
        	var txtcorreoi = document.getElementById("txtcorreoi")
        	var txtcedula = document.getElementById("txtcedula");
        	var request = new XMLHttpRequest();
        	request.open('GET', 'datos_usuario.json', true)
        	request.onload = function(){
        		if(request.status === 200){
        			var ourData = JSON.parse(request.responseText);
        			//console.log(ourData);
        			
        		
        		for(i=0; i<ourData.length;i++){
        			//console.log(ourData[i].rol);
        			
        			/*var htmlString ="";
        			htmlString += "<p>" + ourData[i].rol+".</p>";
        			container.insertAdjacentHTML('beforebegin', htmlString);*/
        			//alert(txt.value);
        			
        			if(txtiduca.value == ourData[i].id_uca){
        				errorAlert("Ya existe un registro con ese IDUCA, escriba otro diferente.");
        			}
        			
        			if(txtcorreoi.value == ourData[i].correo_institucional){
        				errorAlert("Ya existe un registro con ese correo institucional, escriba otro diferente.");
        			}
        			if(txtcedula.value == ourData[i].cedula){
        				errorAlert("Ya existe un registro con esa cedula, escriba otra diferente.");
        			}
        		}
        		}
        		
        		var ourData = JSON.parse(request.responseText);
        		//renderHTML(ourData);
        	}
        	request.send();
        	
        }
        
        function habilitar()

        {

            var camp1= document.getElementById('txtpwd');
            var camp2= document.getElementById('txtpwd2');
            
			
            if (camp1.value != camp2.value) {

                
                camp1.style.borderColor = "red";
                camp1.style.borderWidth = "medium";
            	camp2.style.borderColor = "red";
            	camp2.style.borderWidth = "medium";
                
            }else {
            	
            	camp1.style.borderColor = "green";
            	camp1.style.borderWidth = "medium";
            	camp2.style.borderColor = "green";
            	camp2.style.borderWidth = "medium";
            }
        }
        
        $(document).ready(function() {
            $('.js-example-basic-single').select2();
            var mensaje = 0;
     	    mensaje = "<%=VarMsj %>";

     	    if(mensaje == "1")
     	      {
     	    	errorAlert('Error', 'Ya existe un usuario con ese IDUCA en el sistema, no se ha podido registrar el usuario.');
     	      }
     	    if(mensaje == "2")
     	      {
     	        errorAlert('Error', 'Ya existe un usuario con esa c�dula en el sistema, no se ha podido registrar el usuario.');
     	      }
        });
    </script>

    <!-- jQuery -->
    <script src="../vendors/jquery/dist/jquery.min.js"></script>
    <!-- Bootstrap -->
    <script src="../vendors/bootstrap/dist/js/bootstrap.bundle.min.js"></script>
    <!-- FastClick -->
    <script src="../vendors/fastclick/lib/fastclick.js"></script>
    <!-- NProgress -->
    <script src="../vendors/nprogress/nprogress.js"></script>
    <!-- validator -->
    <!-- <script src="../vendors/validator/validator.js"></script> -->

    <!-- Custom Theme Scripts -->
    <script src="../build/js/custom.min.js"></script>
    
    <!-- Select2 -->
    <script src="../vendors/select2/dist/js/select2.min.js"></script>
    <!-- JAlert js -->
	<script src="../vendors/jAlert/dist/jAlert.min.js"></script>
	<script src="../vendors/jAlert/dist/jAlert-functions.min.js"></script>
<!-- <script src="https://cdn.jsdelivr.net/npm/select2@4.1.0-rc.0/dist/js/select2.min.js"></script> -->
    
    <script type="text/javascript">
   
    </script>

</body>
</html>