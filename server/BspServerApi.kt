package server

import ch.epfl.scala.bsp4j.*
import java.lang.Thread.sleep
import java.net.URI
import java.util.concurrent.CompletableFuture

class BspServerApi: BuildServer, JvmBuildServer, JavaBuildServer {

    override fun buildInitialize(p0: InitializeBuildParams?): CompletableFuture<InitializeBuildResult> {
        var buildServerCapabilities = BuildServerCapabilities().apply {
            compileProvider = CompileProvider(listOf("kotlin", "java", "scala"))
            runProvider = RunProvider(listOf("kotlin", "java", "scala"))
            inverseSourcesProvider = true
            dependencySourcesProvider = true
            resourcesProvider = true
            jvmRunEnvironmentProvider = true
        }
        var ibr = InitializeBuildResult("bazeltest", "2.1.0", "2.0.0", buildServerCapabilities)

        return CompletableFuture.supplyAsync {
            sleep(10000)
            ibr
        }
    }

    override fun onBuildInitialized() {
        println("onBuildInitialized")
    }

    override fun buildShutdown(): CompletableFuture<Any> {
        return CompletableFuture.supplyAsync {
            sleep(10000)
            RunResult(StatusCode.OK)
        }
    }

    override fun onBuildExit() {
        println("onBuildExit")
    }

    override fun workspaceBuildTargets(): CompletableFuture<WorkspaceBuildTargetsResult> {
        var bt = BuildTarget(BuildTargetIdentifier("//server:server"), listOf("library"), listOf("kotlin", "java"),
        listOf(
            BuildTargetIdentifier("@com_google_protobuf//:protobuf_java"),
            BuildTargetIdentifier("@googleapis//:google_devtools_build_v1_build_events_java_proto"),
            BuildTargetIdentifier("@googleapis//:google_devtools_build_v1_publish_build_event_java_grpc"),
            BuildTargetIdentifier("@io_bazel//src/main/java/com/google/devtools/build/lib/buildeventstream/proto:build_event_stream_java_proto"),
            BuildTargetIdentifier("@io_bazel//src/main/protobuf:build_java_proto"),
            BuildTargetIdentifier("@io_bazel//third_party/grpc:grpc-jar"),
            BuildTargetIdentifier("@io_bazel_rules_scala//src/protobuf/io/bazel/rules_scala:diagnostics_java_proto"),
            BuildTargetIdentifier("@maven//:ch_epfl_scala_bsp4j"),
            BuildTargetIdentifier("@maven//:com_google_code_gson_gson"),
            BuildTargetIdentifier("@maven//:org_apache_logging_log4j_log4j_api"),
            BuildTargetIdentifier("@maven//:org_apache_logging_log4j_log4j_core"),
            BuildTargetIdentifier("@maven//:org_eclipse_lsp4j_org_eclipse_lsp4j_jsonrpc")), BuildTargetCapabilities())
        bt.displayName = "//server:server"
        bt.baseDirectory = "file:///Users/azdrojowa/IdeaProjects/bazel-test/server"
        bt.dataKind = "jvm"
        return CompletableFuture.supplyAsync {
            sleep(10000)
            WorkspaceBuildTargetsResult(listOf(bt)
            )
        }
    }

    override fun workspaceReload(): CompletableFuture<Any> {
        return CompletableFuture.supplyAsync {
            sleep(10000)
            RunResult(StatusCode.OK)
        }
    }

    override fun buildTargetSources(p0: SourcesParams?): CompletableFuture<SourcesResult> {
        var sourceItem = SourcesItem(BuildTargetIdentifier("//server:server"), emptyList())
        sourceItem.sources = listOf(
            SourceItem("file:///Users/azdrojowa/IdeaProjects/bazel-test/server/BepServer.kt", SourceItemKind.FILE, false),
            SourceItem("file:///Users/azdrojowa/IdeaProjects/bazel-test/server/BspIntegrationData.kt", SourceItemKind.FILE, false),
            SourceItem("file:///Users/azdrojowa/IdeaProjects/bazel-test/server/BspServerApi.kt", SourceItemKind.FILE, false),
            SourceItem("file:///Users/azdrojowa/IdeaProjects/bazel-test/server/BspServerApi.kt", SourceItemKind.FILE, false),
            SourceItem("file:///Users/azdrojowa/IdeaProjects/bazel-test/server/ServerInitializer.kt", SourceItemKind.FILE, false),
            SourceItem("file:///Users/azdrojowa/IdeaProjects/bazel-test/server/BuildClientImpl.kt", SourceItemKind.FILE, false),
        )
        sourceItem.roots = listOf("file:///Users/azdrojowa/IdeaProjects/bazel-test/server")
        return CompletableFuture.supplyAsync {
            sleep(10000)
            SourcesResult(mutableListOf(sourceItem))
        }
    }

    override fun buildTargetInverseSources(p0: InverseSourcesParams?): CompletableFuture<InverseSourcesResult> {
        return CompletableFuture.supplyAsync {
            sleep(10000)
            InverseSourcesResult(listOf(BuildTargetIdentifier(URI("file:///ident33").toString())))
        }
    }

    override fun buildTargetDependencySources(p0: DependencySourcesParams?): CompletableFuture<DependencySourcesResult> {
        return CompletableFuture.supplyAsync {
            sleep(10000)
            DependencySourcesResult(listOf(DependencySourcesItem(BuildTargetIdentifier(URI("//server:server").toString()),listOf(
                "file:///private/var/tmp/_bazel_azdrojowa/ac231ac3d370b061de72bdfb1462c3de/execroot/bazel_bsp/external/maven/v1/https/repo.maven.apache.org/maven2/org/eclipse/lsp4j/org.eclipse.lsp4j.jsonrpc/0.12.0/org.eclipse.lsp4j.jsonrpc-0.12.0.jar",
                "file:///private/var/tmp/_bazel_azdrojowa/8eecc9648748a9c3bdc2a20cb378cb94/execroot/bazel_bsp/bazel-out/darwin-fastbuild/bin/external/googleapis/google_devtools_build_v1_publish_build_event_proto-speed-src.jar",

                "file:///private/var/tmp/_bazel_azdrojowa/8eecc9648748a9c3bdc2a20cb378cb94/execroot/bazel_bsp/bazel-out/darwin-fastbuild/bin/external/googleapis/google_devtools_build_v1_build_events_proto-speed-src.jar",

                "file:///private/var/tmp/_bazel_azdrojowa/ac231ac3d370b061de72bdfb1462c3de/execroot/bazel_bsp/external/maven/v1/https/repo.maven.apache.org/maven2/ch/epfl/scala/bsp4j/2.0.0/bsp4j-2.0.0.jar",
                "file:///private/var/tmp/_bazel_azdrojowa/ac231ac3d370b061de72bdfb1462c3de/execroot/bazel_bsp/bazel-out/darwin-fastbuild/bin/external/io_bazel/third_party/grpc/_ijar/grpc-jar_checked_in/third_party/grpc/grpc-api-1.41.0-ijar.jar",
                "file:///private/var/tmp/_bazel_azdrojowa/ac231ac3d370b061de72bdfb1462c3de/execroot/bazel_bsp/bazel-out/darwin-fastbuild/bin/external/io_bazel/third_party/grpc/_ijar/grpc-jar_checked_in/third_party/grpc/grpc-auth-1.41.0-ijar.jar",
                "file:///private/var/tmp/_bazel_azdrojowa/ac231ac3d370b061de72bdfb1462c3de/execroot/bazel_bsp/bazel-out/darwin-fastbuild/bin/external/io_bazel/third_party/grpc/_ijar/grpc-jar_checked_in/third_party/grpc/grpc-context-1.41.0-ijar.jar",
                "file:///private/var/tmp/_bazel_azdrojowa/ac231ac3d370b061de72bdfb1462c3de/execroot/bazel_bsp/bazel-out/darwin-fastbuild/bin/external/io_bazel/third_party/grpc/_ijar/grpc-jar_checked_in/third_party/grpc/grpc-core-1.41.0-ijar.jar",
                "file:///private/var/tmp/_bazel_azdrojowa/ac231ac3d370b061de72bdfb1462c3de/execroot/bazel_bsp/bazel-out/darwin-fastbuild/bin/external/io_bazel/third_party/grpc/_ijar/grpc-jar_checked_in/third_party/grpc/grpc-netty-1.41.0-ijar.jar",
                "file:///private/var/tmp/_bazel_azdrojowa/ac231ac3d370b061de72bdfb1462c3de/execroot/bazel_bsp/bazel-out/darwin-fastbuild/bin/external/io_bazel/third_party/grpc/_ijar/grpc-jar_checked_in/third_party/grpc/grpc-protobuf-1.41.0-ijar.jar",
                "file:///private/var/tmp/_bazel_azdrojowa/ac231ac3d370b061de72bdfb1462c3de/execroot/bazel_bsp/bazel-out/darwin-fastbuild/bin/external/io_bazel/third_party/grpc/_ijar/grpc-jar_checked_in/third_party/grpc/grpc-protobuf-lite-1.41.0-ijar.jar",
                "file:///private/var/tmp/_bazel_azdrojowa/ac231ac3d370b061de72bdfb1462c3de/execroot/bazel_bsp/bazel-out/darwin-fastbuild/bin/external/io_bazel/third_party/grpc/_ijar/grpc-jar_checked_in/third_party/grpc/grpc-stub-1.41.0-ijar.jar"
                ))))
        }
    }

    override fun buildTargetResources(p0: ResourcesParams?): CompletableFuture<ResourcesResult> {
        return CompletableFuture.supplyAsync {
            sleep(10000)
            ResourcesResult(listOf(ResourcesItem(BuildTargetIdentifier(URI("//server").toString()), emptyList())))
        }
    }

    override fun buildTargetCompile(p0: CompileParams?): CompletableFuture<CompileResult> {
        return CompletableFuture.supplyAsync {
            sleep(10000)
            CompileResult(StatusCode.OK)
        }
    }

    override fun buildTargetTest(p0: TestParams?): CompletableFuture<TestResult> {
        return CompletableFuture.supplyAsync {
            sleep(10000)
            TestResult(StatusCode.OK)
        }
    }

    override fun buildTargetRun(p0: RunParams?): CompletableFuture<RunResult> {
        return CompletableFuture.supplyAsync {
            sleep(10000)
            RunResult(StatusCode.OK)
        }
    }

    override fun buildTargetCleanCache(p0: CleanCacheParams?): CompletableFuture<CleanCacheResult> {
        return CompletableFuture.supplyAsync {
            sleep(10000)
            CleanCacheResult("ident", false)
        }
    }

    override fun buildTargetDependencyModules(p0: DependencyModulesParams?): CompletableFuture<DependencyModulesResult> {
        return CompletableFuture.supplyAsync {
            sleep(10000)
            DependencyModulesResult(listOf(DependencyModulesItem(BuildTargetIdentifier(URI("file:///iden32t").toString()), listOf(DependencyModule("s1", "s2")))))
        }
    }

    override fun jvmRunEnvironment(p0: JvmRunEnvironmentParams?): CompletableFuture<JvmRunEnvironmentResult> {
        return CompletableFuture.supplyAsync {
            sleep(10000)
            JvmRunEnvironmentResult(listOf(JvmEnvironmentItem(
                BuildTargetIdentifier(URI("file:///ide32nt").toString()), listOf("classpath"), listOf("jvmOptions"), "workingDIR", mapOf(Pair("key", "value")))))
        }
    }

    override fun jvmTestEnvironment(p0: JvmTestEnvironmentParams?): CompletableFuture<JvmTestEnvironmentResult> {
        return CompletableFuture.supplyAsync {
            sleep(10000)
            JvmTestEnvironmentResult(listOf(JvmEnvironmentItem(
                BuildTargetIdentifier(URI("file:///ident33334").toString()), listOf("classpath"), listOf("jvmOptions"), "workingDIR", mapOf(Pair("key", "value")))))
        }
    }

    override fun buildTargetJavacOptions(p0: JavacOptionsParams?): CompletableFuture<JavacOptionsResult> {
        return CompletableFuture.supplyAsync {
            sleep(10000)
            JavacOptionsResult(listOf(
                JavacOptionsItem(
                BuildTargetIdentifier("//server:server"),
                emptyList(),
                    listOf(
                        "file:///private/var/tmp/_bazel_azdrojowa/ac231ac3d370b061de72bdfb1462c3de/execroot/bazel_bsp/external/maven/v1/https/repo.maven.apache.org/maven2/org/eclipse/lsp4j/org.eclipse.lsp4j.jsonrpc/0.12.0/org.eclipse.lsp4j.jsonrpc-0.12.0.jar",

                        "file:///private/var/tmp/_bazel_azdrojowa/8eecc9648748a9c3bdc2a20cb378cb94/execroot/bazel_bsp/bazel-out/darwin-fastbuild/bin/external/googleapis/libgoogle_devtools_build_v1_build_events_proto-speed.jar",
                        "file:///private/var/tmp/_bazel_azdrojowa/8eecc9648748a9c3bdc2a20cb378cb94/execroot/bazel_bsp/bazel-out/darwin-fastbuild/bin/external/googleapis/libgoogle_devtools_build_v1_publish_build_event_java_grpc.jar",
                        "file:///private/var/tmp/_bazel_azdrojowa/8eecc9648748a9c3bdc2a20cb378cb94/execroot/bazel_bsp/bazel-out/darwin-fastbuild/bin/external/googleapis/libgoogle_devtools_build_v1_publish_build_event_proto-speed.jar",

                        "file:///private/var/tmp/_bazel_azdrojowa/8eecc9648748a9c3bdc2a20cb378cb94/execroot/bazel_bsp/bazel-out/darwin-fastbuild/bin/external/googleapis/libgoogle_devtools_build_v1_build_events_proto-speed.jar",
                        "file:///private/var/tmp/_bazel_azdrojowa/8eecc9648748a9c3bdc2a20cb378cb94/execroot/bazel_bsp/bazel-out/darwin-fastbuild/bin/external/googleapis/libgoogle_devtools_build_v1_publish_build_event_java_grpc.jar",
                        "file:///private/var/tmp/_bazel_azdrojowa/8eecc9648748a9c3bdc2a20cb378cb94/execroot/bazel_bsp/bazel-out/darwin-fastbuild/bin/external/googleapis/libgoogle_devtools_build_v1_publish_build_event_proto-speed.jar",
                        "file:///private/var/tmp/_bazel_azdrojowa/ac231ac3d370b061de72bdfb1462c3de/execroot/bazel_bsp/bazel-out/darwin-fastbuild/bin/external/googleapis/google_devtools_build_v1_build_events_proto-speed-src.jar",
                        "file:///private/var/tmp/_bazel_azdrojowa/ac231ac3d370b061de72bdfb1462c3de/execroot/bazel_bsp/bazel-out/darwin-fastbuild/bin/external/googleapis/libgoogle_devtools_build_v1_publish_build_event_java_grpc-src.jar",
                        "file:///private/var/tmp/_bazel_azdrojowa/ac231ac3d370b061de72bdfb1462c3de/execroot/bazel_bsp/external/maven/v1/https/repo.maven.apache.org/maven2/ch/epfl/scala/bsp4j/2.0.0/bsp4j-2.0.0.jar",
                        "file:///private/var/tmp/_bazel_azdrojowa/ac231ac3d370b061de72bdfb1462c3de/execroot/bazel_bsp/bazel-out/darwin-fastbuild/bin/external/io_bazel/third_party/grpc/_ijar/grpc-jar_checked_in/third_party/grpc/grpc-api-1.41.0-ijar.jar",
                        "file:///private/var/tmp/_bazel_azdrojowa/ac231ac3d370b061de72bdfb1462c3de/execroot/bazel_bsp/bazel-out/darwin-fastbuild/bin/external/io_bazel/third_party/grpc/_ijar/grpc-jar_checked_in/third_party/grpc/grpc-auth-1.41.0-ijar.jar",
                        "file:///private/var/tmp/_bazel_azdrojowa/ac231ac3d370b061de72bdfb1462c3de/execroot/bazel_bsp/bazel-out/darwin-fastbuild/bin/external/io_bazel/third_party/grpc/_ijar/grpc-jar_checked_in/third_party/grpc/grpc-context-1.41.0-ijar.jar",
                        "file:///private/var/tmp/_bazel_azdrojowa/ac231ac3d370b061de72bdfb1462c3de/execroot/bazel_bsp/bazel-out/darwin-fastbuild/bin/external/io_bazel/third_party/grpc/_ijar/grpc-jar_checked_in/third_party/grpc/grpc-core-1.41.0-ijar.jar",
                        "file:///private/var/tmp/_bazel_azdrojowa/ac231ac3d370b061de72bdfb1462c3de/execroot/bazel_bsp/bazel-out/darwin-fastbuild/bin/external/io_bazel/third_party/grpc/_ijar/grpc-jar_checked_in/third_party/grpc/grpc-netty-1.41.0-ijar.jar",
                        "file:///private/var/tmp/_bazel_azdrojowa/ac231ac3d370b061de72bdfb1462c3de/execroot/bazel_bsp/bazel-out/darwin-fastbuild/bin/external/io_bazel/third_party/grpc/_ijar/grpc-jar_checked_in/third_party/grpc/grpc-protobuf-1.41.0-ijar.jar",
                        "file:///private/var/tmp/_bazel_azdrojowa/ac231ac3d370b061de72bdfb1462c3de/execroot/bazel_bsp/bazel-out/darwin-fastbuild/bin/external/io_bazel/third_party/grpc/_ijar/grpc-jar_checked_in/third_party/grpc/grpc-protobuf-lite-1.41.0-ijar.jar",
                        "file:///private/var/tmp/_bazel_azdrojowa/ac231ac3d370b061de72bdfb1462c3de/execroot/bazel_bsp/bazel-out/darwin-fastbuild/bin/external/io_bazel/third_party/grpc/_ijar/grpc-jar_checked_in/third_party/grpc/grpc-stub-1.41.0-ijar.jar",
                        "file:///private/var/tmp/_bazel_azdrojowa/ac231ac3d370b061de72bdfb1462c3de/execroot/bazel_bsp/external/com_github_jetbrains_kotlin/lib/annotations-13.0.jar",
                        "file:///private/var/tmp/_bazel_azdrojowa/ac231ac3d370b061de72bdfb1462c3de/execroot/bazel_bsp/external/com_github_jetbrains_kotlin/lib/kotlin-stdlib.jar",
                        "file:///private/var/tmp/_bazel_azdrojowa/ac231ac3d370b061de72bdfb1462c3de/execroot/bazel_bsp/external/com_github_jetbrains_kotlin/lib/kotlin-stdlib-jdk7.jar",
                        "file:///private/var/tmp/_bazel_azdrojowa/ac231ac3d370b061de72bdfb1462c3de/execroot/bazel_bsp/external/com_github_jetbrains_kotlin/lib/kotlin-stdlib-jdk8.jar"
                    ),
                "file:///private/var/tmp/_bazel_azdrojowa/ac231ac3d370b061de72bdfb1462c3de/execroot/bazel_bsp/bazel-out/darwin-fastbuild/bin/server/bsp-run.jar"
            )
            ))
        }
    }

}