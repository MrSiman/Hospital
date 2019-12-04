<!DOCTYPE html>
<#import "/spring.ftl" as spring>
<html lang="en">
<head>
    <meta charset="UTF-8">
</head>
<body>
    <form name="update_type" method="post" action="/Hospital_war_exploded/service_types/update_process">
        Код типа услуги<input type="text" name="typeServiceCode" value="${type.typeServiceCode}" readonly/><br>
        Имя типа услуги<input type="text" name="typeName" value="${type.typeName}" required/><br>
        <button type="submit">Изменить</button>
    </form>
    <br><br><br>
    <form action="/Hospital_war_exploded/service_types">
        <button>Назад</button>
    </form>
    <br><br><br>
    <form action="/Hospital_war_exploded/logout">
        <button>Разлогиниться</button>
    </form>
</body>
</html>