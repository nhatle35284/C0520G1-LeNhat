drop database if exists sinh_vien_05;
create database sinh_vien_05;
use sinh_vien_05;
create table student(
	id int primary key,
	full_name varchar(50),
	age int
);
create table class(
	name_class varchar(50),
	student int,
	foreign key (student) references student(id)
);
insert into student(id,full_name,age) values (1,"nhat",20),(2,"hoang",21),(3,"hải",19);
insert into class(name_class,student) values ("CO5",1),("CO4",2);

select*from student 
inner join class on student.id = class.student;
select*from student 
left join class on student.id = class.student;
select*from student 
right join class on student.id = class.student;