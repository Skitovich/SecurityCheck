
Перед запуском автотестов необходимо убедиться, что на компьютере, где они будут запускаться, установлены Docker Desktop, IntelliJ IDEA и Java 11.

Сделать форк репозитория 

Произвести настройки базовой страницы https://github.com/Skitovich/SecurityCheck/blob/master/src/test/java/com/nspkSecurityCheck/test/BaseTest.java, 
убедиться в корректности ссылки на веб приложение(сейчас приложение запускается локально)

Сверить список загружаемых расширений и время жизни ссылки(TTL) - https://github.com/Skitovich/SecurityCheck/blob/8d8d6add5921d85acc1ad8598761f1972c8e79dc/src/test/java/com/nspkSecurityCheck/test/QuestionnairePageTest.java


Запустить приложение по инструкции https://github.com/Skitovich/SecurityCheck/blob/master/readme

Убедиться что приложение запущено

Как запустить автотесты

После того как приложение запустится, в следующей соседней вкладке терминала запустить тесты командой:

gradlew test
