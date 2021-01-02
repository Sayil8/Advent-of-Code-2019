package com.aoc.Sayil.AoC2019.solutions

import com.aoc.Sayil.AoC2019.inputs.input2

private fun IntArray.setRef(at: Int, value: Int) {
    this[this[at]] = value
}

private fun IntArray.getRef(at: Int) =
        this[this[at]]

class Day2 {
    fun first(input: String, noun: Int, verb: Int) : Int {
        val instructions : IntArray = input.split(",").map { it.toInt() }.toIntArray()

        instructions[1] = noun
        instructions[2] = verb


        (instructions.indices step 4).forEach {
            when(instructions[it]) {
                1 ->
                    instructions.setRef( it + 3 ,instructions.getRef(it + 1) + instructions.getRef(it + 2))
                2 ->
                    instructions.setRef(it + 3, instructions.getRef(it + 1) * instructions.getRef(it +2))
                99 -> return instructions[0]
            }
        }
        throw IllegalStateException("Program ran out of instructions")
    }

    fun second(input: String, target : Int) : Int {

        (0..99).forEach { noun ->
            (0..99).forEach { verb ->
                if (first(input, noun, verb) == target){
                    return 100 * noun + verb
                }
            }
        }

        throw IllegalStateException("Something went wrong")
    }
}



fun main() {
    println(Day2().first(input2.formattedInput, 12, 2))
    println(Day2().second(input2.formattedInput, 19_690_720))
}