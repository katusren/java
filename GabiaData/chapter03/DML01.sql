-- DML(Data Manipulation Language) : 데이터 조작언어
/*
select : 데이터 조회
insert : 데이터 삽입
update : 데이터 수정 또는 갱신
delete : 데이터 삭제
*/

select * from book;
select * from orders;
select * from customer;

-- 데이터 삭제(delete)
delete from orders where bookid like 1; -- 자식테이블에서 먼저 삭제 후 book 테이블에서 삭제
delete from book where bookid like 1; -- 부모 테이블 데이터 삭제 가능

delete from orders where custid like 7; -- 자식테이블에서 먼저 삭제 후 customer 테이블에서 삭제
delete from customer where custid like 7; -- 부모 테이블 데이터 삭제 가능

-- 삭제 복구
INSERT INTO Book VALUES(1, '축구의 역사', '굿스포츠', 13000);
INSERT INTO Customer VALUES (7, '이영지', '대한민국 경기',  NULL);
insert into orders values(1,1,1,13000, To_date('2022-07-15','yyyy-mm-dd'));
insert into orders values(12,7,10,13000,to_date('2022-07-12','yyyy-mm-dd'));

-- 업데이트
update book set bookname='축구하는 여자' where bookid = 2;
-- book 테이블 bookid=5,6,7 에서 각각 price를 14000, 16000, 27000으로 변경
update book set price=14000 where bookid=5;
update book set price=16000 where bookid=6;
update book set price=27000 where bookid=7;

update orders set saleprice = 14000 where bookid = 5;
update orders set saleprice=16000 where bookid=6;

update customer set address='대한민국 서울' where name like '박세리';
update customer set address='대한민국 경기도' where name like '추신수';

-- DDL의 Truncate는 복구가 불가능한 데이터 삭재 where 절 사용 불가
CREATE TABLE emp_test (
  emp_id NUMBER PRIMARY KEY,
  emp_name VARCHAR2(20),
  salary NUMBER
);
INSERT INTO emp_test VALUES (1, '홍길동', 3000);
INSERT INTO emp_test VALUES (2, '이몽룡', 3500);
INSERT INTO emp_test VALUES (3, '성춘향', 4000);
COMMIT;

SELECT * FROM emp_test;
-- TRUNCATE 실행
TRUNCATE TABLE emp_test; -- DDL, 복구 안됨, 조건절 불가능
delete from emp_test; -- DML, 복구 가능, 조건절 권장
SELECT * FROM emp_test;










