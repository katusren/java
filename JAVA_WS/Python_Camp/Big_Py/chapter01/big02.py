import sys
import io
import urllib.request as dw

sys.stdout = io.TextIOWrapper(sys.stdout.detach(), encoding = 'utf-8')
sys.stderr = io.TextIOWrapper(sys.stderr.detach(), encoding = 'utf-8')

imgUrl = "https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyMDA3MTdfMTgw%2FMDAxNTk0OTYzOTUwOTYw.IKn6Jj8o-SoRTbZI3c9fWfqbRlXp8Kn6mm2mrUZj2Vcg.g-mWpamKt2jzpt0gw3B3jeC9z3ozWwsF3czu6h3XHK0g.PNG.ohj3437%2F2020-07-17_14%253B32%253B11_%25288%2529.png&type=sc960_832"
htmlUrl = "http://google.com"

f1 = dw.urlopen(imgUrl).read()
f2 = dw.urlopen(htmlUrl).read()

savePath1 = "C:/Users/soldesk/Downloads/JAVA/Py_Scrap/imgtest2.jpg"
savePath2 = "C:/Users/soldesk/Downloads/JAVA/Py_Scrap/index2.html"

# 방법1
# dw.urlretrieve(imgUrl,savePath1)
# dw.urlretrieve(imgUrl,savePath2)

# 방법2
saveFile1 = open(savePath1,'wb')
saveFile1.write(f1)
saveFile1.close()

# 방법3
with open(savePath2, 'wb') as saveFile2:
    saveFile2.write(f2)
    
print("Scrap 완료")