<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
</head>
<body>
<table>
    <tr>
        <td>Имя</td>
        <td>Пароль</td>
        <td>Админка</td>
    </tr>
    <#list users as user>
        <tr>
            <td>${user.name}</td>
            <td>${user.password}</td>
            <td>${user.admin?c}</td>
            <td><a href="users/update/${user.name}"/>Update</td>
            <td><a href="users/delete/${user.name}"/>Delete</td>
        </tr>
    </#list>
</table><br>
<form action="users/add" method="post" name="new_user">
    Имя пользователя:   <input type="text" name = "name" required/><br>
    Пароль:   <input type="text" name = "password" required/><br>
    Сделать админом:   <input type="checkbox" name = "admin"/><br>
    <button type="submit">Зарегестрировать</button>
    <br><br><br><br><br>
        <a href="/Hospital_war_exploded/logout"><button>Разлогиниться</button></a>
</form>
</body>
</html>