-- DDL(DATA Definition Language) : 데이터 정의
/*
CREATE : 생성
DROP : 테이블 삭제
ALTER : 테이블 수정
*/

-- soldesk
-- 도서 테이블
DROP TABLE book;
CREATE TABLE book(
bookid NUMBER(10) PRIMARY KEY,
bookname VARCHAR2(40),
publisher VARCHAR2(50),
price NUMBER(20)
);

-- PRIMARY KEY: 유일성, NOT NULL을 만족해야한다

-- 판매 정보
DROP TABLE orders;
CREATE TABLE orders(
orderid NUMBER(10),
custid NUMBER(10) REFERENCES customer(custid),
bookid NUMBER(10) REFERENCES book(bookid),
saleprice NUMBER(20),
orderdate DATE,
PRIMARY KEY (orderid)
);

-- 고객 정보
DROP TABLE customer;
CREATE TABLE customer(
custid NUMBER(10)PRIMARY KEY,
name VARCHAR2(20),
address VARCHAR2(50),
phone VARCHAR2(20)
);

SELECT * FROM book;
-- Book
INSERT INTO Book VALUES(1, '축구의 역사', '굿스포츠', 13000);
INSERT INTO Book VALUES(2, '골때리는 그녀들', '나무수', 17000);
INSERT INTO Book VALUES(3, '축구의 이해', '대한미디어', 22000);
INSERT INTO Book VALUES(4, '골프 바이블', '대한미디어', 35000);
INSERT INTO Book VALUES(5, '피겨 교본', '굿스포츠', 8000); -- 14000
INSERT INTO Book VALUES(6, '역도 단계별기술', '굿스포츠', 6000); --16000
INSERT INTO Book VALUES(7, '야구의 추억', '이상미디어', 20000);
INSERT INTO Book VALUES(8, '야구를 부탁해', '이상미디어', 13000);
INSERT INTO Book VALUES(9, '올림픽 이야기', '삼성당', 7500); --27000
INSERT INTO Book VALUES(10, 'Olympic Champions', 'Pearson', 13000);

SELECT * FROM customer;
-- customer
insert into customer values(1, '박지성', '영국 맨체스타', '010-7894-8569');
INSERT INTO Customer VALUES (2, '김연아', '대한민국 서울', '000-6000-0001');  
INSERT INTO Customer VALUES (3, '장미란', '대한민국 강원도', '000-7000-0001');
INSERT INTO Customer VALUES (4, '추신수', '미국 클리블랜드', '000-8000-0001');
INSERT INTO Customer VALUES (5, '박세리', '대한민국 대전',  NULL);
INSERT INTO Customer VALUES (6, '박태환', '호주 클리블랜드', '000-8800-0001');
INSERT INTO Customer VALUES (7, '이영지', '대한민국 경기',  NULL);

select * from orders;
-- orders
insert into orders values(1,1,1,13000, To_date('2022-07-15','yyyy-mm-dd'));
insert into orders values(2,1,3,22000, To_date('2022-07-14','yyyy-mm-dd'));
insert into orders values(3,2,5,13000, To_date('2022-07-14','yyyy-mm-dd'));
insert into orders values(4,3,6,22000, To_date('2022-07-12','yyyy-mm-dd'));
insert into orders values(5,4,7,13000, To_date('2022-07-07','yyyy-mm-dd'));
insert into orders values(6,1,2,22000, To_date('2022-07-07','yyyy-mm-dd'));
insert into orders values(9,2,7,20000, To_date('2022-07-07','yyyy-mm-dd'));
insert into orders values(10,3,2,17000, To_date('2022-07-07','yyyy-mm-dd'));
insert into orders values(11,6,8,13000,to_date('2022-07-15','yyyy-mm-dd'));
insert into orders values(12,7,10,13000,to_date('2022-07-12','yyyy-mm-dd'));
insert into orders values(13,6,2,22000,to_date('2022-07-13','yyyy-mm-dd'));
insert into orders values(7,4,5,8000, To_date('2022-07-14','yyyy-mm-dd'));
insert into orders values(8,3,6,6000, To_date('2022-07-12','yyyy-mm-dd'));

-------------------------------------------------
-- 학사관리 프로젝트(정수 : number, 문자 : varchar2)
-- 학생(학생번호:stdnum, 이름:stdname, 성별:gender, 주소:address, 전화:phone) - student
-- 강좌(강좌번호:classnum, 학생번호:stdnum, 교수번호:pronum, 강좌명:classname, 강의실:classaddress, 강좌시간:classtime) - class
-- 교수(교수번호:pronum, 학생번호:stdnum, 이름:proname, 성별:progender, 주소:proaddress, 전화번호:phone) - professor

DROP TABLE student;
CREATE TABLE student(
stdnum NUMBER(10) PRIMARY KEY,
stdname VARCHAR2(20),
gender VARCHAR2(20),
address VARCHAR2(50),
phone VARCHAR2(20)
);

DROP TABLE professor;
CREATE TABLE professor(
pronum NUMBER(10) PRIMARY KEY,
stdnum NUMBER(10),
proname VARCHAR2(20),
progender VARCHAR2(20),
proaddress VARCHAR2(50),
phone VARCHAR2(20)
);

DROP TABLE calss;
CREATE TABLE class(
classnum NUMBER(10) PRIMARY KEY,S
stdnum NUMBER(10),
pronum NUMBER(10),
classname VARCHAR2(20),
classaddress VARCHAR2(50),
classtime VARCHAR2(10),
FOREIGN KEY(stdnum) REFERENCES student(stdnum),
FOREIGN KEY(pronum) REFERENCES professor(pronum)
);






































