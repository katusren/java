import sqlite3

# 연결후 데이터베이스 생성
con = sqlite3.connect("C:/Users/soldesk/Downloads/JAVA/JAVA_WS/Python_Camp/sqlite/soldesk.db")
cur = con.cursor()

# 데이터베이스에 테이블 생성
cur.execute("insert into T_STU_INFO values('160321','SW','4','010-1111-2222')")
cur.execute("insert into T_STU_INFO values('160321','SW','4','010-1111-2222')")
cur.execute("insert into T_STU_INFO values('160321','SW','4','010-1111-2222')")

id = cur.lastrowid # 튜플의 수

print(id)
con.commit()
cur.close()
con.close()