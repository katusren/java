from abc import ABC, abstractmethod
import math

# 인터페이스 역할을 하는 추상 클래스
class Shape(ABC): # class abstract Shape{}
    # 추상 메서드
    def area(self):
        pass # 추상 메서드
    
    @abstractmethod
    def perimeter(self):
        pass
    
class Circle(Shape):
    
    def __init__(self, radius):
        self.radius=radius
        
    def area(self):
        return math.pi*self.radius**2
    
    def perimeter(self):
        return 2*math.pi*self.radius
    
class Rectangle(Shape):
    def __init__(self, width, height):
        self.width = width
        self.height = height
        
    def area(self):
        return self.width*self.height
    
    def perimeter(self):
        return 2*(self.width+self.height)
    
# 사용
circle = Circle(5)
rectangle = Rectangle(4,7)

print("원의 넓이: ",circle.area())
print("원의 둘레: ",circle.perimeter())

print("사각형의 넓이: ",rectangle.area())
print("사각형의 둘레: ",rectangle.perimeter())