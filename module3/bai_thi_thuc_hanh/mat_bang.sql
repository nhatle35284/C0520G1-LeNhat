drop database if exists quan_ly_mat_bang;
create database quan_ly_mat_bang;
use quan_ly_mat_bang;

create table mat_bang(
ma varchar(45) primary key,
dien_tich double,
trang_thai varchar(45),
tang int,
loai_van_phong varchar(45),
gia double,
ngay_bat_dau date,
ngay_ket_thuc date
);

insert into mat_bang(ma,dien_tich,trang_thai,tang,loai_van_phong,gia,ngay_bat_dau,ngay_ket_thuc) values 
("MB001",100,"trống",2,"Cho Thuê",2000000,"2020/11/20","2021/11/25"),
("MB002",400,"trống",5,"Trọn gói",5000000,"2020/04/03","2020/10/03");

select*from mat_bang