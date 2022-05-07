
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="entidades.*, datos.*, java.util.*;" %>
<!DOCTYPE html>
<html>

<%

String tc = "";
tc = request.getParameter("m")==null?"0":request.getParameter("m");

Vw_inscripcionAdmin InsAdm = new Vw_inscripcionAdmin();
Dt_inscripcionAdmin dtInsAdm = new Dt_inscripcionAdmin();

InsAdm = dtInsAdm.getInscripcionAdmin(Integer.parseInt(tc));

Vw_ofertadet odet = new Vw_ofertadet();
Dt_ofertadet dtodet = new Dt_ofertadet();
odet= dtodet.getDetalleId(InsAdm.getId_oferta_detalle());

ArrayList<Vw_carreraInscripcion> CarIns = new ArrayList<Vw_carreraInscripcion>();

CarIns=dtInsAdm.listaCaInscripcion(InsAdm.getId_inscripcion());


%>



<head>
<!-- Switchery -->
	<link href="../vendors/switchery/dist/switchery.min.css" rel="stylesheet">
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <!-- Meta, title, CSS, favicons, etc. -->
    <meta charset="ISO-8859-1">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Inscripciones | Visualización </title>

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
              <a href="Inicio.jsp" class="site_title"> <i class="fa-solid fa-book"></i><span>Gestión Oferta</span></a>
            </div>

            <div class="clearfix"></div>

            <%@include file="diseño.jsp"%>

            <!-- page content -->
            <div class="right_col" role="main">
                <div class="">
                    <div class="page-title">
                        <div class="title_left">
                            <h3>Ver Inscripciones</h3>
                        </div>

                        
                    </div>
                    <div class="clearfix"></div>

                    <div class="row">
                        <div class="col-md-12 col-sm-12">
                            <div class="x_panel">
                                <div class="x_title">
                                    <h2>Vista de inscripciones </h2>
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
                                    <input type="hidden" value="3" name="opcion" id="opcion"/>
                                    <input type="hidden" value="<%=InsAdm.getId_inscripcion() %>" name="id_inscripcion" id="id_inscripcion"/>
                                    
<!--                                         <p>For alternative validation library <code>parsleyJS</code> check out in the <a href="form.html">form page</a> -->
<!--                                         </p> -->
<!--                                         <span class="section">Personal Info</span> -->

										<input  type="hidden" value="<%=InsAdm.getId_usuario()%>"  id="id_usuarios" name="id_usuarios" required="required" class="form-control " >

										<div class="item form-group">
											<label class="col-form-label col-md-3 col-sm-3 label-align" for="nombre">Usuario:<span class="required">*</span>
											</label>
											<div class="col-md-6 col-sm-6 ">
												<input value=<%=InsAdm.getNombre_completo() %> type="text" id="nombre_completo" name="nombre_completo" required="required" class="form-control " readonly="readonly">
											</div>
										</div>
                                        
                                        <input type="hidden" value="<%=InsAdm.getId_oferta_detalle() %>" name="oferta" id="id_oferta_detalle" class="form-control">                                        
                                        <input type="hidden" value="<%=InsAdm.getId_usuario() %>" name="id_usuario" id="id_usuario" class="form-control">
										<input  type="hidden" value="<%=InsAdm.getNombre_completo()%>"  id="nombre_completo" name="nombre_completo" required="required" class="form-control" >

										
										<div class="item form-group">
											<label class="col-form-label col-md-3 col-sm-3 label-align" for="nombre">Teléfono:<span class="required">*</span>
											</label>
											<div class="col-md-6 col-sm-6 ">
												<input value=<%=InsAdm.getTelefono() %> type="text" id="telefono" name="telefono" required="required" class="form-control " readonly="readonly">
											</div>
										</div>
										
										<div class="item form-group">
											<label class="col-form-label col-md-3 col-sm-3 label-align" for="nombre">Correo:<span class="required">*</span>
											</label>
											<div class="col-md-6 col-sm-6 ">
											
												<input  value="<%=InsAdm.getCorreo()%>" type="text" id="correo" name="correo" required="required" class="form-control " readonly="readonly" >
											</div>
										</div>
										
										<div class="field item form-group">
                                            <label class="col-form-label col-md-3 col-sm-3  label-align">Seleccione la oferta detalle: <span class="required">*</span></label>
                                            <div class="col-md-6 col-sm-6">
<!--                                            <input class="form-control" data-validate-length-range="6" data-validate-words="2" name="name" placeholder="ex. John f. Kennedy" required="required" /> -->
											
												<select disabled class="form-control js-example-basic-single" name="oferta" id="ofertas" required="required">
												  <option value="0">Seleccione...</option>
												  
												  <%
												  ArrayList<Vw_ofertadet> ofertadet = new ArrayList<Vw_ofertadet>();
												  Dt_ofertadet dto = new Dt_ofertadet();
												  ofertadet = dto.listaOfertasdet();
												  
												  for(Vw_ofertadet u : ofertadet){
													  
												  %>
												  <option disabled value="<%=u.getId_oferta_detalle()%>" data-fechai="<%=u.getFecha_inicio()%>" data-fechaf="<%=u.getFecha_final()%>" data-desch="<%=u.getDescripcion_horaria()%>" > <%=u.getCapacitacion()%> - <%=u.getFacilitador()%></option>
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
												<input value="<%=odet.getFecha_inicio()%>" type="text" id="fechaI" name="fecha_inicio" required="required" class="form-control " readonly="readonly">
											</div>
										</div>
										
										<div class="item form-group">
											<label class="col-form-label col-md-3 col-sm-3 label-align" for="nombre">Fecha final:<span class="required">*</span>
											</label>
											<div class="col-md-6 col-sm-6 ">
												<input value="<%=odet.getFecha_final()%>" type="text" id="fechaF" name="fecha_final" required="required" class="form-control " readonly="readonly">
											</div>
										</div>
										
										<div class="item form-group">
											<label class="col-form-label col-md-3 col-sm-3 label-align" for="nombre">Descripción horaria:<span class="required">*</span>
											</label>
											<div class="col-md-6 col-sm-6 ">
											<textarea id="horario" name="horario" required="required" class="form-control" name="message" readonly="readonly"><%=odet.getDescripcion_horaria()%></textarea>
											</div>
										</div>
										
										<div class="item form-group">
											<label class="col-form-label col-md-3 col-sm-3 label-align" for="nombre">Otras dependencias:<span class="required">*</span>
											</label>
											<div class="col-md-6 col-sm-6 ">
												<input value="<%=InsAdm.getOtras_dependencias() %>" type="text" id="otras_dependencias" name="otras_dependencias" required="required" class="form-control " readonly="readonly">
											</div>
										</div>

                                        <div class="item form-group">
											<label class="col-form-label col-md-3 col-sm-3 label-align" for="nombre">Carrera:<span class="required">*</span>
											</label>
											<div class="col-md-6 col-sm-6 ">
												<%
													ArrayList<Vw_carrera_departamento> listaCarrera = new ArrayList<Vw_carrera_departamento>();
													Dt_carreras dtc = new Dt_carreras();
													listaCarrera = dtc.listCarrera();
	
													
													/*
													Solo dios sabe como funciona esto, no pregunten
													*/
													
													boolean x = false; 
													for(Vw_carrera_departamento c: listaCarrera){
														int i =0;
														int size=CarIns.size()-1;
														System.out.print(size);
															while(i<CarIns.size()){
																Vw_carreraInscripcion ci = new Vw_carreraInscripcion();
																ci = CarIns.get(i);
																
																if(c.getId_carrera()==ci.getId_carrera()){
																	%>
																	<input disabled checked  type="checkbox" name="carreras" id="carrera <%=c.getId_carrera()%>" value="<%=c.getId_carrera() %>" class="flat"/> <%=c.getNombre_carrera() %>
																	<br>
																	<%
																	break;
																}else{
																	if(i == size){
																		%>
																		<input disabled type="checkbox" name="carreras" id="carrera <%=c.getId_carrera()%>" value="<%=c.getId_carrera() %>" class="flat"/> <%=c.getNombre_carrera() %>
																		<br>
																		<%
																	}
																}
																i++;
															}
														}
													if(CarIns.isEmpty()){
														for(Vw_carrera_departamento u : listaCarrera){%>
															<input disabled type="checkbox" name="carreras" id="carrera <%=u.getId_carrera()%>" value="<%=u.getId_carrera() %>" class="flat"/> <%=u.getNombre_carrera() %>
															<br>
														<%}
													}
												%>
												<br />
												</div>
										</div>
										
										
                                        
                                        
                                        <div class="ln_solid">
                                            <div class="form-group">
                                                <div class="col-md-6 offset-md-3">
                                                     <button type='submit' class="btn btn-danger">Eliminar</button>
                                                    <a href="tbl_inscripcion.jsp" class="btn btn-dark">Cancelar</a>
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
                   Gestión de Capacitación Docente - UCA
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
        	$('#usuario').val("<%=InsAdm.getId_usuario()%>");
			 if($('#usuario').val() === null){
					$('#usuario').val(0);
				}
			 
			$('#ofertas').val("<%=InsAdm.getId_oferta_detalle()%>");
           $('.js-example-basic-single').select2();
           if($('#ofertas').val() === null){
				$('#ofertas').val(0);
			}
            document.getElementById(datos[i]).checked = true;

            
           
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
    
    function init(){
    	
    	
    }
    
    document.getElementById('usuario').onchange = function() {
    	  /* Referencia a los atributos data de la opción seleccionada */
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
        	  /* Referencia a los atributos data de la opción seleccionada */
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

	
	</body>
			
</html>