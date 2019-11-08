```
 Дополнительные коды возврата:
    5 - неизвестная роль
    6 - не доступа к ресурсу
```
1. Создать enum class для ролей пользователя:
enum class Roles{
READ, WRITE, EXECUTE
}
2. Создать отдельный класс UserAccess(login: String, resource: String, role: Roles)
3. Написать тесты:
    3.1. -login admin -pass admin -res AB.C.D -role EXECUTE -> 0
    3.2. -login user1 -pass user1 -res AB.C -role READ ->0
    3.3. -login admin -pass admin -role EXECUTE -res AB.C.D (параметры role и res в обратном порядке) -> 0
    3.4. -pass admin -login admin -role EXECUTE -res AB.C.D (параметры в обратном порядке) -> 0
    3.5. -login user1 -pass user1 -res AB.C (в данном случае параметр res отбрасываем и производим обработку пользователя с учетом правильности только двух параметров) -> 0
    3.6. -login user1 –pass user -res АВ.C –role EXECUTE -> 6
    3.7. -login admin –pass admin -res АВ –role FULLACCESS -> 5

4. Добавить в класс Params поля res и role
5. Распарсить строку с учетом новых полей в классе Params
6. Добавить в ValidateService методы проверки правильности роли и ресурса для вызванного пользователя
    