a=[23,12,36,63,19]

for i in enumerate(a):
    print(i)
    
print("")

for x in enumerate(a):
    print(x[0],x[1])
    
print("")

for index, value in enumerate(a):
    print(index,value)
print("")
print("-------------------------------------------")

if all(60>x for x in a): # 모두가 참이여야 함 AND 연산자
    print("YES")
else:
    print("NO")
    
print()

if any(60>x for x in a): # 하나라도 참이면 YES -> OR 연산자
    print("YES")
else:
    print("NO")