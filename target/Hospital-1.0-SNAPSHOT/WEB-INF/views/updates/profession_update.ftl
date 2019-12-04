<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
</head>
<body>
    <form name="update_prof" method="post" action="/Hospital_war_exploded/profession/update_process">
        Код должности<input type="text" name="code" value="${update_prof.code}" readonly/><br>
        Название должности<input type="text" name="name" value="${update_prof.name}" required/><br>
        <button type="submit">Изменить</button>
    </form>
    <br><br><br>
    <form action="/Hospital_war_exploded/profession">
        <button>Назад</button>
    </form>
    <br><br><br>
    <form action="/Hospital_war_exploded/logout">
        <button>Разлогиниться</button>
    </form>
</body>
</html>