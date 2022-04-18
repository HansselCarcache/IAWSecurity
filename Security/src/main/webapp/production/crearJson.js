function crearJson(){
    	<% Gson gson = new Gson();
    	Tbl_rol tu = new Tbl_rol(1,"prueba",1);
    	String json = gson.toJson(tu);
    	System.out.println("Este es tu json:"+json);
    	%>
    }