<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
body {font-family: Arial, Helvetica, sans-serif;}
form {border: 3px solid #f1f1f1;}

input[type=text], input[type=password] {
  width: 100%;
  padding: 15px 15px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  box-sizing: border-box; 
}

button {
  background-color: #5979a9;
  color: white;
  padding: 14px 20px;
  margin: 8px 0;
  border: none;
  cursor: pointer;
  width: 100%;
}

button:hover {
  opacity: 0.8;
}

.cancelbtn {
  width: auto;
  padding: 10px 18px;
  background-color: #f44336;
}

.imgcontainer {
  text-align: center;
  margin: 20px 0 10px 0;
}

img.avatar {
  width: 5%;
  border-radius: 50%;
}

.container {
  padding: 16px;
}

span.psw {
  float: right;
  padding-top: 16px;
}

@media screen and (max-width: 300px) {
  span.psw {
     display: block;
     float: none;
  }
  .cancelbtn {
     width: 100%;
  }
}
</style>
</head>
<body>

<h2>Inicio de sesión</h2>

<!-- <form action="/action_page.php" method="post">
   <div class="imgcontainer">
    <img src="https://img2.freepng.es/20180504/phe/kisspng-professional-computer-icons-avatar-job-5aec571ec854c8.3222584415254382388206.jpg" alt="Avatar" class="avatar">
  </div> -->

  <div class="container">
    <label for="uname"><b>Usuario</b></label>
    <input type="text" placeholder="Introduzca su nombre de usuario" name="uname" >

    <label for="psw"><b>Contraseña</b></label>
    <input type="password" placeholder="Introduzca su contraseña" name="psw" >
        
        
   <button type="submit"><a href="production/Inicio.jsp">Iniciar Sesión</a></button> 
    <label>
      <input type="checkbox" checked="checked" name="remember"> Recordar mi contraseña
    </label>
  </div>

  <div class="container" style="background-color:#f1f1f1">
    <button type="button" class="cancelbtn">Cancel</button>
    <span class="psw">¿Olvidó su <a href="#">contraseña?</a></span>
  </div>
</form>

</body>
</html>