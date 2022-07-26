package server

import java.io.InputStream
import io.grpc.Server
import ch.epfl.scala.bsp4j.BuildClient
import java.io.PrintStream
import java.io.PrintWriter
import org.eclipse.lsp4j.jsonrpc.Launcher
import java.util.concurrent.ExecutorService

data class BspIntegrationData (val stdout: PrintStream, val stdin: InputStream, val executor: ExecutorService,
                               val traceWriter: PrintWriter, var launcher: Launcher<BuildClient> ? = null, var server: Server ? = null)