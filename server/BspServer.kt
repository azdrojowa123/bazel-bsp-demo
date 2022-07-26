package server

import ch.epfl.scala.bsp4j.BuildClient
import org.eclipse.lsp4j.jsonrpc.Launcher
import io.grpc.ServerBuilder

class BspServer {

    private val bspServerApi = BspServerApi()

    fun startServer(bspIntegrationData: BspIntegrationData) {
        val launcher = Launcher.Builder<BuildClient>().traceMessages(bspIntegrationData.traceWriter)
             .setOutput(bspIntegrationData.stdout).setInput(bspIntegrationData.stdin)
             .setLocalService(bspServerApi).setRemoteInterface(BuildClient::class.java)
             .setExecutorService(bspIntegrationData.executor)
            .create()
        bspIntegrationData.launcher = launcher
        launcher.startListening()
        val client = launcher.remoteProxy
        val bepServer = BepServer(client)
        bspIntegrationData.server = ServerBuilder.forPort(0).addService(bepServer).build()

    }

}