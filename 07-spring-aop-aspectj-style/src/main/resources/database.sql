create table COURSE (
	id identity primary key ,
	name varchar(20) not null unique,
	duration int,
	fees int
);