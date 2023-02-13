CREATE TABLE IF NOT EXISTS users
(
   id SERIAL PRIMARY KEY,
   firstName varchar(255) not null,
   lastName varchar(255) not null,
   emailId varchar(255) not null
);