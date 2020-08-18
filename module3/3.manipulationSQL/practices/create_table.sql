drop database if exists sinh_vien_05;
create database sinh_vien_05;
use sinh_vien_05;
create table sinh_vien(
ten_sv varchar(255),
ma_sv int,
nam_sinh int
);
insert into sinh_vien(ten_sv,ma_sv,nam_sinh) values 
("hai",1,2001),
("hoang",2,1999),
("nhat",3,2000);
select*from sinh_vien;
delete from sinh_vien where ma_sv;
update sinh_vien set ten_sv="chuong",ma_sv=4,nam_sinh=1988 where ma_sv=2;
alter table student
add age int;
insert into sinh_vien(ten_sv,ma_sv,nam_sinh) values ("hai",1,2001); 