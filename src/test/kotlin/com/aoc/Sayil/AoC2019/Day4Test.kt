package com.aoc.Sayil.AoC2019
import com.aoc.Sayil.AoC2019.inputs.input4
import com.aoc.Sayil.AoC2019.solutions.Day4
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

@DisplayName("Day 4")
class Day4Test {
    // Given
    private val inputRange = input4.formattedInput

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {

        @Test
        fun `Actual answer`() {
            // When
            val answer = Day4(inputRange).first()

            // Then
            assertThat(answer).isEqualTo(1019)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {

        @Test
        fun `Actual answer`() {
            // When
            val answer = Day4(inputRange).second()

            // Then
            assertThat(answer).isEqualTo(660)
        }
    }
}