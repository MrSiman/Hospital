<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
</head>
<body>
    <form method="post" name="updated_doctor" action="/Hospital_war_exploded/doctors/update_process">
        Номер паспорта:   <input type="text" name="numPassport" value="${doctor.numPassport}" readonly/><br>
        ФИО:   <input type="text" name="FIO" value="${doctor.FIO}" required/><br>
        Должность:   <input type="text" name="profession" value="${doctor.profession}" required/><br>
        Заработная плата:   <input type="text" name="salary" value="${doctor.salary}" required/><br>
        Пол:   Мужской<input type="radio" id="sex_male" name="sex" value="true" required/>      Женский<input type="radio" id="sex_female" name="sex" value="false"/><br>
        <button type="submit">Изменить</button>
    </form>
    <br><br><br>
    <form action="/Hospital_war_exploded/doctors">
        <button>Назад</button>
    </form>
    <br><br><br>
    <form action="/Hospital_war_exploded/logout">
        <button>Разлогиниться</button>
    </form>
</body>
</html>