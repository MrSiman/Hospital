<!DOCTYPE html>
<#import "/spring.ftl" as spring>
<html lang="en">
<head>
    <meta charset="UTF-8">
</head>
<body>
    <table>
        <tr>
            <td>Код типа услуги</td>
            <td>Наименование типа услуги</td>
        </tr>
        <#list types as type>
            <tr>
                <td><a href="service_types/${type.typeServiceCode}"/>${type.typeServiceCode}</td>
                <td>${type.typeName}</td>
                <td><a href="service_types/update/${type.typeServiceCode}"/>Update</td>
                <td><a href="service_types/delete/${type.typeServiceCode}"/>Delete</td>
            </tr>
        </#list>
    </table><br>
    <form method="post" name = "newtype" action="service_types/add">
        Код типа услуги<input type="text" name="typeServiceCode" maxlength="6" required/><br>
        Наименование типа услуги<input type="text" name="typeName" required/><br>
        <button type="submit">Добавить новый тип услуги</button>
    </form>
    <br><br><br>
    <a href="/Hospital_war_exploded/hospital"><button>Назад</button></a>
    <br><br><br>
    <a href="/Hospital_war_exploded/logout"><button>Разлогиниться</button></a>
</body>
</html>