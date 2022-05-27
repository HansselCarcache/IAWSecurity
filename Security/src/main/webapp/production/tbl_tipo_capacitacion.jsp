<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="entidades.*, datos.*, java.util.*"%>


<!DOCTYPE html>
<html>
<!-- Para mandar los mensajes -->
<% 
	String msj="";
	msj = request.getParameter("msj") == null ? "0" : request.getParameter("msj");
%>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <!-- Meta, title, CSS, favicons, etc. -->
    <meta charset="ISO-8859-1">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Oferta | Tipo de Capacitación</title>

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
              <a href="Inicio.jsp" class="site_title"> <i class="fa-solid fa-book"></i><span> &nbsp Formación Docente UCA</span></a>
            </div>

            <div class="clearfix"></div>

           <%@include file="diseño.jsp"%>
           
        <!-- page content -->
			<div class="right_col" role="main">
				<div class="">
					<div class="page-title">
						<div class="title_left">
							<h3>Tipos de Capacitación </h3>
						</div>

						<div class="title_right">
							<div
								class="col-md-5 col-sm-5 col-xs-12 form-group pull-right top_search">
								
							</div>
						</div>
					</div>


					<div class="clearfix"></div>


					<div class="col-md-12 col-sm-12 ">
						<div class="x_panel">
							<div class="x_title">
								<h2> Tipos de Capacitaciones Registradas </h2>
								
								<div class="clearfix"></div>
							</div>
							<div class="x_content">
								<div class="row">
									<div class="col-sm-12">
										<div class="card-box table-responsive">
											<div class="text-muted font-13 col-md-12"
												style="text-align: right;">
												<a class="col-md-1" href="#" onclick="mostrarcolumna()"><i class="fa-solid fa-arrow-rotate-left"></i>Cargar</a>
												<a href="addTipoCapacitacion.jsp"> 
													<i class="fa fa-plus-square " title="Nuevo Tipo de Capacitacion"></i> Nuevo Tipo de Capacitacion</a>
												<br></br>
											</div>
										
											<table id="tbl_tipocap" class="table table-striped table-bordered" style="width: 100%">
                    
                    
						                    <%
						                    ArrayList<Tbl_tipo_capacitacion> listaTipCap = new ArrayList<Tbl_tipo_capacitacion>();
						                    Dt_tipo_capacitacion dttipcap = new Dt_tipo_capacitacion();
						                    listaTipCap = dttipcap.listaTipCapActivos();
						                    %>
                    
					                      <thead>
						                        <tr>
						                          
						                    
						                          <th>Tipo Capacitación <a onclick="eliminarcolumna(0)"><i class="fa-solid fa-circle-minus"></i></a></th>
						                          <th>Certificación <a onclick="eliminarcolumna(1)"><i class="fa-solid fa-circle-minus"></i></a></th>
						                          <th>Descripcion <a onclick="eliminarcolumna(2)"><i class="fa-solid fa-circle-minus"></i></a></th>
						                          <th>Estado <a onclick="eliminarcolumna(3)"><i class="fa-solid fa-circle-minus"></i></a></th>
						                          <th>Acciones <a onclick="eliminarcolumna(4)"><i class="fa-solid fa-circle-minus"></i></a></th>
						                          
						                        </tr>
					                      </thead>

						
					                      <tbody>
					                     
						                     <%
						                     for(Tbl_tipo_capacitacion tTipCal : listaTipCap){
						                     String estado = "";
											 String certificado="";
											 if (tTipCal.getEstado() != 3) {
											 estado = "Activa";
											 } else {
											 estado = "Modificada";
											 }
											 if(tTipCal.getCertificada() ==0){
											 certificado = "No se certifica";
											 }else{
											 certificado = "Es certificada";
											 }
											 %>
					                      
					                        <tr>
					                          
					                         
											  <td><%=tTipCal.getTipo_capacitacion() %></td>
											  <td><%=certificado %></td>
											  <td><%= tTipCal.getDescripcion() %></td>
											  <td><%=estado %></td>
											  
					                          <td>
					                           <a href="updateTipoCapacitacion.jsp?m=<%=tTipCal.getId_tipo_capacitacion()%>">
					                            <i class="far fa-edit" title="Modificar Tipo de Capacitación"></i>
					                          </a>
					                          &nbsp;&nbsp;
					                          <a href="readTipoCapacitacion.jsp?m=<%=tTipCal.getId_tipo_capacitacion()%>">
					                            <i class="far fa-eye" title="Visualizar Tipo de Capacitación"></i>
					                          </a> 
					                          &nbsp;&nbsp;
					                          <a href="deleteTipoCapacitacion.jsp?m=<%=tTipCal.getId_tipo_capacitacion()%>" >
					                            <i class="far fa-trash-alt" title="Eliminar Tipo de Capacitación"></i>
					                          </a>
					                          </td>
					                          
					                          
					                        </tr>
					                        
					                        <%
					                        }
					                        %>
					                        
					                      </tbody>
					                      <tfoot>
					                         <tr>
												
												<th>Tipo Capacitación </th>
												<th>Certificada</th>
												<th>Descripcion</th>
												<th>Estado</th>
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
  </div>

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

    <!-- Custom Theme Scripts -->
    <script src="../build/js/custom.min.js"></script>
    
    <!-- PNotify -->
    <script src="../vendors/pnotify/dist/pnotify.js"></script>
    <script src="../vendors/pnotify/dist/pnotify.buttons.js"></script>
    <script src="../vendors/pnotify/dist/pnotify.nonblock.js"></script>
    
    <script>
	function eliminarcolumna(id){
   		var table = $('#tbl_tipocap').DataTable();
   	 
   		table.column( id).visible( false );
   	}
   	function mostrarcolumna(){
   		var table = $('#tbl_tipocap').DataTable();
   	    
   	   	table.columns( [ 0, 1, 2, 3, 4] ).visible( true, true );
   	}
   	
   	
   	
   	
    
    $(document).ready(function() {
    	
    	
        $('#tbl_tipocap').DataTable( {
        	buttons: [  
        				
		        		{
			        		extend: 'csv',
							text: 'CSV',
							title: 'Tipo de Capacitacion registradas',
							action: function ( e, dt, node, config ) {
			                    //alert( 'Activated!' );
			                    eliminarcolumna(4);
			                    $.fn.dataTable.ext.buttons.csvHtml5.action.call(this, e, dt, node, config);
			                },
							exportOptions: {
				                columns: ':visible',
				            }
		        		},
        				{
        					extend: 'excel',
        					text: 'Excel',
        					title: 'Tipo de Capacitacion registradas',
        					action: function ( e, dt, node, config ) {
        	                    //alert( 'Activated!' );
        	                    eliminarcolumna(4);
        	                    $.fn.dataTable.ext.buttons.excelHtml5.action.call(this, e, dt, node, config);
        	                },
        					exportOptions: {
        		                columns: ':visible',
        		            }
        				},
        				
        				{
        					extend: 'pdf',
        					text: 'PDF',
        					title: 'Tipo de Capacitacion registradas',
        					action: function ( e, dt, node, config ) {
        	                    //alert( 'Activated!' );
        	                    eliminarcolumna(4);
        	                    $.fn.dataTable.ext.buttons.pdfHtml5.action.call(this, e, dt, node, config);
        	                },
        					exportOptions: {
        		                columns: ':visible',
        		            }
        				},
      
        				{ 
        					extend: 'print',
        					text: 'Imprimir',
        					title: 'Tipo de Capacitacion registradas',
        					action: function ( e, dt, node, config ) {
        	                    //alert( 'Activated!' );
        	                    eliminarcolumna(4);
        	                    $.fn.dataTable.ext.buttons.print.action.call(this, e, dt, node, config);
        	                },
        					exportOptions: {
        		                columns: ':visible',
        		            }
        					
        				} 
        			 ],
        	keys: true,
        	    
        	"dom": '<Blf<rt>ip>',
        	
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
                title: 'Ocurrio un error al agregar',
                text: 'Vuelva a ingresar los datos e intente nuevamente',
                styling: 'bootstrap3',
                delay: 2000,
                addclass: 'center'
            }); 
        	<%}%>
        	
        	<% if(msj.equals("3")) {%>
    		new PNotify({
                type: 'success',
                title: 'Edicion exitosa',
                text: 'Se han editado los datos existosamente',
                styling: 'bootstrap3',
                delay: 2000,
                addclass: 'center'
            }); 
        	<%}%>
        	
        	<% if(msj.equals("4")) {%>
    		new PNotify({
                type: 'error',
                title: 'Ocurrio un error al editar',
                text: 'Vuelva a ingresar los datos e intente nuevamente',
                styling: 'bootstrap3',
                delay: 2000,
                addclass: 'center'
            }); 
        	<%}%>
        	
        	<% if(msj.equals("5")) {%>
    		new PNotify({
                type: 'success',
                title: 'Eliminacion existosa',
                text: 'Se ha eliminado la oferta de la capacitacion exitosamente',
                styling: 'bootstrap3',
                delay: 2000,
                addclass: 'center'
            }); 
        	<%}%>
        	
        	<% if(msj.equals("6")) {%>
    		new PNotify({
                type: 'error',
                title: 'Ocurrio un error al eliminar',
                text: 'Revise su conexion he intentelo de nuevo',
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
    
    </script>

    </body>
  </html>