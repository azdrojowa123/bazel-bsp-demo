package server

import java.io.PrintWriter
import java.nio.file.Files
import java.nio.file.Paths
import java.nio.file.StandardOpenOption
import java.util.concurrent.Executors


object ServerInitializer {

    @JvmStatic
    fun main(args: Array<String>){
        println("Start bsp server")
        val stdout = System.out
        val stdin = System.`in`
        val executor = Executors.newCachedThreadPool()
        val new_path = Paths.get("").toAbsolutePath().normalize().resolve(".bazelbsp")
        Files.createDirectories(new_path)
        val traceFile = new_path.resolve("bazelbsp.trace.json")
        val traceWriter = PrintWriter(
            Files.newOutputStream(
                traceFile, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING
            )
        )
        val bspIntegrationData = BspIntegrationData(stdout, stdin, executor, traceWriter)
        val bspServer = BspServer()
        bspServer.startServer(bspIntegrationData)
        val server = bspIntegrationData.server?.start()
        bspIntegrationData.launcher?.startListening()
        server?.awaitTermination()
    }

}