from selenium import webdriver
from selenium.webdriver.chrome.options import Options
from selenium.webdriver.chrome.service import Service
import time

# ChromeOptions 객체 생성
chrome_options = Options() # 헤드 정보 / 창 크기 제어
s = Service('C:/chromedriver/chromedriver.exe')

driver = webdriver.Chrome(service= s, options= chrome_options)

driver.set_window_size(1920,1080) # 화면크기
driver.get('https://google.com')
time.sleep(3) # 대기
driver.save_screenshot('C:/Users/soldesk/Downloads/JAVA/Py_Scrap/img/Website1.png')

driver.set_window_size(1920,1080) # 화면크기
driver.get('https://daum.net')
time.sleep(3) # 대기
driver.save_screenshot('C:/Users/soldesk/Downloads/JAVA/Py_Scrap/img/Website2.png')

driver.quit()

print("스크린샷 성공")