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

    <title>Oferta | Modificar </title>

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
    <link href="../build/css/custom.min.css" rel="stylesheet">
    
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
                            <h3>Modificar Oferta</h3>
                        </div>

                    </div>
                    <div class="clearfix"></div>

                    <div class="row">
                        <div class="col-md-12 col-sm-12">
                            <div class="x_panel">
                                <div class="x_title">
                                    <h2>Modificación de ofertas </h2>
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
                                    <form class="" action="" method="post" novalidate>
<!--                                         <p>For alternative validation library <code>parsleyJS</code> check out in the <a href="form.html">form page</a> -->
<!--                                         </p> -->
<!--                                         <span class="section">Personal Info</span> -->
											
										<div class="item form-group">
											<label class="col-form-label col-md-3 col-sm-3 label-align ">ID Oferta: <span class="required">*</span></label>
											<div class="col-md-6 col-sm-6 ">
												<input type="text" id="idoferta" name="idoferta" class="form-control" readonly="readonly" placeholder="ID Oferta">
											</div>
										</div>
											
										<div class="item form-group">
											<label class="col-form-label col-md-3 col-sm-3 label-align" >Nombre: <span class="required">*</span>
											</label>
											<div class="col-md-6 col-sm-6 ">
												<input type="text" id="nombres" name="nombres" required="required" class="form-control ">
											</div>
										</div>
										
										<div class="item form-group">
											<label class="col-form-label col-md-3 col-sm-3 label-align" >Descripcion: <span class="required">*</span>
											</label>
											<div class="col-md-6 col-sm-6 ">
												<input type="text" id="apellidos" name="apellidos" required="required" class="form-control ">
											</div>
										</div>
										
										<div class="item form-group">
											<label class="col-form-label col-md-3 col-sm-3 label-align" >Periodo: <span class="required">*</span>
											</label>
											<div class="col-md-6 col-sm-6 ">
												<input type="text" id="username" name="username" required="required" class="form-control ">
											</div>
										</div>
										
										<div class="item form-group">
											<label class="col-form-label col-md-3 col-sm-3 label-align" >Fecha inicio: <span class="required">*</span>
											</label>
											<div class="col-md-6 col-sm-6 ">
												<input type="date" id="username" name="username" required="required" class="form-control ">
											</div>
										</div>
										
										<div class="item form-group">
											<label class="col-form-label col-md-3 col-sm-3 label-align" >Fecha final: <span class="required">*</span>
											</label>
											<div class="col-md-6 col-sm-6 ">
												<input type="date" id="username" name="username" required="required" class="form-control ">
											</div>
										</div>
										
                                        
                                        
                                        <div class="ln_solid">
                                            <div class="form-group">
                                                <div class="col-md-6 offset-md-3">
                                                    <button type='submit' class="btn btn-primary">Guardar</button>
                                                    <button type='reset' class="btn btn-danger">Cancelar</button>
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
                                    <form class="" action="" method="post" novalidate>
<!--                                         <p>For alternative validation library <code>parsleyJS</code> check out in the <a href="form.html">form page</a> -->
<!--                                         </p> -->
<!--                                         <span class="section">Personal Info</span> -->
									<div class="row">
                        				<div class="col-md-6 col-sm-6">
                        				
                        					<div class="item form-group">
												<label class="col-form-label col-md-3 col-sm-3 label-align ">ID Oferta detalle: <span class="required">*</span></label>
												<div class="col-md-6 col-sm-6 ">
													<input type="text" id="idofertadet" name="idofertadet" class="form-control" readonly="readonly" placeholder="ID Oferta detalle">
												</div>
											</div>
											<div class="field item form-group">
                                            	<label class="col-form-label col-md-3 col-sm-3  label-align">Capacitación:<span class="required">*</span></label>
                                            	<div class="col-md-6 col-sm-6">
<!--                                            <input class="form-control" data-validate-length-range="6" data-validate-words="2" name="name" placeholder="ex. John f. Kennedy" required="required" /> -->
												<%
							                      	ArrayList<Tbl_user> listaUsuario = new ArrayList<Tbl_user>();
							                      	Dt_usuario dtu = new Dt_usuario();
							                      	listaUsuario = dtu.listaUserActivos();
								                 %>
												<select class="form-control js-example-basic-single" name="capacitacion" id="capacitacion" required="required">
												  <option value="">Seleccione...</option>
												  <% 
												  	for(Tbl_user tu :listaUsuario){
												  %>
												  <option value="<%=tu.getId_usuario()%>"><%=tu.getNombre_usuario()%></option>
												  <%
												  	}
												  %>
												</select>
                                            </div>
                                        </div>
                                        <div class="field item form-group">
                                            <label class="col-form-label col-md-3 col-sm-3  label-align">Facilitador: <span class="required">*</span></label>
                                            <div class="col-md-6 col-sm-6">
<!--                                                 <input class="form-control" class='optional' name="occupation" data-validate-length-range="5,15" type="text" /></div> -->
												<%
							                      	ArrayList<Tbl_rol> listRol = new ArrayList<Tbl_rol>();
							                      	Dt_rol dtr = new Dt_rol();
							                      	listRol = dtr.listaRolActivos();
								                 %>
								                 <select class="form-control js-example-basic-single" name="facilitador" id="facilitador" required="required">
												  <option value="">Seleccione...</option>
												  <% 
												  	for(Tbl_rol trol :listRol){
												  %>
												  <option value="<%=trol.getId_rol()%>"><%=trol.getRol()%></option>
												  <%
												  	}
												  %>
												</select>
											</div>
                                        </div>

										<div class="item form-group">
											<label class="col-form-label col-md-3 col-sm-3 label-align" >Fecha inicio: <span class="required">*</span>
											</label>
											<div class="col-md-6 col-sm-6 ">
												<input type="date" id="finicio" name="finicio" required="required" class="form-control ">
											</div>
										</div>
										
										<div class="item form-group">
											<label class="col-form-label col-md-3 col-sm-3 label-align" >Fecha final: <span class="required">*</span>
											</label>
											<div class="col-md-6 col-sm-6 ">
												<input type="date" id="ffinal" name="ffinal" required="required" class="form-control ">
											</div>
										</div>
										
										<div class="item form-group">
											<label class="col-form-label col-md-3 col-sm-3 label-align" >Hora inicio: <span class="required">*</span>
											</label>
											<div class="col-md-6 col-sm-6 ">
												<input type="time" id="hinicio" name="hinicio" required="required" class="form-control ">
											</div>
										</div>
										
										<div class="item form-group">
											<label class="col-form-label col-md-3 col-sm-3 label-align" >Hora final: <span class="required">*</span>
											</label>
											<div class="col-md-6 col-sm-6 ">
												<input type="time" id="hfinal" name="hfinal" required="required" class="form-control ">
											</div>
										</div>
										
										<div class="item form-group">
											<label class="col-form-label col-md-3 col-sm-3 label-align" >Días: <span class="required">*</span>
											</label>
											<div class="col-md-6 col-sm-6 ">
												<input type="text" id="dias" name="dias" required="required" class="form-control ">
											</div>
										</div>
										
										<div class="field item form-group">
                                            <label class="col-form-label col-md-3 col-sm-3  label-align">Publico: <span class="required">*</span></label>
                                            <div class="col-md-6 col-sm-6">
<!--                                            <input class="form-control" data-validate-length-range="6" data-validate-words="2" name="name" placeholder="ex. John f. Kennedy" required="required" /> -->
												
												<select class="form-control js-example-basic-single" name="publico" id="publico" required="required">
												  <option value="">Seleccione...</option>
												
												  <option value="1">Si</option>
												  <option value="2">No</option>
												 
												</select>
                                            </div>
                                        </div>
                                        <div class="item form-group">
											
											<div class="col-md-6 offset-md-3">
												<button type="button" class="btn btn-primary" onclick="agregarFila()">Registrar nuevo</button>
											</div>
										</div>
                                        
                                      
                                        
                                        
                                        <!-- Inicio primera tabla -->	
							              <div class="x_panel">
						                  <div class="x_title">
						                    <h2>Oferta detalle</h2>
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
						                  <div class="row">
                 
						                    <table  id="tbl_detalle"  class="table table-striped table-bordered" style="width:100%">
						                    
						                    <%
						                      		ArrayList<Vw_ofertadet> listaOfertadet = new ArrayList<Vw_ofertadet>();
						                      		Dt_ofertadet dtof = new Dt_ofertadet();
						                      		listaOfertadet = dtof.listaOfertasdet();
						                      %>
						                      <thead>
						                        <tr>
						                          <th>Id Oferta detalle</th>
						                          <th>Nombre Capacitación</th>
						                          <th>Facilitador</th>
						                          <th>Dias</th>
						                          <th>Acciones</th>
						                        </tr>
						                      </thead>
						
						
							                      <tbody>
							                      <%
								                      	for(Vw_ofertadet oferD :listaOfertadet){
								                      		
								                      %>
							          					<tr>
							                          <td><%=oferD.getId_oferta_detalle() %></td>
							                          <td><%=oferD.getCapacitacion() %></td>
							                          <td><%=oferD.getNombres()+' '+oferD.getApellidos() %></td>
							                          <td><%=oferD.getDias() %></td>
							                          <td>
							                           <a href="#">
							                            <i class="far fa-edit" title="Editar Opciones"></i>
							                          </a>
						
							                        
							                          </td>
								                        </tr>
								                         <%
									                        }
									                      %>
							                        
							                      </tbody>
						                      <tfoot>
						                        <tr>
						                          <th>Id Oferta detalle</th>
						                          <th>Nombre Capacitación</th>
						                          <th>Facilitador</th>
						                          <th>Dias</th>
						                          <th>Acciones</th>
						                        </tr>
						                      </tfoot>
						                    </table>
							                  </div>
							                  </div>
							              </div>
							              <!-- Final primera Tabla -->
										
                                        
                                        
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
                                        <!-- Inicio de la partición del medio -->
                                        <div class="col-md-6 col-sm-6">
                                        <!-- Inicio Tabla Capacitaciones -->
                                         <div class="x_panel">
						                  <div class="x_title">
						                    <h2>Capacitaciones registradas</h2>
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
						                  <div class="row">
                 
						                    <table id="tbl_capacitaciones" class="table table-striped table-bordered" style="width:100%">
						                    <%
					                      		ArrayList<Vw_capacitacion> listaCapacitacionV = new ArrayList<Vw_capacitacion>();
					                      		Dt_capacitacion dtcapacitacion = new Dt_capacitacion();
					                      		listaCapacitacionV = dtcapacitacion.listarcapacitacionesV();
			                    			  %>
						                    
						                      <thead>
						                        <tr>
						                          <th>Nombre Capacitación</th>
						                          <th>Modalidad</th>
						                          <th>Estado</th>
						                        </tr>
						                      </thead>
						
						
							                      <tbody>
							                       <%
							                      	for(Vw_capacitacion cap :listaCapacitacionV){
							                      		String estado= "";
							                      		if(cap.getEstado()!=3){
							                      			estado= "Activo";
							                      		}
							                      		else{
							                      			estado = "Inactivo";
							                      		}
	                     						 %>
							          
								                        <tr>
								                          <td><%=cap.getNombre() %></td>
								                          <td><%=cap.getModalidad() %></td>
								                          <td><%=estado %></td>
								                  
								                        </tr>
								                        <%
                        									}
                        								%>
							                        
							                      </tbody>
						                      <tfoot>
						                        <tr>
						                          <th>Nombre Capacitación</th>
						                          <th>Modalidad</th>
						                          <th>Estado</th>
						                        </tr>
						                      </tfoot>
						                    </table>
							                  </div>
							                  </div>
							              </div>
							              <!-- Final tabla Capacitaciones -->
							             
							            </div>
							            <!-- Final de la partición del medio -->
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