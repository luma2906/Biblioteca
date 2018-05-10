<?php
use Illuminate\Database\Eloquent\SoftDeletingTrait;
class Libros extends Eloquent  {
    
    use Illuminate\Database\Eloquent\SoftDeletingTrait;
	protected $table = 'libros';
	protected $primaryKey = 'id_libro';

	public function biblioteca(){
        return $this->hasMany('Biblioteca', 'id_biblioteca', 'id_libro');
    }
	
	

}
