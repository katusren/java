# 함수
def para2_func(v1,v2):
    result = 0
    result = v1+v2
    return result

def para3_func(v1,v2,v3):
    result = 0
    result = v1+v2+v3
    return result  
#==============================
sum = 0

# 메인
sum = para2_func(10,20)
print("매개변수 2개 ==> %d"%sum)
sum=para3_func(10,20,30)
print("매개변수 3개 ==> %d"%sum)

#===============================

def func1():
    a=10 # 지역변수
    print("func()에서 a의 값 %d" % a)
    print("=============================")
def func2():
    global a #전역변수
    a=30
    print("func()에서 a의 값 %d" % a)
    print("=============================")
    
# 전역변수
a=20

# 메인

func1()
func2()