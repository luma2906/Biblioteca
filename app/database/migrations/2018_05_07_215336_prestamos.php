<?php

use Illuminate\Database\Schema\Blueprint;
use Illuminate\Database\Migrations\Migration;

class Prestamos extends Migration {

	/**
	 * Run the migrations.
	 *
	 * @return void
	 */
	public function up()
	{
		Schema::create('prestamos',function($table){
            $table->increments('id_prestamo');
           
            $table->date('fecha',100);
             $table->integer('id_libro')->unsigned();
            $table->integer('id_usuario')->unsigned();

            $table->foreign('id_libro')->references('id_libro')->on('libros');
             $table->foreign('id_usuario')->references('id_usuario')->on('usuarios');
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
		//
	}

}
