import sqlite3


#변수
con, cur=None, None
data1, data2, data3, data4="","","",""
sql=""


# 연결후 데이터베이스 접속
con=sqlite3.connect("C:/Users/soldesk/Downloads/JAVA/JAVA_WS/Python_Camp/sqlite/soldesk.db")
cur=con.cursor()


ch=int(input("<입력>:1,  <출력>:2 를 입력하세요: "))

if ch==1:
    while(True):
        data1=input("사용자 ID ==> ")
        if data1=="":
            break
        data2=input("사용자 이름 ==> ")
        data3=input("사용자 이메일 ==> ")
        data4=input("사용자 출생연도 ==> ")
        sql="insert into userTable values(?,?,?,?)"
        cur.execute(sql, (data1,data2,data3,data4))
        
    con.commit()
    print("데이터 입력 완료")    
elif ch==2:
    cur.execute("select * from userTable")
    print("사용자ID   사용자이름     이메일       출생연도")
    print("--------------------------------------------------------")
    rows=cur.fetchall()
    if not rows:
        print("저장된 데이터가 없습니다.")
    else:
        for row in rows:
            data1=row[0] if len(row) >0 else ""
            data2=row[1] if len(row) >1 else ""
            data3=row[2] if len(row) >2 else ""
            data4=row[3] if len(row) >3 else ""
            print("%7s %12s  %15s %5s" % (data1,data2,data3,data4))
        
cur.close()
con.close()
