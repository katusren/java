import sys
import io
import urllib.request # HTTP 요청을 보내고 응답을 받을 때
import urllib.parse
from urllib.parse import urlparse # URL을 파싱

sys.stdout = io.TextIOWrapper(sys.stdout.detach(), encoding = 'utf-8')
sys.stderr = io.TextIOWrapper(sys.stderr.detach(), encoding = 'utf-8')

API="https://api.ipify.org"

values={
    'format':'json'
}

print('before',values)
params = urllib.parse.urlencode(values) # html -> text
print('after', params)

# 요청
url = API + "?" + params
print("요청 url = ",url)

# 읽기
data=urllib.request.urlopen(url).read()
text=data.decode("utf-8")
print(text)