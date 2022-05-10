<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="entidades.*, datos.*, java.util.*"%>

<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <!-- Meta, title, CSS, favicons, etc. -->
    <meta charset="ISO-8859-1">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Escala de evaluación | Evaluación</title>

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
              <a href="Inicio.jsp" class="site_title"> <i class="fa-solid fa-book"></i><span>Gestión Docente</span></a>
            </div>

            <div class="clearfix"></div>

           <%@include file="dise�o.jsp"%>

        <!-- page content -->
        <div class="right_col" role="main">
          <div class="">
            <div class="page-title">
              <div class="title_left">
                <h3>Escala de evaluaci�n</h3>
              </div>


            </div>

            <div class="clearfix"></div>

            <div class="row">
              <div class="col-md-12 col-sm-12 ">
                <div class="x_panel">
                  <div class="x_title">
                    <h2>Escalas de evaluaci�n registradas</h2>
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
                            <div class="text-muted font-13 col-md-12" style="text-align: right;">
                            <a class="col-md-1" href="#" onclick="mostrarcolumna()"><i class="fa-solid fa-arrow-rotate-left"></i>Cargar</a>
                            <a href="addEscalaCalificacion.jsp">
                            	<i class="fa fa-plus-square"></i> Nueva Escala de evaluaci�n</a>
                            	<br><br>
                            </div>
                            
                    
                    <table id="tbl_calificacion" class="table table-striped table-bordered" style="width:100%">
                    
                    <%
                    		ArrayList<Tbl_escalaCalificacion> listaEscalaCalificacion = new ArrayList<Tbl_escalaCalificacion>();
              				Dt_escalacalificacion escala = new Dt_escalacalificacion();
              				listaEscalaCalificacion = escala.listaEscalaActivo();
                      %>
                    
                      <thead>
                        <tr>
                          <th>ID Escala <a onclick="eliminarcolumna(0)"><i class="fa-solid fa-circle-minus"></i></a></th>
                          <th>Tipo de Calificacion <a onclick="eliminarcolumna(1)"><i class="fa-solid fa-circle-minus"></i></a></th>
                          <th>Descripción <a onclick="eliminarcolumna(2)"><i class="fa-solid fa-circle-minus"></i></a></th>
                          <th>Estado <a onclick="eliminarcolumna(3)"><i class="fa-solid fa-circle-minus"></i></a></th>
                          <th>Acciones <a onclick="eliminarcolumna(4)"><i class="fa-solid fa-circle-minus"></i></a></th>
                          
                        </tr>
                      </thead>


                      <tbody>
                      	<%
                      		for(Tbl_escalaCalificacion tecl :listaEscalaCalificacion){
                      			String estado= "";
                      			if(tecl.getEstado()!=3){
                      				estado= "Activo";
                      			}
                      			else{
                      				estado = "Inactivo";
                      			}
	                      	
	                      %>
                      
                        <tr>
                        
                          <td><%=tecl.getId_escala() %></td>
                          <td><%=tecl.getTipo_calificacion() %></td>
                          <td><%=tecl.getDescripcion() %></td>
                          <td><%=estado %></td>
                          <td>
                           <a href="updateEscalaCalificacion.jsp?m=<%=tecl.getId_escala() %>">
                            <i class="far fa-edit fa-2x" title="Editar Opciones"></i>
                          </a>
                          &nbsp;&nbsp;
                          <a href="readEscalaCalificacion.jsp?m=<%=tecl.getId_escala() %>">
                            <i class="far fa-eye fa-2x" title="Visualizar Opciones"></i>
                          </a> 
                          &nbsp;&nbsp;
                          <a href="deleteEscalaCalificacion.jsp?m=<%=tecl.getId_escala() %>">
                            <i class="far fa-trash-alt fa-2x" title="Eliminar Opciones"></i>
                          </a>
                          </td>
                          
                          
                        </tr>
                        <%
                        }
                        %>
                        
                        
                      </tbody>
                      <tfoot>
                        <tr>
                          <th>ID Escala</th>
                          <th>Tipo de Calificacion</th>
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
            Gentelella - Bootstrap Admin Template by <a href="https://colorlib.com">Colorlib</a>
          </div>
          <div class="clearfix"></div>
        </footer>
        <!-- /footer content -->
      </div>
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
   		var table = $('#tbl_calificacion').DataTable();
   	 
   		table.column( id).visible( false );
   	}
   	function mostrarcolumna(){
   		var table = $('#tbl_calificacion').DataTable();
   	    
   	   	table.columns( [ 0, 1, 2, 3, 4] ).visible( true, true );
   	}
   	
   	
   	
   	
    
    $(document).ready(function() {
    	
    	
        $('#tbl_calificacion').DataTable( {
        	buttons: [  
        				
		        		{
			        		extend: 'csv',
							text: 'CSV',
							title: 'Escalas de calificación registradas',
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
        					title: 'Escalas de calificación registradas',
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
        					title: 'Escalas de calificación registradas',
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
        					title: 'Escalas de calificación registradas',
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
    
    </script>

  </body>
</html>
