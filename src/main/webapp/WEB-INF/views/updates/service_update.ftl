<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
    <form name="updated_service" method="post" action="/Hospital_war_exploded/services/update_process">
        Код услуги:   <input type="text" name="code" value="${service.code}" readonly/><br>
        Наименование типа услуги:   <select>
            <#list type_services as type_service>
                <option>${type_service.typeName}</option>
            </#list>
        </select><br>
        Наименование услуги:   <input type="text" name="name" value="${service.name}" required/><br>
        Стоимость услуги:   <input type="text" name="cost" value="${service.cost}" required/><br>
        <button type="submit">Изменить</button>
    </form>
    <br><br><br>
    <form action="/Hospital_war_exploded/services">
        <button>Назад</button>
    </form>
    <br><br><br>
    <form action="/Hospital_war_exploded/logout">
        <button>Разлогиниться</button>
    </form>
</body>
</html>