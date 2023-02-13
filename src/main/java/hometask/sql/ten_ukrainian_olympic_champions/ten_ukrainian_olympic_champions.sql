DROP SCHEMA IF EXISTS public cascade;

CREATE SCHEMA public

    CREATE TABLE person
    (
        id        serial PRIMARY KEY,
        firstName VARCHAR NOT NULL,
        lastName  VARCHAR NOT NULL,
        age       integer NOT NULL,
        city      VARCHAR NOT NULL
    );

INSERT INTO person (firstName, lastName, age, city)
VALUES ('Yana', 'Klochkova', 40, 'Simferopol'),
       ('Vasiliy', 'Lomachenko', 34, 'Bilhorod-Dnistrovskyi'),
       ('Lilia', 'Podkopayeva', 44, 'Donetsk'),
       ('Artur', 'Ayvazyan', 50, 'Yerevan'),
       ('Yevhen', 'Braslavets', 50, 'Dnipro'),
       ('Iurii', 'Cheban', 36, 'Odessa'),
       ('Yana', 'Dementyeva', 44, 'Kharkiv'),
       ('Nataliya', 'Dobrynska', 40, 'Yakushyntsi'),
       ('Yana', 'Dementyeva', 44, 'Kharkiv'),
       ('Nataliya', 'Dovhodko', 32, 'Kyiv');

SELECT firstName, lastName
FROM person;

SELECT firstName, age
FROM person;

SELECT firstName, lastName, age, city
FROM person;

SELECT *
FROM person
ORDER BY city;

SELECT *
FROM person
ORDER BY age;

SELECT *
FROM person
ORDER BY firstName;



