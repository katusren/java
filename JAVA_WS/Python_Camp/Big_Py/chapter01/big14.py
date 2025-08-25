from bs4 import BeautifulSoup
import urllib.request as req
import urllib.parse as rep
import errno #파일 또는 디렉토리
import os

# HTML을 가져오는 기본 설정
opener = req.build_opener()
opener.addheaders = [('User-agent','Mozilla/5.0')]
req.install_opener(opener)

# 검색어와 URL 설정
base = "https://search.naver.com/search.naver?where=image&sm=tab_jum&query="
quote = rep.quote_plus("사모예드")
url = base+quote

res = req.urlopen(url)
savePath = "C:/Users/soldesk/Downloads/JAVA/Py_Scrap/img/"

# 디렉토리 생성
try:
    if not os.path.isdir(savePath):
        os.makedirs(os.path.join(savePath))
except OSError as e:
    if e.errno != errno.EEXIST:
        print("Failed to create directory!!")
        raise
    
soup = BeautifulSoup(res,"html.parser")

# <img> 태그에서 이미지 추출
img_list = soup.find_all("img")

for i, img in enumerate(img_list,1):
    img_url = img['src']
    fullfilename = os.path.join(savePath, str(i)+ '.jpg')
    req.urlretrieve(img_url,fullfilename)
    
print('다운로드 완료')