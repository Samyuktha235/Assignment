create database FST;
use FST;
drop table Matches;
create table player(p_id int auto_increment PRIMARY KEY,f_name varchar(30),l_name varchar(30),DOB date,Age int,Score int,p_rank int,contact_num varchar(10));
create table matches(match_id int PRIMARY KEY,match_name varchar(20),location varchar(30),start_time datetime,end_time datetime,Star_player varchar(30));
create table team(team_id int,team_name varchar(20),team_score int,team_rank int,no_of_players int);