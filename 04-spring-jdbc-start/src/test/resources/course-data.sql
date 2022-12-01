truncate table course;

insert into course (name, level, duration, fees, description, deleted) values 
('Java Basic', 1, 3, 300000, 'Entrance Java Course', false),
('Jakarta EE', 2, 5, 500000, 'Enterprise Java Course', true),
('Spring Framework', 2, 5, 500000, 'Enterprise Java Course', false),
('Flutter', 1, 3, 300000, 'Mobile Development Course', false);
