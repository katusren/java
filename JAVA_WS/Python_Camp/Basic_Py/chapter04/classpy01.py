# 클래스
class Car:
    # 멤버변수
    color = ""
    speed = 0
    count = 0
    
    # 생성자
    def __init__(self):
        Car.count+=1 # static
        self.speed=0
        
# 메인
#Car myCar1 = new Car();
myCar1 = Car()
myCar1.speed = 60

myCar2 = Car()
myCar2.speed = 90

myCar3 = Car()
myCar3.speed = 30


print("자동차 1의 속도는 %s, 생성된 수는 %d"%(myCar1.speed,Car.count))

print("자동차 2의 속도는 %s, 생성된 수는 %d"%(myCar2.speed,Car.count))

print("자동차 3의 속도는 %s, 생성된 수는 %d"%(myCar3.speed,Car.count))