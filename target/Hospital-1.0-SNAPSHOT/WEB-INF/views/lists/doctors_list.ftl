<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
</head>
<body>
<table>
    <tr>
        <td>Номер паспорта</td>
        <td>Фамилия Имя Отчество</td>
        <td>Должность</td>
        <td>Заработная плата</td>
        <td>Пол</td>
    </tr>
    <#list doctors as doctor>
        <tr>
            <td>${doctor.numPassport}</td>
            <td>${doctor.FIO}</td>
            <td>${doctor.profession}</td>
            <td>${doctor.salary}</td>
            <td>${doctor.sex}</td>
            <td><a href="doctors/update/${doctor.numPassport}"/>Update</td>
            <td><a href="doctors/delete/${doctor.numPassport}"/>Delete</td>
        </tr>
    </#list>
</table><br>
    <form method="post" name="new_doctor" action="doctors/add">
        Номер паспорта:   <input type="text" name="numPassport" required/><br>
        ФИО:   <input type="text" name="FIO" required/><br>
        Должность:   <input type="text" name="profession" required/><br>
        Заработная плата:   <input type="text" name="salary" required/><br>
        Пол:      Мужской<input type="radio" name="sex" value="true" required/>      Женский<input type="radio" name="sex" value="false"/><br>
        <button type="submit">Добавить нового врача</button>
    </form>
    <br><br><br>
    <a href="/Hospital_war_exploded/hospital"><button>Назад</button></a>
    <br><br><br>
    <a href="/Hospital_war_exploded/logout"><button>Разлогиниться</button></a>
</body>
</html>