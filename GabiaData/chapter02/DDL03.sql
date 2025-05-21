-- DDL
-- CREATE, DROP, ALTER



-- 테이블 (Department -> deptno(정수), deptname(문자열), manager(문자열) ) 생성
-- deptno 기본키
CREATE TABLE Department(
deptno NUMBER(20),
deptname VARCHAR2(30),
manager VARCHAR2(30)
);

-- 테이블 (Employee -> empno(정수),name(문자열),phoneno(정수), address(문자열),gender(문자열),position(문자열),deptno(정수)) 생성
-- empno 기본키
CREATE TABLE Employee(
empno NUMBER(20),
name VARCHAR2(30),
phoneno NUMBER(20),
address VARCHAR2(30),
gender VARCHAR2(30),
position VARCHAR2(30),
deptno NUMBER(20)
);


-- 테이블 (Project -> projno(정수), projname(문자열), deptno(정수))생성
-- projno 기본키
CREATE TABLE Project(
projno NUMBER(20),
projname VARCHAR2(30),
deptno NUMBER(20)
);


-- 테이블 (Works -> projno(정수),empno(정수), hoursworked(정수))생성
-- projno,empno 기본키
DROP TABLE works;
CREATE TABLE Works(
projno NUMBER(10) NOT NULL,
empno NUMBER(10),
hoursworked NUMBER(10),
PRIMARY KEY(projno, empno)
);

-- ALTER
-- PRIMARY KEY
ALTER TABLE department ADD PRIMARY KEY(deptno);
ALTER TABLE Employee ADD PRIMARY KEY(empno);
ALTER TABLE Project ADD PRIMARY KEY(projno);

-- 참조 제약조건
-- Employee 에서 Department를 참조
ALTER TABLE Employee ADD CONSTRAINT emp_fk
FOREIGN KEY(deptno) REFERENCES Department(deptno);

-- Project에서 Department를 참조
ALTER TABLE Project ADD CONSTRAINT pro_fk
FOREIGN KEY(deptno) REFERENCES Department(deptno);

-- Works에서 Employee를 참조
ALTER TABLE Works ADD CONSTRAINT work_emp_fk
FOREIGN KEY(empno) REFERENCES Employee(empno);

-- Works에서 Project를 참조
ALTER TABLE Works ADD CONSTRAINT work_proj_fk
FOREIGN KEY(projno) REFERENCES Project(projno);

-- 입력
-- Department (부서)
INSERT INTO Department VALUES(1,'IT','고예림');
INSERT INTO Department VALUES(2,'Marketing','최영준');
INSERT INTO Department VALUES(3,'Sales','김진혁');

SELECT * FROM Department;

-- Employee (직원)
INSERT INTO Employee VALUES(1,'김덕성','01012345678','서울 관악구','남','Programmer',1);
INSERT INTO Employee VALUES(2,'이서울','01012345678','서울 은평구','여','Programmer',2);
INSERT INTO Employee VALUES(3,'박연세','01012345678','경기 고양시','여','Programmer',2);
INSERT INTO Employee VALUES(4,'고예림','01012345678','대전','남','Programmer',1);
INSERT INTO Employee VALUES(5,'최영준','01012345678','서울 종로구','남','Programmer',3);
INSERT INTO Employee VALUES(6,'김진혁','01012345678','의정부','남','Programmer',1);


SELECT * FROM Employee;

-- Project
INSERT INTO Project VALUES(1,'DB구축',1);
INSERT INTO Project VALUES(2,'마케팅데이터 분석',2);

SELECT * FROM Project;

-- Works
INSERT INTO Works VALUES(1,1,3);
INSERT INTO Works VALUES(1,2,1);
INSERT INTO Works VALUES(2,3,1);
INSERT INTO Works VALUES(2,4,5);
INSERT INTO Works VALUES(1,5,1);

SELECT * FROM Works;

-- 내부조인(교집합): Inner Join(=natual join)
-- SQL 전용(ANSI)
SELECT empno, name, phoneno,de.deptno,deptname,manager
FROM department de
INNER JOIN employee em
ON de.deptno = em.deptno;

-- 오라클 전용
SELECT empno, name, phoneno,de.deptno,deptname,manager
FROM department de, employee em
WHERE de.deptno = em.deptno;

-- empno, name, hoursworked (사원의정보와 작업시간)
SELECT em.empno, name, hoursworked
FROM employee em
INNER JOIN works ws
ON em.empno = ws.empno;

SELECT wk.empno, name, projno, hoursworked
FROM employee em, works wk
WHERE em.empno (+)= wk.empno;

-- Outer Join
-- deptno, deptname, projno, projname
-- 단 프로젝트에 투입되지 않은 부서도 모두 출력
-- ANSL
SELECT de.deptno, deptname, projno, projname
FROM department de LEFT OUTER JOIN project pr
ON de.deptno = pr.deptno;
-- 오라클 전용
SELECT de.deptno, deptname, projno, projname
FROM department de, project pr
WHERE de.deptno = pr.deptno(+);

create table Imported_book(
bookid number,
bookname varchar2(40),
publisher varchar2(40),
price number(12));

insert into imported_book values(21,'sol Golf','Soldesk',27000);
insert into imported_book values(22,'soccer Skills','Human',18000);

SELECT * FROM imported_book;

------------------------------------------------------

create table order_2(
orderid number, -- 기본키
custname VARCHAR2(20),
salesperson VARCHAR2(20),
amount number);

create table customer_2(
name VARCHAR2(20), -- 기본키
city VARCHAR2(20),
industrytype VARCHAR2(40)
);

create table salesperson(
name VARCHAR2(20), -- 기본키
age number,
salary number);

-------------------------------------------
-- ALTER 기본키
ALTER TABLE order_2 ADD PRIMARY KEY(orderid);
ALTER TABLE customer_2 ADD PRIMARY KEY(name);
ALTER TABLE salesperson ADD PRIMARY KEY(name);

-- NOT NULL: custname, city, salary
ALTER TABLE order_2 MODIFY custname VARCHAR2(20) NOT NULL;
ALTER TABLE customer_2 MODIFY city VARCHAR2(20) NOT NULL;
ALTER TABLE salesperson MODIFY salary NUMBER NOT NULL;

-- 참조조건(자식테이블: order_2 / 부모테이블: salesperson, customer_2)
ALTER TABLE order_2 ADD CONSTRAINT sales_order_FK
FOREIGN KEY(salesperson) REFERENCES salesperson(name);

ALTER TABLE order_2 ADD CONSTRAINT cust_order_FK
FOREIGN KEY(custname) REFERENCES customer_2(name);

-- 입력
insert into customer_2 values('김이름', '서울', '의류');
insert into customer_2 values('이이름', '인천', '서적');
insert into customer_2 values('최이름', '경기도', '식품');

insert into salesperson values('김판매자', 27, 5000000);
insert into salesperson values('이판매자', 35, 6500000);
insert into salesperson values('최판매자', 25, 7000000);

INSERT INTO order_2 VALUES(1,'김이름','김판매자',3);
INSERT INTO order_2 VALUES(2,'이이름','이판매자',2);

-- 구매아이디와 구매한 고객의 이름, 구매한 고객의 지역, 판매자이름과 판매수익을 출력하시오
SELECT orderid, custname, city, salesperson, salary
FROM order_2 or2
INNER JOIN customer_2 cs2 ON or2.custname = cs2.name
INNER JOIN salesperson sp ON or2.salesperson = sp.name;

SELECT orderid, custname, city, salesperson, salary
FROM order_2 or2, customer_2 cs2, salesperson sp
WHERE or2.custname = cs2.name AND or2.salesperson = sp.name;

commit;

create table sales(
salesdate date,
book_id number,
custmer_id number,
quantity  NUMBER,
amount number);

ALTER TABLE sales ADD PRIMARY KEY(custmer_id);
ALTER TABLE sales ADD CONSTRAINT cust_sales_FK
FOREIGN KEY(custmer_id) REFERENCES customer(custid);

INSERT INTO sales VALUES(to_date('2022-08-01','yyyy-mm-dd'),2,3,1,15);
INSERT INTO sales VALUES(to_date('2022-08-02','yyyy-mm-dd'),1,2,1,12);
INSERT INTO sales VALUES(to_date('2022-08-03','yyyy-mm-dd'),3,4,1,13);

select * from sales;
select * from customer;

create table promotions(
campaign VARCHAR2(40),
promodate date,
custmer_id number PRIMARY key
);

alter table promotions add CONSTRAINT cust_pro_foreign foreign key(custmer_id) references customer(custid);

insert into promotions VALUES('SMS_discount22', to_Date('2022-08-03','yyyy-mm-dd'), 2);
insert into promotions VALUES('SMS_discount22', to_Date('2022-07-30','yyyy-mm-dd'), 3);
insert into promotions VALUES('SMS_discount22', to_Date('2022-07-25','yyyy-mm-dd'), 5);
SELECT * FROM promotions;

-- 구매고객과 구매하지 않은 고객 모두 보이시오
select c.custid, c.name, c.address, c.phone, s.salesdate, s.quantity
FROM customer c LEFT OUTER JOIN sales s
ON c.custid = s.custmer_id(+);
-- 구매한 고객만 출력
select c.custid, c.name, c.address, c.phone, s.salesdate, s.quantity
FROM customer c INNER JOIN sales s
ON c.custid = s.custmer_id;

-- 구매고객과 구매하지 않은 고객의 정보와 promodate, campaign
select c.custid, c.name, c.address, c.phone, s.salesdate, s.quantity. campaign, p.promodate
FROM customer c
left join sales s on c.custid = s.custmer_id
left join promotions p on p.custmer_id = c.custid;

































