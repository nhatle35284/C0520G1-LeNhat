drop database if exists product_manage;
create database product_manage;
use product_manage;

create table product(
id int primary key,
`name` varchar(45),
price double,
quantity int,
color varchar(255),
`description` varchar(255),
category varchar(45)
);

insert into product(id,`name`,price,quantity,color,`description`,category )
values(1,"IPhone 11",799,12,"Purple,Yellow,Green","product Smart Phone new","Phone"),
(2,"IPhone 11 Pro",1100,12,"Green,Black,White","product Smart Phone new","Phone"),
(3,"IPhone X",749,13,"Coral,Black,Bule","product Smart Phone new","Phone"),
(4,"Smart TV màn hình cong 4K UHD 49 inch RU3700",10000000,5,"Black","product Smart TV new","Television"),
(5,"SamSung Galaxy S10 E",420,10,"Prism White,Prism Bule,Prosm Black","product Smart Phone SamSung new","Phone");