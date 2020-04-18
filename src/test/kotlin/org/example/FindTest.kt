package org.example

import org.junit.Test
import kotlin.test.assertEquals

class FindTest {
    @Test
    fun findFile(){
        val expected =
            listOf<String>("C:\\Users\\user\\IdeaProjects\\KotlinAsFirst2019\\input\\empty.txt")
        val find = FindFile()
        val result = find.findFile(true,
            "C:\\Users\\user\\IdeaProjects\\KotlinAsFirst2019\\input", "empty.txt")
        assertEquals(expected, result)
    }
}