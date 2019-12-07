package com.autentification

import java.security.MessageDigest
import kotlin.system.exitProcess

class ValidateService(private val users: List<User>) {
    private val reg = Regex("^[a-zA-Z0-9]+$")

    fun isLoginValid(login: String): Boolean = reg.matches(login)

    fun findUser(login: String): User? {
        for (person in users) {
            if (person.login == login) return User(person.login, person.hash, person.salt)
        }
        return null
    }

    fun isPassCorrect(user: User, pass: String): Boolean {
        return getHash(getHash(pass) + user.salt) == getHash(user.hash + user.salt)
    }

    companion object Hash {
        fun getHash(h: String): String {
            val bytes = h.toByteArray()
            val md = MessageDigest.getInstance("SHA-256")
            val digest = md.digest(bytes)
            return digest.fold("", { str, it -> str + "%02x".format(it) })
        }
    }

    fun isDateCorrect(date: String): Boolean {
        TODO();
    }

    fun isVolCorrect(vol: String): Boolean {
        try {
            val v = vol.toInt()
            return v % 1 == 0 && v > 0
        }
        catch (e: Exception){
            exitProcess(1)
        }
    }

}