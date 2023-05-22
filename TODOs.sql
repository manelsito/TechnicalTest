drop database if exists TODOsDB;

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
('Manel Agudo', 'Manel', '$2a$10$Jezyu76toVlzQgl9GMn./.WaNbxDX9EX7w.aIN.91G417YXmdmjdK', 'Terra Baixa', 'Hospitalet de Llobregat', '08901', 'Spain'),
('Alberto Santos', 'Alberto', '$2a$10$DEEKfUP5.PPx1AXqJtwbl.yu0SYl0X/aIOTIsMN6ir9tHLuPD2iu6', 'Torres i Amat', 'Barcelona', '08001', 'Spain'),
('María López', 'MariaL', '$2a$10$ZThsT02hmRKFllyWXbOdP.uXPdAcrd.BMheX5RnjscC9CUIcBQVTO', 'Calle Principal', 'Madrid', '28001', 'Spain'),
('John Smith', 'johnsmith', '$2a$10$U2djFqUUDMGlrccNo9jpMedDcC70Y7bomveVp1b6JnjWiq0JFpVXK', '123 Oak Street', 'New York', '10001', 'United States'),
('Laura García', 'laurag', '$2a$10$0vBnjyD1WO3fzRbhOl.8ieWs0oQgRqogtja.DVmEsJFp0yAMeqc4e', 'Avenida del Sol', 'Sevilla', '41001', 'Spain');


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
