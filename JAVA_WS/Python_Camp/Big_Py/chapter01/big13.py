from bs4 import BeautifulSoup
import urllib.request as req
import sys
import io

sys.stdout = io.TextIOWrapper(sys.stdout.detach(), encoding = 'utf-8')
sys.stderr = io.TextIOWrapper(sys.stderr.detach(), encoding = 'utf-8')

# 주식 요청 url
url = "http://finance.naver.com/sise/"

# 요청
res = req.urlopen(url).read().decode('euc-kr')
# print('res: ',res)
soup = BeautifulSoup(res, "html.parser")
# print(soup)

top = soup.select("#siselist_tab_0 > tr")

i = 0
print('오늘의 최고 상한가 종목')
for e in (top):
    if e.find("a") is not None:
        print(i, e.select_one(".title").string)
        i+=1
print("------------------------------------------")