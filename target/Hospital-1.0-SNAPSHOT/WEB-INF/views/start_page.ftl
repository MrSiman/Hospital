<!DOCTYPE html>
<html lang="en">
<head>
    <meta content="text/html" charset="UTF-8">
</head>
<body>
    <h1>Регистрация пациента</h1>
    <form method="post" action="add_new_patient" name="register_patient">
        Номер паспорта   <input type="text" name="num_passport" maxlength="8" required><br>
        ФИО   <input type="text" name="FIO" required><br>
        Дата рождения   <input type="text" name="doB" maxlength="10" required><br>
        Дата записи   <input type="text" name="recording_date" maxlength="10" required><br>
        Пол:      Мужской<input type="radio" name="sex" value="true" required/>      Женский<input type="radio" name="sex" value="false"/><br>
        ФИО доктора <select name="doctor_FIO">
            <#list doctors as doctor>
                <option>${doctor.FIO}</option>
            </#list>
        </select>
        <button type="submit">Записаться</button>
    </form>
    <br><br><br>
    <a href="hospital">Перейти к списку таблиц</a>
</body>
</html>