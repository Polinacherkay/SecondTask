package org.example

import org.junit.Test
import kotlin.test.assertEquals
import java.nio.file.Paths
import java.nio.file.Path

class FindTest {
    @Test
    fun findFile(){
        val find = FindFile()
        assertEquals(setOf(Paths.get("input\\empty.txt")), find.findFile(false,
            "input", "empty.txt"))
        assertEquals(setOf(Paths.get("input\\second\\temp.txt")), find.findFile(true,
            "input", "temp.txt"))
        assertEquals(setOf<Path>(), find.findFile(false,
            "input", "temp.txt"))
        assertEquals(setOf(Paths.get("input\\empty.txt"), Paths.get("input\\second\\empty.txt"),
            Paths.get("input\\second\\third\\empty.txt")), find.findFile(true,
                "input", "empty.txt"))
    }
}