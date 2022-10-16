# CDK SAM Local lambda

Running a Lambda locally with SAM and CDK.

# Structure
 * infra - contains cloud infrastructure to work with the lambda
 * lambdas - contains the lambda function
 * layer - contains dependencies the lambda can use

# Prerequisites
Install [docker](https://docs.docker.com/get-docker/), [aws-cli](https://docs.aws.amazon.com/cli/latest/userguide/getting-started-install.html), [cdk](https://docs.aws.amazon.com/cdk/v2/guide/cli.html), and [sam](https://docs.aws.amazon.com/serverless-application-model/latest/developerguide/serverless-sam-cli-install.html).

## Commands

### Run Lambda locally

#### 1. compile the code
```shell
./gradlew clean build
```
#### 2. synthesize the stack
```shell
cd infra && cdk synth --no-staging
```
#### 3. runs the lambda locally
```shell
cd infra && sam local invoke KotlinFun --no-event -t cdk.out/Stack.template.json
```

### Deploy the lambda to AWS
#### 1. build the solution
`gradle clean build`
#### 2. synthesize the stack
```shell
cd infra && cdk synth
```
#### 3. bootstrap AWS resources needed by CDK
```shell
cdk bootstrap
```
#### 4. deploy the stack
```shell
cdk deploy
```
