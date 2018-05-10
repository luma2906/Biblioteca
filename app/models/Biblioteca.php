<?php
use Illuminate\Database\Eloquent\SoftDeletingTrait;
class Biblioteca extends Eloquent  {
    
    use Illuminate\Database\Eloquent\SoftDeletingTrait;
	protected $table = 'biblioteca';
	protected $primaryKey = 'id_biblioteca';
	public function libros(){
		return $this->hasMany('Libros','id_libro','id_biblioteca');
	}

	

}
