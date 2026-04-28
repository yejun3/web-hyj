-- actor 테이블에서 모든 정보를 조회
select actor_id, first_name, last_name, last_update
from actor;

-- select * from actor; 테이블의 모든 컬럼 불러오기

-- actor 테이블에서 이름과 성만 조회하기
select first_name, last_name
from actor;

-- film 테이블에서 영화 제목과 대여기간을 조회
select*from film;

select title, rental_duration
from film;

-- film 테이블에서 rental_rate가 2.99이상인 
-- 영화의 제목과 rental_rate를 조회하세요
select title, rental_rate
from film
where rental_rate >= 2.99;

-- film 테이블에서 영화길이가 120분 이상인 영화의 제목과 길이를 조회
-- costomer 테이블에서 active가 1인 고객만 조회

select title, length
from film
where length >= 120;

select * from customer
where active=1; 

-- null, not null 데이터 판별하는 법
-- address 텡비르에서 adress2가 null인 주소를 조회하세요
select*from address
where address2 is null;

select*from address
where address2 is not null;

-- customer 테이블에서 성이 Smith인 고객 조회하기
select*from customer
where last_name = 'Smith';

-- and : 두가지 이상의 조건을 비교
-- film에서 대여료가 2.99이상
-- 영화 길이가 120 이상인 영화를 조회하세요
select *from film
where rental_rate >=2.99 and length >=120;

-- or 
-- film 테이블에서 영화 등급인 PG 이거나 G인 영화를 조회
select*from film
where rating = 'PG' or rating = 'G';

-- film테이블에서 영화 길이가 60분 이하거나 180분 이상인 영화를 조회
select title, length 
from film
where length <=60 or length>=180;

-- payment 테입르에서 2020년 1월 1일 이후에 결제된 내역을 조회하세요
select*from payment;

select *from payment
where payment_date >= '2020-01-01'