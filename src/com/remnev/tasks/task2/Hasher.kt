package com.remnev.tasks.task2

import java.security.MessageDigest

class Hasher {
    fun hash(h: String): String {
        val bytes = h.toByteArray()
        val md = MessageDigest.getInstance("SHA-256")
        val digest = md.digest(bytes)
        return digest.fold("", { str, it -> str + "%02x".format(it) })
    }
}