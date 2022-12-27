create database jpademo;

create user 'jpademo'@'localhost' identified by 'jpademo';

grant all privileges on jpademo.* to 'jpademo'@'localhost';

use jpademo

create table jpamember (
	id int primary key auto_increment,
	name varchar(40) not null,
	phone varchar(20),
	email varchar(40) unique not null
);