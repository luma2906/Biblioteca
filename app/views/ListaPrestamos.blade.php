@extends('Principal')
@section('titulo')
	Inicio
@endsection
@section('css')
	<link rel="stylesheet" type="text/css" href="{{asset('Css/Libros.css')}}">
@endsection
@section('contenido')
	<div id="tablaLibros">
	

		<table  id="example" class="display" style="width:100%">
		  <thead>
		    <tr>
		      <th scope="col">DNI</th>
		      <th scope="col">Nombre libro</th>
		      <th scope="col">Fecha entrega</th>
		      <th scope="col">Usuario</th>
		      <th scope="col">Cedula</th>
		      <th scope="col">Nombre completo</th>
		    </tr>
		  </thead>
		  <tbody id="cuerpoLibros">
		  	
		  	@if(!empty($vect['Prestamos']))
			    @foreach($vect['Prestamos'] as $prestamo)
				    <tr>
				    	@foreach($vect['Libros'] as $libro)
				    		@if($libro->id_libro==$prestamo->id_libro)
				    			<td>{{$libro->dni}}</td>
				    			<td>{{$libro->nombre_libro}}</td>
				    			<td>{{$prestamo->fecha_entrega}}</td>
				    		@endif
			    		@endforeach
				    	
				    	@foreach($vect['Usuarios'] as $usuario)
				    		@if($usuario->id_usuario==$prestamo->id_usuario)
				    			<td>{{$usuario->correo}}</td>
				    			<td>{{$usuario->cc}}</td>
				    			<td>{{$usuario->nombre." ".$usuario->apellido}}</td>
				    		@endif
			    		@endforeach

				    </tr>
			    @endforeach
			
		    @endif
		   
		  </tbody>
		</table>
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
	      <div class="modal-body">
	        <p>Realmente desea prestar este libro</p>
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
	        <form >
	        	<input type="hidden" name="id" id="id" >
	        	<button type="button" class="btn btn-primary" onclick="prestarlibro()">Si</button>
	        	
	        </form>
	        
	      </div>
	    </div>
	  </div>
	</div>
@endsection