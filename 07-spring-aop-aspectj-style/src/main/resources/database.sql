create table COURSE (
	id int primary key auto_increment,
	name varchar(20) not null unique,
	duration int,
	fees int
);