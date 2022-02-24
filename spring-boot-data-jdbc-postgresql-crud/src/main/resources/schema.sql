--
-- Create table for `users`
--

CREATE TABLE users (
	id serial PRIMARY KEY,
	first_name VARCHAR ( 50 )  NOT NULL,
	last_name VARCHAR ( 50 ) NOT NULL,
	email VARCHAR ( 255 )  NOT NULL
);