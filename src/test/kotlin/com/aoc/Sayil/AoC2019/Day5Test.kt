package com.aoc.Sayil.AoC2019

import com.aoc.Sayil.AoC2019.inputs.input5
import com.aoc.Sayil.AoC2019.solutions.Day5
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

@DisplayName("Day 5")
class Day5Test {

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {

        @Test
        fun `Actual answer`() {
            // Given
            val input = input5.formattedInput

            // When
            val answer = Day5(input).first()

            // Then
            assertThat(answer).isEqualTo(16_209_841)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {

        @Test
        fun `Actual answer`() {
            // Given
            val input = input5.formattedInput

            // When
            val answer = Day5(input).second()

            // Then
            assertThat(answer).isEqualTo(8_834_787)
        }
    }
}