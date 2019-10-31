package com.remnev.tasks.task2

import java.security.MessageDigest

class ValidateService(private val users: List<User>) {

    fun isLoginValid(login: String): Boolean = reg.matches(login)

    fun findUser(login: String): User? {
        for (person in users) {
            if (person.login == login) return User(person.login, person.hash, person.salt)
        }
        return null
    }

    fun isPassCorrect(user: User, pass: String): Boolean {
        return getHash(getHash(pass) + user.salt)== getHash(user.hash + user.salt)
    }

    companion object Hash {
        fun getHash(h: String): String {
            val bytes = h.toByteArray()
            val md = MessageDigest.getInstance("SHA-256")
            val digest = md.digest(bytes)
            return digest.fold("", { str, it -> str + "%02x".format(it) })
        }
    }
}