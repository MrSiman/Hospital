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
            <td>Дата рождения</td>
            <td>Дата записи</td>
            <td>Пол</td>
            <td>Фамилия Имя Отчество врача</td>
        </tr>
        <#list patientes as patient>
            <tr>
                <td>${patient.numPassport}</td>
                <td>${patient.FIO}</td>
                <td>${patient.doB}</td>
                <td>${patient.recordingDate}</td>
                <td>${patient.sex}</td>
                <td>${patient.doctorFIO}</td>
                <td><a href="patientes/update/${patient.numPassport}"/>Update</td>
                <td><a href="patientes/delete/${patient.numPassport}"/>Delete</td>
            </tr><br>
        </#list>
    </table><br>
    <form name="new_patient" method="post" action="patientes/add">
        Номер паспорта:   <input type="text" name="numPassport" maxlength="8" required/><br>
        Фамилия Имя Отчество:   <input type="text" name="FIO" required/><br>
        Дата рождения:   <input type="text" name="doB" maxlength="10" required/><br>
        Дата записи:   <input type="text" name="recordingDate" maxlength="10" v/><br>
        Пол:      Мужской<input type="radio" name="sex" value="true" required/>      Женский<input type="radio" name="sex" value="false"/><br>
        Фамилия Имя Отчество врача:   <select name="doctorFIO">
            <#list doctors as doctor>
                <option>${doctor.FIO}</option>
            </#list>
        </select><br>
        <button type="submit">Добавить нового пациента</button>
    </form>
    <br><br><br>
    <a href="/Hospital_war_exploded/hospital"><button>Назад</button></a>
    <br><br><br>
    <a href="/Hospital_war_exploded/logout"><button>Разлогиниться</button></a>
</body>
</html>