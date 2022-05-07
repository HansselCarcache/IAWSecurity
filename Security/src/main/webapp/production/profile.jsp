<%@page import="datos.Dt_ofertadet"%>
<%@page import="datos.Dt_oferta"%>
<%@page import="entidades.Tbl_oferta"%>
<%@page import="entidades.Vw_capacitacion"%>
<%@page import="datos.Dt_capacitacion"%>
<%@page import="entidades.Tbl_capacitacion"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="entidades.Tbl_user, datos.Dt_usuario, datos.Dt_usuario2, java.util.*;" %>

<% String user = "";
user = request.getParameter("idU")==null?"0":request.getParameter("idU");

Tbl_user tu = new Tbl_user();
Dt_usuario dtu = new Dt_usuario();
tu = dtu.getUserbyID(12);

Tbl_capacitacion tc = new Tbl_capacitacion();
Vw_capacitacion wtc = new Vw_capacitacion();
Dt_capacitacion dtc = new Dt_capacitacion();
wtc = dtc.getCapacitacionbyID(1);

Tbl_oferta oferta = new Tbl_oferta();
Dt_oferta dto = new Dt_oferta();
Dt_ofertadet dtod = new Dt_ofertadet();
oferta = dto.getoferta(1);
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <!-- Meta, title, CSS, favicons, etc. -->
    <meta charset="ISO-8859-1">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Usuario | Perfil</title>

    <!-- Bootstrap -->
    <link href="../vendors/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome -->
    <link href="../vendors/font-awesome/css/font-awesome.min.css" rel="stylesheet">
    <link href="../vendors/fontawesome-free-6.0.0-web/css/all.min.css" rel="stylesheet">
    <!-- NProgress -->
    <link href="../vendors/nprogress/nprogress.css" rel="stylesheet">

    <!-- Custom Theme Style -->
    <link href="../custom.min.css" rel="stylesheet">
    
    <!-- Select2 -->
    <link href="../vendors/select2/dist/css/select2.min.css" rel="stylesheet" />
<!-- <link href="https://cdn.jsdelivr.net/npm/select2@4.1.0-rc.0/dist/css/select2.min.css" rel="stylesheet" /> -->
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

            <%@include file="diseño.jsp"%>

        <!-- page content -->
        <div class="right_col" role="main">
          <div class="">
            <div class="page-title">
              <div class="title_left">
                <h3>Perfil de Usuario</h3>
              </div>
            </div>
            
            <div class="clearfix"></div>

            <div class="row">
              <div class="col-md-12 col-sm-12 ">
                <div class="x_panel">
                  <div class="x_title">
                    <h2>Detalles</h2>
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
                        
                        <li><i class="fa-solid fa-envelope"></i> <%=tu.getCorreo_institucional()%>
                        </li>
                      </ul>

                      <a class="btn btn-primary" style="color: white;"><i class="fa-solid fa-image"></i>Editar foto de perfil</a>
                      <br />

                      

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

                            <!-- start recent activity -->
                            <ul class="messages">
                              <li>
                              <div id="" class="card mt-1">
                                  <div class="card-body row">
                                     <div class="col-md-3 col-sm-6 courseimage">
                                        <a><img src="images/capacitacion.png" class="img-fluid" alt="Responsive image"></a>
                                     </div>
									<div class="media-body col-md-9 col-sm-6">
                                       <h3><%=wtc.getNombre() %></h3>
                                       <h6>Comenzó el: <%=oferta.getFecha_inicial()%></h6>
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
                                       <h3><%=tu.getCargo()%></h3>
                                       <h6>Comenzó el: <%=tu.getFecha_creacion()%></h6>
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
                                       <h3><%=tu.getCargo()%></h3>
                                       <h6>Comenzó el: <%=tu.getFecha_creacion()%></h6>
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
                                       <h3><%=tu.getCargo()%></h3>
                                       <h6>Comenzó el: <%=tu.getFecha_creacion()%></h6>
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
                            <table class="data table table-striped no-margin">
                              <thead>
                                <tr>
                                  <th>#</th>
                                  <th>Project Name</th>
                                  <th>Client Company</th>
                                  <th class="hidden-phone">Hours Spent</th>
                                  <th>Contribution</th>
                                </tr>
                              </thead>
                              <tbody>
                                <tr>
                                  <td>1</td>
                                  <td>New Company Takeover Review</td>
                                  <td>Deveint Inc</td>
                                  <td class="hidden-phone">18</td>
                                  <td class="vertical-align-mid">
                                    <div class="progress">
                                      <div class="progress-bar progress-bar-success" data-transitiongoal="35"></div>
                                    </div>
                                  </td>
                                </tr>
                                <tr>
                                  <td>2</td>
                                  <td>New Partner Contracts Consultanci</td>
                                  <td>Deveint Inc</td>
                                  <td class="hidden-phone">13</td>
                                  <td class="vertical-align-mid">
                                    <div class="progress">
                                      <div class="progress-bar progress-bar-danger" data-transitiongoal="15"></div>
                                    </div>
                                  </td>
                                </tr>
                                <tr>
                                  <td>3</td>
                                  <td>Partners and Inverstors report</td>
                                  <td>Deveint Inc</td>
                                  <td class="hidden-phone">30</td>
                                  <td class="vertical-align-mid">
                                    <div class="progress">
                                      <div class="progress-bar progress-bar-success" data-transitiongoal="45"></div>
                                    </div>
                                  </td>
                                </tr>
                                <tr>
                                  <td>4</td>
                                  <td>New Company Takeover Review</td>
                                  <td>Deveint Inc</td>
                                  <td class="hidden-phone">28</td>
                                  <td class="vertical-align-mid">
                                    <div class="progress">
                                      <div class="progress-bar progress-bar-success" data-transitiongoal="75"></div>
                                    </div>
                                  </td>
                                </tr>
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
    
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
    <script src="../vendors/validator/multifield.js"></script>
    <script src="../vendors/validator/validator.js"></script>
    
    </div>
    </div>

<script>

function setValores()
{
	
	
	
   

	
	
}

$(document).ready(function() {
    $('.js-example-basic-single').select2();
    
    	
});

</script>


    <!-- jQuery -->
    <script src="../vendors/jquery/dist/jquery.min.js"></script>
    <!-- Bootstrap -->
    <script src="../vendors/bootstrap/dist/js/bootstrap.bundle.min.js"></script>
    <!-- FastClick -->
    <script src="../vendors/fastclick/lib/fastclick.js"></script>
    <!-- NProgress -->
    <script src="../vendors/nprogress/nprogress.js"></script>
    <!-- validator -->
    <!-- <script src="../vendors/validator/validator.js"></script> -->

    <!-- Custom Theme Scripts -->
    <script src="../build/js/custom.min.js"></script>
    
    <!-- Select2 -->
    <script src="../vendors/select2/dist/js/select2.min.js"></script>
<!-- <script src="https://cdn.jsdelivr.net/npm/select2@4.1.0-rc.0/dist/js/select2.min.js"></script> -->
    
    <script type="text/javascript">
   
    </script>

  </body>
</html>