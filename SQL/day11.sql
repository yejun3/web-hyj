-- 프로시저 이름 : even_sum
-- 입력받은 두 숫자 사이의 짝수만 더하여 결과 출력하기
-- 시작값과 끝 값은 in  매개변수로 받는다
-- while 사용
-- 짝수만 누적
-- 결과 select로 출력
delimiter //
create procedure even_sum(in num_start int, in num_end int)
begin
	declare i int;  -- 조건에 사용할 변수
	declare total int default 0;

    set i = num_start;
    
    while i <= num_end do 
        if mod(i,2) = 0 then
         set total = total + i ;
        end if;
         set i = i + 1;
    end while;
   select total;
end //
delimiter ;

call even_sum(10,100);
#--------------------------------------------------------------
-- 회원등급 자동 변경
CREATE TABLE customer (
    customer_id INT PRIMARY KEY,
    customer_name VARCHAR(50),
    total_amount INT,
    grade VARCHAR(20)
);
INSERT INTO customer VALUES
(1, '김철수', 120000, NULL),
(2, '이영희', 80000, NULL),
(3, '박민수', 300000, NULL);

-- 모든 회원을 반복 조회하면서 등급 갱신하기
-- 조건
-- 구매금액      등급
-- 20만원 이상      VIP
-- 10만원 이상      GOLD
-- 나머지         SILVER

DELIMITER //
CREATE PROCEDURE update_customer_grade()
BEGIN
   DECLARE v_id INT DEFAULT 1;
   DECLARE v_max_id INT;
   DECLARE v_amount INT;

   -- 최대 고객번호
   SELECT MAX(customer_id)
   INTO v_max_id
   FROM customer;

   WHILE v_id <= v_max_id DO

      -- 고객별 구매금액
      SELECT total_amount
      INTO v_amount
      FROM customer
      WHERE customer_id = v_id;

      IF v_amount IS NOT NULL THEN

         UPDATE customer
         SET grade =
            CASE
               WHEN v_amount >= 200000 THEN 'VIP'
               WHEN v_amount >= 100000 THEN 'GOLD'
               ELSE 'SILVER'
            END
         WHERE customer_id = v_id;

      END IF;

      SET v_id = v_id + 1;

   END WHILE;

END //
DELIMITER ;

call update_customer_grade();
select*from customer;

-- 새로운 회원을 추가 
-- 4, 최민준, 250,000, null
insert into customer(customer_id,customer_name,total_amount,grade)
values(4,'최민준', 250000, null);
-- 새 회원의 등급을 정해주세요
call update_customer_grade;
select*from customer;
#-------------------------------------------------------------------

-- 주문 금액 누적 시 배송시 계산
CREATE TABLE cart (
    cart_id INT PRIMARY KEY,
    product_name VARCHAR(50),
    price INT
);
INSERT INTO cart VALUES
(1, '마우스', 30000),
(2, '키보드', 50000),
(3, '모니터', 200000);

-- 장바구니 금액을 누적하면서 배송비를 계산하시오
-- 누적금액 100,000원 이상 → 배송비 0원
-- 미만 → 배송비 3000원
-- 상품을 하나씩 읽으며 누적
-- SELECT를 이용하여 조회하기

delimiter //
create procedure calcaulte_cart_total()
begin
   declare v_id int default 1; -- 시작값
   declare v_max_id int; -- 종료값
   declare v_price int; -- 가격을 담을 변수
   declare v_total int default 0; -- 총합을 담을 변수
   declare v_delivery_fee int; -- 배송비를 담을 변수
   
   -- 가장 마지막 id찾기
   select max(cart_id)
   into v_max_id
   from cart;
   
   while v_id <= v_max_id do
      select price
      into v_price
      from cart
      where cart_id = v_id;
   
      -- 가격이 null이 아니라면
      if v_price is not null then
         -- v_total에 누적
         set v_total = v_total + v_price;
      
         if v_total >= 100000 then
            set v_delivery_fee = 0;
         else
            set v_delivery_fee = 3000;
         end if;
         
         select 
            v_total as current_total,
            v_delivery_fee as delivery_fee;
      end if;
         
      set v_id = v_id + 1;
   end while;
end //
delimiter ;

call calcaulte_cart_total();

create table member(
 member_id int primary key ,
 member_name varchar(50) not null 
);

delimiter //
create procedure INSERT_MEMBER()
begin
	declare continue handler for 1062
	begin
		select '이미 존재하는 회원 id입니다.' as message;
    end;
    
    insert into member(member_id, member_name)
    values(1,'홍길동');
    
    -- pk값이 중복됨
    insert into member(member_id, member_name)
    values(1,'김철수')
    
    select '프로시저가 끝까지 실행되었습니다.'as message;	
end //
delimiter ;
 
call INSERT_MEMBER;
-- 두번쨰 insert에서 기본키 중복에러가 발생하지만 continue handler를
-- 처리했기 때문에 프로시저가 끝까지 실행된다.

delimiter //
create procedure INSERT_MEMBER_EXIT()
begin
	declare continue handler for 1062
	begin
		select '중복오류가 발생하여 프로시저를 종료합니다.' as message;
    end;
    
    insert into member(member_id, member_name)
    values(1,'홍길동');
    
    -- pk값이 중복됨
    insert into member(member_id, member_name)
    values(1,'김철수')
    
    select '이 문장은 실행되지 않습니다.'as message;	
end //
delimiter ;

call INSERT_MEMBER_EXIT();

-- select into 결과가 없을 떄 처리하기
-- select ... into는 조회 결과를 변수에 넣을때 사용한다.
-- 조회 결과가 없으면 not found 상황이 발생할 수 있다.

-- 프로시저명 : find_product
-- 매개변수 : in p_id int
-- id를 통해 상품의 이름과 가격을 조회
-- 조회되는게 없으면 '해당 상품이 없습니다.'라고 조회하기
delimiter //
create procedure find_product(in p_id int)
begin
	declare v_product_name varchar(50);
    declare v_price int;

	declare continue handler for not found
   begin
   	select '해당 상품이 없습니다.'as message;	
   end;
   
   select product_name,price
   into v_product_name, v_price
   from product
   where product_id = p_id;
   
   select v_product_name as product_name , v_price as price;
end // 
delimiter ;

call find_product(2);
call find_product(100); 
#--------------------------------------------------------------
delimiter //
CREATE PROCEDURE find_product_safe(IN p_id INT)
BEGIN
    DECLARE v_product_name VARCHAR(50);
    DECLARE v_price INT;
    DECLARE v_not_found BOOLEAN DEFAULT FALSE;

    -- NOT FOUND 발생 시 플래그 변경
    DECLARE CONTINUE HANDLER FOR NOT FOUND
    SET v_not_found = TRUE;

    -- 데이터 조회
    SELECT product_name, price
    INTO v_product_name, v_price
    FROM product
    WHERE product_id = p_id;

    -- 결과 판단
    IF v_not_found THEN
        SELECT '해당 상품이 없습니다.' AS message;
    ELSE
        SELECT v_product_name AS product_name,
               v_price AS price;
    END IF;

END //
delimiter ;

call find_product_safe(100);

-- SQLEXCEPTION으로 전체 SQL 오류 처리하기
-- 다양한 예외를 처리할 수 있다는 장점이 있으나 어떤 예외가 
-- 발생했는지 알기 어렵다.
delimiter //
create procedure add_product(
 in p_id int, 
 in p_name varchar(50),
 in p_category varchar(50),
 in p_price int,
 in p_stock int,
 in p_status varchar(50)
 )
 begin
 	declare exit handler for sqlexception
 	begin
 		select '상품등록 중 오류가 발생하였습니다.' as message;
 	end;
   
    insert into product(product_id,product_name,category,price,stock,status)
    values(p_id, p_name, p_category, p_price, p_stock,p_status);
    
    select '상품 등록 성공' as message;
  
 end //
delimiter ;
 
drop procedure add_product;
 
 call add_product(9,'노트북거치대','전자기기',70000,15,'판매중');
 
 -- signal
 -- 강제로 예외를 발생시키는 기능
 -- pk중복, not null 위반, foreign key 위반같은 상황에서는 자동으로 
 -- 예외가 발생한다.
 -- 재고가 부족하면 주문 금지, 나이가 0보다 작으면 저장금지, 
 -- 이미 탈퇴한 회원은 주문금지 같은 비즈니스 로직도 검사를 해야한다.
 
 -- 기본문법
 -- signal sqlstate '오류번호'
 -- set message_text = '오류 메세지'
 
DELIMITER //

create procedure ORDER_PRODUCT2(
   in P_ID INT, -- 제품아이디
   in P_ORDER_COUNT INT -- 주문 개수
)
begin
   declare V_STOCK INT;

--    declare exit HANDLER for sqlexception
--    begin
--       select '주문 처리 중 오류가 발생했습니다.' as MESSAGE;
--    end;
   
   -- 프로시저를 호출 할 때 전달한 제품ID를 통해서 STOCK을 조회하여
   -- V_STOCK에 대입하기
   select STOCK
   into V_STOCK
   from product p 
   where p.product_id = P_ID;
   
   -- 주문량보다 재고가 부족할 때 강제로 예외 발생시키기
   if P_ORDER_COUNT > V_STOCK then
      signal sqlstate '45000'
      set MESSAGE_TEXT = '재고가 부족합니다.';
   end if;
   
   update product p 
   set STOCK = STOCK - P_ORDER_COUNT
   where PRODUCT_ID = P_ID;

   select '주문 완료' as MESSAGE;
end //
DELIMITER ;

call ORDER_PRODUCT2(1,300);

#---------------------------------------------
CREATE TABLE user_account (
    user_id VARCHAR(30) PRIMARY KEY,
    user_name VARCHAR(50) NOT NULL,
    email VARCHAR(100) UNIQUE
);

-- 회원 추가 프로시저 작성하기 
-- 프로시저 이름 : add_user_handler
-- 아이디, 이름, 이메일을 입력받는다.
-- 정상 등록되면 '회원가입 성공'을 출력한다.
-- 아이디 또는 이메일이 중복되면 '아이디 또는 이메일이 중복되었습니다.' 출력한다

DELIMITER //

CREATE PROCEDURE add_user_handler(
    IN p_id INT,
    IN p_name VARCHAR(50),
    IN p_email VARCHAR(100)
)
BEGIN

    -- SQL 에러 발생 시 처리 (중복키 등)
    DECLARE EXIT HANDLER FOR SQLEXCEPTION
    BEGIN
        SELECT '아이디 또는 이메일이 중복되었습니다.' AS message;
    END;

    -- 회원 등록
    INSERT INTO user (user_id, user_name, email)
    VALUES (p_id, p_name, p_email);

    -- 정상 처리 메시지
    SELECT '회원가입 성공' AS message;

END //

DELIMITER 
;
# ------------------------------------------------------------
-- 도서 대여 처리 프로시저
CREATE TABLE book (
    book_id INT PRIMARY KEY,
    title VARCHAR(100),
    author VARCHAR(50),
    stock INT
);

CREATE TABLE book_rental (
    rental_id INT AUTO_INCREMENT PRIMARY KEY,
    book_id INT,
    rental_count INT,
    rental_date DATETIME DEFAULT NOW()
);

INSERT INTO book VALUES
(1, '혼자 공부하는 SQL', '우재남', 3),
(2, '이것이 자바다', '신용권', 5),
(3, '스프링 부트 입문', '김개발', 1),
(4, '리액트 시작하기', '이프론트', 0);

-- 문제
-- 도서 id와 대여 권수를 입력받아 도서를 대여하는 프로시저 rental_book 만들기
-- 요구사항
-- 도서 id와 대여 권수를 입력받는다.
-- 도서가 존재하지 않으면 '존재하지 않는 도서입니다.' 출력
-- 대여 권수가 0이하면 '대여 권수는 1권 이상이어야 합니다.' 출력
-- 재고가 부족하면 '대여 가능한 재고가 부족합니다.' 출력
-- 정상 대여면 반복문을 사용하여 대여 권수만큼 'x 권 대여 처리중 ...' 이라고 출력
-- 정상 대여 후 book 테이블의 재고를 차감한다.
-- book_rental 테이블에 대여 내역을 추가한다.
-- 예외처리는 handler를 사용한다.
delimiter //
create procedure rental_book(
    in p_book_id int,
    in p_rental_count int
)
begin
    declare v_title varchar(100);
    declare v_stock int;
    declare v_not_found boolean  default false;
    declare i int default 1;

    -- signal을 이용한  예외 처리
    declare continue handler for not found
    begin
        set v_not_found = true; 
    end;
    
    declare exit handler for sqlexception 
    begin
    select '대여 처리 중 오류가 발생했습니다.' as message;
    end;

    -- book 테이블에서 입력받은 도서 id에 해당하는 제목과 재고 조회
    select title, stock
    into v_title, v_stock
    from book
    where book_id = p_book_id;

    -- 도서가 존재하지 않는 경우
    if v_not_found then 
        select '존재하지 않는 도서입니다.' as message;
    -- 대여 권수가 0권 이하인 경우
    elseif p_rental_count <= 0 then
       select '대여 권수는 1권 이상이어야 합니다.' as message;
    -- 대여 권수가 재고보다 많은 경우
    elseif p_rental_count > v_stock then
       select '대여 가능한 재고가 부족합니다.' as message;
    -- 도서가 존재하고, 대여 권수도 정상이며, 재고도 충분한 경우
    else 
      -- 대여 권수만큼 반복하면서 처리 과정 출력하기
      while i <= p_rental_count do
          select concat(i,'권 대여 처리중 ...') as process;
          set i = i +1;
      end while;

      -- book 테이블의 재고를 대여 권수만큼 차감
      update book
      set stock = stock - p_rental_count
      where book_id = p_book_id;

      -- book_rental 테이블에 대여 기록을 저장
        insert into book_rental(book_id, rental_count)
        values(p_book_id, p_rental_count);

        -- 최종 성공 메시지 출력
        select concat(v_title, '도서대여가 완료되었습니다.') as message;
    end  if;

end //
delimiter ;

call rental_book(1,3);
call rental_book(88,2);
call rental_book(1,0);
select *from book;

-- cusor 
-- select 결과를 한 줄씩 꺼내서 처리하는 기능
select * from product;   -- 결과를 한 번에 보여준다.
-- 커서를 사용하는 이유
-- 모든 상품을 하나씩 확인하면서 처리하고 싶다.
-- case, update를 사용해서 한 번에 처리할 수도 있지만 행마다 복잡한 로직을 실행해야 한다면
-- cursor를 사용한는 것이 유용하다.
-- 상품 한 행을 조회 -> 재고 상태 판단 -> 다른 테이블에 기록 -> 조건에 따라 추가 작업

-- 커서의 기본 구조 
-- declare 커서이름 cursor for 
-- select 컬럼 from 테이블명
-- open 커서이름; -> select  실행 결과를 커서에 준비
-- fetch 커서이름 into 변수1, 변수2; -> 결과에서 한 행을 꺼내 변수에 저장
-- close 커서 이름; -> 커서 사용 종료

-- 1. 변수 선언
-- 2. 커서 선언
-- 3. NOT FOUND 처리 선언
-- 4. 커서 열기
-- 5. LOOP 반복
--    → FETCH 한 줄 읽기
--    → 출력
-- 6. 데이터 끝나면 LOOP 종료
-- 7. 커서 닫기

-- 커서도 프로시저 안에서 사용을 해야한다.
delimiter //
create procedure print_book_stock()
begin
    declare v_title VARCHAR(100);
    declare v_stock INT;
    declare done boolean default false;

    -- 커서 선언
    declare book_cursor cursor for 
        select  title, stock
        from book;

    -- NOT FOUND 처리
    declare continue HANDLER for not found
    begin
        SET done = true;
    end;

    -- 커서 열기
    open book_cursor;

    read_loop: loop

        fetch book_cursor into v_title, v_stock;

        -- 더 이상 데이터 없으면 종료
        if done then
            leave read_loop;
        end if;

        select CONCAT(v_title, ' 재고: ', v_stock, '권') as result;

    end loop;

    -- 커서 닫기
    close book_cursor;
end // 
delimiter ;

call print_book_stock();

-- student_score 테이블의 모든 학생을 커서로 한 명 씩  읽어
-- 다음 형식으로 출력하는 print_student_score 프로시저 만들기
-- 김철수 - java 점수 : 92점
select*from student_score;
delimiter //
create procedure print_student_score()
begin
	declare v_name varchar(50);
    declare v_subject varchar(50);
	declare v_score int;
	declare done boolean default false;

	declare score_cursor cursor for
	select student_name, subject, score
	from student_score;
	
	declare continue HANDLER for not found
    begin
        SET done = true;
    end;
	
	open score_cursor;
	
	read_loop: loop
		fetch score_cursor into v_name, v_subject, v_score;
		
		if done then
		   leave read_loop;
		end if;
		
		select concat(v_name,'-',v_subject,'점수:',v_score,'점')as result;	
	end loop;
    close score_cursor;
	
end //
delimiter ;

call print_student_score;
#-----------------------------------------------------------------------------------

CREATE TABLE fail_student_log (
    log_id INT AUTO_INCREMENT PRIMARY KEY,
    student_id INT,
    student_name VARCHAR(50),
    subject VARCHAR(50),
    score INT,
    reason VARCHAR(100),
    created_at DATETIME DEFAULT NOW()
);

-- 커서를 이용한 과락 학생 기록하기
-- student_score 테이블에서 점수가 60점 미만인 학생만 커서로 찾아 
-- fail_student_log 테이블에 기록하는 insert_fail_student_log 작성하기

delimiter //
create procedure insert_fail_student_log()
begin
	declare v_id varchar(50);
	declare v_name varchar(50);
    declare v_subject varchar(50);
	declare v_score int;
    declare done boolean default false;
    
    declare score_cursor cursor for
    select student_id, student_name, subject, score 
    from student_score
    where score < 60;

    declare continue HANDLER for not found
    begin
        SET done = true;
    end;
    
    open score_cursor;
    
    read_loop: loop
		fetch score_cursor into v_id, v_name, v_subject, v_score;
    if done then
		   leave read_loop;
	end if;
    insert into fail_student_log(student_id, student_name, subject, score,reason)
    values(v_id, v_name, v_subject, v_score, '60점 미만 과락');

    end loop;
    
    close score_cursor;
    select * from fail_student_log;

end //
delimiter ;

drop procedure insert_fail_student_log;

call insert_fail_student_log();
    

-- trigger 
-- insert,update, delete가 발생 했을 떄 자동으로 실행되는 sql 프로그램
-- 주문이 들어오면 재고 자동 차감
-- 회원정보가 수정되면 수정 로그를 저장
-- 급여가 음수가 입력되면 막기
-- 게시글이 삭제되면 기록 남기기

-- 프로시저는 직접 호출해야 실행한다.
-- 트리거는 자동으로 실행된다.

-- 트리거 작동 시점
-- before : 데이터가 저장, 수정, 삭제 되기 전에 실행(검사)
-- after : 데이터가 저장,수정,삭제된 후 실행(기록, 다른 테이블 수정)

-- 실행 이벤트 
-- insert : 데이터 추가시 실행
-- update : 데이터 수정시 실행
-- delete : 데이터 삭제시 실행

-- new : 새로 들어오거나 수정될 값
-- old : 기존에 있던 값

-- 기본 문법
-- delimiter //
-- create trigger 트리거명
-- [before or after] [insert or update or delete]
-- on 테이블명
-- for each row
-- begin
-- 실행할 SQL;
-- end //
-- delimiter ;

CREATE TABLE board (
    board_id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(100) NOT NULL,
    content TEXT,
    writer VARCHAR(50),
    view_count INT DEFAULT 0,
    status VARCHAR(20) DEFAULT 'ACTIVE',
    created_at DATETIME DEFAULT NOW(),
    updated_at DATETIME
);

CREATE TABLE board_log (
    log_id INT AUTO_INCREMENT PRIMARY KEY,
    board_id INT,
    action_type VARCHAR(20),
    old_title VARCHAR(100),
    new_title VARCHAR(100),
    log_message VARCHAR(255),
    created_at DATETIME DEFAULT NOW()
);

-- board 테이블에 게시글이 추가되면 board_log 테이블에
-- 등록 로그를 남기는 트리거 작성하기
DELIMITER //

create trigger trg_board_insert
after insert on board
for each row
begin
    insert into board_log (
        board_id,
        action_type,
        old_title,
        new_title,
        log_message
    )
    values (
        new.board_id, -- 새로 추가된 값을 가져온다.
        'INSERT',
        null,
        new.title,
        CONCAT('게시글 [', new.title, '] 이(가) 등록되었습니다.')
    );
end //
DELIMITER ;

-- board테이블에 데이터 추가하기
insert into board(title, content, writer)
values('첫번쨰 게시글', '트리거 실습입니다.', '홍길동');

select*from board;
select*from board_log;

-- 게시글이 수정 되었을 떄 로그를 기록하는 트리거
-- 게시글 제목이 수정되면 변경 전 제목과 변경 후 제목을 board_log 테이블에 저장
DELIMITER //

create trigger trg_board_after_update
after update on board
for each row 
begin
    if old.title <> new.title then

        insert into board_log(
            board_id,
            action_type,
            old_title,
            new_title,
            log_message
        )
        values (
            new.board_id,
            'UPDATE',
            old.title,
            new.title,
            '게시글 제목이 수정되었습니다.'
        );

    end if;
end //

DELIMITER ;

update board
set title = '새 제목'
where board_id = 1;
select*from board_log;

-- 게시글이 수정될 떄 마다 board 테이블의 updated_at에 현재 시간을 자동 저장하는 
-- trg_board_before_update 만들기
  
DELIMITER //
create trigger trg_board_before_update
before update on board
for each row
begin
    SET new.updated_at = NOW();
end //
DELIMITER ;

update board
set content = '내용이 수정되었습니다'
where  board_id = 1;
select*from board;