# 클래스
class Car:
    # 멤버변수
    speed = 0

    
    def upSpeed(self,value):
        self.speed+=value
    def downSpeed(self,value):
        self.speed-=value
        
# 상속
class Sedan(Car):
    seatNum=0
    
    def getSeatNum(self):
        return self.seatNum
    
class Truck(Car):
    capacity = 0
    
    def getCapacity(self):
        return self.capacity
    
# 메인
sedan1 = Sedan()
truck1 = Truck()

# 부모클래스 메서드 사용
sedan1.upSpeed(100)
truck1.upSpeed(80)

# 각 클래스의 멤버변수 사용
sedan1.seatNum=5
truck1.capacity=50

print("승용차의 현재 속도는 %d 이고, 좌석수는 %d 입니다. "%(sedan1.speed,sedan1.seatNum))
print("트럭의 현재 속도는 %d 이고 적재중량은 %d 입니다. "%(truck1.speed,truck1.capacity))