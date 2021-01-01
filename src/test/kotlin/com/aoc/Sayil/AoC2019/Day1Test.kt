package com.aoc.Sayil.AoC2019

import com.aoc.Sayil.AoC2019.inputs.input1
import com.aoc.Sayil.AoC2019.solutions.first
import com.aoc.Sayil.AoC2019.solutions.second
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

@DisplayName("Day 1")
class Day1Test {

    // Given
    private val inputs = listOf("12", "14", "1969", "100756").map { it.toInt() }

    @Nested
    @DisplayName("Part 1")
    inner class First {
        @Test
        fun `Matches example`() {
            // When
            val answer = first(inputs)

            // Then
            assertThat(answer).isEqualTo(34_241)
        }

        @Test
        fun `Actual answer`() {
            // When
            val answer = first(input1.formattedInput)

            // Then
            assertThat(answer).isEqualTo(3_291_760)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Second() {
        @Test
        fun `Matches example`() {
            // When
            val answer = second(inputs)

            // Then
            assertThat(answer).isEqualTo(51_316)
        }

        @Test
        fun `Actual answer`() {
            // When
            val answer = second(input1.formattedInput)

            // Then
            assertThat(answer).isEqualTo(4_934_767)
        }
    }
}