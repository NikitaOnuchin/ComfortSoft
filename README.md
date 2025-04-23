# MinNumberApp - Сервис поиска N-го минимального числа

Описание
Сервис предоставляет REST API для поиска N-го минимального числа в массиве данных из XLSX-файла. 
Сервис сортирует массив чисел из файла и возвращает N-й минимальный элемент.

Технологии:
• Java 17, Maven
• Spring Boot 3.4.4
• Apache POI (для работы с Excel файлами)
• SpringDoc OpenAPI (документация API)

Пример запроса:
http://localhost:8080/min?pathFile=d:/array_numbers.xlsx&N=9
Swagger UI: http://localhost:8080/swagger-ui.html

ЗАПУСК ПРИЛОЖЕНИЯ: 
src/main/java/ru/comfortSoft/MinNumberAPI/MinNumberAppApplication.java