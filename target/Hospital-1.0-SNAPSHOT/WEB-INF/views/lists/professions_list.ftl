<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
</head>
<body>
    <table>
        <tr>
            <td><b>Код должности</b></td>
            <td><b>Название должности</b></td>
        </tr>
        <#list professions as profession>
            <tr>
                <td>${profession.code}</td>
                <td>${profession.name}</td>
                <td><a href="profession/update/${profession.code}"/>Update</td>
                <td><a href="profession/delete/${profession.code}"/>Delete</td>
            </tr>
        </#list>
    </table><br>
    <form method="post" name="new_prof" action="profession/add">
        Код должности<input type="text" name="code" maxlength="6" required/><br>
        Название должности<input type="text" name="name" required/><br>
        <button type="submit">Добавить новую должность</button>
    </form>
    <br><br><br>
    <a href="/Hospital_war_exploded/hospital"><button>Назад</button></a>
    <br><br><br>
    <a href="/Hospital_war_exploded/logout"><button>Разлогиниться</button></a>
</body>
</html>