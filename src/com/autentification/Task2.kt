package com.autentification

import kotlin.system.exitProcess

val users = listOf(
        User("admin", ValidateService.getHash("admin"), "salt1"),
        User("user1", ValidateService.getHash("user1"), "salt2")
)
val usersAccess = listOf(
        UserAccess("admin", "AB", Roles.EXECUTE),
        UserAccess("admin", "AB", Roles.READ),
        UserAccess("admin", "AB", Roles.WRITE),
        UserAccess("user1", "AB.C", Roles.READ)
)

fun main(args: Array<String>) {
    val params = Params(args)
    val access = AccessChecker(usersAccess)
    val validate = ValidateService(users)
    val user = validate.findUser(params.login)
    when {
        args.isEmpty() || params.isHelp -> exitProcess(1)
        !validate.isLoginValid(params.login) -> exitProcess(2)
        user == null -> exitProcess(3)
        !validate.isPassCorrect(user, params.pass) -> exitProcess(4)
        (params.res == "") or (params.role == "") -> exitProcess(0)
        !access.checkRole(params.role) -> exitProcess(5)
        !access.checkResourse(params.res) -> exitProcess(6)
        else -> exitProcess(0)
    }
}



