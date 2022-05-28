<%@page import="java.io.Console"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="entidades.*, datos.*,negocio.Ng_InscripcionD ,  java.util.*"%>
<%
String VarMsj = "";

VarMsj = request.getParameter("msj")==null?"0":request.getParameter("msj");

String convocatoria = "";

convocatoria = request.getParameter("idC")==null?"0":request.getParameter("idC");
Vw_ofertadet oferN = new Vw_ofertadet();
ArrayList<Vw_ofertadet> listaOfertadet = new ArrayList<Vw_ofertadet>();
Dt_inscripcionDocente dtof = new Dt_inscripcionDocente();
listaOfertadet = dtof.listaOfertasdet(Integer.parseInt(convocatoria));
oferN = dtof.getOfertaByID(Integer.parseInt(convocatoria));
Ng_InscripcionD ngi = new Ng_InscripcionD();
String existe ="";

%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <!-- Meta, title, CSS, favicons, etc. -->
    <meta charset="ISO-8859-1">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Oferta | Capacitaciones</title>

    <!-- Bootstrap -->
    <link href="cdn.datatables.net/1.10.20/css/jquery.dataTables.min.css">
    <link href="../vendors/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome -->
    <link href="../vendors/font-awesome/css/font-awesome.min.css" rel="stylesheet">
    <link href="../vendors/fontawesome-free-6.0.0-web/css/all.min.css" rel="stylesheet">
    <!-- JAlert -->
    <link href="../vendors/jAlert/dist/jAlert.css" rel="stylesheet">
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
              <a href="InicioDocente.jsp" class="site_title"> <i class="fa-solid fa-book"></i><span> &nbsp Formaci�n Docente UCA</span></a>
            </div>

            <div class="clearfix"></div>

           <%@include file="dise�oDocente.jsp"%>

        <!-- page content -->
        <div class="right_col" role="main">
          <div class="">
            <div class="page-title">
              <div class="title_left">
                <h3>Capacitaciones de <%=oferN.getConvocatoria() %> </h3>
              </div>


            </div>

            <div class="clearfix"></div>

            <div class="row">
              <div class="col-md-12 col-sm-12 ">
                <div class="x_panel">
                  <div class="x_title">
                    <h2>Capacitaciones ofertadas</h2>
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
                            
                            	<br><br>
                            </div>
                            
                    <input type="hidden" id="iduser" value="<%=vwur.getId_usuario()%>">
                     <table  id="tbl_detalle"  class="table table-striped table-bordered" style="width:100%">
						                    
						                   
						                      <thead>
						                        <tr>
						                        
						                          <th>Convocatoria</th>
						                          <th>Nombre Capacitaci�n</th>
						                          <th>Modalidad</th>
						                          <th>Facilitador</th>
						                          <th>Fecha Inicio</th>
						                          <th>Fecha Final</th>
						                          <th>Dias</th>
						                          <th>Inscripci�n</th>
						                          <th>Ver</th>
						                        </tr>
						                      </thead>
						
						
							                      <tbody>
							                      <%
								                      	for(Vw_ofertadet oferD :listaOfertadet){
								                      		if(ngi.existeInscripcion(oferD.getId_oferta_detalle(), vwur.getId_usuario())){
								                      			 existe = "existe";
								                      		}else{
								                      			existe ="no";
								                      		}
								                      		
								                      %>
							          					<tr id="<%=existe%>">
							          					
							                          <td><%=oferD.getConvocatoria() %></td>
							                          <td><%=oferD.getCapacitacion() %></td>
							                          <td><%=oferD.getModalidad() %></td>
							                          <td><%=oferD.getFacilitador() %></td>
							                          <td><%=oferD.getFecha_inicio() %></td>
							                          <td><%=oferD.getFecha_final() %></td>
							                          <td><%=oferD.getDias() %></td>
							                          <td>
							                          &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							                           <a href="addInscripcionD.jsp?idC=<%=oferD.getId_oferta_detalle()%>&idO=<%=oferD.getId_oferta()%>">
							                            <i class="far fa-edit" title="Inscribir Capacitacion"></i>
							                            
							                          </a>
							                         
							                          </td>
							                          <td>
							                           &nbsp;&nbsp;
							                          <a href="readCapacitacionD.jsp?idC=<%=oferD.getId_oferta_detalle()%>&idO=<%=oferD.getId_oferta()%>">
							                            <i class="far fa-eye" title="Visualizar Capacitaci�n"></i>
							                          </a>
							                          </td>
								                        </tr>
								                         <%
									                        }
									                      %>
							                        
							                      </tbody>
						                      <tfoot>
						                        <tr>
						                          
						                          
						                          <th>Convocatoria</th>
						                          <th>Nombre Capacitaci�n</th>
						                          <th>Modalidad</th>
						                          <th>Facilitador</th>
						                          <th>Fecha Inicio</th>
						                          <th>Fecha Final</th>
						                          <th>Dias</th>
						                          <th>Inscripci�n</th>
						                          <th>Ver</th>
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
    <!-- JAlert js -->
	<script src="../vendors/jAlert/dist/jAlert.min.js"></script>
	<script src="../vendors/jAlert/dist/jAlert-functions.min.js"></script>

    <!-- Custom Theme Scripts -->
    <script src="../build/js/custom.min.js"></script>
    <script>
    function eliminarcolumna(){
   		var table = $('#tbl_detalle').DataTable();
   	 
   		table.column(0).visible( false );
   	}
   	function mostrarcolumna(){
   		var table = $('#tbl_detalle').DataTable();
   	    
   	   	table.columns( [ 0, 1, 2, 3] ).visible( true, true );
   	}
   	
   	
   	
   	
    
    $(document).ready(function() {
    	
    	
    	var mensaje = 0;
 	    mensaje = "<%=VarMsj %>";

 	    if(mensaje == "1")
 	      {
 	    	successAlert('Exito', 'Los datos han sido registrados exitosamente!');
 	      }
 	    if(mensaje == "2")
 	      {
 	        errorAlert('Error', 'No se han podido registrar los datos, intente de nuevo.');
 	      }
 	   if(mensaje == "3")
	      {
	        errorAlert('Error', 'Usted ya est� inscrito en este curso.');
	      }
    	
        $('#tbl_detalle').DataTable( {
        	createdRow: function(row, data, index) {
        		 
                // Updated Schedule Week 1 - 07 Mar 22
         
                 if ( row.id == "existe" ) {
                	 $('td:eq(0)', row).css('background-color', 'lightgreen');
                	 $('td:eq(1)', row).css('background-color', 'lightgreen');
                	 $('td:eq(2)', row).css('background-color', 'lightgreen');
                	 $('td:eq(3)', row).css('background-color', 'lightgreen');
                	 $('td:eq(4)', row).css('background-color', 'lightgreen');
                  	 $('td:eq(5)', row).css('background-color', 'lightgreen');
                  	$('td:eq(6)', row).css('background-color', 'lightgreen');
               		 $('td:eq(7)', row).css('background-color', 'lightgreen');
               		 $('td:eq(8)', row).css('background-color', 'lightgreen');
               	 	
                 	 
                 }
        },
        	buttons: [  
        				
		        		{
			        		extend: 'csv',
							text: 'CSV',
							title: 'Capacitaciones registradas',
							action: function ( e, dt, node, config ) {
			                    //alert( 'Activated!' );
			                    eliminarcolumna(3);
			                    $.fn.dataTable.ext.buttons.csvHtml5.action.call(this, e, dt, node, config);
			                },
							exportOptions: {
				                columns: ':visible',
				            }
		        		},
        				{
        					extend: 'excel',
        					text: 'Excel',
        					title: 'Capacitaciones registradas',
        					action: function ( e, dt, node, config ) {
        	                    //alert( 'Activated!' );
        	                    eliminarcolumna(3);
        	                    $.fn.dataTable.ext.buttons.excelHtml5.action.call(this, e, dt, node, config);
        	                },
        					exportOptions: {
        		                columns: ':visible',
        		            }
        				},
        				
        				{
        					extend: 'pdf',
        					text: 'PDF',
        					title: 'Capacitaciones registradas',
        					action: function ( e, dt, node, config ) {
        	                    //alert( 'Activated!' );
        	                    eliminarcolumna(3);
        	                    $.fn.dataTable.ext.buttons.pdfHtml5.action.call(this, e, dt, node, config);
        	                },
        					exportOptions: {
        		                columns: ':visible',
        		            }
        				},
      
        				{ 
        					extend: 'print',
        					text: 'Imprimir',
        					title: 'Capacitaciones registradas',
        					action: function ( e, dt, node, config ) {
        	                    //alert( 'Activated!' );
        	                    eliminarcolumna(3);
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
                "emptyTable": "No existen capacitaciones ofertadas en esta convocatoria todav�a",
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