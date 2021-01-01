package com.aoc.Sayil.AoC2019.solutions

import com.aoc.Sayil.AoC2019.inputs.input1

private fun Int.fuel() : Int =
        (this / 3) - 2

private fun Int.fuelWithFuel() : Int =
        if( this < 9)
            0
        else {
            val fuel = this.fuel()
            fuel + fuel.fuelWithFuel()
        }

fun first(input : List<Int>) : Int =
    input.sumBy { it.fuel() }


fun second(input : List<Int>) : Int =
    input.sumBy { it.fuelWithFuel() }


fun main() {
    println(first(input1.formattedInput))
    println(second(input1.formattedInput))
}