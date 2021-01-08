<?php

include_once './Items.php';
include_once './conect_bd.php';


$sql = "SELECT * FROM items";
$prepare = $pdo->prepare($sql,array(PDO::ATTR_CURSOR => PDO::CURSOR_FWDONLY));
$prepare->execute();

$servicios = $prepare->fetchAll(PDO::FETCH_CLASS,'Items');



    /*foreach ($servicios as  $servicio)
    {
       echo "Id: {$servicio->nombre}";
       echo "Nombre: {$servicio->nombre}";
       echo "Descripcion: {$servicio->descripcion}";
       echo "Imagen: {$servicio->imagen}";
    }*/

    ?>
