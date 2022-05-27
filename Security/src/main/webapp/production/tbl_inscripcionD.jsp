<%@page import="entidades.Vw_inscripcion_docente"%>
<%@page import="entidades.Vw_rolopcion"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="entidades.*, datos.*, java.util.*"%>
    
    <%
String VarMsj = "";

VarMsj = request.getParameter("msj")==null?"0":request.getParameter("msj");


%>

<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <!-- Meta, title, CSS, favicons, etc. -->
    <meta charset="ISO-8859-1">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Inscripciones | Inscripcion</title>

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
                <h3>Inscripciones </h3>
              </div>
            </div>

            <div class="clearfix"></div>

            <div class="row">
              <div class="col-md-12 col-sm-12 ">
                <div class="x_panel">
                  <div class="x_title">
                    <h2>Mis inscripciones</h2>
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
                  
                    <div class="text-muted font-13 col-md-12" style="text-align: right;">
                             <a class="col-md-1" href="#" onclick="mostrarcolumna()"><i class="fa-solid fa-arrow-rotate-left"></i>Cargar</a>
                                  <input type="hidden" value="<%=vwur.getId_usuario() %>" name="Id de usuario" id="idU" />
                            <a href="../Sl_rpt_calificacion?idI=<%=vwur.getId_usuario() %>"  target="_blank">
                            <i class="fa-solid fa-book-open" title=" reporte de calificaciones"></i>
                          </a>
                          <a href="../Sl_rpt_inscripcion?idI=<%=vwur.getId_usuario() %>" target="_blank">
                            <i class="fa-solid fa-print" title=" reporte de inscripcion"></i>
                          </a>
                            	<br><br>
                            </div>
                  
                
                  

                            
                    <table id="tbl_inscr" class="table table-striped table-bordered" style="width:100%">
                    
                    <%
                    ArrayList<Vw_inscripcion_docente> listaInsc = new ArrayList<Vw_inscripcion_docente>();
              		Dt_inscripcionDocente dtinsc = new Dt_inscripcionDocente();
              		listaInsc = dtinsc.listainscripcionPersonal(vwur.getId_usuario());
                      %>
                    
                      <thead>
                        <tr>
                          
                          <th>Capacitacion </th>
                          <th>Fecha Inicio </th>
                          <th>Fecha Final</th>
                          <th>D�as </th>
                          <th>Valor </th>
                          <th>Descripci�n valor </th>
                          <th>Eliminar </th>
                          
                        </tr>
                      </thead>


                      <tbody>
                     	<%
	                      	for(Vw_inscripcion_docente ins :listaInsc){
	                      		String valor = "";
	                      		if(ins.getValor()==null){
	                      			valor = "";
	                      		}else{
	                      			valor=ins.getValor();
	                      		}
	                      		String desc_valor = "";
	                      		if(ins.getDesc_valor()==null){
	                      			desc_valor = "";
	                      		}else{
	                      			desc_valor=ins.getDesc_valor();
	                      		}
	                      		
	                      %>
                      	
                      
                        <tr>
                          <td><%=ins.getCapacitacion()%></td>
                          
                          <td><%=ins.getFecha_inicial()%></td>
                          
                          <td><%=ins.getFecha_final() %></td>
                          
                          <td><%=ins.getDias() %></td>
                          
                          <td><%=valor %></td>
                          
                          <td><%=desc_valor %></td>
                          <td>
                          
<!--                           <a href="readInscripcion.jsp"> -->
<!--                             <i class="far fa-eye" title="Visualizar Opciones"></i> -->
<!--                           </a>  -->
<!--                           &nbsp;&nbsp; -->
                          <a href="deleteInscripcionD.jsp?idI=<%=ins.getId_inscripcion() %>" >
                            <i class="far fa-trash-alt" title="Eliminar Opciones"></i>  
                          </a>
                          </td>
                          
                          
                        </tr>
                        <%
                        }
                        %>
                        
                        
                      </tbody>
                      <tfoot>
                        <tr>
                          
                         <th>Capacitacion </th>
                          <th>Fecha Inicio </th>
                          <th>Fecha Final</th>
                          <th>D�as </th>
                          <th>Valor </th>
                          <th>Descripci�n valor </th>
                          <th>Eliminar </th>
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
    
     <!-- JAlert js -->
	<script src="../vendors/jAlert/dist/jAlert.min.js"></script>
	<script src="../vendors/jAlert/dist/jAlert-functions.min.js"></script>

    <!-- Custom Theme Scripts -->
    <script src="../build/js/custom.min.js"></script>
    
    <script>
    function printCal(){
    	window.open("../Sl_rpt_calificacion", '_blank');
    }
    </script>
    
     <script>
     function eliminarcolumna(id){
    		var table = $('#tbl_inscr').DataTable();
    	 
    		table.column( id).visible( false );
    	}
    	function mostrarcolumna(){
    		var table = $('#tbl_inscr').DataTable();
    	    
    	   	table.columns( [ 0, 1, 2, 3, 4, 5, 6 ] ).visible( true, true );
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
	    	successAlert('Exito', 'Los datos de inscripcion han sido eliminados exitosamente!');
	      }
	    if(mensaje == "4")
	      {
	        errorAlert('Error', 'No se han podido eliminar los datos de inscripcion, intente de nuevo.');
	      }
	    
         $('#tbl_inscr').DataTable( {
         	buttons: [  
         				
 		        		{
 			        		extend: 'csv',
 							text: 'CSV',
 							title: 'Inscripciones registradas',
 							action: function ( e, dt, node, config ) {
 			                    //alert( 'Activated!' );
 			                    eliminarcolumna(6);
 			                    $.fn.dataTable.ext.buttons.csvHtml5.action.call(this, e, dt, node, config);
 			                },
 							exportOptions: {
 				                columns: ':visible',
 				            }
 		        		},
         				{
         					extend: 'excel',
         					text: 'Excel',
         					title: 'Inscripciones registradas',
         					action: function ( e, dt, node, config ) {
         	                    //alert( 'Activated!' );
         	                    eliminarcolumna(6);
         	                    $.fn.dataTable.ext.buttons.excelHtml5.action.call(this, e, dt, node, config);
         	                },
         					exportOptions: {
         		                columns: ':visible',
         		            }
         				},
         				
         				{
         					extend: 'pdf',
         					text: 'PDF',
         					title: 'Inscripciones registradas',
         					action: function ( e, dt, node, config ) {
         	                    //alert( 'Activated!' );
         	                    eliminarcolumna(6);
         	                    $.fn.dataTable.ext.buttons.pdfHtml5.action.call(this, e, dt, node, config);
         	                },
         					exportOptions: {
         		                columns: ':visible',
         		            }
         				},
       
         				{ 
         					extend: 'print',
         					text: 'Imprimir',
         					title: 'Inscripciones registradas',
         					action: function ( e, dt, node, config ) {
         	                    //alert( 'Activated!' );
         	                    eliminarcolumna(6);
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
                 "info": "Mostrando p�gina _PAGE_ de _PAGES_",
                 
                 "infoEmpty": "No existe registro",
                 "infoFiltered": "(filtered from _MAX_ total records)"
             }
         } );
     } );
    
    </script>

  </body>
</html>