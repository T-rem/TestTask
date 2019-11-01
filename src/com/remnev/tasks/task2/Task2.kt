package com.remnev.tasks.task2

import kotlin.system.exitProcess

val users = listOf(
        User("admin", ValidateService.getHash("admin"), "salt1"),
        User("user1", ValidateService.getHash("user1"), "salt2")
)
val reg = Regex("^[a-zA-Z0-9]+$")

fun main(args: Array<String>) {
    val params = Params(args)
    val validate = ValidateService(users)
    val user = validate.findUser(params.login)
    when {
        args.isEmpty() || params.isHelp -> exitProcess(1)
        !validate.isLoginValid(params.login) -> exitProcess(2)
        user == null -> exitProcess(3)
        !validate.isPassCorrect(user, params.pass) -> exitProcess(4)
        else -> exitProcess(0)
    }
}



