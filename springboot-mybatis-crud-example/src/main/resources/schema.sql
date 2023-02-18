create table users
(
   id IDENTITY NOT NULL PRIMARY KEY ,
   first_name VARCHAR(255) NOT NULL,
   last_name VARCHAR(255) NOT NULL,
   email_id VARCHAR(255) NOT NULL
);