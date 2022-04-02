# bananaFactoryDB

## Team member
- Qiaozhi Liu
- Haotian Shen
- Jiawei Liu 

## UML Diagram
![alt text](https://github.ccs.neu.edu/georgeliu614/bananaFactoryDB/blob/main/UML.png?raw=true)

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





