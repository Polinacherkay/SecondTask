package org.example

import java.io.File
import java.nio.file.Files
import java.nio.file.Paths
import java.nio.file.Path



class FindFile {
   fun findFile(r: Boolean, directory: Path, filename: Path): MutableSet<Path> {
        val result = mutableSetOf<Path>()
        val p = Paths.get(directory.toString(), filename.toString())
        if (Files.exists(p)) result.add(p)
        if (r) {
            val allFiles = Paths.get(directory.toString()).toFile() ?: return result
            val allDir = allFiles.list() ?: return result
            for (i in allDir) {
                val check = Paths.get(directory.toString(), i.toString())
                if (check.toFile().isDirectory) {
                        result.addAll(findFile(true, Paths.get(directory.toString() + File.separator + i), filename))
            }
            }
        }
        return result
    }
}