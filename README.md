# marketcatalog

Репозиторий содержит исходный код проекта интернет каталога для бизнеса в сфере продаж. 

### Technology Stack

#### Programing language: 
- **Kotlin** > 1.3.61 version

#### Frameworks:
- **Spring Boot** > 2.2.0 version [data, test, web]

#### Documentation:
- **Swagger** > 2.8.0 version
- **Slf4j** logging

#### Database:
- **H2** > 1.4.200 version
- **PostgreSQL** > 42.2.8 version

### Application framework

#### Modules:

- **parent** - родительский pom module
- **market-api** - дочерний module отвечающий за функциональную часть приложения
- **asfor-parser** - дочерний module отвечающий за сбор информации с внешних ресурсов (https://asforos.by/)

### The application infrastructure

- **nginx** - проксирующий сервис
- **backend** - API интернет каталога
- **ui** - пользовательский интерфейс
- **postgres** - хранение данных

### Running

*Переходим в корневую папку*:

```
.
..
|- asforos-parser 
|- docker
|- json
|- market-api
|- .gitignore
|- pom.xml
```
*Выполняем команду по сборке Docker images:*

```cmd
  ./docker/system.local.build.bat
```

*После успешной сборки запускаем инфраструктуру приложения:*

```cmd
  ./docker/system.local.run.bat
```

*После выполненных с успехом команд, API приложения будет доступно [здесь](http://localhost:8080/api).* 

*Для того чтобы остановить приложение выполните команду:*

```cmd
  ./docker/system.local.down.bat
```
