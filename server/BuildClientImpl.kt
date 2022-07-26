package server

import ch.epfl.scala.bsp4j.*

class BuildClientImpl: BuildClient {

    override fun onBuildShowMessage(params: ShowMessageParams?) {
        println("Not yet implemented")
    }

    override fun onBuildLogMessage(params: LogMessageParams?) {
        println("Not yet implemented")
    }

    override fun onBuildTaskStart(params: TaskStartParams?) {
        println("Not yet implemented")
    }

    override fun onBuildTaskProgress(params: TaskProgressParams?) {
        println("Not yet implemented")
    }

    override fun onBuildTaskFinish(params: TaskFinishParams?) {
        println("Not yet implemented")
    }

    override fun onBuildPublishDiagnostics(params: PublishDiagnosticsParams?) {
        println("Not yet implemented")
    }

    override fun onBuildTargetDidChange(params: DidChangeBuildTarget?) {
        println("Not yet implemented")
    }
}