<?php

class DatabaseSeeder extends Seeder {

	/**
	 * Run the database seeds.
	 *
	 * @return void
	 */
	public function run()
	{
		//Eloquent::unguard();


   		Eloquent::unguard();

      	$this->call('UserTableSeeder');

    }
}
