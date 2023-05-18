drop database TODOsDB;

CREATE DATABASE TODOsDB;

USE TODOsDB;

CREATE TABLE User (
  Id INT AUTO_INCREMENT PRIMARY KEY,
  Name VARCHAR(255) NOT NULL,
  Username VARCHAR(255) NOT NULL UNIQUE,
  Password VARCHAR(255) NOT NULL,
  Street VARCHAR(255) NOT NULL,
  City VARCHAR(255) NOT NULL,
  Zipcode VARCHAR(255) NOT NULL,
  Country VARCHAR(255) NOT NULL
);

CREATE TABLE Todo (
  Id INT AUTO_INCREMENT PRIMARY KEY,
  Title VARCHAR(255) NOT NULL,
  Completed BOOLEAN,
  user_id INT,
  FOREIGN KEY (user_id) REFERENCES User(Id)
);

INSERT INTO User (Name, Username, Password, Street, City, Zipcode, Country) VALUES 
('Manel Agudo', 'Manelsito', '1234', 'Terra Baixa', 'Hospitalet de Llobregat', '08901', 'Spain'),
('Alberto Santos', 'Alberto', '1234', 'Torres i Amat', 'Barcelona', '08001', 'Spain'),
('María López', 'MariaL', 'password123', 'Calle Principal', 'Madrid', '28001', 'Spain'),
('John Smith', 'johnsmith', 'pass456', '123 Oak Street', 'New York', '10001', 'United States'),
('Laura García', 'laurag', 'abc123', 'Avenida del Sol', 'Sevilla', '41001', 'Spain');

INSERT INTO Todo (Title, Completed, user_id) VALUES 
('Tarea 1 de Usuario 1', true, 1), 
('Tarea 2 de Usuario 1', false, 1),
('Tarea 1 de Usuario 2', true, 2),
('Tarea 2 de Usuario 2', false, 2),
('Tarea 3 de Usuario 1', false, 1), 
('Tarea 4 de Usuario 1', false, 1),
('Tarea 3 de Usuario 2', true, 2),
('Tarea 4 de Usuario 2', true, 2),
('Tarea 1 de Usuario 3', true, 3), 
('Tarea 2 de Usuario 3', true, 3),
('Tarea 1 de Usuario 4', false, 4),
('Tarea 2 de Usuario 4', true, 4),
('Tarea 1 de Usuario 5', false, 5), 
('Tarea 2 de Usuario 5', true, 5),
('Tarea 3 de Usuario 5', false, 5),
('Tarea 4 de Usuario 5', true, 5);


select * from user;

select * from todo;

SELECT t.title, u.username, u.country, t.completed FROM Todo t JOIN user u WHERE t.title = "Tarea 1 de Usuario 1" AND u.username = "Manelsito";
