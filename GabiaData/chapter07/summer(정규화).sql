CREATE TABLE summer(
sid number,
calss VARCHAR(40),
price NUMBER
);

insert into summer values(100, 'JAVA', 50000);
insert into summer values(150, 'ORACLE', 45000);
insert into summer values(200, 'JSP', 30000);
insert into summer values(250, 'JAVA', 50000);

SELECT * FROM summer;

-- 삭제 이상현상
-- JSP 강좌의 수강료 조회
SELECT price FROM summer WHERE calss like 'JSP';

-- 200번 학생이 수강신청 철회
DELETE FROM summer WHERE SID=200;

commit;

-- 삽입 이상현상
-- API강좌 추가
insert into summer values(null,'API',25000);
select * from summer;

-- 전체 수강인원을 보이시오
select count(*) AS "수강 인원" from summer;

-- 업그레이드 이상현상
UPDATE summer set price=50000
where calss like 'JAVA';

-- JAVA 수강료 문의
SELECT DISTINCT price FROM summer WHERE calss like 'JAVA';

-- 만약 UPDATE 문을 다음과 같이 작성한다면
UPDATE summer SET price=40000
WHERE calss like 'JAVA' and sid = 100;

-- 원본 유지
DELETE FROM summer WHERE SID IS NULL;

COMMIT;

























