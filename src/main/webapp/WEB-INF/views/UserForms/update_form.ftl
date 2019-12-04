<!DOCTYPE html>
<#import "/spring.ftl" as spring>
<html lang="ru">
<head>
    <meta charset="UTF-8">
</head>
<body>
    <form method="post" action="/Hospital_war_exploded/users/updated" name = "update_user">
        Имя пользователя:   <input type="text" name="name" value="${user.name}" readonly/><br>
        Пароль:   <input type="text" name="password" value="${user.password}" required/><br>
        Админка:   <input type="checkbox" name="admin"><br>
        <button type="submit">Изменить</button>
    </form>
    <br><br><br>
    <form action="/Hospital_war_exploded/users">
        <button>Назад</button>
    </form>
    <br><br><br>
    <form action="/Hospital_war_exploded/logout">
        <button>Разлогиниться</button>
    </form>
</body>
</html>