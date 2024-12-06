package io.emanmacario

import java.io.BufferedReader
import java.io.FileReader
import java.io.IOException

fun main() {
    val filePath = "src\\resources\\dec03.txt"

    try {
        val reader = BufferedReader(FileReader(filePath))

        var entireCommand = ""
        while (true) {
            val reportString = reader.readLine() ?: break
            entireCommand += reportString
        }

        val regex = Regex("mul\\((\\d+),(\\d+)\\)")
        val matches = regex.findAll(entireCommand)

        val total = matches.fold(0) { currentTotal, match ->
            val first = Integer.parseInt(match.groups[1]!!.value)
            val second = Integer.parseInt(match.groups[2]!!.value)

            val product = first * second
            currentTotal + product
        }
        println("Total: $total")
    } catch (e: IOException) {
        e.printStackTrace()
    }
}