<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title></title>
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
	<link rel="stylesheet" href="">
		<link rel="stylesheet" type="text/css" href="{{asset('librerias/bootstrap4/dist/css/bootstrap.css')}}">

	<link rel="stylesheet" type="text/css" href="{{asset('librerias/datatable/datatables.css')}}">
	@yield('css')

	<script src="{{asset('librerias/Jquery/jquery.min.js')}}" type="text/javascript" charset="utf-8"></script>
	<script src="{{asset('librerias/bootstrap4/dist/js/bootstrap.js')}}" type="text/javascript" charset="utf-8" async defer></script>
	<script src="{{asset('librerias/js/index.js')}}" type="text/javascript" charset="utf-8" async defer></script>
	<script src="{{asset('librerias/datatable/datatables.js')}}" type="text/javascript" charset="utf-8" ></script>
</head>
<body>

	


		<nav class="navbar navbar-light bg-light">
		  	<a class="navbar-brand" href="{{asset('Principal')}}">
		  		@yield('titulo')
		  		 
		  		

		  	</a>
		  	<div class="text-right">
					  		<span>Bienvenid@ {{Session::get('nombre')}}</span>
		  	</div>
		  	<div class="form-inline">
				<ul class="navbar-nav align-right">
			      <li class="nav-item active">
			        <a class="navbar-brand" href="{{asset('LogOut')}}">Cerrar sesion</a>
			      </li>
			    </ul>
		  	</div>
		</nav>

		@yield('contenido')
	
	
</body>
</html>