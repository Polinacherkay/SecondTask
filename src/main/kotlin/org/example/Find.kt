package org.example

import org.kohsuke.args4j.Argument
import org.kohsuke.args4j.CmdLineException
import org.kohsuke.args4j.CmdLineParser
import org.kohsuke.args4j.Option


class Find {
    companion object {
        @Option(name = "-r")
        var r = false
        @Option(name = "-d")
        var directory = ""
        @Argument
        var filename = ""

        @JvmStatic fun main(args: Array<String>) {
            val f = Find()
            val parser = CmdLineParser(f)
            try {
                parser.parseArgument(*args)
            } catch (e: CmdLineException) {
                System.err
                return
            }
            if (filename == "" || directory == "") {
                println("Данные указаны не полностью")
            } else {
                val find = FindFile()
                println(find.findFile(r, directory, filename))
            }
            return
        }
    }
}