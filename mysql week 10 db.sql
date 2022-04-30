CREATE DATABASE Week_10_Assignment;
USE Week_10_Assignment;

CREATE TABLE vehicles (
vehicle_id INT NOT NULL AUTO_INCREMENT,
year INT NOT NULL,
make VARCHAR(30) NOT NULL,
model VARCHAR(50) NOT NULL,

PRIMARY KEY (vehicle_id)
);