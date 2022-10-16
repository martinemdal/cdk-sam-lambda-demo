package stack

import software.amazon.awscdk.App
import software.amazon.awscdk.Stack
import software.amazon.awscdk.services.lambda.Code
import software.amazon.awscdk.services.lambda.Function
import software.amazon.awscdk.services.lambda.LayerVersion
import software.amazon.awscdk.services.lambda.Runtime
import software.constructs.Construct

fun main() {
  App().apply {
    val stack = Stack.Builder.create(this, "Stack").build()
    val layers = listOf(createLayer(stack))
    createLambda(stack, layers)
  }.synth()
}

private fun createLambda(construct: Construct, layers: List<LayerVersion>) =
  Function.Builder.create(construct, "KotlinFun")
    .runtime(Runtime.JAVA_8)
    .code(Code.fromAsset("../lambda/build/libs/lambda.jar"))
    .handler("lambda.KotlinFun")
    .layers(layers)
    .build()

private fun createLayer(construct: Construct) = LayerVersion.Builder.create(construct, "layer")
  .code(Code.fromAsset("../lambda/build"))
  .compatibleRuntimes(listOf(Runtime.JAVA_8))
  .build()
