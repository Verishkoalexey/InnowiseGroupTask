DROP TABLE users;
CREATE TABLE users (Id int NOT NULL AUTO_INCREMENT, First_Name varchar(64) NOT NULL, Last_Name varchar(64) NOT NULL, Email varchar(64) NOT NULL, Role varchar(64), Phone_Number varchar(64), PRIMARY KEY (Id)) ENGINE=InnoDB DEFAULT CHARSET=utf8 DEFAULT COLLATE=utf8_general_ci;
