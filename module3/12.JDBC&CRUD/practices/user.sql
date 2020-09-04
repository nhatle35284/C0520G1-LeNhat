drop database if exists demo;
create database demo;
use demo;

create table users (
 id  int(3) not null auto_increment,
 `name` varchar(120) not null,
 email varchar(220) not null,
 country varchar(120),
 primary key (id)
);

insert into users (`name`,email,country) values 
("quang","abc@abc.abc","VietNam"),
("hai","abc@abc.abc","SanHok"),
("hoang","abc@abc.abc","My"),
("nhat","abc@abc.abc","VietNam");

-- Định nghĩa Stored Procedures get_user_by_id
DELIMITER $$

create procedure get_user_by_id(in user_id int)

begin

    select users.name, users.email, users.country

    from users

    where users.id = user_id;

    end$$

DELIMITER ;

-- Định nghĩa Stored Procedures  insert_user 
DELIMITER $$

create procedure get_user_by_id(in user_id int)

begin

    select users.name, users.email, users.country

    from users

    where users.id = user_id;

    end$$

DELIMITER ;

  

DELIMITER $$

create procedure insert_user(

in user_name varchar(50),

in user_email varchar(50),

in user_country varchar(50)

)

begin

    insert into users(name, email, country) values(user_name, user_email, user_country);

    end$$

DELIMITER ;


DELIMITER $$

create procedure get_all_user(

)

begin

    select*from users;

    end$$

DELIMITER ;

DELIMITER $$

create procedure update_user(

in user_id int,
in user_name varchar(50),

in user_email varchar(50),

in user_country varchar(50)

)

begin

    update users set users.`name`=user_name,users.email=user_email,users.country=user_country where users.id=id;

    end$$

DELIMITER ;

DELIMITER $$

create procedure delete_user(

in user_id int

)

begin

    delete from users  where users.id=id;

    end$$

DELIMITER ;

DELIMITER $$

create procedure search_by_country(

in user_country varchar(50)

)

begin

    select * from users where users.country =user_country;

    end$$

DELIMITER ;

