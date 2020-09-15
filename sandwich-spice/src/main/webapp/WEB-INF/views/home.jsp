
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>home</title>
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

    <!-- jQuery library -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

    <!-- Latest compiled JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <style>
        h1 {
            padding-left: 35%;
            color: deeppink;
        }
        input {
            padding-left: 30%;
            color: blueviolet;
            border: azure 1px solid;
            font-family: Likhan;
        }
        button{
            width: 50px;
            height: auto;
            color: navy;
        }

        body {
            font-family: 'DejaVu Sans', Arial, Helvetica, sans-serif    ;
        }

    </style>
</head>
<body>
<div class="alert alert-success" style="padding-left: 30%   ">
    <strong> Choose your Dishes!</strong>
</div>
<div id="myCarousel" class="carousel slide" data-ride="carousel" style="">

    <!-- Indicators -->
    <ol class="carousel-indicators">
        <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
        <li data-target="#myCarousel" data-slide-to="1"></li>
        <li data-target="#myCarousel" data-slide-to="2"></li>
    </ol>

    <!-- Wrapper for slides -->
    <div class="carousel-inner">
        <div class="item active">
            <img style="width: 80%; margin: 10%"
                    src="https://prods3.imgix.net/images/articles/2017_04/Feature-restaurant-butcher-bakery-shops2.jpg?auto=format%2Ccompress&ixjsv=2.2.3&w=670" alt="Chania">
            <div class="carousel-caption">
                <h3>SandWich</h3>
                <p>is always so much fun!</p>
            </div>
        </div>

        <div class="item">
            <img
                    style="width: 80%; margin: 10%" src="http://carnivalmunchies.com/wp-content/uploads/2018/07/club-sandwich.jpg" alt="Chicago">
            <div class="carousel-caption">
                <h3>CLub Sandwich</h3>
                <p>Thank you, love u</p>
            </div>
        </div>

        <div class="item">
            <img style="width: 80%; margin: 10%" src="https://media1.s-nbcnews.com/j/newscms/2018_07/1318715/grilled-steak-today-tease-180216_89508b219dd455b4d43311782841f938.today-inline-large.jpg" alt="New York">
            <div class="carousel-caption">
                <h3>STEAK</h3>
                <p>We love the Big Steak</p>
            </div>
        </div>
    </div>

    <!-- Left and right controls -->
    <a class="left carousel-control" href="#myCarousel" data-slide="prev">
        <span class="glyphicon glyphicon-chevron-left"></span>
        <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" data-slide="next">
        <span class="glyphicon glyphicon-chevron-right"></span>
        <span class="sr-only">Next</span>
    </a>
</div>
<hr>
<form action="home" method="get">
    <table class="table table-striped">
        <thead>
        <tr>
            <th>Name</th>
            <th>Size</th>
            <th>Price</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>Classic Burger</td>
            <td>Big</td>
            <td>$5</td>
        </tr>
        <tr>
            <td>Buger with Franch Fries</td>
            <td> Really Big</td>
            <td>$9.9</td>
        </tr>
        <tr>
            <td>Beef Steak</td>
            <td>Family Size</td>
            <td>$19.5</td>
        </tr>
        </tbody>
    </table>
    <legend> <button type="submit"> OK </button></legend>
</form>

<h2> ${message}</h2>

</body>
</html>
