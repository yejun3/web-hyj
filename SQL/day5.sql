-- 숫자 함수

-- ABS()
-- 절대값 구하기
select ABS(-10), ABS(10), ABS(0);

-- round(숫자, 자릿수)
-- 반올림
select ROUND(1234.567,2),
       ROUND(1234.567,0),
       ROUND(1234.567,-1), -- 음수는 정수 부분자리까지 올라옴 결과 1230 
       ROUND(1234.567,-2), -- 결과 1200 
       ROUND(1234.567); -- 0은 생략 가능
       
-- FLOOR()
-- 주어진 숫자보다 작거나 같은 정수중 최대값을 반환
-- 내림이라고 생각해도 됨
       
select 
     floor(2),
     floor(2.1),
     floor(-2.1);
  
-- TRUNCATE()
-- 버림
select TRUNCATE(3.141592,2); -- 결과 3.14 지정한 숫자자리만큼 자름

-- CEIL
-- 주어진 숫자보다 크거나 같은 정수 중 최소값
-- 올림
select  
     CEIL(2),
     CEIL(2.1),
     CEIL(-2.1);

-- SIGN()
-- 인자로 전달된 숫자가 양수 -> 1
-- 음수면 -> -1
-- 0이면 -> 0
-- null -> null
select 
    sign(-10),
    sign(0),
    sign(359);

-- mod()
-- 나누기 했을 떄 나머지를 구한다.
select 
    mod(1,3),
    mod(2,3),
    mod(4,3),
    mod(3,3);
select 4%3;

-- POWER (밑값,지수)
select 
    power(2,1),
    power(2,2),
    power(2,3),
    power(2,0);

-- RAND()
-- 0이상 1미만의 난수를 반환
select 
    RAND();

-- GRATEST() / LEAST()
-- 최댓값, 최솟값을 반환
select
    GREATEST(10,20,5),
    LEAST(10,20,5);

CREATE TABLE sales (
  id INT PRIMARY KEY,
  product VARCHAR(50),
  price DECIMAL(10,2),
  quantity INT,
  discount_rate DECIMAL(5,2)  -- 할인율(예: 0.15 → 15%)
);

INSERT INTO sales VALUES
(1, 'Keyboard', 29900, 2, 0.10),
(2, 'Mouse',    15900, 3, 0.05),
(3, 'Monitor',  199000, 1, 0.20),
(4, 'USB',       8900, 10, 0.00),
(5, 'Speaker',  45500, 4, 0.15);

-- 각 상품의 제품명과 가격을 3으로 나눈 나머지를 조회
select id, product, mod(price,3) from sales;
-- 모든 내용을 조회하되, 할인률은 %로 표시
select id, product, price, quantity, concat(TRUNCATE(discount_rate*100,0),'%') from sales;
-- 세일즈 테이블에서 # 아이디, 제품명, 가격, 재고, 총 가격(소수점 아래 버림)을 조회하세요
select id, product, price, quantity, TRUNCATE(price*quantity - price*quantity*discount_rate,0) from sales;
-- 1_에서 100 난수를 생성하세요
select TRUNCATE(rand()*100+1,0);
select floor(rand()*100+1);
-- 두 함수가 양수일 때는 동일한 결과를 내지만, 음수일 때는 차이가 있다.

-- 상품가격이 50000보다 크면 1 작으면 -1 같으면 0이 되도록 상품이름과 같이 검색
select product, sign(price-50000) from sales;

-- FORMAT(숫자,소수점자리수)
-- 숫자를 사람이 보기 좋게 "문자열 형태로 포맷팅"하는 함수
-- 특히 천 단위 콤마(,) + 소수점 자리수 지정을 자동으로 해준다.

select
    format(1234567,0),
    format(1234567,2);
-- 결과는 숫자가 아니라 문자열로 반환한다.

select
     id,product,format(price,0),quantity,discount_rate
     from sales;

-- 날짜 함수
-- 날짜/시간 데이터를 조회,계산,추출,변환,포맷팅
-- now()
-- 현재 시간과 날짜를 반환한다.
select NOW();

-- curdate() / current_date
-- 현재 날짜만 반환
select CURDATE();

-- curtime / current_time
-- 현재 시간만 반환
select CURTIME();

-- YEAR(날짜)
-- 연도만 추출한다.
select YEAR('2026-04-30');

-- MONTH(날짜)
-- 월만 추출
select MONTH('2026-04-30');

-- DAY(날짜)
-- 일만 추출
select DAY('2026-04-30');

-- HOUR(), MINUTE(), SECOND()
select 
    HOUR('2026-04-30 15:20:10'), -- 문자열 날짜 포멧은 지켜야함
    MINUTE('2026-04-30 15:20:10'),
    SECOND('2026-04-30 15:20:10');

-- 날짜(DATE) 포맷 : YYYY-MM-DD
-- DATETIME 포맷 : YYYY-MM-DD HH:MM:SS

-- 요알 관련 함수 

-- DAYOFWEEK
-- 요일을 숫자로 반환한다.
select DAYOFWEEK('2026.04,30');
-- 1: 일요일
-- 7: 토요일

-- WEEKDAY()
-- 요일을 숫자로 반환
select WEEKDAY('2026.04,30');
-- 0: 월요일
-- 6 : 일요일

-- DAYNAME()
-- 요일 이름을 반환 (영어)
select DAYNAME(curdate()); 

-- LAST_DAY(DAY)
-- 월의 마지막날 구하기
SELECT CURDATE(), LAST_DAY(CURDATE());

-- date_add(날짜, INTERVAL 순자 단위)
-- INTERVAL 단위 : 얼마만큼 단위로 더할 것인가
select
       NOW(),
       DATE_ADD(NOW(),interval 10 day),
       DATE_ADD(NOW(),interval 3 MONTH),
       DATE_ADD(NOW(),interval 2 HOUR);

-- 날짜 간의 차이를 계산
-- DATEDIFF()
-- 두 날짜 사이의 차이를 "일수"로 계산한다.
select DATEDIFF('2026-05-10','2026-04-30'),
       DATEDIFF('2026-04-30','2026-05-10');

-- 날짜 포맷 변경
-- DATE FORMAT()
-- 날짜를 원하는 포맷으로 바꿈

-- 자주 쓰는 포맷기호
-- %Y : 4자리   년도   2026
-- %y : 2자리   연도   26
-- %m : 2자리   월     04
-- %c : 1~2자리 월     4
-- %d : 2자리   일     01
-- %e : 1~2자리 일     1
-- %H : 24시간제 시    15
-- %h : 12시간제 시    03
-- %i : 분
-- %s : 초
-- %W : 요일명        Thursday
-- %a : 짧은 요일명    Thu

select date_format('2026-04-30 15:20:10', '%Y년 %m월 %d시 %H시 %i분');
select date_format('2026-04-30 15:20:10','%W');
-- MAKEDATE(연도, 일수)
select MAKEDATE(2026,32);

CREATE TABLE orders (
    id INT PRIMARY KEY AUTO_INCREMENT,
    customer VARCHAR(50),
    order_date DATE,
    ship_date DATE,
    price INT
   );

INSERT INTO orders (customer, order_date, ship_date, price) VALUES
('홍길동', '2025-01-02', '2025-01-05', 30000),
('이몽룡', '2025-01-10', '2025-01-12', 45000),
('성춘향', '2024-12-28', '2025-01-03', 52000),
('김철수', '2025-02-01', '2025-02-03', 15000),
('박영희', '2025-02-10', NULL, 22000);  -- 아직 배송되지 않음

-- 주문 테이블에서 고객의 이름과 주문날짜 년, 월, 일 을 조회
select customer, YEAR(order_date), MONTH(order_date), DAY(order_date) 
from orders;

-- 배송까지 걸린 시간 일수를 이름과 함께 조회, 배송 안된것은 제외
select customer, DATEDIFF(ship_date,order_date) 
from orders
where order_date is not null and ship_date is not null; 

-- 2025년 1월에 주문된 주문만 조회
select*from orders
where YEAR(order_date)=2025 and MONTH(order_date)=1;
-- 주문 날짜를 기준으로 2024년에 주문된 기록만 조회
select*from orders
where YEAR(order_date)=2024;

-- 주문 날짜를 기준으로 작년에 주문된 기록만 조회
select*from orders
where Year(order_date) = Year(CURDATE())-1;

DROP TABLE IF EXISTS EMPLOYEES;

CREATE TABLE EMPLOYEES (
    EMPLOYEE_ID INT PRIMARY KEY,
    FIRST_NAME VARCHAR(50),
    LAST_NAME VARCHAR(50),
    EMAIL VARCHAR(100),
    HIRE_DATE DATE,
    JOB_ID VARCHAR(20),
    SALARY INT,
    COMMISSION_PCT DECIMAL(3,2),
    MANAGER_ID INT,
    DEPARTMENT_ID INT
);

INSERT INTO EMPLOYEES VALUES
(100, 'Steven', 'King', 'SKING', '2003-06-17', 'AD_PRES', 24000, NULL, NULL, 90),
(101, 'Neena', 'Kochhar', 'NKOCHHAR', '2005-09-21', 'AD_VP', 17000, NULL, 100, 90),
(102, 'Lex', 'De Haan', 'LDEHAAN', '2001-01-13', 'AD_VP', 17000, NULL, 100, 90),
(103, 'Alexander', 'Hunold', 'AHUNOLD', '2006-01-03', 'IT_PROG', 9000, NULL, 102, 60),
(104, 'Bruce', 'Ernst', 'BERNST', '2007-05-21', 'IT_PROG', 6000, NULL, 103, 60),
(105, 'David', 'Austin', 'DAUSTIN', '2005-06-25', 'IT_PROG', 4800, NULL, 103, 60),
(106, 'Valli', 'Pataballa', 'VPATABAL', '2006-02-05', 'IT_PROG', 4800, NULL, 103, 60),
(107, 'Diana', 'Lorentz', 'DLORENTZ', '2007-02-07', 'IT_PROG', 4200, NULL, 103, 60),
(108, 'Nancy', 'Greenberg', 'NGREENBE', '2002-08-17', 'FI_MGR', 12000, NULL, 101, 100),
(109, 'Daniel', 'Faviet', 'DFAVIET', '2002-08-16', 'FI_ACCOUNT', 9000, NULL, 108, 100),
(110, 'John', 'Chen', 'JCHEN', '2005-09-28', 'FI_ACCOUNT', 8200, NULL, 108, 100),
(111, 'Ismael', 'Sciarra', 'ISCIARRA', '2005-09-30', 'FI_ACCOUNT', 7700, NULL, 108, 100),
(112, 'Jose Manuel', 'Urman', 'JMURMAN', '2006-03-07', 'FI_ACCOUNT', 7800, NULL, 108, 100),
(113, 'Luis', 'Popp', 'LPOPP', '2007-12-07', 'FI_ACCOUNT', 6900, NULL, 108, 100),
(114, 'Den', 'Raphaely', 'DRAPHEAL', '2002-12-07', 'PU_MAN', 11000, NULL, 100, 30),
(115, 'Alexander', 'Khoo', 'AKHOO', '2003-05-18', 'PU_CLERK', 3100, NULL, 114, 30),
(116, 'Shelli', 'Baida', 'SBAIDA', '2005-12-24', 'PU_CLERK', 2900, NULL, 114, 30),
(117, 'Sigal', 'Tobias', 'STOBIAS', '2005-07-24', 'PU_CLERK', 2800, NULL, 114, 30),
(118, 'Guy', 'Himuro', 'GHIMURO', '2006-11-15', 'PU_CLERK', 2600, NULL, 114, 30),
(119, 'Karen', 'Colmenares', 'KCOLMENA', '2007-08-10', 'PU_CLERK', 2500, NULL, 114, 30);

select*from employees;
-- 부서번호가 30번인 사원들의 이름을 출력하되, 이름중 'el'을 
-- 모두 '**'로 마스킹 하여 처리하여 출력하세요
select REPLACE(first_name,'el','**') from employees 
where DEPARTMENT_ID = 30;
-- 이름이 6글자 이상인 사원의 사번과 이름, 급여를 조회하기
select EMPLOYEE_ID, FIRST_NAME, SALARY
from employees
where CHAR_LENGTH(first_name) >=6;
-- 사원테이블에서 이름과 사원번호를 출력하되,
-- 사원번호는 짝수면 0, 홀수면 1로 출력하세요
select mod(EMPLOYEE_ID,2),FIRST_NAME
from employees;
-- 사원번호가 짝수인 사람들의 사원번호와 이름 조회하기
select EMPLOYEE_ID,FIRST_NAME
from employees
where mod(EMPLOYEE_ID,2)=0;

-- 사원테이블에서 이름,급여, 1000당 ■로 개수를 채워 조회하기
select first_name,salary,REPEAT('■',round(salary/1000)) 
from employees;

-- 사원테이블에서 이름, 입사날짜, 6개월 뒤 입사날짜 순으로 조회하세요
select first_name, HIRE_DATE, DATE_ADD(HIRE_DATE,interval 6 month)
from employees;

-- 집계함수
-- 여러 행의 값을 하나의 결과값으로 요약해주는 함수

# 학생 점수를 저장한 score 테이블을 먼저 만들고 데이터를 넣는다.
CREATE TABLE score (
  id INT,
  name VARCHAR(30),
  subject VARCHAR(20),
  point INT
);

INSERT INTO score VALUES
(1, '홍길동', '국어', 85),
(2, '김철수', '영어', 90),
(3, '이영희', '수학', 78),
(4, '박민수', '영어', 92),
(5, '최다혜', '국어', NULL);

-- count()
-- 값의 갯수를 반환하는 함수
select count(point) from score; -- null은 카운트하지 않음
select count(name) from score;
select count(*) from score; -- null을 포함한 모든 행의 갯수

-- SUM()
-- NULL을 제외한 총합을 구한다.
select SUM(point) from score;

-- AVG()
-- NULL을 제외하고 평균을 계산한다.
select AVG(point) from score;

-- MAX()
-- 최댓값을 구한다.
select MAX(point) from score;

-- MIN() 
-- 최솟값을 구한다.
select MIN(point) from score;

-- 사원테이블에서 직종이(JOB_ID)가 'IT_PROG'인 사람들의
-- 평균 급여, 급여 최고액, 급여 최저액, 급여의 총 합계를 출력하세요
select avg(salary),max(salary),min(salary),sum(salary)
from employees
where JOB_ID = 'IT_PROG';

-- 사원테이블에서 100번 부서의 사원들의 급여의 평균을 출력하되, 소수점 한자리까지 출력
select FORMAT(avg(salary),1)
from employees
where DEPARTMENT_ID=100;

-- 총 사원수 구하기
select count(*) from employees;

-- 급여가 5000이상 사원 평균급여
select avg(salary) from employees where salary>=5000;
-- 2005에 입사한 사원들의 수
select count(*)from employees where year(HIRE_DATE) = 2005;

-- # 일반적으로 집계함수와 일반속성은 select절에서 
-- # 같이 조회가 불가능하다.

select JOB_ID,count(*)
from employees
group by JOB_ID;
-- GROUP BY로 묶은 속성은 SELECT에서 집계함수와 함께 사용

-- 사원테이블에서 각 직종별 급여 합 조회하기 
select job_id, sum(salary)
from employees
group by job_id;

-- 사원테이블에서 각 직종별 높은 급여 조회하기 
select job_id, max(salary)
from employees
group by job_id;

-- 부서별로 가장 높은 급여 조회하기 
select DEPARTMENT_ID, max(salary)
from employees
group by DEPARTMENT_ID;

-- 그룹별로 구분을 할 때 기준이 꼭 하나일 필요는 없다.
select DEPARTMENT_ID,JOB_ID,count(*)
from employees
-- where 조건 // 필요시 
group by DEPARTMENT_ID,JOB_ID;  

-- 사원테이블에서 입사년도별 사원수를 조회
-- 년도 사원 수 순으로 조회하기
select year(HIRE_DATE),count(*)
from employees
group by year(HIRE_DATE);

-- 부서별 급여가 5000 이상인 사원들의 평균 급여 구하기
select DEPARTMENT_ID,format(avg(salary),0)
from employees
where salary>=5000
group by DEPARTMENT_ID;

-- 부서별 최고 급여와 최저 급여 차이 구하기
select DEPARTMENT_ID, MAX(salary),MIN(salary),FORMAT(MAX(salary)-MIN(salary),0)
from employees
group by DEPARTMENT_ID;

-- 이름에 'a'가 포함된 사원들 대상으로 이름 길이별 사원수를 구하기
select CHAR_LENGTH(FIRST_NAME), count(*)
from employees
where  FIRST_NAME like '%a%'
group by CHAR_LENGTH(FIRST_NAME);

-- 입사일 기준으로 요일별 사원 수 구하기
select DATE_FORMAT(hire_date,'%W'), count(*)
from employees
group by DATE_FORMAT(hire_date,'%W');
