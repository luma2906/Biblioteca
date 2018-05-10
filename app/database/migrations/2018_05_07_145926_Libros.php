<?php

use Illuminate\Database\Schema\Blueprint;
use Illuminate\Database\Migrations\Migration;

class Libros extends Migration {

	/**
	 * Run the migrations.
	 *
	 * @return void
	 */
	public function up()
	{
		 Schema::create('libros',function($table){
            $table->increments('id_libro');
            $table->string('dni',255)->unique();
            $table->string('nombre_libro',100)->unique();
            $table->string('editorial',100);
            $table->Integer('estado');

            $table->integer('id_biblioteca')->unsigned();
                      
            $table->foreign('id_biblioteca')->references('id_biblioteca')->on('bibliotecas');
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
		Schema::drop('libros');
	}

}
