drop database if exists furama_manage;
create database furama_manage;
use furama_manage;
create table `position`(
	position_id int primary key,
    position_name varchar(45),
    check(position_name="Lễ Tân" 
    or position_name="Phục Vụ"
    or position_name="Chuyên Viên"
    or position_name="Giám Sát"
    or position_name="Quản Lý"
    or position_name="Giám Đốc"
	)
);

create table education_degree(
	education_degree_id int primary key,
    education_degree_name varchar(45),
    check(education_degree_name="Trung Cấp" 
    or education_degree_name="Cao Đẳng"
    or education_degree_name="Đại Học"
    or education_degree_name="sau Đại Học"
	)
);

create table division(
	division_id int primary key,
    division_name varchar(45),
    check(division_name="Sale_Marketing" 
    or division_name="Hành Chính"
    or division_name="Phục Vụ"
    or division_name="Quản Lý"
	)
);

create table `user`(
	user_name varchar(255) primary key,
    user_password varchar(255)
);

create table employee(
	employee_id int primary key,
	employee_name varchar(45),
	employee_birthday date,
	employee_id_card varchar(45),
	employee_salary double,
	employee_phone varchar(45),
	employee_email varchar(45),
	employee_address varchar(45),
    position_id int,
    education_degree_id int,
    division_id int,
    user_name varchar(45),
    foreign key (position_id) references `position`(position_id) on delete cascade,
    foreign key (education_degree_id) references education_degree(education_degree_id) on delete cascade,
    foreign key (division_id) references division(division_id) on delete cascade,
    foreign key (user_name) references user(user_name) on delete cascade
);

create table customer_type(
	customer_type_id int primary key,
	customer_type_name varchar(45)
);

create table customer(
	customer_id int primary key,
	customer_type_id int,
	customer_name varchar(45),
	customer_birthday date,
	customer_gender bit(1),
	customer_id_card varchar(45),
	customer_phone varchar(45),
	customer_email varchar(45),
	customer_address varchar(45),
    foreign key (customer_type_id) references customer_type(customer_type_id) on delete cascade
);

create table `role`(
	role_id int primary key,
    role_name varchar(45)
);

create table user_role(
	role_id int primary key,
    user_name varchar(45)
);

create table attach_service(
	attach_service_id int primary key,
	attach_service_name varchar(45),
	attach_service_cost double,
	attach_service_unti int ,
	attach_service_status varchar(45)
);

create table service_type(
	service_type_id int primary key,
	service_type_name varchar(45)
);

create table rent_type(
	rent_type_id int primary key,
	rent_type_name varchar(45),
	rent_type_cost double
);

create table service(
	service_id int primary key,
    service_name varchar(45),
    service_area double,
    service_cost double,
    service_max_people int,
    rent_type_id int,
    service_type_id int,
    standard_room varchar(45),
    description_order_convenience varchar(45),
    pool_area double,
    number_floors int,
    foreign key (rent_type_id) references rent_type(rent_type_id) on delete cascade,
    foreign key (service_type_id) references service_type(service_type_id) on delete cascade
);

create table contract(
	contract_id int primary key,
    contract_start_date datetime,
    contract_end_date datetime,
    contract_deposit double,
    contract_total_money double,
    employee_id int,
    customer_id int,
    service_id int,
    foreign key (employee_id) references employee(employee_id)on delete cascade,
    foreign key (customer_id) references customer(customer_id)on delete cascade,
    foreign key (service_id) references service(service_id)on delete cascade
);

create table contract_detail(
	contract_detail_id int primary key,
	contract_id int,
    attach_service_id int,
    quantity int,
    foreign key (contract_id) references contract(contract_id)on delete cascade,
    foreign key (attach_service_id) references attach_service(attach_service_id)on delete cascade);

-- thêm vị trí 
insert into `position`(position_id,position_name) 
values (1,"Lễ Tân"),
(2,"Phục Vụ"),
(3,"Chuyên Viên"),
(4,"Giám Sát"),
(5,"Quản Lý"),
(6,"Giám Đốc");

-- thêm trình độ
insert into education_degree(education_degree_id,education_degree_name) 
values (1,"Trung Cấp"),
(2,"Cao Đẳng"),
(3,"Đại Học"),
(4,"Sau Đại Học");

-- thêm bộ phận
insert into division(division_id,division_name) 
values (1,"Sale_Marketing"),
(2,"Hành Chính"),
(3,"Phục Vụ"),
(4,"Quản Lý");

-- thêm người sử dụng
insert into `user`(user_name,user_password) 
values ("minhminh32","123456a"),
("quangnguyen0203","123456c"),
("chuonghoang1234","123456d"),
("haitien123","123456e"),
("tungtu1234","123456f"),
("hientran123","123456g"),
("toan123","123456g");

-- thêm nhân viên
insert into employee (employee_id,employee_name,employee_birthday,employee_id_card,employee_salary,
employee_phone,employee_email,employee_address,position_id,education_degree_id,division_id,user_name)
values (1,"Lê Minh",'2004/06/04',"14124134",5500000,"091234556","minh2004@gmail.com","Da Nang",1,2,1,"minhminh32"),
(2,"Nguyen Huu Quang",'1996/12/12',"14896548",5500000,"091234556","quang1996@gmail.com","Da Nang",1,3,1,"quangnguyen0203"),
(3,"Hoàng Văn Kim Chương",'1988/05/25',"21342686",5500000,"091234556","chuong1988@gmail.com","Da Nang",1,4,1,"chuonghoang1234"),
(4,"Nguyễn Tiến Hải",'2001/08/13',"12414145",5500000,"091234556","haitien2001@gmail.com","Da Nang",1,1,3,"haitien123"),
(5,"Từ Sỹ Tùng",'1995/12/12',"14877548",5500000,"091234556","tungtu1995@gmail.com","Da Nang",1,4,2,"tungtu1234"),
(6,"Trần Hữu Hiên",'1996/06/12',"79674646",5500000,"0912432526","hient1996@gmail.com","Da Nang",1,3,4,"hientran123");

-- thêm loại khách 
insert into customer_type(customer_type_id,customer_type_name) 
values (1,"Diamond"),
(2,"Platinium"),
(3,"Gold"),
(4,"Silver"),
(5,"Member");

-- thêm Khách hàng
insert into customer (customer_id,customer_type_id,customer_name,customer_birthday,customer_gender,
	customer_id_card,customer_phone,customer_email,customer_address)
values (1,2,"Hoang Thi A",'1999/12/07',1,"312314124","0123452432","athihoang11@gmail.com","Quảng Nam"),
(2,3,"Tu Hong B",'2003/12/13',0,"312314124","0123452432","btuhong11@gmail.com","Quảng Trị"),
(3,1,"Khanh Thi C",'1980/12/07',1,"312314124","0123452432","cthihoang11@gmail.com","Đà Nẵng"),
(4,4,"Nguyen Thi D",'1999/12/07',1,"312314124","0123452432","dthihoang11@gmail.com","Quảng Trị");

-- thêm loại dịch vụ di kèm
insert into attach_service(attach_service_id,attach_service_name,attach_service_cost,attach_service_unti,
	attach_service_status)
values (1,"massage","50",1,"Tốt"),
(2,"karaoke","45",1,"Tốt"),
(3,"thức ăn","10",1,"Tốt"),
(4,"nước uống","5",1,"Tốt"),
(5,"xe di chuyển tham quan quanh resort","30",1,"Tốt");

-- thêm loại dịch vụ 
insert into service_type(service_type_id,service_type_name) 
values (1,"Villa"),
(2,"House"),
(3,"Room");

-- thêm kiểu thuê
insert into rent_type (rent_type_id,rent_type_name,rent_type_cost)
values (1,"Đêm",100),
(2,"Ngày",300),
(3,"Tháng",2000);

-- thêm dịch vụ
insert into  service(service_id,service_name,service_area,service_cost,service_max_people,rent_type_id,
    service_type_id,standard_room,description_order_convenience,pool_area,number_floors) 
values (1,"Villa1",32.3,12000,4,1,1,"CUD","măt hàng",7.5,3),
(2,"Villa2",32.3,12000,4,1,1,"CPD","măt hàng",7,3),
(3,"House1",25.3,8000,4,1,1,"CRD","măt hàng",4.5,1),
(4,"House",23.3,9000,4,1,1,"CUD","măt hàng",4,2);

-- thêm hợp đồng
insert into contract(contract_id,contract_start_date,contract_end_date,contract_deposit,contract_total_money,
    employee_id,customer_id,service_id)
values (1,'2019/12/04','2020/07/05',100,2000,1,1,1),
(2,'2020/12/04','2020/07/05',100,2000,2,3,1),
(3,'2020/12/04','2020/07/05',100,2000,3,2,3),
(4,'2019/12/04','2020/07/05',100,2000,3,2,2);

insert into contract_detail(contract_detail_id,contract_id,attach_service_id,quantity) 
values (1,1,1,5),
(2,3,3,2),
(3,4,2,2),
(4,2,1,3),
(5,2,2,3),
(6,2,1,3);
select * from customer;

select * from employee;

select * from service;