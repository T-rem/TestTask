package com.remnev.tasks.task2

class Params(arr: Array<String>) {
    val login: String
    val pass: String
    val isHelp: Boolean

    init {
        when(checkArgs(arr)){
            0->{
                login = arr[1]
                pass = arr[3]
                isHelp = false
            }
            1->{
                login = arr[3]
                pass = arr[1]
                isHelp = false
            }
            else ->{
                login = ""
                pass = ""
                isHelp = true
            }
        }

    }

    private fun checkArgs(arr: Array<String>): Int {
        return when{
            arr.size != 4 -> -1
            (arr.size == 4) and (arr[0] == "-login") and (arr[2] == "-pass") -> 0
            (arr.size == 4) and (arr[0] == "-pass") and (arr[2] == "-login") -> 1
            else -> 2
        }
    }
}
