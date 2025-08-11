import sqlite3

# 연결후 데이터베이스 생성
con = sqlite3.connect("C:/Users/soldesk/Downloads/JAVA/JAVA_WS/Python_Camp/sqlite/soldesk.db")
cur = con.cursor()

# 데이터 삽입
cur.execute("select * from T_STU_INFO")

rows = cur.fetchall()
print(rows)

for r in rows:
    print('ST_name:{0}, ST_code:{1}, ST_MAJ:{2}, ST_GRA:{3}'.format(r[0],r[1],r[2],r[3]))

con.commit()
cur.close()
con.close()