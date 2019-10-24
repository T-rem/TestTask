val map = mapOf("admin" to "admin", "user1" to "user1", "user2" to "user2")const val help = ("blach-blach")val reg = Regex("^[a-zA-Z0-9]+$")fun main(args: Array<String>) {    if (args.isEmpty()) {        println(help)    } else {        val params = Params(args)        val validate = ValidateService(map)        if (!params.isHelp) {            if (validate.isLoginValid(params.login!!)) {                val user = validate.findingUser(params.login!!)                if (user != null) {                    if (validate.isPassCorrect(params.login!!, params.pass!!)) {                        println(0)                    } else println(4)                } else println(3)            } else println(2)        } else println(help)    }}fun checker(arr: Array<String>): Boolean {    return arr.size == 4}class ValidateService(private val map: Map<String, String>) {    fun isLoginValid(login: String): Boolean = reg.matches(login)    fun findingUser(login: String): User? {        return if (map.containsKey(login))            User(login, map[login])        else null    }    fun isPassCorrect(login: String, pass: String): Boolean {        return map[login] == pass    }}class Params(var login: String?, var pass: String?, var isHelp: Boolean = false) {    constructor(arr: Array<String>) : this("", "", false) {        if (checker(arr)) {            when (arr[0]) {                "-login" -> this.login = arr[1]                "-pass" -> this.pass = arr[1]            }            when (arr[2]) {                "-login" -> this.login = arr[3]                "-pass" -> this.pass = arr[3]            }        } else this.isHelp = true    }}class User(var login: String?, var pass: String?)