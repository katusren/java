# 변수
i,k,heartNum=0,0,0
numStr, ch, heartStr="","",""

# 메인
numStr = input("숫자를 입력하세요: ")
print("")

i=0
ch=numStr[i] # 하나씩 읽어오기

while True:
    heartNum=int(ch) # 숫자로 형변환    
    
    heartStr=""
    for k in range(0,heartNum+1):
        heartStr+="\u2665"
    print(heartStr)
    
    i+=1
    if(i>len(numStr)-1):
        break
    ch=numStr[i]