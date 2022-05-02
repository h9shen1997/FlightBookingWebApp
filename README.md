## Project domain

A flight booking company.

## Design

- Front-end: React with Hooks, React router v6.
- Back-end: Spring boot, Java persistance API and mySQL.

## How to run our program

- Back-end: Open the folder FlightBookingCompanyBackend in IntelliJ and use the Spring Boot configuration with JDK 11 and `com.example.FlightBookingCompanyBackend.FlightBookingCompanyBackend` Main class. Make sure our data file is imported through the MySQL workbench and the the username and password are correct in the `application.properties` file the resources section in the project.
- Front-end: Change directory to folder FlightBookingCompanyFrontend and use `npm install` to install all dependencies. After all dependencies are installed, use `npm start` to run the project. Make sure that the backend is running before running the front-end, otherwise you will encounter unable to fetch error.
- Testing with postman: Import the postman testing collection through this JSON link https://www.getpostman.com/collections/91acba5ad5466c22399d. On the home page, first search for some flights, for example, SEA to HNL. When you first search for this, there will be no connecting flights. Then, use the postman to create a flight from LAX to HNL. Then you can view all the connecting flights from SEA to HNL after searching again.

## Functionalities implemented

- CRUD operation of customer:
  Go to http://localhost:3000/customers to view all the customers and perform CRUD operations. This page is not accessible through any button on the page to prevent customer from manipulating it. - Create: a new customer can be added using the "Add Customer" button at the top of the page. - Read: when you nagivate to customers from the home page, all the customer in the database will be loaded. - Update: only the password of the customer can be updated. The customer needs to type in the correct username, or no update will be reflected. - Delete: a customer can be removed from the database using the red "delete" button.

- Create and search of flights.

## UML Diagram

![alt text](https://github.com/h9shen1997/FlightBookingWebApp/blob/main/UML.png)

## Requirements

- At least 2 end users for the application

  - Customer and airline Employees.

- At least 3 domain object data models

  - Reservation: a reservation booked by customers.
  - Trip: a trip that contains total duration and mileage information.
  - Flight: a flight that contains information of airport, duration, mileage, etc.
  - Recommendation: a recommendation for the user suggesting any interesting travel options.
  - EmployeeOperationLog: actions taken by the employee, such as adding a new flight.
  - CustomerOperationLog: actions taken by the customer, such as changing the reservation's flight.

- At least 2 relationships between user data model and a domain object

  - A customer can perform many operation entries to update the reservation (one to many).
  - An employee can perform many operation entries to update the flight (one to many).
  - A customer can make lots of reservations (one to many)

- At least 2 relationships between domain objects to domain objects

  - A reservation can contain one trip (one to one).
  - A trip can contain many connecting and non-connecting flights (one to many).
  - A trip can be recommended optionally (one to at most one)

- A user to user relationship

  - A customer can be the travel companion of another customer.

- At least 1 inheritance relationship between two classes

  - Both customer and employee inherit from user. Customer has its specific fields, including flyer status, miles accrued, reservation, travel companion, whereas the employee has a passcode used to verify login in the system.

- Portable enumerations
  - 4 portable enum classes have been implemented, the flight class, the membership status, the operations employee and customer can perform, and the operating airport of the airline company.
