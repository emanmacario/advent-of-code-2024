package io.emanmacario

import java.io.BufferedReader
import java.io.FileReader
import java.io.IOException

fun main() {
    val filePath = "src\\resources\\dec02.txt"
    try {
        val reader = BufferedReader(FileReader(filePath))

        var totalSafeReports = 0
        while (true) {
            val reportString = reader.readLine() ?: break
            val levelsString = reportString.split(" ")
            val levels = levelsString.map { Integer.parseInt(it) }
            val adjacentLevelPairs = levels.zipWithNext()

            val isSortedAsc = adjacentLevelPairs.all { pair ->
                val isAscending = pair.first <= pair.second
                val absDiff = Math.abs(pair.first - pair.second)
                val satisfiesDiffConstraint =  absDiff in 1..3
                isAscending && satisfiesDiffConstraint
            }
            val isSortedDesc = adjacentLevelPairs.all { pair ->
                val isDescending = pair.first >= pair.second
                val absDiff = Math.abs(pair.first - pair.second)
                val satisfiesDiffConstraint =  absDiff in 1..3
                isDescending && satisfiesDiffConstraint
            }
            if (isSortedAsc || isSortedDesc) {
                totalSafeReports += 1
            }
        }
        print("Total safe reports: $totalSafeReports")
    } catch (e: IOException) {
        e.printStackTrace()
    }
}