package com.aoc.Sayil.AoC2019.solutions

import com.aoc.Sayil.AoC2019.helpers.Point2D
import com.aoc.Sayil.AoC2019.inputs.input3
import java.lang.IllegalArgumentException

class Day3(input : List<String>) {

    private fun parseWire(wire : String) : List<Point2D> {
        var current = Point2D.origin
        return wire.split(",").flatMap {
            val direction = it.first()
            val steps = it.drop(1).toInt()
            (0 until steps).map {
                val next = when(direction) {
                    'U' -> current.up()
                    'D' -> current.down()
                    'L' -> current.left()
                    'R' -> current.right()
                    else -> throw IllegalArgumentException("Not valid direction")
                }
                current = next
                next
            }
        }
    }

    private val wire1 = parseWire(input.first())
    private val wire2 = parseWire(input.last())

    private val intersections : Set<Point2D> = wire1.intersect(wire2)


    fun first() :Int =
            intersections.map { it.distanceTo(Point2D.origin) }.minOrNull()!!


    fun second() : Int =
            intersections.map {
                println(it)
                println(wire1.indexOf(it))
                println(wire2.indexOf(it))
                wire1.indexOf(it) + wire2.indexOf(it) + 2
            }.minOrNull()!!
}

fun main() {
    println(Day3(input3.formattedInput).first())
    println(Day3(input3.formattedInput).second())
}