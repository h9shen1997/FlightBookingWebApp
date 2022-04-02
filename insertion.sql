INSERT INTO users (user_id, first_name, last_name, user_name, password, email, dob)
VALUES
	(NULL, "Jimmy", "Ofallon", "jof1", "12345", "jof1@gmail.com", "1992-01-09"),
    (NULL, "Emily", "Warren", "ew001", "12345", "ew001@gmail.com", "1995-12-10"),
    (NULL, "Steven", "Buffet", "sbuffet12", "12345", "sbuffet12@gmail.com", "1989-02-07"),
    (NULL, "Beth", "McArthur", "bma23", "12345", "bma23@gmail.com", "1975-11-06"),
    (NULL, "Ellis", "Madison", "emadison", "12345", "emadison@gmail.com", "1976-06-11"),
    (NULL, "Bucky", "Winter", "bwinter", "12345", "bwinter@gmail.com", "1967-11-29"),
    (NULL, "Jonny", "Bilt", "jbit", "12345", "jblt@gmail.com", "1973-09-09"),
    (NULL, "Chuck", "Brain", "cbrain", "12345", "cbrain@gmail.com", "1956-07-28");
    
SELECT * from users;

INSERT INTO employees (employee_id, passcode)
VALUES
	(1, "test_passworld1"),
    (2, "test_passworld2"),
    (3, "test_passworld3"),
    (4, "test_passworld4"),
    (5, "test_passworld5"),
    (6, "test_passworld6"),
    (7, "test_passworld7");
    
SELECT * from employees;
    
INSERT INTO statuses (status)
VALUES
	("GENERAL"),
    ("BRONZE"),
    ("SILVER"),
    ("GOLD"),
    ("PLATINUM");
    
INSERT INTO flight_classes (class)
VALUES
	("BASIC"),
    ("MAIN"),
    ("BUSINESS"),
    ("FIRST");
    
INSERT INTO operations (operation)
VALUES
	("ADD"),
    ("DELETE"),
    ("UPDATE");
    
SELECT * from flight_classes;
SELECT * from operations;
SELECT * from statuses;

INSERT INTO customers (customer_id, miles_accrued)
VALUES
	(1,  109),
    (2,  1302),
    (3,  109),
    (4,  80999),
    (5,  4000),
    (6,  2500),
    (7,  2385);
    
select * from customers;

select * from reservations;
INSERT INTO reservations (reservation_id, reservation_code, flight_class, trip)
VALUES
	(1, "RSV01", "BASIC", 1),
    (2, "RSV02", "MAIN", 2),
    (3, "RSV03", "BUSINESS", 3),
    (4, "RSV04", "FIRST", 4),
    (5, "RSV05", "BUSINESS", 5),
    (6, "RSV06", "BUSINESS", 6);
    
INSERT INTO customer_operation_logs (log_id, operation, reservation, performed_at, customer)
VALUES
	(1, "ADD", "1", "2020-03-04", 1),
    (2, "DELETE", "2", "2019-08-01", 2),
    (3, "UPDATE", "3", "2021-11-01", 3),
    (4, "DELETE", "4", "2017-05-23", 4),
    (5, "ADD", "5", "2015-04-11", 5);
    
INSERT INTO trips(trip_id, reservation, duration, total_mileage, total_cost)
VALUES
	(1, 1, 124, 250, 100.4),
    (2, 2, 230, 218, 220.1),
    (3, 3, 40, 50, 98.6),
    (4, 4, 20, 69, 102.2),
    (5, 5, 43, 54, 89.9),
    (6, 6, 132, 34, 89.98);
    
INSERT INTO recommendations(recommendation_id, trip, departure_airport, likes)
VALUES
	(1, 1, "SEA", 20),
    (2, 2, "BOS", 120),
    (3, 3, "LAX", 230),
    (4, 4, "ATL", 1239),
    (5, 5, "DEN", 637),
    (6, 6, "MIA", 237);
    
INSERT INTO flights (flight_id, airline, departure_airport, arrival_airport, flight_number, cost,
					mileage, duration, departure_time, arrival_time, trip, capacity)
VALUES
	(1, "DELTA AIRLINE", "SEA", "BOS", "DL 234", "200.7", "1200", "480", "2020-01-09 01:01:01", "2020-01-09 13:01:01", 1, 130),
	(2, "JET BLUE", "ATL", "SEA", "JB 22", "240.4", "1234", "510", "2020-01-09 01:01:01", "2020-01-09 13:01:01", 2, 100),				
	(3, "UNITED AIRLINE", "ORD", "DEN", "UA 112", "70.3", "1000", "103", "2020-01-09 01:01:01", "2020-01-09 13:01:01", 3, 186),
    (4, "DELTA AIRLINE", "MIA", "HOU", "DL 12", "260.9", "1300", "1002", "2020-01-09 01:01:01", "2020-01-09 13:01:01", 4, 90);
    
    
INSERT INTO employee_operation_logs(log_id, operation, flight, performed_at, employee)
VALUES
	(1, "ADD", 1, "2009-01-03 01:01:03", 1),
    (2, "DELETE", 2, "2011-11-03 01:01:03", 3),
    (3, "ADD", 3, "2012-11-18 01:01:03",4),
    (4, "UPDATE", 4, "2013-01-03 01:01:03", 2),
    (5, "DELETE", 1, "2014-12-15 01:01:03", 1);
    
SELECT  * from flights;
    
    
    

    