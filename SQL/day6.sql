-- having
-- where과 기능은 같다.
-- 작성위치가 group by 뒤에 작성
-- 그룹화된 결과에 조건을 적용할 떄 사용하는 키워드   

-- where -> 묶기 전에 필터링
-- having -> 묶은 후에 필터링

-- group by를 사용하면 데이터가 다음과 같이 바뀐다.
-- 여러 행 -> 그룹으로 묶임 -> 집계값이 생성

-- where에서는 집계함수를 사용할 수 없다.
-- 평균급여가 5000보다 큰 부서의 정보를 조회하세요 
select department_id, avg(salary)
from employees
-- where avg(salary) > 5000 -- where은 전체 행에 대해서 평균급여를 구함
group by department_id 
having avg(salary)>5000; -- having은 group에 해당되는 대한 평균

-- 급여가 5000 이상인 사원대상 부서별 평균급여 7000이상 부서 조회
select department_id, avg(salary)
from employees
where salary>= 5000
group by department_id
having avg(salary)>=7000;
-- 많이 하는 실수 
-- where 절에 그룹함수 안에 조건 걸기
-- group by 안한 속성을 select에서 사용
-- having 대신에 where 사용

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

-- 부서별 사원 수를 구하고 사원 수가 3명 이상인 부서만 조회 하세요
select department_id, count(*)
from employees
group by DEPARTMENT_ID
having count(*)>=3;

-- 부서별 최고 급여가 10000인 부서
select department_id, max(salary)
from employees
group by department_id
having max(salary)>=10000;

-- 입사년도별 사원중 5명 이상 년도만 출력
select year(hire_date), count(*)
from employees
group by year(HIRE_DATE)
having count(*)>=5;

DROP TABLE IF EXISTS sales;

CREATE TABLE sales (
    id INT AUTO_INCREMENT PRIMARY KEY,
    category VARCHAR(50),
    amount INT,
    sale_date DATE
);

INSERT INTO sales (category, amount, sale_date) VALUES
('식품', 80000, '2025-01-01'),
('식품', 70000, '2025-01-02'),
('식품', 60000, '2025-01-03'),
('전자제품', 250000, '2025-01-01'),
('전자제품', 150000, '2025-01-02'),
('의류', 30000, '2025-01-01'),
('의류', 25000, '2025-01-03'),
('도서', 12000, '2025-01-02'),
('가구', 180000, '2025-01-03'),
('가구', 50000, '2025-01-04'),
('문구', 10000, '2024-12-31'),
('문구', 15000, '2025-01-02');

-- 판매 내역 테이블
select * from sales;

-- 판매가 2번 이상 발생한 카테고리만 조회하기
select category, count(*)
from sales
group by category
having count(*)>=2;

-- 카테고리별 평균 금액이 100,000이상인 것만 조회하기
select category,avg(amount)
from sales
group by category
having avg(amount)> 100000;

-- 2025-01-02 이후 거래만 대상으로 카테고리별 총액이 20,000이상인 것만 조회하기
select category, sum(amount)
from sales
where sale_date >='2025-01-02'
group by category 
having sum(amount)>=20000;

-- 카테고리별 가장 큰 판매금액을 구하되 , 가장 큰 금액이 200,000원 이상인 카테고리만 조회하세요
select category , max(amount)
from sales
group by category
having max(amount)>=200000;

-- 카테코리별 판매 총액을 구한 뒤, 총 판매금액이 50,000이상인 카테고리만 조회하세요
select category , sum(amount)
from sales
group by category
having sum(amount)>=50000;

-- 2025년 1월 1일에 판매된 데이터만 대상으로 하여 카테고리별 판매총액 구하기 
-- 총 판매금액 20000이상 조회
select category , sum(amount)
from sales
where sale_date = '2025-01-01'
group by category
having sum(amount)>=20000;     

-- ROLLUP
-- GROUP BY 가 그룹별로 집계를 해준다면, ROLLUP은 소계와 총계까지 한번에 만드는 기능

-- 아래에서 위로 합계를 말아 올리는 기능
-- 카테고리별 판매금액
select category, sum(amount)
from sales
group by category;

-- ROLLUP을 사용하여 카테고리별 합계와 전체 합계를 같이 조회
select ifnull(category,'전체'), sum(amount)
from sales
group by category with rollup;

INSERT INTO sales (category, amount, sale_date) VALUES
-- 2024 데이터 보강
('식품', 50000, '2024-01-02'),
('식품', 40000, '2024-01-03'),
('전자제품', 120000, '2024-02-01'),
('전자제품', 80000, '2024-02-03'),
('의류', 20000, '2024-03-01'),
('가구', 90000, '2024-03-05'),
-- 2026 데이터 추가
('식품', 90000, '2026-01-01'),
('식품', 70000, '2026-01-02'),
('전자제품', 300000, '2026-01-03'),
('전자제품', 200000, '2026-01-04'),
('의류', 60000, '2026-02-01'),
('도서', 15000, '2026-02-03'),
('가구', 250000, '2026-03-01'),
('가구', 100000, '2026-03-05');

-- 년도별 + 카테고리별 rollup
select year(sale_date),ifnull(category,'전체 카테고리'),sum(amount)
from sales
group by year(sale_date),category with rollup;


-- 년도 + 카테고리별 합계 
-- 년도별 합계 
-- 전체 합계 

-- 월별 + 카테고리 별  총 판매량
select year(sale_date),month(sale_date),category, sum(amount)
from sales
group by year(sale_date),month(sale_date), category with rollup;

-- null 처리 
-- 집계함수는 자동으로 null을 무시
select * from employees e;
select count(e.commission_pct) from employees e; -- 속성을 넣으면 null 값을 제외함 
select count(*) from employees; -- 전체 행 


-- sales 테이블에서 카테고리 개수 세기
-- distinct : 중복되는 값 처리
select count(category)from sales;
select count(distinct category)from sales;

-- IFNULL(컬럼,대체값)
select first_name,salary,ifnull(e.commission_pct,0)
from employees e;

INSERT INTO employees (employee_id, first_name, last_name, email, hire_date, job_id, salary, commission_pct, manager_id, department_id)
VALUES
(201, 'Chris', 'Brown', 'CBROWN', '2025-01-10', 'IT_PROG', NULL, NULL, 103, 60),
(202, 'Emma', 'Stone', 'ESTONE', '2025-02-15', 'FI_ACCOUNT', NULL, NULL, 108, 100),
(203, 'Liam', 'Smith', 'LSMITH', '2025-03-20', 'PU_CLERK', NULL, NULL, 114, 30),
(204, 'Olivia', 'Davis', 'ODAVIS', '2025-04-05', 'IT_PROG', NULL, NULL, 103, 60),
(205, 'Noah', 'Wilson', 'NWILSON', '2025-05-01', 'FI_ACCOUNT', NULL, NULL, 108, 100);

select*from employees where salary is null;

-- 전체 급여평균
select avg(ifnull(salary,0)) from employees;

-- 형변환 함수
-- cast(값 as 변환타입)
-- char :문자열
-- signed : 정수
-- decimal : 소수
-- date : 날짜

-- 사원 테이블에서 사원번호, 사원명, 급여를 조회하되,
-- 급여는 '급여: xxx' 형태로 나오도록 작성하시오

select EMPLOYEE_ID, FIRST_NAME, concat('급여: ',cast(salary as char))
from employees;

-- order by 
-- 쿼리 결과에 반환되는 행들을 특정 기준으로 정령하고자 할 떄 사용
-- order by절은 select절의 가장 마지막에 기술
-- ASC: 오름차순(생략 가능)
-- DESC: 내림차순(생략불가)

-- 사원 테이블에서 급여를 많이 받는 순으로 사번, 이름, 급여를 출력하기
select employee_id, first_name, salary
from employees
where salary is not null
order by salary desc;

-- 정렬은 여러가지 기준으로 가능하다.
-- 급여가 같을 떄 입사순이 늦은 순으로 정렬이 가능
select employee_id, first_name, salary, hire_date
from employees
ORDER BY salary DESC, hire_date DESC;

-- 순위를 구하는 함수
-- 행마다 순위를 붙여주는 함수
-- RANK() OVER(정렬)
select RANK()OVER(order by salary desc),first_name,salary
from employees;
-- 공동 순위 발생
-- 다음순위 건너 뜀 (1,2,2,4);

-- DENSE_RANK()
-- 공동순위는 있지만 건너뛰지는 않음
select 
 DENSE_RANK()Over(order by salary desc),
 first_name, salary    
 from employees;

-- ROW_NUMBER() : 무조건 순서대로 번호
select 
 ROW_NUMBER()Over(order by salary desc),
 first_name, salary
 from employees;


