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

    <title>Facilitadores</title>

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
              <a href="Inicio.jsp" class="site_title"> <i class="fa-solid fa-book"></i><span>Evaluacion Docente</span></a>
            </div>

            <div class="clearfix"></div>

           <%@include file="diseñoDocente.jsp"%>

        <!-- page content -->
        <div class="right_col" role="main">
          <div class="">
            <div class="page-title">
              <div class="title_left">
                <h3>Evaluacion</h3>
              </div>


            </div>

            <div class="clearfix"></div>

            <div class="row">
              <div class="col-md-12 col-sm-12 ">
                <div class="x_panel">
                  <div class="x_title">
                    <h2>Docentes Inscritos </h2>
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
                          <div class="col-sm-12">
                            <div class="card-box table-responsive">
                           
                            
                    
                    <table id="tbl_Evaluacion" class="table table-striped table-bordered" style="width:100%">
                    
                     <%
                      		ArrayList<Vw_inscripcion> listInc = new ArrayList<Vw_inscripcion>();
                      		Dt_inscripcion dtins = new Dt_inscripcion();
                      		listInc = dtins.listaIns();
                      %>
                      
                    
                    
                      <thead>
                        <tr>
                          <th>Usuario</th>
                          <th>Carrera</th>
                          <th>Oferta</th>
                          <th>Id UCA</th>
                          <th>Correo</th>
                          <th>Calificacion</th>
                        </tr>
                      </thead>
                      <tbody>
                      
                                 <%
	                      	for(Vw_inscripcion ins : listInc){
	                      		
	                      	
	                      %>
                      
                           
                          <tr>
                        <td><%=ins.getUsuario() %></td>
                        <td><%=ins.getNombre_carrera() %></td>
                        <td><%=ins.getNombre_oferta() %></td>
                        <td><%=ins.getId_uca() %></td>
                        <td><%=ins.getCorreo_electronico() %></td>
                        
                        <td>      </td>
                        </tr><%}%>
                      </tbody>
                      <tfoot>
                        <tr>
                          <th>Usuario</th>
                          <th>Carrera</th>
                          <th>Oferta</th>
                          <th>Id UCA</th>
                          <th>Correo</th>
                          <th>Calificacion</th>
  
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
            Gentelella - Bootstrap Admin Template by <a href="https://colorlib.com">Colorlib</a>
          </div>
          <div class="clearfix"></div>
        </footer>
        <!-- /footer content -->
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
   		var table = $('#tbl_Evaluacion').DataTable();
   	 
   		table.column( id).visible( false );
   	}
   	function mostrarcolumna(){
   		var table = $('#tbl_Evaluacion').DataTable();
   	    
   	   	table.columns( [ 0, 1, 2, 3, 4, 5, 6, 7, 8 ] ).visible( true, true );
   	}
   	
   	
   	
   	
    
    $(document).ready(function() {
    	
    	
        $('#tbl_Evaluacion').DataTable( {
        	buttons: [  
        				
		        		{
			        		extend: 'csv',
							text: 'CSV',
							title: 'Ofertas registradas',
							action: function ( e, dt, node, config ) {
			                    //alert( 'Activated!' );
			                    eliminarcolumna(8);
			                    $.fn.dataTable.ext.buttons.csvHtml5.action.call(this, e, dt, node, config);
			                },
							exportOptions: {
				                columns: ':visible',
				            }
		        		},
        				{
        					extend: 'excel',
        					text: 'Excel',
        					title: 'Ofertas registradas',
        					action: function ( e, dt, node, config ) {
        	                    //alert( 'Activated!' );
        	                    eliminarcolumna(8);
        	                    $.fn.dataTable.ext.buttons.excelHtml5.action.call(this, e, dt, node, config);
        	                },
        					exportOptions: {
        		                columns: ':visible',
        		            }
        				},
        				
        				{
        					extend: 'pdf',
        					text: 'PDF',
        					title: 'Ofertas registradas',
        					action: function ( e, dt, node, config ) {
        	                    //alert( 'Activated!' );
        	                    eliminarcolumna(8);
        	                    $.fn.dataTable.ext.buttons.pdfHtml5.action.call(this, e, dt, node, config);
        	                },
        					exportOptions: {
        		                columns: ':visible',
        		            }
        				},
      
        				{ 
        					extend: 'print',
        					text: 'Imprimir',
        					title: 'Ofertas registradas',
        					action: function ( e, dt, node, config ) {
        	                    //alert( 'Activated!' );
        	                    eliminarcolumna(8);
        	                    $.fn.dataTable.ext.buttons.print.action.call(this, e, dt, node, config);
        	                },
        					exportOptions: {
        		                columns: ':visible',
        		            }
        					
        				} 
        			 ],
        	keys: true,
        	    
        	"dom": '<lf<rt>ip>',
        	
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

  </body>
</html>