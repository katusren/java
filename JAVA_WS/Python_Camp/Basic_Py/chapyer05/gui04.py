from tkinter import *
import tkinter.messagebox

window = Tk()

# 함수
def myFun():
    if chk.get()==0:
        tkinter.messagebox.showinfo("","체크 버튼이 꺼졌어요")
    else:
        tkinter.messagebox.showinfo("","체크 버튼이 켜졌어요")
        
# main
chk = IntVar() # 정수값 반환 / # 실수형: DoubleVar() / # 문자열 : StringVar()
cb1 = Checkbutton(window,text="클릭하세요",variable=chk,command=myFun)

cb1.pack()

window.mainloop()