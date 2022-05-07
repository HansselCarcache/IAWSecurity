
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="entidades.*, datos.*, java.util.*;" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <!-- Meta, title, CSS, favicons, etc. -->
    <meta charset="ISO-8859-1">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Oferta | Registrar </title>

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
                            <h3>Registrar Oferta</h3>
                        </div>

                    </div>
                    <div class="clearfix"></div>

                    <div class="row">
                        <div class="col-md-12 col-sm-12">
                            <div class="x_panel">
                                <div class="x_title">
                                    <h2>Ingrese un Encabezado para su oferta </h2>
                                    
                                    <div class="clearfix"></div>
                                </div>
                                <div class="x_content">
                                    <form class="" action="" method="post" data-parsley-validate>
                                    <input type="hidden" value="1" name="opcion" id="opcion"/>
                                    <input type="hidden" value="0" name="id" id="id"/>
                                    <input type="hidden" value="addOferta.jsp" name="frm" id="frm"/>
<!--                                         <p>For alternative validation library <code>parsleyJS</code> check out in the <a href="form.html">form page</a> -->
<!--                                         </p> -->
<!--                                         <span class="section">Personal Info</span> -->
                                        <div class="field item form-group">
                                            <label class="col-form-label col-md-3 col-sm-3  label-align">Nombre de Oferta <span class="required">*</span></label>
                                            <div class="col-md-6 col-sm-6">
                                            	<input class="form-control" required="required" id="nombre" name="nombre" placeholder="Primer Semestre 2020"  />
										
                                            </div>
                                        </div>
                                        
                                        <div class="field item form-group">
                                            <label class="col-form-label col-md-3 col-sm-3  label-align">Fecha Inicio <span class="required">*</span></label>
                                            <div class="col-md-6 col-sm-6">
                                            	<input class="form-control" type="date" name="finicio" id="finicio" />
										
                                            </div>
                                        </div>
                                        
                                        <div class="field item form-group">
                                            <label class="col-form-label col-md-3 col-sm-3  label-align">Fecha Final <span class="required">*</span></label>
                                            <div class="col-md-6 col-sm-6">
                                            	<input class="form-control" type="date" name="ffinal" id="ffinal"   />
												<p id="txt" style="display:none;">Revise el orden de las fechas</p>
                                            </div>
                                        </div>
                                        
                                        
                                        <div class="field item form-group">
                                            <label class="col-form-label col-md-3 col-sm-3  label-align">Descripción <span class="required">*</span></label>
                                            <div class="col-md-6 col-sm-6">
                                            	<input class="form-control" required="required" name="descr" id="descr" placeholder="capacitaciones ofertadas...." />
										
                                            </div>
                                        </div>
                                        <div class="ln_solid">
                                            <div class="form-group">
                                                <div class="col-md-6 offset-md-3">
                                                
                                                	<button id="btn_guardar" type="button" onclick="initEnc()" class="btn btn-primary">Guardar</button>
                                                    <a href="tbl_oferta.jsp" class="btn btn-success">Regresar</a>
                                                </div>
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
                                    <h2>Detalles de oferta </h2>
                                    <ul class="nav navbar-right panel_toolbox">
                                        <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
                                        </li>
                                        
                                    </ul>
                                    <div class="clearfix"></div>
                                </div>
                                <div class="x_content">
                                    <form class="" action="" method="post" novalidate>
<!--                                         <p>For alternative validation library <code>parsleyJS</code> check out in the <a href="form.html">form page</a> -->
<!--                                         </p> -->
<!--                                         <span class="section">Personal Info</span> -->
									<div class="row">
                        				<div class="col-md-12 col-sm-12">
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
																<select disabled="disabled" class="form-control js-example-basic-single"
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
																<select disabled class="form-control js-example-basic-single"
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
																<select disabled class="form-control js-example-basic-single"
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
																	readonly required="required" class="form-control ">
																<p style="display:none;" id="txtid">Confirme que se encuentre dentro del rango de encabezado</p>
															</div>
														</div>

														<div class="item form-group">
															<label
																class="col-form-label col-md-3 col-sm-3 label-align">Fecha
																final: <span class="required">*</span>
															</label>
															<div class="col-md-6 col-sm-6 ">
																<input readonly type="date" id="ffinald" name="ffinald"
																	required="required" class="form-control ">
																<p style="display:none;" id="txtfd">Confirme que se encuentre dentro del rango de encabezado</p>
															</div>
														</div>
														<div class="item form-group">
															<label
																class="col-form-label col-md-3 col-sm-3 label-align">Días
																de Asistencia: <span class="required">*</span>
															</label>
															<div class="col-md-6 col-sm-6 ">
																<input readonly type="text" id="dias" name="dias"
																	required="required" class="form-control ">
																
															</div>
														</div>
														<div class="item form-group">
															<label
																class="col-form-label col-md-3 col-sm-3 label-align">Descripcion
																horaria: <span class="required">*</span>
															</label>
															<div class="col-md-6 col-sm-6 ">
																<textarea readonly id="horario" name="horario"
																	required="required" class="form-control" name="message"></textarea>
															</div>
														</div>




														<div class="field item form-group">
															<label
																class="col-form-label col-md-3 col-sm-3  label-align">Visibilidad:
																<span class="required">*</span>
															</label>
															<div class="col-md-6 col-sm-6">
																<select disabled class="form-control js-example-basic-single"
																	name="publico" id="publico" required="required">
																	<option value="1">Mantener Privado</option>
																	<option value="2">Hacer Publico</option>
																</select>
															</div>
														</div> 
                                        <div class="item form-group">
											
											<div class="col-md-6 offset-md-3">
												<button type="button" class="btn btn-primary" onclick="initDet()">Registrar nuevo</button>
											</div>
										</div>
                                        
                                      
                                        
                                        
                                        <!-- Inicio segunda tabla -->	
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

															
															<tr>
																<td></td>
																<td></td>
																<td></td>
																<td></td>
																<td></td>
																<td></td>
																<td></td>
															</tr>
															
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


													<select  name="fechasIniciales" id="fechasIniciales" size="5" ></select>
													<select  name="fechasFinales" id="fechasFinales" size="5" ></select>
													<select  name="capacitaciones" id="capacitaciones" size="5" ></select>
													<select  name="facilitadores" id="facilitadores" size="5" ></select>
													<select  name="modalidades" id="modalidades" size="5" ></select>
													<select  name="diasAsistencia" id="diasAsistencia" size="5" ></select>
													<select  name="horarios" id="horarios" size="5" ></select>
													<select  name="visibilidades" id="visibilidades" size="5" ></select>
													
												</div>
											</div>
										</div>
									</div>
								</div>
							              <!-- Final Segunda Tabla -->
										
                                        
                                        
                                        <div class="ln_solid"><br>
                                            <div class="form-group">
                                                <div class="col-md-6 offset-md-3">
                                                    <button type='submit' class="btn btn-primary">Guardar</button>
                                                    <button type='reset' class="btn btn-danger">Cancelar</button>
                                                </div>
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
    <script>
    
    function initEnc(){
    	if($('#nombre').val() === '' && $('#descr').val() === '' ){
    		alert('placeholder'); 	        		  
    	}else{
    		if(compararFechas()){
        		if ( $('#nombre').is('[readonly]') ) {
            		
        			setEncFalse();
        			setDetTrue();
            	}else{
            		
            		setEncTrue();
            		setDetFalse();
            	}
        		$('#txt').css('display','none')
        	}
        	else{
        		$('#finicio').css('background-color', '#FFF4E7');
        		$('#ffinal').css('background-color', '#FFF4E7');
        		$('#finicio').css('border-color', '#FFC075');
        		$('#ffinal').css('border-color', '#FFC075');
        		
        		$('#txt').css('display','block')
        	}
    	}
    	      	
    }
    
    
    function compararFechas(){
    	if ($('#finicio').val() <= $('#ffinal').val() ) {
			return true;
		}else{
			return false;
		}
    }
    <%
	ArrayList<Tbl_ofertadet> insert = new ArrayList<Tbl_ofertadet>();
	
	%>
    
    function initDet(){
    	if($('#finicio').val() <= $('#finiciod').val() && $('#ffinal').val() >= $('#finiciod').val()){
    		//Fecha inicio detalle en rango
    		if($('#finiciod').val() <= $('#ffinald').val() &&  $('#ffinald').val() <= $('#ffinal').val()){
    			//Fecha final detalle en rango
    			$('#txtfd').css('display','none')
    			$('#txtid').css('display','none')
    			setDetFalse();
    			
    			//Aqui empieza codigo para crear arrayList<FacturaDet>()
    			agregarFila();
    			agregarOpciones();
    		}else{
    			//Preventiva por css
    			$('#ffinald').css('background-color', '#FFF4E7');
        		$('#ffinald').css('border-color', '#FFC075');
        		$('#txtfd').css('display','block')
        		
        		$('#finiciod').css('background-color', '#FFFFFF');
        		$('#finiciod').css('border-color', '#ced4da');
        		$('#txtid').css('display','none')
    		}
    	}else{
    		//Preventiva por css
    		$('#finiciod').css('background-color', '#FFF4E7');
    		$('#finiciod').css('border-color', '#FFC075');
    		$('#txtid').css('display','block')
    	}
    }
    
    function setEncFalse(){
    	$('#nombre').prop("readonly",false);
    	$('#finicio').prop("readonly",false);
    	$('#ffinal').prop("readonly",false);
    	$('#descr').prop("readonly",false);
    	$('#btn_guardar').text("Guardar");
    	
    	$('#finicio').css('background-color', '#FFFFFF');
		$('#ffinal').css('background-color', '#FFFFFF');
		$('#finicio').css('border-color', '#ced4da');
		$('#ffinal').css('border-color', '#ced4da');
    }
    
    function setEncTrue(){
    	$('#nombre').prop("readonly",true);
    	$('#finicio').prop("readonly",true);
    	$('#ffinal').prop("readonly",true);
    	$('#descr').prop("readonly",true);
    	$('#btn_guardar').text("Reactivar");
    	
    	$('#finicio').css('background-color', '#e9ecef');
		$('#ffinal').css('background-color', '#e9ecef');
		$('#finicio').css('border-color', '#ced4da');
		$('#ffinal').css('border-color', '#ced4da');
    }
    
    function setDetFalse(){
    	$('#capacitacion').prop("disabled",false);
    	$('#facilitador').prop("disabled",false);
    	$('#modalidad').prop("disabled",false);
    	$('#finiciod').prop("readonly",false);
    	$('#ffinald').prop("readonly",false);
    	$('#dias').prop("readonly",false);
    	$('#horario').prop("readonly",false);
    	$('#publico').prop("disabled",false);
    	
    	$('#finiciod').css('background-color', '#FFFFFF');
		$('#ffinald').css('background-color', '#FFFFFF');
		$('#finiciod').css('border-color', '#ced4da');
		$('#ffinald').css('border-color', '#ced4da');
		$('#txtid').css('display','none')
		$('#txtfd').css('display','none')
    }
    
    function setDetTrue(){
    	$('#capacitacion').prop("disabled",true);
    	$('#facilitador').prop("disabled",true);
    	$('#modalidad').prop("disabled",true);
    	$('#finiciod').prop("readonly",true);
    	$('#ffinald').prop("readonly",true);
    	$('#dias').prop("readonly",true);
    	$('#horario').prop("readonly",true);
    	$('#publico').prop("disabled",true);
    	
    	$('#finiciod').css('background-color', '#e9ecef');
		$('#ffinald').css('background-color', '#e9ecef');
		$('#finiciod').css('border-color', '#ced4da');
		$('#ffinald').css('border-color', '#ced4da');
    }
    
    
    
    function agregarFila(){
             	
        var cap =  $('#capacitacion option:selected').text();
        var fac = $('#facilitador option:selected').text();
        var fid = $('#finiciod').val();
        var ffd = $('#ffinald').val();
        var hor = $('#horario').val();
        var dias = $('#dias').val();
        var pub = $('#publico option:selected').text();
        
        
         document.getElementById("tbl_detalle").insertRow(1).innerHTML = 
         '<td>'+ cap +'</td>'+
         '<td>'+ fac +'</td>' + 
         '<td> Del'+ fid +' al '+ ffd +'</td>' +
         '<td>'+ hor +'</td>' +
         '<td>'+ dias +'</td>' +
         '<td>'+ pub +'</td>' +
         '<td><button type="button" onclick="eliminarFila()" class="btn btn-sm btn-danger borrar"><i class="fas fa-trash-alt"></i></button></td>';
    }
    
    
    function agregarOpciones(){
    	var cap =  $('#capacitacion').val();
        var fac = $('#facilitador').val();
        var mod = $('#modalidad').val();
        var fid = $('#finiciod').val();
        var ffd = $('#ffinald').val();
        var hor = $('#horario').val();
        var dias = $('#dias').val();
        var pub = $('#publico').val();
        
        $('#fechasIniciales').prepend(new Option(fid,fid));
        $('#fechasFinales').prepend(new Option(ffd,ffd));
        $('#capacitaciones').prepend(new Option(cap,cap));
        $('#facilitadores').prepend(new Option(fac,fac));
        $('#modalidades').prepend(new Option(mod,mod));
        $('#diasAsistencia').prepend(new Option(dias,dias));
        $('#horarios').prepend(new Option(hor,hor));
        $('#visibilidades').prepend(new Option(pub,pub));
    }
    
    
    
    function eliminarFila () {
        $(document).on('click', '.borrar', function (event) {
            event.preventDefault();
            eliminarOpciones($(this).closest('tr').index());
            $(this).closest('tr').remove();
        });
    }
    
    function eliminarOpciones(id){
    	$('#fechasIniciales option:eq('+id+')').remove();
        $('#fechasFinales option:eq('+id+')').remove();
        $('#capacitaciones option:eq('+id+')').remove();
        $('#facilitadores option:eq('+id+')').remove();
        $('#modalidades option:eq('+id+')').remove();
        $('#diasAsistencia option:eq('+id+')').remove();
        $('#horarios option:eq('+id+')').remove();
        $('#visibilidades option:eq('+id+')').remove();
    }
    
    </script>
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
        
        
        
        $(document).ready(function() {
            $('#tbl_capacitaciones').DataTable( {
            	buttons: [ 'copy', 'csv', 'excel','pdf', 'print' ],
            	"dom": '<"top"lf>rt<"bottom"ip><"clear">',
            	keys: true,
            	
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
            	"dom": '<"top"lf>rst<"bottom"ip><"clear">',
            	keys: true,
            	
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