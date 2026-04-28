-- film테이블에서 길이가 60분이상 90분 이하인 영화를 조회
select title, length from film
where length between 60 and 90; 

-- film 테이블에서 등급이 G또는 PG 또는 PG-13인 영화의 제목과 길이, 등급 조회
select * from film;

select title, length, rating
from film
where rating in('G','PG','PG-13');

-- actor 테이블에서 이름이 A로 시작하는 배우의 이름 조회
select*from actor
where first_name like 'A%';

-- film  테이블에서 제목에 LOVE가 포함된 제목을 조회하세요
select title
from film
where title like '%LOVE%';

-- actor 테이블에서 이름이 A로 시작하고 총 3글자인 배우의 이름 조회
select*from actor
where first_name like 'A__';

-- 배우 테이블에서 이름의 두번째 글자가 A인 배우
select first_name
from actor
where first_name like '_A%';

-- 배우 테이블에서 이름이 정확히 4글자인 배우 이름 조회
select first_name
from actor
where first_name like '____';

-- not like 
-- 패턴이 일치 하지 않는 데이터를 조회할 떄 사용
select title
from film
where title not like 'A%';

-- customer 테이블에서 이메일이 .org로 끝나는 고객을 조회하세요
select * from customer
where email like '%.org';

-- film 테이블에서 제목에 dinosaur가 포함되지 않은 영화 제목 조회
select title from film 
where title not like '%dinosaur%';

create table FRUIT(
    ID INT primary key,
    NAME VARCHAR(30),
    PRICE INT
);

- 한 번에 불러내기
insert into fruit (ID, NAME, PRICE)
values (1, '사과', 3000),
       (2, '바나나', 2000),
       (3, '포도', 5000);

select * from fruit;

-- 한건 추가
insert into fruit (ID, NAME, PRICE)
values (4, '복숭아', 6000);

-- SELECT가 된 결과를 추구하는 방법

create table FRUIT_BACKUP(
    ID INT primary key,
    NAME VARCHAR(30),
    PRICE INT
);

insert into fruit_backup (ID, NAME, PRICE)
select ID, NAME, PRICE
from fruit
where price <= 3000;

select*from FRUIT_BACKUP;

-- 일부 컬럼만 출력하기
-- 컬럼이 NOT NULL이면 무조건 써야함
insert into FRUIT(ID)
values (5);

select*from FRUIT;

-- 컬럼명을 생략하는 insert
insert into FRUIT values (6, '딸기', 3900);

insert into FRUIT values (7, '키위', null);

-- Null값을 작젖 넣을 수 있다
insert into FRUIT values (7, '키위', null);

Defalut값 사용하기 
insert into tbl_student (id,name,major,GENDER,birth)

values *from tbl_gender

-- 문자열 데이터를 넣을 떄 작은 따옴표를 사용한다.
-- 날짜 데이터도 직은 따옴표로 넣는다

insert into tbl_student (id, name, major, birth)  -- gender 생략
values (1, '홍길동', '컴퓨터공학과', '2000-09-05');
-- gender는 NOT NULL DEFAULT 'W' 이므로 자동으로 'W'가 들어간다


insert into tbl_student (id,name,major,GENDER,birth)
values (2, '이영희', '산업디자인', 'W', '2020-01-01');

insert into tbl_student (id,name,major,GENDER,birth)
values (3, '김철수', '화학공학', 'M', '1983-12-31');

select * from tbl_student

insert into FLOWER (name,color,price)
values('장미','red',3000);

insert into FLOWER (name,color,price)
values('해바라기','yellow',6000);

insert into FLOWER (name,color,price)
values('튤립','grape',5000);

insert into FLOWER (name,color,price)
values('안개꽃','white',2000);

select*from FLOWER;

-- 화분 테이블 추가
select * from pot;

insert into POT (productnumber, color, shape, name)
values(2026001,'흰색','타원형','장미'); 
-- name은 flower 테이블의 name에 들어있는 값만 사용 가능
insert into POT (productnumber, color, shape, name)
values(2026002,'검은색','사각형','튤립');

update pot
set name = '해바라기'
where name = '튤립';
-- TBL_STUDENT 테이블의 홍길동 이름을 김길동으로 바꿔라

update tbl_student
set name = '김길동'
where id =1; -- 조건을 걸지 않으면 테이블의 모든 속성이 수정 될수 있다.

select * from tbl_student;

-- DEFAULT값으로 바꾸기
update tbl_student
set GENDER = default -- default 값인 w가 들어감
where ID = 3;

-- 여러 조건으로 UPDATE하기
-- AND를 사용하여 조건을 만족하는 행만 수정하기
-- 꽃 테이블에서 색깔이 보라색이고 가격이 5000원인 꽃의 이름을 진달래로 바꾸기

update FLOWER 
set name = '진달래'
where color = 'grape' and price = 5000;

select *from FLOWER;

create table actor_practice as 
select actor_id, first_name, last_name, last_update
from sakila.actor;

select*from actor_practice;

-- 배우번호 1번인 배우의 이름을 james로 수정
update actor_practice
set last_name = 'JAMES'
where actor_id = 1;

-- 배우번호 2번인 배우의 이름을 MINA로, 성을 LEE로 수정
update actor_practice
set last_name = 'LEE',
    first_name= 'MINA'
where actor_id = 2;

-- sakila 데이터 베이스
create table film_practice as 
select*from sakila.film

select*from film_practice;
-- 영화번호가 1번인 영화의 대여가격(rental_rate)을 4.99로 수정
update film_practice
set rental_rate =4.99
where film_id = 1;
-- 배우 테이블에서 이름이 A로 시작하는 배우의 성을 TEST로 바꾸세요
update actor_practice 
set first_name = 'TEXT'
where first_name like 'A%';

-- 영화 테이블에서 등급이 R 또는 NC-17의 영화의 대여기간(rental_duration)을 3으로 수정
update film_practice
set rental_duration = 3
where RATING in ('R','NC-17');

-- 영화 번호가 1인 영화의 대여기간을 1 증가시키기
select title , rental_duration from film_practice
where film_id =1; 

update film_practice
set rental_duration = rental_duration +1
where film_id = 1;

-- 영화 테이블의 대여료(rental_rate)를 10% 인상하세요
update film_practice
set rental_rate = rental_rate*1.1;

select title, rental_rate from film_practice;

-- 배우 테이블에서 id가 1인 배우 삭제
delete from actor_practice 
where actor_id = 1;

 select * from actor_practice;

-- 여러 행을 삭제 
 -- 이름이 john인 배우 모두 삭제
 delete from actor_practice 
 where last_name = 'JOHN';

-- 이름이 A로 시작하는 배우 삭제
delete from actor_practice 
where first_name like 'A%';
 
select * from actor_practice;

-- 데이터만 전부 삭제하기
delete from actor_practice;
select*from actor_practice;

-- flower 테이블의 삭제하기
-- 외래키 컬럼이 데이터를 참조하고 있으면 참조당하는 쪽의 데이터를 
-- 먼저 삭제할 수 없다. 
-- 외래키를 설정할 떄 on delete CASCADE 설정을 주게 되면 같이 삭제됨
 delete from FLOWER 
 where name = '장미';

-- pot테이블에서 장미꽃을 담고있는 화분 데이터 삭제
delete from pot 
where name = '장미';

select*from flower;


create table product(
no int primary key,
name varchar(200),
price int,
p_date date
);

insert into product(no,name,price,p_date)
values (1000,'컴퓨터',100,'2021-04-15'),
       (1002,'냉장고',200,'2021-03-29'),
       (1003,'에어컨',300,'2020-12-15'),
       (1004,'오디오',20,'2020-12-15'),
       (1001,'세탁기',60,'2021-04-15');

select *from product;

update product
set price = price +20
where no=1000;

delete from product
where name = '세탁기';

 -- 사용자 생성하기
create user 'student_user'@'localhost'
   identified by '1234';    

-- 사용자 확인하기
-- MySQL 사용자는 mysql.user 테이블에서 확인할 수 있다.
select user, host from mysql.user;

-- GRANT
-- 사용자에게 권한을 주는 명령어
-- GRANT 권한 ON 데이터베이스명.테이블명 TO'사용자명'@'접속위치';

-- sakila 데이터베이스이 actor 테이블을 조회할 수 있는 권한 주기
grant select 
on sakila.actor
to'student_user'@'localhost';

-- sakila 데이터베이스의 다른 테이블에도 접근할 수 있다.
grant select 
on sakila.*
to'student_user'@'localhost';


-- 모든 권한 부여하기
grant all privileges
on sakila.*
to 'student_user'@'localhost';

-- 권한 확인하기
show grants for 'student_user'@'localhost';

-- REVOKE
-- 사용자에게 부여한 권한을 회수하는 명령어 
-- REVOKE 권한 ON 데이터베이스명.테이블명 FROM '사용자명'@'접속위치'

revoke select 
on sakila.actor
from 'student_user'@'localhost';

-- 모든 권한 회수하기
revoke all privileges
on sakila.*
from 'student_user'@'localhost';
 
-- 자주 쓰이는 권한의 종류
-- select, insert, update, delete : 데이터 관련
-- create, drop, alter 테이블 관련
-- index : 인덱스 생성/삭제관련
-- references : 외래키 관련 권한
-- all privilieges

-- 사용자 삭제
-- drop user '사용자명'@'접속위치';
drop user 'student_user'@'localhost';


create user 'test_user'@'%'
identified by '1234';

grant select, alter
on sakila.*
to'test_user'@'%';

select user, host from mysql.user; 

revoke all privileges 
on sakila.*
from 'test_user'@'%';

drop user 'test_user'@'%';

-- 영화 가격 수정
select TITLE, RENTAL_RATE from film_practice where film_id =1;

start transaction;
-- 임시 상태
update film_practice
set rental_rate = rental_rate +1
where film_id =1;

-- commit을 해서 확정을 한다.
-- rollback을 해서 되돌리기
rollback;

commit; -- commit을 하면 확정을 하기 때문에 rollback을 해도 반영이 안됨
