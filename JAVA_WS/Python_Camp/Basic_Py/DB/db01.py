import sqlite3

# 연결후 데이터베이스 생성
con = sqlite3.connect("C:/Users/soldesk/Downloads/JAVA/JAVA_WS/Python_Camp/sqlite/soldesk.db")
cur = con.cursor()

# 데이터베이스에 테이블 생성
cur.execute("create table T_STU_INFO(ST_code char(32), ST_MAJ char(32), ST_GRA char(32), ST_PHO char(32))")

con.commit()
cur.close()
con.close()