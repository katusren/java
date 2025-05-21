-- Table 생성
-- SQL(DDL -> Data Definition Language) : CREATE, DROP, ALTER

-- JAVA 연동
-- 테이블 삭제
DROP TABLE usertbl;
CREATE TABLE usertbl(
userid VARCHAR2(20), name VARCHAR2(20), password VARCHAR2(20), 
age NUMBER(10), email VARCHAR2(20));

-- 검색
SELECT * FROM usertbl; -- DML
-- 입력
INSERT INTO usertbl VALUES('sol2025','soldesk','12345',15,'soldesk@study.com');
INSERT INTO usertbl VALUES('smile2025','smile','12345',38,'smile@study.com');
INSERT INTO usertbl VALUES('gabia2025','gabia','12345',20,'gabia@study.com');

-- 업데이트
UPDATE usertbl SET email='soldesk@sol.com' WHERE userid='sol2025';
-- 데이터 삭제
DELETE FROM usertbl WHERE userid ='sol2025';

------------------------------------------------------------

-- memberjoin 테이블 생성
CREATE TABLE memberjoin(
id VARCHAR2(20),
pwd NUMBER(20)
);

-- 테이블 삭제
DROP TABLE memberjoin;

-- 검색
SELECT * FROM memberjoin; -- DML

INSERT INTO memberjoin values('smile',12345);
INSERT INTO memberjoin values('soldesk',12345);


































COMMIT;
