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

### Liquibase (Version control for your database)

Миграция и версионирование базы данных выражено в модуле **market-liquibase**

Описание миграции производиться в формате: ``xml``


Директория изменений: **/db/changelog/changeSets/**

Определенная структура расположения скриптов:

```
.
..
|- db
  |- changelog
    |- chnageSets
      |- data
      |- index
      |- schema
    |- changelog-master.xml
```

Описание структуры директорий:

**db** - root директория

**changelog** - директория содержит файлы включения всех changeSets

**/db/changelog-master.xml** - main database-changelog инкапсулирует в себе все главные changeSets

**changelog** - директория содержащая все changeSets

**data** - директория содержащит changeSets нацеленных на изменение данных в БД

**index** - директория содержащит changeSets нацеленных на изменение и сопровождение indexes

**schema** - директория содержащит changeSets нацеленных на изменение схемы бызы данных (добавление или изменение таблиц)

Правила добавления новых файлов для миграции БД:

1) Именование файлов <год><месяц><день>_<час><минута>_<номер задачи>_<краткое описание>.xml;
2) Точно понимать что выполняют changeSets в файле изменений, (меняют структуру БД, добавляют данные или добавляют indexes) и помещать в соответствующую папку;
3) Каждый changeSets имеет автора и идентификатор
4) Идентификатор changeSet должен быть формата: <год><месяц><день>_<час><минута>

Пример к пункту 1:

[20200508_2251_117_CREATE_TABLE_TBX_RB_UNIT.xml](https://github.com/devpav/marketcatalog/tree/master/market-liquibase/src/main/resources/db/changelog/changeSets/schema/20200508_2251_117_CREATE_TABLE_TBX_RB_UNIT.xml)

`2020 - год 05 - месяц 08 - день 22 - час 51 - минута 117 - номер задачи CREATE_TABLE_TBX_RB_UNIT - краткое описание`

Пример к пункту 3:

```xml
<changeSet author="devpav" id="20200508_2253"/>
```



