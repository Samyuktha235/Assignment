create database sportsleague;
use sportsleague;

create table team(team_id varchar(10) primary key,
team_name varchar(30),
no_of_players int);

create table player(p_id varchar(5) PRIMARY KEY,
f_name varchar(30),
l_name varchar(30),
team_id varchar(10),
DOB date,
Age int,
contact_num varchar(10),
foreign key (team_id) references team(team_id));

create table matches(match_id varchar(20) PRIMARY KEY,
match_name varchar(50),
team_id varchar(10),
location varchar(50),
result varchar(15),
m_date date,
total_score int,
foreign key (team_id) references team(team_id));

create table score_points(
player_id varchar(5),
match_id varchar(20),
team_id varchar(10),
score int,
foreign key (team_id) references team(team_id),
foreign key (player_id) references player(p_id),
foreign key (match_id) references matches(match_id));


