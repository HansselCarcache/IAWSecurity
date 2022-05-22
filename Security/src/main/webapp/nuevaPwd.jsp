<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="entidades.Tbl_user, datos.Dt_usuario, datos.Dt_usuario2, java.util.*" %>
<%
String VarMsj = "";
String user = "";
String correo = "";
VarMsj = request.getParameter("msj")==null?"0":request.getParameter("msj");
user = request.getParameter("user")==null?"0":request.getParameter("user");
correo = request.getParameter("email")==null?"0":request.getParameter("email");
Dt_usuario dtu = new Dt_usuario();


%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<!-- Meta, title, CSS, favicons, etc. -->
	<meta charset="ISO-8859-1">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">

	<title>Registro | Sistema de gesti�n docente</title>

	<!-- Bootstrap -->
    <link href="vendors/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome -->
    <link href="vendors/font-awesome/css/font-awesome.min.css" rel="stylesheet">
  	<link href="vendors/fontawesome-free-6.0.0-web/css/all.min.css" rel="stylesheet">
  	<!-- JAlert -->
    <link href="vendors/jAlert/dist/jAlert.css" rel="stylesheet">
    <!-- NProgress -->
    <link href="vendors/nprogress/nprogress.css" rel="stylesheet">
	<!-- Custom Theme Style -->
	<link href="custom.min.css" rel="stylesheet">
	<!-- Select2 -->
    <link href="vendors/select2/dist/css/select2.min.css" rel="stylesheet" />
</head>
	
<body>
	<div class="main_container">
    	<a href="#" class="site_title"> <i class="fa-solid fa-book"></i><span>Registro de Nuevo Docente</span></a>
    	<!-- page content -->
        <div class="right_col" role="main">
      		<div class="">
            	<div class="clearfix"></div>
            	<div class="row">
            		<div class="col-md-12 col-sm-12">
            			<div class="x_panel">
            				<div class="x_title">
            					<h2>Favor ingrese sus datos</h2>
            					<div class="clearfix"></div>
            				</div>
            				<div class="x_content">
            					<form id="frmDocente" name="frmDocente" action="Sl_login" method="post" onsubmit="toSubmit(event)">
            						<input type="hidden" value="4" name="opcion" id="opcion"/>
            						<input type="hidden" id="usuario2" name="usuario2" value="<%=user%>">
            						<input type="hidden" id="correo" name="correo" value="<%=correo%>">
            						
									
									<div class="field item form-group">
										<label class="col-form-label col-md-3 col-sm-3 label-align" >Contrase�a nueva: <span class="required">*</span>
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
									
									
									<div class="ln_solid">
                                        <div class="form-group">
                                            <div class="col-md-6 offset-md-3">
                                                <button onclick="comprobarClave()" class="btn btn-primary">Reestablecer contrase�a</button>
                                                <input onclick="location.href='Login.jsp'" type="reset" class="btn btn-danger" value="Cancelar"/>
                                                
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
    </div>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
    <script src="vendors/validator/multifield.js"></script>
    <script src="vendors/validator/validator.js"></script>
    
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
        	
        	
        	 if (clave1 == clave2)
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
    <script src="vendors/jquery/dist/jquery.min.js"></script>
    <!-- Bootstrap -->
    <script src="vendors/bootstrap/dist/js/bootstrap.bundle.min.js"></script>
    <!-- FastClick -->
    <script src="vendors/fastclick/lib/fastclick.js"></script>
    <!-- NProgress -->
    <script src="vendors/nprogress/nprogress.js"></script>
    <!-- validator -->
    <!-- <script src="../vendors/validator/validator.js"></script> -->

    <!-- Custom Theme Scripts -->
    <script src="build/js/custom.min.js"></script>
    
    <!-- Select2 -->
    <script src="vendors/select2/dist/js/select2.min.js"></script>
    <!-- JAlert js -->
	<script src="vendors/jAlert/dist/jAlert.min.js"></script>
	<script src="vendors/jAlert/dist/jAlert-functions.min.js"></script>
<!-- <script src="https://cdn.jsdelivr.net/npm/select2@4.1.0-rc.0/dist/js/select2.min.js"></script> -->
    
    <script type="text/javascript">
   
    </script>

</body>

</html>