<?php
	$local_db = "localhost";
	$user_db = "root";
	$pass_db = "";
	$name_db = "test";
	# đừng đụng vào 
  $conn = new mysqli($local_db, $user_db, $pass_db, $name_db);
  $conn->set_charset("utf8");
    
?>
