var container = document.getElementById("container");
var btn = document.getElementById("btn");
btn.addEventListener("click", function(){
	
	var request = new XMLHttpRequest();
	request.open('GET', 'datos_persona3.json', true)
	request.onload = function(){
		if(request.status === 200){
			var ourData = JSON.parse(request.responseText);
			//console.log(ourData);
		
		for(i=0; i<ourData.length;i++){
			//console.log(ourData[i].rol);
			var htmlString ="";
			htmlString += "<p>" + ourData[i].rol+".</p>";
			container.insertAdjacentHTML('beforebegin', htmlString);
		}
		}
		
		//var ourData = JSON.parse(ourRequest.responseText);
		//renderHTML(ourData);
	}
	request.send();
	
})

/*function renderHTML(data){
	var htmlString ="";
	console.log(data.length);
	for(ii=0; ii<data.length; ii++){
		htmlString += "<p>" + data[ii].rol+".</p>";
		container.insertAdjacentHTML('beforebegin', htmlString);
	}
}*/



////////////

  function crearJson(){
    	<%
    	//PARA GUARDAR
    	Gson gson = new GsonBuilder().setPrettyPrinting().create();
    			
    			//PARA LEER
    			String fileName = "datos_rol.json";
    			Path path = new File(fileName).toPath();
    			
    			
    			
    			try (Reader br = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {
    				 
    	            
    	            Tbl_rol[] lista2 = gson.fromJson(br, Tbl_rol[].class);
    	            lista2.add(crj.listaRolActivos());
    	            Arrays.stream(lista2).forEach(e -> {
    	            	System.out.println("{"+"\n"+"id_rol: "+e.getId_rol()+",\n"+"rol: "+ e.getRol()+",\n"+"estado: "+ e.getEstado()+"\n}\n");
    	            });

    	        } catch (IOException e) {
    	            e.printStackTrace();
    	        }
		
%>
/*var request = new XMLHttpRequest();
request.open('GET', '', true)
request.onload = function(){
	if(request.status === 200){
		var ourData = JSON.parse(request.responseText);
		//console.log(ourData);
	
	for(i=0; i<ourData.length;i++){
		//console.log(ourData[i].rol);
		var htmlString ="";
		htmlString += "<p>" + ourData[i].rol+".</p>";
		container.insertAdjacentHTML('beforebegin', htmlString);
	}
	}
	
	//var ourData = JSON.parse(ourRequest.responseText);
	//renderHTML(ourData);
}
request.send();*/

    	
    }
    
    function mostrar(){
    	<%
    	String prueba = path.toAbsolutePath().toString();
    	String replace = "C:/payara5/glassfish/domains/domain1/config/datos_rol.json";
    	
    	
    	
    	%>
    	console.log("<%=path.getFileSystem().getPath("/Security", "production","datos_rol.json")%>");
    	console.log("<%=prueba%>");
    }
    function eliminar(){
    	var request = new XMLHttpRequest();
    	request.open('GET', '<%=path%>', true)
    	request.onload = function(){
    		if(request.status === 200){
    			var ourData = JSON.parse(request.responseText);
    			//console.log(ourData);
    		
    		for(i=0; i<ourData.length;i++){
    			//console.log(ourData[i].rol);
    			var htmlString ="";
    			htmlString += "<p>" + ourData[i].rol+".</p>";
    			container.insertAdjacentHTML('beforebegin', htmlString);
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
