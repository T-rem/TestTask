package com.remnev.tasks.task1

fun main(args: Array<String>) {
        val reg = Regex("(?U)\\W+")
        var words: List<String>
        if (args.isEmpty()) {
            do {
                words = readLine().toString().split(reg)
                words = words.filter { it != "" }
            } while (words.isEmpty())
            solution(words)
        } else {
            words = argsToLine(args).split(reg)
            words = words.filter { it != "" }
            solution(words)
        }
    }

    fun solution(sol: List<String>) {
        val outAnswer: MutableMap<String, Int> = HashMap()
        for (i in 0 until sol.size) {
            val count = outAnswer[sol[i]]
            if (count == null) {
                outAnswer[sol[i]] = 1
            } else {
                outAnswer[sol[i]] = count + 1
            }
        }
        val sortedAnswer = outAnswer.toSortedMap()
        for (result in sortedAnswer) {
            println("${result.key} ${result.value}")
        }
    }

    fun argsToLine(arr: Array<String>): String {
        var line = ""
        for (i in 0 until arr.size) {
            line += arr[i] + " "
        }
        return line
    }
