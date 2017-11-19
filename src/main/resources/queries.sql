--on mysql command line
CREATE SCHEMA adsapp;
USE adsapp;
CREATE TABLE adverts (
    ID int NOT NULL AUTO_INCREMENT,
    name varchar(255) NOT NULL,
    email varchar(255),
    text varchar(255),
    PRIMARY KEY (ID)
);

insert into adverts values(1, 'Bhagwati Prasad', 'write2bpj@gmail.com', 'Java @ 5$/hour');