<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="entidades.*, datos.*, java.util.*;"%>
<!DOCTYPE html>
<html>
<%
ArrayList<Vw_ofertadet> listaOferta = new ArrayList<Vw_ofertadet>();
Tbl_oferta oferta = new Tbl_oferta();

Dt_oferta dto = new Dt_oferta();
Dt_ofertadet dtod = new Dt_ofertadet();

String id = "";
id = request.getParameter("m") == null ? "0" : request.getParameter("m");

oferta = dto.getoferta(Integer.parseInt(id));
listaOferta = dtod.listaOD_id(Integer.parseInt(id));

String msj="";
msj = request.getParameter("msj") == null ? "0" : request.getParameter("msj");
%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- Meta, title, CSS, favicons, etc. -->
<meta charset="ISO-8859-1">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>Oferta | Registrar</title>

<!-- Bootstrap -->
<link href="cdn.datatables.net/1.10.20/css/jquery.dataTables.min.css">
<link href="../vendors/bootstrap/dist/css/bootstrap.min.css"
	rel="stylesheet">
<!-- Font Awesome -->
<link href="../vendors/font-awesome/css/font-awesome.min.css"
	rel="stylesheet">
<link href="../vendors/fontawesome-free-6.0.0-web/css/all.min.css"
	rel="stylesheet">
<!-- NProgress -->
<link href="../vendors/nprogress/nprogress.css" rel="stylesheet">
<!-- iCheck -->
<link href="../vendors/iCheck/skins/flat/green.css" rel="stylesheet">
<!-- Datatables -->

<link
	href="../vendors/datatables.net-bs/css/dataTables.bootstrap.min.css"
	rel="stylesheet">
<link
	href="../vendors/datatables.net-buttons-bs/css/buttons.bootstrap.min.css"
	rel="stylesheet">
<link
	href="../vendors/datatables.net-fixedheader-bs/css/fixedHeader.bootstrap.min.css"
	rel="stylesheet">
<link
	href="../vendors/datatables.net-responsive-bs/css/responsive.bootstrap.min.css"
	rel="stylesheet">
<link
	href="../vendors/datatables.net-scroller-bs/css/scroller.bootstrap.min.css"
	rel="stylesheet">

<!-- Custom Theme Style -->
<link href="../custom.min.css" rel="stylesheet">

<!-- Select2 -->
<link href="../vendors/select2/dist/css/select2.min.css"
	rel="stylesheet" />

<!-- PNotify -->
    <link href="../vendors/pnotify/dist/pnotify.css" rel="stylesheet">
    <link href="../vendors/pnotify/dist/pnotify.buttons.css" rel="stylesheet">
    <link href="../vendors/pnotify/dist/pnotify.nonblock.css" rel="stylesheet">
    <style type="text/css">
		.center{
			right: calc(50% - 150px) !important;
		}
	</style>
<!-- <link href="https://cdn.jsdelivr.net/npm/select2@4.1.0-rc.0/dist/css/select2.min.css" rel="stylesheet" /> -->
</head>

<body class="nav-md">
	<div class="container body">
		<div class="main_container">
			<div class="col-md-3 left_col">
				<div class="left_col scroll-view">
					<div class="navbar nav_title" style="border: 0;">
						<a href="Inicio.jsp" class="site_title"> <i
							class="fa-solid fa-book"></i><span>Gestión Docente</span></a>
					</div>

					<div class="clearfix"></div>

					<%@include file="diseño.jsp"%>

					<!-- page content -->
					<div class="right_col" role="main">
						<div class="">
							<div class="page-title">
								<div class="title_left">
									<h3>Registrar Oferta</h3>
								</div>

							</div>
							<div class="clearfix"></div>
							
							<div class="row">
								<div class="col-md-12 col-sm-12">
									<div class="x_panel">
										<div class="x_title">
											<h2>Registros de ofertas</h2>
											<ul class="nav navbar-right panel_toolbox">
												<li><a class="collapse-link"><i
														class="fa fa-chevron-up"></i></a></li>

											</ul>
											<div class="clearfix"></div>
										</div>
										<div class="x_content">
											<form class="" action="" method="post" novalidate>
												<div class="field item form-group">
													<label
														class="col-form-label col-md-3 col-sm-3  label-align">Nombre
														de Oferta <span class="required">*</span>
													</label>
													<div class="col-md-6 col-sm-6">
														<input class="form-control" name="name"
															placeholder="ex. Primer Semestre 2020"
															value="<%=oferta.getNombre()%>" readonly />

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
															id="finicio" placeholder="ex. Primer Semestre 2020"
															readonly />

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
															id="ffinal" placeholder="ex. Primer Semestre 2020"
															readonly />

													</div>
												</div>

												<div class="field item form-group">
													<label
														class="col-form-label col-md-3 col-sm-3  label-align">Año
														<span class="required">*</span>
													</label>
													<div class="col-md-6 col-sm-6">
														<input value="<%=oferta.getYear()%>" class="form-control"
															name="periodo" id="periodo" placeholder="ex. 1S2020"
															readonly />

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
														<div class="col-md-6 offset-md-3"></div>
													</div>
												</div>
											</form>


										</div>
									</div>
								</div>
							</div>

							<div class="row">
								<div class="col-md-12 col-sm-12">
									<div class="x_panel">
										<div class="x_title">
											<h2>Detalles de oferta</h2>
											<ul class="nav navbar-right panel_toolbox">
												<li><a class="collapse-link"><i
														class="fa fa-chevron-up"></i></a>
											</ul>
											<div class="clearfix"></div>
										</div>
										<div class="x_content">
											<div class="row">
												<div class="col-md-12 col-sm-12">
											<form class="" action="../Sl_OfertaDet" method="post" novalidate>
												<input type="hidden" value="<%=oferta.getFecha_inicial() %>" name="finicio" id="finicio"/>
											   	<input type="hidden" value="<%=oferta.getFecha_final() %>"  name="ffinal" id="ffinal" />
											   	<input type="hidden" value="1" name="opcion" id="opcion"/>
											   	<input type="hidden" value="0" name="id_oferta_det" id="id_oferta_det"/>
											   	<input type="hidden" value="0" name="estado" id="estado"/>
											   	<input type="hidden" value="addOfertaDet.jsp" name="frm" id="frm"/>
											   	<input type="hidden" value="<%=oferta.getId_oferta() %>" name="id_oferta" id="id_oferta"/>
<%-- 									   <textarea onfocus="this.value = 'Mensaje en\ndos lineas'"><%="Mensaje en \n dos lineas" %></textarea> --%>
												<!--                                         <p>For alternative validation library <code>parsleyJS</code> check out in the <a href="form.html">form page</a> -->
												<!--                                         </p> -->
												<!--                                         <span class="section">Personal Info</span> -->
												
														<div class="field item form-group">
															<label
																class="col-form-label col-md-3 col-sm-3  label-align">Capacitación:<span
																class="required">*</span></label>
															<div class="col-md-6 col-sm-6">
																<!--                                            <input class="form-control" data-validate-length-range="6" data-validate-words="2" name="name" placeholder="ex. John f. Kennedy" required="required" /> -->
																<%
																ArrayList<Tbl_capacitacion> listaCapacitacion = new ArrayList<Tbl_capacitacion>();
																Dt_capacitacion dtu = new Dt_capacitacion();
																listaCapacitacion = dtu.listacapacitacionesActivas();
																%>
																<select class="form-control js-example-basic-single"
																	name="capacitacion" id="capacitacion"
																	required="required">
																	<option value="">Seleccione...</option>
																	<%
																	for (Tbl_capacitacion tc : listaCapacitacion) {
																	%>
																	<option value="<%=tc.getId_capacitacion()%>"><%=tc.getNombre()%></option>
																	<%
																	}
																	%>
																</select>
															</div>
														</div>
														<div class="field item form-group">
															<label
																class="col-form-label col-md-3 col-sm-3  label-align">Facilitador:
																<span class="required">*</span>
															</label>
															<div class="col-md-6 col-sm-6">
																<!--                                                 <input class="form-control" class='optional' name="occupation" data-validate-length-range="5,15" type="text" /></div> -->
																<%
																ArrayList<Tbl_facilitadores> listFac = new ArrayList<Tbl_facilitadores>();
																Dt_facilitadores dtrol = new Dt_facilitadores();
																listFac = dtrol.listaFaciActivos();
																%>
																<select class="form-control js-example-basic-single"
																	name="facilitador" id="facilitador" required="required">
																	<option value="">Seleccione...</option>
																	<%
																	for (Tbl_facilitadores trol : listFac) {
																	%>
																	<option value="<%=trol.getId_facilitador()%>"><%=trol.getNombres()%></option>
																	<%
																	}
																	%>
																</select>
															</div>
														</div>
														
														<div class="field item form-group">
															<label
																class="col-form-label col-md-3 col-sm-3  label-align">Modalidad:
																<span class="required">*</span>
															</label>
															<div class="col-md-6 col-sm-6">
																<!--<input class="form-control" class='optional' name="occupation" data-validate-length-range="5,15" type="text" /></div> -->
																<%
																ArrayList<Tbl_modalidad> listMod = new ArrayList<Tbl_modalidad>();
																Dt_modalidad dtmod = new Dt_modalidad();
																listMod = dtmod.listaModalidadesActivas();
																%>
																<select class="form-control js-example-basic-single"
																	name="modalidad" id="modalidad" required="required">
																	<option value="">Seleccione...</option>
																	<%
																	for (Tbl_modalidad mod : listMod) {
																	%>
																	<option value="<%=mod.getId_modalidad()%>"><%=mod.getNombre_modalidad() %></option>
																	<%
																	}
																	%>
																</select>
															</div>
														</div>

														<div class="item form-group">
															<label
																class="col-form-label col-md-3 col-sm-3 label-align">Fecha
																inicio: <span class="required">*</span>
															</label>
															<div class="col-md-6 col-sm-6 ">
																<input type="date" id="finiciod" name="finiciod"
																	required="required" class="form-control ">
															</div>
														</div>

														<div class="item form-group">
															<label
																class="col-form-label col-md-3 col-sm-3 label-align">Fecha
																final: <span class="required">*</span>
															</label>
															<div class="col-md-6 col-sm-6 ">
																<input type="date" id="ffinald" name="ffinald"
																	required="required" class="form-control ">
															</div>
														</div>
														<div class="item form-group">
															<label
																class="col-form-label col-md-3 col-sm-3 label-align">Días
																de Asistencia: <span class="required">*</span>
															</label>
															<div class="col-md-6 col-sm-6 ">
																<input type="text" id="dias" name="dias"
																	required="required" class="form-control ">
															</div>
														</div>
														<div class="item form-group">
															<label
																class="col-form-label col-md-3 col-sm-3 label-align">Descripcion
																horaria: <span class="required">*</span>
															</label>
															<div class="col-md-6 col-sm-6 ">
																<textarea id="horario" name="horario"
																	required="required" class="form-control" name="message"></textarea>
															</div>
														</div>




														<div class="field item form-group">
															<label
																class="col-form-label col-md-3 col-sm-3  label-align">Visibilidad:
																<span class="required">*</span>
															</label>
															<div class="col-md-6 col-sm-6">
																<select class="form-control js-example-basic-single"
																	name="publico" id="publico" required="required">
																	<option value="1">Mantener Privado</option>
																	<option value="2">Hacer Publico</option>
																</select>
															</div>
														</div> 
														
														<div class="ln_solid">
				                                            <div class="form-group">
				                                                <div class="col-md-6 offset-md-3">
				                                                    <button type='submit' class="btn btn-primary">Guardar</button>
				                                                    <a href="tbl_oferta.jsp" class="btn btn-success">Regresar</a>
				                                                </div>
				                                            </div>
                                       					</div>
												
											</form>
										</div>
									</div>
									</div>
									</div>
								</div>



								<div class="x_panel">
									<div class="x_title">
										<h2>Escalas Registradas</h2>

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
																if (to.getPublico() == 1) {
																	estado = "Privado";
																} else {
																	estado = "Publico";
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
											                           	<a href="updateOfertaDet.jsp?m=<%=to.getId_oferta()%>&d=<%=to.getId_oferta_detalle()%>">
											                            	<i class="far fa-edit fa-2x" title="Editar detalle de la oferta"></i>
											                         	</a>
											                          	&nbsp;&nbsp;
											                          	<a href="readOfertaDet.jsp?id=?m=<%=to.getId_oferta()%>&d=<%=to.getId_oferta_detalle()%>">
											                            	<i class="far fa-eye fa-2x" title="Visualizar detalle de la oferta"></i>
											                          	</a> 
											                          	&nbsp;&nbsp;
											                          	<a href="deleteOfertaDet.jsp??m=<%=to.getId_oferta()%>&d=<%=to.getId_oferta_detalle()%>" >
											                            	<i class="far fa-trash-alt fa-2x" title="Eliminar detalle de la oferta"></i>
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
					<div class="col-md-6 col-sm-6 "></div>
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


	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
	<script src="../vendors/validator/multifield.js"></script>
	<script src="../vendors/validator/validator.js"></script>

	<!-- Javascript functions	-->
	<script>
		function hideshow() {
			var password = document.getElementById("password1");
			var slash = document.getElementById("slash");
			var eye = document.getElementById("eye");

			if (password.type === 'password') {
				password.type = "text";
				slash.style.display = "block";
				eye.style.display = "none";
			} else {
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
			"events" : [ 'blur', 'input', 'change' ]
		}, document.forms[0]);
		// on form "submit" event
		document.forms[0].onsubmit = function(e) {
			var submit = true, validatorResult = validator.checkAll(this);
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

		$(document).ready(function() {
        	try {
        		<% if(msj.equals("1")) {%>
        		new PNotify({
                    type: 'success',
                    title: 'Ingreso exitoso',
                    text: 'Se han ingresado los datos existosamente',
                    styling: 'bootstrap3',
                    delay: 2000,
                    addclass: 'center'
                }); 
            	<%}%>
            	
            	<% if(msj.equals("2")) {%>
        		new PNotify({
                    type: 'error',
                    title: 'Ocurrio un error',
                    text: 'Vuelva a ingresar los datos e intente nuevamente',
                    styling: 'bootstrap3',
                    delay: 2000,
                    addclass: 'center'
                }); 
            	<%}%>
            	
            	//FECHAS EN DETALLE
            	<% if(msj.equals("3")) {%>
        		new PNotify({
                    type: 'warning',
                    title: 'Advertencia',
                    text: 'La fecha inicial ingresada ocurre luego de la fecha final ingresada',
                    styling: 'bootstrap3',
                    delay: 2000,
                    addclass: 'center'
                }); 
            	<%}%>
            	
            	<% if(msj.equals("4")) {%>
        		new PNotify({
                    type: 'warning',
                    title: 'Advertencia',
                    text: 'Asegurese que la fecha final esta dentro del rango del encabezado',
                    styling: 'bootstrap3',
                    delay: 2000,
                    addclass: 'center'
                }); 
            	<%}%>
            	
            	<% if(msj.equals("5")) {%>
        		new PNotify({
                    type: 'warning',
                    title: 'Advertencia',
                    text: 'Asegurese que la fecha inicial esta dentro del rango del encabezado',
                    styling: 'bootstrap3',
                    delay: 2000,
                    addclass: 'center'
                }); 
            	<%}%>
        		  
            	
        		  
        		}
        		catch(err) {
        		  alert(err.message)
        		}
            
        });
		function agregarFila() {

			var cap = $('#capacitacion').val();
			var fac = $('#facilitador').val();
			var dias = $('#dias').val();

			document.getElementById("tbl_detalle").insertRow(1).innerHTML = '<td>'
					+ cap
					+ '</td>'
					+ '<td>'
					+ fac
					+ '</td>'
					+ '<td>'
					+ dias
					+ '</td>'
					+ '<td><button type="button" onclick="eliminarFila()" class="btn btn-sm btn-danger borrar"><i class="fas fa-trash-alt"></i></button></td>';
		}

		function eliminarFila() {
			$(document).on('click', '.borrar', function(event) {
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
					"info" : "Mostrando página _PAGE_ de _PAGES_",

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
					"info" : "Mostrando página _PAGE_ de _PAGES_",

					"infoEmpty" : "No existe registro",
					"infoFiltered" : "(filtered from _MAX_ total records)"
				}
			});
		});
	</script>


	<!-- Pnotify -->
	<script src="../vendors/pnotify/dist/pnotify.js"></script>
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
	<script
		src="../vendors/datatables.net-bs/js/dataTables.bootstrap.min.js"></script>
	<script
		src="../vendors/datatables.net-buttons/js/dataTables.buttons.min.js"></script>
	<script
		src="../vendors/datatables.net-buttons-bs/js/buttons.bootstrap.min.js"></script>
	<script src="../vendors/datatables.net-buttons/js/buttons.flash.min.js"></script>
	<script src="../vendors/datatables.net-buttons/js/buttons.html5.min.js"></script>
	<script src="../vendors/datatables.net-buttons/js/buttons.print.min.js"></script>
	<script
		src="../vendors/datatables.net-fixedheader/js/dataTables.fixedHeader.min.js"></script>
	<script
		src="../vendors/datatables.net-keytable/js/dataTables.keyTable.min.js"></script>
	<script
		src="../vendors/datatables.net-responsive/js/dataTables.responsive.min.js"></script>
	<script
		src="../vendors/datatables.net-responsive-bs/js/responsive.bootstrap.js"></script>
	<script
		src="../vendors/datatables.net-scroller/js/dataTables.scroller.min.js"></script>
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