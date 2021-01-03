package com.aoc.Sayil.AoC2019.solutions

import com.aoc.Sayil.AoC2019.inputs.input4

class Day4(private val range : IntRange) {


    private fun isSorted(input: String): Boolean =
            input.zipWithNext().all { it.first <= it.second }

    private fun containsMatchingPair(input: String): Boolean =
            input.zipWithNext().any { it.first == it.second }

    private fun containsIsolatedPair(input: String): Boolean =
            input.groupBy { it }.any { it.value.size == 2 }



    fun first() =
            range
                    .map { it.toString() }
                    .count { isSorted(it) && containsMatchingPair(it)}

    fun second() =
            range
                    .map { it.toString() }
                    .count { isSorted(it) && containsIsolatedPair(it) }

}

fun main() {
    println(Day4(input4.formattedInput).first())
    println(Day4(input4.formattedInput).second())
}