<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="entidades.*, datos.*, java.util.*" %>
<!DOCTYPE html>
<html>

<%

 String cap = ""; 
 cap = request.getParameter("idC")==null?"0":request.getParameter("idC"); 
 
 String ofer = ""; 
 ofer = request.getParameter("idO")==null?"0":request.getParameter("idO"); 
						
Vw_ofertadet ofd = new Vw_ofertadet(); 
Dt_ofertadet dtofd = new Dt_ofertadet(); 
ofd = dtofd.getDetalleId(Integer.parseInt(cap));

%>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <!-- Meta, title, CSS, favicons, etc. -->
    <meta charset="ISO-8859-1">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Capacitación | Visualizar </title>

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
              <a href="InicioDocente.jsp" class="site_title"> <i class="fa-solid fa-book"></i><span> Formación Docente</span></a>
            </div>

            <div class="clearfix"></div>

            <%@include file="diseñoDocente.jsp"%>

            <!-- page content -->
            <div class="right_col" role="main">
                <div class="">
                    <div class="page-title">
                        <div class="title_left">
                            <h3>Capacitación</h3>
                        </div>

                        
                    </div>
                    <div class="clearfix"></div>

                    <div class="row">
                        <div class="col-md-12 col-sm-12">
                            <div class="x_panel">
                                <div class="x_title">
                                    <h2>Visualización de capacitación </h2>
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
                                    <form  action="#" method="post" novalidate>
                                   
<!--                                         <p>For alternative validation library <code>parsleyJS</code> check out in the <a href="form.html">form page</a> -->
<!--                                         </p> -->
<!--                                         <span class="section">Personal Info</span> -->
										
										<div class="field item form-group">
											<label class="col-form-label col-md-3 col-sm-3 label-align" >Capacitación: 
											</label>
											<div class="col-md-6 col-sm-6 ">
												<input type="text" id="txtusername" value="<%=ofd.getCapacitacion() %>" name="txtusername" readonly="readonly"  required="required"  class="form-control ">
											</div>
										</div>

										<div class="item form-group">
											<label class="col-form-label col-md-3 col-sm-3 label-align ">Fecha Inicio:</label>
											<div class="col-md-6 col-sm-6 ">
												<input id="txtiduser" name="txtiduser" value="<%=ofd.getFecha_inicio() %>" type="text" class="form-control" readonly="readonly" placeholder="ID Usuario">
											</div>
										</div>
										
										<div class="item form-group">
											<label class="col-form-label col-md-3 col-sm-3 label-align" >Fecha Final: 
											</label>
											<div class="col-md-6 col-sm-6 ">
												<input type="text" id="txtfreg" value="<%=ofd.getFecha_final() %>" name="txtfreg" readonly="readonly" required="required" class="form-control ">
											</div>
										</div>
										
										<div class="item form-group">
											<label class="col-form-label col-md-3 col-sm-3 label-align" >Dias: 
											</label>
											<div class="col-md-6 col-sm-6 ">
												<input type="text" id="txtestado" value="<%=ofd.getDias() %>" name="txtestado" readonly="readonly" required="required" class="form-control ">
											</div>
										</div>

										<div class="field item form-group">
											<label class="col-form-label col-md-3 col-sm-3 label-align" >Descripción Horaria: 
											</label>
											<div class="col-md-6 col-sm-6 ">
												<input type="text" id="txtnombreC" value="<%=ofd.getDescripcion_horaria() %>" name="txtnombreC" readonly="readonly"  required="required" class="form-control ">
											</div>
										</div>
										
										
										<div class="field item form-group">
											<label class="col-form-label col-md-3 col-sm-3 label-align" >Modalidad: 
											</label>
											<div class="col-md-6 col-sm-6 ">
												<input type="text" id="txtcargo" value="<%=ofd.getModalidad() %>" name="txtcargo" readonly="readonly" required="required" class="form-control ">
											</div>
										</div>
										
                                        <div class="field item form-group">
											<label class="col-form-label col-md-3 col-sm-3 label-align" >Tipo de capacitación: 
											</label>
											<div class="col-md-6 col-sm-6 ">
												<input type="text" id="txtcedula" value="<%=ofd.getTipo_capacitacion() %>"  name="txtcedula" readonly="readonly"  required="required" class="form-control ">
											</div>
										</div>
                                        <div class="field item form-group">
											<label class="col-form-label col-md-3 col-sm-3 label-align" >Facilitador: 
											</label>
											<div class="col-md-6 col-sm-6 ">
												<input type="text" id="txttelefono" value="<%=ofd.getFacilitador() %>" name="txttelefono" readonly="readonly" required="required" class="form-control ">
											</div>
										</div>
                                        
                                        
										
										
						
                        
																																						                                                                                
                                        <div class="ln_solid">
                                            <div class="col-md-6 offset-md-3">
                								<a href="tbl_capacitacionD.jsp?idC=<%=ofer %>" class="btn btn-primary">Regresar</a>
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