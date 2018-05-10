<?php
// app/database/seeds/DatabaseSeeder.php
class UserTableSeeder extends Seeder
{

public function run()
{
    DB::table('usuarios')->delete();
   		 User::create(array(
	        'nombre'     => 'Luisa Maria',
	        'apellido' => 'sevilayha',
	        'correo'    => 'luma2906@gmail.com',
	        'cc'    => '1088299818',
	        'password' => Hash::make('123'),
	        'edad'  => '25',
	        'genero'  => 'f',
	                
	    ));	
}

}

		