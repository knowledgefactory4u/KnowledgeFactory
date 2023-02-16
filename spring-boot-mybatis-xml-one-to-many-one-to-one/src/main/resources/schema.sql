CREATE TABLE IF NOT EXISTS users
    (
        email CHARACTER VARYING(30) NOT NULL,
        name CHARACTER VARYING(30),
        PRIMARY KEY (email)
    );
CREATE TABLE IF NOT EXISTS cards
    (

       PRIMARY KEY (id),
       id INTEGER NOT NULL,
       cardnumber CHARACTER VARYING(30),
       cardtype CHARACTER VARYING(50),
       email CHARACTER VARYING(50),
       CONSTRAINT fk_group
             FOREIGN KEY(email)
                  REFERENCES users(email)
    );