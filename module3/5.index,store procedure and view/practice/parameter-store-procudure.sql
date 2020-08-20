-- tham số loại IN
DELIMITER //

create procedure getCusById

(in cusNum int(11))

begin

  select * from customers where customerNumber = cusNum;

end //

DELIMITER ;

-- Gọi store procedure:

call getCusById(175);
delimiter //


-- tham số loại OUT 
create procedure GetCustomersCountByCity(

    in  in_city varchar(50),

    out total int

)

begin

    select count(customerNumber)

    into total

    from customers

    where city = in_city;

end//

DELIMITER ;
-- Gọi store procedure:

CALL GetCustomersCountByCity('Lyon',@total);

SELECT @total;


-- tham số  loại INOUT
DELIMITER //

CREATE PROCEDURE SetCounter(

    INOUT counter INT,

    IN inc INT

)

BEGIN

    SET counter = counter + inc;

END//

DELIMITER ;

-- Gọi store procedure:

SET @counter = 1;

CALL SetCounter(@counter,1); -- 2

CALL SetCounter(@counter,1); -- 3

CALL SetCounter(@counter,5); -- 8

SELECT @counter; -- 8