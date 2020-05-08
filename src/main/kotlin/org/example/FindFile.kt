package org.example

import java.nio.file.Files
import java.nio.file.Paths
import java.nio.file.Path



class FindFile {
    fun findFile(r: Boolean, directory: String, filename: String): MutableSet<Path> {
            val result = mutableSetOf<Path>()
            val p = Paths.get(directory, filename)
            if (Files.exists(p)) result.add(p)
            if (r) {
                val allFiles = Paths.get(directory).toFile()
                val allDir = allFiles.list()
                for (i in allDir) {
                    val check = Paths.get(directory, i.toString())
                    if (check.toFile().isDirectory) {
                        result.addAll(findFile(true, directory + "\\" + i, filename))
                    }
                }
            }
        return result
    }
}