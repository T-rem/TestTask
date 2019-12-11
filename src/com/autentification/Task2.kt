package com.autentification

import kotlin.system.exitProcess

val users = listOf(
        User("admin", ValidateService.getHash("admin"), "salt1"),
        User("user1", ValidateService.getHash("user1"), "salt2")
)
val usersAccess = listOf(
        UserAccess("admin", "AB", Roles.EXECUTE),
        UserAccess("admin", "A.BC.D", Roles.EXECUTE),
        UserAccess("admin", "AB", Roles.READ),
        UserAccess("admin", "AB", Roles.WRITE),
        UserAccess("user1", "AB.C", Roles.READ)
)

fun main(args: Array<String>) {
    val params = Params(args)
    val validate = ValidateService(users)
    val user = validate.findUser(params.login)
    val access = AccessChecker(usersAccess)
    when {
        args.isEmpty() || params.isHelp -> exitProcess(1)
        !validate.isLoginValid(params.login) -> exitProcess(2)
        user == null -> exitProcess(3)
        !validate.isPassCorrect(user, params.pass) -> exitProcess(4)
        (params.res == "") or (params.role == "") -> exitProcess(0)
        !access.isRoleCorrect(params.login, params.role) -> exitProcess(5)
        !access.isResourceCorrect(params.login, params.res, params.role) -> exitProcess(6)
        (params.de == "") or (params.ds == "") or (params.vol == "")  -> exitProcess(0)
        !validate.isVolCorrect(params.vol) -> exitProcess(7)
        !validate.isDateCorrect(params.ds) -> exitProcess(7)
        !validate.isDateCorrect(params.de) -> exitProcess(7)
        else -> exitProcess(0)
    }
}