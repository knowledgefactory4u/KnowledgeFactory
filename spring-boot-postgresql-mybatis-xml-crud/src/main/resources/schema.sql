CREATE TABLE IF NOT EXISTS users
(
   id SERIAL PRIMARY KEY,
   first_name varchar(255) not null,
   last_name varchar(255) not null,
   email_id varchar(255) not null
);