<?php
use Illuminate\Database\Eloquent\SoftDeletingTrait;
class Prestamo extends Eloquent  {
    
    use Illuminate\Database\Eloquent\SoftDeletingTrait;
	protected $table = 'prestamos';
	protected $primaryKey = 'id_prestamo';

	
	
	

}
