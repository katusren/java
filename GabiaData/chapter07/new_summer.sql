-- summer 정규화
-- summerprice 생성
CREATE TABLE summerprice(
class VARCHAR(40),
price NUMBER
);

insert into summerprice values('JAVA',50000);
insert into summerprice values('JSP',45000);
insert into summerprice values('Spring',80000);

SELECT * FROM summerprice;

create table summerEnroll(
sid number,
class varchar2(40)
);

insert into summerEnroll values(100,'JAVA');
insert into summerEnroll values(150,'JSP');
insert into summerEnroll values(200,'Spring');
insert into summerEnroll values(250,'JAVA');

SELECT * FROM summerEnroll;

---------------------------------------------------------------
SELECT price FROM summerprice WHERE class like 'Spring';

-- 200번 학생 수강 취소
DELETE FROM summerenroll WHERE sid = 200;

commit;

-- 삽입
insert into summerprice values('JS',25000);
select * from summerprice;

-- 수강 등록 테이블 조회
select * from summerEnroll;
-- 수강 학생수 조회
SELECT COUNT(*) FROM summerEnroll;

-- 업데이트
UPDATE summerprice SET price = 40000
WHERE class LIKE 'JAVA';






























