class Animal:
    # 멤버 변수
    name = ""
    age = 0
    
    # 메서드
    def setName(self,name):
        self.name = name
        
    def setAge(self,age):
        self.age = age
        
    def getInfo(self):
        return f"이름: {self.name}, 나이: {self.age}살"
    
# 상속
class Dog(Animal):
    breed = ""
    
    def setBreed(self,breed):
        self.breed = breed
        
    def bark(self):
        return "멍멍!"
    
    def getInfo(self):
        return super().getInfo()+f", 품종: {self.breed}"
    
class Bird(Animal):
    wingSpan = 0
    
    def setWingSpan(self, wingSpan):
        self.wingSpan = wingSpan
        
    def chirp(self):
        return "짹짹!"
    
    def getInfo(self):
        return super().getInfo()+f", 날개 길이: {self.wingSpan}"
    
# 메인
dog1 = Dog()
bird1 = Bird()

# 강아지 정보
dog1.setName("백설")
dog1.setAge(9)
dog1.setBreed("공주")

# 새 정보
bird1.setName("참새")
bird1.setAge(3)
bird1.setWingSpan(25)

# 출력
print(dog1.getInfo())
print(f"{dog1.name}이 말합니다: {dog1.bark()}")

print(bird1.getInfo())
print(f"{bird1.name}가 지저귑니다: {dog1.bark()}")