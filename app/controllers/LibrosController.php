<?php

class LibrosController extends BaseController {

	/*
	|--------------------------------------------------------------------------
	| Default Home Controller
	|--------------------------------------------------------------------------
	|
	| You may wish to use controllers instead of, or in addition to, Closure
	| based routes. That's great! Here is an example controller method to
	| get you started. To route to this controller, just add the route:
	|
	|	Route::get('/', 'HomeController@showWelcome');
	|
	*/

	public function MostrarLibros()
	{
		$libro=DB::select("SELECT id_libro, nombre_libro,dni,editorial,codigo_unico,estado,count(*) as cant FROM Libros group by codigo_unico");
		
	
		$usuario=User::all();
		return View::make('Libros')->with(array("Libros"=>$libro,"Usuarios"=>$usuario));
	}
	public function PrestarLibro(){
		$id=Input::get('id');
		$id_usuario=Input::get('id_usuario');
		$id_actual=Input::get('id_actual');

		$libro=Libros::where("id_libro","=",$id)->first();
		$prestamo=new Prestamo();
		$libro->estado=0;
		
		
		if (!$libro->save()){
		    echo "error";
		}else{
			$prestamo->id_libro=$libro->id_libro;
			$prestamo->fecha_prestamo=date("Y-m-d");
			$prestamo->fecha_entrega=$this->sumarFechas(date("Y-m-d"));
			$prestamo->id_usuario=	$id_usuario;
			$prestamo->save();
			$librito=Libros::where("codigo_unico","=",$id_actual)->get();
			echo  json_encode($librito);
		}
	

	}

	public function DevolverLibro(){
		$fecha_actual=date("Y-m-d");
		$SePasoFecha=false;
		$id=Input::get('id');
		$id_actual=Input::get('id_actual');
		$libro=Libros::where("id_libro","=",$id)->first();
		$prestamo=Prestamo::where("id_libro",$id)->first();
		$libro->estado=1;
		if (!$libro->save()){
		    echo "error";
		}else{
			//Realizo un borrado logico
			$prestamo->delete();
			$librito=Libros::where("codigo_unico","=",$id_actual)->get();
			$dias=$this->fechaEntrega($fecha_actual,$prestamo->fecha_entrega);
			if($dias<0){
				$SePasoFecha=false;

			}else{
				$SePasoFecha=true;
			}
			echo  json_encode(array("Librito"=>$librito,"Fecha"=>$SePasoFecha,"NumDias"=>$dias));
		}
	}

	public function DetalleLibro(){
		$id=Input::get('id');
		$libro=Libros::where("codigo_unico","=",$id)->get();
		echo  json_encode($libro);
	}
	public function fechaEntrega($fecha1,$fecha2){
		$datetime1 = new DateTime($fecha1);
		$datetime2 = new DateTime($fecha2);
		$interval = $datetime1->diff($datetime2);
		//esto esta en  dias
		$dias=$interval->format('%R%a');
		return $dias;
	}
	public function sumarFechas($fechaActual){
		$fecha = $fechaActual;
		$nuevafecha = strtotime ( '+3 day' , strtotime ( $fecha ) ) ;
		$nuevafecha = date ( 'Y-m-d' , $nuevafecha );
		return $nuevafecha;
	}
}
