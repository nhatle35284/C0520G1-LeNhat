drop database if exists library_manage;
create database library_manage;
use library_manage;
-- bảng loại sách
create table category(
	id_category int primary key,
	name_category varchar(50)
);
-- thẻ mượn sách
create table brrow_order (
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
    foreign key (card_code) references brrow_order(card_code)
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
    foreign key (card_code) references brrow_order(card_code)
);
-- chi tiết mượn 
create table order_details(
book_id int,
id_card int,
foreign key (book_id) references book(book_id),
foreign key (id_card) references student(id_card)
);
-- thêm loại sách 
insert into category values (1,"");
insert into category values (2,"");
insert into category values (3,"");
insert into category values (4,"");
insert into category values (5,"");
-- thêm thẻ mượn sách cho sinh viên
insert into brrow_order values (1234,1,"chuong","anh1");
insert into brrow_order values (1235,2,"hoang","anh2");
insert into brrow_order values (1236,3,"hai","anh3");
insert into brrow_order values (1237,4,"quang","anh4");
insert into brrow_order values (1238,5,"toan","anh5");
-- thêm sinh viên
insert into student values ( 1,"chuong",12/02/1988,"quang tri","abc@abc.abc","0343242363","eqwfdsafads",1234);
insert into student values ( 2,"chuong",03/05/1999,"quang nam","abc@abc.abc","0412341245","eqwfdsafads",1235);
insert into student values ( 3,"hai",13/08/2001,"ha tinh","abc@abc.abc","0523456421","eqwfdsafads",1236);
insert into student values ( 4,"quang",11/06/1996,"quang tri","abc@abc.abc","0343242363","eqwfdsafads",1237);
insert into student values ( 5,"toan",12/02/1993,"quang tri","abc@abc.abc","0343242363","eqwfdsafads",1238);
-- thêm sách
insert into book values(1,"truyen tranh", "nhi dong","abc",2000,2,1200,"avdvf",1,1234);
insert into book values(2,"thieu nhi1", "nhi dong","abc",2000,2,1200,"avdvf",2,1235);
insert into book values(3,"thieu nhi2", "nhi dong","abc",2000,2,1200,"avdvf",3,1236);
insert into book values(4,"thieu nhi3", "nhi dong","abc",2000,2,1200,"avdvf",4,1237);
insert into book values(5,"thieu nhi4", "nhi dong","abc",2000,2,1200,"avdvf",5,1238);
