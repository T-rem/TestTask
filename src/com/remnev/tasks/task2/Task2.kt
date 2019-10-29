package com.remnev.tasks.task2

val admin = User("admin", "d6d5b9d0efdf5ef33d99afc43f272be29321ec05cd75f903bb2125adc9806313", "salt1")
val user1 = User("user1", "3edc3b98cf84a259a5fe3ebb56d4f6bebb09604c4ea218ff1755eb6dccedc5ef", "salt2")
val users = listOf<User>(admin, user1)
val reg = Regex("^[a-zA-Z0-9]+$")

fun main(args: Array<String>) {
    if (args.isEmpty()) println(1)
    else {
        val params = Params(args)
        if (!params.isHelp) {
            val validate = ValidateService(users)
            val user = validate.findingUser(params.login)
            when {
                !validate.isLoginValid(params.login) -> println(2)
                user == null -> println(3)
                validate.isPassCorrect(user, params.pass) -> println(0)
                else -> println(4)
            }
        } else println(1)
    }
}



