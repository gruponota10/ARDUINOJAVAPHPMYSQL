<!DOCTYPE html>
<html>
<head>
<title>Arduino Sensores</title>
</head>
<body>

<style>

    body{
    margin:0px;
    background-image: url("background.png");
    background-image: cover;
    }

    p{
        font-family: Impact, Charcoal, sans-serif;
        font-size: 90px;
        color: white;
        
    }

    span{
        font-family: Impact, Charcoal, sans-serif;
        font-size: 30px;
        color: white;
    }

    .principal{
        
        display: column;
        height: 631px;
    }


     .principal div{

    }

    .header{
        height: 10%;
        background-size: cover;
        min-width: 400px;

    }


    @media (min-width:1000px){
    .content{

        background-size: cover;
        display: flex;
        align-items: center;
        align-content: center;
        justify-content:  center;
        height: 80%;
        min-width: 100px;
       
    }

    }


    .content div{

        padding: 50px;
        flex-basis: 24%;
        height: 71%;
        
    }



    .temperatura{
        
    width: 100%;
    height: 0;
    min-height: 400px;
    min-width: 400px;
    box-sizing: border-box;
    padding-bottom: 50%;
    background-image: url('temperatura.png');
    background-size: contain;
    background-position: center;
    background-repeat: no-repeat;

    
        
    }

    .temperatura2 {
            line-height: 0px;
            text-align: center;
            text-indent:  32px;

    }

     .humidade{
    width: 100%;
    height: 0;
    min-height: 400px;
    min-width: 400px;
    box-sizing: border-box;
    padding-bottom: 50%;
    background-image: url('humidade.png');
    background-size: contain;
    background-position: center;
    background-repeat: no-repeat;
    
    }

    .humidade2 {
        line-height: 0px;
        text-align: center;

    }

     .chuva{
        width: 100%;
        height: 0;
        min-height: 400px;
        min-width: 400px;
        box-sizing: border-box;
        padding-bottom: 50%;
        background-image: url('chuva.png');
        background-size: contain;
        background-position: center;
        background-repeat: no-repeat;
        
        
    }

    .chuva2 {
        line-height: 150px;
        text-align: center;

    }


    .footer{
    
            background-size: cover;
            height: 10%;
            min-width: 400px;
    }

</style>

    <div class="principal">

    <div class="header"></div>
    <div class="content">
        
            <div class="temperatura"><div class="temperatura2"><p id="temp"></p></div></div>
            <div class="humidade"><div class="humidade2"><p id="humi"></p></div></div>
            <div class="chuva"><div class="chuva2"><span id="chuva"><span></div></div>

    </div>
    <div class="footer"></div>
    </div>

    <script type="text/javascript" src="jquery.min.js" > </script>
    <script type="text/javascript">
    $(document).ready( function() {
        $('#temp').load('temperatura.php');
        $('#humi').load('humidade.php');
        $('#chuva').load('chuva.php');
        refresh();
    });
    
    function refresh()
    {
        setTimeout(function() {
            $('#temp').load('temperatura.php');
            $('#humi').load('humidade.php');
            $('#chuva').load('chuva.php');
            refresh();
        }, 100);

    }

    </script>

</body>
</html>
