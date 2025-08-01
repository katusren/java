i, sum = 0,0
snum, ednum, num = 0,0,0

snum = int(input("시작값 입력 : "))
ednum = int(input("끝값 입력 : "))
num = int(input("증가값 입력 : "))

for i in range(snum,ednum,num):
    sum += i
print("%d 에서 %d 까지 %d씩 증가한 값의 합 : %d" %(snum,ednum,num,sum))