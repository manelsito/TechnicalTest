# README

This is the repository for the Spring technical test. Here you will find all the necessary information to get started with the project.

## Description

Spring application for OMC technical test.

## Environment Setup

Before getting started with the project, make sure you have the following requirements in your development environment:

- JDK (Java Development Kit) 8 or higher installed.
- Maven installed to manage dependencies.
- An Integrated Development Environment (IDE) such as IntelliJ IDEA or Eclipse to facilitate development.

## Project Setup

Follow the steps below to set up the project in your development environment:

1. Clone this repository to your local machine using the `git clone https://github.com/manelsito/TechnicalTest.git` command.

2. Import the project into your IDE.

3. The main configuration file is located at `src/main/resources/application.properties`. Make sure to adjust the configuration according to your needs.

4. Run the `mvn clean install` command in the project root directory to download dependencies and compile the code.

5. Import the SQL file `TODOs.sql` into your database. This file contains the necessary schema and data for the application to work correctly.

## Running the Application

Once the project is set up, you can run the application by following these steps:

1. Open the project in your IDE.

2. Find the main class of the project, `TodOsSpringApplication.java`.

3. Right-click on the class and select "Run" or "Run as," then choose "Spring Boot App" to start the application.

4. The application will run on a local server, and you can access it through your browser at [http://localhost:8080](http://localhost:8080) (or the port you configured in `application.properties`).

##Problems

1. I have had several problems with spring security because they have recently updated it and some functionalities have been deprecated, so looking for guides and tutorials has been a bit difficult for me
