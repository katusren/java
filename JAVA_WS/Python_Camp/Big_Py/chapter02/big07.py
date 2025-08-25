from selenium import webdriver # pip install selenium
from selenium.webdriver.chrome.service import Service
from selenium.webdriver.chrome.options import Options
from selenium.webdriver.common.by import By
import time
import os
import re

# Chrome WebDriver 경로 설정
chrome_driver_path = "C:/chromedriver/chromedriver.exe"
# print('드라이버 로드 완료')

# Selenium WebDriver 설정
chrome_options = Options()
chrome_options.add_argument("--headless") # 브라우저 창을 띄우지 않음(백그라운드)
chrome_options.add_argument("--disable-gpu")
chrome_options.add_argument("--no-sandbox")

# WebDriver 실행
service = Service(executable_path=chrome_driver_path)
driver = webdriver.Chrome(service=service, options=chrome_options)

try:
    # 영화 검색 페이지 열기 (예: "말할 수 없는 비밀")
    search_query = "말할 수 없는 비밀 영화"
    search_url = f"https://search.naver.com/search.naver?query={search_query}"
    driver.get(search_url)
    
    # 페이지 로딩 대기
    time.sleep(3)
    
    # 영화 제목 가져오기
    try:
        title_element = driver.find_element(By.CLASS_NAME, "title_area")
        title = title_element.text.strip()
    except:
        title = "제목을 찾을 수 없음"
    
    # 영화 평점 가져오기
    try:
        score_element = driver.find_element(By.CLASS_NAME, "score_area .num")
        score = score_element.text.strip()
    except:
        score = "평점을 찾을 수 없음"
    
    # 결과 출력
    print(f"영화 제목: {title}")
    print(f"평점: {score}")
    
    # 특수문자 제거하여 파일명 생성
    filename = re.sub(r'[^a-zA-Z0-9가-힣]', '', title)
    
    # 평점을 파일로 저장
    file_path = os.path.join(os.getcwd(), f"{filename}.txt")
    with open(file_path, "w", encoding="utf-8") as file:
        file.write(score)

    print(f"파일 저장 완료: {file_path}")
    
finally:
    driver.quit() # WebDriver 종료