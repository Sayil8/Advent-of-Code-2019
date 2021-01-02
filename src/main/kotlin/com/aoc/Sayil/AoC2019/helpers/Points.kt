package com.aoc.Sayil.AoC2019.helpers

import kotlin.math.abs

data class Point2D(val x: Int, val y: Int) {
    fun up() : Point2D = copy(y = y + 1)
    fun down() : Point2D = copy(y = y - 1)
    fun right() : Point2D = copy(x = x + 1)
    fun left() : Point2D = copy(x = x - 1)

    fun distanceTo(otherPoint: Point2D) : Int =
            abs(x - otherPoint.x) + abs(y - otherPoint.y)


    companion object{
        val origin = Point2D(0,0)
    }
}