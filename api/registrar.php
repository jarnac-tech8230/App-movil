<?php

header('Content-Type: application/json');
header('Access-Control-Allow-Origin: *');
header("Access-Control-Allow-Headers: X-API-KEY, Origin, X-Requested-With, Content-Type, Accept, Access-Control-Request-Method");
header("Access-Control-Allow-Methods: GET, POST, OPTIONS, PUT, DELETE");
header("Allow: GET, POST, OPTIONS, PUT, DELETE");
$method = $_SERVER['REQUEST_METHOD'];
if($method == "OPTIONS") {
    die();
}

$data = file_get_contents('php://input');

$json_data = json_decode($data , true);
if ($_SERVER['REQUEST_METHOD'] === 'POST') 
{
//code to process data
if ($data == "")
{
    $response = array('code' => 500, 'msg' => 'Faltan datos para el registro', 'data' => []);    
}
else
{

        //aca me conecto a la BD

        //aca pongo el sql

        //exceute
        //execute([':email' => $json_data['email'], ':pass' => $json_data['pass']])




    $response = array('code' => 200, 'msg' => 'ok', 'data' => []);  
}

    echo json_encode($response);
}


