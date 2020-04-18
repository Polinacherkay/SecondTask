package org.example

import java.nio.file.Files
import java.nio.file.Paths
import java.nio.file.InvalidPathException


class FindFile {
    fun findFile(r: Boolean, directory: String, filename: String): MutableList<String> {
        val result = mutableListOf<String>()
        val p = Paths.get(directory + "\\" + filename)
        if (Files.exists(p)) result.add(directory + "\\" + filename)
        if (r) {
            val allFiles = Paths.get(directory)
            val allDir = allFiles.toList()
            for (i in allDir) {
                val check = Paths.get(directory + "\\" + i)
                if (check.toFile().isDirectory) {
                    result.addAll(findFile(true, directory + "\\" + i, filename))
                }
            }
        }
        return result
    }
}