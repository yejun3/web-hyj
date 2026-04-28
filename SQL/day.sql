-- 꽃 flower
-- 이름 PK varchar(200)
-- ----------------
-- 색깔 varchar(200)
-- 가격 int
-- 
-- 화분 pot
-- 제품번호(PK)
-- ------------------
-- 화분색깔 varchar(100)
-- 모양 varchar(100)
-- 꽃 이름 varchar(200)

create table if not exists FLOWER (
 name varchar(200) primary key,
 color varchar(200),
 price int
);

create table if not exists POT(
productnumber varchar(200) primary key,
color varchar(100),
shape varchar(100),
name varchar(200),
constraint foreign key(name) references FLOWER(name)
);

create table USER( 
user_id varchar(200) primary key,
user_name varchar(200)
);

create table POST(
post_number int primary key,
user_id varchar(200),
title varchar(200),
detail text,
constraint foreign key(user_id) references USER(user_id)
);

create table COMMENT(
comment_number int primary key,
post_number int,
user_id varchar(200),
comment_detail text,
create_time date,
constraint foreign key(user_id) references USER(user_id),
constraint foreign key(post_number) references POST(post_number)
);






