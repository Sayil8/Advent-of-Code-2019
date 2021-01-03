package com.aoc.Sayil.AoC2019.solutions

import com.aoc.Sayil.AoC2019.inputs.input5
import kotlin.math.pow


class IntCodeComputer(private val program: IntArray,
                      private val input: MutableList<Int> = mutableListOf()
) {
    constructor(program: IntArray, singleInput: Int) : this(program, mutableListOf(singleInput))

    fun run(): List<Int> {
        var instructionPointer = 0
        val output = mutableListOf<Int>()

        do {
            val nextOp = IntCodeInstruction(instructionPointer, program)
            instructionPointer += nextOp.execute(instructionPointer, program, input, output)
        } while (nextOp !is IntCodeInstruction.Halt)

        return output
    }
}

sealed class IntCodeInstruction(internal val nextInstructionOffset: Int) {
    abstract fun execute(pointer: Int,
                         program: IntArray,
                         input: MutableList<Int>,
                         output: MutableList<Int>): Int

    private fun Int.toParameterMode(pos: Int): Int =
            this / (10.0.pow(pos + 1).toInt()) % 10

    internal fun IntArray.param(paramNo: Int, offset: Int): Int =
            this.getRef(this[offset].toParameterMode(paramNo), offset + paramNo)

    private fun IntArray.getRef(mode: Int, at: Int): Int =
            when (mode) {
                0 -> this[this[at]]
                1 -> this[at]
                else -> throw IllegalArgumentException("Unknown mode: $mode")
            }

    object Add : IntCodeInstruction(4) {
        override fun execute(pointer: Int, program: IntArray, input: MutableList<Int>, output: MutableList<Int>): Int {
            val writeTo = program[pointer + 3]
            program[writeTo] = program.param(1, pointer) + program.param(2, pointer)
            return nextInstructionOffset
        }
    }

    object Multiply : IntCodeInstruction(4) {
        override fun execute(pointer: Int, program: IntArray, input: MutableList<Int>, output: MutableList<Int>): Int {
            val writeTo = program[pointer + 3]
            program[writeTo] = program.param(1, pointer) * program.param(2, pointer)
            return nextInstructionOffset
        }
    }

    object Input : IntCodeInstruction(2) {
        override fun execute(pointer: Int, program: IntArray, input: MutableList<Int>, output: MutableList<Int>): Int {
            val writeTo = program[pointer + 1]
            program[writeTo] = input.removeAt(0)
            return nextInstructionOffset
        }
    }

    object Output : IntCodeInstruction(2) {
        override fun execute(pointer: Int, program: IntArray, input: MutableList<Int>, output: MutableList<Int>): Int {
            output.add(program.param(1, pointer))
            return nextInstructionOffset
        }
    }

    object Halt : IntCodeInstruction(1) {
        override fun execute(pointer: Int, program: IntArray, input: MutableList<Int>, output: MutableList<Int>): Int = 0
    }

    object JumpIfTrue : IntCodeInstruction(3) {
        override fun execute(pointer: Int, program: IntArray, input: MutableList<Int>, output: MutableList<Int>): Int {
            val a = program.param(1, pointer)
            val b = program.param(2, pointer)
            return if (a != 0) b - pointer else nextInstructionOffset
        }
    }

    object JumpIfFalse : IntCodeInstruction(3) {
        override fun execute(pointer: Int, program: IntArray, input: MutableList<Int>, output: MutableList<Int>): Int {
            val a = program.param(1, pointer)
            val b = program.param(2, pointer)
            return if (a == 0) b - pointer else nextInstructionOffset
        }
    }

    object LessThan : IntCodeInstruction(4) {
        override fun execute(pointer: Int, program: IntArray, input: MutableList<Int>, output: MutableList<Int>): Int {
            val writeTo = program[pointer + 3]
            program[writeTo] = if (program.param(1, pointer) < program.param(2, pointer)) 1 else 0
            return nextInstructionOffset
        }
    }

    object Equals : IntCodeInstruction(4) {
        override fun execute(pointer: Int, program: IntArray, input: MutableList<Int>, output: MutableList<Int>): Int {
            val writeTo = program[pointer + 3]
            program[writeTo] = if (program.param(1, pointer) == program.param(2, pointer)) 1 else 0
            return nextInstructionOffset
        }
    }

    companion object {
        operator fun invoke(pointer: Int, program: IntArray): IntCodeInstruction {
            return when ( val operation = program[pointer] % 100) {
                1 -> Add
                2 -> Multiply
                3 -> Input
                4 -> Output
                5 -> JumpIfTrue
                6 -> JumpIfFalse
                7 -> LessThan
                8 -> Equals
                99 -> Halt
                else -> throw IllegalArgumentException("Unknown operation: $operation")
            }
        }
    }
}

class Day5(input : String) {

    private val program = input.split(",").map { it.toInt() }.toIntArray()

    private fun solve(instruction: Int): Int =
            IntCodeComputer(program, instruction).run().last()

    fun first() : Int =
        solve(1)

    fun second () : Int =
            solve(5)

}

fun main() {
    println(Day5(input5.formattedInput).first())
    println(Day5(input5.formattedInput).second())
}