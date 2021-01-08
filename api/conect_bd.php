<?php


/* Conectar a una base de datos de MySQL invocando al controlador */
$dsn = 'mysql:dbname=mi_hogar;host=sqlmihogar.mysql.database.azure.com'; //localhost
$usuario = 'adminHogar@sqlmihogar';
$contrasenna = 'hogar123#';

try {
    $pdo = new PDO($dsn, $usuario, $contrasenna);
} catch (PDOException $e) {
    echo 'Falló la conexión: ' . $e->getMessage();
}
