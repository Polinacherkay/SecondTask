package org.example

import org.junit.Test
import kotlin.test.assertEquals
import java.nio.file.Paths
import java.nio.file.Path

class FindTest {
    @Test
    fun findFile(){
        val expected =
            setOf<Path>(Paths.get("input\\empty.txt"))
        val find = FindFile()
        val result = find.findFile(true,
            "input", "empty.txt")
        assertEquals(expected, result)
    }
}