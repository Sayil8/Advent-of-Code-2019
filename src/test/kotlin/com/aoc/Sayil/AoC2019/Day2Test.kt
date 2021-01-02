package com.aoc.Sayil.AoC2019

import com.aoc.Sayil.AoC2019.inputs.input2
import com.aoc.Sayil.AoC2019.solutions.Day2
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test


@DisplayName("Day 2")
class Day2Test {

    @Nested
    @DisplayName("Part 1")
    inner class First {
        @Test
        fun `Matches example`() {
            //Given
             val input = "1,1,1,4,99,5,6,0,99"

            // When
            val answer = Day2().first(input,0,0)

            // Then
            assertThat(answer).isEqualTo(30)
        }

        @Test
        fun `Actual answer`() {
            // Given
            val input = input2.formattedInput

            // When
            val answer = Day2().first(input, 12, 2)

            //Then
            assertThat(answer).isEqualTo(5_098_658)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Second{

        @Test
        fun `Actual answer` () {
            // Given
            val input = input2.formattedInput

            //When
            val answer = Day2().second(input, 19_690_720)

            //Then
            assertThat(answer).isEqualTo(5_064)
        }
    }
}