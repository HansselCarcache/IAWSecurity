<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="entidades.Tbl_user, datos.Dt_usuario, datos.Dt_usuario2, java.util.*" %>
<%
String VarMsj = "";

VarMsj = request.getParameter("msj")==null?"0":request.getParameter("msj");
Dt_usuario dtu = new Dt_usuario();
dtu.crearJSON();

%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<!-- Meta, title, CSS, favicons, etc. -->
	<meta charset="ISO-8859-1">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">

	<title>Registro | Sistema de  Formación Docente</title>

	<!-- Bootstrap -->
    <link href="vendors/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome -->
    <link href="vendors/font-awesome/css/font-awesome.min.css" rel="stylesheet">
  	<link href="vendors/fontawesome-free-6.0.0-web/css/all.min.css" rel="stylesheet">
  	<!-- JAlert -->
    <link href="vendors/jAlert/dist/jAlert.css" rel="stylesheet">
    <!-- NProgress -->
    <link href="vendors/nprogress/nprogress.css" rel="stylesheet">
	<!-- Custom Theme Style -->
	<link href="custom.min.css" rel="stylesheet">
	<!-- Select2 -->
    <link href="vendors/select2/dist/css/select2.min.css" rel="stylesheet" />
</head>
	
<body>
	<div class="main_container">
    	<a href="Login.jsp" class="site_title"> <i class="fa-solid fa-book"></i><span>Registro de Nuevo Docente</span></a>
    	<!-- page content -->
        <div class="right_col" role="main">
      		<div class="">
            	<div class="clearfix"></div>
            	<div class="row">
            		<div class="col-md-12 col-sm-12">
            			<div class="x_panel">
            				<div class="x_title">
            					<h2>Hubo un problema al realizar el proceso de registro por tanto su cuenta no ha sido creada!</h2></br></br>
            					<h2>Favor intentar nuevamente</h2></br></br>
            					<a href="registrarNuevoDocente.jsp" class="btn btn-primary">Regresar</a>
            					<div class="clearfix"></div>
            				</div>
            			</div>
            		</div>
            	</div>
            </div>
        </div>
    </div>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
    <script src="vendors/validator/multifield.js"></script>
    <script src="vendors/validator/validator.js"></script>
</body>

</html>