# Friday Code Challenge

The Application is a basic Java 8 program, executing the program with the address will return the street and the house number as json. 

## Getting Started

Download and Extract the Zip. Go to the unzipped folder and execute the following command to run the application.

```
java -jar target/FridayCodeChallenge-jar-with-dependencies.jar "${input string}"
```

You can also change and compile the code with the help of the assembly plugin by running the command in the root folder

```
mvn clean compile assembly:single
```

This will create a fat-jar "FridayCodeChallenge-jar-with-dependencies.jar", which you can test. (maven and java should be installed on your operating system).

## Test Cases

I have already coded the test cases as per requirement you can execute them with the following command.
```
mvn clean compile test
```

## Executing Requests/Tests

The application gets the input address as the argument. For running a test, just execute the application with the input address.

```
java -jar target/FridayCodeChallenge-jar-with-dependencies.jar "4, rue de la revolution"
```
Response: (The response json should look like this)
```
{"street":"rue de la revolution","houseNumber":"4"}
```

(Do let me know if you face any problems running or testing the application, email:zarakfarid@gmail.com) 

## Design

I have taken into account four cases and resolved those:			
1. Address starting from digits
2. Address starting from digits with text in the middle
3. Address starting from text
4. Address starting from text with digits in the middle

The actual application might have a scoring system (not implemented) using an external api (google maps etc) to verify the results and score the output, the result with the highest score is ouputed as the final outcome.
