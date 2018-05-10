<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title></title>
	<link rel="stylesheet" href="">
	<link rel="stylesheet" type="text/css" href="{{asset('librerias/bootstrap4/dist/css/bootstrap.css')}}">
</head>
<body>
	<div class="card center" style="width: 38rem; margin:0px auto">

		  <img class="card-img-top" src="{{asset('Imagenes/img1.jpg')}}" alt="Card image cap" height="250">
		  <div class="card-body">
		  	<h1 class="text-center">Inicio de sessión</h1>
		    <form action="{{asset('Login')}}" method="POST">
			  <div class="form-group">
			    <label for="exampleInputEmail1">Correo</label>
			    <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Correo electronico" name="correo">
			   
			  </div>
			  <div class="form-group">
			    <label for="exampleInputPassword1">Contraseña</label>
			    <input type="password" class="form-control" id="exampleInputPassword1" placeholder="Contraseña" name="password">
			  </div>
			 
			  <button type="submit" class="btn btn-primary">Login</button>
			</form>
		  </div>
	</div>
	
</body>
</html>