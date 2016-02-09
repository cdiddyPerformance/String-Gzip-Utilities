# String-Gzip-Utilities
Some simple Java String Wrappers for examples and a message converter that can be used to gzip and gunzip message contents.

##Pre-requisites
Java JDK 1.7


###Soasta Custom Scripting Module API
* cloudtest-plugin-api.jar 
* cloudtest-scripting-environment.jar 


```javascript
importPackage(org.soasta.amqp);
var amqpClient = new SimpleClient($context.createJavaEnvironment());
var message = "Hello World!";
var queueName = "test";
var host ="amqp://server.compute-1.amazonaws.com";
amqpClient.publish(message,queueName,host);
```

