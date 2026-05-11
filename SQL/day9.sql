-- customer 테이블 (고객정보 저장)
-- customer_id 정수 자동 증가(AUTO_INCREMENT) PK
-- customer_name 문자열(길이 50)
-- city 문자열(길이 30)
-- grade 문자열(길이 20)
create table customer(
 customer_id int auto_increment primary key,
 customer_name varchar(50),
 city varchar(50),
 grade varchar(20)
 );
 
-- product 테이블 (상품정보)
-- product_id 정수 자동증가 pk
-- product_name 문자열 길이(100)
-- category 문자열(길이50)
-- price 정수
-- stock 정수
create table product(
 product_id int auto_increment primary key,
 product_name varchar(100),
 category varchar(100),
 price int,
 stock int
 );

-- orders테이블 (주문내역)
-- order_id 정수 자동 증가 pk
-- customer_id 정수 FK
-- order_date 날짜
-- status 문자열(길이20)
create table orders( 
 order_id int auto_increment primary key,
 customer_id int,
 order_date date,
 status varchar(20),
 constraint a foreign key(customer_id) references customer(customer_id)
 );
 

-- order_item 테이블 (주문에 들어간 상품정보 저장 테이블)
-- order_item_id 정수 자동 증가 pk
-- order_id 정수 fk
-- product_id 정수 fk
-- quantity 정수
create table order_item(
 order_item_id int auto_increment primary key,
 order_id int,
 product_id int, 
 quantity int,
 constraint o foreign key(order_id) references orders(order_id),
 constraint p foreign key(product_id) references product(product_id)
 );

INSERT INTO customer (customer_name, city, grade) VALUES
('김민준', '서울', 'VIP'),
('이서연', '부산', 'GOLD'),
('박지훈', '대구', 'SILVER'),
('최유진', '서울', 'VIP'),
('정하늘', '광주', 'GOLD');

INSERT INTO product (product_name, category, price, stock) VALUES
('기계식 키보드', '전자기기', 120000, 20),
('무선 마우스', '전자기기', 50000, 50),
('모니터 받침대', '가구', 35000, 30),
('사무용 의자', '가구', 200000, 10),
('텀블러', '생활용품', 25000, 100),
('노트북 거치대', '전자기기', 70000, 15);

INSERT INTO orders (customer_id, order_date, status) VALUES
(1, '2026-05-01', '완료'),
(1, '2026-05-03', '완료'),
(2, '2026-05-04', '완료'),
(3, '2026-05-05', '취소'),
(4, '2026-05-06', '완료'),
(5, '2026-05-07', '완료');

INSERT INTO order_item (order_id, product_id, quantity) VALUES
(1, 1, 1),
(1, 2, 2),
(2, 5, 3),
(3, 3, 2),
(3, 6, 1),
(4, 1, 1),
(5, 4, 2),
(6, 5, 5);

-- view 이름 : view 이름 : v_order_detail
-- 조회할 컬럼
-- order_id, customer_name, city, product_name,category, 
-- quantity, price* quantity(별칭 order_amount), order_date,status

create view v_order_detail as
select o.order_id, c.customer_name, c.city, p.product_name, p.category, price*quantity as order_amount, o.order_date, o.status
from orders o
inner join customer c
on o.customer_id = c.customer_id
inner join order_item i
on o.order_id = i.order_id 
inner join product p
on p.product_id = i.product_id;

select*from v_order_detail;

-- v_order_detail view를 사용하여 
-- 주문금액이 100,000원 이상인 데이터만 조회하기
-- 조회컬럼 : 주문자 이름, 제품명, 주문금액
select customer_name, product_name,order_amount
from v_order_detail
where order_amount>= 100000;

-- view 기반 통계 view 생성하기
-- v_order_detail 을 사용하여 고객별 총 구매금액을 저장하는 v_customer_detail
-- view 만들기
-- customer_name, 총 구매금액(total_amont)
-- 취소 주문은 제외한다.

create view v_customer_detail as
select customer_name, sum(order_amount) as total_amount
from v_order_detail
where status != '취소'
group by customer_name;

select *from v_customer_detail;

-- v_customer_detail를 사용하여 총 구매금액이 200000이상인 고객만 조회하는 
-- v_vip_customer 뷰 만들기

create view v_vip_customer as
select *
from v_customer_detail
where total_amount>= 200000;

select*from v_vip_customer;

-- v_customer_detail을 활용하여
-- 구매순위를 조회하세요
-- 이름, 구매가격, 순위
select customer_name, total_amount, rank()over(order by total_amount desc)as ranking
from v_customer_detail;

-- v_order_detail을 사용하여 카테고리별 총 매출 조회하기
-- 카테고리, 총 매출(total_sales)
select category, sum(order_amount) as total_sales
from v_order_detail
where status ='완료'
group by category;

-- v_customer_detail 뷰를 사용하여 전체 평균 구매금액보다 높은 고객만 조회하세요
select *
from v_customer_detail
where total_amount > (select avg(total_amount)from v_customer_detail);

 create view v_order_detail2 as
 select 
       order_id,
       status
 from orders;
 
 create view v_completed_order as 
 select* 
 from v_order_detail2
 where status = '완료';
 
 drop view v_order_detail2;
 
 select*from v_completed_order; -- 에러 발생 -> 참고로 하는 v_order_detail2를 삭제했기 떄문에
   
 -- 혹시나 삭제를 하게 된다면 마지막부터 역순으로 삭제하는 것을 권장
 
-- auto_increment 확인
 select Last_insert_ID();
  -- 마지막에 실행된 insert가 만든 auto_increment 값을 반환한다.
 -- 한번에 데이터를 추가할 때는 그 insert문에서 처음 생성된 첫번째 auto_increment 값을 반환한다.

-- 프로시저 만들기
DELIMITER //
create procedure hello_proc()
begin
	select 'HELLO MYSQL';
end //
delimiter ;
-- 실행: art키 + x

call hello_proc();

-- product 테이블의 전체 내용을 조회하는
-- show_product 프로시저 만들고 호출하여 결과 확인하기
delimiter //
create procedure show_product()
begin
	select * 
	from product;
end//
delimiter ; 

call show_product();

-- 프로시저 삭제
drop procedure hello_proc;

-- 프로시저 목록 확인
show procedure status;

-- 변수 추가하기 
delimiter //
create procedure variable_proc()
begin 
	declare num int;
    set num = 100;
    
    select num;
end//
delimiter ;

call variable_proc;

-- product에서 101에서 101번의 제품 가격을 v_price라는 변수에 넣어서
-- 조회하는 get_product_price() 프로시저 만들기
delimiter //
create procedure get_product_price()
begin
	declare v_price int;
     select price
     into v_price -- 테이블 조회 결과를 변수에 대입
     from roll_up_practice.product
     where product_id = 101;
     select v_price as product_price;
end //
delimiter ;

call get_product_price;

-- delimiter //
-- create procedure get_product_price()
-- begin
-- 	declare v_price int;
--      set v_price = (
--       select price
--      from roll_up_practice.product
--      where product_id = 101;
--      )
--      select v_price as product_price;
-- end //
-- delimiter ; 서브쿼리를 사용해서 set으로 값을 넣는 것도 가능  

delimiter //
create procedure find_product(in p_id int)
begin
	select *
	 from roll_up_practice.product
	 where product_id = p_id;
end //
delimiter ;

call find_product(101);

delimiter //
create procedure GET_STOCK(in P_ID int, out P_STOCK int)
begin
	select stock
	into p_stock
	from product
	where product_id = p_id;
end //
delimiter ;

call GET_STOCK(1, @result_stock);
-- product_id가 1인 재품의 수량을 확인   

select @result_stock;
-- 세션 변수
-- @ 변수명
-- 현재 MYSQL이 연결될동안만 유지되는 변수

-- MySQL의 변수의 종류
-- 지역변수 : 프로시저 내부에서만 사용 가능
-- 세션변수 : 전체 세션에서 사용이 가능하다.

-- inout 변수를 통해서 숫자를 전달받고, 10을 더한 뒤 내보내는 
-- increse_number 프로시저 만들기
delimiter //
create procedure increse_number(inout p_num int)
begin
	set p_num = p_num + 10;
end//
delimiter ;

-- 세션변수는 declare 없이 선언이 가능하다.
set @num = 5;
call increse_number(@num);
select @num;

delimiter //
create procedure check_stock(in p_id int)
begin
	declare v_stock int;
    select stock
    into v_stock
    from product
	where product_id = p_id;
  
    if v_stock >= 10 then
          select '재고가 충분합니다.' as message;
    elseif v_stock = 0 then
          select '품절입니다' as message;
    end if;
end//
delimiter ;

call check_stock(6);

-- save_product 프로시저 만들기
-- procudct_id를 매개변수로 전달하여 조회가 된다면 상품정보를 수정하기
-- 조회가 안된다면 새로운 상품을 추가하기
-- 매개변수는 다음과 같다.
-- p_procduct_id, p_product_name, p_category
-- p_price, p_stock
DELIMITER //
create procedure save_product(
   in p_product_id int,
   in p_product_name varchar(50),
   in p_category varchar(30),
   in p_price int,
   in p_stock int
)
begin
   declare v_count int;

   select count(*)
   into v_count
   from product
   where product_id = p_product_id;
   
   if v_count = 0 then
      insert into PRODUCT(PRODUCT_NAME,CATEGORY,PRICE,STOCK)
      values (P_PRODUCT_NAME, P_CATEGORY, P_PRICE, P_STOCK);
   else
      update PRODUCT
      set PRODUCT_NAME = P_PRODUCT_NAME,
         CATEGORY = P_CATEGORY,
         PRICE = P_PRICE,
         STOCK = P_STOCK
      where product_id = p_product_id;
   end if;
end //
delimiter ;

call save_product(7,'USB 허브','전자기기',30000,40);
call save_product(1,'기계식 키보드','전자기기',150000,50);
call save_product(1,'키보드','전자기기',150000,100);
select * from PRODUCT;

-- delete_product 프로시저 만들기
-- 전달받은 product_id가 있으면 해당 데이터 삭제하기
-- 존재하지 않으면 '데이터가 없습니다'라고 출력하기
delimiter //
create procedure delete_product (in p_product_id int )
begin
   declare v_count int;

   select count(*)
   into v_count
   from product
   where product_id = p_product_id;
   
  	if v_count = 0 then
    select '데이터가 없습니다.' as message;
  	
  	else
    delete from product
  	where product_id = p_product_id;
  end if;
end //
delimiter ;
  	
