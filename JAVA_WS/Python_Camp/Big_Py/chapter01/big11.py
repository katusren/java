from bs4 import BeautifulSoup
import sys
import io

sys.stdout = io.TextIOWrapper(sys.stdout.detach(), encoding = 'utf-8')
sys.stderr = io.TextIOWrapper(sys.stderr.detach(), encoding = 'utf-8')

fp=open("C:/Users/soldesk/Downloads/JAVA/Py_Scrap/cars.html", encoding="utf-8")
soup=BeautifulSoup(fp, "html.parser")
print(soup)

#일반 메서드
def car_func(select):
  print("car_func: ", soup.select_one(select).string)
  
car_func("#gr")
car_func("li#gr")
car_func("ul>#gr")
car_func("#cars #gr")
car_func("#cars > #gr")
car_func("li[id='gr']")  
print("-----------------------------------------")
#람다식(매개변수 : q) 
car_lambda=lambda q: print("car_func: ", soup.select_one(q).string)

car_lambda("#gr")
car_lambda("li#gr")
car_lambda("ul>#gr")
car_lambda("#cars #gr")
car_lambda("#cars > #gr")
car_lambda("li[id='gr']")

print("-----------------------------------------")
print("car_func", soup.select("li")[3].string)
print("car_func", soup.find_all("li")[3].string)