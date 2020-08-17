drop database if exists user_me;
create database user_me;
use user_me;
CREATE TABLE users(
   user_id INT AUTO_INCREMENT PRIMARY KEY,
   username VARCHAR(40),
   password VARCHAR(255),
   email VARCHAR(255)
);
CREATE TABLE roles(
   role_id INT AUTO_INCREMENT,
   role_name VARCHAR(50),
   PRIMARY KEY(role_id)
);
CREATE TABLE userroles(
   user_id INT NOT NULL,
   role_id INT NOT NULL,
   PRIMARY KEY(user_id,role_id),
   FOREIGN KEY(user_id) REFERENCES users(user_id),
   FOREIGN KEY(role_id) REFERENCES roles(role_id)
);
CREATE TABLE user1(
id INT NOT NULL
);
ALTER TABLE user1
    ADD PRIMARY KEY(id);