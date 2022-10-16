package cdk

import software.amazon.awscdk.App
import software.amazon.awscdk.Stack
import software.amazon.awscdk.services.lambda.Code
import software.amazon.awscdk.services.lambda.Function
import software.amazon.awscdk.services.lambda.LayerVersion
import software.amazon.awscdk.services.lambda.Runtime

fun main() {
  App().addStack {
    addLayer {
      code(Code.fromAsset("../layer/build")).compatibleRuntimes(listOf(Runtime.JAVA_8))
    }
    addLambda {
      runtime(Runtime.JAVA_8)
        .code(Code.fromAsset("../lambdas/build/libs/lambdas.jar"))
        .handler("lambdas.ExampleLambda")
    }
  }
}

private fun App.addStack(stackBuilder: Stack.() -> Unit) = apply {
  Stack.Builder.create(this).build().run(stackBuilder)
}


private val layersCache = mutableMapOf<Stack, MutableList<LayerVersion>>()
private val Stack.layers get() = layersCache.getOrPut(this, ::mutableListOf)

private fun Stack.addLambda(lambda: Function.Builder.() -> Function.Builder = { this }) {
  Function.Builder.create(this, "lambda")
    .lambda()
    .layers(layers)
    .build()
}
private fun Stack.addLayer(layerBuilder: LayerVersion.Builder.() -> LayerVersion.Builder = { this }) =
  LayerVersion.Builder
    .create(this, "layer ${layers.size}")
    .apply { layerBuilder() }.build()
    .apply(layers::add)
