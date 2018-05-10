@extends('Plantilla')

@section('titulo')
	Inicio
@endsection

@section('contenido')


	<div class="row text-center" style="margin:0px auto;padding-top: 20px">
		<div class="col-lg-12">
	
			<div class="row" style="padding: 5px">
				<div class="col-lg-4  ">
					<div class="card" style="width: 18rem;">
					  <img class="card-img-top" src="{{asset('Imagenes/libro.jpg')}}" alt="Card image cap">
					  <div class="card-body">
					    <h5 class="card-title">Agregar libros</h5>
					   
					    <a href="#" class="btn btn-success">Agregar</a>
					  </div>
					</div>
				</div>
				<div class="col-lg-4">
					<div class="card" style="width: 18rem;">
					  <img class="card-img-top" src="{{asset('Imagenes/libro2.jpg')}}" alt="Card image cap">
					  <div class="card-body">
					    <h5 class="card-title">Lista de  libros</h5>
					    
					    <a href="{{asset('PrestarLibro')}}" class="btn btn-warning">libros</a>
					  </div>
					</div>
				</div>
				<div class="col-lg-4">
					<div class="card" style="width: 18rem;">
					  <img class="card-img-top" src="{{asset('Imagenes/libro3.jpg')}}" alt="Card image cap">
					  <div class="card-body">
					    <h5 class="card-title">Prestamos</h5>
					   
					    <a href="{{asset('ListaLibrosPrestados')}}" class="btn btn-success">Ver</a>
					  </div>
					</div>
				</div>
				
			</div>
			
		</div>
	</div>

@endsection