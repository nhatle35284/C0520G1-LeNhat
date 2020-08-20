drop database if exists `file`;
create database `file`;
use `file`;
create table student (
	id int,
    ten varchar(50),
    tuoi int,
    khoahoc varchar(50),
    sotien int 
);
insert into  student 
values (1,"Hoang",21,"CNTT",40000);

insert into  student 
values (2,"Viet",19,"DTVT",32000);

insert into  student 
values (3,"Thanh",18,"KTDN",40000);

insert into  student 
values (4,"Nhan",19,"CK",45000);

insert into  student 
values (5,"Huong",20,"TCNH",50000);

insert into  student 
values (5,"Huong",20,"TCND",20000);

-- hiển thị người tên huong
select * 
from student 
where ten="Huong";
select count(id),ten 
from student 
where ten="huong" 
group by tuoi;

-- hien thi tong tiền của huong
select ten,sum(sotien) as tongtien 
from student 
where ten="huong";

-- hiển thi danh sách tên không trùng lặp
select distinct id 
from student