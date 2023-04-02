-- drop schema
DROP SCHEMA IF EXISTS student_db cascade;

-- create schema
CREATE SCHEMA IF NOT EXISTS student_db;

-- create table
CREATE TABLE IF NOT EXISTS student_db.student
(
    id         serial PRIMARY KEY,
    first_name VARCHAR NOT NULL,
    email      VARCHAR NOT NULL
);

-- fill table
INSERT INTO student_db.student (first_name, email)
VALUES ('yana', 'klochkova@gmail.com'),
       ('vasiliy', 'lomachenko@gmail.com'),
       ('lilia', 'podkopayeva@gmail.com'),
       ('artur', 'ayvazyan@gmail.com'),
       ('yevhen', 'braslavets@gmail.com');
