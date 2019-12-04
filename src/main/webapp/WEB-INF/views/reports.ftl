<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
</head>
<body>
    <form action="reports/download">
        Имя файла с отчётом:   <input type="text" name="report_name" required><br>
        <!--Куда сохраняем?   <input type="file" name="report_dir" required webkitdirectory directory multiple><br>-->
        <select name="report_type" required>
            <option value="services_types">Отчёт по списку типов услуг</option>
            <option value="services">Отчёт по списку услуг</option>
            <option value="patients">Отчёт по списку пациентов</option>
            <option value="professions">Отчёт по списку должностей</option>
            <option value="doctors">Отчёт по списку докторов</option>
            <option value="complete_services">Отчёт по списку оказанных услуг</option>
        </select><br>
        <button>Получить отчёт</button>
    </form>
    <br><br><br>
    <form action="/Hospital_war_exploded/hospital">
        <button>Назад</button>
    </form>
    <br><br><br>
    <form action="/Hospital_war_exploded/logout">
        <button>Разлогиниться</button>
    </form>
</body>
</html>