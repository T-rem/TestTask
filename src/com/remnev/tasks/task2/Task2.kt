package com.remnev.tasks.task2

import java.security.MessageDigest


val pairLoginHash = mapOf("admin" to "d6d5b9d0efdf5ef33d99afc43f272be29321ec05cd75f903bb2125adc9806313", "user1" to "3edc3b98cf84a259a5fe3ebb56d4f6bebb09604c4ea218ff1755eb6dccedc5ef")
val pairLoginSalt = mapOf("admin" to "salt1", "user1" to "salt2")
val reg = Regex("^[a-zA-Z0-9]+$")

fun main(args: Array<String>) {
    if (args.isEmpty()) {
        println(1)
        val hasher = Hasher()
        val h = hasher.hash("user1")
        val h2 = hasher.hash(h+"salt2")
        println(h2)
    } else {
        val params = Params(args)
        if (!params.isHelp) {
            val validate = ValidateService(pairLoginHash, pairLoginSalt)
            if (validate.isLoginValid(params.login!!)) {
                val user = validate.findingUser(params.login!!)
                if (user != null) {
                    if (validate.isPassCorrect(params.login!!, params.pass!!)) {
                        println(0)
                    } else println(4)
                } else println(3)
            } else println(2)
        } else println(1)
    }
}

fun checker(arr: Array<String>): Boolean {
    return arr.size == 4
}



