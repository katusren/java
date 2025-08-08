from tkinter import *
import tkinter.messagebox

# 함수
def myFun():
    tkinter.messagebox.showinfo("강아지 버튼,", "이쁜 강아지~~")
    
window = Tk()
photo = PhotoImage(file="C:/Users/soldesk/Pictures/resource/GIF/dog2.gif")
# button1 = Button(window,text="파이썬 종료", fg="red", command=quit)
button1 = Button(window, image=photo, command=myFun)

button1.pack()

window.mainloop()