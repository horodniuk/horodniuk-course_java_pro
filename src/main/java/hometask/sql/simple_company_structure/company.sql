SELECT *
FROM employees
WHERE salary BETWEEN 1000 and 3000;

SELECT *
FROM employees
WHERE job_id IN (9, 10, 11);


SELECT *
FROM employees
WHERE salary = (SELECT MAX(salary) FROM employees);


SELECT *
FROM employees
WHERE salary = (SELECT MIN(salary) FROM employees);