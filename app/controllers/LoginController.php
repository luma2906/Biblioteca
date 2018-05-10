<?php

class LoginController extends BaseController {
	public function MostrarPrincipal(){

		return View::make('Principal');
	}
	
	public function IniciarSesion()
	{
		$correo=Input::get('correo');
		$password=Input::get('password');
		$validator = Validator::make(
			array('correo' => $correo,
				'Password' => $password,
			),
			array('correo' => "required",
				'Password' => "required",
			)
		);

		$Usuario = User::where("Correo",$correo)->first();
		
		if ($validator->fails()) {
			
	
	
			return Redirect::to('Index');
			
		}

		  $userdata = array(
		        'correo'     => $correo,
		        'password'  => $password
		    );

		   if (Auth::attempt($userdata,false)) {
		   		//crear el auth de autenticacion
		   	    Auth::login(Auth::user(), true);
		   	    $Usuario->api_token=Session::getToken();

		   		Session::put('correo', $Usuario->correo);					
				Session::put('nombre', $Usuario->nombre." ".$Usuario->nombre);		
				Session::put('apellido', $Usuario->apellido);
				Session::put('id', $Usuario->id_usuario);
				$Usuario->save();
       			return Redirect::to('Principal');
		        

		    } else {        

		        // validation not successful, send back to form 
		        return Redirect::to('Index');
		       

		    }
	}
	public function CerrarSesion()
	{
		Auth::logout();
		return Redirect::to('/');
    }

}
