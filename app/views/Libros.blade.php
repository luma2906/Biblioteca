@extends('Principal')
@section('titulo')
	Inicio
@endsection
@section('css')
	<link rel="stylesheet" type="text/css" href="{{asset('Css/Libros.css')}}">
@endsection
@section('contenido')
	<div id="tablaLibros">
		<div class="row">
			<div class="col-lg-12">
				<table  id="tabla1" class="display" style="width:100%">
		  			<thead>
					    <tr>
					  
					      <th scope="col">Nombre libro</th>
					      <th scope="col">Cantidad</th>
					    
					      <th scope="col">Opción</th>
					    </tr>
					  </thead>
					  <tbody id="cuerpoLibrosT">
					  	
					  	@if(!empty($Libros))
						    @foreach($Libros as $libro)
							    <tr>
							       <td>{{$libro->nombre_libro}}</td>
							      <td>{{$libro->cant}}</td>
							       
							       		 <td><button type="" class="btn btn-success" onclick="AbrirLibros({{$libro->codigo_unico}})">Ver</button></td>
							      
							     
							    </tr>
						    @endforeach
						
					    @endif
					   
					  </tbody>
					</table>
				</div>

				
		</div>

		
	</div>

	


	<div class="modal" tabindex="-1" role="dialog" id="Libros">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h5 class="modal-title">Modal title</h5>
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
	          <span aria-hidden="true">&times;</span>
	        </button>
	      </div>
	   
			      <div class="modal-body">
			      <form>
			      	<input type="hidden" name="id_libro_detalle" id="id_libro_detalle">
			      </form>
			      <table  id="example" class="display" style="width:100%">
						  <thead>
						    <tr>
						      <th scope="col">DNI</th>
						      <th scope="col">Nombre libro</th>
						      <th scope="col">Estado</th>
						      <th scope="col">Editorial</th>
						      <th scope="col">Opción</th>
						    </tr>
						  </thead>
						  <tbody id="cuerpoLibros">
						  	
						  	@if(!empty($Libros))
							    @foreach($Libros as $libro)
								    <tr>
								      <td scope="row">{{$libro->dni}}</td>
								      <td>{{$libro->nombre_libro}}</td>
								      @if($libro->estado==1)
								     	 <td>Disponible</td>
								      @else
								      	<td>Ocupado</td>
								      @endif
								      <td>{{$libro->editorial}}</td>
								       @if($libro->estado==1)
								       		 <td><button type="" class="btn btn-success" onclick="AbrirAlerta({{$libro->id_libro}})">Prestar</button></td>
								       @else
								       		 <td><button type="" class="btn btn-danger" onclick="Devolver({{$libro->id_libro}})">Devolver</button></td>
								       @endif
								     
								    </tr>
							    @endforeach
							
						    @endif
						   
						  </tbody>
						</table>
	        
	        
	      		</div>
	    
	    </div>
	  </div>
	</div>


	<div class="modal" tabindex="-1" role="dialog" id="prestamolibro">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h5 class="modal-title">Modal title</h5>
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
	          <span aria-hidden="true">&times;</span>
	        </button>
	      </div>
	       <form >
			      <div class="modal-body">
			      	<h1>¿Quien realiza el prestamo?</h1>
			      	<select class="form-control"  name="id_usuario" id="id_usuario" >
			        
			      	
			      	@foreach($Usuarios as $usuario)

			      		<option value="{{$usuario->id_usuario}}">{{$usuario->nombre}}</option>
			      	@endforeach
			      	</select>
			        <p>Realmente desea prestar este libro</p>
			      </div>
	      		<div class="modal-footer">
		       		 <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
		       
		        	<input type="hidden" name="id" id="id" >
		        	<button type="button" class="btn btn-primary" onclick="prestarlibro()">Si</button>
	        	
	        
	        
	      		</div>
	      </form>
	    </div>
	  </div>
	</div>


@endsection