## Описание:
Программа представляет из себя текстовый редактор, который принимает на вход аргумент/аргументы командной строки:
1. Выделяет из аргумента/аргументов уникальные слова.
2. Подсчитывает каждое уникальное слово.
3. Сортирует по алфавиту.
4. Выводит полученный результат.
	
## Запуск:
Осуществляется путем вызова ```application.jar``` из командной строки. Данный файл находится в папке ```src/```.

Перед запуском необходимо собрать ```application.jar``` путем запуска скрипта через интерпритатор sh ```building.sh```, который находится в корневой папке.

Варианты запуска:

1. ```java -jar application.jar```` (В данном случае после выполнения команды необходимо вручную ввести параметры для программы)
2. ```java -jar application.jar` arguments``` (Место "arguments" задаются необходимые параметры)
3. ```java -jar application.jar` "arguments"``` (Аналогично с п.2)
4. ```echo "arguments" | java -jar application.jar``` (Апалогично с п.2)
	
## Тестирование:
Осуществляется при помощи запуска скрипта ```testingScript.sh```. Данный файл находится в корневой папке ```TestTask```.

Правила работы со скриптом:
1. В файле ```Test.txt``` необходимо в первой строке указать желаемые аргументы для запуска программы
2. Вторую строку оставить пустой
3. Начиная с третей строки написать ожидаемый вывод программы при заданных аргументах, к примеру:

```
the quick brown fox jumps over the lazy dog dog

brown 1
dog 2
fox 1
jumps 1
lazy 1
over 1
quick 1
the 2
```
	
4\. Установить для спкрипта флаг исполняемости ```chmod ugo+x testingScript.sh```

5\. Запустить скрипт в командной строке через через интерпритатотр sh или bash (```sh testingScript.sh``` или ```bash testingScript.sh```)

6\. Скрипт на вывод выдает ваши заданные параметры, ожидаемый вывод программы и актуальный вывод программы, к примеру:

```
Tnput: the quick brown fox jumps over the lazy dog dog

Expected output:
brown 1
dog 2
fox 1
jumps 1
lazy 1
over 1
quick 1
the 2

Actual output:
brown 1
dog 2
fox 1
jumps 1
lazy 1
over 1
quick 1
the 2
```
	
7\. Самостоятельно сравнить ожидаемый и актуальный вывод. 
