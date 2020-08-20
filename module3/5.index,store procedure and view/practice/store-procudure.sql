-- Tạo Mysql Stored Procedure đầu tiên
-- DELIMITER //

-- CREATE PROCEDURE findAllCustomers()

-- BEGIN

--   SELECT * FROM customers;

-- END //

-- DELIMITER ;

-- Sửa procedure
use classicmodels;
DELIMITER //

drop procedure if exists `findAllCustomers`//

create procedure findAllCustomers()

begin

   select *  from customers where customerNumber = 175;

end; //

DELIMITER ;

-- Cách gọi procedure
call findAllCustomers();