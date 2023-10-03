create database uni_exam;
use uni_exam;


create table course (
c_number varchar(5) primary key,
c_name varchar(30),
c_dept varchar(20));

create table section (
s_number varchar(5),
s_enrollment int,
c_number varchar(5),
foreign key (c_number) references course(c_number));


create table Room(
r_number varchar(7) primary key,
capacity int,
building varchar(20));

create table exam(
exam_id varchar(7) primary key,
c_number varchar(5),
s_number varchar(5),
r_number varchar(5),
e_time time,
foreign key (c_number) references course(c_number),
foreign key (r_number) references Room(r_number));