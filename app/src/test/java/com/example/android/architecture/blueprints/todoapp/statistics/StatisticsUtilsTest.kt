package com.example.android.architecture.blueprints.todoapp.statistics

import com.example.android.architecture.blueprints.todoapp.data.Task
import org.junit.Assert.*
import org.junit.Test
import org.hamcrest.CoreMatchers.`is` as iss

class StatisticsUtilsTest {

    @Test
    fun getActiveAndCompletedStats_noCompleted_returnsHundredZero() {

        // Create an active task
        val tasks = listOf<Task>(
                Task("title", "desc", isCompleted = false)
        )

        // Call your function
        val result = getActiveAndCompletedStats(tasks)

        // Check the result
        assertThat(result.completedTasksPercent, iss(0f))
        assertThat(result.activeTasksPercent, iss(100f))
    }

    @Test
    fun getActiveAndCompletedStats_oneCompleted_returnsZeroHundred() {

        // Create an active task
        val tasks = listOf<Task>(
                Task("title", "desc", isCompleted = true)
        )

        // Call your function
        val result = getActiveAndCompletedStats(tasks)

        // Check the result
        assertThat(result.completedTasksPercent, iss(100f))
        assertThat(result.activeTasksPercent, iss(0f))
    }

    @Test
    fun getActiveAndCompletedStats_twoCompleted_threeActive_returnsFortySixty() {

        // Create an active task
        val tasks = listOf<Task>(
                Task("title", "desc", isCompleted = true),
                Task("title", "desc", isCompleted = true),
                Task("title", "desc", isCompleted = false),
                Task("title", "desc", isCompleted = false),
                Task("title", "desc", isCompleted = false)
        )

        // Call your function
        val result = getActiveAndCompletedStats(tasks)

        // Check the result
        assertThat(result.completedTasksPercent, iss(40f))
        assertThat(result.activeTasksPercent, iss(60f))
    }

    @Test
    fun getActiveAndCompletedStats_emptyList_returnsZero() {

        // Given
        val tasks = emptyList<Task>()

        // When
        val result = getActiveAndCompletedStats(tasks)

        // Then
        assertThat(result.completedTasksPercent, iss(0f))
        assertThat(result.activeTasksPercent, iss(0f))
    }


    @Test
    fun getActiveAndCompletedStats_nullList_returnsZero() {

        // Given
        val tasks: List<Task>? = null

        // When
        val result = getActiveAndCompletedStats(tasks)

        // Then
        assertThat(result.completedTasksPercent, iss(0f))
        assertThat(result.activeTasksPercent, iss(0f))
    }

}