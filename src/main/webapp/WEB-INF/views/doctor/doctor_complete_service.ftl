<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
</head>
<body>
<table>
    <tr>
        <td>ID</td>
        <td>Наименование услуги</td>
        <td>ФИО пациента</td>
        <td>Дата оказания услуги</td>
        <td>Время начала</td>
        <td>Время окончания</td>
        <td>Стоимость</td>
    </tr>
    <#list complete_services as service>
        <tr>
            <td>${service.id}</td>
            <td>${service.serviceName}</td>
            <td>${service.namePatient}</td>
            <td>${service.dateComplete}</td>
            <td>${service.timeBegin}</td>
            <td>${service.timeEnd}</td>
            <td>${service.cost}</td>
        </tr>
    </#list>
</table>
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