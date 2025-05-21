-- 기본키가 하나일 경우는 각 컬럼에 명시가 가능하지만, 두개 이상일 경우는 괄호를 사용하여 복합키로 지정해야 함
CREATE TABLE newbook(
bookid NUMBER(10),
naverid NUMBER(10),
bookname VARCHAR2(40),
publisher VARCHAR2(50),
price NUMBER(20),
PRIMARY KEY(bookid, naverid)
);

DROP TABLE newcustomer;
CREATE TABLE newcustomer(
custid NUMBER PRIMARY KEY,
name VARCHAR2(40),
address VARCHAR2(40),
phone VARCHAR2(40)
);

CREATE TABLE neworders(
orderid NUMBER,
custid NUMBER,
bookid NUMBER,
saleprice NUMBER,
orderdate DATE,
PRIMARY KEY(orderid),
FOREIGN KEY(custid) REFERENCES newcustomer(custid) ON DELETE CASCADE
);

-- 테이블 삭제
DROP TABLE newbook; -- REFERENCES가 설정되어 있지 않아서 잘 삭제됨

DROP TABLE newcustomer; -- REFERENCES가 설정되어 있음 즉 부모 테이블이므로 삭제가 안됨
DROP TABLE neworders; -- 자식 테이블이므로 먼저 삭제해줘야 newcostomer 테이블이 삭제됨

-- ON DELETE CASCADE, ON UPDATE CASCADE: 부모 테이블에서 삭제 또는 업데이트시 자동으로 자식 테이블에 적용
-- ON UPDATE CASCADE는 오라클에서는 지원되지 않음(트리거로 지원하고 있음)
---------------------------------------------------------------------------------

-- 제약조건(PRIMARY KEY 설정(단 제약 조건 이름 없음))
ALTER TABLE newbook ADD PRIMARY KEY(bookid);
ALTER TABLE newcustormer ADD PRIMARY KEY(custid);
ALTER TABLE neworders ADD PRIMARY KEY(orderid);

-- 제약조건 해제
ALTER TABLE newbook DROP CONSTRAINT SYS_C007314;
ALTER TABLE newcustormer DROP CONSTRAINT SYS_C007321;
ALTER TABLE neworders DROP CONSTRAINT SYS_C007319;

-- 제약조건(PRIMARY KEY 설정(단 제약 조건 이름 부여))
ALTER TABLE newbook ADD CONSTRAINT pk_book PRIMARY KEY(bookid);
ALTER TABLE newcustormer ADD CONSTRAINT pk_customer PRIMARY KEY(custid);
ALTER TABLE neworders ADD CONSTRAINT pk_orders PRIMARY KEY(orderid);

-- 제약조건 해제
ALTER TABLE newbook DROP CONSTRAINT pk_book;
ALTER TABLE newcustormer DROP CONSTRAINT pk_customer;
ALTER TABLE neworders DROP CONSTRAINT pk_orders;

-- NULL값 허용 하지 않음
ALTER TABLE newbook MODIFY bookname VARCHAR2 NOT NULL;

-- 제약조건(REFERENCES)
ALTER TABLE neworders ADD CONSTRAINT refer_newbook
FOREIGN KEY(bookid) REFERENCES newbook(bookid);

ALTER TABLE neworders ADD CONSTRAINT refer_newcustormer
FOREIGN KEY(custid) REFERENCES newcustormer(custid);

-- 제약조건 해제
ALTER TABLE newbook DROP CONSTRAINT refer_newbook;
ALTER TABLE newcustormer DROP CONSTRAINT refer_newcustormer;

-- ALTER 변경 추가 삭제
SELECT * FROM newbook;
desc TB_newbook; -- 테이블 요약 정보
ALTER TABLE TB_newbook RENAME TO newbook; -- 이름 변경

ALTER TABLE newbook ADD isbn VARCHAR2(40); -- 속성 추가
ALTER TABLE newbook MODIFY isbn NUMBER; -- 속성 타입변경
ALTER TABLE newbook RENAME COLUMN isbn to iss; -- 컬럼 이름 변경
ALTER TABLE newbook DROP COLUMN iss; -- 칼럼 삭제

CREATE TABLE mother_tbl(
m_val VARCHAR2(50)
);

CREATE TABLE child_tbl(
m_val VARCHAR2(10),
c_val VARCHAR2(20)
);

SELECT * FROM mother;
SELECT * FROM child;

-- ALTER키를 이용하여 PRIMARY KEY 생성
ALTER TABLE mother_tbl ADD PRIMARY KEY(m_val);
ALTER TABLE child ADD PRIMARY KEY(c_val);

-- REFERENCES 제약조건(이름은 mother_child_FK) 단. ON DELETE CASCADE
ALTER TABLE child ADD CONSTRAINT mother_child_FK 
FOREIGN KEY(m_val) REFERENCES mother(m_val) ON DELETE CASCADE;

-- 각 테이블의 이름 변경(mother, child)
ALTER TABLE mother_tbl RENAME TO mother;
ALTER TABLE child_tbl RENAME TO child;

-- 각 테이블의 name이라는 컬럼을 추가
ALTER TABLE mother ADD name VARCHAR2(40);
ALTER TABLE child ADD name VARCHAR2(40);

-- mother 테이블에 m_val의 타입을 VARCHER(20)으로 변경
ALTER TABLE mother MODIFY m_val VARCHAR(20);

desc mother;
desc child;

SELECT * FROM mother;
INSERT INTO mother VALUES('A','A값1');
INSERT INTO mother VALUES('B','B값1');
SELECT * FROM child;
INSERT INTO child VALUES('A','a','A값1');
INSERT INTO child VALUES('A','a','A값2'); -- PK인 c_val값이 중복되어 에러
INSERT INTO child VALUES('A','aa','A값2');
INSERT INTO child VALUES('B','b','B값1');
INSERT INTO child VALUES('B','bb','B값2');

DELETE FROM mother WHERE m_val = 'A';

-- UNIQUE : 중복데이터 입력 불가능
-- DEFAULT : 입력값이 없을겨우
-- check : 직접입력시 최소 금액

DROP TABLE bookinfo;
CREATE TABLE bookinfo(
isbn VARCHAR2(13) UNIQUE, -- 고유 ISBN, 중복 입력 불가
title VARCHAR2(100) NOT NULL, -- 책 제목, 반드시 입력해야 함
author VARCHAR2(50),
price NUMBER(10) DEFAULT 10000 CHECK(price >=5000),
publisher VARCHAR2(50)
);

-- DEFAULT: 가격을 입력하지 않으면 자동으로 설정
-- CHECK: 가격을 입력할 경우 최소 5000원 이상만 가능

-- 기본값 사용 (price 생략)
INSERT INTO BookInfo(isbn, title, author, publisher)
VALUES ('9781234567890', '자바의 정석', '남궁성', '도우출판');

-- price를 6000으로 직접 입력(조건 통과)
INSERT INTO BookInfo(isbn, title, author,price, publisher)
VALUES ('9781234567891', 'SQL 첫걸음', '홍길동', 6000 , '한빛미디어');

-- isbn 중복으로 제약조건에 위배됨(에러 발생)
INSERT INTO BookInfo(isbn, title, author,price, publisher)
VALUES ('9781234567891', 'SQL 심화', '나수진', 12000 , '한빛미디어');

-- 오류: price가 3000으로 입력되면 CHECK 제약 위반(에러 발생)
INSERT INTO BookInfo(isbn, title, author, price, publisher)
VALUES ('9781234567892', '파이썬 입문', '이순신',3000, '이지스퍼블리싱');

SELECT * FROM bookinfo;





















