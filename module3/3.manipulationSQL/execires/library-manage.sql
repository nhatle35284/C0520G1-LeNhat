drop database if exists library_manage;
create database library_manage;
use library_manage;
-- bảng loại sách
create table category(
	id_category int primary key,
	name_category varchar(50)
);
-- thẻ mượn sách
create table brrow_card (
	card_code int primary key,
    id_card int ,
	student_name varchar(50),
	image varchar(50)
);
create table student(
	id_card int primary key,
	student_name varchar(50),
	student_birdthday date,
	address varchar(50),
	email varchar(50),
	phone varchar(10),
	image varchar(50),
    card_code int,
    foreign key (card_code) references brrow_card(card_code)
);


create table book( 
	book_id int primary key,
	book_name varchar(50) not null,
	publish varchar(50),
	author varchar (50),
	year_publish int,
	number_publish int,
	price double,
	image varchar(50),
    id_category int,
    card_code  int,
    foreign key (id_category) references category(id_category),
    foreign key (card_code) references brrow_card(card_code)
);
-- thêm loại sách 
insert into category values (1,"");
insert into category values (2,"");
insert into category values (3,"");
insert into category values (4,"");
insert into category values (5,"");
-- thêm thẻ mượn sách cho sinh viên
insert into brrow_card values (1234,1,"chuong","anh1");
insert into brrow_card values (1235,2,"hoang","anh2");
insert into brrow_card values (1236,3,"hai","anh3");
insert into brrow_card values (1237,4,"quang","anh4");
insert into brrow_card values (1238,5,"toan","anh5");
-- thêm sinh viên
insert into student values ( 1,"chuong",12/02/1988,"quang tri","abc@abc.abc","0343242363","eqwfdsafads",1234);
-- thêm sách
insert into book values(1,"thieu nhi", "nhi dong","abc",2000,2,1200,"avdvf",1,1234);
