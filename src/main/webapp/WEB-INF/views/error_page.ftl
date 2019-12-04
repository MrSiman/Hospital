<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <!--<script type="text/javascript" src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
    <script type="text/javascript">
        jQuery(document).ready(function () {
            jQuery.get("", function (error_name) {
                alert(error_name);
            })
        })
     </script>-->
    <style>
        .error_window {
            width: 600px;
            height: 50px;
            text-align: center;
            padding: 15px;
            border: 3px solid #0000cc;
            border-radius: 10px;
            color: #0000cc;
            text-decoration-color: #0000cc;

            position: absolute;
            top: 0;
            right: 0;
            bottom: 0;
            left: 0;
            margin: auto;
        }
    </style>
</head>
<body>
    <div class="error_window">
        <h1>${name_error}</h1>
        <a href="/Hospital_war_exploded/"><button>В начало</button></a>
    </div>
</body>
</html>