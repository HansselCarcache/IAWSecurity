<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="entidades.*, datos.*, java.util.*;"%>

<!DOCTYPE html>
<html>
<%
ArrayList<ArrayList<String>> listas = new ArrayList<ArrayList<String>>();
	
	ArrayList<String> lista1 = new ArrayList<String>();
	lista1.add("a");
	lista1.add("b");
	lista1.add("c");
	
	ArrayList<String> lista2 = new ArrayList<String>();
	lista2.add("d");
	lista2.add("e");
	lista2.add("f");
	
	ArrayList<String> lista3 = new ArrayList<String>();
	
	listas.add(lista1);
	listas.add(lista2);
	listas.add(lista3);
	
	
	int usuario = 2; 
%>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <!-- Meta, title, CSS, favicons, etc. -->
    <meta charset="ISO-8859-1">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Evaluacion</title>

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

           <%@include file="diseño.jsp"%>

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
                    
                    <div class="clearfix"></div>
                  </div>
                  <div class="x_content">
                      <div class="row">
                          <div class="col-sm-12">
                            <div class="card-box table-responsive">
                           
                            
                    
                    <table id="tbl_Evaluacion" class="table table-striped table-bordered" style="width:100%">
                    
                     <%
                      		ArrayList<Vw_evaluacion> listInc = new ArrayList<Vw_evaluacion>();
                      		String cedula="";
                      		Dt_evaluacion dtins = new Dt_evaluacion();
                      		
                      		cedula = dtins.getCedula(usuario);
                      		listInc = dtins.listaInscripActivo(cedula);
                      %>
                      
                    
                    
                      <thead>
                        <tr>
                          <th>Estudiante docente</th>
                          <th>Convocatoria</th>
                          <th>Capacitacion</th>
                          <th>Tipo Calificacion</th>
                          <th>Valor</th>
                          <th>Calificacion</th>
                        </tr>
                      </thead>
                      <tbody>
	                     <%
	                      	for(Vw_evaluacion ins : listInc){
	                      %>
                      
                           
                          <tr>
                        <td><%=ins.getEstudiante() %></td>
                        <td><%=ins.getConvocatoria() %></td>
                        <td><%=ins.getCapacitacion() %></td>
                         <%
                        	if(ins.getTipo_calificacion() == null){
                        		ins.setTipo_calificacion("---");
                        	}
                         
                         	if(ins.getValor1()== null){
                     			ins.setValor1("---");
                     		}
                        	
                        %>
                        <td><%=ins.getTipo_calificacion() %></td>
                       
                        <td><%=ins.getValor1() %></td>
                        <td>
							<a data-toggle="modal" data-target=".bs-example-modal-lg" target="blank"><i class="fa fa-2x fa-check" title="Evaluar Docente"></i></a>
							<div class="modal fade bs-example-modal-lg" tabindex="-1" role="dialog" aria-hidden="true">
		                      <div class="modal-dialog modal-lg">
		                        <div class="modal-content">
		
		                        <div class="modal-header">
		                          <h4 class="modal-title" id="myModalLabel">Evaluacion</h4>
		                          <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">×</span>
		                          </button>
		                        </div>
		                        
		                        
		                        	<div class="col-md-12 col-sm-12">
		                        		
										<form class="" action="" method="post" novalidate>
<!--                                         <p>For alternative validation library <code>parsleyJS</code> check out in the <a href="form.html">form page</a> -->
<!--                                         </p> -->
<!--                                         <span class="section">Personal Info</span> -->
										<div class="modal-body">
										<div class="field item form-group">
                                            <label class="col-form-label col-md-3 col-sm-3  label-align">Tipo de Calificación: <span class="required">*</span></label>
                                            <div class="col-md-6 col-sm-6">
<!--                                            <input class="form-control" data-validate-length-range="6" data-validate-words="2" name="name" placeholder="ex. John f. Kennedy" required="required" /> -->
<%-- <%-- 												<% --%> 
<!-- // 							                      	ArrayList<Tbl_user> listaUsuario = new ArrayList<Tbl_user>(); -->
<!-- // 							                      	Dt_usuario dtu = new Dt_usuario(); -->
<!-- // 							                      	listaUsuario = dtu.listaUserActivos(); -->
<!-- // 							                      	//onChange="mostrar_cualitativa()"  -->
<%-- <%-- 								                 %> --%> 
												<select onchange="mostrar_cualitativa()" class="form-control js-example-basic-single" name="cbxUser" id="tipo_cal" required="required">
												  <option value="0">Seleccione...</option>
												  <option value="1">Cuantitativa</option>
												  <option value="2">Cualitativa</option>
												  <option value="3">Semi</option>
												 
												  
												  
												</select>
                                            </div>
                                        </div>
										
										
                                        <div style="display:none;" class="field item form-group" id="ev_cualitativa">
                                            <label class="col-form-label col-md-3 col-sm-3  label-align">Calificación Cualitativa: <span class="required">*</span></label>
                                            <div class="col-md-6 col-sm-6">
<!--                                                 <input class="form-control" class='optional' name="occupation" data-validate-length-range="5,15" type="text" /></div> -->
								                 <select  class="form-control js-example-basic-single" name="t_cual" id="t_cual" required="required">
												</select>
											</div>
                                        </div>
                                        
                                        <div style="display:none;" class="item form-group" id="ev_cuantitativa">
											<label for="middle-name" class="col-form-label col-md-3 col-sm-3 label-align">Calificación</label>
											<div class="col-md-6 col-sm-6 ">
												<input id="calificacion" class="form-control" type="text" name="calificacion">
											</div>
										</div>
                                        
                                        </div>

                                        <div class="modal-footer">
		                          			<button type="button" class="btn btn-primary">Guardar Cambios</button>
		                      			</div>
                                        
                                    </form>                     	
		                        	</div>
		                        </div>
		                       
		
		                      	</div>
		                     </div>
		                   
						</td>
                        </tr>
                        <%}%>
                      </tbody>
                      <tfoot>
                        <tr>
                          <th>Estudiante docente</th>
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
     <!-- Select2 -->
    <script src="../vendors/select2/dist/js/select2.min.js"></script>
         <script>
         
   	function eliminarcolumna(id){
   		var table = $('#tbl_Evaluacion').DataTable();
   	 
   		table.column( id).visible( false );
   	}
   	function mostrarcolumna(){
   		var table = $('#tbl_Evaluacion').DataTable();
   	    
   	   	table.columns( [ 0, 1, 2, 3, 4, 5, 6, 7, 8 ] ).visible( true, true );
   	}
   	
   	function mostrar_cualitativa(){
   		var $select = document.getElementById('t_cual');
   		//$select.empty();
   		var cuali = document.getElementById('ev_cualitativa');
   		var cuanti = document.getElementById('ev_cuantitativa');
   		
   		var id = $("#tipo_cal :selected").val()
   		
   		if(id == 0)
   		{
			if (cuanti.style.display === "block") {
	   	   	   	cuanti.style.display = "none";
	   	   }
	   			
	   		if (cuali.style.display === "block") 
	   		{
	   	   	  	cuali.style.display = "none";
	   	   	}
		}
   		
   		
   		if(id != 1 && id !=0)
   		{
   	//		$select.empty();
   			
   			if(id==2){
   				$('#t_cual').empty();
   				<%
   	   			for(String as: lista1){
   	   			%>
   	   				$('#t_cual').append($('<option>', {
   	   	    			value: 1,
   	   	    			text: '<%=as%>'
   	   				}));
   	   				
   	   			<%}%>	
   			}
   			
   			if(id==3){
   				$('#t_cual').empty();
   				<%
   	   			for(String as: lista2){
   	   			%>
   	   				
   	   				$('#t_cual').append($('<option>', {
	   	    			value: 1,
	   	    			text: '<%=as%>'
	   				}));
   	   			<%}%>	
   			}
   			
   			if (cuali.style.display === "none") 
   			{
   	   	    	cuali.style.display = "block";
   	   	    }
   			
   			if (cuanti.style.display === "block") 
   			{
   	   	    	cuanti.style.display = "none";
   	   	    }
   		}

		if(id==1)
   		{
//    			$select.empty();
   			if (cuanti.style.display === "none") {
   	   	    	cuanti.style.display = "block";
   	   	    }
   			
   			if (cuali.style.display === "block") 
   			{
   	   	    	cuali.style.display = "none";
   	   	    }
   		}
   	    
   	}
   	
   	
    
    $(document).ready(function() {
    	
        $('#tbl_Evaluacion').DataTable( {
        	buttons: [  
        				
		        		{
			        		extend: 'csv',
							text: 'CSV',
							title: 'Evaluaciones',
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
        					title: 'Evaluaciones',
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
        					title: 'Evaluaciones',
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
        					title: 'Evaluaciones',
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