package org.example

import org.kohsuke.args4j.Argument
import org.kohsuke.args4j.CmdLineException
import org.kohsuke.args4j.CmdLineParser
import org.kohsuke.args4j.Option
import kotlin.system.exitProcess
import java.nio.file.Path


class Find {
    companion object {
        @Option(name = "-r")
        private var r = false
        @Option(name = "-d", required = true)
        private lateinit var directory: Path
        @Argument(required = true)
        private lateinit var filename: Path

        @JvmStatic fun main(args: Array<String>) {
            val f = Find()
            val parser = CmdLineParser(f)
            try {
                parser.parseArgument(*args)
            } catch (e: CmdLineException){
                System.err.println(e.message)
                parser.printUsage(System.err)
                exitProcess(1)
            }
            val find = FindFile()
            println(find.findFile(r, directory, filename))
        }
    }
}