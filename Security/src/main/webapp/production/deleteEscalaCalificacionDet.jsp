<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="entidades.*, datos.*, java.util.*" %>
    
 
    
<!DOCTYPE html>
<html>

<%

Dt_escalaCalificacionDet dtescd = new Dt_escalaCalificacionDet();

Dt_escalacalificacion dte = new Dt_escalacalificacion();

ArrayList<Tbl_escalaCalificacion> listaEscala = new ArrayList<Tbl_escalaCalificacion>();
Tbl_escalaCalificacion escala = new Tbl_escalaCalificacion();



ArrayList<Tbl_escalaCalificacionDet> listaEscalaDet = new ArrayList<Tbl_escalaCalificacionDet>();
Tbl_escalaCalificacionDet escalaDet = new Tbl_escalaCalificacionDet();




String id = "";
id = request.getParameter("m") == null ? "0" : request.getParameter("m");
listaEscalaDet = dtescd.listaESCD_id(Integer.parseInt(id));
escala = dte.getEscala(Integer.parseInt(id));


String msj="";
msj = request.getParameter("msj") == null ? "0" : request.getParameter("msj");

String d = "";
d = request.getParameter("d") == null ? "0" : request.getParameter("d");

if(Integer.parseInt(d) !=0){
	escalaDet = dtescd.getDetalleId(Integer.parseInt(d));
}

%>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <!-- Meta, title, CSS, favicons, etc. -->
    <meta charset="ISO-8859-1">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Escala Evaluaci�n | Modificar </title>

    <!-- Bootstrap -->
    <link href="cdn.datatables.net/1.10.20/css/jquery.dataTables.min.css">
    <link href="../vendors/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome -->
    <link href="../vendors/font-awesome/css/font-awesome.min.css" rel="stylesheet">
  	<link href="../vendors/fontawesome-free-6.0.0-web/css/all.min.css" rel="stylesheet">
    <!-- NProgress -->
    <link href="../vendors/nprogress/nprogress.css" rel="stylesheet">
    <!-- iCheck -->
    <link href="../vendors/iCheck/skins/flat/green.css" rel="stylesheet">
    <!-- Datatables -->
    
    <link href="../vendors/datatables.net-bs/css/dataTables.bootstrap.min.css" rel="stylesheet">
    <link href="../vendors/datatables.net-buttons-bs/css/buttons.bootstrap.min.css" rel="stylesheet">
    <link href="../vendors/datatables.net-fixedheader-bs/css/fixedHeader.bootstrap.min.css" rel="stylesheet">
    <link href="../vendors/datatables.net-responsive-bs/css/responsive.bootstrap.min.css" rel="stylesheet">
    <link href="../vendors/datatables.net-scroller-bs/css/scroller.bootstrap.min.css" rel="stylesheet">

    <!-- Custom Theme Style -->
    <link href="../custom.min.css" rel="stylesheet">
    
    <!-- Select2 -->
    <link href="../vendors/select2/dist/css/select2.min.css" rel="stylesheet" />
<!-- <link href="https://cdn.jsdelivr.net/npm/select2@4.1.0-rc.0/dist/css/select2.min.css" rel="stylesheet" /> -->

<!-- PNotify -->
    <link href="../vendors/pnotify/dist/pnotify.css" rel="stylesheet">
    <link href="../vendors/pnotify/dist/pnotify.buttons.css" rel="stylesheet">
    <link href="../vendors/pnotify/dist/pnotify.nonblock.css" rel="stylesheet">
    <style type="text/css">
		.center{
			right: calc(50% - 150px) !important;
		}
	</style>



</head>

<body class="nav-md">
    <div class="container body">
        <div class="main_container">
            <div class="col-md-3 left_col">
                <div class="left_col scroll-view">
                    <div class="navbar nav_title" style="border: 0;">
                        <a href="index.html" class="site_title"><i class="fa-solid fa-book"></i> <span> Formaci�n Docente</span></a>
                    </div>

                    <div class="clearfix"></div>

                    <%@include file="dise�o.jsp"%>

            <!-- page content -->
            <div class="right_col" role="main">
                <div class="">
                    <div class="page-title">
                        <div class="title_left">
                            <h3>Eliminar Escala de Calificacion Detalle</h3>
                        </div>

                    </div>
                    <div class="clearfix"></div>

                    <div class="row">
                        <div class="col-md-12 col-sm-12">
                            <div class="x_panel">
                                <div class="x_title">
                                    <h2>Modificaci�n de escala de evaluaci�n </h2>
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
                                    <form class="" action="../Sl_EscalaCalificacion" method="post" novalidate>
<!--                                         <p>For alternative validation library <code>parsleyJS</code> check out in the <a href="form.html">form page</a> -->
<!--                                         </p> -->
<!--                                         <span class="section">Personal Info</span> -->

												<input type="hidden" value="2" id="opcion" name="opcion"/>
												
												<input type="hidden" value="<%=id %>" id="id" name="id_escala"/>
												<input type="hidden" value="updateEscalaCalificacion.jsp" name="frm" id="frm"/>
											
										<div class="item form-group">
											<label class="col-form-label col-md-3 col-sm-3 label-align ">Tipo Calificacion: <span class="required">*</span></label>
											<div class="col-md-6 col-sm-6 ">
												<input type="text" id="tipo" name="tipo" class="form-control" value= "<%=escala.getTipo_calificacion() %>" placeholder="" readonly>
											
											</div>
										</div>
										
										
											
										<div class="item form-group">
											<label class="col-form-label col-md-3 col-sm-3 label-align" >Descripcion <span class="required">*</span>
											</label>
											<div class="col-md-6 col-sm-6 ">
												<input type="text" id="desc" name="desc"  value="<%=escala.getDescripcion() %>"class="form-control "readonly>
											</div>
										</div>
										
							      </form>
                                    
                                    
                                </div>
                            </div>
                        </div>
                        
                          </div>
                            
                        </div><div class="x_panel">
										<div class="x_title">
											<h2>Detalles de Escala Calificacion</h2>
											<ul class="nav navbar-right panel_toolbox">
												<li><a class="collapse-link"><i
														class="fa fa-chevron-up"></i></a>
											</ul>
											<div class="clearfix"></div>
										</div>
										<div class="x_content">
											<div class="row">
												<div class="col-md-12 col-sm-12">
											<form class="" action="../Sl_escalaCalificacionDet" method="post" novalidate>
												
											   	<input type="hidden" value="<%=escala.getId_escala() %>"  name="id_escala" id="id" />
											  	<input type="hidden" value="<%=escalaDet.getId_det_escalaCalificacion()%>"  name="IdDet" id="id" />
											  	<input type="hidden" value="3" name="opcion" id="opcion"/>
											   	<input type="hidden" value="1" name="estado" id="estado"/>
											   	<input type="hidden" value="addEscalaCalificacionDet.jsp" name="frm" id="frm"/>
											  
											  
														
													<div class="field item form-group">
													<label
														class="col-form-label col-md-3 col-sm-3  label-align">Primer valor
														<span class="required">*</span>
													</label>
													<div class="col-md-6 col-sm-6">
														<input value="<%=escalaDet.getValor1() %>"
															class="form-control" name="val1" id="descr" readOnly/>
<!-- 															placeholder="ex. escalas dentro del periodo 1S 2020"
 -->															

													</div>
													</div>
													
													
													<div class="field item form-group">
													<label
														class="col-form-label col-md-3 col-sm-3  label-align">Segundo valor
														<span class="required">*</span>
													</label>
													<div class="col-md-6 col-sm-6">
														<input value="<%=escalaDet.getValor2() %>"
															class="form-control" name="val2" id="val2"/ readOnly>
															<!--  placeholder="ex. escalas "-->
															

													</div>
														</div>
													<div class="field item form-group">
													<label
														class="col-form-label col-md-3 col-sm-3  label-align">Descripcion
														<span class="required">*</span>
													</label>
													<div class="col-md-6 col-sm-6">
														<input value="<%=escalaDet.getDescripcion() %>"
															class="form-control" name="desc" id="descr"/ readOnly>
															<!--  placeholder="ex. escalas "-->
															

													</div>
													</div>
														
											<div class="ln_solid">
													<div class="form-group">
														<div class="col-md-6 offset-md-3">
															<button type='submit' class="btn btn-danger">Eliminar</button>
															<a href="tbl_escalaCalificacion.jsp" class="btn btn-success">Regresar</a>
														</div>
														</div>
													</div>
					
												
											</form>
										</div>
									</div>
									</div>
									</div>
                        
                        		<div class="x_panel">
									<div class="x_title">
										<h2>Escalas  Registradas</h2>

										<div class="clearfix"></div>
									</div>
									<div class="x_content">
										<div class="row">
											<div class="col-sm-12">
												<div class="card-box table-responsive">
													

													<table id="tbl_detalle"
														class="table table-striped table-bordered dataTable facultad"
														style="width: 100%">


														<thead>
															<tr>
																<th>Valor 1</th>
																<th>Valor 2</th>
																<th>Descripcion</th>
																<th>Acciones</th>
															</tr>
														</thead>

														<tbody>

															<%
															for (Tbl_escalaCalificacionDet det : listaEscalaDet) {
																String estado = "";
																
															%>
															<tr>
																<td><%=det.getValor1()%> </td>
																<td><%=det.getValor2()%></td>
																<td><%=det.getDescripcion()%></td>
															
																<td>
											                           	
											                          	<a href="readEscalaCalificacionDet.jsp?m=<%=det.getId_escala()%>&d=<%=det.getId_det_escalaCalificacion()%>">
											                            	<i class="far fa-eye fa-2x" title="Visualizar detalle de la oferta"></i>
											                          	</a> 
											                          	
	                          									</td>
															</tr>
															<%
															}
															%>
														</tbody>

														<tfoot>
															<tr>
																<th>Valor 1</th>
																<th>Valor 2</th>
																<th>Descripcion</th>
																<th>Acciones</th>
															</tr>
														</tfoot>
													</table>


												</div>
											</div>
										</div>
									</div>
								</div>
                        
                        
                        
                    </div>
                    
                    
                          
                        
               	<div class="col-md-6 col-sm-6 ">
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
        	
        	<% if(msj.equals("1")) {%>
    		new PNotify({
                type: 'error',
                title: 'Ocurrio un error al eliminar',
                text: 'Vuelva a ingresar los datos e intente nuevamente',
                styling: 'bootstrap3',
                delay: 2000,
                addclass: 'center'
            }); 
        	<%}%>
        	
            $('.js-example-basic-single').select2();
        });
        
        function agregarFila(){
            
            var cap =  $('#capacitacion').val();
            var fac = $('#facilitador').val();
            var dias = $('#dias').val();

             document.getElementById("datatable-buttons").insertRow(1).innerHTML = 
             '<td>'+ cap +'</td>'+
             '<td>'+ fac +'</td>' + 
             '<td>'+ dias +'</td>' + 
             '<td><button type="button" class="btn btn-sm btn-danger borrar"><i class="fas fa-trash-alt"></i></button></td>';
        }
      
        function eliminarFila () {
            $(document).on('click', '.borrar', function (event) {
                event.preventDefault();
                $(this).closest('tr').remove();
            });
            
             
        }
        $(document).ready(function() {
			$('#tbl_capacitaciones').DataTable({
				buttons : [ 'copy', 'csv', 'excel', 'pdf', 'print' ],
				"dom" : '<"top"lf>rt<"bottom"ip><"clear">',
				keys : true,

				"lengthMenu" : [ 10, 25, 50, 75, 100 ],

				"language" : {
					"lengthMenu" : "Mostrar _MENU_ records por pagina",
					"search" : "Buscar:",
					"paginate" : {
						"first" : "Primero",
						"last" : "Ultimo",
						"next" : "Siguiente",
						"previous" : "Anterior"
					},
					"emptyTable" : "No existen datos en la tabla",
					"zeroRecords" : "No existe un registro en la BD",
					"info" : "Mostrando p�gina _PAGE_ de _PAGES_",

					"infoEmpty" : "No existe registro",
					"infoFiltered" : "(filtered from _MAX_ total records)"
				}
			});

			$('#tbl_detalle').DataTable({
				buttons : [ 'copy', 'csv', 'excel', 'pdf', 'print' ],
				"dom" : '<"top"lf>rst<"bottom"ip><"clear">',
				keys : true,

				"lengthMenu" : [ 10, 25, 50, 75, 100 ],

				"language" : {
					"lengthMenu" : "Mostrar _MENU_ records por pagina",
					"search" : "Buscar:",
					"paginate" : {
						"first" : "Primero",
						"last" : "Ultimo",
						"next" : "Siguiente",
						"previous" : "Anterior"
					},
					"emptyTable" : "No existen datos en la tabla",
					"zeroRecords" : "No existe un registro en la BD",
					"info" : "Mostrando p�gina _PAGE_ de _PAGES_",

					"infoEmpty" : "No existe registro",
					"infoFiltered" : "(filtered from _MAX_ total records)"
				}
			});
		});
        
    </script>
<!--Pnotify-->
<script src="../vendors/pnotify/dist/pnotify.js"></script>
<script src="../vendors/pnotify/dist/pnotify.buttons.js"></script>
<script src="../vendors/pnotify/dist/pnotify.nonblock.js"></script>
    <!-- jQuery -->
    <script src="../vendors/jquery/dist/jquery.min.js"></script>
    <!-- Bootstrap -->
    <script src="../vendors/bootstrap/dist/js/bootstrap.bundle.min.js"></script>
    <!-- FastClick -->
    <script src="../vendors/fastclick/lib/fastclick.js"></script>
    <!-- NProgress -->
    <script src="../vendors/nprogress/nprogress.js"></script>
     <!-- iCheck -->
    <script src="../vendors/iCheck/icheck.min.js"></script>
     <!-- Datatables -->
    <script src="../vendors/datatables.net/js/jquery.dataTables.min.js"></script>
    <script src="../vendors/datatables.net-bs/js/dataTables.bootstrap.min.js"></script>
    <script src="../vendors/datatables.net-buttons/js/dataTables.buttons.min.js"></script>
    <script src="../vendors/datatables.net-buttons-bs/js/buttons.bootstrap.min.js"></script>
    <script src="../vendors/datatables.net-buttons/js/buttons.flash.min.js"></script>
    <script src="../vendors/datatables.net-buttons/js/buttons.html5.min.js"></script>
    <script src="../vendors/datatables.net-buttons/js/buttons.print.min.js"></script>
    <script src="../vendors/datatables.net-fixedheader/js/dataTables.fixedHeader.min.js"></script>
    <script src="../vendors/datatables.net-keytable/js/dataTables.keyTable.min.js"></script>
    <script src="../vendors/datatables.net-responsive/js/dataTables.responsive.min.js"></script>
    <script src="../vendors/datatables.net-responsive-bs/js/responsive.bootstrap.js"></script>
    <script src="../vendors/datatables.net-scroller/js/dataTables.scroller.min.js"></script>
    <script src="../vendors/jszip/dist/jszip.min.js"></script>
    <script src="../vendors/pdfmake/build/pdfmake.min.js"></script>
    <script src="../vendors/pdfmake/build/vfs_fonts.js"></script>
    <!-- validator -->
    <!-- <script src="../vendors/validator/validator.js"></script> -->

    <!-- Custom Theme Scripts -->
    <script src="../build/js/custom.min.js"></script>
    
    <!-- Select2 -->
    <script src="../vendors/select2/dist/js/select2.min.js"></script>
<!-- <script src="https://cdn.jsdelivr.net/npm/select2@4.1.0-rc.0/dist/js/select2.min.js"></script> -->
    
    <script type="text/javascript">
   
    </script>
    
    <script>
          
</script>

</body>
</html>