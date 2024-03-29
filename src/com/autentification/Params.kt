package com.autentification

import kotlinx.cli.ArgParser
import kotlinx.cli.ArgType
import kotlinx.cli.default
import kotlin.system.exitProcess

class Params(arr: Array<String>) {
    private val parser = ArgParser("example")
    val login by parser.option(ArgType.String, shortName = "login").default("")
    val pass by parser.option(ArgType.String, shortName = "pass").default("")
    val role by parser.option(ArgType.String, shortName = "role").default("")
    val res by parser.option(ArgType.String, shortName = "res").default("")
    val ds by parser.option(ArgType.String, shortName = "ds").default("")
    val de by parser.option(ArgType.String, shortName = "de").default("")
    val vol by parser.option(ArgType.String, shortName = "vol").default("")
    var isHelp: Boolean = false

    init {
        try {
            parser.parse(arr)
        } catch (e: Exception) {
            exitProcess(1)
        }
        when {
            (arr.size < 4) or (arr.size > 14 ) -> isHelp = true
            (login == "") or (pass == "") -> isHelp = true
        }
    }
}

