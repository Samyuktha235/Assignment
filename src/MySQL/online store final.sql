create database ONSF;
use ONSF;

create table creator(
a_name varchar(30),
a_address varchar(300),
a_url varchar(2048),
PRIMARY KEY(a_name,a_address));

create table publisher(
p_name varchar(30) primary key,
p_address varchar(300),
p_phone char(10),
p_url varchar(2048));

create table product(Title varchar(50),
product_id varchar(20) primary key,
price float,
p_year year,
a_name varchar(30),
p_name varchar(30),
genre varchar(50),
product_type varchar(15),
foreign key (a_name) references creator(a_name),
foreign key (p_name) references publisher(p_name));

create table warehouse(
w_code int primary key,
w_address varchar(300),
w_phone char(10));

create table customer(
c_name varchar(50),
c_address varchar(300),
c_email varchar(100) primary key,
c_phone char(10));

drop table stocks;
create table stocks(
pw_id int primary key,
product_id varchar(20),
w_code int,
no_of_copies int,
foreign key (product_id) references product(product_id),
foreign key (w_code) references warehouse(w_code));

create table shopping_basket(
basket_id int primary key,
c_email varchar(300),
product_id varchar(20),
total_amount int,
product_type varchar(15),
foreign key (c_email) references customer(c_email),
foreign key (product_id) references product(product_id));


create table orders(
order_id int primary key,
pw_id int,
c_email varchar(300),
product_id varchar(20),
total_amount int,
product_type varchar(15),
foreign key (c_email) references customer(c_email),
foreign key (product_id) references product(product_id),
foreign key (pw_id) references stocks(pw_id));
