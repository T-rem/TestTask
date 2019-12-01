package com.autentification

class AccessChecker(private val access: List<UserAccess>) {

    fun isRole(login: String, role: String): Boolean {
        for (user in access) {
            if (user.login == login && user.role.name == role) return true
        }
        return false
    }

    fun isResourse(login: String, res: String, role: String): Boolean {
        val resArr = res.split(".")
        var count = 0
        for (user in access) {
            if (user.login == login && user.role.name == role) {
                val resArr2 = user.resource.split(".")
                if (resArr.size < resArr2.size) continue
                for(i in 0 until resArr2.size){
                    if(resArr[i] == resArr2[i]) count++
                    else count = 0
                }
                if (count == resArr2.size) return true
            }
        }
        return false
    }

}