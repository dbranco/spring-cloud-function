# Introduction
This sample project tries to deliver a lambda using spring boot java as simple as possible

# Consideration
There is a webflux dependency, which helps the project to run locally and listening to calls to the "greet" function. You
only need to start the JavaAwsLambdaApplication class and call the function as:

```shell
$ curl localhost:8080/greet -H "Content-Type: text/plain" -d "simple string"
```

# AWS Lambda
For further integration with AWS please refer to the following [link](https://cloud.spring.io/spring-cloud-function/reference/html/aws.html),
in this page you will find extra information, like:
- Dependencies
  - org.springframework.cloud:spring-cloud-function-adapter-aws
  - com.amazonaws:aws-lambda-java-events
  - com.amazonaws:aws-lambda-java-core
- How the fatJar should be build

## Deploy the function
I am assuming that you have created/posses an AWS account, if not create one. 

You will need to have AWS Cli installed and aws credentials configured. If not:
- Then follow these [instructions](https://docs.aws.amazon.com/IAM/latest/UserGuide/getting-started_create-admin-group.html)
- Generate the access key to deploy the code. 
- Execute and provide the needed information
```shell
$ aws configure --profile <YOUR DESIRED PROFILE NAME>
```
Once, you have the previous access you can then execute:
```shell
$ ./gradlew shadowJar
$ aws lambda create-function --profile <YOUR DESIRED PROFILE NAME> \
    --function-name aws-lambda-java \
    --zip-file fileb://build/libs/awsLamdaSample.jar \
    --role <EXECUTION ROLE PREVIOUSLY CREATED> \
    --handler org.springframework.cloud.function.adapter.aws.FunctionInvoker::handleRequest \
    --runtime java11 --timeout 60 --memory-size 300
```
In case you need to deploy new code, you can always execute the following after creating/executing the `shadowJar`
```shell
aws lambda update-function-code --profile <YOUR DESIRED PROFILE NAME> \
    --function-name aws-lambda-java \
    --zip-file fileb://build/libs/awsLamdaSample.jar
```

# Stackoverflow
This sample code gave me some problems that force me to document it, please refer to [here](https://stackoverflow.com/questions/69110895/kotlin-spring-cloud-function-aws-lambda?noredirect=1#comment122161272_69110895)
for more information.