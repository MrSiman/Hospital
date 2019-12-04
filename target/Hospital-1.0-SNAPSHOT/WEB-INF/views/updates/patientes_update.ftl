<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
</head>
<body>
    <form method="post" name="update_patient" action="/Hospital_war_exploded/patientes/updated">
        Номер паспорта:   <input type="text" name="numPassport" value="${update_patient.numPassport}" required/><br>
        Фамилия Имя Отчество:   <input type="text" name="FIO" value="${update_patient.FIO}" required/><br>
        Дата рождения:   <input type="text" name="doB" value="${update_patient.doB}" required/><br>
        Дата записи:   <input type="text" name="recordingDate" value="${update_patient.recordingDate}" required/><br>
        Пол:      Мужской<input type="radio" name="sex" value="true" required/>      Женский<input type="radio" name="sex" value="false"/><br>
        Фамилия Имя Отчество врача:   <select name="doctorFIO">
            <#list doctors as doctor>
                <option>${doctor.FIO}</option>
            </#list>
        </select><br>
        <button type="submit">Изменить</button>
    </form>
    <br><br><br>
    <form action="/Hospital_war_exploded/patientes">
        <button>Назад</button>
    </form>
    <br><br><br>
    <form action="/Hospital_war_exploded/logout">
        <button>Разлогиниться</button>
    </form>
</body>
</html>