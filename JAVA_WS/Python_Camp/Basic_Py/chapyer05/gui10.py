from tkinter import *
import tkinter.messagebox
'''
def clickLeft(event):
    tkinter.messagebox.showinfo("마우스","왼쪽 마우스가 클릭됨")
    
# 메인
window=Tk()
window.bind("<Button-1>",clickLeft)
'''

def clickLeft(event):
    tkinter.messagebox.showinfo("마우스","사진에서 왼쪽 마우스가 클릭됨")
    
# 메인
window=Tk()
window.geometry("400x400")
photo = PhotoImage(file="C:/Users/soldesk/Pictures/resource/GIF/rabbit.gif")
label1 = Label(window,image=photo)
label1.bind("<Button>",clickLeft)

label1.pack(expand=1,anchor=CENTER)

window.mainloop()