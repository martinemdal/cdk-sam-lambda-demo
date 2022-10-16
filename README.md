# Running a CDK/SAM Lambda function locally on Docker

# Structure
 * stack - contains cdk-defined cloud infrastructure to work with the lambda
 * lambda - contains the lambda function itself

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
cd stack && cdk synth --no-staging
```
#### 3. runs the lambda locally
```shell
cd stack && sam local invoke KotlinFun --no-event -t cdk.out/Stack.template.json
```

### Deploy the lambda to AWS
#### 1. build the solution
`gradle clean build`
#### 2. synthesize the stack
```shell
cd stack && cdk synth
```
#### 3. bootstrap AWS resources needed by CDK
```shell
cdk bootstrap
```
#### 4. deploy the stack
```shell
cdk deploy
```
