drop database if exists demo;
create database demo;
use demo; 
create table products(
	Id int,
	product_code int,
	product_name varchar(50),
	product_price double,
	product_amount int,
	product_description varchar(255),
	product_status varchar(50)
);
insert into products 
values (1,1234,"samsung galaxy note 9",1000,12,"","Ok");
insert into products 
values (2,1235,"samsung galaxy note 8",900,11,"","Ok");
insert into products 
values (3,1236,"samsung galaxy note 7",800,15,"","Ok");
insert into products 
values (4,1237,"samsung galaxy note 6",700,19,"","Ok");
insert into products 
values (5,1238,"samsung galaxy note 5",500,100,"","Ok");

-- truy vấn bình thường
select * 
from products 
where product_code = 1237; 

-- sử dụng explain truy vấn bình thường
explain select * 
from products 
where product_code = 1237;

-- tạo unique index
alter table products 
add unique index idex_products (product_code);	

-- sử dụng explain unique index
explain select * 
from products 
where product_code = 1237;

-- tạo composite index (product_name,product_price)
alter table products 
add index idex_composite (product_name,product_price);

-- sử dụng explain unique index
explain select * 
from products 
where product_code = 1237;

-- xóa index
drop index idex_products on products;
drop index idex_composite on products;

-- Tạo view lấy về các thông tin: productCode, productName, productPrice, productStatus từ bảng products.
create view product_view as
 
select product_code, product_name, product_price, product_status

from products;

-- kết quả tạo view từ productCode, productName, productPrice, productStatus từ bảng products
select*from product_view;

-- sửa đổi view
create or replace view product_view as 
select product_code, product_name, product_price, product_status
from products
where product_price = 1000;

select*
from product_view;
-- xóa view 
drop view product_view;

-- tạo procedure 
DELIMITER //

create procedure show_all_product
()

begin

	select * from products;

end; //

DELIMITER ;
-- goi show_all_product()
call show_all_product();

-- procedure thêm sản phẩm
delimiter //

create procedure add_product(in Id int,
	in product_code int,
	in product_name varchar(50),
	in product_price double,
	in product_amount int,
	in product_description varchar(255),
	in product_status varchar(50) )
begin
	insert into products values (Id,
		product_code,
        product_name,
        product_price,
        product_amount,
        product_description,
        product_status);
end; //
delimiter ;
-- gọi add product 
call add_product(1,1234,"samsung galaxy note 9",1000,12,"","Ok");
select*from products;

-- procedure sửa sản phẩm theo id
DELIMITER //

create procedure update_product
(in id_update int)

begin

	update products set product_name="sam sung galaxy note 9s" where Id=id_update;

end; //

DELIMITER ;
-- gọi procedure xóa sản phẩm
call delete_product(2);

-- procedure xóa sản phẩm theo id
DELIMITER //

create procedure delete_product
(in id_delete int)

begin

	delete from products where Id=id_delete;

end; //

DELIMITER ;
-- gọi procedure xóa sản phẩm
call delete_product(2);
