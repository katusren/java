-- 시퀀스
CREATE SEQUENCE SEQ_TEST
START WITH 1
INCREMENT BY 1
MINVALUE 1
MAXVALUE 9999
CYCLE NOCACHE;

/*
START WITH 1 -- 시작
INCREMENT BY 1 -- 증가값
MINVALUE 1 -- 임계구역의 최소값
MAXVALUE 9999 -- 임계구역의 최대값
CYCLE -- 9999까지 찍고 1부터 시작
NOCYCLE -- 반복 없음
CACHE - 이전에 사용된 메모리 영역을 계속 유지함
NOCACHE; -- 속도 향상
*/

-- 증가 시퀀스
CREATE TABLE emp_seq(
id number,
name VARCHAR2(20),
day timestamp with time zone default systimestamp
);

SELECT * FROM emp_seq;

/*
timestamp  -- date 자료형의 확장판(year, month, dat, hour, minute, second)
with time zone -- 표준시간(GMT) 시차적용
default systimestamp -- 로컬시스템 시간에 맞춤
*/

-- 입력
INSERT INTO emp_seq VALUES(SEQ_TEST.NEXTVAL, '홍길동', DEFAULT);
INSERT INTO emp_seq VALUES(SEQ_TEST.NEXTVAL, '김영롱', DEFAULT);
INSERT INTO emp_seq VALUES(SEQ_TEST.NEXTVAL, '김태국', DEFAULT);
INSERT INTO emp_seq VALUES(SEQ_TEST.NEXTVAL, '유세진', DEFAULT);

-- 시퀀스 수정
ALTER SEQUENCE SEQ_TEST INCREMENT BY 2;
ALTER SEQUENCE SEQ_TEST MAXVALUE 1000;

----------------------------------------------
-- 감소 시퀀스
CREATE SEQUENCE SEQ_TEST2
START WITH 1000
INCREMENT BY -1
MINVALUE 1
MAXVALUE 1000
NOCACHE
NOCYCLE;

CREATE TABLE emp_seq2(
id number,
name varchar(20),
day timestamp with time zone default systimestamp
);

INSERT INTO emp_seq2 VALUES(SEQ_TEST2.NEXTVAL, '김길동', DEFAULT);
INSERT INTO emp_seq2 VALUES(SEQ_TEST2.NEXTVAL, '박수', DEFAULT);
INSERT INTO emp_seq2 VALUES(SEQ_TEST2.NEXTVAL, '김치', DEFAULT);

SELECT * FROM emp_seq2
















































