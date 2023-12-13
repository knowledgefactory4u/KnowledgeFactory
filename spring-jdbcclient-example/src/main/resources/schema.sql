-- DROP TABLE IF EXISTS students;

CREATE TABLE students (
  id SERIAL PRIMARY KEY,
  name VARCHAR(250) NOT NULL,
  email VARCHAR(250) NOT NULL,
  gender VARCHAR(250) NOT NULL,
  age INT
);