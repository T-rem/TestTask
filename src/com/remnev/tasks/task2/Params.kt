package com.remnev.tasks.task2

import kotlinx.cli.ArgParser
import kotlinx.cli.ArgType
import kotlinx.cli.default

class Params(arr: Array<String>) {
    private val parser = ArgParser("example")
    val login by parser.option(ArgType.String, shortName = "login").default("")
    val pass by parser.option(ArgType.String, shortName = "pass").default("")
    val role by parser.option(ArgType.String, shortName = "role").default("")
    val res by parser.option(ArgType.String, shortName = "res").default("")
    var isHelp: Boolean by parser.option(ArgType.Boolean).default(false)

    init {
        parser.parse(arr)
        when {
            (arr.size < 4) or (arr.size > 8) -> isHelp = true
            (login == "") or (pass == "") -> isHelp = true
        }
    }
}
