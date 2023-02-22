IF OBJECT_ID(N'users', N'U') IS NULL
CREATE TABLE users (
  id              INT           NOT NULL    IDENTITY    PRIMARY KEY,
  first_name      VARCHAR(100)  NOT NULL,
  last_name       VARCHAR(100),
  email           VARCHAR(100)  NOT NULL,
);