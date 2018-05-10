$(document).ready(function() {

    $('#example').DataTable();
    $('#tabla1').DataTable();

} );
var valorMulta = 1500;
function prestarlibro(){
	var id=$("#id").val();
	var id_usuario=$("#id_usuario").val();
	var id_actual=$("#id_libro_detalle").val();
	$("#prestamolibro").modal('hide');
	
	
	$.ajax({
		url : 'ReservarLibro',
		type: 'POST',
		data: {id:id,id_usuario:id_usuario,id_actual:id_actual},

		success : function(resp) {

			if(resp=="error"){
				alert("Error no se puedo prestar el libro");
			}else{
				vectorLibros=jQuery.parseJSON(resp);
				console.log(vectorLibros[0].nombre_libro);
				$("#cuerpoLibros").empty();
				html="";
				estado="Disponible";
				$.each(vectorLibros, function (index, value) {
				  if(value.estado==1){
				  		estado="Disponible";
				  }else{
				  		estado="Ocupado";
				  }
				  html=html+"<tr>"+
						"<td>"+value.dni+"</td>"+
						"<td>"+value.nombre_libro+"</td>"+
						"<td>"+estado+"</td>"+
						"<td>"+value.editorial+"</td>";

						if(value.estado==1){
							html=html+"<td><button type='' class='btn btn-success' onclick='AbrirAlerta("+value.id_libro+")'>Prestar</button></td>"+
					  		"</tr>";
						}else{
							html=html+"<td><button type='' class='btn btn-danger' onclick='Devolver("+value.id_libro+")'>Devolver</button></td>"+
					  		"</tr>";
						}
					
				 
				});
				
				$("#cuerpoLibros").append(html);
				
			}
		},
		error : function(){
			alert("error ajax");

		},


	});

}


function AbrirLibros(id_codigo){
	$("#cuerpoLibros").empty();
	var id=id_codigo;
	
	$.ajax({
		url : 'AbrirLibrosDetalle',
		type: 'POST',
		data: {id:id},

		success : function(resp) {

			if(resp=="error"){
				alert("Error no se pudo devolver el libro");
			}else{
				vectorLibros=jQuery.parseJSON(resp);
				$("#id_libro_detalle").val(id);
				$("#cuerpoLibros").empty();
				html="";
				estado="Disponible";
				$.each(vectorLibros, function (index, value) {
				  if(value.estado==1){
				  		estado="Disponible";
				  }else{
				  		estado="Ocupado";
				  }
				  html=html+"<tr>"+
						"<td>"+value.dni+"</td>"+
						"<td>"+value.nombre_libro+"</td>"+
						"<td>"+estado+"</td>"+
						"<td>"+value.editorial+"</td>";

						if(value.estado==1){
							html=html+"<td><button type='' class='btn btn-success' onclick='AbrirAlerta("+value.id_libro+")'>Prestar</button></td>"+
					  		"</tr>";
						}else{
							html=html+"<td><button type='' class='btn btn-danger' onclick='Devolver("+value.id_libro+")'>Devolver</button></td>"+
					  		"</tr>";
						}
					
				 
				});
				
				$("#cuerpoLibros").append(html);
				$("#Libros").modal('show');
				
			}
		},
		error : function(){
			alert("error ajax");

		},


	});
	
}
function Devolver(id){

	var id=id;
	var id_actual=$("#id_libro_detalle").val();

	
	$.ajax({
		url : 'DevolverLibro',
		type: 'POST',
		data: {id:id,id_actual:id_actual},

		success : function(resp) {

			if(resp=="error"){
				alert("Error no se pudo devolver el libro");
			}else{
				vectorLibros=jQuery.parseJSON(resp);
				
				$("#cuerpoLibros").empty();
				html="";
				estado="Disponible";
			
				if(vectorLibros['Fecha']==false){
					alert("Debe pagar una multa de "+vectorLibros['NumDias']*valorMulta*-1+" Debido a que el libro no se entrego en la fecha establecida");
				}
				$.each(vectorLibros['Librito'], function (index, value) {
				  if(value.estado==1){
				  		estado="Disponible";
				  }else{
				  		estado="Ocupado";
				  }
				  html=html+"<tr>"+
						"<td>"+value.dni+"</td>"+
						"<td>"+value.nombre_libro+"</td>"+
						"<td>"+estado+"</td>"+
						"<td>"+value.editorial+"</td>";

						if(value.estado==1){
							html=html+"<td><button type='' class='btn btn-success' onclick='AbrirAlerta("+value.id_libro+")'>Prestar</button></td>"+
					  		"</tr>";
						}else{
							html=html+"<td><button type='' class='btn btn-danger' onclick='Devolver("+value.id_libro+")'>Devolver</button></td>"+
					  		"</tr>";
						}
					
				 
				});
				
				$("#cuerpoLibros").append(html);
				
			}
		},
		error : function(){
			alert("error ajax");

		},


	});
}
function AbrirAlerta(id){
	 $("#id").val(id);
	$("#prestamolibro").modal('show');
	/*
	*/
}