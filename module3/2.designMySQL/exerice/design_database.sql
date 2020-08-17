drop database if exists classic_cars;
create database classic_cars;
use classic_cars;
create table offices (
officeCode varchar(10) not null unique primary key,
city varchar(50) not null,
phone varchar(50) not null,
addressLine1 varchar(50) not null,
addressLine2 varchar(50),
state varchar(50),
country varchar(50) not null,
postalCode varchar(15) not null
);

create table employees (
employeeNumber int not null unique primary key,
lastName varchar(50) not null,
firstName varchar(50) not null,
email varchar(100) not null,
jobTitle  varchar(50) not null,
reportTo varchar(255),
officeCode varchar(10),
foreign key (reportTo) references employees(reportTo),
foreign key (officeCode) references offices(officeCode)
);
create table customers (
customerNumber int not null unique primary key,
customerName varchar(50)not null,
contactLastName varchar(50)not null, 
contactFirstName varchar(50)not null, 
phone  varchar(50) not null, 
addressLine1 varchar(50) not null, 
addressLine2 varchar(50), 
city varchar(50) not null, 
state  varchar(50) not null, 
postalCode varchar(15) not null, 
country  varchar(50) not null, 
creditLimit  int,
salesRepEmployeeNumber varchar(255) not null,
foreign key (salesRepEmployeeNumber) references employees(salesRepEmployeeNumber)
);

create table productlines (
productLine varchar(50) not null unique primary key,
textDescription varchar(255) not null,
image varchar(255) not null
);

create table products (
productCode varchar(15) not null unique primary key,
productName varchar(70) not null,
productScale  varchar(10) not null,
productVendor  varchar(50) not null,
productDescription varchar(255) not null,
quantityInStock  int not null,
buyPrice double not null,
MSRP double not null,
productLine varchar(50) not null,
foreign key (productLine) references productlines(productLine)
);

create table orders (
orderNumber int unique not null primary key,
orderDate date not null,
requiredDate  date not null,
shippedDate   date not null,
`status` varchar(15),
comments varchar(255),
quantityOrdered int not null,
priceEach double not null,
customerNumber int not null,
foreign key (customerNumber) references customers(customerNumber)
);
create table payments (
customerNumber int not null,
checkNumber varchar(50) not null,
paymentDate date not null,
amount double not null,
foreign key (customerNumber) references customers(customerNumber)
);

create table OrderDetails(
ordernumber int not null,
productcode varchar(15),
foreign key (ordernumber) references orders(orders),
foreign key (productcode) references products(productcode)
);
