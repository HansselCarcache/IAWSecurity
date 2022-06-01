
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="entidades.*, datos.*, java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<!-- Switchery -->
	<link href="../vendors/switchery/dist/switchery.min.css" rel="stylesheet">
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <!-- Meta, title, CSS, favicons, etc. -->
    <meta charset="ISO-8859-1">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Inscripciones | Registrar </title>

    <!-- Bootstrap -->
    <link href="../vendors/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome -->
    <link href="../vendors/font-awesome/css/font-awesome.min.css" rel="stylesheet">
    <link href="../vendors/fontawesome-free-6.0.0-web/css/all.min.css" rel="stylesheet">
    <!-- NProgress -->
    <link href="../vendors/nprogress/nprogress.css" rel="stylesheet">
    <!-- iCheck -->
	<link href="../vendors/iCheck/skins/flat/green.css" rel="stylesheet">

    <!-- Custom Theme Style -->
    <link href="../custom.min.css" rel="stylesheet">
    
    <!-- Select2 -->
    <link href="../vendors/select2/dist/css/select2.min.css" rel="stylesheet" />
<!-- <link href="https://cdn.jsdelivr.net/npm/select2@4.1.0-rc.0/dist/css/select2.min.css" rel="stylesheet" /> -->
<style type="text/css">
#tipo{
display:none;
}
</style>
</head>

<body class="nav-md">
    <div class="container body">
      <div class="main_container">
        <div class="col-md-3 left_col">
          <div class="left_col scroll-view">
            <div class="navbar nav_title" style="border: 0;">
              <a href="Inicio.jsp" class="site_title"> <i class="fa-solid fa-book"></i><span> Formaci�n Docente</span></a>
            </div>

            <div class="clearfix"></div>

            <%@include file="dise�o.jsp"%>

            <!-- page content -->
            <div class="right_col" role="main">
                <div class="">
                    <div class="page-title">
                        <div class="title_left">
                            <h3>Registrar Inscripciones</h3>
                        </div>

                        
                    </div>
                    <div class="clearfix"></div>

                    <div class="row">
                        <div class="col-md-12 col-sm-12">
                            <div class="x_panel">
                                <div class="x_title">
                                    <h2>Registro de inscripciones </h2>
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
                                    <form class="" action="../Sl_InscripcionAdmin" method="post" novalidate>
                                    <input type="hidden" value="1" name="opcion" id="opcion"/>
<!--                                         <p>For alternative validation library <code>parsleyJS</code> check out in the <a href="form.html">form page</a> -->
<!--                                         </p> -->
<!--                                         <span class="section">Personal Info</span> -->

										<div class="field item form-group">
                                            <label class="col-form-label col-md-3 col-sm-3  label-align">Seleccione el usuario: <span class="required">*</span></label>
                                            <div class="col-md-6 col-sm-6">
<!--                                            <input class="form-control" data-validate-length-range="6" data-validate-words="2" name="name" placeholder="ex. John f. Kennedy" required="required" /> -->
											
												<select class="form-control js-example-basic-single" name="id_usuarios" id="usuarios" required="required">
												  <option value="">Seleccione...</option>
												  
												  <%
												  ArrayList<Tbl_user> users = new ArrayList<Tbl_user>();
												  Dt_usuario dt = new Dt_usuario();
												  users= dt.listaUserActivos();
												  
												  for(Tbl_user u : users){
													  String correo = "";
												  
													  if(u.getCorreo_institucional()==null){
														  correo = u.getCorreo_personal();
													  }else{
														  correo = u.getCorreo_institucional();
													  }
												  %>
												  <option value="<%=u.getId_usuario()%>" data-nombre="<%=u.getNombre_real()%>" data-telefono="<%=u.getTelefono_contacto()%>" data-correo="<%=correo%>" > <%=u.getNombre_real()%></option>
												  <%
												  }
												  
												  %>
												  
												</select>
                                            </div>
                                        </div>
                                        
										<input type="hidden" id="nombre_completo" name="nombre_completo" required="required" class="form-control " >

										
                                       
											
									
                                       
										
										<div class="item form-group">
											<label class="col-form-label col-md-3 col-sm-3 label-align" for="nombre">Tel�fono:<span class="required">*</span>
											</label>
											<div class="col-md-6 col-sm-6 ">
												<input type="text" id="telefono" name="telefono" required="required" class="form-control " >
											</div>
										</div>
										
										<div class="item form-group">
											<label class="col-form-label col-md-3 col-sm-3 label-align" for="nombre">Correo:<span class="required">*</span>
											</label>
											<div class="col-md-6 col-sm-6 ">
												<input type="text" id="correo" name="correo" required="required" class="form-control " >
											</div>
										</div>
										
										<div class="field item form-group">
                                            <label class="col-form-label col-md-3 col-sm-3  label-align">Seleccione la oferta detalle: <span class="required">*</span></label>
                                            <div class="col-md-6 col-sm-6">
<!--                                            <input class="form-control" data-validate-length-range="6" data-validate-words="2" name="name" placeholder="ex. John f. Kennedy" required="required" /> -->
											
												<select class="form-control js-example-basic-single" name="oferta" id="ofertas" required="required">
												  <option value="">Seleccione...</option>
												  
												  <%
												  ArrayList<Vw_ofertadet> ofertadet = new ArrayList<Vw_ofertadet>();
												  Dt_ofertadet dto = new Dt_ofertadet();
												  ofertadet = dto.listaOfertasdet();
												  
												  for(Vw_ofertadet u : ofertadet){
													  
												  %>
												  <option value="<%=u.getId_oferta_detalle()%>" data-fechai="<%=u.getFecha_inicio()%>" data-fechaf="<%=u.getFecha_final()%>" data-desch="<%=u.getDescripcion_horaria()%>" > <%=u.getCapacitacion()%> - <%=u.getFacilitador()%></option>
												  <%
												  }
												  
												  %>
												  
												</select>
                                            </div>
                                        </div>
                                        
                                        <div class="item form-group">
											<label class="col-form-label col-md-3 col-sm-3 label-align" for="nombre">Fecha inicial:<span class="required">*</span>
											</label>
											<div class="col-md-6 col-sm-6 ">
												<input type="text" id="fechaI" name="fecha_inicio" required="required" class="form-control " readonly="readonly">
											</div>
										</div>
										
										<div class="item form-group">
											<label class="col-form-label col-md-3 col-sm-3 label-align" for="nombre">Fecha final:<span class="required">*</span>
											</label>
											<div class="col-md-6 col-sm-6 ">
												<input type="text" id="fechaF" name="fecha_final" required="required" class="form-control " readonly="readonly">
											</div>
										</div>
										
										<div class="item form-group">
											<label class="col-form-label col-md-3 col-sm-3 label-align" for="nombre">Descripci�n horaria:<span class="required">*</span>
											</label>
											<div class="col-md-6 col-sm-6 ">
											<textarea id="horario" name="horario" required="required" class="form-control" name="message" readonly="readonly"></textarea>
											</div>
										</div>
										
										<div class="item form-group">
											<label class="col-form-label col-md-3 col-sm-3 label-align" for="nombre">Otras dependencias:<span class="required">*</span>
											</label>
											<div class="col-md-6 col-sm-6 ">
												<input type="text" id="otras_dependencias" name="otras_dependencias" required="required" class="form-control " >
											</div>
										</div>

                                        <div class="item form-group">
											<label class="col-form-label col-md-3 col-sm-3 label-align" for="nombre">Carrera:<span class="required">*</span>
											</label>
											<div class="col-md-6 col-sm-6 ">
												<%
													ArrayList<Vw_carrera_departamento> listaCarreras = new ArrayList<Vw_carrera_departamento>();
													Dt_carreras dtc = new Dt_carreras();
													listaCarreras = dtc.listCarrera();
	
													for(Vw_carrera_departamento c: listaCarreras){
												%>
												 
													<input type="checkbox" name="carreras" id="carrera<%=c.getId_carrera()%>" value="<%=c.getId_carrera()%>" class="flat" /> <%=c.getNombre_carrera()%>
												
												<br />
												
												
												<%} %>
											</div>
										</div>
										
										
                                        
                                        
                                        <div class="ln_solid">
                                            <div class="form-group">
                                                <div class="col-md-6 offset-md-3">
                                                    <button type='submit' class="btn btn-primary">Guardar</button>
                                                    <a href="tbl_inscripcion.jsp" class="btn btn-danger">Cancelar</a>
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
                   Gesti�n de Capacitaci�n Docente - UCA
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
        document.forms[0].onsubmit = function(e) {
            var submit = true,
                validatorResult = validator.checkAll(this);
            console.log(validatorResult);
            return !!validatorResult.valid;
        };
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
        
        $(document).ready(function() {
            $('.js-example-basic-single').select2();
        });
    </script>




<script type="text/javascript">
function display(){
	var x = document.getElementById('evaluada').value;
	
	if(x == "1"){
		document.getElementById('tipo').style.display="block";
	} else if(x == "0"){
	var x = document.getElementById('tipo').style.display="none";
	}
}
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
<!-- <script src="https://cdn.jsdelivr.net/npm/select2@4.1.0-rc.0/dist/js/select2.min.js"></script> -->
    
    <script type="text/javascript"> 
    document.getElementById('usuarios').onchange = function() {
    	  /* Referencia a los atributos data de la opci�n seleccionada */
    	  var mData = this.options[this.selectedIndex].dataset;

    	  /* Referencia a los input */
    	  var elNombreCompleto = document.getElementById('nombre_completo');
    	  var elTelefono = document.getElementById('telefono');
    	  var elCorreo = document.getElementById('correo');

    	  /* Asignamos cada dato a su input*/
    	  elNombreCompleto.value = mData.nombre;
    	  elTelefono.value = mData.telefono;
    	  elCorreo.value = mData.correo;
    	};
    	
    	document.getElementById('ofertas').onchange = function() {
      	  /* Referencia a los atributos data de la opci�n seleccionada */
      	  var mData = this.options[this.selectedIndex].dataset;

      	  /* Referencia a los input */
      	  var elFechaI = document.getElementById('fechaI');
      	  var elFechaF = document.getElementById('fechaF');
      	  var elDescH = document.getElementById('horario');

      	  /* Asignamos cada dato a su input*/
      	  elFechaI.value = mData.fechai;
      	  elFechaF.value = mData.fechaf;
      	  elDescH.value = mData.desch;
      	};
    </script>
    
    <!-- iCheck -->
	<script src="../vendors/iCheck/icheck.min.js"></script>

			<script>
				$(document).ready(function() {
					$('input').iCheck({
						checkboxClass : 'icheckbox_flat',
						radioClass : 'iradio_flat'
					});
				});
			</script></body>
			
	
</html>