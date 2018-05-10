<?php

/*
|--------------------------------------------------------------------------
| Application Routes
|--------------------------------------------------------------------------
|
| Here is where you can register all of the routes for an application.
| It's a breeze. Simply tell Laravel the URIs it should respond to
| and give it the Closure to execute when that URI is requested.
|
*/

Route::get('/', function()
{
	return View::make('Index');
});
Route::post('Login','LoginController@IniciarSesion');

Route::get('LogOut','LoginController@CerrarSesion');
Route::group(array('before' => 'auth'), function(){

	

	Route::get('Principal','LoginController@MostrarPrincipal');
	Route::get('PrestarLibro','LibrosController@MostrarLibros');
	Route::post('ReservarLibro','LibrosController@PrestarLibro');
	Route::post('DevolverLibro','LibrosController@DevolverLibro');
	Route::get('ListaLibrosPrestados','LibrosPrestadoController@MostrarLibros');
	Route::post('AbrirLibrosDetalle','LibrosController@DetalleLibro');

});
//
Route::get("Api","ApiRest@getAll");
Route::get("ApiLogin/{correo}/{password}","ApiRest@login");
Route::get("ApiLogOut","ApiRest@cerrarSesion");
Route::get("ApiPrestamos/{toke}/{id_usuario}","ApiRest@getPrestamos");