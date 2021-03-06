# Flights Web Service

## Описание
Ищет перелет по id в файле "flights.csv" и возвращает информацию о нем в формате JSON.


### Инструменты и технологии
* Java 8
* Spring Boot
* Maven
* JUnit

### Запуск
#### 1) Используя Docker
Сервис можно запустить в docker контейнере. Для этого достаточно:
* собрать образ из Dockerfile, расположенного в корне репозитория  
 docker build -t flights_img .
* запустить контейнер с готовым образом  
 docker run -p 8080:8080 flights_img


#### 2) Используя java
В корне репозитория расположен готовый исполняемый файл flights.jar. Если нет docker, но установлена java 8:  
используйте "java -jar flights.jar" для запуска.

#### Проверка
Файл csv с информацией о перелетах должен называться flights.csv и распологаться в той же директории, что и исполняемый файл. 

В ответ на GET /flights/:id сервис вернет название рейса, дату и время вылета, дату и время прибытия. 
Если id отсутствует в файле flights.csv, ответ будет пустым.
1) Ручная проверка. После запуска сервиса перейдите на http://localhost:8080/flights/:id в браузере или воспользуйтесь утилитой curl (curl http://localhost:8080/flights/:id).
   :id заменяется на числовой id перелета.
2) Проект включает юнит тесты. (см. src/test/.../AviasalesApplicationTests)

#### Сборка
Исполняемый файл уже собран, но при желании собрать самостоятельно:  
mvnw clean package (соберет проект и создаст директорию target, куда положит исполняемый файл).


