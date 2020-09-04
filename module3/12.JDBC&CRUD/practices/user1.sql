drop database if exists `transaction`;
CREATE DATABASE `transaction`;
USE `transaction`;

create table users (
 id  int(3) NOT NULL AUTO_INCREMENT,
 name varchar(120) NOT NULL,
 email varchar(220) NOT NULL,
 country varchar(120),
 PRIMARY KEY (id)
);
insert into users(name, email, country) values('Minh','minh@codegym.vn','Viet Nam');
insert into users(name, email, country) values('Kante','kante@che.uk','Kenia');

create table contract(
id_contract int primary key,
id_user int,
name_contract varchar(50),
foreign key (id_user) references users(id) 
);

insert into contract(id_contract,id_user,name_contract) values(1,1,"ttx");
insert into contract(id_contract,id_user,name_contract) values(2,2,"ttm");