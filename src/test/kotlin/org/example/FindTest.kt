package org.example

import org.junit.Test
import java.io.File
import kotlin.test.assertEquals
import java.nio.file.Paths
import java.nio.file.Path

class FindTest {
    @Test
    fun findFile(){
        assertEquals(setOf(Paths.get("input" + File.separator + "empty.txt")),
            FindFile.findFile(false, Paths.get("input"),  Paths.get("empty.txt")))
        assertEquals(setOf(Paths.get("input" + File.separator + "second" + File.separator + "temp.txt")),
            FindFile.findFile(true, Paths.get("input"), Paths.get("temp.txt")))
        assertEquals(setOf<Path>(), FindFile.findFile(false, Paths.get("input"), Paths.get("temp.txt")))
        assertEquals(setOf(Paths.get("input" + File.separator + "empty.txt"),
            Paths.get("input" + File.separator + "second" + File.separator + "empty.txt"),
            Paths.get("input" + File.separator + "second" + File.separator + "third" + File.separator + "empty.txt")),
            FindFile.findFile(true, Paths.get("input"), Paths.get("empty.txt")))
    }
}