CREATE DATABASE finsystem CHARACTER SET utf8;
CREATE USER 'financial_user'@'localhost' IDENTIFIED BY '1234';
USE finsystem;
GRANT ALL PRIVILEGES ON finsystem.* TO 'financial_user'@'localhost';
FLUSH PRIVILEGES;
