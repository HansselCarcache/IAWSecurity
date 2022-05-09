<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="entidades.Tbl_user, datos.Dt_usuario, datos.Dt_usuario2, java.util.*" %>

<% 
String user = "";
user = request.getParameter("idU")==null?"0":request.getParameter("idU");

Tbl_user tu = new Tbl_user();
Dt_usuario dtu = new Dt_usuario();
tu = dtu.getUserbyID(Integer.parseInt(user));
ArrayList<Tbl_user> listaUser = new ArrayList<Tbl_user>();
listaUser = dtu.listaUserActivos();
// tu = dtu.getUserbyID(12);



%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <!-- Meta, title, CSS, favicons, etc. -->
    <meta charset="ISO-8859-1">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Seguridad | Opciones</title>

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
              <a href="Inicio.jsp" class="site_title"> <i class="fa-solid fa-book"></i><span>Gesti�n Docente</span></a>
            </div>

            <div class="clearfix"></div>

           <%@include file="dise�o.jsp"%>

        <!-- page content -->
        <div class="right_col" role="main">
          <div class="">
            <div class="page-title">
              <div class="title_left">
                <h3>Perfil de Usuario</h3>
              </div>


            </div>

            <div class="clearfix"></div>

            <div id="divtabla1" style="display:block;" class="row">
              <div class="col-md-12 col-sm-12 ">
                <div class="x_panel">
                  <div class="x_title">
                    <h2>Detalles</h2>
                    <ul class="nav navbar-right panel_toolbox">
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false"><i class="fa fa-wrench"></i></a>
                        <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                            <a class="dropdown-item" href="#">Settings 1</a>
                            <a class="dropdown-item" href="#">Settings 2</a>
                            
                          </div>
                      </li>
                      <li><a class="close-link"><i class="fa fa-close"></i></a>
                      </li>
                      
                      <li><a class="close-link"><i class="fa fa-close"></i></a>
                      </li>
                    </ul>
                    <div class="clearfix"></div>
                  </div>
                  <div class="x_content">
                      <div class="row">
                          <div class="col-md-3 col-sm-3  profile_left">
                      <div class="profile_img">
                        <div id="crop-avatar">
                            
                            <!-- Current avatar -->
                          <img style="margin-bottom: -25px" class="img-responsive avatar-view" src="images/userProfile.png" alt="Avatar" title="Change the avatar" width="250xp" height="230xp">
                        </div>
                      </div>
                      
                      <h3><%=tu.getNombre_real()%></h3>
                      
                      <ul class="list-unstyled user_data">
                        
                        <li><i class="fa-solid fa-user"></i> <%=tu.getNombre_usuario()%>
                        </li>
                        
                        <li>
                          <i class="fa fa-briefcase user-profile-icon"></i> <%=tu.getCargo()%>
                        </li>
                        
                        <li><i class="fa-solid fa-envelope"></i> <%=vwur.getNombre_usuario()%>
                        </li>
                      </ul>

                      <div class="file-select" id="src-file1" >
                      <a class="btn btn-primary" style="color: white;"><i class="fa-solid fa-image"></i> Editar foto de perfil</a>
                      <form method="post" action="../Sl_Imagen" enctype="multipart/form-data">
         				Elija un archivo / imagen:
    					<input type="file" name="uploadFile">
   						 <br/><br/>
    					<input type="submit" value="Subir" />
                      	 <br />
                      </form>
                      </div>

                    </div>
                    <div class="col-md-9 col-sm-9 ">


                      <div class="" role="tabpanel" data-example-id="togglable-tabs">
                        <ul id="myTab" class="nav nav-tabs bar_tabs" role="tablist">
                          <li role="presentation" class="active"><a href="#tab_content1" id="home-tab" role="tab" data-toggle="tab" aria-expanded="true">Cursos</a>
                          </li>
                          <li role="presentation" class=""><a href="#tab_content2" role="tab" id="profile-tab" data-toggle="tab" aria-expanded="false">Detalles</a>
                          </li>
                        </ul>
                        <div id="myTabContent" class="tab-content">
                          <div role="tabpanel" class="tab-pane active " id="tab_content1" aria-labelledby="home-tab">
                          <!-- End current avatar -->
                    
                    <!-- start recent activity -->
                            <ul class="messages">
                              <li>
                              <div id="" class="card mt-1">
                                  <div class="card-body row">
                                     <div class="col-md-3 col-sm-6 courseimage">
                                        <a><img src="images/capacitacion.png" class="img-fluid" alt="Responsive image"></a>
                                     </div>
									<div class="media-body col-md-9 col-sm-6">
                                       <h3><%=vwur.getNombre_usuario() %></h3>
                                       <h6>Comenz� el: <%=vwur.getNombre_usuario()%></h6>
									<div class="mt-1">
                                    </div>
                                    </div>
                                  </div>
                               </div>
                              </li>
                              <li>
                              <div id="" class="card mt-1">
                                  <div class="card-body row">
                                     <div class="col-md-3 col-sm-6 courseimage">
                                        <a><img src="images/capacitacion.png" class="img-fluid" alt="Responsive image"></a>
                                     </div>
									<div class="media-body col-md-9 col-sm-6">
                                       <h3><%=vwur.getNombre_usuario()%></h3>
                                       <h6>Comenz� el: <%=vwur.getNombre_usuario()%></h6>
									<div class="mt-1">
                                    </div>
                                    </div>
                                  </div>
                               </div>
                              </li>
                              <li>
                              <div id="" class="card mt-1">
                                  <div class="card-body row">
                                     <div class="col-md-3 col-sm-6 courseimage">
                                        <a><img src="images/capacitacion.png" class="img-fluid" alt="Responsive image"></a>
                                     </div>
									<div class="media-body col-md-9 col-sm-6">
                                       <h3><%=vwur.getNombre_usuario()%></h3>
                                       <h6>Comenz� el: <%=vwur.getNombre_usuario()%></h6>
									<div class="mt-1">
                                    </div>
                                    </div>
                                  </div>
                               </div>
                              </li>
                              <li>
                              <div id="" class="card mt-1">
                                  <div class="card-body row">
                                     <div class="col-md-3 col-sm-6 courseimage">
                                        <a><img src="images/capacitacion.png" class="img-fluid" alt="Responsive image"></a>
                                     </div>
									<div class="media-body col-md-9 col-sm-6">
                                       <h3><%=vwur.getNombre_usuario()%></h3>
                                       <h6>Comenz� el: <%=vwur.getNombre_usuario()%></h6>
									<div class="mt-1">
                                    </div>
                                    </div>
                                  </div>
                               </div>
                              </li>

                            </ul>
                            
                            
                            
                            <!-- end recent activity -->
                            
                            </div>
                          <div role="tabpanel" class="tab-pane fade" id="tab_content2" aria-labelledby="profile-tab">
                    
                    <!-- start user projects -->
                            <table class="table table-striped table-bordered" style="width:100%">
                              <thead>
                                <tr>
                                  <th>#</th>
                                  <th>Project Name</th>
                                  <th>Client Company</th>
                                  <th>Hours Spent</th>
                                </tr>
                              </thead>
                              <tbody>
                              
                              <%
                              for(Tbl_user userList: listaUser){
                              %>
                              
                                <tr>
                                  <td><%=userList.getId_usuario() %></td>
                                  <td><%=userList.getNombre_real() %></td>
                                  <td><%=userList.getCorreo_personal() %></td>
                                  <td><%=userList.getTelefono_contacto() %></td>
                                </tr>
                                
                                
                                
                                
                                <%
                              }
                                %>
                                
                              </tbody>
                            </table>
                            
                            
                            
                            <!-- end user projects -->
                            
                            
                            
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
    	
    }

    $(document).ready(function() {
        $('.js-example-basic-single').select2();
        
        	
    });
    
    
    </script>

  </body>
</html>