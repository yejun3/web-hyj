DROP TABLE IF EXISTS orders;
DROP TABLE IF EXISTS product;

CREATE TABLE product (
    product_id INT AUTO_INCREMENT PRIMARY KEY,
    product_name VARCHAR(100) NOT NULL,
    category VARCHAR(50) NOT NULL,
    price INT NOT NULL,
    stock INT NOT NULL
);

INSERT INTO product(product_name, category, price, stock) VALUES
('기계식 키보드', '전자기기', 120000, 20),
('무선 마우스', '전자기기', 50000, 50),
('모니터 받침대', '가구', 35000, 30),
('사무용 의자', '가구', 200000, 10),
('텀블러', '생활용품', 25000, 100),
('노트북 거치대', '전자기기', 70000, 15);

CREATE TABLE orders (
    order_id INT AUTO_INCREMENT PRIMARY KEY,
    product_id INT NOT NULL,
    quantity INT NOT NULL,
    total_price INT NOT NULL,
    order_date DATETIME DEFAULT NOW()
);

-- 전체 상품 조회 프로시저 만들기 
-- 이름 : get_all_procedure 
--  product 테이블의 전체 상품을 조회한다.
-- 가격이 높은 순서대로 정렬한다.

delimiter //
create procedure get_all_procedure()
begin
	select*
	from product
	order by price desc;
end//
delimiter ;

call get_all_procedure(); 

-- 상품 ID로 상품 조회하기
-- 이름 : get_product_by_id
-- 상품 id를 전달받아서 해당 상품 정보를 조회하세요
delimiter //
create procedure get_product_by_id(in id int)
begin 
	select*from product
	where product_id = id;
end //
delimiter ;
call get_product_by_id(1);

-- 카테고리별 상품 조회하기
-- 이름 : get_products_by_category
-- 카테고리명을 입력받는다.
-- 해당 카테고리의 상품만 조회한다.
-- 가격이 낮은 순으로 정렬한다.
delimiter //
create procedure get_products_by_category(in p_category varchar(50))
begin 
	select*from product
	where category = p_category
	order by price asc;
end //
delimiter ;
call get_products_by_category('전자기기');

-- 상품 재고를 반환받기
-- 이름 : get_product_stock
-- 상품 ID를 입력받는다.
-- 해당 상품의 재고를 OUT 매개변수로 반환한다.
-- 호출 후 세션 변수로 결과를 확인한다.
delimiter //
create procedure get_product_stock(in p_id int, out p_stock int)
begin 
	select stock
	into p_stock
	from product
	where product_id = p_id;
end //
delimiter ;
call get_product_stock(3,@result_stock);
select @result_stock as stock;

-- 상품 추가 시저 프로시저 만들기
-- 이름 : insert_product
-- 상품명, 카테고리, 가격, 재고를 입력받아서 product 테이블에 상품을 추가한다.
-- 추가 후 전체 상품 목록을 조회한다.
delimiter //
create procedure insert_product(
   in p_product_name varchar(50),
   in p_category varchar(50),
   in p_price int,
   in p_stock int
  )
 begin
 	insert into product(product_name, category, price, stock)
 	values (p_product_name, p_category, p_price, p_stock);
    select*from product;
 end //
delimiter ;

call insert_product ('노트북', '전자기기',500000, 3);
 

-- 상품 가격 수정하기
-- 이름 : update_product_price
-- 상품 ID와 변경할 가격을 입력받는다.
-- 해당 상품의 가격을 입력받는다.
-- 해당 상품의 가격을 수정한다.
-- 수정된 행이 있으면 "가격이 수정되었습니다." 출력
-- 수정된 행이 없으면 "해당 상품이 없습니다." 출력
-- row_count() : 변경된 행의 갯수 반환 

delimiter //
create procedure update_product_price(in p_product_id int, in p_price int)
begin 
	update product
	set price = p_price
    where product_id = p_product_id;

if row_count() > 0 then
select '가격이 수정되었습니다.' as message;

else
select '해당 상품이 없습니다.' as message;

end if;

end //
delimiter ;

call update_product_price (1,130000);
call update_product_price (999,130000);
-- row_count() : 수정된 행의 갯수를 반환하는 함수, 직전의 실행한 sql문이 몇개의 행에 영향을 주었는지 반환  

-- -----------------------------------------------------------------------------------------------
-- 상품이 있으면 수정하고 없으면 추가하기
-- 이름 : upsert_product
-- 상품 id, 상품명, 카테고리, 가격, 재고를 입력받는다.
-- 입력받는 상품 id가 product테이블에 존재하면 상품정보를 수정한다.
-- 존재하지 않으면 새로운 상품을 추가한다.
-- 처리결과 메세지를 출력한다.
delimiter //
create procedure upsert_product(
    in p_product_id int, 
    in p_product_name varchar(50),
    in p_category varchar(50),
    in p_price int,
    in p_stock int
  )
 begin
	 -- 조회된 개수를 담는 변수
	declare check_id int;
    -- id를 가지고  데이터가 있는지 갯수를 센다.
    select count(*)
    into check_id
    from product
    where product_id = p_product_id;

    -- check_id > 0 : 조회된 행이 있다. -> product가 있으니 수정해라
	if check_id > 0 then
 	update product
 	set product_name = p_product_name,
 	    category = p_category,
 	    price = p_price,
 	    stock = p_stock
 	where product_id = p_product_id;
    
    select '수정되었습니다.' as message;
 	select * from product;
    
    else
 	insert into product(product_name, category, price, stock)
 	values (p_product_name, p_category, p_price, p_stock);
    
    select '추가되었습니다.' as message;
    select * from product;
    
    end if;
 
 end //
delimiter ;
drop procedure upsert_product;
call upsert_product(1,'고급 기계식 키보드', '전자기기', 150000, 10);
call upsert_product(100,'고급 키보드', '전자기기', 150000, 10);

-- 상품 id가 있으면 삭제하고 없으면 없다 메시지 출력하기
-- 이름 : delete_product_if_exists
-- 상품 id를 입력받고 해당 상품 id가 있으면 삭제한다.
-- 해당 상품 id가 없으면 "데이터가 없습니다."를 출력한다.
-- 삭제 성공 시 "삭제되었습니다."를 출력한다.
delimiter //
create procedure delete_product_if_exists(in p_product_id int)
 begin
	declare check_id int;
    select count(*)
    into check_id
    from product
    where product_id = p_product_id;
	 
	if check_id > 0  then
 	delete from product
 	where product_id = p_product_id;
    select '데이터가 삭제되었습니다.' as message;
 	select * from product;
	
    else
    select'데이터가 없습니다.' as message;
    
    end if;
 
 end //
delimiter ;

drop procedure delete_product_if_exists;
call delete_product_if_exists(8);
call delete_product_if_exists(100);

-- 주문 처리 프로시저 만들기
-- 이름 : order_product
-- 상품 ID와 주문 수량을 입력받는다.
-- 상품이 존재하지 않으면 "상품이 존재하지 않습니다." 출력하기
-- 재고가 부족하면 "재고가 부족합니다" 출력하기
-- 재고가 충분하면 orders 테이블에 주문을 추가한다.
-- 주문 후 product테이블의 재고를 차감한다.
-- 주문 성공 시 "주문이 완료되었습니다."를 출력한다.
delimiter //
create procedure order_product(in p_product_id int, in p_quantity int)
begin
    declare check_id int;
    declare check_store int;
    declare check_price int;

    select count(*)
    into check_id
    from product
    where product_id = p_product_id;

    if check_id = 0 then
        select '상품이 존재하지 않습니다.' as message;

    else
        select stock, price
        into check_store, check_price
        from product
        where product_id = p_product_id;

        if check_store >= p_quantity then
            insert into orders(product_id, quantity, total_price)
            values (p_product_id, p_quantity, check_price * p_quantity);

            update product
            set stock = stock - p_quantity
            where product_id = p_product_id;

            select '주문이 완료되었습니다.' as message;

        else

            select '재고가 부족합니다.' as message;

        end if;

    end if;

end //
delimiter ;

drop procedure order_product;
call order_product(1,2);
call order_product(1,3);
select*from product;
select*from orders;

-- 가격 등급 조회 프로시저
-- 이름 : get_price_grade
-- 상품 id를 입력받는다.
-- 가격이 100,000원 이상이면 "고가 상품"이라고 출력하기
-- 50,000원 이상 100,000 미만이면 "중간 가격 상품"을 출력하기
-- 상품 가격이 50,000원 미만이면 "저가 상품" 출력하기
-- 상품이 없으면 "상품이 없습니다." 출력하기

delimiter //
create procedure get_price_grade(in p_product_id int)
 begin
	 declare check_id int;
	 declare check_price int; 
    select count(*)
    into check_id
    from product
    where product_id = p_product_id;
	
    select price 
	into check_price
	from product 
	where product_id = p_product_id; 
	 
    if check_id = 0 then
    select'상품이 없습니다.' as message;
    
	elseif check_price >= 100000 then
    select '고가 상품' as message;
 	
	elseif check_price >= 50000 then
	select'중간 가격 상품' as message;
	
    else
    select '저가상품' as message;
    
    end if;
 
 end //
delimiter ;

-- 기본 문법 
-- case 
--      when 조건식 1 then 결과 1
--      when 조건식 2 then 결과 2
--      when 조건식 3 then 결과 3
--      else 기본결과
-- end

-- product 테이블에서 상품명, 재고,
-- 재고가 50개 이상이면 '재고많음', 10개이상이면 '재고 보통,' 그 미만은 '재고부족'

select 
     product_name,
     stock,
     case
     	when stock >= 50 then '재고많음'
     	when stock >= 10 then '재고보통'
     	else '재고부족'
     end as stock_status
   from product;

-- when 은 조건
-- then은 조건이 참일 떄 반환할 값
-- else는 어떠한 조건도 만족하지 않을 때 반환할 값
-- end문은 case문의 끝을 의미한다.
-- case문은 위에서 아래로 조건을 검사한다.
-- 범위 조건은 큰 조건부터 작은 조건 순서대로 작성해야 한다.

-- 특정 컬럼의 값이 무엇인지 비교할 떄 사용할 수 있다.
select
    product_name,
    category,
    case category -- 특정 값을 비교할 떄는 column명을 써줘야 한다.
        when '전자기기' then '전자제품 코너'
        when '가구' then '가구 코너'
        when '생활용품' then '생활용품 코너'
        else '기타코너'
   end as display_area
 from product;
-- case문은 select절에서 사용되며 실제 테이블에 없는 가상의 결과 컬럼을 만들 수있다.

-- case문은 order by에서도 사용할 수 있다.
select 
    product_name,
    stock
 from product
 order by
      case
      	 when stock <10 then 1
      	 when stock <30 then 2
      	 else 3 
      end,
      stock;

-- update문에서도 사용할 수 있다.
alter table product add status varchar(20);

update product 
set status = 
 case  
 	when stock <= 10 then '재고부족'
 	else '판매중'
 end;
select*from product;
 
-- group by와 집계에도 자주 사용된다.
-- 상품이 가격대별로 몇개씩 있는지 조회하기
select 
   case  
   	  when price >= 100000 then '고가'
   	  when price >= 50000 then '중가'
   	  else '저가'
   end as price_level, count(*) as product_count
   from product
   group by 
      case  
   	  when price >= 100000 then '고가'
   	  when price >= 50000 then '중가'
   	  else '저가'
   	 end;   

-- sum과 case를 같이 사용하면 조견별 집계가 가능하다.
-- 조건별 개수를 직접 계산한다. 
-- 보통 한줄로 갯수를 보고싶을떄
select
    sum(case when category = '전자기기'  then 1 else 0 end) as electronics_count,
    sum(case when category = '가구' then 1 else 0 end) as furniture_count,
    sum(case when category = '생활용품' then 1 else 0 end) as life_count
 from product;

-- 카테고리별 그룹을 만든다.
select 
    category, count(*)
    from product
group by category;

-- ----------------------------------------------------------------- 
CREATE TABLE student_score (
    student_id INT PRIMARY KEY,
    student_name VARCHAR(30),
    subject VARCHAR(30),
    score INT,
    attendance_rate INT
); 

INSERT INTO student_score VALUES
(1, '김철수', 'Java', 95, 98),
(2, '이영희', 'Java', 82, 90),
(3, '박민수', 'Java', 67, 75),
(4, '최유리', 'Database', 88, 92),
(5, '정하늘', 'Database', 73, 80),
(6, '한지민', 'Database', 55, 60),
(7, '강민호', 'Python', 100, 100),
(8, '윤서연', 'Python', 45, 50);

-- 점수등급 출력하기 
-- 90점 이상 a, 80점이상 b, 70점 이상 c, 60점 이상 d, 그 외 f
-- 출력컬럼 student_name, score, grade

select 
   student_name,score,
   case 
   	when score >= 90 then 'A'
   	when score >= 80 then 'B' 
   	when score >= 70 then 'C' 
   	when score >= 60 then 'D' 
   	else 'F'
   end as grade
 from student_score;
   
 -- 출석 상태 출력하기 
-- 95 이상 우수, 80이상 보통, 그외 위험
-- 출력컬럼 : 이름 출석률 출석상태
select 
   student_name, attendance_rate,
   case 
   	when attendance_rate >= 95 then '우수'
   	when attendance_rate >= 80 then '보통' 
   	else '위험'
   end as attendance_status
 from student_score;
 
 -- 과목별 난이도 표시하기
 -- java -> 중급
 -- database -> 어려움
 -- python -> 쉬움
 -- 출력컬럼: subject, difficulty
 select 
    subject,
   case subject
   	when 'java' then '중급'
   	when 'database' then '어려움'
   	when 'python' then '쉬움' 
   end as difficulty
 from student_score;
 
 -- 장학생 여부 툴력 
 -- 점수 >= 90이고 출석률 >= 90
 -- 둘다 만족하면 '장학생'
 -- 아니면 '일반학생'
 -- 출력컬럼 : 이름, 점수, 출석률, 장학생여부
select 
   student_name,score,attendance_rate,
   case 
   	when score >= 90 and attendance_rate >= 90 then '장학생' 
   	else '일반학생'
   end as scholaship
 from student_score;
 
 -- grade 컬럼을 추가한 후 다음 기준으로 값을 update 하기
 -- 90점 이상 a, 80점이상 b, 70점 이상 c, 60점 이상 d, 그 외 f
 
alter table student_score add column grade varchar(50);
update student_score
set grade =    
   case 
   	when score >= 90 then 'A'
   	when score >= 80 then 'B' 
   	when score >= 70 then 'C' 
   	when score >= 60 then 'D' 
   	else 'F'
  end;
select*from student_score;   

-- ---------------------------------------------------------------
-- while문의 기본문법
-- whlie 조건 do
-- 실행문;
-- END WHILE;

create table LOOP_TEST(num int);

delimiter //
create procedure while_example()
 begin
 	declare v_num int default 1;
    
    while v_num <= 5 do 
        insert into loop_test values(v_num);
        set v_num = v_num +1;
    end while;
 end //
delimiter ;

 call while_example();
 
 select *from loop_test;
-- -------------------------------------------------
--  reapeat 
--  무조건 한 번 실행 후 조건 검사
--  reapeat
--  실행문;
--  until 조건
-- end repeat;
delimiter //
drop procedure if exists repeat_example//

create procedure repeat_example()
begin
    declare v_num int default 6;

    repeat
        insert into loop_test(num)
        values(v_num);

        set v_num = v_num + 1;

    until v_num > 10
    end repeat;

end//
delimiter ;

call repeat_example();

select * from loop_test;
-- ---------------------------------------------------
 -- loop 
 -- 무한 반복 기반 
 -- 직접 종료 조건을 만들어야 한다.
 -- label : LOOP
 -- 실행문;
 -- IF 조건 THEN LEAVE label
 -- END IF;
 -- END LOOF;
delimiter //
create procedure loop_example()
begin 
    declare v_num int default 11;

    my_loop: loop

        insert into loop_test(num)
        values(v_num);

        set v_num = v_num + 1;

        if v_num > 16 then
            leave my_loop;
        end if;

    end loop;

end //
delimiter ;
 
call loop_example();

select *from loop_test;
-- ---------------------------------------------------------------

-- while문을 이용하여 1~20 까지의 수 중 짝수만 저장하세요
delimiter //
create procedure even_numbers()
begin
    declare v_num int default 1;
    
  while v_num <= 20 do
        if mod(v_num, 2) = 0 then
            insert into loop_test(num) values(v_num);
       
        end if;

        set v_num = v_num + 1;

    end while;

end //
delimiter ;
delete from loop_test;
call even_numbers();
select*from loop_test;

-- repeat문을 사용하여 1부터 10까지의 총 합 구하기
delimiter //
create procedure sum_repeat()
begin
	declare v_num int default 1;
	declare v_sum int default 0;

	repeat
		set v_sum = v_sum + v_num;
		set v_num = v_num + 1;
	until v_num > 10
	
	end repeat;
	
	select v_sum;
end //
delimiter ;

call sum_repeat();