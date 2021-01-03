package com.aoc.Sayil.AoC2019.inputs

object input4 {
    val formattedInput = """
248345-746315
""".trimIndent().split("-").let {
        it[0].toInt()..it[1].toInt()
    }
}