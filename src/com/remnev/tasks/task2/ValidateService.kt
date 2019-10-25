package com.remnev.tasks.task2

class ValidateService(private val pairLoginHash: Map<String, String>, private val pairLoginSalt: Map<String, String>) {

    fun isLoginValid(login: String): Boolean = reg.matches(login)

    fun findingUser(login: String): User? {
        return if (pairLoginSalt.containsKey(login))
            pairLoginHash[login]?.let { pairLoginSalt[login]?.let { it1 -> User(login, it1, it) } }
        else null
    }

    fun isPassCorrect(login: String, pass: String): Boolean {
        val hasher = Hasher()
        val inputHash = hasher.hash(hasher.hash(pass) + pairLoginSalt[login])
        return inputHash == pairLoginHash[login]
    }
}