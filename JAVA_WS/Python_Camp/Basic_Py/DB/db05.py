import sqlite3

# 연결후 데이터베이스 생성
con = sqlite3.connect("C:/Users/soldesk/Downloads/JAVA/JAVA_WS/Python_Camp/sqlite/soldesk.db")
cur = con.cursor()

# 테이블 생성
#cur.execute("create table userTable(id char(20), userName char(32), email char(32), bithYear int(20))")

# 데이터 삽입
cur.execute("insert into userTable values('sol','soldesk','sol@naver.com',4)")
cur.execute("insert into userTable values('sol1','soldesk1','sol@naver.com',40)")
cur.execute("insert into userTable values('sol2','soldesk2','sol@naver.com',400)")
cur.execute("insert into userTable values('sol3','soldesk3','sol@naver.com',4000)")

id = cur.lastrowid # 튜플의 수
print(id)

# 데이터 삭제
cur.execute("delete from userTable where id='sol'")

# 데이터 조회
cur.execute("select * from userTable")

rows = cur.fetchall()
print(rows)

for r in rows:
    print('ST_name:{0}, ST_code:{1}, ST_MAJ:{2}, ST_GRA:{3}'.format(r[0],r[1],r[2],r[3]))


con.commit()
cur.close()
con.close()