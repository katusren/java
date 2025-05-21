SELECT * FROM book;
SELECT * FROM customer;
SELECT * FROM orders;

-- Book테이블에서 가격이(price) 20000원이상인 데이터의 도서이름, 출판사, 가격 출력
select bookname, publisher, price from book where price>=20000; 

-- Book 테이블에서 모든 도서의 이름과 가격만 출력
select bookname, price from book;

-- Book 테이블에서 모든 도서의 출판사 출력
select publisher from book;

-- Book 테이블에서 모든 도서의 출판사 출력(단 중복제거)
select DISTINCT publisher from book;

-- 가격이 15000원 이상 23000원 이하인 도서의 모든 정보 출력
SELECT * FROM BOOK
WHERE price >= 15000 and price<=23000;
-- 가격이 15000원 이상 23000원 이하인 도서의 모든 정보 출력(단 between 사용)
SELECT * FROM BOOK
WHERE price BETWEEN 15000 and 23000;

-- like와 = 의 차이
-- = 사용시 대소문자 구분, 정확히 일치, 속도빠름
-- like 하나라도 일치하면 검색 결과 출력, 정확하게 일치하지 않아도 패턴으로 검색, 속도저하
-- 패턴

-- book 테이블에서 축구의 역사를 출간한 출판사와 도서의 가격을 보이시오
select publisher, price
from book
where bookname='축구의 역사';

select publisher, price
from book
where bookname like '축구의 역사';

-- book테이블에서 야구에 관한 도서의 모든 정보를 보이시오
select * from book
where bookname like '%야구%';

-- 집계
-- 도서가격 합계
select sum(price) "도서가격 총액"
from book;

-- 도서가격 중 가장 비싼 도서의 가격
select MAX(price) "도서 최고가"
from book;

-- 도서가격 중 가장 싼 도서의 가격
select MIN(price) "도서 최저가"
from book;

-- 입고된 도서 갯수
SELECT COUNT(BOOKID) "총도서 수"
FROM BOOK;

SELECT * FROM BOOK;



















