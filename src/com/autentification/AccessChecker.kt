package com.autentification

class AccessChecker(private val access: List<UserAccess>) {

    fun checkRole(role: String): Boolean {
        for (user in access) {
            if (user.role.name == role) return true
        }
        return false
    }
//Переделать т.к. не покроет все тесты
    fun checkResourse(res: String): Boolean {
        for (user in access) {
            if (res.contains(user.resource)) return true
        }
        return false
    }
}