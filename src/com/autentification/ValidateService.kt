package com.autentification

import java.security.MessageDigest
import java.time.LocalDate
import java.time.format.DateTimeFormatter

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
        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
        return try {
            LocalDate.parse(date, formatter)
            true
        }
        catch (e: Exception){
            false
        }
    }

    fun isVolCorrect(vol: String): Boolean {
        return try {
            val v = vol.toInt()
            v > 0
        }
        catch (e: Exception){
            false
        }
    }

}