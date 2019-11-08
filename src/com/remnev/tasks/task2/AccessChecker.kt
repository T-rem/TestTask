package com.remnev.tasks.task2

class AccessChecker(private val access: List<UserAccess>) {

    fun checkRole(role: String): Boolean {
        for (user in access) {
            if (user.role.name == role) return true
        }
        return false
    }

    fun checkResourse(res: String): Boolean {
        for (user in access) {
            if (res.contains(user.resource)) return true
        }
        return false
    }
}