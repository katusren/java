-- 18c 계정등록 권한
ALTER SESSION SET "_ORACLE_SCRIPT"=true;

-- 계정생성
create user member IDENTIFIED by 12345;
-- 기본 접속 권한
grant CONNECT, RESOURCE to member;
-- view, sequence 생성 권한
grant create view, create sequence to member;

ALTER USER member DEFAULT TABLESPACE USERS QUOTA UNLIMITED ON USERS;

create user dm IDENTIFIED by 12345;
grant CONNECT, RESOURCE to dm;

-- 용량 할당
ALTER USER dm DEFAULT TABLESPACE USERS QUOTA UNLIMITED ON USERS;


-----------------------------------------------------
CREATE USER soldesk IDENTIFIED by 12345;

GRANT CONNECT, RESOURCE TO soldesk;

grant create view, create sequence to soldesk;

ALTER USER soldesk DEFAULT TABLESPACE USERS QUOTA UNLIMITED ON USERS;