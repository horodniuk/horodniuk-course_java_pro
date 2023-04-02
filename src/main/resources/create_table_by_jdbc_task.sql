CREATE TABLE person
(
    id        INTEGER  NOT NULL AUTO_INCREMENT,
    firstName CHAR(50) NOT NULL,
    lastName  CHAR(50) NOT NULL,
    age       INTEGER  NOT NULL,
    PRIMARY KEY (id)
);

INSERT INTO person (firstName, lastName, age)
VALUES ('Robert', 'Anderson', 15),
       ('Faruk', 'Barber', 20),
       ('Anne', 'Bennet', 25),
       ('Nicholas', 'Berryman', 30),
       ('Amanda', 'Borec', 35);