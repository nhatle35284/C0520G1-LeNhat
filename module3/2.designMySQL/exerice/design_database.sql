drop database if exists classic_cars;
create database classic_cars;
use classic_cars;
create table offices (
	office_code varchar(10) not null unique primary key,
	city varchar(50) not null,
	phone varchar(50) not null,
	address_line1 varchar(50) not null,
	address_line2 varchar(50),
	state varchar(50),
	country varchar(50) not null,
	postal_code varchar(15) not null
);

create table employees (
	employee_number int not null unique primary key,
	last_name varchar(50) not null,
	first_name varchar(50) not null,
	email varchar(100) not null,
	job_title  varchar(50) not null,
	report_to varchar(255),
	office_code varchar(10),
	foreign key (report_to) references employees(report_to),
	foreign key (office_code) references offices(office_code)
);
create table customers (
	customer_number int not null unique primary key,
	customer_name varchar(50)not null,
	contact_lastName varchar(50)not null, 
	contact_firstName varchar(50)not null, 
	phone  varchar(50) not null, 
	address_line1 varchar(50) not null, 
	address_line2 varchar(50), 
	city varchar(50) not null, 
	state  varchar(50) not null, 
	postal_code varchar(15) not null, 
	country  varchar(50) not null, 
	credit_limit  int,
	sales_rep_employee_number varchar(255) not null,
	foreign key (sales_rep_employee_number) references employees(sales_rep_employee_number)
);

create table productlines (
	product_line varchar(50) not null unique primary key,
	text_description varchar(255) not null,
	image varchar(255) not null
);

create table products (
	product_code varchar(15) not null unique primary key,
	product_name varchar(70) not null,
	product_scale  varchar(10) not null,
	product_vendor  varchar(50) not null,
	product_description varchar(255) not null,
	quantity_in_stock  int not null,
	buy_price double not null,
	MSRP double not null,
	product_line varchar(50) not null,
	foreign key (product_line) references productlines(product_line)
);

create table orders (
	order_number int unique not null primary key,
	order_date date not null,
	required_date  date not null,
	shipped_date   date not null,
	`status` varchar(15),
	comments varchar(255),
	quantity_ordered int not null,
	price_each double not null,
	customer_number int not null,
	foreign key (customer_number) references customers(customer_number)
);
create table payments (
	customer_number int not null,
	check_number varchar(50) not null,
	payment_date date not null,
	amount double not null,
	foreign key (customerNumber) references customers(customerNumber)
);

create table OrderDetails(
	order_number int not null,
	product_code varchar(15),
	foreign key (order_number) references orders(order_number),
	foreign key (product_code) references products(product_code)
);
