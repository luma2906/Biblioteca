<?php

class ApiRest extends BaseController {
	public function getPrestamos($token,$id_usuario){
		$usuarios=User::where("id_usuario","=",$id_usuario)->first();
		if($usuarios->api_token!=null && $token==$usuarios->api_token){
			$Prestamos=Prestamo::where("id_usuario","=",$id_usuario)->get();
			$libros=Libros::where("estado","=","0")->get();
			$vect=Array(
		    	"Prestamos" => $Prestamos,
		    	"resultado" => "exito",
		    	"Libros" => $libros,
	    	);
		}else{
			$vect=Array(
		    	"Prestamos" => NULL,
		    	"resultado" => "error",
		    	"Libros" => NULL,
	    	);
		}
	    
		return Response::json($vect);
	}
	public function getAll(){
		$Prestamos=Prestamo::all();
	    $vect=Array(
	    	"token" => "121212",
	    	"Prestamos" => $Prestamos,
	    );
		return Response::json($vect);
	}
	public function login($correo,$password){
		$userdata = array(
		        'correo'     => $correo,
		        'password'  => $password
		    );

		   if (Auth::attempt($userdata,false)) {
		   		 Auth::login(Auth::user(), true);
		   	    $token=Session::getToken();
		   	    $Usuario = User::where("Correo",$correo)->first();
		   	    $Usuario->api_token=Session::getToken();
		   	    $Usuario->save();
		   	    $vect=Array(
	    			"usuario" => $Usuario,
	    			"resultado" => "exito",
	    		);
		   }else{
		   		$vect=Array(
	    			"usuario" => NULL,
	    			"resultado" => "error",
	    		);
		   }
		   return Response::json($vect);
	}
	public function cerrarSesion(){
		Auth::logout();
		 $vect=Array(
	    			
			"resultado" => "exito",
		);
		return Response::json($vect);
	}
	public function add(){

	}
	


}

