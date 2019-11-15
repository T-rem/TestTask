package com.autentification

class AccessChecker(private val access: List<UserAccess>) {

    fun isRole(login: String, role: String): Boolean {
        for (user in access) {
            if (user.login == login && user.role.name == role) return true
        }
        return false
    }

    //Переделать т.к. не покроет все тесты
    fun isResourse(login: String, res: String, role: String): Boolean {
        val resArr = res.split(".")
        for (user in access) {
            if (user.login == login && user.role.name == role) {
                val resArr2 = user.resource.split(".")
                for (i in 0 until resArr2.size){
                    if (resArr2[i] != resArr[i]) return false
                }
            }
        }
        return true
    }

}