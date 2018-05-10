<?php

use Illuminate\Database\Schema\Blueprint;
use Illuminate\Database\Migrations\Migration;

class Biblioteca extends Migration {

	/**
	 * Run the migrations.
	 *
	 * @return void
	 */
	public function up()
	{
		 Schema::create('bibliotecas',function($table){
            $table->increments('id_biblioteca');
            $table->string('nombre',100);
            $table->string('direccion',100);
            $table->string('correo',100);
            $table->string('url',100);
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
		Schema::drop('bibliotecas');
	}

}
