<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="entidades.*, datos.*, java.util.*" %>
<!DOCTYPE html>
<html>
<%
ArrayList<Vw_ofertadet> listaOferta = new ArrayList<Vw_ofertadet>();
Tbl_oferta oferta = new Tbl_oferta();

Dt_oferta dto = new Dt_oferta();
Dt_ofertadet dtod = new Dt_ofertadet();

String of = "";
of = request.getParameter("m") == null ? "0" : request.getParameter("m");

oferta = dto.getoferta(Integer.parseInt(of));
listaOferta = dtod.listaOD_id(Integer.parseInt(of));


%>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <!-- Meta, title, CSS, favicons, etc. -->
    <meta charset="ISO-8859-1">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Oferta | Visualizar </title>

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
									<h3>Visualización de Oferta</h3>
								</div>

							</div>
							<div class="clearfix"></div>
							
							<div class="row">
								<div class="col-md-12 col-sm-12">
									<div class="x_panel">
										<div class="x_title">
											<h2>Ver oferta</h2>
											<ul class="nav navbar-right panel_toolbox">
												<li><a class="collapse-link"><i
														class="fa fa-chevron-up"></i></a></li>

											</ul>
											<div class="clearfix"></div>
										</div>
										<div class="x_content">
											<form class="" action="../Sl_OfertaEnc" method="post" novalidate>
												<input type="hidden" value="2" id="opcion" name="opcion"/>
												<input type="hidden" value="<%=of %>" id="id" name="id"/>
												<div class="field item form-group">
													<label
														class="col-form-label col-md-3 col-sm-3  label-align">Nombre
														de Oferta <span class="required">*</span>
													</label>
													<div class="col-md-6 col-sm-6">
														<input class="form-control" name="nombre"
															placeholder="ex. Primer Semestre 2020"
															value="<%=oferta.getNombre()%>" readonly/>

													</div>
												</div>

												<div class="field item form-group">
													<label
														class="col-form-label col-md-3 col-sm-3  label-align">Año
														<span class="required">*</span>
													</label>
													<div class="col-md-6 col-sm-6">
														<input value="<%=oferta.getYear()%>" class="form-control"
															name="year" id="finicio" readonly />

													</div>
												</div>
												<div class="field item form-group">
													<label
														class="col-form-label col-md-3 col-sm-3  label-align">Fecha
														Inicio <span class="required">*</span>
													</label>
													<div class="col-md-6 col-sm-6">
														<input value="<%=oferta.getFecha_inicial()%>"
															class="form-control" type="date" name="finicio"
															id="finicio" readonly />

													</div>
												</div>

												<div class="field item form-group">
													<label
														class="col-form-label col-md-3 col-sm-3  label-align">Fecha
														Final <span class="required">*</span>
													</label>
													<div class="col-md-6 col-sm-6">
														<input value="<%=oferta.getFecha_final()%>"
															class="form-control" type="date" name="ffinal"
															id="ffinal" placeholder="ex. Primer Semestre 2020" readonly
															 />

													</div>
												</div>

												<div class="field item form-group">
													<label
														class="col-form-label col-md-3 col-sm-3  label-align">Descripción
														<span class="required">*</span>
													</label>
													<div class="col-md-6 col-sm-6">
														<input value="<%=oferta.getDescripcion()%>"
															class="form-control" name="descr" id="descr"
															placeholder="ex. ofertas dentro del periodo 1S 2020"
															readonly />

													</div>
												</div>
												<div class="ln_solid">
													<div class="form-group">

														<a href="tbl_oferta.jsp"
															title="Regresar a registros"> <i
															class="fa fa-arrow-circle-o-left fa-2x"> </i> Regresar a
															registros
														</a>
													</div>
												</div>
											</form>


										</div>
									</div>
								</div>
							</div>

							<div class="row">
								<div class="x_panel">
										<div class="x_title">
											<h2>Ofertas para: <%=oferta.getNombre()%> <%=oferta.getYear() %></h2>
	
											<div class="clearfix"></div>
										</div>
										<div class="x_content">
											<div class="row">
												<div class="col-sm-12">
													<div class="card-box table-responsive">
<!-- 														<div class="text-muted font-13 col-md-12" -->
<!-- 															style="text-align: right;"> -->
<!-- 															<a href="frm_addOfertaDet.jsp"> <i -->
<!-- 																class="fa fa-2x fa-plus-square" title="Nueva Oferta"></i></a> -->
<!-- 															<br></br> -->
<!-- 														</div> -->
	
														<table id="tbl_detalle"
															class="table table-striped table-bordered dataTable facultad"
															style="width: 100%">
	
	
															<thead>
																<tr>
																	<th>Capacitacion</th>
																	<th>Facilitador</th>
																	<th>Duracion</th>
																	<th>Horario</th>
																	<th>Días de Asistencia</th>
																	<th>Visibilidad</th>
																	<th>Acciones</th>
																</tr>
															</thead>
	
															<tbody>
	
																<%
																for (Vw_ofertadet to : listaOferta) {
																	String estado = "";
																	if (to.getPublico() == 2) {
																		estado = "Publico";
																	} else {
																		estado = "Privado";
																	}
																%>
																<tr>
																	<td><%=to.getTipo_capacitacion()%> <%=to.getCapacitacion()%></td>
																	<td><%=to.getFacilitador()%></td>
																	<td>De <%=to.getFecha_inicio()%> a <%=to.getFecha_final()%></td>
																	<td><%=to.getDescripcion_horaria()%></td>
																	<td><%=to.getDias()%></td>
																	<td><%=estado%></td>
																	<td>
											                          	
											                          	<a href="readOfertaDet.jsp?m=<%=to.getId_oferta()%>&d=<%=to.getId_oferta_detalle()%>">
											                            	<i class="far fa-eye fa-2x" title="Visualizar Detalle de Oferta"></i>
											                          	</a> 
											                          	
	                          										</td>
																</tr>
																<%
																}
																%>
															</tbody>
	
															<tfoot>
																<tr>
																	<th>Capacitación</th>
																	<th>Facilitador</th>
																	<th>Duración</th>
																	<th>Horario</th>
																	<th>Días de Asistencia</th>
																	<th>Visibilidad</th>
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
            $('#tbl_capacitaciones').DataTable( {
            	buttons: [ 'copy', 'csv', 'excel','pdf', 'print' ],
            	"dom": '<"top"lf>rt<"bottom"ip><"clear">',
            	
            	"lengthMenu": [ 10, 25, 50, 75, 100 ],
            
            	"language": {
                    "lengthMenu": "Mostrar _MENU_ records por pagina",
                    "search": "Buscar:",
                    "paginate": {
                        "first":      "Primero",
                        "last":       "Ultimo",
                        "next":       "Siguiente",
                        "previous":   "Anterior"
                    },
                    "emptyTable": "No existen datos en la tabla",
                    "zeroRecords": "No existe un registro en la BD",
                    "info": "Mostrando página _PAGE_ de _PAGES_",
                    
                    "infoEmpty": "No existe registro",
                    "infoFiltered": "(filtered from _MAX_ total records)"
                }
            } );
            
            $('#tbl_detalle').DataTable( {
            	buttons: [ 'copy', 'csv', 'excel','pdf', 'print' ],
            	"dom": '<"top"f>rt<"bottom"p><"clear">',
            	
            	"lengthMenu": [ 10, 25, 50, 75, 100 ],
            
            	"language": {
                    "lengthMenu": "Mostrar _MENU_ records por pagina",
                    "search": "Buscar:",
                    "paginate": {
                        "first":      "Primero",
                        "last":       "Ultimo",
                        "next":       "Siguiente",
                        "previous":   "Anterior"
                    },
                    "emptyTable": "No existen datos en la tabla",
                    "zeroRecords": "No existe un registro en la BD",
                    "info": "Mostrando página _PAGE_ de _PAGES_",
                    
                    "infoEmpty": "No existe registro",
                    "infoFiltered": "(filtered from _MAX_ total records)"
                }
            } );
        } );
        
        
        
    </script>

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

</body>
</html>