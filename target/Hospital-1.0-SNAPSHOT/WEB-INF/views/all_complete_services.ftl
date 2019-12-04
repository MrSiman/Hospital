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
            <td>ФИО врача</td>
            <td>ФИО пациента</td>
            <td>Дата оказания услуги</td>
            <td>Время начала</td>
            <td>Время окончания</td>
            <td>Стоимость</td>
        </tr>
        <#list all_complete_services as service>
            <tr>
                <td>${service.id}</td>
                <td>${service.serviceName}</td>
                <td>${service.nameDoctor}</td>
                <td>${service.namePatient}</td>
                <td>${service.dateComplete}</td>
                <td>${service.timeBegin}</td>
                <td>${service.timeEnd}</td>
                <td>${service.cost}</td>
                <td><a href="all_complete_services/delete/${service.id}"/>Delete</td>
            </tr>
        </#list>
    </table>
</body>
</html>