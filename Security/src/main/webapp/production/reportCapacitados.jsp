<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="entidades.*, datos.*, java.util.*" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <!-- Meta, title, CSS, favicons, etc. -->
    <meta charset="ISO-8859-1">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Reporte | Capacitados </title>

    <!-- Bootstrap -->
    <link href="../vendors/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome -->
    <link href="../vendors/font-awesome/css/font-awesome.min.css" rel="stylesheet">
    <link href="../vendors/fontawesome-free-6.0.0-web/css/all.min.css" rel="stylesheet">
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
                            <h3>Reportes</h3>
                        </div>

                        
                    </div>
                    <div class="clearfix"></div>

                    <div class="row">
                        <div class="col-md-12 col-sm-12">
                            <div class="x_panel">
                                <div class="x_title">
                                    <h2>Reportes de Docentes Capacitados</h2>
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
                                       <form action="../Sl_OpcionRol" method="post" novalidate>
                                  
<!--                                         <p>For alternative validation library <code>parsleyJS</code> check out in the <a href="form.html">form page</a> -->
<!--                                         </p> -->
<!--                                         <span class="section">Personal Info</span> -->					

										     <input type="hidden" value="1" name="opcion" id="opcion"/>
                                        <div class="field item form-group">
                                            <label class="col-form-label col-md-3 col-sm-3  label-align">Convocatoria: <span class="required">*</span></label>
                                            <div class="col-md-6 col-sm-6">
<!--                                                 <input class="form-control" class='optional' name="occupation" data-validate-length-range="5,15" type="text" /></div> -->
												<%						                      	
							                      	ArrayList<Vw_oferta> listaOferta = new ArrayList<Vw_oferta>();
						                      		Dt_oferta dtof = new Dt_oferta();
						                      		listaOferta = dtof.listaOfActivos();
								                 %>
								                 <select class="form-control js-example-basic-single" name="pconv" id="pconv" > <!-- Cambiar el id y name -->
												  <option value="">Seleccione...</option>
												  <% 
												  	for(Vw_oferta tof :listaOferta){
												  %>
												  <option value="<%=tof.getId_oferta()%>"><%=tof.getNombre()%></option>
												  <%
												  	}
												  %>
												</select>
											</div>
                                        </div>
                                        
                                        <div class="field item form-group">
                                            <label class="col-form-label col-md-3 col-sm-3  label-align">Sexo: <span class="required">*</span></label>
                                            <div class="col-md-6 col-sm-6">
<!--                                            <input class="form-control" data-validate-length-range="6" data-validate-words="2" name="name" placeholder="ex. John f. Kennedy" required="required" /> -->
											
												<select class="form-control js-example-basic-single" name="psexo" id="psexo" >
												  <option value="">Seleccione...</option>
												  
												  <option value="1">Masculino</option>
												  <option value="2">Femenino</option>
												  
												</select>
                                            </div>
                                        </div>
                                        
                                        <div class="field item form-group">
                                            <label class="col-form-label col-md-3 col-sm-3  label-align">Año: <span class="required">*</span></label>
                                            <div class="col-md-6 col-sm-6">
												<input class="form-control" type="number" name="yearr" id="yearr" />
                                            </div>
                                        </div>
                                        
                                        <div class="field item form-group">
                                            <label class="col-form-label col-md-3 col-sm-3  label-align">Facultad: <span >*</span></label>
                                            <div class="col-md-6 col-sm-6">
<!--                                            <input class="form-control" data-validate-length-range="6" data-validate-words="2" name="name" placeholder="ex. John f. Kennedy" required="required" /> -->
												<%					                      	
							                      	ArrayList<Tbl_facultad> listFacu = new ArrayList<Tbl_facultad>();
						                      		Dt_facultad dtfacu = new Dt_facultad();
						                      		listFacu =  dtfacu.listaFacultadActivos();
								                 %>
												<select class="form-control js-example-basic-single" name="pfacultad" id="pfacultad" >
												  <option value="">Seleccione...</option>
												  <% 
												  	for(Tbl_facultad tf :listFacu){
												  %>
												  <option value="<%=tf.getNombre_facultad()%>"><%=tf.getNombre_facultad()%></option>
												  <%
												  	}
												  %>
												</select>
                                            </div>
                                        </div>
                                        
                                        <div class="field item form-group">
                                            <label class="col-form-label col-md-3 col-sm-3  label-align">Departamento: <span >*</span></label>
                                            <div class="col-md-6 col-sm-6">
<!--                                            <input class="form-control" data-validate-length-range="6" data-validate-words="2" name="name" placeholder="ex. John f. Kennedy" required="required" /> -->
												<%
												ArrayList<Vw_facultad_departamento> listDepa = new ArrayList<Vw_facultad_departamento>();
				                      			Dt_departamento dtdepa = new Dt_departamento();
				                      			listDepa = dtdepa.listaDepartamentosActivos();
								                 %>
								                 <select class="form-control js-example-basic-single" name="pdepartamento" id="pdepartamento" required="required">
												  <option value="">Seleccione...</option>
												  <% 
												  	for(Vw_facultad_departamento tdepa :listDepa){
												  %>
												  <option value="<%=tdepa.getNombre_departamento()%>"><%=tdepa.getNombre_departamento()%></option>
												  <%
												  	}
												  %>
												</select>
                                            </div>
                                        </div>
                                        
                                        
                                        <div class="field item form-group">
                                            <label class="col-form-label col-md-3 col-sm-3  label-align">Carrera: <span >*</span></label>
                                            <div class="col-md-6 col-sm-6">
<!--                                            <input class="form-control" data-validate-length-range="6" data-validate-words="2" name="name" placeholder="ex. John f. Kennedy" required="required" /> -->
												<%
												ArrayList<Vw_carrera_departamento> listCar = new ArrayList<Vw_carrera_departamento>();
				                      			Dt_carreras dtcar = new Dt_carreras();
				                      			listCar = dtcar.listCarrera();
								                 %>
								                 <select class="form-control js-example-basic-single" name="pcarrera" id="pcarrera" required="required">
												  <option value="">Seleccione...</option>
												  <% 
												  	for(Vw_carrera_departamento tcar :listCar){
												  %>
												  <option value="<%=tcar.getNombre_carrera()%>"><%=tcar.getNombre_carrera()%></option>
												  <%
												  	}
												  %>
												</select>
                                            </div>
                                        </div>

                                        
                                        
                                        <div class="ln_solid">
                                            <div class="form-group">
                                                <div class="col-md-6 offset-md-3">
                                                    <button type='submit' class="btn btn-primary">Generar reporte</button>
                                                    
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
                    Gestion de Capacitacion Docente - UCA
                </div>
                <div class="clearfix"></div>
            </footer>
            <!-- /footer content -->
        </div>
    </div>

    <script src="../vendors/bootstrap-datetimepicker/src/js/bootstrap-datetimepicker.js"></script>
    <script src="../vendors/validator/multifield.js"></script>
    <script src="../vendors/validator/validator.js"></script>
    
    <!-- Javascript functions	-->
	<script>
		$(document).ready(function(){
		  $("#yearr").datetimepicker({
		     format: "yyyy",
		     viewMode: "years"
		  });   
		});
	
	
	</script>
    
    
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
    
    <script>
 	// IMPRIMIR REPORTE SIN PARAMETROS //
    function printListUsers(){
    	window.open("../Sl_rptCapacitados", '_blank');
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
   
    </script>
    
    

</body>
</html>