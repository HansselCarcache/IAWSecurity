<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="entidades.*, datos.*, java.util.*"%>

<!DOCTYPE html>
<html>
<%
//CONSTRUCTOR DE OBJETOS
	Dt_evaluacion dte = new Dt_evaluacion();
	Dt_escalacalificacion des = new Dt_escalacalificacion();

	ArrayList<Tbl_escalaCalificacion> liste =  new ArrayList<Tbl_escalaCalificacion>();


	liste=des.listaEscalaActivo();
	
	String msj="";
	msj = request.getParameter("msj") == null ? "0" : request.getParameter("msj");	
	
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
              <a href="Inicio.jsp" class="site_title"> <i class="fa-solid fa-book"></i><span>Evaluacion Docente</span></a>
            </div>

            <div class="clearfix"></div>

           <%@include file="diseñoFacilitador.jsp"%>

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
                     		int usuario = vwur.getId_usuario(); 
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
                       
                        <td><%=ins.getValorIns()%><br>///////<br><%=ins.getDescIns()%></td>
                        <td>
							<a data-toggle="modal" data-target=".bs-example-modal-lg<%=ins.getId_inscripcion() %>" target="blank"><i class="fa fa-2x fa-check" title="Evaluar Docente"></i></a>
							<div class="modal fade bs-example-modal-lg<%=ins.getId_inscripcion() %>" tabindex="-1" role="dialog" aria-hidden="true">
		                      <div class="modal-dialog modal-lg">
		                        <div class="modal-content">
		
		                        <div class="modal-header">
		                          <h4 class="modal-title" id="myModalLabel">Evaluacion a <%=ins.getEstudiante() %></h4>
		                          <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">×</span>
		                          </button>
		                        </div>
		                        
		                        
		                        	<div class="col-md-12 col-sm-12">
		                        		
										<form class="" action="../Sl_Evaluacion" method="post" novalidate>
											<input id="opcion" type="hidden" name="opcion" value="1">
											<input style="display:none;" id="respuesta<%=ins.getId_inscripcion() %>" type="text" name="respuesta<%=ins.getId_inscripcion() %>">
											<input id="id" class="form-control" value="<%=ins.getId_inscripcion() %>" type="hidden" name="id">
											<select style="display:none;" class="form-control js-example-basic-single" name="descr" id="descr<%=ins.getId_inscripcion() %>" required="required">
											</select>
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
														<select onchange="recargarLista(<%=ins.getId_inscripcion() %>)" class="form-control js-example-basic-single" name="tipo_cal<%=ins.getId_inscripcion() %>" id="tipo_cal<%=ins.getId_inscripcion() %>" required="required">
														  <option value="0">Seleccione...</option>
														  
														  <%for(Tbl_escalaCalificacion ec:liste){ %>
														  		<option value="<%=ec.getId_escala()%>"><%=ec.getTipo_calificacion() %></option>
														  <%} %>
														</select>
		                                            </div>
		                                        </div>
												
													
												<div>
												<div style="display:none;" id="ev_cualitativa<%=ins.getId_inscripcion() %>">		
			                                        <div  class=" item form-group" >
			                                            <label class="col-form-label col-md-3 col-sm-3  label-align">Calificación Cualitativa: <span class="required">*</span></label>
			                                            <div class="col-md-6 col-sm-6">
			<!--                                                 <input class="form-control" class='optional' name="occupation" data-validate-length-range="5,15" type="text" /></div> -->
											                 <select onchange="init(<%=ins.getId_inscripcion() %>)" class="form-control js-example-basic-single" name="t_cual<%=ins.getId_inscripcion() %>" id="t_cual<%=ins.getId_inscripcion() %>" required="required">
															</select>
															
															<input id="valor<%=ins.getId_inscripcion() %>" type="hidden" name="valor<%=ins.getId_inscripcion() %>">
															
														</div>
														
														
			                                        </div>
			                                        
			                                       
		                                        </div>
		                                        <div style="display:none;" id="ev_cuantitativa<%=ins.getId_inscripcion() %>">
			                                        <div class="item form-group" >
														
															<label for="middle-name" class="col-form-label col-md-3 col-sm-3 label-align">Calificación</label>
														<div class="col-md-6 col-sm-6 ">
															<input id="calificacion<%=ins.getId_inscripcion() %>" class="form-control" type="number" name="calificacion<%=ins.getId_inscripcion() %>">
														</div>
														
														
													</div>
												</div>
												<div style="display:none;" class="field item form-group" id="div_descripcion<%=ins.getId_inscripcion() %>">
			                                        <label for="middle-name" class="col-form-label col-md-3 col-sm-3 label-align">Descripcion:</label>
													<div class="col-md-6 col-sm-6 ">
														<input id="descripcion<%=ins.getId_inscripcion() %>" class="form-control" type="text" name="descripcion<%=ins.getId_inscripcion() %>">
													</div>
															
														
												</div>
	                                        </div>
	                                        </div>
	
	                                        <div class="modal-footer">
			                          			<button type="submit" class="btn btn-primary">Guardar Cambios</button>
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
                          <th>Convocatoria</th>
                          <th>Capacitacion</th>
                          <th>Tipo Calificacion</th>
                          <th>Valor</th>
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
    
     <!-- PNotify -->
    <script src="../vendors/pnotify/dist/pnotify.js"></script>
    <script src="../vendors/pnotify/dist/pnotify.buttons.js"></script>
    <script src="../vendors/pnotify/dist/pnotify.nonblock.js"></script>
     
     <script>
         
   	function eliminarcolumna(id){
   		var table = $('#tbl_Evaluacion').DataTable();
   	 
   		table.column( id).visible( false );
   	}
   	function mostrarcolumna(){
   		var table = $('#tbl_Evaluacion').DataTable();
   	    
   	   	table.columns( [ 0, 1, 2, 3, 4, 5, 6, 7, 8 ] ).visible( true, true );
   	}
   	
   	function init(x){
   		var desc_div = document.getElementById('div_descripcion'+x);
   		desc_div.style.display ="block";
   		
   		var text =  $("#t_cual"+x+" :selected").text();
   		var id = $("#t_cual"+x+" :selected").val();
   		
   		$("#descr"+x).val(id);
   		$("#valor"+x).val(text);
   		
   		var text2 = $("#descr"+x+" :selected").text();
   		
   		$("#descripcion"+x).val(text2);
   	}
   	
   	
   	
   	function recargarLista(x){
		var $select = document.getElementById('t_cual'+x);
   		
   		var cuali = document.getElementById('ev_cualitativa'+x);
   		var cuanti = document.getElementById('ev_cuantitativa'+x);
   		var desc_div = document.getElementById('div_descripcion'+x);
   		
   		var id = $("#tipo_cal"+x).val();
   		$("#respuesta"+x).val("");
   		$("#descripcion"+x).val("");
   		desc_div.style.display ="none";
   		
   		if(id == 0)
   		{
   			
			if (cuanti.style.display === "block") {
	   	   	   	cuanti.style.display = "none";
	   	   }
	   			
	   		if (cuali.style.display === "block") 
	   		{
	   	   	  	cuali.style.display = "none";
	   	   	}
	   		desc_div.style.display ="none";
		}else{
			
			$.ajax({
	   			type:"POST",
	   			url: "data.jsp",
	   			data:{
	   				idTipo:id
	   			},
	   			success:function(r){
	   				var cadena = "";
	   				$("#respuesta"+x).val(r);
	   				
	   				cadena =$("#respuesta"+x).val(); 
	   				var array = cadena.split("*************");
	   				
	   				if($("#respuesta"+x).val()==""){
	   								
	   					$("#descripcion"+x).val("");
//		    			$select.empty();
			   			if (cuanti.style.display === "none") {
			   	   	    	cuanti.style.display = "block";
			   	   	    }
			   			
			   			if (cuali.style.display === "block") 
			   			{
			   	   	    	cuali.style.display = "none";
			   	   	    }
			   			desc_div.style.display ="block";
	   				}else{
	   					$("#respuesta"+x).val()
	   					$("#t_cual"+x).html(array[0]);
	   	   				$("#descr"+x).html(array[1]);
	   	   				
		   	   			if (cuali.style.display === "none") 
		   	   			{
		   	   	   	    	cuali.style.display = "block";
		   	   	   	    }
		   	   			
		   	   			if (cuanti.style.display === "block") 
		   	   			{
		   	   	   	    	cuanti.style.display = "none";
		   	   	   	    }
	   				}
	   				
	   			},
	   			error:function(){
	   				alert("error");
	   			}
	   		});
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

	<script>
	$(document).ready(function() {
    	try {
    		<% if(msj.equals("1")) {%>
    		new PNotify({
                type: 'success',
                title: 'Evaluacion Completada',
                text: 'Se realizo la evaluación correctamente',
                styling: 'bootstrap3',
                delay: 2000,
                addclass: 'center'
            }); 
        	<%}%>
        	
        	<% if(msj.equals("2")) {%>
    		new PNotify({
                type: 'error',
                title: 'Error',
                text: 'Ha ocurrido un problema, verfique los datos e intente nuevamente',
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