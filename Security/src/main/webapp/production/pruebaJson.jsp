<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="entidades.*, datos.*, java.util.*, java.io.*, com.google.gson.Gson,
com.google.gson.GsonBuilder, java.nio.file.Files, java.nio.file.FileSystems,
java.nio.file.Path, java.nio.charset.StandardCharsets;"%>

<!DOCTYPE html>
<html>
   
 <% ArrayList<Tbl_rol> trol = new ArrayList<Tbl_rol>();
   	    crearJson crj = new crearJson();
   	    trol = crj.listaRolActivos();
   	    	
   	    	%>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <!-- Meta, title, CSS, favicons, etc. -->
    <meta charset="ISO-8859-1">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Gestión | Usuarios</title>

    <!-- Bootstrap -->
    <link href="cdn.datatables.net/1.10.20/css/jquery.dataTables.min.css">
    <link href="../vendors/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome -->
    <link href="../vendors/font-awesome/css/font-awesome.min.css" rel="stylesheet">
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
    <link href="../build/css/custom.min.css" rel="stylesheet">
  </head>

   <body >
   <input type="text" id="txtprueba" name="txtprueba"></input>
    <button id="btn" onclick="mostrar()" >mostrar</button>
    <div id="container"></div>
                
           
   
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
    var container = document.getElementById("container");
    var txt = document.getElementById("txtprueba");
    function mostrar(){
    	var request = new XMLHttpRequest();
    	request.open('GET', 'datos_rol.json', true)
    	request.onload = function(){
    		if(request.status === 200){
    			var ourData = JSON.parse(request.responseText);
    			console.log(ourData);
    			
    		
    		for(i=0; i<ourData.length;i++){
    			//console.log(ourData[i].rol);
    			
    			var htmlString ="";
    			htmlString += "<p>" + ourData[i].rol+".</p>";
    			container.insertAdjacentHTML('beforebegin', htmlString);
    			//alert(txt.value);
    			
    			if(txt.value == ourData[i].rol){
    				alert("Ya existe un registro con ese nombre");
    			}
    		}
    		}
    		
    		var ourData = JSON.parse(request.responseText);
    		//renderHTML(ourData);
    	}
    	request.send();

    	
    }
    
    
   
    	
    	   	
    
    
   
   	
   	
    $(document).ready(function() {
   	<%-- <%
   	File fichero2 = new File("datos_rol.json");
	crj.eliminarFichero(fichero2);
   	%> --%>
   	    	
   });
    
   
    
    
   
    </script>
    
     <script>
   
    	   	</script>

</body>
</html>