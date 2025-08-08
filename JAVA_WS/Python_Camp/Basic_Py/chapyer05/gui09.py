import os
from tkinter import *
from time import *

# 실제 작업 디렉토리 확인용()
print("현재 작업 디렉터리 : ", os.getcwd())

# 1. 만약 이미지가 현재 작업 경로와 같은 경로에 있다면
# fnameList = ["jeju1.gif", "jeju2.gif", "jeju3.gif", "jeju4.gif","jeju5.gif","jeju6.gif","jeju7.gif","jeju8.gif","jeju9.gif"]

# 2. 만약 이미지가 현재 작업 경로와 다른 경로에 있다면
# fnameList = ["C:/Users/soldesk/Pictures/resource/GIF/jeju1.gif", ...]

# 3. 현재 작업 위치를 기준으로 찾고자 하는 파일의 경로를 자동으로 검색하여 구성해줌
current_dir = os.path.dirname(os.path.abspath(__file__))
fnameList = [os.path.join(current_dir,f"jeju{i}.gif") for i in range(1,10)]
# print(fnameList)

# 이미지 목록 확인
for f in fnameList:
    if not os.path.exists(f):
        print("이미지 파일이 존재하지 않습니다")
        
photoList = [None]*9
num = 0

def clickNext():
    global num
    num += 1
    if num >= len(fnameList):
        num = 0
    photo = PhotoImage(file=fnameList[num])
    pLabel.configure(image = photo)
    pLabel.image = photo
    
def clickPrev():
    global num
    num -= 1
    if num < 0:
        num = len(fnameList) - 1
    photo = PhotoImage(file=fnameList[num])
    pLabel.configure(image = photo)
    pLabel.image = photo
    
def pageUp(event):
    clickNext()

def pageDown(event):
    clickPrev()
    
    
# 메인
window = Tk()
window.geometry("700x500")
window.title("디지털 앨범")

# 키보드 이벤트
window.bind("<Prior>",pageUp) # PgUp
window.bind("<Next>",pageDown) # PgDn

# 마우스 이벤트
btnPrev = Button(window, text="<<이전", command=clickPrev)
btnNext = Button(window, text="다음>>", command=clickNext)

# 첫 번째 이미지 적용
photo = PhotoImage(file=fnameList[num])
pLabel = Label(window,image=photo)

pLabel.place(x=15,y=50)
btnPrev.place(x=250,y=10)
btnNext.place(x=400,y=10)

window.mainloop()