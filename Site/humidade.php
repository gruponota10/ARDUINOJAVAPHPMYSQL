<?php
header("Refresh:3");

$servername = "localhost:3306";
$username = "root";
$password = "newrootpassword";
$dbname = "arduino";

// Create connection
$conn = new mysqli($servername, $username, $password,$dbname);

// Check connection
if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
}
echo "";


$sql = "SELECT valortemp, valorhumi, valorchuva FROM dados WHERE iddados=1";
$result = $conn->query($sql);

if ($result->num_rows > 0) {
    // output data of each row
    while($row = $result->fetch_assoc()) {
        echo $row["valorhumi"];
    }
} else {
    echo "error";
}
$conn->close();

?>