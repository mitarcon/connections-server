DROP TABLE greeting_entity IF EXISTS;

CREATE TABLE greeting_entity (
  id INT GENERATED BY DEFAULT AS IDENTITY (START WITH 1, INCREMENT BY 1) NOT NULL,
  text VARCHAR(100) NOT NULL,
  PRIMARY KEY(id)
);