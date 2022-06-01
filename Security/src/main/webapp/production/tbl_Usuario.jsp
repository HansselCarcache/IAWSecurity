<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="entidades.Tbl_user, entidades.Vw_userrol,
     entidades.Vw_rolopcion, datos.Dt_usuario, datos.Dt_usuario2,datos.Dt_rolopciones, java.util.*" %>
    

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

    <title>Seguridad | Usuarios</title>

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
              <a href="Inicio.jsp" class="site_title"> <i class="fa-solid fa-book"></i><span> Formación Docente</span></a>
            </div>

            <div class="clearfix"></div>

           <%@include file="diseño.jsp"%>

        <!-- page content -->
        <div class="right_col" role="main">
          <div class="">
            <div class="page-title">
              <div class="title_left">
                <h3>Usuarios </h3>
              </div>


            </div>

            <div class="clearfix"></div>

            <div id="divtabla1" style="display:block;" class="row">
              <div class="col-md-12 col-sm-12 ">
                <div class="x_panel">
                  <div class="x_title">
                    <h2>Usuarios registrados</h2>
                    <ul class="nav navbar-right panel_toolbox">
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" onclick="usuariosEliminados()" data-toggle="dropdown" role="button" aria-expanded="false">Ver usuarios Inactivos <i class="fa-solid fa-user-large-slash"></i></a>
                        
                      </li>
                      <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
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
                            <a href="addUsuario.jsp">
                            	<i class="fa fa-plus-square"></i> Nuevo usuario</a>
                            	<br><br>
                            </div>
                            
                    
                    <table id="tbl_user" class="table table-striped table-bordered" style="width:100%">
                     <%
                      		ArrayList<Tbl_user> listaUsuario = new ArrayList<Tbl_user>();
                      		Dt_usuario dtusr = new Dt_usuario();
                      		listaUsuario = dtusr.listaUserActivos();
                      %>
                    
                      <thead>
                        <tr>
                          
                          <th>ID Uca <a onclick="eliminarcolumna(0)"><i class="fa-solid fa-circle-minus"></i></a></th>
                          <th>Nombre usuario <a onclick="eliminarcolumna(1)"><i class="fa-solid fa-circle-minus"></i></a></th>
                          <th>Nombre completo <a onclick="eliminarcolumna(2)"><i class="fa-solid fa-circle-minus"></i></a></th>
                          <th>Sexo <a onclick="eliminarcolumna(3)"><i class="fa-solid fa-circle-minus"></i></a></th>
                          <th>Telefono <a onclick="eliminarcolumna(4)"><i class="fa-solid fa-circle-minus"></i></a></th>
                          <th>Cargo <a onclick="eliminarcolumna(5)"><i class="fa-solid fa-circle-minus"></i></a></th>
                          <th>Correo personal <a onclick="eliminarcolumna(6)"><i class="fa-solid fa-circle-minus"></i></a></th>
                          <th>Cédula <a onclick="eliminarcolumna(7)"><i class="fa-solid fa-circle-minus"></i></a></th>
                          <th>Estado <a onclick="eliminarcolumna(8)"><i class="fa-solid fa-circle-minus"></i></a></th>
                          <th>Acciones <a onclick="eliminarcolumna(9)"><i class="fa-solid fa-circle-minus"></i></a></th>
                          
                          
                        </tr>
                      </thead>


                      <tbody>
                     	<%
	                      	for(Tbl_user tusr :listaUsuario){
	                      		String estado= "";
	                      		if(tusr.getEstado()==0){
	                      			estado= "No verificado";
	                      		}else if(tusr.getEstado()!=3){
	                      			estado = "Activo";
	                      		}else{
	                      			estado = "Inactivo";
	                      		}
	                      		String sexo="";
	                      		if(tusr.getSexo()==1){
	                      			sexo="Masculino";
	                      		}else if(tusr.getSexo()==2){
	                      			sexo="Femenino";
	                      		}
	                      		String iduca = "";
	                      		if(tusr.getId_uca()==null){
	                      			iduca = "";
	                      		}else{
	                      			iduca=tusr.getId_uca();
	                      		}
	                      %>
                      	
                      
                        <tr>
                          
                          <td><%=iduca %></td>
                          <td><%=tusr.getNombre_usuario() %></td>
                          <td><%=tusr.getNombre_real()%></td>
                          <td><%=sexo %></td>
                          <td><%=tusr.getTelefono_contacto() %></td>
                          <td><%=tusr.getCargo() %></td>
                          <td><%=tusr.getCorreo_personal() %></td>
                          <td><%=tusr.getCedula() %></td>
                          <td><%=estado %></td>
                          <td>
                           <a href="updateUsuario.jsp?idU=<%=tusr.getId_usuario()%>">
                            <i class="far fa-edit" title="Editar Usuario"></i>
                          </a>
                          &nbsp;
                           <a href="addFotoUsuario.jsp?idU=<%=tusr.getId_usuario()%>">
                            <i class="fa fa-camera" title="Agregar Foto de Usuario"></i>
                          </a>
                          &nbsp;
                          <a href="readUsuario.jsp?idU=<%=tusr.getId_usuario()%>">
                            <i class="far fa-eye" title="Visualizar Usuario"></i>
                          </a> 
                          &nbsp;
                          <a href="deleteUsuario.jsp?idU=<%=tusr.getId_usuario() %>" >
                            <i class="far fa-trash-alt" title="Eliminar Usuario"></i>
                          </a>
                          </td>
                          
                          
                        </tr>
                        <%
                        }
                        %>
                        
                        
                        
                      </tbody>
                      <tfoot>
                        <tr>
                          
                          <th>ID Uca</th>
                          <th>Nombre usuario</th>
                          <th>Nombre completo</th>
                          <th>Sexo</th>
                          <th>Telefono</th>
                          <th>Cargo</th>
                          <th>Correo personal</th>
                          <th>Cédula</th>
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
              
              <!-- INICIO DE LA SEGUNDA TABLA -->
              <div id="divtabla2" style="display:none;" class="row">
              <div class="col-md-12 col-sm-12 ">
                <div class="x_panel">
                  <div class="x_title">
                    <h2>Usuarios Inactivos</h2>
                    <ul class="nav navbar-right panel_toolbox">
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" onclick="usuariosActivos()" data-toggle="dropdown" role="button" aria-expanded="false">Ver usuarios Activos <i class="fa-solid fa-user-check"></i></a>
                      </li>
                      <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
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
                            
                            
                    
                    <table id="tbl_user2" class="table table-striped table-bordered" style="width:100%">
                     <%
                      		ArrayList<Tbl_user> listaUsuarioInactivos = new ArrayList<Tbl_user>();
                      		
                      		listaUsuarioInactivos = dtusr.listaUserInactivos();
                      %>
                    
                      <thead>
                        <tr>
                          
                          <th>ID Uca </th>
                          <th>Nombre usuario </th>
                          <th>Nombre completo </th>
                          <th>Sexo </th>
                          <th>Telefono </th>
                          <th>Cargo </th>
                          <th>Correo personal </th>
                          <th>Cédula </th>
                          <th>Estado </th>
                          <th>Acciones </th>
                          
                          
                        </tr>
                      </thead>


                      <tbody>
                     	<%
	                      	for(Tbl_user tusr :listaUsuarioInactivos){
	                      		String estado= "";
	                      		if(tusr.getEstado()!=3){
	                      			estado= "Activo";
	                      		}
	                      		else{
	                      			estado = "Inactivo";
	                      		}
	                      		String sexo="";
	                      		if(tusr.getSexo()==1){
	                      			sexo="Masculino";
	                      		}else if(tusr.getSexo()==2){
	                      			sexo="Femenino";
	                      		}
	                      		String iduca = "";
	                      		if(tusr.getId_uca()==null){
	                      			iduca = "";
	                      		}else{
	                      			iduca=tusr.getId_uca();
	                      		}
	                      %>
                      	
                      
                        <tr>
                          
                          <td><%=iduca %></td>
                          <td><%=tusr.getNombre_usuario() %></td>
                          <td><%=tusr.getNombre_real()%></td>
                          <td><%=sexo %></td>
                          <td><%=tusr.getTelefono_contacto() %></td>
                          <td><%=tusr.getCargo() %></td>
                          <td><%=tusr.getCorreo_personal() %></td>
                          <td><%=tusr.getCedula() %></td>
                          <td><%=estado %></td>
                          <td>
                           <a href="restaurarUsuario.jsp?idU=<%=tusr.getId_usuario()%>">
                            <i class="fa-solid fa-arrow-rotate-left" title="Restaurar Usuario"></i>
                          </td>
                          
                          
                        </tr>
                        <%
                        }
                        %>
                        
                        
                        
                      </tbody>
                      <tfoot>
                        <tr>
                          
                          <th>ID Uca</th>
                          <th>Nombre usuario</th>
                          <th>Nombre completo</th>
                          <th>Sexo</th>
                          <th>Telefono</th>
                          <th>Cargo</th>
                          <th>Correo personal</th>
                          <th>Cédula</th>
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
    
    <!-- JAlert js -->
	<script src="../vendors/jAlert/dist/jAlert.min.js"></script>
	<script src="../vendors/jAlert/dist/jAlert-functions.min.js"></script>

    <!-- Custom Theme Scripts -->
    <script src="../build/js/custom.min.js"></script>
    
     <script>
   	function eliminarcolumna(id){
   		var table = $('#tbl_user').DataTable();
   	 
   		table.column( id).visible( false );
   	}
   	function mostrarcolumna(){
   		var table = $('#tbl_user').DataTable();
   	    
   	   	table.columns( [ 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 ] ).visible( true, true );
   	}
   	
   	
   	
   	function usuariosEliminados(){
   		document.getElementById("divtabla1").style.display = "none";
   		document.getElementById("divtabla2").style.display = "flex";
   	}
   	
   	function usuariosActivos(){
   		document.getElementById("divtabla1").style.display = "flex";
   		document.getElementById("divtabla2").style.display = "none";
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
 	        successAlert('Exito', 'Los datos han sido modificados exitosamente!');
 	      }
 	      if(mensaje == "4")
 	      {
 	    	  errorAlert('Error', 'No se han podido modificar los datos, intente de nuevo');
 	      }
 	      if(mensaje == "5")
 	      {
 	        successAlert('Exito', 'Los datos han sido eliminados exitosamente!');
 	      }
 	      if(mensaje == "6")
 	      {
 	        errorAlert('Error', 'No se han podido eliminar los datos, intente de nuevo');
 	      }
 	      if(mensaje == "7")
	      {
 	    	successAlert('Exito', 'Los datos han sido modificados exitosamente. El IDUCA ya existía en el sistema y no fue modificado.');
	      }
 	      if(mensaje == "8")
	      {
	    	successAlert('Exito', 'El usuario fue restaurado con éxito');
	      }
 	      if(mensaje == "9")
	      {
	        errorAlert('Error', 'No se ha podido restaurar el usuario. Intente de nuevo.');
	      }
 	     if(mensaje == "10")
	      {
	    	successAlert('Exito', 'La foto fue subida con éxito');
	      }
	      if(mensaje == "11")
	      {
	        errorAlert('Error', 'No se ha podido subir la foto. Intente de nuevo.');
	      }
    	
        $('#tbl_user').DataTable( {
        	buttons: [  
        				
		        		{
			        		extend: 'csv',
							text: 'CSV',
							title: 'Usuarios registrados',
							action: function ( e, dt, node, config ) {
			                    //alert( 'Activated!' );
			                    eliminarcolumna(9);
			                    $.fn.dataTable.ext.buttons.csvHtml5.action.call(this, e, dt, node, config);
			                },
							exportOptions: {
				                columns: ':visible',
				            }
		        		},
        				{
        					extend: 'excel',
        					text: 'Excel',
        					title: 'Usuarios registrados',
        					action: function ( e, dt, node, config ) {
        	                    //alert( 'Activated!' );
        	                    eliminarcolumna(9);
        	                    $.fn.dataTable.ext.buttons.excelHtml5.action.call(this, e, dt, node, config);
        	                },
        					exportOptions: {
        		                columns: ':visible',
        		            }
        				},
        				
        				{
        					extend: 'pdf',
        					text: 'PDF',
        					title: 'Usuarios registrados',
        					action: function ( e, dt, node, config ) {
        	                    //alert( 'Activated!' );
        	                    eliminarcolumna(9);
        	                    $.fn.dataTable.ext.buttons.pdfHtml5.action.call(this, e, dt, node, config);
        	                },
        					exportOptions: {
        		                columns: ':visible',
        		            }
        				},
      
        				{ 
        					extend: 'print',
        					text: 'Imprimir',
        					title: 'Usuarios registrados',
        					action: function ( e, dt, node, config ) {
        	                    //alert( 'Activated!' );
        	                    eliminarcolumna(9);
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
        //Inicio de segunda tabla
        $('#tbl_user2').DataTable( {
        	buttons: [  
        				
		        		{
			        		extend: 'csv',
							text: 'CSV',
							title: 'Usuarios registrados',
							action: function ( e, dt, node, config ) {
			                    //alert( 'Activated!' );
			                    eliminarcolumna(9);
			                    $.fn.dataTable.ext.buttons.csvHtml5.action.call(this, e, dt, node, config);
			                },
							exportOptions: {
				                columns: ':visible',
				            }
		        		},
        				{
        					extend: 'excel',
        					text: 'Excel',
        					title: 'Usuarios registrados',
        					action: function ( e, dt, node, config ) {
        	                    //alert( 'Activated!' );
        	                    eliminarcolumna(9);
        	                    $.fn.dataTable.ext.buttons.excelHtml5.action.call(this, e, dt, node, config);
        	                },
        					exportOptions: {
        		                columns: ':visible',
        		            }
        				},
        				
        				{
        					extend: 'pdf',
        					text: 'PDF',
        					title: 'Usuarios registrados',
        					action: function ( e, dt, node, config ) {
        	                    //alert( 'Activated!' );
        	                    eliminarcolumna(9);
        	                    $.fn.dataTable.ext.buttons.pdfHtml5.action.call(this, e, dt, node, config);
        	                },
        					exportOptions: {
        		                columns: ':visible',
        		            }
        				},
      
        				{ 
        					extend: 'print',
        					text: 'Imprimir',
        					title: 'Usuarios registrados',
        					action: function ( e, dt, node, config ) {
        	                    //alert( 'Activated!' );
        	                    eliminarcolumna(9);
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