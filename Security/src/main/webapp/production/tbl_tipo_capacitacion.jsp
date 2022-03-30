<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="entidades.*, datos.*, java.util.*;"%>


<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <!-- Meta, title, CSS, favicons, etc. -->
    <meta charset="ISO-8859-1">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Oferta | Tipo de Capacitaci�n</title>

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
  </head>

  <body class="nav-md">
    <div class="container body">
      <div class="main_container">
        <div class="col-md-3 left_col">
          <div class="left_col scroll-view">
            <div class="navbar nav_title" style="border: 0;">
              <a href="Inicio.jsp" class="site_title"> <i class="fa-solid fa-book"></i><span>Gesti�n Oferta</span></a>
            </div>

            <div class="clearfix"></div>

           <%@include file="dise�o.jsp"%>
           
           
           

        <!-- page content -->
			<div class="right_col" role="main">
				<div class="">
					<div class="page-title">
						<div class="title_left">
							<h3> Gestion de Tipos de Capacitacion </h3>
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
												<a href="addTipoCapacitacion.jsp"> <i class="fa fa-2x fa-plus-square" title="Nuevo Tipo de Capacitaci�n"></i></a>
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
	                          
	                          <th>Id<a onclick="eliminarcolumna(0)"><i class="fa-solid fa-circle-minus"></i></a></th>
	                          <th>Tipo Capacitaci�n <a onclick="eliminarcolumna(1)"><i class="fa-solid fa-circle-minus"></i></a></th>
	                          <th>Certificaci�n <a onclick="eliminarcolumna(2)"><i class="fa-solid fa-circle-minus"></i></a></th>
	                          <th>Descripcion <a onclick="eliminarcolumna(3)"><i class="fa-solid fa-circle-minus"></i></a></th>
	                          <th>Estado <a onclick="eliminarcolumna(4)"><i class="fa-solid fa-circle-minus"></i></a></th>
	                          <th>Acciones <a onclick="eliminarcolumna(5)"><i class="fa-solid fa-circle-minus"></i></a></th>
	                          
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
                          
                          <td><%=tTipCal.getId_tipo_capacitacion() %></td>
						  <td><%=tTipCal.getTipo_capacitacion() %></td>
						  <td><%=certificado %></td>
						  <td><%= tTipCal.getDescripcion() %></td>
						  <td><%=estado %></td>
						  
                          <!-- <td>
                           <a href="updateModalidad.jsp">
                            <i class="far fa-edit" title="Editar Modalidad"></i>
                          </a>
                          &nbsp;&nbsp;
                          <a href="readModalidad.jsp">
                            <i class="far fa-eye" title="Visualizar Modalidad"></i>
                          </a> 
                          &nbsp;&nbsp;
                          <a href="deleteModalidad.jsp" >
                            <i class="far fa-trash-alt" title="Eliminar Modalidad"></i>
                          </a>
                          </td> -->
                          
                          <td>
							<a href="" target="blank"><i class="fa fa-2x fa-edit" title="Modificar Tipo de Capacitaci�n"></i></a> 
							<a href="" target="blank"><i class="fa fa-eye fa-2x" title="Visualizar Tipo de Capacitaci�n"></i></a> 
							<a href="" target="blank"><i class="fa fa-2x fa-trash" title="Eliminar Tipo de Capacitaci�n"></i></a>
						  </td>
                          
                        </tr>
                        
                        <%
                        }
                        %>
                        
                      </tbody>
                      <tfoot>
                         <tr>
							<th>Id </th>
							<th>Tipo Capacitaci�n </th>
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
    
    <script>
	function eliminarcolumna(id){
   		var table = $('#tbl_modalidad').DataTable();
   	 
   		table.column( id).visible( false );
   	}
   	function mostrarcolumna(){
   		var table = $('#tbl_modalidad').DataTable();
   	    
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
                "info": "Mostrando p�gina _PAGE_ de _PAGES_",
                
                "infoEmpty": "No existe registro",
                "infoFiltered": "(filtered from _MAX_ total records)"
            }
        } );
    } );
    
    </script>

    </body>
  </html>