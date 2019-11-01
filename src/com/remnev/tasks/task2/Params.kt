package com.remnev.tasks.task2

class Params(arr: Array<String>) {
    val login: String
    val pass: String
    val isHelp: Boolean

    init {
        when {
            arr.size != 4 -> {
                login = ""
                pass = ""
                isHelp = true
            }
            (arr.size == 4) and (arr[0] == "-login") and (arr[2] == "-pass") -> {
                login = arr[1]
                pass = arr[3]
                isHelp = false
            }
            (arr.size == 4) and (arr[0] == "-pass") and (arr[2] == "-login") -> {
                login = arr[3]
                pass = arr[1]
                isHelp = false
            }
            else -> {
                login = ""
                pass = ""
                isHelp = true
            }
        }
    }
}
