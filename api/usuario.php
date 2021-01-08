<?php
header('Content-Type: application/json');
if ($_SERVER["REQUEST_METHOD"] == "POST") {
  // collect value of input field
  //$name = $_POST['nombre'];
  //if (empty($name)) {
   //  echo 'Se esta vacia';
  //} else {

    echo json_encode([
        "usuario" => $_POST['inputnombre_usuario'],
        "email" => $_POST['inputemail_usuario']
    ], true);

  //}
}


?>