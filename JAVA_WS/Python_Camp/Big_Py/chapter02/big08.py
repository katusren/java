from selenium import webdriver
from selenium.webdriver.chrome.options import Options
from selenium.webdriver.chrome.service import Service

# ChromeOptions 객체 생성
chrome_options = Options() # 헤드 정보 / 창 크기 제어
s = Service('C:/chromedriver/chromedriver.exe')

driver = webdriver.Chrome(service= s, options= chrome_options)

driver.get('https://google.com')
driver.save_screenshot('C:/Users/soldesk/Downloads/JAVA/Py_Scrap/img/Website1.png')

driver.get('https://daum.net')
driver.save_screenshot('C:/Users/soldesk/Downloads/JAVA/Py_Scrap/img/Website2.png')

driver.quit()

print("스크린샷 성공")