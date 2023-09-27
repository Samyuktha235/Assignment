create database FST;
use FST;
-- drop table player;
create table player(p_id varchar(5) PRIMARY KEY,
f_name varchar(30),
l_name varchar(30),
DOB date,
Age int,
contact_num varchar(10));

create table matches(match_id int PRIMARY KEY,
match_name varchar(50),
location varchar(50),
result varchar(15),
m_date date,
total_score int);


create table team(team_id int primary key,
team_name varchar(30),
no_of_players int);

create table score_points(
player_id varchar(5),
match_id int,
score int,
foreign key(player_id) references player(p_id),
foreign key(match_id) references matches(match_id));