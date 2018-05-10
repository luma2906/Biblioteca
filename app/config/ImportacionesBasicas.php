<!-- **********************  IMPORTACION BASICAS ********* -->

<!-- 
|*************************************************************************
| Importación de Jquery
|*************************************************************************
|
| Se realiza la importación del archivo minimizado de jquery (Produccion)
-->

<script type="text/javascript" src="<?php echo asset('Librerias/Jquery/jquery.min.js')?>"> </script>


<!-- 
|*************************************************************************
| Importación de bootstrap
|*************************************************************************
|
| Se cargan los archivos css y js necesarios para el correcto
| funcionamiento de bootstrap en la aplicación
-->
<link rel="stylesheet"  href="<?php echo asset('Librerias/Bootstrap/css/bootstrap.min.css')?>">
<script type="text/javascript" src="<?php echo asset('Librerias/Bootstrap/js/bootstrap.min.js')?>"></script> 

<!--  
|*************************************************************************
| Importación de Font Awesome
|*************************************************************************
|
| Se realiza la importación del archivo css minimizado de font-awesome (Produccion)
-->
<link rel="stylesheet"  href="<?php echo asset('Librerias/Font-awesome/css/font-awesome.min.css')?>">

<!-- 
|*************************************************************************
| Importación de Summernote
|*************************************************************************
|
| Se cargan los archivos css y js necesarios para el correcto
| funcionamiento de summernote en la aplicación.
| Adicional se importa el archivo de lenguaje para que summernote funcione en español
| Summernote requiere que se haya importado bootstrap y font-awesome
-->

<script type="text/javascript" src="<?php echo asset('Librerias/summernote/summernote.min.js')?>"> 
</script>
<script type="text/javascript" src="<?php echo asset('Librerias/summernote/Langs/summernote-es-CO.js')?>"> 
</script>
<link rel="stylesheet"  href="<?php echo asset('Librerias/summernote/summernote.css')?>">

