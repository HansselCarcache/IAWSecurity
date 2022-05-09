<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="entidades.Tbl_user, datos.Dt_usuario, datos.Dt_usuario2, java.util.*" %>
<!DOCTYPE html>
<html>
<%
String user = "";
user = request.getParameter("idU")==null?"0":request.getParameter("idU");

Tbl_user tu = new Tbl_user();
Dt_usuario dtu = new Dt_usuario();
tu = dtu.getUserbyID(Integer.parseInt(user));
%>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <!-- Meta, title, CSS, favicons, etc. -->
    <meta charset="ISO-8859-1">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Usuarios | Eliminar </title>

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
              <a href="Inicio.jsp" class="site_title"> <i class="fa-solid fa-book"></i><span>Gestión Docente</span></a>
            </div>

            <div class="clearfix"></div>

            <%@include file="diseño.jsp"%>

            <!-- page content -->
            <div class="right_col" role="main">
                <div class="">
                    <div class="page-title">
                        <div class="title_left">
                            <h3>Eliminar usuario</h3>
                        </div>

                        
                    </div>
                    <div class="clearfix"></div>

                    <div class="row">
                        <div class="col-md-12 col-sm-12">
                            <div class="x_panel">
                                <div class="x_title">
                                    <h2>Eliminación de usuarios </h2>
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
                                    <form id="frmUser" name="frmUser" class="" action="../Sl_Usuario" method="post" onsubmit="toSubmit(event)">
<!--                                         <p>For alternative validation library <code>parsleyJS</code> check out in the <a href="form.html">form page</a> -->
<!--                                         </p> -->
<!--                                         <span class="section">Personal Info</span> -->
										<input type="hidden" value="3" name="opcion" id="opcion"/>
										<input type="hidden" value="<%=vwur.getId_usuario() %>" name="usuario_eliminacion" id="usuario_eliminacion" />
										<input type="hidden" value="<%=tu.getEstado() %>" name="estado" id="estado" />	
										<div class="item form-group">
											<label class="col-form-label col-md-3 col-sm-3 label-align ">ID Usuario:</label>
											<div class="col-md-6 col-sm-6 ">
												<input id="txtiduser" name="txtiduser" type="text" class="form-control" readonly="readonly" placeholder="ID Usuario">
											</div>
										</div>
										
										<div class="item form-group">
											<label class="col-form-label col-md-3 col-sm-3 label-align" >Fecha de registro: 
											</label>
											<div class="col-md-6 col-sm-6 ">
												<input type="text" id="txtfreg" name="txtfreg" readonly="readonly" required="required" class="form-control ">
											</div>
										</div>
										
										<div class="item form-group">
											<label class="col-form-label col-md-3 col-sm-3 label-align" >Estado: 
											</label>
											<div class="col-md-6 col-sm-6 ">
												<input type="text" id="txtestado" name="txtestado" readonly="readonly" required="required" class="form-control ">
											</div>
										</div>

										<div class="field item form-group">
											<label class="col-form-label col-md-3 col-sm-3 label-align" >Nombre Completo: 
											</label>
											<div class="col-md-6 col-sm-6 ">
												<input type="text" id="txtnombreC" name="txtnombreC" readonly="readonly"  required="required" class="form-control ">
											</div>
										</div>
										
										
										
										<div class="field item form-group">
											<label class="col-form-label col-md-3 col-sm-3 label-align" >Nombre Usuario: 
											</label>
											<div class="col-md-6 col-sm-6 ">
												<input type="text" id="txtusername" name="txtusername" readonly="readonly"  required="required"  class="form-control ">
											</div>
										</div>
										
										<div class="field item form-group">
                                            <label class="col-form-label col-md-3 col-sm-3  label-align">Sexo: </label>
                                            <div class="col-md-6 col-sm-6">
<!--                                            <input class="form-control" data-validate-length-range="6" data-validate-words="2" name="name" placeholder="ex. John f. Kennedy" required="required" /> -->
											
												<select class="form-control js-example-basic-single" disabled name="cbxsexo" id="cbxsexo" required="required">
												  
												  
												  <option value="1">Masculino</option>
												  <option value="2">Femenino</option>
												  
												</select>
                                            </div>
                                        </div>
                                        <div class="field item form-group">
											<label class="col-form-label col-md-3 col-sm-3 label-align" >Cédula: 
											</label>
											<div class="col-md-6 col-sm-6 ">
												<input type="text" id="txtcedula" name="txtcedula" readonly="readonly"  required="required" class="form-control ">
											</div>
										</div>
                                        <div class="field item form-group">
											<label class="col-form-label col-md-3 col-sm-3 label-align" >Teléfono: 
											</label>
											<div class="col-md-6 col-sm-6 ">
												<input type="text" id="txttelefono" name="txttelefono" readonly="readonly" required="required" class="form-control ">
											</div>
										</div>
                                        
                                        <div class="field item form-group">
											<label class="col-form-label col-md-3 col-sm-3 label-align" >Cargo: 
											</label>
											<div class="col-md-6 col-sm-6 ">
												<input type="text" id="txtcargo" name="txtcargo" readonly="readonly" required="required" class="form-control ">
											</div>
										</div>
										
										<div class="field item form-group">
											<label class="col-form-label col-md-3 col-sm-3 label-align" >Correo personal: 
											</label>
											<div class="col-md-6 col-sm-6 ">
												<input type="text" id="txtcorreop" name="txtcorreop" readonly="readonly" required="required" class="form-control ">
											</div>
										</div>
										
										
										<div class="field item form-group">
											<label class="col-form-label col-md-3 col-sm-3 label-align" >ID UCA: 
											</label>
											<div class="col-md-6 col-sm-6 ">
												<input type="text" id="txtiduca" name="txtiduca" readonly="readonly"   class="form-control ">
											</div>
										</div>
										
										<div class="field item form-group">
											<label class="col-form-label col-md-3 col-sm-3 label-align" >Correo institucional: 
											</label>
											<div class="col-md-6 col-sm-6 ">
												<input type="text" id="txtcorreoi" name="txtcorreoi" readonly="readonly"   class="form-control ">
											</div>
										</div>

                                        
                                        
                                        <div class="ln_solid">
                                            <div class="col-md-6 offset-md-3">
                								<button onclick="deleteUser()" class="btn btn-danger">Eliminar</button>
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
        /*document.forms[0].onsubmit = function(e) {
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
        
      //Funciones del formulario
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
    		var form = document.getElementById("frmUser");
			form.onsubmit = function() {
  			return true;
			}
   		}
   		
   	 function deleteUser(){
         $.jAlert({
             'type': 'confirm',
             'confirmQuestion': '¿Esta seguro que desea eliminar el registro?',
             'onConfirm': function(e, btn){
               e.preventDefault();
               //do something here
               submitForm();
               document.getElementById('frmUser').submit();
               btn.parents('.jAlert').closeAlert();
               return false;
             },
             'onDeny': function(e, btn){
               e.preventDefault();
               //do something here
               btn.parents('.jAlert').closeAlert();
               return false;
             }
         });
     }
        
        function setValores()
        {
        	
        	
        	$('#cbxUser').removeAttr('disabled');
        	document.getElementById("txtiduser").value = "<%=tu.getId_usuario()%>"
        	
        	document.getElementById("txtnombreC").value = "<%=tu.getNombre_real()%>"
        	document.getElementById("cbxsexo").value = '<%=tu.getSexo()%>'
            document.getElementById("cbxsexo").text = '<%=tu.getSexo()%>'
            $("#cbxsexo").select2()	
        	document.getElementById("txttelefono").value = "<%=tu.getTelefono_contacto()%>"
        	document.getElementById("txtcargo").value = "<%=tu.getCargo()%>"
        	
        	document.getElementById("txtiduca").value = "<%=tu.getId_uca()%>"	
            document.getElementById("txtcorreoi").value = "<%=tu.getCorreo_institucional()%>"
            document.getElementById("txtusername").value = "<%=tu.getNombre_usuario()%>"
            document.getElementById("txtcedula").value = "<%=tu.getCedula()%>"
            document.getElementById("txtcorreop").value = "<%=tu.getCorreo_personal()%>"
            document.getElementById("txtfreg").value = "<%=tu.getFecha_creacion()%>"
            
            
            estado = "<%=tu.getEstado()%>" 
                 
            	if(estado=="0"){
                    
               		document.getElementById("txtestado").value = "No verificado"
                             
                }else if(estado!="3"){
                	document.getElementById("txtestado").value = "Activo"
                }  	
           
 
        	
        	
        }
        
        $(document).ready(function() {
            $('.js-example-basic-single').select2();
            setValores();
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