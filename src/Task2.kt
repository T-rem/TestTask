import java.security.MessageDigest


val pairLoginHash = mapOf("admin" to "d6d5b9d0efdf5ef33d99afc43f272be29321ec05cd75f903bb2125adc9806313", "user1" to "3edc3b98cf84a259a5fe3ebb56d4f6bebb09604c4ea218ff1755eb6dccedc5ef")
val pairLoginSalt = mapOf("admin" to "salt1", "user1" to "salt2")
val reg = Regex("^[a-zA-Z0-9]+$")

fun main(args: Array<String>) {
    if (args.isEmpty()) {
        println(1)
        val hasher = Hasher()
        val h = hasher.hash("user1")
        val h2 = hasher.hash(h+"salt2")
        println(h2)
    } else {
        val params = Params(args)
        if (!params.isHelp) {
            val validate = ValidateService(pairLoginHash, pairLoginSalt)
            if (validate.isLoginValid(params.login!!)) {
                val user = validate.findingUser(params.login!!)
                if (user != null) {
                    if (validate.isPassCorrect(params.login!!, params.pass!!)) {
                        println(0)
                    } else println(4)
                } else println(3)
            } else println(2)
        } else println(1)
    }
}

fun checker(arr: Array<String>): Boolean {
    return arr.size == 4
}

class ValidateService(private val pairLoginHash: Map<String, String>, private val pairLoginSalt: Map<String, String>) {

    fun isLoginValid(login: String): Boolean = reg.matches(login)

    fun findingUser(login: String): User? {
        return if (pairLoginSalt.containsKey(login))
            pairLoginHash[login]?.let { pairLoginSalt[login]?.let { it1 -> User(login, it1, it) } }
        else null
    }

    fun isPassCorrect(login: String, pass: String): Boolean {
        val hasher = Hasher()
        val inputHash = hasher.hash(hasher.hash(pass) + pairLoginSalt[login])
        return inputHash == pairLoginHash[login]
    }
}

class Hasher {
    fun hash(h: String): String {
        val bytes = h.toByteArray()
        val md = MessageDigest.getInstance("SHA-256")
        val digest = md.digest(bytes)
        return digest.fold("", { str, it -> str + "%02x".format(it) })
    }
}

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

class User(val login: String?, val hash: String, val salt: String)

