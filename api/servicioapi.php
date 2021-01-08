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


include_once './Items.php';
include_once './Imagenes.php';
include_once './conect_bd.php';



$sql = "SELECT * FROM item";
$prepare = $pdo->prepare($sql,array(PDO::ATTR_CURSOR => PDO::CURSOR_FWDONLY));
$prepare->execute();

$items = $prepare->fetchAll(PDO::FETCH_CLASS,'Items');

$id = $items[0]->id;
$sql = "SELECT * FROM imagen WHERE item_id = :id";
$prepare = $pdo->prepare($sql,array(PDO::ATTR_CURSOR => PDO::CURSOR_FWDONLY));
$prepare->execute([':id' => $id]);


$imagenes = $prepare->fetchAll(PDO::FETCH_CLASS,'Imagenes');

$imagen=[];

$result = [];



foreach($imagenes as $img){
    array_push($imagen, [
            "ruta" => $img->ruta
    ]);
}

foreach ($items as  $item)
    {   
        
        
        array_push($result, [
            "id" => $item->id,
            "nombre" => $item->nombre,
            "categoria" => $item->categoria,       
            "direccion" => $item->direccion,
            "descripcion" => $item->direccion,
            "area"=> $item->direccion,
            "banio"=> $item->banio,
            "dormitorio"=> $item->dormitorio,
            "anio_construido"=> $item->anio_construido,
            "bien_estar"=> $item->bien_estar,
            "orientacion"=> $item->orientacion,
            "cocina"=> $item->cocina,
            "parking"=> $item->parking,
            "video"=> $item->video,
            "visto"=> $item->visto,
            "rut_empresa"=> $item->rut_empresa,
            "imagen"=>$imagen
        ]);
    }




echo json_encode($result);