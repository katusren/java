import urllib.request as req
import os.path, random
import simplejson as json

#URL 요청
url="https://api.github.com/repositories"

#경로와 파일명
savename="C:/Users/soldesk/Downloads/JAVA/data/repo.json"

#예외처리
if not os.path.exists(url):
    req.urlretrieve(url, savename)
    
# 객체를 역직렬화(load)
item = json.load(open(savename,'r',encoding='utf-8'))
print(type(item))

for i in item:
    print(i["full_name"]+"-"+i["owner"]["url"])

print("-"*20)

# 문자를 역직렬화(loads)
items = json.load(open(savename,'r',encoding='utf-8').read())
print('Type: ',type(items))

for it in items:
    print(it["full_name"]+"-"+it["owner"]["url"])