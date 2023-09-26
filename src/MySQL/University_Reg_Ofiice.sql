create database URO;
use URO;
show tables;
drop table student;
create table student(Stu_id char(7) primary key,Stu_name varchar(30),Program varchar(20));
Select * from student;
desc student;
Select * from courses;
desc courses;
Select * from course_offering;
desc course_offering;
create table courses(course_id char(5) primary key,course_title varchar(30),credit int,syllabus text,prerequisites text);
create table course_offering(course_id char(5),Year year,semester int,section_number int,instructor varchar(30),timing time,classroom varchar(5),
FOREIGN KEY(course_id) REFERENCES courses(course_id));