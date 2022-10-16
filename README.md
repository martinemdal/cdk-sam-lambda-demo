# CDK SAM Local lambda

Running a Lambda locally with SAM and CDK.

# Structure
infra - contains cloud infrastructure to work with the lambda
lambdas - contains the lambda function
layer - contains dependencies the lambda can use

# Prerequisites
Install [aws-cli](https://docs.aws.amazon.com/cli/latest/userguide/getting-started-install.html), [cdk](https://docs.aws.amazon.com/cdk/v2/guide/cli.html), and [sam](https://docs.aws.amazon.com/serverless-application-model/latest/developerguide/serverless-sam-cli-install.html).

## Commands

### Run Lambda locally

#### 1. build the solution
`gradle clean build` 
#### 2. go to the infra package
`cd infra`
#### 3. dunno, build the project thingy i guess?
`cdk synth --no-staging`
#### 4. runs the lambda locally
`sam local invoke KotlinFun --no-event -t cdk.out/Stack.template.json`

### Deploy the lambda to AWS
#### 1. build the solution
`gradle clean build`
#### 2. go to the infra package
`cd infra`
#### 3. synthesize the cloudformation templates
`cdk synth`
#### 3. bootstrap AWS resources needed by CDK
`cdk bootstrap`
#### 4. deploy the stack
`cdk deploy`
