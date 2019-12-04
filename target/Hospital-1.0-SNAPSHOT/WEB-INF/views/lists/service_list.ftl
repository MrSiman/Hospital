<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
</head>
<body>
    <table>
        <tr>
            <td><b>Код услуги</b></td>
            <td><b>Тип услуги</b></td>
            <td><b>Наименование услуги</b></td>
            <td><b>Стоимость услуги</b></td>
        </tr>
        <#list services as service>
            <tr>
                <td>${service.code}</td>
                <td>${service.typeName}</td>
                <td>${service.name}</td>
                <td>${service.cost}</td>
                <td><a href="services/update/${service.code}"/>Update</td>
                <td><a href="services/delete/${service.code}"/>Delete</td>
            </tr>
        </#list>
    </table><br>
    <form method="post" name="new_service" action="services/add" accept-charset="UTF-8"">
        Код услуги<input type="text" name="code" maxlength="6" required/><br>
        Тип услуги:   <select>
            <#list type_services as type_service>
                <option>${type_service.typeName}</option>
            </#list>
        </select><br>
        Наименование услуги<input type="text" name="name" required/><br>
        Стоимость услуги<input type="text" name="cost" required/><br>
        <button type="submit">Добавить новую услугу</button>
    </form>
    <br><br><br>
    <a href="/Hospital_war_exploded/hospital"><button>Назад</button></a>
    <br><br><br>
    <a href="/Hospital_war_exploded/logout"><button>Разлогиниться</button></a>
</body>
</html>