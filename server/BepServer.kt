package server

import ch.epfl.scala.bsp4j.BuildClient
import com.google.devtools.build.v1.PublishBuildEventGrpc.PublishBuildEventImplBase

class BepServer(bspClient: BuildClient): PublishBuildEventImplBase() {

}