<?php

class LibrosPrestadoController extends BaseController {

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
		$Prestamos=Prestamo::all();
		$Libros=Libros::all();
		$Usuarios=User::all();
		$vec=array(
	  	 "Prestamos"=>$Prestamos,
	     "Usuarios"=>$Usuarios,
	  	 "Libros"=>$Libros,
	    

	  	);
		return View::make('ListaPrestamos')->with("vect",$vec);
	}

	public function fechaEntrega($fecha1,$fecha2){
		$datetime1 = new DateTime($fecha1);
		$datetime2 = new DateTime($fecha2);
		$interval = $datetime1->diff($datetime2);
		//esto esta en  dias
		$dias=$interval->format('%R%a');
		return $dias;
	}
	
}
