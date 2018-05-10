<?php

use Illuminate\Database\Schema\Blueprint;
use Illuminate\Database\Migrations\Migration;

class Usuarios extends Migration {

	/**
	 * Run the migrations.
	 *
	 * @return void
	 */
	public function up()
	{
		 Schema::create('usuarios',function($table){
            $table->increments('id_usuario');
            $table->string('correo',100)->unique();
            $table->string('cc',100)->unique();
            $table->string('nombre',100);
            $table->string('apellido',100);
            $table->string('password');
            $table->integer('edad');
            $table->string("genero");
            $table->string("remember_token",100)->nullable();
            $table->softDeletes();
            $table->timestamps();
        });
	}

	/**
	 * Reverse the migrations.
	 *
	 * @return void
	 */
	public function down()
	{
		Schema::drop('usuarios');
	}


}
