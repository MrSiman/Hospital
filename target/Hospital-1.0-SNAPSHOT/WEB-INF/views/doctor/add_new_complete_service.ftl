<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
</head>
<body>
    <form method="post" action="/Hospital_war_exploded/login_doctor/add/process" name="add_new_complete_service">
        ФИО пациента:   <input type="text" name="patient_FIO" value="${patient.FIO}" readonly><br>
        Наименование услуги:   <input type="text" name="service_name" required><br>
        Дата оказания:   <input type="text" name="date_complete" value="${patient.recordingDate}" readonly><br>
        Время начала:   <input type="text" name="time_begin" required><br>
        Время окончания:   <input type="text" name="time_end" required><br>
        <button type="submit">Добавить</button>
    </form>
    <br><br><br>
    <form action="/Hospital_war_exploded/compete_services">
        <button>Назад</button>
    </form>
    <br><br><br>
    <form action="/Hospital_war_exploded/logout">
        <button>Разлогиниться</button>
    </form>
</body>
</html>