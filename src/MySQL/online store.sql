create database onlinestore;
use onlinestore;

create table author(
a_name varchar(30),
a_address varchar(300),
a_url varchar(2048),
PRIMARY KEY(a_name,a_address));


create table publisher(
p_name varchar(30) primary key,
p_address varchar(300),
p_phone char(10),
p_url varchar(2048));


create table book(Title varchar(50),
ISBN varchar(20) primary key,
price float,
b_year year,
a_name varchar(30),
p_name varchar(30),
foreign key (a_name) references author(a_name),
foreign key (p_name) references publisher(p_name));

create table artist(
artist_name varchar(30) primary key,
artist_address varchar(300),
phone char(10),
url varchar(2048));

create table cassettes(
cassette_id varchar(20)  primary key,
price float,
cassette_year year,
artist_name varchar(30),
genre varchar(50),
foreign key(artist_name) references artist(artist_name));

create table compact_disc(
cd_id varchar(20)  primary key,
price float,
cd_year year,
artist_name varchar(30),
genre varchar(50),
foreign key(artist_name) references artist(artist_name));

create table warehouse(
w_code int primary key,
w_address varchar(300),
w_phone char(10));

create table bookstocks(
ISBN varchar(20),
w_code int,
no_of_copies int,
foreign key (ISBN) references book(ISBN),
foreign key (w_code) references warehouse(w_code),
primary key(ISBN,w_code));

create table cassettestocks(
cassette_id varchar(20),
w_code int,
no_of_copies int,
foreign key (cassette_id) references cassettes(cassette_id),
foreign key (w_code) references warehouse(w_code),
primary key(cassette_id,w_code));

create table cdstocks(
cd_id varchar(20),
w_code int,
no_of_copies int,
foreign key (cd_id) references compact_disc(cd_id),
foreign key (w_code) references warehouse(w_code),
primary key(cd_id,w_code));


create table customer(
c_name varchar(50),
c_address varchar(300),
c_email varchar(100) primary key,
c_phone char(10));


create table shopping_basket(
basket_id int primary key,
c_email varchar(300),
ISBN varchar(20),
cd_id varchar(20),
cassette_id varchar(20),
total_amount int,
foreign key (c_email) references customer(c_email),
foreign key (cassette_id) references cassettes(cassette_id),
foreign key (cd_id) references compact_disc(cd_id),
foreign key (ISBN) references book(ISBN));


