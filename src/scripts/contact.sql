DROP TABLE IF EXISTS Contact;

CREATE TABLE Contact (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  firstName VARCHAR (100),
  lastName VARCHAR (100),
  companyName VARCHAR (100),
  hobby VARCHAR (100)
);