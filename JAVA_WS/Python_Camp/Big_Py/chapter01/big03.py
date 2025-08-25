import sys
import io
import urllib.request # HTTP 요청을 보내고 응답을 받을 때
from urllib.parse import urlparse # URL을 파싱

sys.stdout = io.TextIOWrapper(sys.stdout.detach(), encoding = 'utf-8')
sys.stderr = io.TextIOWrapper(sys.stderr.detach(), encoding = 'utf-8')

url="http://www.encar.com/"
mem=urllib.request.urlopen(url)

print(type(mem))

print("geturl : ",mem.geturl())
print("status : ",mem.status)

print("headers : ",mem.getheaders())
print("info :",mem.info()) # headers 정보를 행 단위로 보여줌
print("getcode :",mem.getcode()) # mem.stusts

# 서버가 사용하는 문자 인코딩 또는 utf-8
encoding = mem.info().get_content_charset() or 'utf-8'
print("read :",mem.read(500).decode(encoding)) # 500 바이크 스크랩핑
print(urlparse('http://www.encar.co.kr?test=test').query)