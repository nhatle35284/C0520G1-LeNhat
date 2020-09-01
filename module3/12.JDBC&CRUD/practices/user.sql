drop database if exists demo;
create database demo;
use demo;

create table users (
 id  int(3) not null auto_increment,
 `name` varchar(120) not null,
 email varchar(220) not null,
 country varchar(120),
 primary key (id)
);

insert into users (`name`,email,country) values 
("nhat","abc@abc.abc","VietNam"),
("nhat","abc@abc.abc","VietNam"),
("nhat","abc@abc.abc","VietNam"),
("nhat","abc@abc.abc","VietNam");