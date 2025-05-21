create table userinfo(
id number not null, -- PK
name VARCHAR2(20),
loginid VARCHAR2(20),
email VARCHAR2(20)
);
create table depart(
id number not null,
depart_nm VARCHAR2(20),
depart_tel VARCHAR2(20)
);

-- 데이터 5개 삽입
insert into userinfo values(1,'콩','a','naver');
insert into userinfo values(2,'초롱','b','gmail');
insert into userinfo values(3,'백설','c','daum');
insert into userinfo values(4,'라운','d','naver');
insert into userinfo values(5,'나나','e','daum');

-- 데이터 4개
insert into depart values(1,'10','010');
insert into depart values(2,'11','011');
insert into depart values(3,'12','012');
insert into depart values(4,'13','013');

SELECT * FROM userinfo;
SELECT * FROM depart;

-- ALTER -> 제약조건
-- PRIMARY KEY

ALTER TABLE userinfo ADD PRIMARY KEY(id);
ALTER TABLE depart ADD PRIMARY KEY(id);

-- FOREIGN KEY 제약조건(부모 테이블 : userinfo(id));
ALTER TABLE depart ADD CONSTRAINT userdb_foreign 
FOREIGN KEY(id) REFERENCES userinfo(id);

-- 삭제
ALTER TABLE depart DROP CONSTRAINT userdb_foreign;

-- NOT NULL 제약조건(depart_tel)
ALTER TABLE depart MODIFY depart_tel NOT NULL;

-- INNER JOIN
-- ANSI
-- 사원의 아이디와 성명 부서전화번호 이메일
SELECT us.id, name,depart_tel, email
FROM userinfo us INNER JOIN depart dp
ON us.id = dp.id;

-- 오라클 전용
SELECT us.id, name,depart_tel, email
FROM userinfo us, depart dp
WHERE us.id = dp.id;

-- OUTER JOIN(ANSI)
-- 사원의 아이디와 성명 부서전화번호 이메일(단 부서배정을 받지 않은 인턴사원까지 모두 출력)
SELECT us.id, name,depart_tel, email
FROM userinfo us LEFT OUTER JOIN depart dp
ON us.id = dp.id;

































