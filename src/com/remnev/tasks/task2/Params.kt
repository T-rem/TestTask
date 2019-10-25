package com.remnev.tasks.task2

class Params(var login: String?, var pass: String?, var isHelp: Boolean = false) {
    constructor(arr: Array<String>) : this("", "", false) {
        if (checker(arr)) {
            when (arr[0]) {
                "-login" -> this.login = arr[1]
                "-pass" -> this.pass = arr[1]
                else -> this.isHelp = true
            }
            when (arr[2]) {
                "-login" -> this.login = arr[3]
                "-pass" -> this.pass = arr[3]
                else -> this.isHelp = true
            }
        } else this.isHelp = true
    }
}