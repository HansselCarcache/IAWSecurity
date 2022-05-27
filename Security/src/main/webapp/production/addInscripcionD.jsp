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
//Para mientras se programa la sesión solo se pueden hacer inscripciones con el user 3



%>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <!-- Meta, title, CSS, favicons, etc. -->
    <meta charset="ISO-8859-1">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Inscripción Capacitación </title>

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
              <a href="InicioDocente.jsp" class="site_title"> <i class="fa-solid fa-book"></i><span>Gestión Oferta</span></a>
            </div>

            <div class="clearfix"></div>

            <%@include file="diseñoDocente.jsp"%>

            <!-- page content -->
            <div class="right_col" role="main">
                <div class="">
                    <div class="page-title">
                        <div class="title_left">
                            <h3>Inscripción</h3>
                        </div>

                        
                    </div>
                    <div class="clearfix"></div>

                    <div class="row">
                        <div class="col-md-12 col-sm-12">
                            <div class="x_panel">
                                <div class="x_title">
                                    <h2>Inscripción de capacitación </h2>
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
                                    
                                    <form  id="frmIns" action="../Sl_Inscripcion" method="post" onsubmit="toSubmit(event)" >
                                    <%
                                    Tbl_user tu = new Tbl_user();
                                    Dt_usuario dtu = new Dt_usuario();
                                    tu = dtu.getUserbyID(vwur.getId_usuario());
                                    %>
                                   
<!--                                         <p>For alternative validation library <code>parsleyJS</code> check out in the <a href="form.html">form page</a> -->
<!--                                         </p> -->
<!--                                         <span class="section">Personal Info</span> -->
										<input type="hidden" value="1" name="opcion" id="opcion"/>
										<input type="hidden" value="<%=ofd.getId_oferta_detalle() %>" name="idoferd" id="idoferd"/>
										<input type="hidden" value="<%=tu.getId_usuario() %>" name="iduser" id="iduser"/>
										<input type="hidden" value="<%=tu.getNombre_real() %>" name="nombre_completo" id="nombre_completo"/>
										<input type="hidden" value="<%=tu.getTelefono_contacto() %>" name="telefono_contacto" id="telefono_contacto"/>
										<input type="hidden" value="<%=tu.getTelefono_contacto() %>" name="telefono_contacto" id="telefono_contacto"/>
										<!-- Para mientras solo se hace con el correo personal pero después se hara una validación para que elija el correo institucional si este existe. -->
										<input type="hidden" value="<%=tu.getCorreo_personal() %>" name="correo" id="correo"/>
										<input type="hidden" value="<%=ofer %>" name="convocatoria" id="convocatoria"/>
										
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
											<label class="col-form-label col-md-3 col-sm-3 label-align" >Facilitador: 
											</label>
											<div class="col-md-6 col-sm-6 ">
												<input type="text" id="txttelefono" value="<%=ofd.getFacilitador() %>" name="txttelefono" readonly="readonly" required="required" class="form-control ">
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
												 
													<input type="checkbox" name="carreras" required id="carrera<%=c.getId_carrera()%>" value="<%=c.getId_carrera()%>"  class="flat" /> <%=c.getNombre_carrera()%>
												
												<br />
												
												
												<%} %>
											</div>
										</div>
                                        
                                        
										
										
						
                        
																																						                                                                                
                                        <div class="ln_solid">
                                            <div class="col-md-6 offset-md-3">
                								<button onclick="validarcheckbox()" class="btn btn-primary">Inscribir</button>
                                                   <a href="tbl_capacitacionD.jsp?idC=<%=ofer %>" class="btn btn-danger">Cancelar</a>
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
//         document.forms[0].onsubmit = function(e) {
//             var submit = true,
//                 validatorResult = validator.checkAll(this);
//             console.log(validatorResult);
//             return !!validatorResult.valid;
//         };
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
    		var form = document.getElementById("frmIns");
			form.onsubmit = function() {
  			return true;
			}
   		}
        
        $(document).ready(function() {
            $('.js-example-basic-single').select2();
        });
        
        
        function validarcheckbox() {
            el=document.getElementsByClassName("flat");

            var atLeastOneChecked=false;//at least one cb is checked
            for (i=0; i<el.length; i++) {
                if (el[i].checked === true) {
                    atLeastOneChecked=true;
                }
            }

            if (atLeastOneChecked === true) {
                for (i=0; i<el.length; i++) {
                    el[i].required = false;
                }
            } else {
                for (i=0; i<el.length; i++) {
                    el[i].required = true;
                }
            }
            submitForm();
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