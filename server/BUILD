load("@io_bazel_rules_kotlin//kotlin:jvm.bzl", "kt_jvm_library")

kt_jvm_library(
    name = "server",
    srcs = glob(["*.kt"]),
    deps = [
        "@googleapis//:google_devtools_build_v1_build_events_java_proto",
        "@googleapis//:google_devtools_build_v1_publish_build_event_java_grpc",
        "@io_bazel//third_party/grpc:grpc-jar",
        "@maven//:ch_epfl_scala_bsp4j",
        "@maven//:org_eclipse_lsp4j_org_eclipse_lsp4j_jsonrpc",
    ],
)

java_binary(
    name = "bsp-run",
    main_class = "server.ServerInitializer",
    visibility = ["//server:__subpackages__"],
    runtime_deps = ["//server"],
)
