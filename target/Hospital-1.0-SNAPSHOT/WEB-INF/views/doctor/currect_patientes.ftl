<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
    <table>
        <tr>
            <td>Номер паспорта</td>
            <td>Фамилия Имя Отчество</td>
            <td>Дата рождения</td>
            <td>Дата записи</td>
            <td>Пол</td>
        </tr>
        <#list current_patientes as patient>
            <tr>
                <td>${patient.numPassport}</td>
                <td>${patient.FIO}</td>
                <td>${patient.doB}</td>
                <td>${patient.recordingDate}</td>
                <td>${patient.sex}</td>
                <td><a href="add/${patient.numPassport}"/>Внести в карту обслуженных</td>
            </tr>
        </#list>
    </table><br>
    <br><br><br>
    <form action="/Hospital_war_exploded/login_doctor">
        <button>Назад</button>
    </form>
    <br><br><br>
    <form action="/Hospital_war_exploded/logout">
        <button>Разлогиниться</button>
    </form>
</body>
</html>