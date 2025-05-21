-- 부속질의 (인라인질의)
    
--  고객의 ID가 2번이하의 고객에 대한 이름과 총 판매액
--  조인

select name, sum(saleprice) Total
from customer cs, orders od
where cs.custid = od.custid and cs.custid <= 2
group by cs.name;

-- 스칼라 질의
select od.custid, (select name
                    from customer cs
                    where cs.custid=od.custid)name, sum(saleprice)
from orders od
where od.custid < 2
group by od.custid;

-- 인라인 질의
select custid, name
from customer
where custid <=2;

select cs.name, sum(saleprice) Total
from customer cs, orders od
where cs.custid = od.custid
group by cs.name;

select cs.name, sum(saleprice) Total
from (select custid, name from customer where custid<2) cs, orders od
where cs.custid = od.custid
group by cs.name;

-----------------------------------------------------------------------
-- 스칼라 : 주문 내역이 있는 고객의 아이디와 주소, 고객별 판매금액을 보이시오

SELECT * FROM CUSTOMER;
SELECT * FROM ORDERS;

SELECT CUSTID, 
(SELECT ADDRESS FROM CUSTOMER WHERE CUSTOMER.CUSTID = ORDERS.CUSTID) ADDRESS, SUM(SALEPRICE) TOTAL
FROM ORDERS
GROUP BY ORDERS.CUSTID;

-- 조인 : 주문 내역이 있는 고객의 이름, 각 고객별 주문 금액의 평균을 보이시오
SELECT NAME, ROUND(AVG(SALEPRICE),2) AVG_PRICE
FROM CUSTOMER, ORDERS
WHERE CUSTOMER.CUSTID = ORDERS.CUSTID
GROUP BY NAME;

-- 인라인
SELECT CUSTID, ROUND(AVG(SALEPRICE),2)TOTAL
FROM ORDERS
GROUP BY CUSTID;


SELECT NAME, 평균판매액
FROM (SELECT CUSTID, ROUND(AVG(SALEPRICE),2) 평균판매액
FROM ORDERS GROUP BY CUSTID) OD, CUSTOMER CS
WHERE CS.CUSTID = OD.CUSTID;

-- 인라인 : 고객의 이름과 고객별 총 판매액을 보이시오
SELECT NAME, "고객별 총 판매액"
FROM CUSTOMER CS, (SELECT CUSTID, SUM(SALEPRICE) AS "고객별 총 판매액" FROM ORDERS GROUP BY CUSTID) OD
WHERE CS.CUSTID = OD.CUSTID
ORDER BY NAME;

-- 인라인 : 고객의 이름과 고객별 총 판매액이 3만원 이상인 고객을 보이시오
SELECT NAME, "고객별 총 판매액"
FROM CUSTOMER CS, (SELECT CUSTID, SUM(SALEPRICE) AS "고객별 총 판매액" FROM ORDERS GROUP BY CUSTID) OD
WHERE CS.CUSTID = OD.CUSTID AND "고객별 총 판매액" >= 30000
ORDER BY NAME;














































