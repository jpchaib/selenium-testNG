# Java Maven + TestNG + Selenium Automation Framework

## Introduction
 - This repository contains a Java Maven project that utilizes TestNG and Selenium to test features of a react front-end application. The framework is designed to be easily maintainable and scalable for future use.

## Prerequisites
- Java 8 or higher
- Maven 3 or higher
- Selenium 3 or higher
- TestNG 6 or higher
- Project Structure

The project is structured as follows:

- src/main/java/revenue/testNG - contains the Java source code and, also, contains the test cases written in Java and utilizing TestNG and Selenium
- pom.xml - Maven build configuration file

## How to run
- Clone the repository
- Navigate to the project directory
- Run the following command in the repo directory: `/mvnw clean install`
- Then you can run any java file as TestNG.

## Report
TestNG will generate a report in test-output folder after test execution. The report will give a detailed summary of the test results including passed, failed, and skipped tests.

## Note
The react front-end application under test is expected to be up and running on the URL specified in the Constants.java file before running the tests.
The tests assume a certain state of the react front-end application and may fail if the state is different.

## Contributions
Feel free to fork the repository and make contributions. All pull requests will be reviewed and merged if deemed appropriate.
