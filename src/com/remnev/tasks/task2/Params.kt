package com.remnev.tasks.task2

class Params(arr: Array<String>) {
    val login: String
    val pass: String
    val isHelp: Boolean

    init {
        login = getParams(arr)[0]
        pass = getParams(arr)[1]
        isHelp = getParams(arr)[2] == "true"
    }

    private fun getParams(arr: Array<String>): Array<String> {
        val params = arrayOf("", "", "false")
        if (checker(arr)) {
            when (arr[0]) {
                "-login" -> params[0] = arr[1]
                "-pass" -> params[1] = arr[1]
                else -> params[2] = "true"
            }
            when (arr[2]) {
                "-login" -> params[0] = arr[3]
                "-pass" -> params[1] = arr[3]
                else -> params[2] = "true"
            }
        } else params[2] = "true"
        return params
    }


    private fun checker(arr: Array<String>): Boolean {
        return arr.size == 4
    }
}
