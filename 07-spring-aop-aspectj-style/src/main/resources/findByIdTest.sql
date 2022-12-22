drop table if exists COURSE;

create table COURSE (
	id identity primary key ,
	name varchar(20) not null unique,
	duration int,
	fees int
);

insert into COURSE(name, duration, fees) values ('Java Basic', 4, 150000);