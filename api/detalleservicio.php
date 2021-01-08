<?php

include_once './Items.php';
include_once './conect_bd.php';

$sql = "SELECT * FROM item WHERE id = :id";
$prepare = $pdo->prepare($sql,array(PDO::ATTR_CURSOR => PDO::CURSOR_FWDONLY));
$prepare->execute([':id' => $_GET['id'] ]);

$servicios = $prepare->fetchAll(PDO::FETCH_CLASS,'Items');

$servicio = $servicios[0]->id;


var_dump($servicio)




?>


