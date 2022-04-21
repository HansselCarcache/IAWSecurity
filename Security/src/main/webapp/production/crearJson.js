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

 // Array para depositar datos tras primer llamada al JSON.
    let users = [];

    function mostrarUsuarios() {
      // Variables de contenedores
      var id_rol = document.getElementById("showname");
      var rol = document.getElementById("showage");
      var estado = document.getElementById("showdescription");
      // Borro los datos para cargar nuevos
      id_rol.innerHTML = "";
      rol.innerHTML = "";
      estado.innerHTML = "";
  //Agrego el name, age, description por cada persona en JSON
      users.forEach((element) => {
    	  id_rol.append(`id_rol: ${element.id_rol}`);
    	  rol.append(`rol: ${element.rol} `);
    	  estado.append(`estado: ${element.estado} `);
      });
    }

    function addUser() {
      // Tomo los valores de cada input
      var id_rol = document.getElementById("name").value;
      var rol = document.getElementById("age").value;
      var estado = document.getElementById("description").value;

      // Agrego al array objeto con datos de input, nuevo registro.
      users.push({ id_rol, rol, estado });
      mostrarUsuarios(); // Vuelvo a mostrar los datos
    }

    // Cargo los usuarios desde JSON solo la primera vez que carga página.
   
    function loadUsers() {
      fetch("../datos_rol.json")
        .then((respuesta) => respuesta.json())
        .then((respuesta) => {
          users = respuesta; // Vuelco respuesta en array users
          console.log(users[1].rol)
          mostrarUsuarios();
        })
        .catch((error) => alert("Ha ocurrido un error (" + error.message + ")"));
    }
