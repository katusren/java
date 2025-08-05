## 변수 선언 부분
inStr, outStr = "",""
ch = ""
count, i = 0,0 

# 메인 코드
inStr=input("문자열을 입력하세요 : ")
count=len(inStr)

for i in range(0,count):
    ch=inStr[i] #SolDesk
    if(ord(ch) >= ord("A") and ord(ch)<=ord("Z")): #문자가 대문자면
        newCh=ch.lower()
    elif(ord(ch) >= ord("a") and ord(ch)<=ord("z")):
        newCh=ch.upper()
    else:
        newCh=ch
    outStr += newCh

print(outStr)
